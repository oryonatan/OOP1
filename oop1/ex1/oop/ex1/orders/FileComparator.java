package oop.ex1.orders;

import java.io.File;

/**
 * Lexicographic order comparator for file names
 * 
 * @author yonatan,yuli
 * 
 */
public class FileComparator extends AbsComparator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see oop.ex1.orders.AbsComparator#compare(java.io.File, java.io.File)
	 */
	public int compare(File fstfile, File scndfile) {
		// compares file's names
		String nameFstFile = ((File) fstfile).getName();
		String nameScndFile = ((File) scndfile).getName();
		// If the same name - do ABS compare
		if (nameFstFile.compareTo(nameScndFile) == 0) {
			return super.compare(fstfile, scndfile);
		}
		return nameFstFile.compareTo(nameScndFile);
	}

}
