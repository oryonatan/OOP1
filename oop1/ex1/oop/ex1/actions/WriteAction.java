package oop.ex1.actions;

import java.io.File;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;


public class WriteAction extends Action {
	private boolean write;

	public WriteAction(String[] params) throws BadParamException {
		super(params);
		if (YES.equals(params[YES_OR_NO])) {
			this.write = true;
		} else if (NO.equals(params[YES_OR_NO])) {
			this.write = false;
		} else {
			throw new BadParamException();
		}

	}

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
