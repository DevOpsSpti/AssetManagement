package edu.escuelaing.arem.ASE.app;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App{
	/**
	 * @author Jose Luis Gomez Camacho
	 */
	public static void main(String[] args){ 
		Calculadora calculos= new Calculadora("datos.txt");
		try {
			System.out.println(calculos.mean());
			System.out.println(calculos.stddev());
		} catch (ListaException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}
}
