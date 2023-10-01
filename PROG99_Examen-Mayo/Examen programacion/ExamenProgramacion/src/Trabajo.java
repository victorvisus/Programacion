public class Trabajo {
    public String nombreTrabajo;
    public double nota;

    public Trabajo(String nombreTrabajo, double nota) {
        this.nombreTrabajo = nombreTrabajo;
        this.nota = nota;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public Trabajo setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
        return this;
    }

    public double getNota() {
        return nota;
    }

    public Trabajo setNota(double nota) {
        this.nota = nota;
        return this;
    }
}
