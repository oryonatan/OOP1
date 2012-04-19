package oop.ex1.filescript;
import java.util.ArrayList;
import oop.ex1.parser.Block;
import oop.ex1.parser.Parser;

/**
 * Runner for the program
 * 
 * @author Yuli Shapiro
 * @author Yonathan Oren
 * 
 */
public class MyFileScript {

	private static final String ERROR = "ERROR";
	private static final int COMMANDS_FILE_LOCATION = 1;
	private static final int SOURCE_DIR = 0;

	/**
	 * Main function , runs the program,
	 * 
	 * @param arg
	 *            first argument is the directory to work on , the second is the
	 *            command file
	 */
	public static void main(String[] args) {
		try {
			// Create blocks and run them
			ArrayList<Block> blocks = Parser.parse(args[SOURCE_DIR],args[COMMANDS_FILE_LOCATION]);
			for (Block block : blocks) {
				block.run();
			}
		} catch (Exception e) {
			quit();
		}
	}

	/**
	 * Leaves the program with ERROR to STDERR
	 * 
	 */
	public static void quit() {
		System.err.println(ERROR);
		System.exit(-1);
	}
}