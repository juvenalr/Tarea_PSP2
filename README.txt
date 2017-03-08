"Tarea PSP2" 
- 201710_CSOF5101_01 CONCEPTOS AVANZADOS DE INGENIERÍA SOFTWARE
- Programa 3 PSP2
- Juvenal Alberto Riaño Heredia cod 201710795
- 08/03/2017

- Instrucciones para ejecutar el programa

  	* deacargue los archivos desde https://github.com/juvenalr/Tarea_PSP2

  	* Descomprima el archivo

  	* Abra una consolo de comandos cmd y ubiquese dentro de la carpeta descomprimida (i.e cd C:/...../Tarea_PSP2-master)

  	* Ajecute el comando >mvn package
		Nota:  deberá tener instalado el programa maven en su equipo y haber modificado la ruta en la variable PATH 
		con la ruta de la carpeta bin de maven

  	* Una vez maven coplila el programa, ejecute el comanodo >java -cp target/psp2-1.0-SNAPSHOT.jar edu.uniandes.psp2.Controlador
     	 	Nota: deberá tener instalado la máquina virtual de Java (JRM) en su quipo
	
  
	* Una vez se ejecuta, el programa solicita que ingrese la ruta del archivo con los datos este lo puede encontara en la ruta test\Achivo_Datos_Test.txt
	       Nota: cada línea dentro del archivo represnta un conjuto de datos y su estructura es la siguiente: Nombre Conjunto Datos,valor1,valor2,valor3