package edu.uniandes.psp2;

import java.util.ArrayList;


/**
 * realiza los diferntes calculos aritmeticos
 * @author juvenal
 * @version 2.0 06/03/2017
 */
public class Calculo 
{

	/**
	 * calcula la suma de los valores de un conjunto de datos
	 * @param conjunto de datos
	 * @return suma de los valores del conjuto de datos
	 */
	public double sumatoria(ConjuntoDatos datos)
	{
		double suma=0;
		ArrayList<Double> valores= datos.getListaValoresNumero();
		for(double valor : valores)
		{
			suma = suma + valor;
		}
		return suma;
	}
	
	/**
	 * calcula la suma de los cuadrados de los valores de un conjunto de datos
	 * @param conjunto de datos
	 * @return suma de los cuadrados de los valores del conjuto de datos
	 */
	public double sumatoriaCuadrados(ConjuntoDatos datos)
	{
		double suma=0;
		
		ArrayList<Double> valores= datos.getListaValoresNumero();
		for(double valor : valores)
		{
			suma = suma + Math.pow(valor,2);
		}
		
		return suma;
	}
	
	/**
	 * calcula la media de un conjunto de datos
	 * @param conjunto de datos
	 * @return media de los valores del conjuto de datos
	 */
	public double media(ConjuntoDatos datos)
	{
		double med=0;		
		double numeroDatos=datos.getNumeroElementos();
		 
		if (numeroDatos >0)
		{
			med= sumatoria(datos)/numeroDatos;
		}
		
		return med;
	}
	
	/**
	 * calcula la suma de las multiplicaciones entre los valores de dos conjutos de datos
	 * @param conjunto de datos X
	 * @param conjunto de datos Y
	 * @return suma de la multiplicaciones
	 */
	public double sumatoriaMultiplicacion(ConjuntoDatos datosX,ConjuntoDatos datosY)
	{
		double suma=0;
		
		ArrayList<Double> valoresX= datosX.getListaValoresNumero();
		ArrayList<Double> valoresY= datosY.getListaValoresNumero();
		
		
		double mult=0;
		int numeroElemntosX= datosX.getNumeroElementos();
		int numeroElemntosY = datosY.getNumeroElementos();
		if (numeroElemntosX != numeroElemntosY)
		{
			System.out.println("sumatoriaMultiplicacion: Error  los conjuntos de datos no tienen el miemo número de elementos");
			return -1;			
		}
		else
		{
			for(int i=0;i< numeroElemntosX; i++)
			{
				mult= valoresX.get(i)*valoresY.get(i);
				suma= suma + mult;
			}
		}
		
		return suma;
	}
	
	/**
	 * calcula el parametro B1
	 * @param conjunto de datos X
	 * @param conjunto de datos Y
	 * @return parametro B1
	 */
	public double calcularB1(ConjuntoDatos datosX,ConjuntoDatos datosY)
	{
		double b1=0;
		double sumaMultiplicacionesXY=0;
		double mediaX=0;
		double mediaY=0;
		double sumaCuadradosX=0;
			
		
		int numeroElemntosX = datosX.getNumeroElementos();
		int numeroElemntosY = datosY.getNumeroElementos();
		
		if (numeroElemntosX != numeroElemntosY)
		{
			System.out.println("CalcularB1: Error  los conjuntos de datos no tienen el miemo número de elementos");
			return -1;			
		}
		else
		{
			sumaMultiplicacionesXY=this.sumatoriaMultiplicacion(datosX, datosY);
			mediaX=this.media(datosX);
			mediaY=this.media(datosY);
			sumaCuadradosX=this.sumatoriaCuadrados(datosX);
			
			if ( sumaCuadradosX - numeroElemntosX*Math.pow(mediaX, 2)!=0)
			{
				b1= (sumaMultiplicacionesXY  - (numeroElemntosX*mediaX*mediaY))/(sumaCuadradosX - numeroElemntosX*Math.pow(mediaX, 2));
			}
		}
		return b1;
	}
	
	/**
	 * calcula el parametro B0
	 * @param media conjunto de datos y
	 * @param media conjunto de datos X
	 * @param parametro B1
	 * @return parametro B0
	 */
	public double calcularB0(double mediaY, double mediaX, double b1)

	
	{
		double b0=0;
		b0=mediaY-b1*mediaX;
		return b0;
	}
	
	
	/**
	 * calcula el coefiente de correlacion
	 * @param conjunto de datos X
	 * @param conjunto de datos Y
	 * @return coeficiente de correlacion
	 */
	
	public double calcularCoeficiente(ConjuntoDatos datosX,ConjuntoDatos datosY)
	{
		double r=0;
		double sumaMultiplicacionesXY=0;		 
		double sumaCuadradosX=0;
		double sumaCuadradosY=0;
	    double sumatoriaX=0;
	    double sumatoriaY=0;
		double numerador=0;
		double denominador=0;
		
		int numeroElemntosX = datosX.getNumeroElementos();
		int numeroElemntosY = datosY.getNumeroElementos();
		
		if (numeroElemntosX != numeroElemntosY)
		{
			System.out.println("CalcularB1: Error  los conjuntos de datos no tienen el miemo número de elementos");
			return -1;			
		}
		else
		{
			sumaMultiplicacionesXY=this.sumatoriaMultiplicacion(datosX, datosY);
			sumaCuadradosX=this.sumatoriaCuadrados(datosX);
			sumaCuadradosY=this.sumatoriaCuadrados(datosY);
			sumatoriaX=this.sumatoria(datosX);
			sumatoriaY=this.sumatoria(datosY);
			
			numerador = numeroElemntosX*sumaMultiplicacionesXY - sumatoriaX*sumatoriaY;
			
			denominador= (numeroElemntosX*sumaCuadradosX - Math.pow(sumatoriaX, 2))* (numeroElemntosY*sumaCuadradosY - Math.pow(sumatoriaY, 2));
					
			if ( denominador>0)
			{
				r=numerador /Math.sqrt(denominador);
			}
		}
		return r;
	}
}
