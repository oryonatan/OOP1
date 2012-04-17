package oop.ex1.filters;

import java.io.FileFilter;
import java.lang.Class;

import oop.ex1.exceptions.BadParamException;


/**Enum containing filter type classes , used for dynamic generation of filters
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
	HIDDEN(HiddenFilter.class);
	

	public Class<? extends FileFilter> classType;
	
	FiltersEnum(Class<? extends FileFilter> classType)
	{
		this.classType = classType;
	}

	/**Returns a filter using a string , since the filters appear in the file in lowecase , we need
	 * to upper case the,
	 * @param filterName the name of the filter needed
	 * @return filter class appropriate for the name.
	 * @throws BadParamException
	 */
	public static FiltersEnum fromValue(String filterName) throws BadParamException{
		if (filterName != null){
			//Iterate over values()
			for (FiltersEnum filter : values()){
				//Look inside object's name property.
				if(filter.name().equals(filterName.toUpperCase())){
					return filter;
				}
			}
		}
		throw new BadParamException();
	}
	

}
