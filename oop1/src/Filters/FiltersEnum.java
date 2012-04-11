package Filters;

import java.lang.Class;

import Exceptions.BadParamException;

public enum FiltersEnum{
	BEFORE(BeforeFilter.class),
	AFTER(AfterFilter.class),
	GREATE_THEN(GreaterThanFilter.class),
	SMALLER_THAN(SmallerThanFilter.class),
	PERFIX(StartsWithFilter.class),
	SUFFIX(EndsWithFilter.class),
	WRITABLE(WriteableFilter.class),
	EXECUTABLE(ExecFilter.class),
	HIDDEN(HiddenFilter.class);
	

	public Class<?> classType;
	
	FiltersEnum(Class<?> classType)
	{
		this.classType = classType;
	}

	public static FiltersEnum fromValue(String value) throws BadParamException{
		if (value != null){
			for (FiltersEnum filter : values()){
				if(filter.name().equals(value.toUpperCase())){
					return filter;
				}
			}
		}
		throw new BadParamException();
	}
	

}
