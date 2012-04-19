package oop.ex1.orders;

import java.io.File;

public class sizeComparator extends absComparator{
	
	public int compare(File fstfile, File scndfile)
	{
		Long sizeFstFile = fstfile.length();
		Long sizeScndFile = scndfile.length();
		
		if (sizeFstFile.compareTo(sizeScndFile) == 0)
		{
			return super.compare(fstfile, scndfile);
		}
		return sizeFstFile.compareTo(sizeScndFile);
	}
	

}
