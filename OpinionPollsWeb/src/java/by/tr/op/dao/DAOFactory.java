package by.tr.op.dao;

import by.tr.op.dao.impl.PollsDAOProvider;

public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
		
    private PollsDAO pollsDao = new PollsDAOProvider();
	
    private DAOFactory(){}
	
    public static DAOFactory getInstance(){
	return INSTANCE;
    }

    public PollsDAO getPollsDao() {
        return pollsDao;
    }
	
}