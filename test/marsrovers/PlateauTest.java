package marsrovers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlateauTest {
	
	Plateau plateau;
	
	@Before
	public void start() {
		plateau = new Plateau(5, 5);
	}
	
	@After
	public void end() {
		plateau = null;
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void badPlateauOnX() {
		new Plateau(-1, 5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void badPlateauOnY() {
		new Plateau(1, -5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void badPlateau() {
		new Plateau(0, 0);
	}
	
	@Test
	public void coordinatesExist() {
		for (int x = 0; x <= 5; x++) {
			for (int y = 0; y <= 5; y++) {
				assertTrue(plateau.coordinateExists(x, y));
			}
		}
		assertFalse(plateau.coordinateExists(6, 5));
		assertFalse(plateau.coordinateExists(6, 6));
		assertFalse(plateau.coordinateExists(5, 6));
		
		assertFalse(plateau.coordinateExists(-1, 0));
		assertFalse(plateau.coordinateExists(-1, -1));
		assertFalse(plateau.coordinateExists(0, -1));
	}
	
}
