public class Mascota {
    public int edad;
    public String nombre;

    public Mascota(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Mascota setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Mascota setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
