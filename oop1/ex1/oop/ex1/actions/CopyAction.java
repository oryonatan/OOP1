package oop.ex1.actions;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeSet;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.PermissionsException;
import oop.ex1.exceptions.ActionExceptions.ActionCopyAbsPathException;

public class CopyAction extends Action {

	private static final int BUFFER_SIZE = 1024;
	private String target;
	private static final int param_length = 2;

	public CopyAction(String[] params) throws BadParamException {
		super(params, param_length);
		if (params[TARGET].startsWith(File.separator)) {
			throw new ActionCopyAbsPathException();
		}
		target = params[SOURCE_DIR] + File.separator + params[TARGET];
	}

	public void Exec(TreeSet<File> files) throws IOException,
			PermissionsException {
		try {
			File ftarget = new File(target);
			if (!ftarget.exists())
				ftarget.mkdirs();

			BufferedInputStream bufferedInput = null;
			BufferedOutputStream bufferedOutput = null;

			byte[] buffer = new byte[BUFFER_SIZE];

			for (File pathname : files) {
				FileInputStream fistream = new FileInputStream(
						pathname.getAbsolutePath());
				FileOutputStream fostream = new FileOutputStream(target
						+ File.separator + pathname.getName());

				bufferedInput = new BufferedInputStream(fistream);
				bufferedOutput = new BufferedOutputStream(fostream);

				int bytesRead;
				// Keep reading from the file while there is any content
				// when the end of the stream has been reached, -1 is returned
				do {
					bytesRead = bufferedInput.read(buffer, 0, buffer.length);
					bufferedOutput.write(buffer, 0, bytesRead);
				} while (bytesRead == buffer.length);
				bufferedOutput.close();
				bufferedInput.close();
			}
		} catch (SecurityException e) {
			throw new PermissionsException();
		}

	}
}
