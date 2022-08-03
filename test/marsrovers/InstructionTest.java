package marsrovers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionTest {

	Rover rover;
	
	@Before
	public void start() {
		rover = new Rover(new Plateau(5, 5), 1, 2, Bearing.N);
	}
	
	@After
	public void end() {
		rover = null;
	}
	
	@Test
	public void executeInstructions() throws Exception {
		assertEquals("1 2 W", Instruction.L.execute(rover).toString());
		assertEquals("1 2 N", Instruction.R.execute(rover).toString());
		assertEquals("1 3 N", Instruction.M.execute(rover).toString());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void executeBadInstructions() throws Exception {
		rover = new Rover(new Plateau(2, 2), 1, 2, Bearing.N);
		Instruction.M.execute(rover);
	}
	
	@Test
	public void charParser() throws Exception {
		assertEquals(Instruction.L, Instruction.valueOf('L'));
	}
}
