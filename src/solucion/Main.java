package solucion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long rnd = 10000;
		SalaEspera sala = new SalaEspera();
		int cantidadEstudiantes = 6;
		Estudiante[] estudiantes = new Estudiante[cantidadEstudiantes];

		Monitor monitor = new Monitor(sala, rnd);
		monitor.start();
		
		for (int i = 0; i < cantidadEstudiantes; i++) {
			estudiantes[i] = new Estudiante(sala, "Estudiante " + i, rnd);
			estudiantes[i].start();
		}

		
	}

}
