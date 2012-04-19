package oop.ex1.filters;

import java.io.FileFilter;


/**
 * Enum containing filter type classes , used for dynamic generation of filters
 * 
 * @author yonatan,yuli
 * 
 */
public enum FiltersEnum{
	BEFORE(BeforeFilter.class),
	AFTER(AfterFilter.class),
	GREATER_THAN(GreaterThanFilter.class),
	SMALLER_THAN(SmallerThanFilter.class),
	PREFIX(StartsWithFilter.class),
	SUFFIX(EndsWithFilter.class),
	WRITABLE(WriteableFilter.class),
	EXECUTABLE(ExecFilter.class),
	HIDDEN(HiddenFilter.class),
	FILE(NameFilter.class);

	public Class<? extends FileFilter> classType;
	FiltersEnum(Class<? extends FileFilter> classType) {
		this.classType = classType;
	}
}
