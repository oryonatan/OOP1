import java.io.File;
import java.io.FileFilter;
import java.io.IOError;
import java.util.ArrayList;

import Filters.FileFilterBox;
import Filters.StartsWithFilter;;



public class FileLister {

	private static  ArrayList<File> files = new ArrayList<File>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File folder = new File("c:\\");
		FileFilterBox filterGen = new FileFilterBox();
		filterGen.addFilter(new StartsWithFilter("$"){
			{
				negate();
			}
		});
		for(File file :folder.listFiles(filterGen)){
			files.add(file);
		}
		System.out.println(files);
		// TODO Auto-generated method stub
	}



}
