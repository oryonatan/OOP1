package actions;

import java.io.File;
import java.util.TreeSet;

import exceptions.BadParamException;
import exceptions.PermissionsException;

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
	public void Exec(TreeSet<File> files) throws PermissionsException
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

