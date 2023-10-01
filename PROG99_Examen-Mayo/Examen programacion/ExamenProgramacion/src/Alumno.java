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

    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public Alumno setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
        return this;
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public Alumno setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
        return this;
    }

    public ArrayList<Trabajo> getListaTrabajos() {
        return listaTrabajos;
    }

    public Alumno setListaTrabajos(ArrayList<Trabajo> listaTrabajos) {
        this.listaTrabajos = listaTrabajos;
        return this;
    }
}
