package oop.ex1.parser;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import oop.ex1.actions.Action;
import oop.ex1.actions.ActionsEnum;
import oop.ex1.exceptions.BadParamException;


public class ActionParser {
	private static final int FILTER_TYPE = 0;
	private static final int ARGUMENTS = 1;

	public static ArrayList<Action> parseLines(String sourceDir, String[] lines)
			throws BadParamException {
		String[] params;
		ArrayList<Action> actions = new ArrayList<Action>();
		for (String line : lines) {
			params = line.split("%");
			actions.add(ActionFactory(sourceDir, params));
		}
		if (actions.size() == 0 ){
			throw new BadParamException();
		}
		return actions;
	}

	private static Action ActionFactory(String sourceDir, String[] params)
			throws BadParamException {
		Action action = null;
		String[] args ;
		Constructor<? extends Action> ctor;
		try {
			ctor = ActionsEnum.fromValue(params[FILTER_TYPE]).classType
					.getConstructor(String[].class);
			if (params.length == 1){
				args= new String[] { sourceDir};
			}else{
				args = new String[] { sourceDir, params[ARGUMENTS] };
			}
			
			action = ((Action) ctor.newInstance((Object) args));
		} catch (java.lang.Exception e) {
			throw new BadParamException();
		}
		return action;

	}
}
