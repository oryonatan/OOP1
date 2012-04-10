package Actions;

import java.io.File;
import Exceptions.BadParamException;
import Exceptions.PermissionsException;

public class WriteAction implements Action{
	private boolean write;
	
	public WriteAction(String param) throws BadParamException
	{
		if ("YES".equals(param) )
			this.write = true;
		else if ("NO".equals(param) )
			this.write = false;
		throw new BadParamException();
			
	}
	public void Exec(File[] files) throws PermissionsException
	{
		try
		{
			for (File pathname: files)
			{
				pathname.setWritable(write);	
			}
		}
		catch(SecurityException e){
			throw new PermissionsException();
		}
	}
}

