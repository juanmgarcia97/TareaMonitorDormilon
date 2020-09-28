package solucion;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Monitor extends Thread{

	private Semaphore atendiendo;
	private SalaEspera sala;
	private Random rnd;

	public Monitor(SalaEspera sala, long rnd) {
		super();
		atendiendo = new Semaphore(1);
		this.sala = sala;
		this.rnd = new Random(rnd);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				if (sala.getEstudiantes().size() > 0) {
					atendiendo.acquire();
					sleep(Math.abs(rnd.nextInt(10000)));
					String est = sala.atenderEstudiante();
					System.out.println("El monitor está atendiendo a " + est);
					atendiendo.release();
				} else {
					sleep(Math.abs(rnd.nextInt(10000)));
					System.out.println("El monitor se echará una siesta");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
