package oop.ex1.actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;
import oop.ex1.exceptions.ActionExceptions.ActionParamSizeException;


/**
 * An abstract class which represents an action
 * 
 * @author yuli
 *
 */
public abstract class Action {
	protected String[] params;
	protected static final String YES = "YES";
	protected static final String NO = "NO";
	protected static final int YES_OR_NO = 1;
	protected static final String DATE_FORMAT = "dd/MM/yyyy";
	protected static final int DATE = 1;
	protected static final int SOURCE_DIR = 0;
	protected static final int TARGET = 1;
	
	
	/**
	 * Checks if the action received the right amount of parameters,
	 * should be done in all actions.
	 * 
	 * @param params 		- an array string of the parameters which the action recieves 
	 * 						( including source directory)
	 * @param param_length	- the amount of parameters in the array 
	 * @throws BadParamException
	 */
	public Action(String[] params,int param_length) throws BadParamException{
		if(params.length!= param_length){
			throw new ActionParamSizeException();
		}
		this.params = params;
	}
	/**
	 * The task which the action should do on the files
	 * 
	 * @param files - the input files that the actions executes on them 
	 * @throws IOException
	 * @throws PermissionsException
	 */
	public abstract void Exec(TreeSet<File> files) throws IOException, PermissionsException;
}
