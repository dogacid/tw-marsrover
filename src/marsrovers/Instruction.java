package marsrovers;

import java.lang.reflect.InvocationTargetException;


public enum Instruction {

	L("bearLeft"), R("bearRight"), M("moveForward");
	
	private final String roverMethod;

	private Instruction(String roverMethod) {
		this.roverMethod = roverMethod;
	}
	
	Rover execute(Rover rover) throws Exception {
		try {
			Rover.class.getMethod(this.roverMethod, new Class[0]).invoke(rover);
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof RuntimeException) {
				throw (RuntimeException) e.getTargetException();
			}
		}
		return rover;
	}

	static Instruction valueOf(char abbrev) {
		for (Instruction instruction : values()) {
			if (instruction.name().charAt(0) == abbrev)
				return instruction;
		}
		throw new IllegalArgumentException("'" + abbrev + "' not supported Instruction");
	}
}
