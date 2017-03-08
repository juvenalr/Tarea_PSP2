package edu.uniandes.psp2;

import java.util.Map;

/**
 * clase qque se encarga de generar de mostrar los menus en pantalla
 * @author juvenal
 * @version 2.0 06/03/2017
 */

public class Vista
{
	/**
	 * muestra el menu para ingresar la ruta del archivo
	 * 
     */
	public void mostrarMenuRutaArchivo()
	{
		System.out.println("Benevenido al Porgrama1 PSP2 Calculo de Regeresion");
		System.out.println("Por Favor Ingrese la Ruta del Archivo que Contiene los Datos o Digite S para salir");		
		
	}
	
	/**
	 * muestra el menu para selecionar un conjunto de datos
	 * @param nombre de la variable que representa el conjunto de datos seleccionado
	 * @param diccionario con la lista devalores a mostrar
     */
	public void mostrarMenuSelccionDatos(String variable, Map<String,String> datos)
	{
		System.out.println("Seleccionar los Datos Correspondientes a la Variable "+variable+" ó Digite S Para Salir");
		
		for (Map.Entry<String, String> dato : datos.entrySet())
		{
			System.out.println("(" + dato.getKey() + ")   "+dato.getValue() );
		}
		System.out.println("(S) Salir del Menú");
	}
	
	/**
	 * muestra el menu para ingresar el valor para el cual se desea realizar la estimacion
	 * 
     */
	public void mostrarMenuIngresoValor()
	{
		System.out.println("Ingrese el Valor Para el Cual Desea Realizar la Estimación");
		
	
	}
	
	/**
	 * muestra los resultados de la regresio
	 * @param diccionario que contiene los resulatdos de la regresion
     */
	
	public void mostrarResultados( Map<String,String> resultados)
	{
		System.out.println("Parametros Calculados Regresión");
		
		for (Map.Entry<String, String> resultado : resultados.entrySet())
		{
		    
			System.out.println("(" + resultado.getKey() + ")   "+resultado.getValue() );
		}
	
	}
	
	/**
	* muestralos valores de los conjuntos de datos
	 * @param lista de datos
     */
	public void mostrarConjuntoDattos(ConjuntoDatos datos)
	{
		String textoDatos="";
		int p=1;
		
		for( String s : datos.getListaValores() )
		{
			
			if (p==1)
			{
				textoDatos= s;
			}
			
			else
			{
				textoDatos= textoDatos + "," + s;
			}
			p+=1;
		}
		
		System.out.println(datos.getTitulo() +": " +textoDatos);
		
	}
	
	/**
	* muestara ek menu para calcular la regresion
	 */
	public void mostrarMenuRegresion()
	{
		
		
		System.out.println(" (1) Seleccionar los Conjuntos de Datos X y Y");
		System.out.println(" (S) Salir del Menú");
		
	}
	
}
