import java.io.File;
import java.util.ArrayList;



public class MyFileScript {

	private static final int COMMANDS_FILE_LOCATION = 1;
	private static final int SOURCE_DIR = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File sourceDir = new File(args[SOURCE_DIR]);
		File commandsFile = new File(args[COMMANDS_FILE_LOCATION]);
		/*ArrayList<Block> blocks = new Parser.parse(sourceDir,commandsFile);
		 * 
		asd*/
	}

}
