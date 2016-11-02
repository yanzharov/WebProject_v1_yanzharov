package by.tr.op.controller;

import by.tr.op.command.Command;
import by.tr.op.command.impl.AddNewUser;
import by.tr.op.command.impl.GetPolls;
import by.tr.op.command.impl.SignIn;
import by.tr.op.command.impl.SignOut;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final static String SIGN_IN="SIGN_IN";
    private final static String SIGN_OUT="SIGN_OUT";
    private final static String ADD_NEW_USER="ADD_NEW_USER";
    private final static String GET_POLLS="GET_POLLS";
    private Map<String, Command> commands = new HashMap<String, Command>();
	
    public CommandProvider() {
	commands.put(SIGN_IN, new SignIn());
        commands.put(SIGN_OUT, new SignOut());
        commands.put(ADD_NEW_USER, new AddNewUser());
        commands.put(GET_POLLS, new GetPolls());
    }
	
    public Command getCommand(String commandName){
	Command command;
	command = commands.get(commandName);
	return command;
    }
    
}
