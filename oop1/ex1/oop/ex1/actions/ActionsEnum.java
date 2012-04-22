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
}
