package Actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParsePosition;

import Exceptions.BadParamException;
import Exceptions.PermissionsException;

public class LastModAction {
	private Date lastmod;

	public LastModAction(String param) throws BadParamException
	{
		lastmod = new SimpleDateFormat("dd/MM/yyyy").parse(param, new ParsePosition(0));
			
	}
	public void Exec(File[] files) throws PermissionsException
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
