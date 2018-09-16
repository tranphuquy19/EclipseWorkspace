package TH_4;

public class Box {
	int width, height, depth;

	Box() {
		width = 0;
		height = 0;
		depth = 0;
	}

	Box(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	Box(int a) {
		width = height = depth = a;
	}

	Box(Box obj) {
		width = obj.width;
		height = obj.height;
		depth = obj.depth;
	}

	public int volumeBox() {
		return width * height * depth;
	}
}
