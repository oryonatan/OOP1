package oop.ex1.orders;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;

import oop.ex1.exceptions.AbsComperatorIOError;

/**
 * Lexicographic order comparator for full path names
 * 
 * @author yuli,yonatan
 *
 */
public class AbsComparator implements Comparator<File> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(File fstfile, File scndfile) {
		// compares file's full name
		String nameFstFile = null;
		String nameScndFile = null;
		try {
			nameFstFile = fstfile.getCanonicalPath();
			nameScndFile = scndfile.getCanonicalPath();
		} catch (IOException e) {
			throw new AbsComperatorIOError();
		}

		return nameFstFile.compareTo(nameScndFile);
	}

}
