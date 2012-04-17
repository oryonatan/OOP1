package oop.ex1.orders;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;

public class absComparator implements Comparator<File>{
	public int compare(File fstfile, File scndfile) 
	{
		
		String nameFstFile = null;
		String nameScndFile = null;
		try {
			nameFstFile = fstfile.getCanonicalPath();
			nameScndFile = scndfile.getCanonicalPath();
		} catch (IOException e) {
			// !!!
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nameFstFile.compareTo(nameScndFile);
	}

}

