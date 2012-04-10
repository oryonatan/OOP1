package Filters;
import java.io.File;
import java.io.FileFilter;
import java.util.Date;


public class AfterFilter extends YesNoFilter implements FileFilter {
	private Date date ;
	public AfterFilter(Date date ) {
		this.date = date;
	}
	@Override
	public boolean accept(File pathname) {
		return date.after(new Date(pathname.lastModified())) ^ negative;
	}
}
