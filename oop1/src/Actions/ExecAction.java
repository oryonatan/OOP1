package Actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import Exceptions.BadParamException;
import Exceptions.PermissionsException;

public class ExecAction implements Action{
	private boolean exec;
	
	
	public ExecAction(String param) throws BadParamException
	{
		if ("YES".equals(param) )
			this.exec = true;
		else if ("NO".equals(param) )
			this.exec = false;
		throw new BadParamException();
			
	}
	public void Exec(TreeSet<File> files) throws IOException, PermissionsException
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
