package solucion;

import java.util.Random;

public class Estudiante extends Thread {

	private String nombre;
	private SalaEspera sala;
	private Random rnd;

	public Estudiante(SalaEspera sala, String nombre, long rnd) {
		super();
		this.sala = sala;
		this.nombre = nombre;
		this.rnd = new Random(rnd);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				if (sala.getEstudiantes().size() < 3) {
					System.out.println("El estudiante " + nombre + " está esperando en la sala.");
					sala.estudianteEntra(nombre);
				} else {
					System.out.println(nombre + " se va de la sala porque está llena.");
					sleep(Math.abs(rnd.nextInt(10000)));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
