package order;


import java.io.File;
import java.util.Calendar;
import java.util.Comparator;

public class modComparator extends absComparator {
	
	public int compare(File fstfile, File scndfile)
	{
		
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTimeInMillis(fstfile.lastModified());
		cal2.setTimeInMillis(scndfile.lastModified());
		
		if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR))
             
		{
			return super.compare(fstfile, scndfile);
		}
		if (cal1.after(cal2))
		{
			return 1;
		}
		else
			return -1;
	}
	

}
