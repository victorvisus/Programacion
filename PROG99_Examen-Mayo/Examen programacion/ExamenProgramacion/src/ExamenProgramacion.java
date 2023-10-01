import java.util.ArrayList;

public interface ExamenProgramacion {
    public int [] sumaColumnasMatriz(int m[][]);
    public void SqlToCsv(String sql, String fichero);
    public int insertaMediaTrabajos(Alumno a);
    public int secuenciaMayor(int[] v);
    public int mediaImparesDesdePrimerPar(int[] v);
    public String mayorEdad(ArrayList<Mascota> mascotas);
}
