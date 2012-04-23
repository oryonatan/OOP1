package oop.ex1.parser;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import oop.ex1.actions.Action;
import oop.ex1.actions.ActionsEnum;
import oop.ex1.exceptions.BadOrderException;
import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.ActionExceptions.BadActionException;

/**
 * parser for actions
 * 
 * @author Yuli
 * 
 */
public class ActionParser {
	private static final int NO_PARAMS = 1;
	private static final int FILTER_TYPE = 0;
	private static final int ARGUMENTS = 1;

	/**
	 * Creates an ArrayList of actions as they appear in the command file
	 * 
	 * @param sourceDir
	 *            - the source directory from the command line arguments
	 * @param lines
	 *            - an array which holds the actions from the command file
	 * @return
	 * @throws BadParamException
	 */
	public static ArrayList<Action> parseLines(String sourceDir, String[] lines)
			throws BadParamException {
		String[] params;
		ArrayList<Action> actions = new ArrayList<Action>();
		for (String line : lines) {
			// Each filter is composed form between 1 to 2 sections
			// seperated by an "%"
			params = line.split(Parser.PARAMETER_SEPERATOR);
			actions.add(ActionFactory(sourceDir, params));
		}
		if (actions.size() == 0) {
			throw new BadParamException();
		}
		return actions;
	}

	/**
	 * A factory that generates the actions
	 * 
	 * @param sourceDir
	 *            - the source directory from the command line arguments
	 * @param params
	 *            - the parameters for the specific action
	 * @return
	 * @throws BadParamException
	 */
	private static Action ActionFactory(String sourceDir, String[] params)
			throws BadParamException {
		Action action = null;
		String[] args;
		Constructor<? extends Action> ctor;
		try {
			// If name is not in lower case - err.
			String orderName = Parser.validateString(params[FILTER_TYPE]);
			// Create constructor for the given action
			ctor = ActionsEnum.valueOf(orderName).classType
					.getConstructor(String[].class);

			// we create an array of strings to be passed
			// to the action ctor. These actions which get
			// parameters should have them in the array.
			if (params.length == NO_PARAMS) {
				args = new String[] { sourceDir };
			} else {
				args = new String[] { sourceDir, params[ARGUMENTS] };
			}

			// create the object
			action = ((Action) ctor.newInstance((Object) args));
		} catch (java.lang.Exception e) {
			throw new BadActionException();
		}
		return action;

	}
}
