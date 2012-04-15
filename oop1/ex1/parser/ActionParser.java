package parser;

import actions.ActionsEnum;
import actions.Action;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import exceptions.BadParamException;

public class ActionParser {
	private static final int FILTER_TYPE = 0;
    private static final int ARGUMENTS  = 1;
   


	public static ArrayList<Action> parseLines(String sourceDir, String[] lines) throws BadParamException {
		String[] params;
		ArrayList<Action> actions = new ArrayList<Action>();
		for (String line : lines) {
			params = line.split("%");
			actions.add(ActionFactory(sourceDir,params));
		}
		return actions;
	}

	private static Action ActionFactory(String sourceDir,String[] params) throws BadParamException {
		
		Action action = null;
		try
		{
			Constructor<? extends Action> ctor = ActionsEnum.valueOf(params[FILTER_TYPE]).classType.getConstructor(String.class);
			action = (Action) ctor.newInstance(sourceDir + params[ARGUMENTS]);
		}
        catch (java.lang.Exception e) {
            throw new BadParamException();
        }
		return action;

	}
}
