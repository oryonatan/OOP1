package Filters;

import java.io.File;
import java.io.FileFilter;

/**A filter that allows only folders to pass.
 * @author yonatan,yuli
 *
 */
public class FolderFilter implements FileFilter {
	
	/* (non-Javadoc)
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory()){
			return true;
		}
		return false;
	}

}
