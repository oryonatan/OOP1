package order;

import java.io.File;
import java.util.Comparator;

public class sizeComparator implements Comparator<File> {
	
	public int compare(File fstfile, File scndfile)
	{
		int sizeFstFile = ((int)fstfile.length());
		int sizeScndFile = ((int)scndfile.length());
		
		return sizeFstFile - sizeScndFile;
	}
	

}
