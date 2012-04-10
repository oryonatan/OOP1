package Filters;
import java.io.File;
import java.io.FileFilter;


public class ExecFilter extends YesNoFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.canExecute() ^ negative;
	}

}
