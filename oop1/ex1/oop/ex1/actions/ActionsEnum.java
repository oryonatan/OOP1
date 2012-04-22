package oop.ex1.actions;





/**
 * Enum containing actions type classes , used for dynamic generation of actions
 * 
 * @author yuli
 *
 */
public enum ActionsEnum {
	PRINT_DATA(PrintDataAction.class),
	PRINT_NAME(PrintNameAction.class),
	COPY(CopyAction.class),
	EXEC(ExecAction.class),
	WRITE(WriteAction.class),
	LAST_MOD(LastModAction.class);
	
	public Class<? extends Action> classType;
	
	ActionsEnum(Class<? extends Action> classType)
	{
		this.classType = (Class<? extends Action>) classType;
	}


	/**Returns a Action using a string , since the filters appear in the file in lowecase , we need
	 * to upper case the,
	 * @param actionName the name of the filter needed
	 * @return filter class appropriate for the name.
	 * @throws BadParamException
	 *//**
	public static ActionsEnum fromValue(String actionName) throws BadParamException{
		if (actionName != null){
			//Iterate over values()
			for (ActionsEnum filter : values()){
				//Look inside object's name property.
				if(filter.name().equals(actionName.toUpperCase())){
					return filter;
				}
			}
		}
		throw new BadParamException();
	}*/
}
