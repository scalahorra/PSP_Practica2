package src;

public class Consumidor extends Thread{

	public int consumidores = 0;
	private Monitor monitor;

	public Consumidor(int consumidores, Monitor monitor) {
		this.consumidores = consumidores;
		this.monitor = monitor;
	}

	public void run() {
        int idConsumidor = 1;
        while (idConsumidor < consumidores) {
             if (monitor.consumirProducto(idConsumidor)) {
                idConsumidor++;
            }
            try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}
