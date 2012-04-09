package Order;

import java.io.File;
import java.util.Comparator;

public class fileComparator implements Comparator<File>{

	public int compare(File fstfile, File scndfile)
	{
		String nameFstFile = ((File)fstfile).getName();
		String nameScndFile = ((File)scndfile).getName();
		
		return nameFstFile.compareTo(nameScndFile);
	}
	

}

