package marsrovers;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoverTest {
	
	Plateau plateau;
	Rover rover;
	
	@Before
	public void start() {
		plateau = new Plateau(5, 5);
		rover = new Rover(plateau, 1, 2, Bearing.N);
	}
	
	@After
	public void end() {
		rover = null;
		plateau = null;
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void badLandingTheRoverOnThePlateau() {
		new Rover(plateau, 6, 6, Bearing.N);
	}

	@Test
	public void verifyToString() {
		assertEquals("1 2 N", rover.toString());
	}
	
	@Test
	public void left() {
		assertEquals("1 2 W", rover.bearLeft().toString());
	}
	
	@Test
	public void right() {
		assertEquals("1 2 E", rover.bearRight().toString());
	}
	
	@Test
	public void moveNorth() {
		assertEquals("1 3 N", rover.moveForward().toString());
	}
	
	@Test
	public void moveEast() {
		assertEquals("2 2 E", rover.bearRight().moveForward().toString());
	}
	
	@Test
	public void moveSouth() {
		assertEquals("1 1 S", rover.bearRight().bearRight().moveForward().toString());
	}
	
	@Test
	public void moveWest() {
		assertEquals("0 2 W", rover.bearLeft().moveForward().toString());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void moveOffThePlateauGoingNorth() {
		rover.moveForward().moveForward().moveForward().moveForward();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void moveOffThePlateauGoingSouth() {
		rover.bearLeft().bearLeft().moveForward().moveForward().moveForward();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void moveOffThePlateauGoingEast() {
		rover.bearRight().moveForward().moveForward().moveForward().moveForward().moveForward();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void moveOffThePlateauGoingWest() {
		rover.bearLeft().moveForward().moveForward();
	}
	
	@Test
	public void executeWithNoInstructions() throws Exception {
		assertEquals("1 2 N", rover.execute().toString());
	}
	
	@Test
	public void uploadAndExecuteInstructions() throws Exception {
		rover.upload(new Instruction[]{Instruction.M});
		assertEquals("1 3 N", rover.execute().toString());
	}
		
	@Test
	public void emulateInstructionsFromCustomerTest1() {
		rover
			.bearLeft().moveForward()
			.bearLeft().moveForward()
			.bearLeft().moveForward()
			.bearLeft().moveForward()
			.moveForward();
		
		assertEquals("1 3 N", rover.toString());
	}
	
	@Test
	public void emulateInstructionsFromCustomerTest2() {
		rover = new Rover(plateau, 3, 3, Bearing.E);
		rover
			.moveForward().moveForward()
			.bearRight().moveForward()
			.moveForward().bearRight()
			.moveForward().bearRight()
			.bearRight().moveForward();
		
		assertEquals("5 1 E", rover.toString());
	}

}
