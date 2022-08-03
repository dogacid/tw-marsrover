package marsrovers;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Mission {
	
	private final List<Rover> rovers;

	public Mission(Reader reader) throws IOException {
		rovers = new ArrayList<Rover>();
		
		LineNumberReader lineReader = new LineNumberReader(reader);
		MissionParser parser = new MissionParser();
		
		String line = lineReader.readLine();
		Plateau plateau = parser.parsePlateau(line);
		
		for (line = lineReader.readLine(); line != null; line = lineReader.readLine()) {
			Rover rover = parser.parseRover(plateau, line);
			rover.upload(parser.parseInstructions(lineReader.readLine()));
			rovers.add(rover);
		}
		
		lineReader.close();
	}

	public void launch(PrintStream printStream) throws Exception {
		for (Rover rover : rovers) {
			printStream.println(rover.execute().toString());
		}
	}

}
