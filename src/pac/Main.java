package pac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("INICIO DEL PROGRAMA...");

        //Para indicar que queremos usar Hibernate definimos las interfaces
        Configuration cfg =new Configuration().configure();
        //instancia de sessionFactory en nuestra sesión
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        System.out.println("conexion establecida");

        //Para insertar datos en la BD vamos a usar transactions
        Transaction tx = session.beginTransaction();

        Modulo m1 = new Modulo();
        m1.setNombre("Programacion B");
        m1.setCodigo("M03B");
        System.out.println(m1);

        Modulo m2 = new Modulo();
        m2.setNombre("Acceso a datos");
        m2.setCodigo("M06");
        System.out.println(m2);

        Modulo m3 = new Modulo();
        m3.setNombre("Desarrollo de aplicaciones moviles");
        m3.setCodigo("M08");
        System.out.println(m3);

        Modulo m4 = new Modulo();
        m4.setNombre("Servicios y procesos");
        m4.setCodigo("M09");
        System.out.println(m4);

        Profesor b = new Profesor();
        b.setNombre("Alvaro");
        b.setSexo("Hombre");
        System.out.println(b);


        Alumno a1 = new Alumno();
        a1.setNombre("Juan");
        a1.setNacionalidad("Espaniola");
        a1.setEdad(26);
        a1.setSexo("Hombre");
        a1.setModulos(new HashSet<Modulo>());
        a1.getModulos().addAll(Arrays.asList(m1,m2,m3,m4));
        System.out.println(a1);

        Alumno a2 = new Alumno();
        a2.setNombre("Pedro");
        a2.setNacionalidad("Andorrana");
        a2.setEdad(21);
        a2.setSexo("Hombre");
        a2.setModulos(new HashSet<Modulo>());
        a2.getModulos().addAll(Arrays.asList(m1,m2,m4));
        System.out.println(a2);

        Alumno a3 = new Alumno();
        a3.setNombre("Marta");
        a3.setNacionalidad("Espaniola");
        a3.setEdad(19);
        a3.setSexo("Mujer");
        a3.setModulos(new HashSet<Modulo>());
        a3.getModulos().addAll(Arrays.asList(m3,m4));
        System.out.println(a3);

        Alumno a4 = new Alumno();
        a4.setNombre("Carla");
        a4.setNacionalidad("Francesa");
        a4.setEdad(35);
        a4.setSexo("Mujer");
        a4.setModulos(new HashSet<Modulo>());
        a4.getModulos().addAll(Arrays.asList(m2,m3,m4));
        System.out.println(a4);




        //Relaciones



        m1.setAlumnos(new HashSet<Alumno>());
        m1.getAlumnos().addAll(Arrays.asList(a1,a2));
        m2.setAlumnos(new HashSet<Alumno>());
        m2.getAlumnos().addAll(Arrays.asList(a1,a2,a4));
        m3.setAlumnos(new HashSet<Alumno>());
        m3.getAlumnos().addAll(Arrays.asList(a1,a3,a4));
        m4.setAlumnos(new HashSet<Alumno>());
        m4.getAlumnos().addAll(Arrays.asList(a1,a2,a3,a4));




        session.save(b);
        session.save(a1);
        session.save(a2);
        session.save(a3);
        session.save(a4);


        tx.commit(); //Hacemos el commit de la transacción y habremos insertado
        // los datos del primer registro de alumno



        session.close();
        sessionFactory.close();

    }
}
