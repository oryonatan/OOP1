package oop.ex1.actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;


public class PrintNameAction extends Action{
	
	private static int param_length = 1;
	
	public PrintNameAction(String[] params) throws BadParamException {
		super(params,param_length);
	}

	public void Exec(TreeSet<File> files) throws IOException
	{
		for (File pathname: files)
		{
			System.out.println(pathname.getName());	
		}
	}
}
