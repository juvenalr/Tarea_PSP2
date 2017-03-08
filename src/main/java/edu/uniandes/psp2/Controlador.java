package edu.uniandes.psp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Calse controlador que contiene el metodo principal
 * @author juvenal
 * @version 2.0 06/03/2017
 */
public class Controlador
{
  /**Objeto de la clase AdministrarDatos que se encarga de los procesos y calculo*/ 
  public AdministrarDatos adminDatos;
  
  /**Objeto de la clase vista que mustra los menus en pantalla*/
  public Vista menus;
  
  /**
	 * lee los de la consola las entradas del ususario
	 */
  
  public Controlador()
  {
	  adminDatos= new AdministrarDatos();
	  menus=new Vista();
  }
  public String leerLineaConsola()
  { String line = null;
  	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  	try
  	{
  		line = reader.readLine();
  	} 
  	catch (IOException e) 
  	{
  		System.out.println("Error Línea no leida");
  		return null;
  	}
  	return line;
  }
  
  /**
	 * presnta el menu para ingresar la ruta del archivo
	 */
  public void menuRutaArchivo()
  {
  	menus.mostrarMenuRutaArchivo();
  	String path= leerLineaConsola();
  	
  	if (path != null )
  	{
  		if(path.toLowerCase().equals("s"))
  			
  		{
  			
  			System.exit(0) ;
  		}
  		else if (adminDatos.leerArchivo(path))
  		
  		{
  			menuCalcularRegresion();
  			
  		
  		}
  		else
  		{  System.out.println("Opción no Valida");
  			menuRutaArchivo();
  			
  		}
  		
  		
  	}
  }
  
  /**
 	 * presenta el menu para calcular la regresion lineal
 	 */
  public void menuCalcularRegresion()
  {
	  int indiceX;
	  int indiceY;
	
	  double xk;
	  MostrarValoresCargados();
	  Map<String,String> resultados;
	  menus.mostrarMenuRegresion();
	  
	  
	  String val=leerLineaConsola();
	
	  if(val.toLowerCase().equals("s"))		
	  {
		  System.exit(0) ;
	  }	  	
	  
	  
	  Map<String,String> titulosX = adminDatos.getTitulosListaConjuntoDatos();
	 
	  indiceX= MenuSelecionDatos("X",titulosX);
	  
	  if (indiceX !=-1)
	  {
		  Map<String,String> titulosY = delElemntoMapa(Integer.toString(indiceX),titulosX);
		  
		  indiceY= MenuSelecionDatos("Y",titulosY);
		  
		  if (indiceY !=-1)
		  {
			  menus.mostrarMenuIngresoValor();
			  val=leerLineaConsola();
			  if (esNumero( val))
			  {
				  xk=Double.parseDouble(val);
				  
				  resultados= this.adminDatos.getParametrosRegresion(indiceX-1, indiceY-1, xk);
				  
				  menus.mostrarResultados(resultados);
			  }
			  else
			  {
				  System.out.println("El valor ingresado no es un número");
				  menuCalcularRegresion();
			  }
		  }
		  
		  else
		  {
			  menuCalcularRegresion();
		  }
	  }
	  
	  else
	  {
		  menuCalcularRegresion();
	  }
	  
	  menuCalcularRegresion();
  }
  
 
  /**
  * Muesta el conjunto de datos cargado
  */
  public void MostrarValoresCargados()
  {
  	ArrayList<ConjuntoDatos> listaDatos= adminDatos.getListaConjuntoDatos();
  	for(ConjuntoDatos datos: listaDatos)
  	{
  		menus.mostrarConjuntoDattos(datos);
  	}
  }
  
  /**
   * retorna un mapa exlcuyendo el dato que coincide con la llave
   * @param llave del elemnto a excluir
   */
   public Map<String,String> delElemntoMapa(String llave,Map<String,String> mapa)
   {
	   Map<String,String> nuevoMapa =new HashMap <String,String>();
	   for (Map.Entry<String, String> elemento : mapa.entrySet())
		{
		   
			if (!elemento.getKey().equals(llave))
			{
				nuevoMapa.put(elemento.getKey(),elemento.getValue());
			}
		}
	   return nuevoMapa;
   }
   /**
    * retorna el indece del conjunto de datos
    * @param dicionario con los indices y titulos de un conjunto de datos
    */
  public int MenuSelecionDatos(String variable,Map<String,String> titulos)
  {

  	menus.mostrarMenuSelccionDatos(variable, titulos);
  	
  	
  	String val=leerLineaConsola();
  	if(val.toLowerCase().equals("s"))		
  	{
  		return -1;
  	}
  	
  	else if ( esEntero(val))
  		
  	{
  		 if (titulos.containsKey(val))
  		{
  			return Integer.parseInt(val);
  		}
  		
  		else
  		{
  			System.out.println("Ingrese una opcion valida");
  			MenuSelecionDatos(variable, titulos);
  		}
  		
  	}
  	else
  	{ 
  		System.out.println("Ingrese una opcin valida");
  		MenuSelecionDatos(variable, titulos);
  	}
  	return -1;
  }
  
  /**
   * define si un valor en formato texto correponde a un entero 
   * @return verdadero si es entero
    */
  public boolean esEntero(String val)
  {
  	
  	try 
  	{
  		Integer.parseInt(val);
		return true;
  	}
  	catch(NumberFormatException ex)
  	{
  		return false;
  	}
  	
  	
  }
  /**
   * define si un valor en formato texto correponde a un numero 
   * @return verdadero si es numero
    */
  public boolean esNumero(String val)
  {  		

  	try {
  			Double.parseDouble(val);
  			return true;
  		}
  	catch(NumberFormatException ex)
  	{
  		return false;
  	}
  	
  	
  }
  /**
   * Metodo pricipal
    */
  static public void main(String args[])
  {
   Controlador aplicacion = new Controlador();
   aplicacion.menuRutaArchivo();
   
  }
}
