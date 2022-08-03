package marsrovers;

import org.junit.Test;
import static org.junit.Assert.*;

public class BearingTest {

	@Test
	public void valueOfChar() {
		assertEquals(Bearing.N, Bearing.valueOf("N"));
		assertEquals(Bearing.S, Bearing.valueOf("S"));
		assertEquals(Bearing.W, Bearing.valueOf("W"));
		assertEquals(Bearing.E, Bearing.valueOf("E"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void badValueOfChar() {
		Bearing.valueOf("G");
	}
	
	@Test
	public void leftAndRightOfN() {
		assertEquals(Bearing.W, Bearing.N.left());
		assertEquals(Bearing.E, Bearing.N.right());
	}
	
	@Test
	public void leftAndRightOfE() {
		assertEquals(Bearing.N, Bearing.E.left());
		assertEquals(Bearing.S, Bearing.E.right());
	}
	
	@Test
	public void leftAndRightOfS() {
		assertEquals(Bearing.E, Bearing.S.left());
		assertEquals(Bearing.W, Bearing.S.right());
	}
	
	@Test
	public void leftAndRightOfW() {
		assertEquals(Bearing.S, Bearing.W.left());
		assertEquals(Bearing.N, Bearing.W.right());
	}
	
	@Test
	public void incrementValues() {
		assertEquals(0, Bearing.N.x);
		assertEquals(1, Bearing.N.y);
		
		assertEquals(1, Bearing.E.x);
		assertEquals(0, Bearing.E.y);
		
		assertEquals(0, Bearing.S.x);
		assertEquals(-1, Bearing.S.y);
		
		assertEquals(-1, Bearing.W.x);
		assertEquals(0, Bearing.W.y);
	}
	
}
