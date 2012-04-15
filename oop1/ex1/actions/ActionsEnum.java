package actions;

import java.lang.Class;



public enum ActionsEnum {
	print_data(PrindDataAction.class),
	print_name(PrintNameAction.class),
	copy(CopyAction.class),
	exec(ExecAction.class),
	write(WriteAction.class);
	
	public Class<? extends Action> classType;
	
	ActionsEnum(Class<? extends Action> classType)
	{
		this.classType = (Class<? extends Action>) classType;
	}

}
