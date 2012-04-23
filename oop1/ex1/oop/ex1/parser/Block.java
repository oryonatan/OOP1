package oop.ex1.parser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

import oop.ex1.actions.Action;
import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.BlockException;
import oop.ex1.exceptions.PermissionsException;
import oop.ex1.filters.FileFilterBox;
import oop.ex1.filters.FolderFilter;


/** Execution block object , should be runnable from MyFileScript, instances
 * containing filters,actions,order type and comments are created by
 * the parser.
 * @author yonatan , yuli
 *
 */
public class Block {
	private FolderFilter folderFilter;
	private FileFilterBox filters;
	private ArrayList<Action> actions;
	private Comparator<File> order;
	private String[] comments;
	TreeSet<File> files ;
	private String path;


	/**Block Constructor
	 * @param filters filterBox of the filters
	 * @param actions list of actions
	 * @param order the order type
	 * @param comments list of comments on block
	 */
	public Block(String path,FileFilterBox filters, ArrayList<Action> actions,
			Comparator<File> order,String[] comments) {
		this.path = path;
		this.filters = filters;
		this.actions = actions;
		this.order =  order;
		this.comments = comments;
		this.folderFilter = new FolderFilter();
	}

	/**Runs the block on the given path
	 * @throws BadParamException
	 * @throws BlockException 
	 */
	public void run() throws BadParamException, BlockException {
		listAndFilterFilesOrdered();
		doActions();		
		printComments();
	}

	/**Prints the Block Comments
	 * 
	 */
	private void printComments() {
		for (String commentString : comments){
			System.out.println(commentString);
		}
	}

	/**Runs all the actions on the block
	 * @throws BadParamException
	 */
	private void doActions() throws BadParamException,BlockException {
		for (Action action:actions){
			try {
				action.Exec(files);
			} catch (IOException e) {
				throw new BlockException();
			} catch (PermissionsException e) {
				throw new BlockException();
			}
		}
	}

	/** Lists all the files in the subdirs and puts them in a TreeSet called files
	 * @param path the path to run the filters on.
	 * @throws BadParamException
	 */
	private void listAndFilterFilesOrdered() throws BadParamException {
		//Create TreeSet with order
		files = new TreeSet<File>(this.order);
		File sourceDir = new File(this.path);
		if (!sourceDir.isDirectory()) {
			throw new BadParamException();
		}
		recursiveDir(sourceDir, files);
	}

	/**Recursively lists all files in a directory , and filters them in according
	 * to the filters specified. The files will be put in the TreeSet called files.
	 * @param path the path to list in
	 * @param files TreeSet of files
	 */
	public void recursiveDir(File path, TreeSet<File> files) {
		//Add all files
		files.addAll(Arrays.asList(path.listFiles(filters)));
		//Recurse into the directories
		for (File folder : path.listFiles(folderFilter)) {
			recursiveDir(folder, files);
		}
	}

}
