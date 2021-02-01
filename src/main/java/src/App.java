package src;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		//Creamos todo lo que vamos a necesitar 
		ArrayList<Integer> array = new ArrayList<Integer>();
		Monitor monitor = new Monitor(array);
		Productor productor = new Productor(30, monitor);
		Consumidor consumidor = new Consumidor(30, monitor);

		productor.start();
		consumidor.start();
		
		//Cuando mueran los 2 hilos, saldrá un mensaje con lo que se ha quedado en la cola
		try {
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.imprimir();

	}
}
