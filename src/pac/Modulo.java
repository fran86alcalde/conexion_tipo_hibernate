package pac;

import java.util.HashSet;
import java.util.Set;

public class Modulo {
    private long id;
    private String nombre;
    private String codigo;
    private Set<Alumno> Alumnos=new HashSet<Alumno>();

    public Modulo(){}

    public Set<Alumno> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        Alumnos = alumnos;
    }

    public Modulo(long id, String nombre, String codigo) {
        super();
        this.id=id;
        this.nombre=nombre;
        this.codigo=codigo;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "insert into modulo, nombre: " + nombre + ", codigo: " + codigo;
    }
}

