package actions;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import exceptions.PermissionsException;



public interface Action {
	public void Exec(TreeSet<File> files) throws IOException, PermissionsException;
}
