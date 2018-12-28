#include <bits/stdc++.h>

using namespace std;

const int N = (int) (5e2 + 2);
const long long INF = (long long) (1e18);

struct MaxMatching {
    int n, g[N][N], matchX[N], matchY[N], trace[N];
    queue <int> q;
    MaxMatching(int n = 0) : n(n) {
        for (int i = 1; i <= n; ++i) {
            matchX[i] = matchY[i] = trace[i] = 0;
            for (int j = 1; j <= n; ++j) g[i][j] = 0;
        }
    }
    void addEdge(int u, int v) { g[u][v] = 1; }
    void initBFS() {
        while (!q.empty()) q.pop();
        memset(trace, 0, sizeof trace);
        for (int i = 1; i <= n; ++i) if (matchX[i] == 0) q.push(i);
    }
    int bfs() {
        while (!q.empty()) {
            int u = q.front(); q.pop();
            for (int v = 1; v <= n; ++v) if (g[u][v] && !trace[v]) {
                trace[v] = u;
                if (!matchY[v]) return v;
                q.push(matchY[v]);
            }
        }
        return 0;
    }
    void enlarge(int y) {
        while (y > 0) {
            int x = trace[y];
            int nxt = matchX[x];
            matchX[x] = y;
            matchY[y] = x;
            y = nxt;
        }
    }
    int maxMatch() {
        while (true) {
            initBFS();
            int y = bfs();
            if (y == 0) break;
            enlarge(y);
        }
        int ret = 0;
        for (int i = 1; i <= n; ++i) if (matchX[i] != 0) ret++;
        return ret;
    }
} g;

struct MaxMatchingMinCost {
    int n, start, finish, matchX[N], matchY[N], trace[N], argmin[N];
    long long c[N][N], d[N], fx[N], fy[N];
    queue <int> q;
    MaxMatchingMinCost(int n = 0) : n(n) {
        for (int i = 1; i <= n; ++i) {
            fy[i] = matchX[i] = matchY[i] = 0;
            for (int j = 1; j <= n; ++j) c[i][j] = INF;
        }
    }
    void addEdge(int i, int j, long long w) { c[i][j] = min(c[i][j], w); }
    long long getC(int i, int j) { return c[i][j] - fx[i] - fy[j]; }
    void initBFS() {
        while (!q.empty()) q.pop();
        q.push(start);
        memset(trace, 0, sizeof trace);
        for (int j = 1; j <= n; ++j) {
            d[j] = getC(start, j);
            argmin[j] = start;
        }
        finish = 0;
    }
    void bfs() {
        while (!q.empty()) {
            int i = q.front(); q.pop();
            for (int j = 1; j <= n; ++j) if (!trace[j]) {
                long long w = getC(i, j);
                if (!w) {
                    trace[j] = i;
                    if (!matchY[j]) {
                        finish = j;
                        return ;
                    }
                    q.push(matchY[j]);
                }
                if (d[j] > w) {
                    d[j] = w;
                    argmin[j] = i;
                }
            }
        }
    }
    void subx_addy() {
        long long delta = INF;
        for (int j = 1; j <= n; ++j)
            if (trace[j] == 0 && d[j] < delta) delta = d[j];
        fx[start] += delta;
        for (int j = 1; j <= n; ++j)
            if (trace[j]) {
                int i = matchY[j];
                fy[j] -= delta;
                fx[i] += delta;
            }
            else d[j] -= delta;

        for (int j = 1; j <= n; ++j)
            if (!trace[j] && !d[j]) {
                trace[j] = argmin[j];
                if (!matchY[j]) { finish = j; return ; }
                q.push(matchY[j]);
            }
    }
    void enlarge() {
        do {
            int i = trace[finish];
            int next = matchX[i];
            matchX[i] = finish;
            matchY[finish] = i;
            finish = next;
        } while (finish);
    }
    long long minCost() {
        for (int i = 1; i <= n; ++i) fx[i] = *min_element(c[i] + 1, c[i] + n + 1);
        for (int j = 1; j <= n; ++j) {
            fy[j] = c[1][j] - fx[1];
            for (int i = 1; i <= n; ++i) {
                fy[j] = min(fy[j], c[i][j] - fx[i]);
            }
        }
        for (int i = 1; i <= n; ++i) {
            start = i;
            initBFS();
            while (finish == 0) {
                bfs();
                if (!finish) subx_addy();
            }
            enlarge();
        }
        long long ret = 0;
        for (int i = 1; i <= n; ++i) ret += c[i][matchX[i]];
        return ret;
    }
} G;

int n, m;

int main() {
    freopen("BUILDROAD.INP", "r", stdin);
    freopen("BUILDROAD.OUT", "w", stdout);
    ios_base::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> m;
    g = MaxMatching(n); G = MaxMatchingMinCost(n);
    for (int i = 1; i <= m; ++i) {
        int u, v;
        long long w;
        cin >> u >> v >> w;
        g.addEdge(u, v); G.addEdge(u, v, w);
    }
    if (g.maxMatch() < n) cout << -1;
    else cout << G.minCost();
    return 0;
}
