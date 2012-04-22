package oop.ex1.actions;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;

/**
 * An actions which prints file information to the standard input (STDOUT)
 * 
 * @author yuli
 *
 */
public class PrintDataAction extends Action{
	
	private static int param_length = 1;

	/**
	 * @param params -  an array which suppose to hold no strings because
	 * 					the action print_data doesn't get any parameters
	 * @throws BadParamException
	 */
	public PrintDataAction(String[] params) throws BadParamException {
		super(params,param_length);
	}

	/* (non-Javadoc)
	 * @see oop.ex1.actions.Action#Exec(java.util.TreeSet)
	 */
	public void Exec(TreeSet<File> files) throws IOException
	{
		for (File pathname: files)
		{
			printFileAttributes(pathname);			
			System.out.print(" " + (double)(pathname.length())/128 + " ");
			System.out.print(new Date(pathname.lastModified()).toString() + " ");
			System.out.println(pathname.getCanonicalPath() );
		}
	}

	/**
	 * Prints file's attributes (   "h" - for hidden,
	 * 								"w" - for writable,
	 * 								"x" - for executable)
	 * 
	 * @param pathname - the file whos'e attributes we want to print
	 */
	private void printFileAttributes(File pathname) {
		if (pathname.isHidden())
			System.out.print("h");
		else
			System.out.print("-");
		
		if (pathname.canWrite())
			System.out.print("w");
		else
			System.out.print("-");
		
		if (pathname.canExecute())
			System.out.print("x");
		else
			System.out.print("-");
	}
}
