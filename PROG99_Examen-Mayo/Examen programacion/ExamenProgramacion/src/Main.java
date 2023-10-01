import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		App app = new App();
		ArrayList<Mascota> mascotas = new ArrayList<>();
		Mascota perro = new Perro(20, "toby", false);
		Mascota gato = new Gato(20, "gato", true);
		mascotas.add(perro);
		mascotas.add(gato);
		System.out.println(app.mayorEdad(mascotas));
		int[] v = {3,5,2,3,7,4,5};

		System.out.println("La media es " + app.mediaImparesDesdePrimerPar(v));
		int[] n = {2, 2, 5, 5, 5, 5 ,5, 4, 4};
		System.out.println(app.secuenciaMayor(n));

		int i, j;

		int[][] matriz = {{3, 2, 7}, {4, 1, 1}, {4, 1, 2}, {2, 0, 3}};

		int[] result = app.sumaColumnasMatriz(matriz);
		for (int z = 0; z < result.length; z++) {
			//			System.out.println(result[z]);
		}

		app.SqlToCsv("select * from modulos", "notas.csv");
		ArrayList<Trabajo> trabajoList = new ArrayList<>();
		trabajoList.add(new Trabajo("1", 9));
		trabajoList.add(new Trabajo("2", 9.5));
		trabajoList.add(new Trabajo("3", 9.75));
		trabajoList.add(new Trabajo("4", 9));
		Alumno alumno = new Alumno(501, "SI", trabajoList);
		app.insertaMediaTrabajos(alumno);
	}

}
