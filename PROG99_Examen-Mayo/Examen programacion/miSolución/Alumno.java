import java.util.ArrayList;

public class Alumno {
    public int codigoAlumno;
    public String codigoModulo; //Modulo en el que está matriculado
    public ArrayList<Trabajo> listaTrabajos;

    public Alumno(int codigoAlumno, String codigoModulo, ArrayList<Trabajo> listaTrabajos) {
        this.codigoAlumno = codigoAlumno;
        this.codigoModulo = codigoModulo;
        this.listaTrabajos = listaTrabajos;
    }
}
