package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugadores extends  Persona{
    private int Elo,Edad;

// region Constructor Lista TOSTRING(datos)

    public static ArrayList<Jugadores> listaJugadores = new ArrayList<>();
    public Jugadores( String nombre, String apellido, String pais, int partidos, int elo, int edad) {
        super(nombre, apellido, pais, partidos);
        Elo = elo;
        Edad = edad;
    }
    public  void  datos() {
        System.out.println("Jugadores{" +
                "id=" + this.getId() +
                ", Nombre='" + this.getNombre() + '\'' +
                ", Apellido='" + this.getApellido() + '\'' +
                ", Edad=" + Edad +
                ", Pais='" + this.getPais() + '\'' +
                ", Partidos='" + this.getPartidos() + '\'' +
                ", Elo=" + Elo +

                '}');
    }

// endregion

    // region METODOS



    public static void verPagos() {
        System.out.println("--------------------- PAGOS A JUGADORES --------------------------------------");
        for (Jugadores elPlayer:listaJugadores){
            String Nombre = elPlayer.getNombre();
            String Apellido = elPlayer.getApellido();

            int partidosJugados = elPlayer.getPartidos();
            int pagoAJugadores= 600;
            int PagoTotal = pagoAJugadores * partidosJugados;
            System.out.println(Nombre +" " + Apellido +": Partidos Jugados: "+partidosJugados +"  ---- TOTAL: $"+PagoTotal);
        }
    }

    public static void altaJugador(){
        Scanner scanner = new Scanner(System.in);
        Scanner enteros = new Scanner(System.in);
        try {
            System.out.println("------- DATOS DE INGRESO DE JUAGDOR -------");
            System.out.println("Ingrese Nombre: ");
            String pNombre = scanner.nextLine();
            System.out.println("Ingrese Apellido: ");
            String pApellido = scanner.nextLine();
            System.out.println("Ingrese Edad: ");
            int pEdad = enteros.nextInt();
            System.out.println("Ingrese Pais: ");
            String pPais = scanner.nextLine();
            System.out.println("Ingrese Elo: ");
            int pElo = enteros.nextInt();
            System.out.println("Ingrese Partidos Jugados: ");
            int pPartidos = enteros.nextInt();
            Jugadores elPlayer = new Jugadores(pNombre,pApellido,pPais,pPartidos,pElo,pEdad);
            listaJugadores.add(elPlayer);
            listaPersonas.add(elPlayer);
            System.out.println("Jugador "+ pNombre + " " + pApellido +" Ingresado Con Exito");
        }catch (Exception e){
            System.out.println(e);
        }




    }

public static boolean jugoPartida(int id){

        for (Partida laPartida:Partida.listaPartidas){
            if (laPartida.getJugador1().getId() == id || laPartida.getJugador2().getId() == id){
                return true;
            }
        }
        return false;

}
    public  static void bajaJugador(){
        Scanner scanner = new Scanner(System.in);
        verListaDeJugadores();
        System.out.println("Ingrese Id de Jugador a Eliminar");
        int elId = scanner.nextInt();
        try {
            for (Jugadores elPlayer:listaJugadores){
                if (elPlayer.getId() == elId){
                   boolean jugo = jugoPartida(elId);
                   if (jugo){
                       System.out.println("NO SE PUEDE ELIMINAR UN JUGADOR CON REGISTROS DE PARTIDAS");
                       return;
                   }
                   else {
                       listaJugadores.remove(elPlayer);

                       System.out.println("Jugador " + elPlayer.getNombre()+" " + elPlayer.getApellido() +" ha sido Eliminado");
                       return;
                   }
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void updateJugador(){
        Scanner scanner  = new Scanner(System.in);
        Scanner enteros  = new Scanner(System.in);
        verListaDeJugadores();
        System.out.println("Ingrese Id de Jugador a Modificar: ");
        int elId = enteros.nextInt();
        for (Jugadores elPlayer:listaJugadores){
            if (elId == elPlayer.getId()){
                try {
                    System.out.println("------- DATOS DE MODIFICACION DE JUAGDOR -------");
                    System.out.println("Ingrese Nombre: ");
                    String pNombre = scanner.nextLine();
                    System.out.println("Ingrese Apellido: ");
                    String pApellido = scanner.nextLine();
                    System.out.println("Ingrese Edad: ");
                    int pEdad = enteros.nextInt();
                    System.out.println("Ingrese Pais: ");
                    String pPais = scanner.nextLine();
                    System.out.println("Ingrese Elo: ");
                    int pElo = enteros.nextInt();
                    System.out.println("Ingrese Partidos Jugados : ");
                    int pPartidos = enteros.nextInt();
                    elPlayer.setNombre(pNombre);
                    elPlayer.setApellido(pApellido);
                    elPlayer.setEdad(pEdad);
                    elPlayer.setPais(pPais);
                    elPlayer.setElo(pElo);
                    elPlayer.setPartidos(pPartidos);
                    System.out.println("Jugador Modificado Con Exito");
                    return;
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        }



    }

    public static void verListaDeJugadores(){

        if (listaJugadores.isEmpty()){
            System.out.println("NO HAY JUGADORES INSCRIPTOS AUN");
            return;
        }

        System.out.println("--------------------------  LISTA DE JUGADORES -------------------------------------");
        for (Jugadores elPlayer:listaJugadores){
            elPlayer.datos();
        }
    }

    // endregion

    // region GET Y SETERS
    public int getElo() {
        return Elo;
    }

    public void setElo(int elo) {
        Elo = elo;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
    // endregion
}
