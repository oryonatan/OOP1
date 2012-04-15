package filescript;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.BadParamException;

import parser.Block;
import parser.Parser;



public class MyFileScript {

	private static final int COMMANDS_FILE_LOCATION = 1;
	private static final int SOURCE_DIR = 0;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BadParamException 
	 */
	public static void main(String[] args) throws BadParamException, IOException {		
		ArrayList<Block> blocks = Parser.parse(args[SOURCE_DIR], args[COMMANDS_FILE_LOCATION]);
		for (Block block:blocks){
			block.run();
		}
	}

}
