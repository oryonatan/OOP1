package Actions;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeSet;

import Exceptions.PermissionsException;

public class CopyAction implements Action{
	private String target;

	
	public CopyAction(String target)
	{
		this.target = target;

	}
	
	public void Exec(TreeSet<File> files) throws IOException, PermissionsException
	{
		try
		{
			// !!! maybe no need to check, 
			// !!! maybe better in constructor
			File ftarget = new File(target);
			if (!ftarget.exists())
				ftarget.mkdirs();
			
			BufferedInputStream bufferedInput = null;
			BufferedOutputStream bufferedOutput = null;

	        byte[] buffer = new byte[1024];
	        
			for (File pathname: files)
			{
				 FileInputStream fistream = new FileInputStream( pathname.getAbsolutePath() );
				 FileOutputStream fostream = new FileOutputStream( target + "\\" +  pathname.getName() );
		
				 bufferedInput = new BufferedInputStream(fistream);
				 bufferedOutput = new BufferedOutputStream(fostream);
				 		            
		         //Keep reading from the file while there is any content
		         //when the end of the stream has been reached, -1 is returned
		         while (bufferedInput.read(buffer) != -1) 
		         {
		        	 bufferedOutput.write(buffer);
		         }
		         bufferedOutput.close();
		         bufferedInput.close();	 
			}
		}
		catch(SecurityException e){
			throw new PermissionsException();
		}
		
	}
}
	

	

