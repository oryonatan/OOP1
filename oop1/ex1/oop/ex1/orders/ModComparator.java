package oop.ex1.orders;

import java.io.File;
import java.util.Calendar;

/**
 * Date modified comperator
 * 
 * @author yonatan,yuli
 * 
 */
public class ModComparator extends AbsComparator {
	/**
	 * Checks if to dates (specified in long ms from epoch time) occured in the
	 * same day
	 * 
	 * @param date1
	 *            the first date
	 * @param date2
	 *            the second date
	 * @return
	 */
	public static boolean isSameDay(long date1, long date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTimeInMillis(date1);
		cal2.setTimeInMillis(date2);
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2
						.get(Calendar.DAY_OF_YEAR);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see oop.ex1.orders.absComparator#compare(java.io.File, java.io.File)
	 */
	public int compare(File fstfile, File scndfile) {
		// compares dates
		Long fstFileLastMod = fstfile.lastModified();
		Long scndFileLastMod = scndfile.lastModified();
		// If in the same day - do ABS compare
		if (isSameDay(fstFileLastMod, scndFileLastMod)) {
			return super.compare(fstfile, scndfile);
		}
		return fstFileLastMod.compareTo(scndFileLastMod);
	}
}
