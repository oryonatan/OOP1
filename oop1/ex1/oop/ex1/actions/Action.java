package oop.ex1.actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;
import oop.ex1.exceptions.ActionExceptions.ActionParamSizeException;




public abstract class Action {
	protected String[] params;
	protected static final String YES = "YES";
	protected static final String NO = "NO";
	protected static final int YES_OR_NO = 1;
	protected static final String DATE_FORMAT = "dd/MM/yyyy";
	protected static final int DATE = 1;
	protected static final int SOURCE_DIR = 0;
	protected static final int TARGET = 1;
	
	
	
	
	public Action(String[] params,int param_length) throws BadParamException{
		if(params.length!= param_length){
			throw new ActionParamSizeException();
		}
		this.params = params;
	}
	public abstract void Exec(TreeSet<File> files) throws IOException, PermissionsException;
}
