package oop.ex1.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.text.ParsePosition;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;


public class LastModAction extends Action{

	private static final int param_length = 2;

	public LastModAction(String[] params) throws BadParamException
	{
		super(params,param_length);
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
