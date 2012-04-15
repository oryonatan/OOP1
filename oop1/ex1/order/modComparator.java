package Order;

import java.io.File;
import java.util.Comparator;

public class modComparator implements Comparator<File> {
	
	public int compare(File fstfile, File scndfile)
	{
		int modFstFile = ((int)fstfile.lastModified());
		int modScndFile = ((int)scndfile.lastModified());
		
		return modFstFile - modScndFile;
	}
	

}
