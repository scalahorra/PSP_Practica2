package src;

public class Productor extends Thread{

	public int productores = 0;
	private Monitor monitor;

	public Productor(int productores, Monitor monitor) {
		this.productores = productores;
		this.monitor = monitor;
	}

	public void run() {
		int idProductor = 1;
		while (idProductor < productores) {
			monitor.añadirProducto(idProductor);
			idProductor++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
