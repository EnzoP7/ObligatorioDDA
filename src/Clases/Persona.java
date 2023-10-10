package Clases;


import java.util.ArrayList;

public class Persona {
    private int id,Partidos;
    private String Nombre,Apellido,Pais;



    // region CONSTRUCTOR LISTA TOSTRING

    public static ArrayList<Persona> listaPersonas = new ArrayList<>();
    public Persona( String nombre, String apellido, String pais,int partidos) {
        this.id = generadorDeId();
        Nombre = nombre;
        Apellido = apellido;
        Pais = pais;
        this.Partidos = partidos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Pais='" + Pais + '\'' +
                ", Partidos='" + Partidos + '\'' +
                '}';
    }


    // endregion

    // region METODOS
    public static void verPagos(){
        System.out.println(" ");
    }
    public int generadorDeId(){
        return listaPersonas.size()+1;
    }


    // endregion

    // region GET Y SETERS
    public int getId() {
        return id;
    }

    public int getPartidos() {
        return Partidos;
    }

    public void setPartidos(int partidos) {
        Partidos = partidos;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    //endregion
}
