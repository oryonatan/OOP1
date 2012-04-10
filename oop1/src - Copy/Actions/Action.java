package Actions;

import java.io.File;
import java.io.IOException;

import Exceptions.PermissionsException;

public interface Action {
	public void Exec(File[] files) throws IOException, PermissionsException;
}
