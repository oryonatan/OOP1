package actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;


public class PrintNameAction implements Action{

	
	public void Exec(TreeSet<File> files) throws IOException
	{
		for (File pathname: files)
		{
			System.out.println(pathname.getName());	
		}
	}
}
