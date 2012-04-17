package oop.ex1.filescript;

import java.io.IOException;
import java.util.ArrayList;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.parser.Block;
import oop.ex1.parser.Parser;



public class MyFileScript {

	private static final String ERROR = "ERROR";
	private static final int COMMANDS_FILE_LOCATION = 1;
	private static final int SOURCE_DIR = 0;

	/**
	 * @param args
	 * @throws IOException
	 * @throws BadParamException
	 */
	public static void main(String[] args) {
		try {
			ArrayList<Block> blocks = Parser.parse(args[SOURCE_DIR],
					args[COMMANDS_FILE_LOCATION]);
			for (Block block : blocks) {
				block.run();
			}
		} catch (Exception e) {
			System.err.println(ERROR);
			System.exit(-1);
		}
	}
}