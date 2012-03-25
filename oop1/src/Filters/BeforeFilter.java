package Filters;
import java.io.File;
import java.io.FileFilter;
import java.util.Date;


public class BeforeFilter extends YesNoFilter implements FileFilter{
	private Date date ;
	public BeforeFilter(Date date){
		this.date = date;
	}
	
	@Override
	public boolean accept(File pathname) {
		return date.before(new Date(pathname.lastModified())) ^ negative;
	}

}
