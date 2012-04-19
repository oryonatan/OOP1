package oop.ex1.orders;

import java.io.File;
import java.util.Calendar;

public class modComparator extends absComparator {
	public static boolean isSameDay(long date1, long date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTimeInMillis(date1);
		cal2.setTimeInMillis(date2);
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2
						.get(Calendar.DAY_OF_YEAR);
	}

	public int compare(File fstfile, File scndfile) {
		Long fstFileLastMod = fstfile.lastModified();
		Long scndFileLastMod = scndfile.lastModified();
		if (isSameDay(fstFileLastMod, scndFileLastMod)) {
			return super.compare(fstfile, scndfile);
		}
		return fstFileLastMod.compareTo(scndFileLastMod);
	}
}
