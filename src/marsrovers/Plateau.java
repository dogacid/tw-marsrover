package marsrovers;

public class Plateau {

	private final int upperX;
	private final int upperY;

	public Plateau(int upperX, int upperY) {
		if (upperX < 1 || upperY < 1)
			throw new IndexOutOfBoundsException("x or y must be greater than zero");
		
		this.upperX = upperX;
		this.upperY = upperY;
	}

	public boolean coordinateExists(int x, int y) {
		return x >= 0 && x <= upperX && y >= 0 && y <= upperY;
	}

}
