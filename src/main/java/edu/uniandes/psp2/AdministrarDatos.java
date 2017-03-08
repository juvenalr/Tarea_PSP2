package edu.uniandes.psp2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * clase que administra los conjuntos de datos
 * @author juvenal
 * @version 2.0 06/03/2017
 */
public class AdministrarDatos
{
	
	
	/**Lista de conjuntos de datos*/
	private ArrayList<ConjuntoDatos> ListaConjuntoDatos;
	
	/**objeto de tipo Calculo*/
	private Calculo calculos;
	
	public AdministrarDatos()
	{
		ListaConjuntoDatos= new ArrayList<ConjuntoDatos>();
		calculos = new Calculo();
	}
	
	/**
     * Lee los valores desde un archivo de texto
     *  @return  retorna falso si no puede abrir el archivo
     */
	
	public boolean leerArchivo(String path)

	{
		boolean leido = false;
		
		if ( path.contains(".txt"))
		{
			try {
					BufferedReader br = new BufferedReader(new FileReader(path));
				
					try {
						String line = br.readLine();
						while (line != null) 
						{
							ConjuntoDatos nuevoConjuntoDatos= new ConjuntoDatos();
							
							String[] valores= line.split(",") ;
							for (int i= 0; i<valores.length;i++) 
							{
								if (i==0)
								{
									nuevoConjuntoDatos.setTitulo(valores[i]);
								}				        
								else
								{
									try {
										Double pValor= Double.parseDouble(valores[i]);
								
										nuevoConjuntoDatos.addDato(pValor);
										}
									catch(NumberFormatException ex)
									{
										System.out.println("Conjunto de Datos " +nuevoConjuntoDatos.getTitulo()+ "Valor No Cargado: " + valores[i]);								
									}
								}						
							
							}
							ListaConjuntoDatos.add(nuevoConjuntoDatos);
							line = br.readLine();
				    }
					leido= true;
					br.close();
				} 
				catch (IOException e) 
				{
					
				}
				
			} 
			catch (FileNotFoundException e) 
				{
					System.out.println("El Archivo No Se Pudo Abrir");
					return false;
				}
		}
		
		return leido;
	}

	/**
	 * devuleve el un conjunto de datos de la lista
	 * 
     * @param indice del conjunto de datos
     */
	public ConjuntoDatos getConjunto(int indice)
	{
		
		return ListaConjuntoDatos.get(indice);
	}
	
	/**
	 * Obtiene los parametro de la regresion para dos conjuntos de datos
	 * 
     * @param indice del conjunto de datos X
     * @param indice del conjunto de datos Y
     */
	public Map<String,String> getParametrosRegresion(int indX, int indY,double valor)
	{
		Map<String,String> parametros= new HashMap<String,String>();
		double b1=0;
		double b0=0;
		double r=0;
		double mediaX=0;
		double mediaY=0;
		double estimacion;
		
		ConjuntoDatos datosX = this.getConjunto(indX);
		ConjuntoDatos datosY= this.getConjunto(indY);
		
		mediaX= calculos.media(datosX);
		mediaY=calculos.media(datosY);
		b1=calculos.calcularB1(datosX, datosY);
		b0=calculos.calcularB0(mediaY, mediaX, b1);
		r= calculos.calcularCoeficiente(datosX, datosY);
		
		estimacion = b0 + b1*valor;
		
		parametros.put("b1",String.valueOf(b1));
		parametros.put("b0",String.valueOf(b0));
		parametros.put("r2",String.valueOf(Math.pow(r, 2)));
		parametros.put("r",String.valueOf(r));	
		parametros.put("Yk",String.valueOf(estimacion));
		
		
		
		
		
		
		
		return parametros;
		
	}
	
	/**
     * obtiene la lista del conjunto de datos
     *  @return  lista del conjunto de datos
     */
	public ArrayList<ConjuntoDatos>  getListaConjuntoDatos()
	{
		return ListaConjuntoDatos;
	}
	
	/**
     * obtiene la lista del conjunto de datos
     *  @return  lista del conjunto de datos
     */
	public Map<String,String>  getTitulosListaConjuntoDatos()
	{
		Map<String,String> titulos= new HashMap<String,String>();
		int indice=1;
		for(ConjuntoDatos datos :getListaConjuntoDatos())
		{
			titulos.put(Integer.toString(indice), datos.getTitulo());
			indice=indice+1;
		}
		
		return titulos;
		
	}
}
