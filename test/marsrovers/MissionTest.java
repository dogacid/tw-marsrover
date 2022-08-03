package marsrovers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Test;

import static org.junit.Assert.*;


public class MissionTest {
	
	@Test
	public void thoughtWorksCustomerTest() throws Exception {
		Mission mission = new Mission(
			new StringReader(
				"5 5\n" +
				"1 2 N\n" +
				"LMLMLMLMM\n" +
				"3 3 E\n" +
				"MMRMMRMRRM")
		);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		mission.launch(new PrintStream(baos));
		
		assertEquals("1 3 N\n5 1 E\n", baos.toString());
	}
	
}
