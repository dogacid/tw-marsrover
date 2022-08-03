

import java.io.FileReader;

import marsrovers.Mission;

public class App {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("Usage: java App <mission text file>");
		} else {
			new Mission(new FileReader(args[0])).launch(System.out);
		}
	}
	
}
