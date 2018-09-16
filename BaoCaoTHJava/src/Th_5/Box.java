package Th_5;

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

	public int volumeBox() {
		return width * height * depth;
	}
}
