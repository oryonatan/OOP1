package Filters;

import java.lang.Class;

public enum FiltersEnum {
	before(BeforeFilter.class),
	after(AfterFilter.class),
	greater_than(GreaterThanFilter.class),
	smaller_than(SmallerThanFilter.class),
	perfix(StartsWithFilter.class),
	suffix(EndsWithFilter.class),
	writable(WriteableFilter.class),
	executable(ExecFilter.class),
	hidden(HiddenFilter.class);
	
	private Class classType;
	
	FiltersEnum(Class classType)
	{
		this.classType = classType;
	}
	

}
