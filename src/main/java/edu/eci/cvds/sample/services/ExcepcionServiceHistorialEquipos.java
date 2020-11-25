package edu.eci.cvds.sample.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiceHistorialEquipos extends Exception {
	public ExcepcionServiceHistorialEquipos(String string) {
		super(string);
	}
        
	public ExcepcionServiceHistorialEquipos(String string, PersistenceException pex) {
		super(string, pex);
	}
}