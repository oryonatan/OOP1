package order;

import java.io.File;
import java.util.Comparator;

public class sizeComparator extends absComparator{
	
	public int compare(File fstfile, File scndfile)
	{
		int sizeFstFile = ((int)fstfile.length());
		int sizeScndFile = ((int)scndfile.length());
		
		if (sizeFstFile - sizeScndFile == 0)
		{
			super.compare(fstfile, scndfile);
		}
		return sizeFstFile - sizeScndFile;
	}
	

}
