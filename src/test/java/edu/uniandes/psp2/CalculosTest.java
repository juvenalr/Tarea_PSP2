package edu.uniandes.psp2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CalculosTest extends TestCase 
{
 
 

 
 @Test 
 public void testSuma()
 {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double suma= cal.sumatoria(datosX);
	 assertEquals(15.0,suma);
	 
 
 }
 
 @Test 
 public void testSumaCuadrados()
 {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double suma= cal.sumatoriaCuadrados(datosX);
	 assertEquals(55.0,suma);	 
 
 }
 
 @Test 
 public void testMedia()
 {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double suma= cal.media(datosX);
	 assertEquals(3.0,suma);	 
 
 }
 
 @Test 
 public void testSumaMultiplicacio()
 {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 ConjuntoDatos datosY= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 datosY.addDato(Double.parseDouble("1"));
	 datosY.addDato(Double.parseDouble("2"));
	 datosY.addDato(Double.parseDouble("3"));
	 datosY.addDato(Double.parseDouble("4"));
	 datosY.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double suma= cal.sumatoriaMultiplicacion(datosX, datosY);
	 assertEquals(55.0,suma);	 
 
 }
 
 @Test 
 public void testB0()
 {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 ConjuntoDatos datosY= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 datosY.addDato(Double.parseDouble("1"));
	 datosY.addDato(Double.parseDouble("2"));
	 datosY.addDato(Double.parseDouble("3"));
	 datosY.addDato(Double.parseDouble("4"));
	 datosY.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double suma= cal.calcularB1(datosX, datosY);
	 assertEquals(1.0,suma);	 
 
 }
 
 @Test 
 public void testB()
 {
	 ConjuntoDatos datosX= new ConjuntoDatos();
	 ConjuntoDatos datosY= new ConjuntoDatos();
	 datosX.addDato(Double.parseDouble("1"));
	 datosX.addDato(Double.parseDouble("2"));
	 datosX.addDato(Double.parseDouble("3"));
	 datosX.addDato(Double.parseDouble("4"));
	 datosX.addDato(Double.parseDouble("5"));
	 
	 datosY.addDato(Double.parseDouble("1"));
	 datosY.addDato(Double.parseDouble("2"));
	 datosY.addDato(Double.parseDouble("3"));
	 datosY.addDato(Double.parseDouble("4"));
	 datosY.addDato(Double.parseDouble("5"));
	 
	 Calculo cal = new Calculo();
	 double suma= cal.calcularB1(datosX, datosY);
	 assertEquals(1.0,suma); 
 
 }
 
 @Test 
 public void testdelMapa()
 {
	 Controlador con = new Controlador();
	 Map<String,String> mapa = new HashMap <String,String>();
	 mapa.put("1", "A");
	 mapa.put("2", "B");
	 
	 
	 Map<String,String> mapa3 = con.delElemntoMapa("1", mapa);
	 assertEquals(false,mapa3.containsKey("1")); 
 
 }
}
