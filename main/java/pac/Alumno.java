package pac;

import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

public class Alumno implements Serializable {

    private long id;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String sexo;
    private Set<Modulo>Modulos=new HashSet<Modulo>();

    public Alumno() {
    }

    public Alumno(String nombre, String nacionalidad, int edad, String sexo, String codigo) {
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.edad=edad;
        this.sexo=sexo;

    }

    public Set<Modulo> getModulos() {
        return Modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        Modulos = modulos;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        int num_modulos = 0;
        if(this.getModulos() != null){
            num_modulos = this.getModulos().size();
        }
        return "insert into alumno, nombre: " + nombre + ", nacionalidad: " + nacionalidad + ", edad: " + edad + ", sexo: " + sexo + ", módulos: " + num_modulos;

    }

}

