package solucion;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class SalaEspera {

	private Semaphore sala;

	private PriorityQueue<String> estudiantes;

	public SalaEspera() {
		sala = new Semaphore(1);
		estudiantes = new PriorityQueue<String>();
	}

	public void estudianteEntra(String nombre) {
		try {
			sala.acquire();
			estudiantes.add(nombre);
			System.out.println(nombre + " ha entrado a la sala de espera.");
			sala.release();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String atenderEstudiante() {
		try {
			if (estudiantes.size() > 0) {
				sala.acquire();
				String est = estudiantes.poll();
				System.out.println(est + " está siendo atendido por el monitor.");
				sala.release();
				return est;
			}
			return "";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	public PriorityQueue<String> getEstudiantes() {
		return estudiantes;
	}

}
