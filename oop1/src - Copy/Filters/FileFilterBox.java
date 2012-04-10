package Filters;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class FileFilterBox implements FileFilter {
	public ArrayList<FilterLine> filterLines = new ArrayList<FilterLine>();
	
	public void addFilter(FileFilter filter) {
		filterLines.add(new FilterLine(filter));
	}
	public void addFilter(FilterLine filterLine) {
		filterLines.add(filterLine);
	}

	public boolean accept(File pathname) {
		for (FilterLine filtersLine : filterLines){
			if (!filtersLine.accept(pathname)) return false;
		}
		return true;
	}

}