package by.tr.op.service.factory;

import by.tr.op.service.AuthorizationService;
import by.tr.op.service.EditUserService;
import by.tr.op.service.FindPollService;
import by.tr.op.service.impl.Authorization;
import by.tr.op.service.impl.EditUser;
import by.tr.op.service.impl.FindPolls;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
	
    private AuthorizationService authorizationService=new Authorization();
    private EditUserService editUserService=new EditUser();
    FindPollService findPollService=new FindPolls();
	
    private ServiceFactory(){}
	
    public static ServiceFactory getInstance(){
	return INSTANCE;
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public EditUserService getEditUserService() {
        return editUserService;
    }

    public FindPollService getFindPollService() {
        return findPollService;
    }

}
