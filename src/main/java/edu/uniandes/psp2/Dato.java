package edu.uniandes.psp2;
/**
 * representa a un nodo de una lista vinculada
 * @author juvenal
 * @version 2.0 06/03/2017
 */
public class Dato 
{
	/**valor*/
	private Double valor;
	
	/**siguiente nodo*/
	private Dato nextDato;
	
	/**
     * constructor de la clase
     * 
     */
	public Dato() 
	{
		
		this.nextDato = null;
		this.valor=(double) 0;
	}
	
	 /**
     * Obtiene el valor almacenado en el nodo
     * @return valor
     */
	public Double getValor() 
	{
		return valor;
	}
	
	 /**
     * Asigna el valor a almacenar por el nodo
     * @param valor
     */
	public void setValor(Double valor) 
	{
		this.valor = valor;
	}
	
	 /**
     * Retorna el nodo siguiente conectado al actual nodo
     * @return siguiente nodo
     */
	public Dato getNextDato()
	{
		return nextDato;
	}
	
	/**
     * Asigna el siguiente nodo que se conecta al nodo actual
     * @param siguiente nodo
     */
	public void setNextDato(Dato nextDato)
	{
		this.nextDato = nextDato;
	}
	
	
	

}

