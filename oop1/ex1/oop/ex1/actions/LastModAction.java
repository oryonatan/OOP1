package oop.ex1.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.text.ParsePosition;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;


/**
 * An actions which sets file's last modified time
 * 
 * @author yuli
 *
 */
public class LastModAction extends Action{

	private static final int param_length = 2;

	/**
	 * @param params -  an array which holds one string of type date ("21/02/2012")
	 * 					which defines to what date to set the files last modified time
	 * @throws BadParamException
	 */
	public LastModAction(String[] params) throws BadParamException
	{
		super(params,param_length);
	}
	
	/* (non-Javadoc)
	 * @see oop.ex1.actions.Action#Exec(java.util.TreeSet)
	 */
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
