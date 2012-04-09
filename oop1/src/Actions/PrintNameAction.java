package Actions;

import java.io.File;
import java.io.IOException;


public class PrintNameAction {

	
	public void Exec(File[] files) throws IOException
	{
		for (File pathname: files)
		{
			System.out.println(pathname.getName());	
		}
	}
}
