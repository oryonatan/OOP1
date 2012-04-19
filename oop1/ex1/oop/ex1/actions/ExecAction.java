package oop.ex1.actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;


public class ExecAction extends Action {
	private boolean exec;
	private static final int param_length = 2;

	public ExecAction(String[] params) throws BadParamException {
		super(params,param_length);
		if (YES.equals(params[YES_OR_NO]))
			this.exec = true;
		else if (NO.equals(params[YES_OR_NO]))
			this.exec = false;
		else {
			throw new BadParamException();
		}

	}

	public void Exec(TreeSet<File> files) throws IOException,
			PermissionsException {
		try {
			for (File pathname : files) {
				pathname.setExecutable(exec);
			}
		} catch (SecurityException e) {
			throw new PermissionsException();
		}
	}
}
