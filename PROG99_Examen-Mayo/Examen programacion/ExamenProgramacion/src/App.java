import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App implements ExamenProgramacion {

	@Override
	public int[] sumaColumnasMatriz(int[][] m) {
		int i, j, sumaFila = 0;
		int[] resultado = new int[m.length];
		for (i = 0; i < m.length; i++) {
			for (j = 0; j < m[i].length; j++) {
				sumaFila += m[i][j];
			}
			resultado[i] = sumaFila;
			sumaFila = 0;
		}
		return resultado;
	}

	@Override
	public void SqlToCsv(String sql, String fichero) {
		try {
			BD instance = BD.getInstance();
			ResultSet resultSet = instance.consultaBD(sql);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int numeroColumnas = rsmd.getColumnCount();
			String[] datos = new String[numeroColumnas];
			while (resultSet.next()) {
				for (int i = 1; i < numeroColumnas - 1; i++) {
					datos[i] = String.format("%s%s", resultSet.getString(i), ";");
				}
			}
			instance.cerrarConsulta();
			try (ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero))) {
				ficheroSalida.writeObject(datos);
				ficheroSalida.flush();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertaMediaTrabajos(Alumno a) {
		if (a.listaTrabajos == null) {
			a.listaTrabajos = new ArrayList<>();
		}
		double mediaNotas = a.listaTrabajos.stream()
										   .mapToDouble(Trabajo::getNota)
										   .average()
										   .orElse(0d);
		BD instance = BD.getInstance();
		try {

			instance.consultaBD(String.format("insert into NOTAS (COD_MODULO, COD_ALUMNO, NOTA_FINAL)values ('%s', %s, %s )",
											  a.codigoModulo,
											  a.codigoAlumno, mediaNotas));
			instance.cerrarConsulta();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a.getListaTrabajos().size();
	}

	@Override
	public int secuenciaMayor(int[] v) {
		int contador = 0;
		int contador2 = 0;
		for (int i = 0; i < v.length - 1; i++) {
			if (v[i] == v[i + 1] && contador <= contador2) {
				contador++;
			} else if (v[i] == v[i + 1]) {
				contador2++;
				contador = contador2 + 1;
			}
		}
		if (contador2 + 1 >= contador) {
			return contador2;
		} else {
			return contador;
		}
	}

	@Override
	public int mediaImparesDesdePrimerPar(int[] v) {
		double media = 0.0;
		int contador = 0;
		int posicion = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i] % 2 == 0) {
				posicion = i;
				break;
			}
		}
		for (int j = posicion; j < v.length; j++) {
			if (v[j] % 2 != 0) {
				media += v[j];
				contador++;
			}
		}
		return (int) media / contador;
	}

	@Override
	public String mayorEdad(ArrayList<Mascota> mascotas) {
		if (mascotas == null || mascotas.isEmpty()) {
			throw new IllegalArgumentException("La lista no puede estar vacía ni ser nula");
		}

		List<Mascota> mascotaFiltered = new ArrayList<>();
		for (Mascota mascota : mascotas) {
			if (mascota instanceof Gato &&  ((Gato) mascota).estaMaullando) {
				mascotaFiltered.add(mascota);
			}
			if (mascota instanceof Perro && ((Perro) mascota).estaLadrando) {
				mascotaFiltered.add(mascota);
			}
		}

		Mascota mascotaVieja = mascotaFiltered.stream()
									   .max(Comparator.comparing(Mascota::getEdad))
									   .orElse(null);

		return mascotaVieja.getNombre();
	}
}
