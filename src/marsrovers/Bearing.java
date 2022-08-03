package marsrovers;

public enum Bearing {

	N(0, 1), E(1, 0), S(0, -1), W(-1, 0);
	
	final int x;
	final int y;

	private Bearing(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Bearing left() {
		int index = ordinal() - 1;
		Bearing[] bearings = Bearing.values();
		return bearings[(index == -1 ? (bearings.length-1) : index)];
	}
	
	Bearing right() {
		int index = ordinal() + 1;
		Bearing[] bearings = Bearing.values();
		return bearings[(index == bearings.length ?  0 : index)];
	}
		
}
