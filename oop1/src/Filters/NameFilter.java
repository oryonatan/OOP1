package Filters;
import java.io.File;
import java.io.FileFilter;


public class NameFilter extends YesNoFilter implements FileFilter {
	private String name ;
	
	public NameFilter(String name) {
		this.name = name;
	}

	@Override
	public boolean accept(File pathname) {
		return pathname.getName().equals(name) ^ negative;
	}

}
