package src;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Monitor {

	ArrayList<Integer> monitor = new ArrayList<Integer>();
	
	public Monitor(ArrayList<Integer> numeros) {
		super();
		this.monitor = numeros;
	}
	
	//Generamos el producto
	public synchronized boolean añadirProducto(int idProductor) {
		if (monitor.size() == 10) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int random = ThreadLocalRandom.current().nextInt(0, 100);
		monitor.add(random);
		System.out.println("El productor "+idProductor+" produce "+random+" unidades");
		notify();
		return true;
	}
	
	//Consumimos el producto
	public synchronized boolean consumirProducto(int idConsumidor) {

		if (!monitor.isEmpty()) {
			int random = monitor.remove(monitor.size() - 1);
			System.out.println("El consumidor "+idConsumidor+" consume "+random+" unidades");
			notify();
			return true;
		}
		return false;

	}
	
	//Imprimimos cuánto queda en el valor
	public void imprimir() {
		System.out.print("[");
		for (int i = 0; i < monitor.size(); i++) {
			System.out.println(monitor.get(i) + " ");
		}
		System.out.print("]");
	}
}
