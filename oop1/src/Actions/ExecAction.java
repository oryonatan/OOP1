package Actions;

import java.io.File;
import Exceptions.BadParamException;
import Exceptions.PermissionsException;

public class ExecAction {
	private boolean exec;
	
	
	public ExecAction(String param) throws BadParamException
	{
		if ("YES".equals(param) )
			this.exec = true;
		else if ("NO".equals(param) )
			this.exec = false;
		throw new BadParamException();
			
	}
	public void Exec(File[] files) throws PermissionsException 
	{
		try
		{
			for (File pathname: files)
			{
				pathname.setExecutable(exec);	
			}
		}
		catch(SecurityException e){
			throw new PermissionsException();
		}
	}
}
