package marsrovers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MissionParserTest {

	MissionParser parser;
	
	@Before
	public void start() {
		parser = new MissionParser();
	}
	
	@After
	public void end() {
		parser = null;
	}
	
	@Test
	public void parsePlateau() {
		Plateau plateau = parser.parsePlateau("5 5");
		assertTrue(plateau.coordinateExists(5, 5));
		
		plateau = parser.parsePlateau("4 4");
		assertFalse(plateau.coordinateExists(5, 5));
		
		plateau = parser.parsePlateau("2 4");
		assertTrue(plateau.coordinateExists(0, 1));
	}
	
	@Test(expected = NumberFormatException.class)
	public void NonNumber1ParsePlateau() {
		parser.parsePlateau("a 5");
	}
	
	@Test(expected = NumberFormatException.class)
	public void NonNumber2ParsePlateau() {
		parser.parsePlateau("5 a");
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void MissingDataParsePlateau() {
		parser.parsePlateau("5 ");
	}
	
	@Test
	public void parseRover() {
		Rover rover = parser.parseRover(new Plateau(5, 5), "1 2 N");
		assertEquals("1 2 N", rover.toString());
	}
	
	@Test(expected = NumberFormatException.class)
	public void NonNumberParse1Rover() {
		parser.parseRover(new Plateau(5, 5), "a 5 N");
	}
	
	@Test(expected = NumberFormatException.class)
	public void NonNumberParse2Rover() {
		parser.parseRover(new Plateau(5, 5), "5 a N");
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void MissingDataParseRover() {
		parser.parseRover(new Plateau(5, 5), "5 5");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void BadDataParseRover() {
		parser.parseRover(new Plateau(5, 5), "5 5 T");
	}
	
	@Test
	public void parseRoverInstructions() {
		assertArrayEquals(
				new Instruction[]{ Instruction.L, Instruction.M, Instruction.R, Instruction.L, Instruction.L, Instruction.M },
				parser.parseInstructions("LMRLLM"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void badInstruction() {
		parser.parseInstructions("LMYLLM");
	}
}
