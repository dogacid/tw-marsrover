package marsrovers;

public class Rover {

	private int x;
	private int y;
	private Bearing bearing;
	private final Plateau plateau;
	private Instruction[] instructions;

	public Rover(Plateau plateau, int x, int y, Bearing bearing) {
		this.plateau = plateau;
		this.bearing = bearing;
		this.instructions = new Instruction[0];
		moveTo(x, y);
	}

	private void moveTo(int x, int y) {
		if (plateau.coordinateExists(x, y)) {
			this.x = x;
			this.y = y;
		} else {
			throw new IndexOutOfBoundsException("Rover cannot move to co-ordinates(" + x + ", " + y + ") bearing " + bearing + ", will fall off the Plateau");
		}
	}

	public Rover bearLeft() {
		this.bearing = bearing.left();
		return this;
	}

	public Rover bearRight() {
		this.bearing = bearing.right();
		return this;
	}

	public Rover moveForward() {
		moveTo(this.x + this.bearing.x, this.y + this.bearing.y);
		return this;
	}
	
	public Rover execute() throws Exception {
		for (Instruction instruction : instructions) {
			instruction.execute(this);
		}
		return this;
	}
	
	public void upload(Instruction[] instructions) {
		this.instructions = instructions;
	}
	
	@Override
	public String toString() {
		return x + " " + y + " " + bearing;
	}

}
