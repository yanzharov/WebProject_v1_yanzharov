package by.tr.op.service;

import by.tr.op.bean.Information;
import by.tr.op.service.exception.ServiceException;

public interface AuthorizationService {
    
    Information signIn(String login,String password) throws ServiceException;
    
}
