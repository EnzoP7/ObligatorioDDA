package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Partida {

    private int id,tipoPartida;
    private Jugadores jugador1,jugador2,ganador;
    private Arbitro arbitro;
    private String fecha;


    // region CONSTRUCTOR , LISTA  Y TOSTRING
    public static ArrayList<Partida> listaPartidas = new ArrayList<>();
    public Partida( Jugadores jugador1, Jugadores jugador2, Arbitro arbitro, String fecha, int tipoPartida,Jugadores ganador) {
        this.id = generarId();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.tipoPartida = tipoPartida;
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", jugador1=" + jugador1.getNombre() +" "+jugador1.getApellido() +
                ", jugador2=" + jugador2.getNombre() +" "+jugador2.getApellido()+
                ", arbitro=" +arbitro.getNombre() +" "+arbitro.getApellido() +
                ", fecha=" + fecha +
                ", tipoPartida=" + tipoPartida(tipoPartida) +
                ", Ganador=" + ganador.getNombre()+" "+ganador.getApellido()  +
                '}';
    }
// endregion

    // region METODOS
    public static int generarId(){
        return listaPartidas.size()+1;
    }
    public static Jugadores seleccionarJugador(){
        Scanner scanner = new Scanner(System.in);
        for (Jugadores elPlayer:Jugadores.listaJugadores){
            System.out.println("Id: "+elPlayer.getId() + ", Nombre: "+elPlayer.getNombre() +" "+ elPlayer.getApellido());
        }
        System.out.println("Seleccione Id del Jugador  ");
        int idJugador = scanner.nextInt();
        for (Jugadores elPlayer:Jugadores.listaJugadores){
            if (idJugador == elPlayer.getId()){
                return elPlayer;
            }
        }
        return null;
    }

    public static void verPartidasDeUnaFecha(){
        Scanner scanner = new Scanner(System.in);

        verListaDePartidas();
        System.out.println("Ingrese Fecha de Partida");
        String fecha = scanner.nextLine();
        Boolean encontrada = false;

        System.out.println("------------------- PARTIDAS CON FECHA "+fecha +" ---------------------------------");
        for (Partida laPartida:listaPartidas){
            if (Objects.equals(laPartida.getFecha(), fecha)){
                System.out.println(laPartida.toString());
                encontrada = true;
            }
        }
        if (!encontrada){
            System.out.println("No se encontraron partidas con la fecha "+fecha);
        }
    }

    public  static  void verPartidasDeJugador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------  VER PARTIDAS DE JUGADOR -----------------------------------------------------");

        Jugadores.verListaDeJugadores();
        System.out.println("Ingrese Id de Jugador:");
        try {
            int pId = scanner.nextInt();
            boolean encontrada = false;
            for (Partida laPartida:listaPartidas){
                String nombre = laPartida.getJugador1().getNombre();
                String apellido = laPartida.getJugador1().getApellido();



                if (laPartida.getJugador1().getId() == pId){
                    System.out.println("------------------------------------------  PARTIDAS DE JUGADOR "+ nombre +" "+ apellido + " -----------------------------------------------------");
                    System.out.println("Como Jugador 1:");
                    System.out.println(laPartida.toString());
                    encontrada = true;
                }
                if (laPartida.getJugador2().getId()==pId){
                    System.out.println("Como jugador 2");
                    System.out.println(laPartida.toString());
                    encontrada = true;

                }
            }
            if (!encontrada){
                System.out.println("No se encontraron Registros de Partida con este Jugador");
            }

        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static Arbitro seleccionarArbitro(){
        Scanner scanner = new Scanner(System.in);
        for (Arbitro elArbitro:Arbitro.listaArbitros){
            System.out.println("Id: "+elArbitro.getId() + ", Nombre: "+elArbitro.getNombre() + elArbitro.getApellido());
        }
        System.out.println("Seleccione Id del Arbitro  ");
        int idArbitro = scanner.nextInt();
        for (Arbitro elArbitro:Arbitro.listaArbitros){
            if (idArbitro == elArbitro.getId()){
                return elArbitro;
            }
        }
        return null;
    }


    public static String tipoPartida(int laPartida){
        switch (laPartida){
            case 1:return "Regional";

            case 2:return "Nacional";

            case 3:return "Internacional";
            default:
                return "Desconocido";
        }

    }
    public static int seleccionarTipoPartida(){
        Scanner elEntero = new Scanner(System.in);
        System.out.println("----------- TIPO PARTIDA ----------------------");
        System.out.println("1 Regional ----------   2 Nacional  ----------- 3 Internacional");
        int tipo = elEntero.nextInt();
        return tipo;

    }

    public static Jugadores elGanador(Jugadores jugador1,Jugadores jugador2){
        Scanner elScaner = new Scanner(System.in);
        System.out.println("Selecciona que Jugador Gano, Ingresa 1 o 2");
        System.out.println("Jugador 1 : "+jugador1.getNombre() + " " +jugador1.getApellido());
        System.out.println("Jugador 2 : "+jugador2.getNombre() + " " +jugador2.getApellido());
        int decision = elScaner.nextInt();
        if (decision == 1) return jugador1;
        else return  jugador2;


    }



    public static boolean validarPartida(Partida laPartida){

        int tipoPartida = laPartida.tipoPartida;
        switch (tipoPartida){
            case 2:
                if (laPartida.arbitro.getNivelDeCertificacion() == 1){
                    System.out.println("Los Arbitros con Certificacion 1 No Pueden Arbitrar Partdas regionales");
                    return false;
                }
                break;
            case 3:{
                if (laPartida.arbitro.getNivelDeCertificacion() != 3){
                    System.out.println("Solo Arbitros con Certificación Nivel 3 Pueden Arbitrar Partidas Internacionales");
                    return false;

                }
                break;
            }

        }
        if (laPartida.jugador1 == laPartida.jugador2) return false;
        return true;



    }


    public  static  Partida buscarPartida(int pid){
        for (Partida laPartida:listaPartidas){
            if (laPartida.getId()== pid){

                return laPartida;
            }

        }
        return null;
    }

    public static void verListaDePartidas(){
        if (listaPartidas.isEmpty()){
            System.out.println("NO HAY NINGUNA PARTIDA REGISTRADA");
            return;
        }
        else {
            try {
                System.out.println("----------------------- LISTA DE PARTIDAS ----------------------");
                for (Partida laPartida:listaPartidas){
                    System.out.println(laPartida.toString());
                }
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    //endregion

    // region ALTA Y MODIFICAR
    public static void altaPartida(){

        if (Jugadores.listaJugadores.size() < 2 || Arbitro.listaArbitros.isEmpty()){

           System.out.println("NO HAY JUGADORES/ARBITROS SUFICIENTES");
           return;

        }else {
            try {

                Scanner elEntero = new Scanner(System.in);
        System.out.println("----------------- Ingresar Datos de Partida------------------");
        System.out.println("Seleccione Jugador 1: ");
        Jugadores elPlayer =seleccionarJugador();
        System.out.println("Seleccione Jugador 2: ");
        Jugadores elPlayer2 =seleccionarJugador();
        Arbitro elArbitro = seleccionarArbitro();
                System.out.println("INGRESE FECHA:");
                String fecha = elEntero.nextLine();
                int tipoPartida =seleccionarTipoPartida();
                assert elPlayer != null;
                assert elPlayer2 != null;
                Jugadores ganador = elGanador(elPlayer,elPlayer2);
                Partida laPartida = new Partida(elPlayer,elPlayer2,elArbitro,fecha,tipoPartida,ganador);
                boolean valida = validarPartida(laPartida);
                if (valida){
                    listaPartidas.add(laPartida);
                    System.out.println("La Partida ha sido Registrada Con Exito");
                }else {
                    System.out.println("HUBO UN ERROR");
                    return;
                }

                Jugadores perdedor = (ganador == elPlayer) ? elPlayer2 : elPlayer;
                int eloGanador = ganador.getElo();
                int eloPerdedor = perdedor.getElo();
                String NombreGanador = ganador.getNombre() + " " + ganador.getApellido();
                String NombrePerdedor = perdedor.getNombre() + " " + perdedor.getApellido();
                if (eloGanador<eloPerdedor){
                    int diferencia = eloPerdedor - eloGanador;
                    int Puntos = diferencia / 4;
                    ganador.setElo(eloGanador + Puntos);
                    perdedor.setElo(eloPerdedor - Puntos);
                    ganador.setPartidos(ganador.getPartidos() + 1);
                    perdedor.setPartidos(perdedor.getPartidos() + 1);
                    System.out.println(NombreGanador + " GANA "+Puntos + " Puntos ----------  "+NombrePerdedor + " Pierde "+Puntos+" Puntos");

                }
                else {
                    int diferencia = eloGanador -eloPerdedor ;
                    int Puntos = diferencia / 8 ;
                    ganador.setElo(eloGanador + Puntos);
                    perdedor.setElo(eloPerdedor - Puntos);
                    ganador.setPartidos(ganador.getPartidos() + 1);
                    ganador.setPartidos(perdedor.getPartidos() + 1);
                    System.out.println(NombreGanador + " GANA "+Puntos + " Puntos ----------  "+NombrePerdedor + " Pierde "+Puntos+" Puntos");
                }







            }catch (Exception e){
                System.out.println(e);
            }
        }



    }


    public static void updatePartida(){
        Scanner scanner = new Scanner(System.in);
        verListaDePartidas();
        System.out.println("Ingresa el Id de la Partida Deseada:");
        int pId = scanner.nextInt();
        Partida laPartida = buscarPartida(pId);

    }

    //endregion



    // region SET Y GETERS


    public Jugadores getGanador() {
        return ganador;
    }

    public void setGanador(Jugadores ganador) {
        this.ganador = ganador;
    }

    public int getId() {
        return id;
    }


    public Jugadores getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugadores jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugadores getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugadores jugador2) {
        this.jugador2 = jugador2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipoPartida() {
        return tipoPartida;
    }

    public void setTipoPartida(int tipoPartida) {
        this.tipoPartida = tipoPartida;
    }

    //endregion
}
