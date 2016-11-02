package by.tr.op.service.impl;

import by.tr.op.bean.Information;
import by.tr.op.bean.Poll;
import by.tr.op.dao.DAOFactory;
import by.tr.op.dao.PollsDAO;
import by.tr.op.dao.exception.DAOException;
import by.tr.op.service.FindPollService;
import by.tr.op.service.exception.ServiceException;
import java.util.List;

public class FindPolls implements FindPollService{

    @Override
    public Information getPolls() throws ServiceException {
        Information information=new Information();
        DAOFactory factory=DAOFactory.getInstance();
        PollsDAO pollsDao=factory.getPollsDao();
        List<Poll> list;
        
        try{
            list=pollsDao.getPolls();
            information.setPolls(list);
        }
        catch(DAOException e){
            throw new ServiceException(e);
        }
        return information;
    }
    
}
