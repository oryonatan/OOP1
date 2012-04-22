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
	public int compare(File fstfile, File scndfile) {

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
