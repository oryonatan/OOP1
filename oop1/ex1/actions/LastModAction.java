package actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.text.ParsePosition;

import exceptions.BadParamException;
import exceptions.PermissionsException;

public class LastModAction implements Action{
	private Date lastmod;

	public LastModAction(String param) throws BadParamException
	{
		lastmod = new SimpleDateFormat("dd/MM/yyyy").parse(param, new ParsePosition(0));
			
	}
	public void Exec(TreeSet<File> files) throws PermissionsException
	{
		try
		{
			for (File pathname: files)
			{
				pathname.setLastModified(lastmod.getTime());	
			}
		}
		catch(SecurityException e){
			throw new PermissionsException();
		}
	}
}
