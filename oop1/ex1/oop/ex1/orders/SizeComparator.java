package oop.ex1.orders;

import java.io.File;

/**
 * Order comparator for SizeComperator
 * 
 * @author yonatan
 * 
 */
public class SizeComparator extends AbsComparator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see oop.ex1.orders.AbsComparator#compare(java.io.File, java.io.File)
	 */
	public int compare(File fstfile, File scndfile) {
		Long sizeFstFile = fstfile.length();
		Long sizeScndFile = scndfile.length();
		// If of the same size - sort by ABS
		if (sizeFstFile.compareTo(sizeScndFile) == 0) {
			return super.compare(fstfile, scndfile);
		}
		return sizeFstFile.compareTo(sizeScndFile);
	}

}
