package marsrovers;

public class MissionParser {

	Plateau parsePlateau(String line) {
		String[] coordinates = line.split(" ");
		return
			new Plateau(
				Integer.parseInt(coordinates[0]),
				Integer.parseInt(coordinates[1])
			);
	}

	public Rover parseRover(Plateau plateau, String line) {
		String[] roverAttributes = line.split(" ");
		return
			new Rover(
				plateau,
				Integer.parseInt(roverAttributes[0]),
				Integer.parseInt(roverAttributes[1]),
				Bearing.valueOf(roverAttributes[2])
			);
	}

	public Instruction[] parseInstructions(String line) {
		Instruction[] instructions = new Instruction[line.length()];
		char[] charInstructions = line.toCharArray();
		for (int i = 0 ; i < charInstructions.length; i++) {
			instructions[i] = Instruction.valueOf(charInstructions[i]);
		}
		return instructions;
	}
	
}
