package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Esta clase es la encargada de unir los Nodos.
 * @author Jose Luis Gomez Camacho
 */
public class Lista {
	private int length;
	
	/**
	 * Constructor para la lista,
	 */
	public Lista() {
		length=0;
	}
	/**
	 * M�todo encargado de crear y unir los Nodos.
	 * @param value El valor a guardar en el Nodo.
	 */


	/**
	 * M�todo que se encarga de recorrer los nodos hasta encontrar el buscado.
	 * @param pos La posici�n de la lista que desea. 
	 * @return El valor almacenado en el nodo.
	 */
	public double getValue(int pos)throws ListaException {

		Double valor = null;
		for( int x=0; x<=length && valor == null; x+=1) {

		}
		if (valor == null)throw new ListaException(ListaException.index);
		
		return valor;
	}
	/**
	 * @return La longitud de la lista. 
	 */
	public int getLength() {
		return length;
	}
}
