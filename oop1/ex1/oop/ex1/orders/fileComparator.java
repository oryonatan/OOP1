package oop.ex1.orders;


import java.io.File;

public class fileComparator extends absComparator{

	public int compare(File fstfile, File scndfile)
	{
		String nameFstFile = ((File)fstfile).getName();
		String nameScndFile = ((File)scndfile).getName();
		if (nameFstFile.compareTo(nameScndFile) == 0){
			return super.compare(fstfile, scndfile);
		}
		return nameFstFile.compareTo(nameScndFile);
	}
	

}

