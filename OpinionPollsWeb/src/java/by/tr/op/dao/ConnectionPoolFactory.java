package by.tr.op.dao;

import by.tr.op.dao.connection.ConnectionPool;

public class ConnectionPoolFactory {
    private static final ConnectionPoolFactory INSTANCE = new ConnectionPoolFactory();
		
    private ConnectionPool connectionPool = new ConnectionPool(20);
	
    private ConnectionPoolFactory(){}
	
    public static ConnectionPoolFactory getInstance(){
	return INSTANCE;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
