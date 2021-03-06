#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef vector<vector<int>> dsk;

// BFS t�m du?ng di t? s d?n t
// Tr? v? danh s�ch c�c d?nh tr�n du?ng di
vector<int> find_path(int s, int t, const dsk &ke) {
    int n = ke.size();
    vector<int> trace(n, -1);
    queue<int> q;
    q.push(s);
    trace[s] = s;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (int v: ke[u]) if (trace[v] < 0) {
            q.push(v);
            trace[v] = u;
        }
    }

    vector<int> path;
    int u = t;
    while (u != s) {
        path.push_back(u);
        u = trace[u];
    }
    path.push_back(s);
    for (int i=0, j=path.size()-1; i<j; i++, j--) swap(path[i], path[j]);
    return path;
}

int bfs(int s, const vector<int> &pos, const dsk &ke, vector<bool> &visited) {
    queue<int> q;
    q.push(s);
    visited[s] = true;
    int r = -1;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (int v: ke[u]) if (!visited[v] && pos[v]<0) {
            q.push(v);
            visited[v] = true;
        } else r = max(r, pos[v]);
    }
    return r;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0);
    int n, m, s, t;
    cin >> n >> m >> s >> t;
    s--, t--;
    dsk ke(n);
    for (int i=0; i<m; i++) {
        int u, v;
        cin >> u >> v;
        ke[u-1].push_back(v-1);
    }

    vector<int> path = find_path(s, t, ke);

    // Luu l?i v? tr� c?a d?nh tr�n du?ng di
    vector<int> pos(n, -1);
    for (int i=0; i<(int)path.size(); i++) {
        pos[path[i]] = i;
    }

    vector<bool> visited(n, false);
    int r = -1, res = 0;
    for (int u: path) {
        // N?u t? c�c d?nh tru?c u c� th? di t?i m?t
        // d?nh sau u th� u kh�ng xung y?u, ngu?c l?i
        // u l� n�t xung y?u.
        if (u != s && u != t && r <= pos[u]) res++;

        r = max(r, bfs(u, pos, ke, visited));
    }
    cout << res;
    return 0;
}
