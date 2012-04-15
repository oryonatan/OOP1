package Actions;

import java.lang.Class;



public enum ActionsEnum {
	print_data(PrindDataAction.class),
	print_name(PrintNameAction.class),
	copy(CopyAction.class),
	exec(ExecAction.class),
	write(WriteAction.class);
	
	public Class classType;
	
	ActionsEnum(Class classType)
	{
		this.classType = classType;
	}

}
