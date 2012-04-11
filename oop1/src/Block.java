import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

import Actions.Action;
import Exceptions.BadParamException;
import Exceptions.PermissionsException;
import Filters.FileFilterBox;
import Filters.FolderFilter;

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
	private ArrayList<String> comments;
	TreeSet<File> files ;

/*	public static void main(String[] args) throws BadParamException {
		FileFilterBox fBox = new FileFilterBox();
		fBox.addFilter(new AfterFilter("01/01/1995"));
		Block b = new Block(fBox, null,new modComparator());
		b.run("C:\\Octave\\3.2.4_gcc-4.4.0\\bin");
	}*/

	/**Block Constructor
	 * @param filters filterBox of the filters
	 * @param actions list of actions
	 * @param order the order type
	 * @param comments list of comments on block
	 */
	public Block(FileFilterBox filters, ArrayList<Action> actions,
			Comparator<File> order,ArrayList<String> comments) {
		this.filters = filters;
		this.actions = actions;
		this.order =  order;
		this.comments = comments;
		this.folderFilter = new FolderFilter();
	}

	/**Runs the block on the given path
	 * @param path the path to run the block on.
	 * @throws BadParamException
	 */
	public void run(String path) throws BadParamException {
		listAndFilterFilesOrdered(path);
		doActions();		
		printComments();
	}

	/**Prints the Block Comments
	 * 
	 */
	private void printComments() {
		for (String commeString : comments){
			System.out.println(commeString);
		}
	}

	/**Runs all the actions on the block
	 * @throws BadParamException
	 */
	private void doActions() throws BadParamException {
		for (Action action:actions){
			try {
				action.Exec(files);
			} catch (IOException e) {
				throw new BadParamException();
			} catch (PermissionsException e) {
				throw new BadParamException();
			}
		}
	}

	/** Lists all the files in the subdirs and puts them in a TreeSet called files
	 * @param path the path to run the filters on.
	 * @throws BadParamException
	 */
	private void listAndFilterFilesOrdered(String path) throws BadParamException {
		//Create TreeSet with order
		files = new TreeSet<File>(this.order);
		File sourceDir = new File(path);
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
