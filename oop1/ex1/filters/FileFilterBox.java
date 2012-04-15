package filters;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * Object that contains a list of filter lines traverses on them with an "and"
 * logical conjunctuion
 * 
 * @author yonatan,yuli
 * 
 */
public class FileFilterBox implements FileFilter {
	public ArrayList<FilterLine> filterLines = new ArrayList<FilterLine>();

	/**
	 * Adds a single filter ,by creating a new line with a single filter.
	 * 
	 * @param filter
	 *            the filter to add.
	 */
	public void addFilter(FileFilter filter) {
		filterLines.add(new FilterLine(filter));
	}

	/**
	 * Adds a filters line containing one or more filters.
	 * 
	 * @param filterLine
	 *            the line to add
	 */
	public void addFilter(FilterLine filterLine) {
		filterLines.add(filterLine);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	public boolean accept(File pathname) {
		// Filter should fail folders
		if (pathname.isDirectory()) {
			return false;
		}
		// If one of the filters is false - the "and" requirement means that the
		// file should be filtered.
		for (FilterLine filtersLine : filterLines) {
			if (!filtersLine.accept(pathname))
				return false;
		}
		return true;
	}

}