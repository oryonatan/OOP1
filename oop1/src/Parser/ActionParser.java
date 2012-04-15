package Parser;

import Actions.ActionsEnum;
import Actions.Action;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import Exceptions.BadParamException;

public class ActionParser {
	private static final int FILTER_TYPE = 0;
    private static final int ARGUMENTS  = 1;
   


	public static ArrayList<Action> parseLines(String[] lines) throws BadParamException {
		String[] params;
		ArrayList<Action> actions = null;
		for (String line : lines) {
			params = line.split("%");
			actions.add(ActionFactory(params));
		}
		return actions;
	}

	private static Action ActionFactory(String[] params) throws BadParamException {
		
		Action action = null;
		try
		{
			Constructor ctor = ActionsEnum.valueOf(params[FILTER_TYPE]).classType.getConstructor(String.class);
			action = (Action) ctor.newInstance(params[ARGUMENTS]);
		}
        catch (java.lang.Exception e) {
            throw new BadParamException();
        }
		return action;

	}
}
