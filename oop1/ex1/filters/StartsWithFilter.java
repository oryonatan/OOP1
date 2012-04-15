package filters;

import java.io.File;
import java.io.FileFilter;

/**A filter that looks for files with names statring in a given string.
 * @author yonatan,yuli
 *
 */
public class StartsWithFilter extends NegatableFilter implements FileFilter {
	private String arg = new String();

	/**Constructor for the filter.
	 * @param text the text to look for
	 */
	public StartsWithFilter(String text) {
		this.arg = text;
	}

	/* (non-Javadoc)
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().startsWith(arg) ^ negative;
	}
}