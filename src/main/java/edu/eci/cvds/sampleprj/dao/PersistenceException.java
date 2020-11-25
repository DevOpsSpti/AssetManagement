package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception {

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }

    public PersistenceException(String string, org.apache.ibatis.exceptions.PersistenceException e) {
        super(string,e);
    }

    public PersistenceException() {
	super();
    }
}