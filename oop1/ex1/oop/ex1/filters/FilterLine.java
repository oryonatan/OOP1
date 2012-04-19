package oop.ex1.filters;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * An object containing a single line of filter , the line should return true ,
 * if one of the filter is passed.
 * 
 * @author yonatan,yuli
 * 
 */
public class FilterLine implements FileFilter {
	public ArrayList<FileFilter> filters = new ArrayList<FileFilter>();

	/**
	 * Default empty constructor
	 * 
	 */
	public FilterLine(){};

	/**
	 * Constructor , adds a line line to to the line
	 * 
	 * @param filter
	 *            a line with filter
	 */
	public FilterLine(FileFilter filter) {
		add(filter);
	}

	/**
	 * Adds a filter to the line
	 * 
	 * @param filter
	 *            the filter to add.
	 */
	public void add(FileFilter filter) {
		filters.add(filter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		for (FileFilter filter : filters) {
			if (filter.accept(pathname))
				return true;
		}
		return false;
	}

}
