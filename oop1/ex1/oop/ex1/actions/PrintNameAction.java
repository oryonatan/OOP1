package oop.ex1.actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;


/**
 * An action which prints file name to the standard output (STDOUT)
 * 
 * @author yuli
 *
 */
public class PrintNameAction extends Action{
	
	private static int param_length = 1;
	
	/**
	 * @param params -  an array which suppose to hold no strings because
	 * 					the action print_name doesn't get any parameters
	 * @throws BadParamException
	 */
	public PrintNameAction(String[] params) throws BadParamException {
		super(params,param_length);
	}

	/* (non-Javadoc)
	 * @see oop.ex1.actions.Action#Exec(java.util.TreeSet)
	 */
	public void Exec(TreeSet<File> files) throws IOException
	{
		for (File pathname: files)
		{
			System.out.println(pathname.getName());	
		}
	}
}
