package Th_5;

public class SubBox extends Box {
	int weight;

	SubBox(int width, int height, int depth, int weight) {
		super(width, height, depth);
		this.weight = weight;
	}

	public int volumeBox() {
		return width * height * depth;
	}

}
