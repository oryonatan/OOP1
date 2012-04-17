package actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.text.ParsePosition;

import exceptions.BadParamException;
import exceptions.PermissionsException;

public class LastModAction extends Action{


	public LastModAction(String[] params) throws BadParamException
	{
		super(params);
	}
	
	public void Exec(TreeSet<File> files) throws PermissionsException
	{
		Date lastmod = new SimpleDateFormat(DATE_FORMAT).parse(params[DATE], new ParsePosition(0));
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
