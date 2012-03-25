package Filters;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class FilterLine implements FileFilter {
	public ArrayList<FileFilter> filters = new ArrayList<FileFilter>();
	public FilterLine(FileFilter filter) {
		filters.add(filter);
	}
	@Override
	public boolean accept(File pathname) {
		for (FileFilter filter : filters){
			if (filter.accept(pathname) ) return true;
		}
		return false;
	}

}
