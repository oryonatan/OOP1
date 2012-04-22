package oop.ex1.actions;

import java.io.File;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;


/**
 * An action which sets file’s last modified time
 * 
 * @author yuli
 *
 */
public class WriteAction extends Action {
	private boolean write;

	private static final int param_length = 2;

	/**
	 * @param params -  an array which holds one string of type "YES" or "NO" 
	 * 					which defines if we want to have writing permissions
	 * @throws BadParamException
	 */
	public WriteAction(String[] params) throws BadParamException {
		super(params,param_length);
		if (YES.equals(params[YES_OR_NO])) {
			this.write = true;
		} else if (NO.equals(params[YES_OR_NO])) {
			this.write = false;
		} else {
			throw new BadParamException();
		}

	}

	/* (non-Javadoc)
	 * @see oop.ex1.actions.Action#Exec(java.util.TreeSet)
	 */
	public void Exec(TreeSet<File> files) throws PermissionsException {
		try {
			for (File pathname : files) {
				pathname.setWritable(write);
			}
		} catch (SecurityException e) {
			throw new PermissionsException();
		}
	}
}
