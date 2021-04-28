import java.util.Scanner;
import java.util.Random;

public class LibJuegosIPC1A_201930139{

		 static int punteoG[];
		 static int punteoP[];		
		 static int numeroJug=0;
		 static int llamadaTabla=0;
		 static String nombres[];


	public static void main(String[]args){
		Scanner entrada = new Scanner(System.in);//yo me recuerdo bien que si la clase principal ya tiene las librerias que los otros usan, no es necesario que las otras las posean
		/*sopa_letras juegoSL = new sopa_letras();
		Target juegoT = new Target();
		dosMIlCuarentaYOcho juegoDC = new dosMIlCuarentaYOcho();*/
		int bienIngresado=1;
		int opcion=-1;

		if(args.length>0){

			if(args.length>1){
				bienIngresado=0;
				System.out.println("Solo debe ingresar un número como máximo\n");
			}

			if(Integer.parseInt(args[0])>3 && Integer.parseInt(args[0])<1){
				bienIngresado=0;
				System.out.println("Los números de opción a ingresar deben estar entre 1 y 3\n");	
			}
		
			else{
				//bienIngresado=1;
				opcion=Integer.parseInt(args[0]);
			}	
		}//fin del if que permite que no se reciba nada

		if(bienIngresado==1){

			while(opcion!=0){//Se quedará así, pues si no se envía nada en linea de comandos, seguirá opcion con valor =-1

			if (opcion==-1){//este es por si acaso ingreso datos en lin com, pues no debería mostrar el menu al principio 

			System.out.printf("\t\t\t\tBIENVENIDO\n");
			System.out.println("\t\t\t\t   a la");		
			System.out.println("\t\t\t    LIBRERIA DE JUEGOS");		

			System.out.println("-MENU PRINCIPAL-");		
			System.out.println("\n\n\t     -JUEGOS-\t\t\t\t    -OTRAS OPCIONES-\n");		
			System.out.println("\t  ----------------\t\t\t  ------------------\n");		
			System.out.println("1. Sopa de letras\t\t\t  4. Tabla de puntuaciones\n");		
			System.out.println("2. Target\t\t\t\t  0. Salir\n");		
			System.out.println("3. 2048\n");		
			System.out.println("\n\nPor favor ingresa el número de opcion que deseas ejecutar\n");		
			opcion= entrada.nextInt();
			pressAnyKeyToContinue();
			//y el limpiador
			}//fin del if con opcion=-1

			else{

				switch(opcion){
					case 0:
						System.out.printf("\n\n\t\t\tGRACIAS POR USAR NUESTROS SERVICIOS : )\n");				
						pressAnyKeyToContinue();
						//Aquí iri el limpiador
					break;		

					case 1: 
						juego1();
						opcion=-1;
						//aqui va la llamada al metdo tabla???, bueno si lo quieres hacer deberás investigar como pasar datos de un métdo a otro, sino entonces ponlo dentro de cada parte del juego
					break;
				
					case 2:
						juego2();
						opcion=-1;

					break;
				
					case 3:
						juego3();
						opcion=-1;
					break;

					case 4:
						//llamaras a tablaP, la caul tambien tendrá un menucito para poder regresar al principal
						//aqui iria el limpiador al igual que antes de la llamada a cada juego
						tabla_Puntuaciones();
						opcion=-1;//no afecta en nada que haga esto, pues antes opción era diferente de 0 porque contenía el valor del juego y como no estaban ese if y el else, se ejecutaría hasta que ingresran 0
					break;

					default:
						 System.out.printf("\nDebes ingresar cualquiera de los numeros correspondientes a las opciones\n");	
						 opcion=-1;
						 pressAnyKeyToContinue();
						 //aqupi iria el limpiador


				}//fin del switch que ejecuta las opciones

			}//fin del else que permite que esto se muestre solo cuando opcion!=-1	

			//aquí habria un limpiador
			}//fin del while que mantiene ejecutandose TODO el programa, mientras no haya decidido salirse

		}//fin del if que permite que se ejecute cuando debe, es decir si no ha ingresado nada o si lo hizo y lo realizó bien	
	}//fin del main

	//Aquí iba el acomodador

	static public void juego1(){

		Scanner entrada = new Scanner(System.in);
		Random aleatorio = new Random();


		String palabraOrig;
		String palabra="m";
		String palabraSeleccionada;
		String palabraIngresada="m";
		String nombrecito;
		char palabraDesordenada[];//poseera en cada ubicacion las letras ordenadas de forma aleatoria
		//int NUM_JUGADORES=1;
		int i=0;
		int NUM_JUGADORES=1;
		int ubicacion;
		int ubicacionAlea[];//este arreglo servirá para verificar que los numero aleatorios no salgan repetidos
		int control=0;
		int continuar=1;
		int gano=0;//por si acaso...además esto no me provocará problemas, mas bien puede que me ayude cuando mande los datos a acumulador, solo no debo crear vars con el mismo nombre en otros métodos
		
		int intentos=3;//si quieres que no cuente el intento en el que está solo vuelve a este 2 y pon en la condicon >=0 y listo
		
	
		System.out.println("\n\n\n\n\n\t\t\t\t***SOPA DE LETRAS***\n");		
		System.out.println("Por favor, ingresa tu nombre: ");		
		nombrecito = entrada.nextLine();
		System.out.println("\n");		
		pressAnyKeyToContinue();

		System.out.println("\t\t\t\t***SOPA DE LETRAS***");
		System.out.println("\n-> INSTRUCCIONES");
		System.out.println("\nDebes tener a una o más personas, para que te asignen una palabra a adivinar");// lo que podría hacer es preguntar si tienes amigos, si si entonces pedir la palabra, sino entonces
		System.out.println("\n1. Tu amigo deberá ingresar una palabra cualquiera para que la puedas adivinar");//tomar una de las que tendrías almacenadas en un arreglo
		System.out.println("2. Deberás ingresar la palabra que crea que su amigo ingresó");
		System.out.println("3. Puedes intentar hacerlo 3 veces ");
		System.out.println("4. Deberás reingresar al juego para seguir jugando con otra palabra o la misma si lo desea");
		System.out.println("5. Tendrás que presionar M al solicitar datos para el juego si quieres desplegar el menú");


		while(continuar==1 && palabra.equals("m")){//debe ser así la condicion, puesto que puede que presionen continuar o no, y aun así la palabra seguiria teniendo una m y por ello se seguiría ejec independ
			entrada.nextLine();			                                   //y si solo poner continuar, entonces si solo dejas continuar, se crearía un bucle inf ya que requiero de continuar con valor 1para que se ejecute lo demás y por ello, en ningun momento a parte de este, le cambiaría el valor								
			System.out.printf("\n\n\nAMIGO\nPor favor escribe la palabra: ");//tambien podrías implementar m aquí, pero tendrías que cambiar las condiciones del if que habías pensado o mejor dicho partirlo en 2
																//así, ver si m palabraorig es= m, esto despues de pasarla a minus, si sí entonces hacer 	
			palabraOrig= entrada.nextLine();
			palabra=palabraOrig.toLowerCase();//es que se puede colocar la función directamente a la var sin necesidad de estarla guardando en otra var del mismo tipo, pero solo la transformará en esa línea
			//System.out.printf("%s", palabra);
		
			pressAnyKeyToContinue();		
			System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//bueno aquí iría el código para limpiar la pantalla
		
			if(palabra.equals("m")){
				continuar=menuSecundario(continuar);
			}//fin de este if que verifiva si se invocó al menuSec

		}//fin del while, que permite que ingresen una palabra si desean ciontinuar,luego de llamar al menu	

		if(continuar==1){
			palabraDesordenada= new char [palabra.length()];//creo hasta aqupi el tamaño del arreglo porque sino daría error hasta arriba por no tenre dato la var String
			ubicacionAlea= new int [palabra.length()];


			while(i<palabra.length()){//1.este while será para asignar los caraceter de forma aleatoria en cada ubicacion (de forma oredenada) del arreglo de char's 
				ubicacion = aleatorio.nextInt(palabra.length());// recuerda que necesita ser creada cada vez esta variables para que tome un número diferente en cada ciclo
				ubicacionAlea[i]=ubicacion;//esta variables recibe guarda de forma ordenada los numeros aleatorios de las ubicaiones, para luego, en el if de abajo, comparar si ya exite un número de ubic =
									  //para que si fuera así, entonces genere otro número hasta que de con otra ubicacion que no esté y así no se respitan y por ello omitan las letras que conforma la palabra

				if(i!=0){//debes excluir cuando i es igual a 0, porque es el primer número alea que salió y por ello si no lo hicieras no podría comparar si se repiten los demás números porque no pasarías de ahí
						for(int x=0; x<i; x++ ){//debe ser solo MENOR porque sino siempre encontraría una coincidencia, ya que ahí se encuentra el numero reciente almacenado
							if(ubicacionAlea[x]==ubicacion)//no olvides que esto es para que no se repitan las letras en un número en el que no aparece en las palabras
								control++;						
						}//fin del for
				}//fin del if		

				if(control==0){//Esta condición hace que al excluir al cero (lo cual se debe hacer), no se requiera de pensar de que forma le asignaré al cero si la expre está dentro de un if donde se le excluye
					palabraDesordenada[i]=palabra.charAt(ubicacion);
					i++;			
				}//fin del if que se encarfa de asignar el valor en la ubicación de palabraDes... si no hubo ninguna coincidencia

		    	control=0;//esto es para que se pueda volver a cumplir la condición de este if
			}//Fin del while asignador

		
		while(intentos>0 && gano==0 && continuar==1){//2. este es el while que permite ver el juego
		 	while(continuar==1 && palabraIngresada.equals("m")){	
		 		System.out.printf("\t\t\t\t***SOPA DE LETRAS***\n\t\t\t\t\t\t\tINTENTOS RESTANTES: %d", intentos);
		    	System.out.printf("\n\n\n\n");

				System.out.printf("\t   ");

				for(int y=0; y<palabra.length();y++){
					System.out.printf("     %s  ", palabraDesordenada[y]);//aquí muestro la palabra desordenada	CREO QUE TENDRE QUE QUITAR QUE AL INGRESAR LA PALABRA, PORQUE AL ENERRARLA EN UN IF, ENTIENDE COMO SI NO TUVIERA NADA, AUNQUE EN REALIDAD NO VAYA A HABER PORBLEMAS POR LA CONDICIÓN DEL WHILE

					}//por medio de este se visualiza la palabra

					System.out.println("\n\n");

			
			
				System.out.printf("\nEscriba la palabra que cree sea correcta: ");
				palabraSeleccionada= entrada.nextLine();
				palabraIngresada=palabraSeleccionada.toLowerCase();
				pressAnyKeyToContinue();

				if(palabraIngresada.equals("m")){
					continuar=menuSecundario(continuar);

				}//fin de este if que verifiva si se invocó al menuSec

			}//fin del while

			/*for(int z=0; z<palabra.length(); z++)	{
				System.out.println("__");

			}//fin del for que muestra ___*///no lo pongas porque no saldrá de forma horizontal, piensalo, por el println, además no tendría sentido porque aparecería después de ingresar la palabra

			if(continuar==1){

				if(palabraIngresada.equals(palabra)){//ver por qué no lo lee
					System.out.printf("\n\n\n\t\t\t    :) FELICIDADES, HA GANADO EL JUEGO\n\n");
					gano=1;
					acomodador(NUM_JUGADORES, nombrecito, gano);
					pressAnyKeyToContinue();
					//para luego poner el limpiador
					//System.out.printf("\n\nDesea jugar otra vez");//en realidad esto lo debo hacer con un metodo general, para volver a llamar al juego y no tener que hacer a intentos=2 en este caso y además estar
					//System.out.printf("1. Si         2.no");//haciendo esto cada vez en cada uno de los juegos
					//recibir opcion y si es si llamar al juego si no, mostrar el menú... aunqu pensandolo bien, creo que si tendré que hacerlo en c/u
				}//fin de este if felicitador

				else{
					intentos--;
				
						if(intentos==0){
							System.out.printf("\n\n\n\n\tA agotado el número de intentos posibles, el juego ha terminado :|\n");
							System.out.printf("\t\tLa palabra correcta era: %s\n\n\n\n", palabra);	
							acomodador(NUM_JUGADORES, nombrecito, gano);
						
							
							//como los intentos se acabaron y el while que muestra el juego funciona mientras una de las condiciones sea que gano=0, entonces no tendrás problemas con la sumatoria de resultados
						}	//en este caso debería llamar a ACUMULADOR para que agregue la cantidad y el nombre respectivo al registro temporal
						else
							System.out.printf("\n\n\n\n \t  :( No ha ingresado la palabra correcta, intente de nuevo\n\n\n\n\n\n\n\n\n");

							pressAnyKeyToContinue();
					//Runtime.getRuntime().exec("clear");

					palabraIngresada="m";

					//AQUÍ IRÍA OTRO CLS Y ANTES DE EL UN SYSTEM PAUSE, MEJOR DICHO SU VERSION JAVA
				}//FIN DEL ELSE

			}//fin del if que permite ejecutar el codigo si es continuar==1

		}//fin del while 2, si terminó quiere decir que acabó sus intentos, entonces					


		}//fin del if que permite ejecutar esto si desea continuar

		//AQUI IRIA EL METODO ACOMODADOR,si no haces lo de llamar al métod al terminar el juego, recuerda que lo que debes hacer es enviar los datos de nombre y  gano al método, yo creo que esto funcionaría
		//si hago un resturn para nombre y juego para llamar a ese método en el espacio en el que el metodo ACUMULADOR recibe los datos

	}//fin de la clase juego1

	static public void juego2(){
		Scanner entrada = new Scanner(System.in);
		Random valorAleatorio = new Random();

		int numJugadores=5;
		int tipoTiro=-1;
		String jugadores[];//recuerda que no creaste otra var string para los punteos, puesto que al metodo que se encarga de tabular, solo se requier enviarle, el dato de gano o perdio, por ello debes hacer a
		int valor=0;	   //ganó un arreglo, para que junto con los nombres, pase el valor de 1 o 0 al parámetro que guarda dichos valores, por ello el métdo debe recibir dos parámetros uno para nombres y otro
		int valorTiro[];   //para juegos ganados
		int gano[]= new int[4];//en este caso no importa cuantos decidan juagar, por el hecho de que al enviar y guardar los datos, solo se haran en los espacios que son necesitados por cada jugador
		int continuar=1;			   //es decir que dependerá del número los espacios a usar, mas no el tamaño total del arreglo

		System.out.printf("\n\n\n\n\n\t\t\t\tBIENVENIDO A TARGET\n\n");

		while(numJugadores>4 || numJugadores<0){
		System.out.printf("Ingrese el número de jugadores (el máximo es de 4): \n");
		numJugadores= entrada.nextInt();

			if(numJugadores>4){
				System.out.printf("\t***Debes ingresar un numero entre 1 y 4***");
			}
		}

		jugadores = new String[numJugadores];
		valorTiro= new int[numJugadores];

		entrada.nextLine();

		for(int x=1; x<=numJugadores;x++){
			int y=x-1;
			System.out.printf("\n\nJugador numero %d ingresa tu nombre: ", x);
		
			jugadores[y]=entrada.nextLine();
		}

		System.out.printf("\n\n\n");

		pressAnyKeyToContinue();
		//aquí iría el limpiador de pantalla

		System.out.printf("\n\n\t\t\t\t    ----TARGET----\n");
		System.out.printf("\n\nTEMÁTICA DE JUEGO");
		System.out.printf("\nEl juego consiste en tratar de acertar al área de la diana con mayor valor de\ntal manera que se llegue a reunir una cantidad mayor o igual a 200 puntos para\npoder ganar; Para"
			+" ello se podrá escoger entre tres tipos distintos de tiro\n los cuales tienen diferentes listas de probabilidades para acertar a algún\npunto. El jugador que alcanze la cantidad requerida será" 
			+ " el GANADOR");
		System.out.printf("\n\nINSTRUCCIONES\n");
		System.out.printf("1. EL juego puede disfrutarse con un máximo de 4 personas\n");
		System.out.printf("2. Cada jugador deberá esperar su turno para decidir el tipo de tiro\n");
		System.out.printf("3.Deberás ingresar el numero correspondiente al tiro\n\n");
		System.out.printf("  1 para Tiro rápido\t   --->\t   Probabilidad de dar en zona 0 o en la de 50\n");
		System.out.printf("  2 para Tiro controlado    --->    Probabilidad de dar en zona de 10, 20 o 30\n");
		System.out.printf("  3 para Tiro bajo el brazo\t--->\tProbabilidad de dar en cualquier zona\n\n");
		System.out.printf("4. Ganará el que obtenga una cantidad mayor o igual a 200 puntos\n");
		System.out.printf("5. Si se desea ver el menpu de opciones, presione 0\n\n");
		pressAnyKeyToContinue();
		//cada vez que haya una pausa, después debería ir un limpiador
		
		while(gano[0]==0 && gano[1]==0 && gano[2]==0 && gano[3]==0 && continuar==1){			
			//System.out.printf("\n\n\t\t\t       ----TARGET----\n");//Dejará de ser comentario, si implementas el gráfico

			/*for(int x=0; x<10;x++){
				System.out.printf("\t\t  ");

				for(int f=0; f<6;f++){
					System.out.printf("_____");
				}
 
				System.out.printf("\n\t\t  ");
				for(int b=0; b<2;b++){
					System.out.printf("|\t\t\t\t\t  ");
				}

			}	*/

			for(int x=0; x<numJugadores;x++){//Como este for está fuera del bloque donde está el otro for usando la var x, entonces no habrá confucion, a diferencia de si existiera otrs en el mismo bloque								
				if(continuar==1){
					while(tipoTiro!=1 && tipoTiro!=2 && tipoTiro!=3 && tipoTiro!=0 && continuar==1){//que se inicializara y cambiar avalores como si fuera la única llamada así
					//z=numJugadores-1; ya no porque mostrsremos nombres con el for
					System.out.printf("\n\n\t\t\t\t    ----TARGET----\n");

					for(int z=0; z<numJugadores;z++){
						switch(z){//si el switch funciona hasta llegar al cso, saldrá bien, sino pues entonces saldrán siempre los cuatro aunque no exitas en ese juego y si es así, deberá poner un if
								 //con cada situacion actual requerida	
							case 0:
							System.out.printf("J1: %s: %d  puntos", jugadores[0], valorTiro[0] );					
							break;
							case 1:
							System.out.printf("   \t \t\t\t\tJ2: %s: %d  puntos\n", jugadores[1], valorTiro[1]);
							break;
							case 2:
							System.out.printf("J3: %s: %d  puntos", jugadores[2], valorTiro[2]);
							break;
							case 3:
							System.out.printf("    \t \t\t\t\tJ4: %s: %d  puntos\n", jugadores[3], valorTiro[3]);														
							break;//es que podría ordenarlos bien al poner break en c/u y al implementar un for como el de arribita para que se mmostrara caso por caso pero, para no recargar otro ciclo, mejor así,
						}//fin del switch que muestra la situación actual
					}//fin del for que muestra a los jugadores


				
					System.out.printf("\n\nEs el turno de %s",jugadores[x]);

					//si dejas guardado el valor de tiro, intacto, para todos o para un solo jugador, lo que haría sería una simulación de jugar contra la computadpra
																 //así que por si acaso lo quieres implementar, para el caso de la computadora, no pediría el valor de tiro, 1 porque el la máquina y 2, PORQUE
																 //YA TIENES GUARDADO EL VALOR, para ello tendrías que hacer un arreglo de tipoTIro y usar solo el espacio 2 para la MAQUINA, así no sucederá nada
						System.out.printf("\n\n-->Ingrese el tipo de tiro: ");//y funcionará como si estuviera jugando sola, pues al evaluar el while para ese espacio, siempre tendría un valor que no le permite ejecutarse
						tipoTiro=entrada.nextInt();							 //y así haría una SIMULACIÓN... supongo que lo hacen de forma similar para todos los demás juegos	
																		//pues si quieren que gane la máquina o en otras palabras que aumente la dificultad, solo le reducen el número de posibilidadse y no solo	
						if(tipoTiro!=1 && tipoTiro!=2 && tipoTiro!=3 && tipoTiro!=0){		//eso sino que también a los valores que le permiten ganar con mayor facilidad, como en el caso de target el tiro 1 y 2
							System.out.printf("\n\n\tINGRESA CUALQUIERA DE LOS NUMEROS CORRESPONDIENTES A LAS OPCIONES\n");
							System.out.printf("  0 para visualiza el menú de opciones\n");
							System.out.printf("  1 para Tiro rápido\t   --->\t   Probabilidad de dar en zona 0 o en la de 40\n");
							System.out.printf("  2 para Tiro controlado    --->    Probabilidad de dar en zona de 10, 20 o 30\n");
							System.out.printf("  3 para Tiro bajo el brazo\t--->\tProbabilidad de dar en cualquier zona\n\n");
						}//Fin del if					

						if(tipoTiro==0){
						continuar=menuSecundario(continuar);
						tipoTiro=-1;
						}

					}//fin del while para repetir pregunta

					
					if(continuar==1){	

						switch(tipoTiro){
							case 1:
								valor= 40*(valorAleatorio.nextInt(2));
							break;
						
							case 2: 
								valor= 10*(1+valorAleatorio.nextInt(3));
							break;

							case 3:
								valor= 10*(valorAleatorio.nextInt(5));
							break;	

							//no necesito un default puesto que arriba se encargará de pedi y pedir la opción hasta que ingresen una correcta

						}//fin del switch

						tipoTiro=0;
						valorTiro[x]=valorTiro[x]+valor;

						System.out.printf("\n\n\n\t\t    %s a obtenido %d puntos en este tiro\n", jugadores[x], valor);
						System.out.printf("\t\t\t -Tiene un total de %d puntos-", valorTiro[x]);

						if(valorTiro[x]>=200){

							System.out.printf("\n\n\t\t\tFELICIDADES ERES EL GANADOR! :)\n\n");						
							gano[x]=1;							
							//System.out.printf("valor de x %d", x); por esta linea comprobé que gano si guarda el 1 en la ubicacion correcta
							x=numJugadores;//esto para terminar el for cuando haya ganado alguno, pues si no lo pusieras, seguiría ejecutandose hasta que se acaben los turnos, pues hasta alli se daría "cuenta"
							
							acomodador(numJugadores, jugadores[0], gano[0]);
							
							for(int z=1; z<numJugadores;z++){
								acomodador(0, jugadores[z], gano[z]);
							}//fin del for
						}

						else if(valorTiro[x]>=150 && valorTiro[x]<=190){
							System.out.printf("\n\n\t\t\t\t VAMOS A POR UN %d \n", 200-valorTiro[x]);				

						}				

						else {
							switch(valor){
								case 10:
									System.out.printf("\n\n\t\tAl menos ya tienes puntos... ¡sigue tirando!\n\n");
								break;

								case 20:
									System.out.printf("\n\n\t     Bueno, piensa que tienes más que los que tiraron a 10 o 0\n\n");
								break;

								case 30:
									System.out.printf("\n\n\t\t Ufff, por poco y dabas en el grande, tú puedes!\n\n");
								break;

								case 40:
									System.out.printf("\n\n\t\t Wooo, parece que alguien a estado practicando! :)\n\n");
								break;

								/*case 50:
									//Nada mal...ahora sigue así! :(, desapareciooo
							 		System.out.printf("\n\n\t\t Wooo, parece que alguien a estado practicando! :)\n\n");
								break;*/

								default:
									System.out.printf("\n\n\t   NO es el mejor tiro que hayas tenido, pero aún se puede\n\n");
								break;

							}//fin del switch

						}//fin del else	que muestra msjes si el valorTotal es < 150

						//System.out.printf("valorTiro[%d] es %d",x, valorTiro[x]);//Esto es solo para corroborar que todo vaya bien con esta var

						//Aqui iria el limpiador y antes un system pause
					}//fin del if que hace que no se ejecute este código porque ya no desea continuar

				}//fin del if que evita que se muestre el juego cuando ya no quiere continuar	

				tipoTiro=-1;

				if(continuar==0){
					System.out.printf("\n\n\n\n\t\t\t\tGracias por jugar : )\n\n");

				}
			}//fin del for que lleva el orden de turnos

			pressAnyKeyToContinue();
			//aquí iría el limpiador


		}//fin del while que opera mientras gano==0				


	}//fin de juego2

	static public void juego3(){
		Scanner entrada=new Scanner(System.in);
		Random aleatorio = new Random();

		int NUMEROS_JUG=1;
		int arreglo[][]=new int [4][4];	//este es el que guarda los numeros de la cuadrícula	
		int numeroAleatorio;
		int aleaFila= -1;
		int aleaCol=-1;	
		int aleatorioFila=0;
		int aleatorioCol=0;	
		int gano=0;
		int opMenu=0;//esta vari es para evitar que se agregue un número al regresar a la partida!
		int filaCambiante;//Estas y la de abajo servirán para el while que se encarga de la suma para la orientación vertical
		int filaFija;
		int columnaCambiante;//y esta y la de abjao para la orientación horizontal
		int columnaFija;
		int suma=0;
		int sumaTotal=0;
		int cantidad=1;
		int contadorCeros=0;
		int coincidenciasY=1;
		int coincidenciasX=1;
		int continuar=1;
		/*int yaNoVert=0;
		int yaNoHoriz=0;*///ára eso están las coincidencias individuales, duh!
		String dir;
		String direccion="nada";
		String nombre;
		//Debo incrustar el código que en el caso del sudoku buscaba coincidencias, solo que en este caso sera para que no inserte el número en una celda que ya contenía uno
		
		//es que cre que será mejor un while para que solo se ejecute para dos numeros, que sean 2 o 4 (no se si comienza con 4 tambipen o solo 2)
		//HABIA PUESTO AQUPI EL FOR, PENSANDO EN QUE LA FORMA DE ACTUAR DEL PRIMERO ES INDEPENDIENTE, PERO DEPENDIENDO DE COMO SURGAN LOS NÚMERO CREO QUE DEBERÉ PONER AL WHILE, pues creo que lo transformaré
		// DENTRO DEL WHILE QUE SE EJECUTA MIENTRAS N HAYA GANADO 
		//while(nombre.equals(null)){//como decir que se ejecute mientras nombre no tenga nada ni aun un enter, creo que debes usar un evento KeyEvent.VK_ENTER
		System.out.printf("\t\t\t          --2048---");
		System.out.printf("\n\nPor favor, ingresa tu nombre: ");
		nombre= entrada.nextLine();
		System.out.printf("\n\n\n");
		//
		pressAnyKeyToContinue();
		//Aqupi iria el limpiador

		for(int x=0; x<2;x=x+0){//esto solo deberá funcionar para solo dos npumeros al inicio, por ahora solo será para ver si funciona el código para mover los números
							  //RECUERDA QUE ESTAS VAR CON EL OBJ ALEATORIO DEBEN ESTAR DENTRO DE UN CICLO PARA QUE C/V generen un npumero nuevo, pues estas trabajan por ciiclos
			aleatorioFila=aleatorio.nextInt(4);//Esto será para asignar los valores a filas y columnas sin orden
			aleatorioCol=aleatorio.nextInt(4);

			
			if(aleaFila!=aleatorioFila && aleaCol!= aleatorioCol){//si tuviera que compara con más indices, entonces ahí s i debería usar un for y una var auxiliar para almacenar el valor del arreglo en 0, para luego compara el dato con el if donde si son iguales no asigna y si si pues procede a hacerlo
				aleaFila=aleatorioFila;
				aleaCol=aleatorioCol;
				arreglo[aleatorioFila][aleatorioCol]=2;
				x++;
			}//fin del if que no permite que las ubicaiones se repitan, porque si es probable
		}	
		System.out.printf("\t\t\t          --2048---");
		System.out.printf("\n\nTEMÁTICA DEL JUEGO\n");
		System.out.printf("El juego consiste en que muevas todos los números que en pantalla se muestran\nde tal manera que se puedan fusionar cuando choquen al haber ingresado una\ndirección específica"
			+".Los números se fusionan solo en parejas iguales; por cada\nmovimiento realizado se agrega un número 2 o 4 en pantalla. Perderás si\nla cuadrícula se llena y no existen ninguna forma en la que te"
			+" puedas\nmover para combinar al menos una pareja de números.\n\nSi logras obtener un 2048 en cualquiera de las celdas\n HABRÁS GANADO!");
		System.out.printf("\n\n\nINTRUCCIONES");		
		System.out.printf("\n\n1. Ingresar las abreviaturas correspondientes (una por una) a las direcciones\nen las que deseas mover todos los numeros; esto cuando sea solicitado por el juego\n");
		System.out.printf("\n   ar = arriba\t     ab = abajo\t     de = derecha\t     iz = izquierda\n");
		System.out.printf("\n2.Ingresar M si se desea acceder al menú de opciones\n\n");
		pressAnyKeyToContinue();
		//aquí iría el limpiador de pantallas :/


		while(gano==0 && continuar==1){//debe ser y porque puede que no haya ganado y desea salir o que haya ganado y desea salir

			//debo crear un método que salga del juego cuando presionen la tecla correspondiente, este deberá tener la posiblidad de despelgar un menú que diga salir (o continuar esto aún no lo sé, debo pensarlo
			//lo que si se es que debe ser capaz de ser ejecutado cuado se presione el valor requerido, entonces creoq eu sería conveniente que dentro del while que tenga por condi (mientras ganó == 0 || op°=0 para salir)
			//exista un switch que tenga las opciones respectivas de esa varibale, supongamos opcion, donde en el caso 1 se ejecute este código porque es el número que indica que la persona desea jugar el primer juego, 
			//en el caso 2 ejecutará el segundo y en el caso tres el tercero, luego otro método será capaz de cambiar el valor de op al invocarlo, con M, ya que las dir se indicarán con Ar,Ab... el cual si la
			//vuelve 0 mostrará el menú original que estará en el main, recuerda que el método del switch estará en la clase donde esté el main y si presiona 5 entonces de una vez terminará el programa al no tener nada
			//Adentro además de un mensaje que le agradezca por haber jugado, luego se saldrá del swtich y no habrá nada más abajo y ahpi terminará
			//SUPONGO QUE AL CAMBIAR EL VALOR DE OPCION DEL METODO EN EL JUEGO, al llamarlo y pasarle el parámetro se saldrá de una vez de él y pasará al caso correspondiente. esto quiere decir que el menpu principal del
			//main estará dentro de un ciclo WHILE digamos por ahora donde su condición es que op no sea 5, esta ariable estará inicializada en -1 , valor que se cambiará al entrar al caso 5 y como en ese caso además del
			//msje no habra nada más entonces regresará a verificar su condición y no será cumplida.			

			cantidad=1;	//recuerda que esta va ligada al while que se encarga de agregar un número más cada vez que se mueva

				System.out.printf("\t\t\t          --2048---\n\t\t\t\t\t\t\t     Puntuacion: %d\n", sumaTotal);
				System.out.printf("\t   ");
				System.out.println("__________________________________________________\n");

			for(int filas=0; filas<4; filas++){//este es para mostrar los valores al arreglo, en este caso este es el que avanza por filas y el de abajo por columnas				
			
				System.out.printf("\t   |");

					for(int colum=0; colum<4; colum++){//
						
						System.out.printf("|%5d     |", arreglo[filas][colum]);				

					}//fin del for anidado para mostrarr las columnas

				System.out.printf("|\n");
				System.out.printf("\t   ");
				System.out.println("__________________________________________________");
				System.out.println("");
			}//fin del for exteriir

		//te hace falta incrutar el código para desplazarte y lo demás....

			if(coincidenciasY==0 && coincidenciasX==0 && contadorCeros==0){//esto es para cuando al llenar la cuadríaculas, de verdad ya no hay ninguna posiblidad de fusionar los números
						System.out.printf("\n\n\t\t\tLOSIENTO HAS PERDIDO EL JUEGO :(\n\n");
						System.out.printf("\t\t\t   Puntuación total alcanzada: %d\n\n\n", sumaTotal);
						acomodador(NUMEROS_JUG, nombre, gano);
						pressAnyKeyToContinue();

						continuar=0;				
					//Si tambipen debe aparecer las perdidas, entonces debo llamar aquí tambien al métod, solo que al que suma a las partidas perdidas
				}//fin del if que te dice que perdiste :(


			else{//este else nos demuestra que estos (sin tener nada especificado entre paréntesis), van a ejecutar el código, en cualquier version de la condición no cumplida, aunque la condición tuviera &&'s'

			//es que este while es para que continue en casi¿o de no escriba la direccion correcta	
			while(direccion.equals("nada")){//aquí no debo incluir la M, puesto que después de recibirla, en el switch, se llamará al menú terciario y luego asignará a op 0 o lo dejará en 1 y a direccion en M o en cualquier ptra que 
			//en la condición permita seguir usando dicho ciclo, como por eje nada 
			//CREO QUE EN LUGAR DE ESTAR PONIENDO TODOS LOS CASOS, SOLO DEBERÍA = LA VAR direccion al final del while a "nada", cuando ya se haya utilizado lo que se requiera, fuera del switch	


				System.out.printf("\nINGRESE LA DIRECCIÓN EN LA QUE DESEA MOVER TODOS LOS CUADROS: ");
				//entrada.nextLine(); recuerda que esto es para agarrar datos, cuando no lee porque hay uno por ahí volando
				dir = entrada.nextLine();
				direccion= dir.toLowerCase();
				System.out.println();
				pressAnyKeyToContinue();
				opMenu=0;
				//aquí iria un limpiador de pantalla
				
					switch(direccion){//vamos a ver si me puedo ahorrar el crear otra varibale al usar esta función junto con el eqquals, puesto que la primera solo funciona para la línea en 
					//la que se encuatra, si no hay varibale...aunque tendría que escribir mucho toLOwer case.. no, mejor creo la var, no habrá problema en que la condición emplee a la variable que guarda
					//lo reecibido originalemente en minus, puesto que está iniccializada en un valor que permite ejecutar el código		
						case "m":
							continuar=menuSecundario(continuar);
							if(continuar==1){
								
								opMenu=1;
								//direccion="nada";//mejor no lo pongo, así vuelve a visualizar el cuadro de antes por si acaso, se le olvidó, además si vas a incluir el limpiador, DEBE VOLVER A MOSTRARSE
							}
						break;		

						case "ab":

							if(coincidenciasY==0){
								System.out.printf("\n\n\t\t\tIntente con direcciones HORIZONTALES :)\n");
							}	

							else{
							  for(int columna=0;columna<4;columna++){//este es el código para hacer las sumas respectivas
							    	filaCambiante=2;
								    filaFija=3;

								    while(filaCambiante>=0 && filaFija>=1){
										if(arreglo[filaFija][columna]==0){
											filaFija--;
										//	filaCambiante--;
										}//esto es para evitar que haga sumas con parejas de 0's; comparaciones con 0  al menos teniendo a este en arreglo de filaFIja

										else{
											if(arreglo[filaFija][columna]==arreglo[filaCambiante][columna]){
												suma=arreglo[filaFija][columna]+arreglo[filaCambiante][columna];
												sumaTotal=sumaTotal+suma;
												arreglo[filaFija][columna]=suma;
												arreglo[filaCambiante][columna]=0;
												suma=0;
												filaFija--;
										//		filaCambiante--;
											}

											else if(arreglo[filaFija][columna]!=arreglo[filaCambiante][columna] &&  (arreglo[filaCambiante][columna]!=0)){//este es el que permite que se sumen los numeros separados por ceros
												filaFija--;//más que todo por la última condición
										//		if(filaFija==filaCambiante)
										//			filaCambiante--;

											}

										}//este ELSE se encarga de la suma, además de cambiar la ubicaion de filaFija para que se sumen numeros iguales que estan separados por 0

										filaCambiante--;

									}//fin del while que se encarga de mover entre filas en este caso, para app o no la suma 

								}


								for (int col=0; col<4; col++){//Esto es para aplicar la dir a cada columna, en este caso por ser hacia abajo el mov
									for(int fila=2; fila>=0; fila--){//esto para ubicarse en la fila desde la cual se comenzará a bajar el numero del arreglo, se comienza en 2 porque se numera de 0 1 3 y
										int filaUbic= fila +1;		 // el numero en la ultima ubicación, no tiene necesidad de bajarse, pues está en el tope, claro, si hubiera uno dif a cer, sino sería reemplazado
										//System.out.printf("\n%d", fila);//solo es para corroborar que fila no cambia de valor, asi como n1 y n2 no cambian de valor, sino solo la var que cambia el resul..NO CAMBIA!
											while(filaUbic < 4 && arreglo[filaUbic][col]==0){
												arreglo[filaUbic][col]=arreglo[filaUbic-1][col];//en esta y la fila de abajo sustituí a fila por filUBic-1 por el hecho de que así se podrá hacer cero(borrar al 
																							//numero de su posicion anterior, pues como antes lo tenia solo borraba al numero de su posicion original, mas no de
																							//las otras por las cuales pasó, entonces así no hay pierde en borrar dichos datos

												arreglo[filaUbic-1][col]=0;
												//System.out.printf("%d", filaUbic);//solo es para corroborar que no haya cambiado de valor, YIUP, no cambia de valor xD, recuerdo que solo lo hará si a esa misma var
												filaUbic++;//le asignas dicha alteración,pero como "nadie" la recibe, solo funciona para esa línea
											}//fin del while que se encarga de bajar el numero de la celda superior, sin importar si es cero o no, mientras no encuentre un tope
									}//fin del for que sube cada fila para ir bajando los numero de dicha columna
								}//fin del for que mnavega entre columnas

							}//fin del else de las coincidencias
						break;

						case "ar":
							if(coincidenciasY==0){
								System.out.printf("\n\n\t\t\tIntente con direcciones HORIZONTALES :)\n");
							}

							else{
								for(int columna=0;columna<4;columna++){//este es el código para hacer las sumas respectivas
									filaCambiante=1;
									filaFija=0;

									while(filaCambiante<4 && filaFija<3){
										if(arreglo[filaFija][columna]==0){
											filaFija++;
										//		filaCambiante++;
										}//esto es para evitar que haga sumas con parejas de 0's; comparaciones con 0  al menos teniendo a este en arreglo de filaFIja

										else{
											if(arreglo[filaFija][columna]==arreglo[filaCambiante][columna]){
												suma=arreglo[filaFija][columna]+arreglo[filaCambiante][columna];
												sumaTotal=sumaTotal+suma;
												arreglo[filaFija][columna]=suma;
												arreglo[filaCambiante][columna]=0;
												suma=0;
												filaFija++;
											//		filaCambiante++;
											}

											else if(arreglo[filaFija][columna]!=arreglo[filaCambiante][columna] &&  (arreglo[filaCambiante][columna]!=0)){//este es el que permite que se sumen los numeros separado
												filaFija++;//más que todo por la última condición
												//filaCambiante--;//esto lo acabo de poner pues, como abajo incrementa esta var, lo que sucedería es que no compararía con el valor de fila CAmb, el caul también hay que considerar
											//	if(filaCambiante==filaFija)
											//		filaCambiante++;

											}

										}//este ELSE se encarga de la suma, además de cambiar la ubicaion de filaFija para que se sumen numeros iguales que estan separados por 0

										filaCambiante++;

									}//fin del while que se encarga de mover entre filas en este caso, para app o no la suma 

								}


								for(int col=0; col<4;col++){
									for(int fila=1;fila<4;fila++){
										int filaUbic=fila-1;

										while(filaUbic>=0 &&arreglo[filaUbic][col]==0){
											arreglo[filaUbic][col]=arreglo[filaUbic+1][col];

											arreglo[filaUbic+1][col]=0;

											filaUbic--;//Esto es para seguir revisando e las filas de más arriba, por si acaso el numero está muy lejos del tope al que debe llegar
										}//fin del while

									}//fin del for que se encarga de escoger las filas para bajar los numeros

								}//fin del for navegador de columnas

							}//fin del else coincidenciasY	
						break;
						
						case "de":
							if(coincidenciasX==0){
								System.out.printf("\n\n\t\t\tIntente con direcciones VERTICALES :)\n");
							}

							else{
								for(int fila=0;fila<4;fila++){//este es el código para hacer las sumas respectivas
									columnaCambiante=2;
									columnaFija=3;

									while(columnaCambiante>=0 && columnaFija>=1){
										if(arreglo[fila][columnaFija]==0){
											columnaFija--;
											//columnaCambiante--;
										}//esto es para evitar que haga sumas con parejas de 0's; comparaciones con 0  al menos teniendo a este en arreglo de filaFIja

										else{
											if(arreglo[fila][columnaFija]==arreglo[fila][columnaCambiante]){
												suma=arreglo[fila][columnaFija]+arreglo[fila][columnaCambiante];
												sumaTotal=sumaTotal+suma;
												arreglo[fila][columnaFija]=suma;
												arreglo[fila][columnaCambiante]=0;
												suma=0;
												columnaFija--;
												//columnaCambiante--;//lo pongo así porque en estos bloques si o si, fila cambiante debe aumentar, a diferencia del else de abajito
											}

											else if(arreglo[fila][columnaFija]!=arreglo[fila][columnaCambiante] &&  (arreglo[fila][columnaCambiante]!=0)){//este es el que permite que se sumen los numeros separado
												columnaFija--;//más que todo por la última condición
												//if(columnaCambiante==columnaFija)
												//	columnaCambiante--;


											}

										}//este ELSE se encarga de la suma, además de cambiar la ubicaion de filaFija para que se sumen numeros iguales que estan separados por 0

										columnaCambiante--;//en este punto lo único que he heco es poner ubicación cambiante en cada bloque, para evitar que se salte la suma de numero al tenrlo aquí abajo y especiíficamente por el else de arribita

									}//fin del while que se encarga de mover entre filas en este caso, para app o no la suma 

								}

								//y este es el código para hacer el cambio de posiciones, según la dirección

															//como en este caso ya estamos en otra orientación, horizontal, será similar que para arriba, solo que con las varibales cambiadas, es decir ahora en el externo filas y en el	
								for(int fila=0; fila<4;fila++){//interno columnas, por el hecho de que la orientación cambio, pero con respecto a las movidas, será similar al positivo vert
									for(int col=2;col>=0;col--){
										int colUbic=col+1;

										while(colUbic<4 &&arreglo[fila][colUbic]==0){
											arreglo[fila][colUbic]=arreglo[fila][colUbic-1];

											arreglo[fila][colUbic-1]=0;

											colUbic++;
										}//fin del while

									}//fin del for que se encarga de escoger las filas para bajar los numeros

								}//fin del for navegador de columnas
							}//fin del else coincidenciasX	

						break;	

						case "iz"://en este caso, será similar a la versioón negativa de vert, porque izq y abajo, son "similares", al menos en su signo, como se hace normalmente

						if(coincidenciasX==0){
								System.out.printf("\n\n\t\t\tIntente con direcciones VERTICALES :)\n");
							}

							else{	

								for(int fila=0;fila<4;fila++){//este es el código para hacer las sumas respectivas
									columnaCambiante=1;
									columnaFija=0;

									while(columnaCambiante<4 && columnaFija<3){
										if(arreglo[fila][columnaFija]==0){
											columnaFija++;
										//	columnaCambiante++;
										}//esto es para evitar que haga sumas con parejas de 0's; comparaciones con 0  al menos teniendo a este en arreglo de filaFIja

										else{
											if(arreglo[fila][columnaFija]==arreglo[fila][columnaCambiante]){
												suma=arreglo[fila][columnaFija]+arreglo[fila][columnaCambiante];
												sumaTotal=sumaTotal+suma;
												arreglo[fila][columnaFija]=suma;
												arreglo[fila][columnaCambiante]=0;
												suma=0;
												columnaFija++;
										//		columnaCambiante++;
											}

											else if(arreglo[fila][columnaFija]!=arreglo[fila][columnaCambiante] &&  (arreglo[fila][columnaCambiante]!=0)){//este es el que permite que se sumen los numeros separado
												columnaFija++;//más que todo por la última condición
												//if(columnaFija==columnaCambiante)
													//columnaCambiante++;

											}

										}//este ELSE se encarga de la suma, además de cambiar la ubicaion de filaFija para que se sumen numeros iguales que estan separados por 0

										columnaCambiante++;

									}//fin del while que se encarga de mover entre filas en este caso, para app o no la suma 

								}

								for(int fila=0; fila<4;fila++){
									for(int col=1;col<4;col++){
										int colUbic=col-1;

										while(colUbic>=0 &&arreglo[fila][colUbic]==0){//recuerda que el while es el que revisa si los numeros de los espacios a los que se desea mover son 0's o no, para saber si
											arreglo[fila][colUbic]=arreglo[fila][colUbic+1];//cambiarlos de lugar o no

											arreglo[fila][colUbic+1]=0;

											colUbic--;
										}//fin del while

									}//fin del for que se encarga de escoger las filas para bajar los numeros

								}//fin del for navegador de columnas
							}//fin del else coincidenciasX	

						break;	

						default: 
							System.out.printf("\n\n->Debe ingresar cualquiera de las abreviaturas para cada dirección específica\n\n");
							direccion="nada";
					}//fin del switch					

			}//fin del while que compara dir's		


			//como en este caso el while que utiliza "nada" para funcionar está dentro del while que permite jugat, entonces no genrará problema que aquí se = a nada direccion, pues el grandote incumpliría con 1 condici+on, lo cual lo pararía
			//PERO PARA VEITAR QUE TRABAJE EN VANO cuando ya no quiera continuar, mejor pongo desde aquí hasta antes del elsote en un if donde compare si continuar==1;

			if(continuar==1){

			
				direccion="nada";//Esto es para que no tenga necesidad de poner todas las posib de dir en la condi del while que evalua la dir, y no da problema que esté aquí, pues ya opere con la direccion
						//y 	

				//paseré el contador para que el hwile a arriba se ejcute bien, pues como ahora liberé el estudio de las coincidencias, pusde darse el caso de que hayan 0 pero no coincidenica en X o Y, así
				//que si lo piensas bien, no lo debe ejecutar su coincidecias x y son 0 Y contadorCeros, también
				contadorCeros=0;

				for(int c=0; c<4;c++){//Esto lo realiza aunque no esté lleno el tablero, por eso si se debe hacer a countadorCeros =0 en algun punto donde no afecte el trabajo de este, para que no de más los resultdos
					for(int f=0; f<4; f++){//por haberse basado en algo anterior
						if(arreglo[f][c]==0){
							contadorCeros++;
						}

						if(arreglo[f][c]==2048){
							gano=1;

						//Aquí llamaré al método que suma las partidas ganadas
						}
					}//fin del for anidado
				}//for hallador de numeros en el arreglo

					if(contadorCeros!=0 && opMenu==0){//como depende del contadorCeros, entonces debe ir aquí porque sino aunque hayn ceros, pueden que no existan coincidencias y por eso siga que no hay aunque se haya agregado un npumeo que si permita combinar, o cuasulamente salga uno que no lo permita, por ello se debe clocar entre estos dos , para evitar esa situación
					while(cantidad<2){//este es para agregarle un número a cada movimiento
						numeroAleatorio=1+ aleatorio.nextInt(4);//RECUERDA QUE ESTAS VAR CON EL OBJ ALEATORIO DEBEN ESTAR DENTRO DE UN CICLO PARA QUE C/V generen un npumero nuevo, pues estas trabajan por ciiclos
						aleatorioFila=aleatorio.nextInt(4);//Esto será para asignar los valores a filas y columnas sin orden
						aleatorioCol=aleatorio.nextInt(4);

						if(arreglo[aleatorioFila][aleatorioCol]==0 && (numeroAleatorio%2==0)){//esto es para que asigne solo el numeros divisibles entre 2: 2 y 4, despues del primer tiro, pues en el primero,solo saca 2
																				     //si no lo quiere así, sino que saque dos numeros cualquiera al inicio (ya sea 2 o 4), entonces solo hay que ponerle otra vez 4
							arreglo[aleatorioFila][aleatorioCol]=numeroAleatorio;			//a la var Random, en lugar de igualarlo a 2.	  
							cantidad++;
						}				//por este if, no da problemas que ya no haya espacio, pues solo asigna si hay algun valor 0, por medio de una comprobación hecha la cantidad de veces que sea necesaria
					}//fin del while agregador

				}//din de este if esto es para que no se quede trabado aquí el código, además si una de las 2 es 0, indica que ya no cabe nada más


				//if(contadorCeros==0){//esto es para que ver si aunque haya llenado la cuadrícula, aún tiene oportunidad de seguir jugando porque hay coincidencias ya sean horiz o vert
				
					coincidenciasX=0;//aqui las volví cero, porque dependo de este valor para sabir si existen o no coincidencias
					coincidenciasY=0;//y con esto, estas variables, tendran el valor correspondiente a la entrada y organización del bloque actual, así que está bien porque en base a ella hay qye trabajar

					for(int col=0;col<4;col++){//en este caso no me importa hacia donde están, es decir en la forma en que se encuentran, pues solo importa que existan o no
						for(int f=1;f<4;f++){
							int fa= f-1;
								if(arreglo[f][col]==arreglo[fa][col]){
									coincidenciasY++;//recuerda que cuando exista una suma puedes hacer la var += el valor, para agregarle a lo que tenia otro valo, cuando es de incrementar, es mejor usar ++ o --
								}
						}

					}//fin del for exterior

				/*if(coincidenciasY==0){
					yaNoVert=1;
				}//Esto es para que no se trabe cuando ya no pueda sumar, porque por medio de esto colocaré un if y un else el switch para evaluar si hacer o no todo el código a aprtir de las sumas

				else{
					yaNoVert=0;
				}*/

					for(int fil=0; fil<4;fil++){
						for(int c=1;c<4;c++){
							int ca=c-1;
							if(arreglo[fil][c]==arreglo[fil][ca]){
								coincidenciasX++;
							}//fin del if
						}

					}//fin del for exterior		

				/*if(coincidenciasX==0){
					yaNoHoriz=1;
				}*/		

				
		//	}//fin del if que se encarga de ver las coincidencias posibles	//lo hice comentario, para que aun así evalúe si hay o no coincidencias auqneu hayan 0, puede darse el caso, la verda ajammm.

//			contadorCeros=0;

			}//fin del if que evita que trabaje en vano si continuar no es 1
			}//fin del elsote	
		}//fin del while que permite jugar

				if(gano==1){
				System.out.printf("\n\n\n\t\t\t\t¡FELICIDADES HAS GANADO EL JUEGO! : )\n\n");
				acomodador(NUMEROS_JUG, nombre, gano);
				pressAnyKeyToContinue();
				//poner el metodo que llama al menú principal -AQUI-
				}

      //DEBERÍA HABER UNA DIRECCION IGUALADA A "NADA" PARA QUE VUELVA A JUGAR CUANDO YA HAYA GANADO, pero mejor lo felicitas pones un sistem pause y lo llevas al menú principal, al igual que cuando pierde

	}//fin de juego 3



	

    static public int menuSecundario(int conti){//Al ser estatic su alcance no abarcará hacia abajo, sino solo hacia arriba
     		Scanner entrada = new Scanner(System.in);
     		int seraCorrecta=0;
     			
     			//aqui iria el limpiador
     		while(seraCorrecta==0){
     			System.out.println("\n\n\n\n\n\t\t\t\t---MENU de OPCIONES---\n");
     			System.out.println("\t\tIngrese el número de la opcion que desea ejecutar...");
     			System.out.println("\n\t\t1. Continuar\t\t\t0. salir\n");
     			conti=entrada.nextInt();

     			if(conti==1 || conti==0){
     				seraCorrecta=1;     			
     			}
     		}

     		return conti;

     			//pressAnyKeyToContinue();//recuerad que el orden en que se crean los métods, no afecta su alcance, pues el compilador, se encarga de buscarlos si en dado caso se le llamara antes de ser creado
     			//aquí iria otro limiador
     }//fin de menuSecundario

     static public void acomodador(int numeroJ, String nombre, int ganados){//este media vez es llamado, ejecuta su código, sin restricciones aqunque talvez si con "especialidades" xD
     	//EN ESTA PARTE me encargo de crear a las vars locales con los tamaños que las globales poseian antes, esto para que no se pierdan dichos datos
     		String nombreLocal[] =new String [numeroJug];//no habría problema que esteé este bloque aquí, puesto que no le asigna valores a las locales solo les crea su tamaño, lo cual es venvo pero por el momento esto evitará erroes, al querer usralas en otros bloques
     		int ganadasLocal[] =new int [numeroJug];//en este caso, como lo que quiero es que su tamaño se uno anterior al que tendrá, entonces es ideal usar numeroJUg, ya que este almacena los valores anteriores
     		int perdidasLocal [] =new int [numeroJug];//de ubicación antes de ser sumado con numeroJ
     		int tamActual=numeroJug;

     		if(llamadaTabla>0){	// pienseo que deberían ir aquí por lo mismo que el bloque de arriba, depende del tamaño anterior y así ya no necesitaría poner ala funcion length sino a numeroJug
     		for(int x=0; x<numeroJug; x++){
     			nombreLocal[x]=nombres[x];
     			ganadasLocal[x]=punteoG[x];
     			perdidasLocal[x]=punteoP[x];    			

     		}//fin del for que guarda los valores anteriores en las vars locales VER POR QUÉ ME DA ERROR CON EL LENGTH()     		

     	}//fin del if que se encarga de asignar a las var locales y a las globales, los valores anteriores

     		numeroJug+=numeroJ;//Esto es para que el string vaya creciendo confereme se agreguen más jugadores y así no haya un máximo de jugadores posibles de registrar
			nombres = new String [numeroJug];//el esar creando cada vez las variables, es lo que provoca que se hagan null los datos anteriores, eso quieres decir que tendrás que poner un límite de jugadores
			punteoP = new int[numeroJug];
			punteoG = new int[numeroJug]; 		

			if(llamadaTabla>0){
     			for(int y=0; y<tamActual; y++){//recuerda que cuando quieres saber el numero de filas que un arreglo tiene no debes poner el subíndice puesto que el # de ellos es el que queremos saber, en cambio si quisieramos # de columnas ahí sí, pues estas dependen de las filas
     				nombres[y]=nombreLocal[y];
     				punteoG[y]=ganadasLocal[y];
     				punteoP[y]=perdidasLocal[y];
     			}//fin del for que le asigna los valores anteriores para que después se agreguen los nuevos, es decir este evita la pérdida de información
     		}//fin del if que se encarga de pasar los valores de las locales a las globales     	

		if(ganados==0){//esto es para que se agregue al numero de partidas PERDIDAS
			for(int x=0; x<numeroJug; x++){

				if(punteoP[x]==0 && punteoG[x]==0){//este es para asignar en las posiciones VACIAS , los nombres NUEVOS, debo poner a ambas aunque sean de diferentes punteos, pero eso me asegurará que no hay ningun jugador ahí
					nombres[x]=nombre;
					punteoP[x]+=1;
					x=numeroJug;
					//si quiero quitar el null, tendría que restarle 1 al tamaño en este bloque PEROOO, terminaría borrando los datos al volver a crear la variable, así que no es solode restar, si quieres lo piensas después
					//debo hacer esto, puesto que los datos los recibe 1 por 1 y por eso, si ya cumplió su tarea con ese 1 etonces que termine el proceso, pues ya no hay nada más que hacer
				}//fin del if que se encarga de agregar los nombres nuevos en un espacio limpio

				else{
					if(nombres[x].equals(nombre)){//este if es que se encarga de ver si el espacio lleno, coincide con el nombre enviado, para agregarle los dato
						punteoP[x]+=1;
						x=numeroJug;
						//nombres = new String [numeroJug-1];//Esto er apara arreglar lo del null
//otra forma de hacerlo seria hacer de tamaño 1 cada arreglo y aquí verificar de primero si son iguales en la ubicacion x, esto lo buscarias por medio de un for que tenfria el tamño del arreglo, ya luego si esto es falso entonces, si le sumaria el valor de jugadores a su tamañao y haría lo que corresponde cunado no son iguales
					}//fin del if que verifica igualdad entre nombres	
				}//fin del else para cuando punteoP[x] está lleno

			}//fin del for
		}//fin del if

		else{
			for(int x=0; x<numeroJug; x++){

				if(punteoG[x]==0 && punteoP[x]==0){//este es para asignar en las posiciones VACIAS , los nombres NUEVOS
				nombres[x]=nombre;
				punteoG[x]+=ganados;
				x=numeroJug;
				}//fin del if que se encarga de agregar los nombres nuevos en un espacio limpio

				else{
					if(nombres[x].equals(nombre)){//este if es que se encarga de ver si el espacio lleno, coincide con el nombre enviado, para agregarle los dato
						punteoG[x]+= ganados;
						x=numeroJug;
					}//fin del if que verifica igualdad entre nombres	
				}//fin del else para cuando punteoG[x], está lleno
			}//fin del for			

		}//fin del else

		llamadaTabla++;//si porque media vez se le llamo, no tiene porque volver a cero
		System.out.printf("%s", llamadaTabla);
	 //si en todo caso quisiera hacer que contara el numero de partidas desertadas, tendŕía que crear uno similar al if de partidas PERDIDAS, pero en este caso ademas de ganados==0 debo agregar continuar==0

	}//FIN DEL METODO ACOMODADOR

	static public void tabla_Puntuaciones(){
		Scanner entrada=new Scanner(System.in);

		int seguir=-1;	

		while(seguir!=0){
			System.out.printf("\t\t\t   TABLA DE JUGADORES\n\n");
			System.out.printf("\tNombre jugador\t\t\t\t Numero de partidas\n");
			System.out.printf("\t\t\t\t\t   Ganadas\t\t  Perdidas\n");

			for(int y=0; y<numeroJug;y++){
				System.out.printf("%s%44d%22d\n", nombres[y], punteoG[y], punteoP[y]);
			}//fin del for

			System.out.printf("\n\n\n0.Salir");
			System.out.printf("\n\n->Ingrese 0 para retornar al menú principal: ");
			seguir=entrada.nextInt();

			if(seguir!=0){
				System.out.printf("\n\n\t\t\t\t\tSolo puede introducir 0");
			}//fin del if

			pressAnyKeyToContinue();
			//y luego el limpiador

		}//fin del while que mantiene ejecutandose mientras desee continuar

	}//fin de tabla_Puntuaciones
  
     static public void pressAnyKeyToContinue()//recuerda que no importa si en el métod que llamaste desde otra clase tien adentro otras llamadas de métods que se encentren o no en su clase, funcionará, puesto
      { 									  //que están relacionados
          String seguir;
          Scanner teclado = new Scanner(System.in);
          System.out.println("Presione ENTER para continuar...");
          try
            {
             seguir = teclado.nextLine();
            }   
         catch(Exception e)//Esta excepcion lo que hace es que se siga ejecutando aunque cometa algun error el usuaruo
          {}  
     }//ya no es necesario que cada juego lo incluya



}//fin de la clase LJI1A