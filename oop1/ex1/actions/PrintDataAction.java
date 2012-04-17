package actions;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TreeSet;

public class PrintDataAction extends Action{
	

	public PrintDataAction(String[] params) {
		super(params);
	}

	public void Exec(TreeSet<File> files) throws IOException
	{
		for (File pathname: files)
		{
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
			
			
			System.out.print(" " + pathname.length() + " ");
			System.out.print(new Date(pathname.lastModified()).toString() + " ");
			System.out.println(pathname.getCanonicalPath() );
			
		}
	}
}
