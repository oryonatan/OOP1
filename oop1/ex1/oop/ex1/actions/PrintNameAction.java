package oop.ex1.actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;


public class PrintNameAction extends Action{
	
	public PrintNameAction(String[] params) {
		super(params);
	}

	public void Exec(TreeSet<File> files) throws IOException
	{
		for (File pathname: files)
		{
			System.out.println(pathname.getName());	
		}
	}
}
