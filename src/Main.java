import Clases.Arbitro;
import Clases.Jugadores;
import Clases.Partida;
import Clases.Persona;
import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

import static Clases.Arbitro.bajaArbitro;

public class Main {
    public static void main(String[] args) {

        // region DATOS DE PREUBA

        Jugadores Jugador1 = new Jugadores("Enzo","Pontet","Uruguay",44,200,22);
        Persona.listaPersonas.add(Jugador1);
        Jugadores.listaJugadores.add(Jugador1);

        Jugadores Jugador2 = new Jugadores("Lucas","Chambon","Argentina",100,100,32);
        Persona.listaPersonas.add(Jugador2);
        Jugadores.listaJugadores.add(Jugador2);
        Jugadores Jugador3 = new Jugadores("Luis","Aquino","Peru",212,1921,66);
        Persona.listaPersonas.add(Jugador3);
        Jugadores.listaJugadores.add(Jugador3);
        Jugadores Jugador4 = new Jugadores("Maxi","Colman","Chileno",10,30,20);
        Persona.listaPersonas.add(Jugador4);
        Jugadores.listaJugadores.add(Jugador4);

        Arbitro arbitro1 = new Arbitro("Gustavo","Erramuspe","Paraguay",2,1);
        Persona.listaPersonas.add(arbitro1);
        Arbitro.listaArbitros.add(arbitro1);
        Arbitro arbitro2 = new Arbitro("Agustin","Maciel","Venezolano",100,2);
        Persona.listaPersonas.add(arbitro2);
        Arbitro.listaArbitros.add(arbitro2);
        Arbitro arbitro3 = new Arbitro("Alen","Lopez","Uruguay",33,3);
        Persona.listaPersonas.add(arbitro3);
        Arbitro.listaArbitros.add(arbitro3);


//        Partida laPartida = new Partida(Jugador1,Jugador2,arbitro3,"20-06-2023",1,Jugador2);
//        Partida.listaPartidas.add(laPartida);


        //endregion

        int opcion;
        String userInput;
        Scanner scanner = new Scanner(System.in);

        do {
            clearConsole();
            System.out.println("Para salir de la Consola Ingresar 0");
            System.out.println("--- TORNEO DE AJEDREZ ---");
            System.out.print("Ingrese Accion a Realizar: \n");

            System.out.println("--------------------------------------------  Opciones Jugadores  --------------------------------------------");
            System.out.println("1 Ingresar Jugador \t 2 Eliminar Juagdor  \t  3 Modificar Juagdor \t  4 Lista de Jugadores \n");


            System.out.println("--------------------------------------------  Opciones Arbitros  ---------------------------------------------");
            System.out.println("5 Ingresar Arbitro \t 6 Eliminar Arbitro \t 7 Modificar Arbitro \t  8 Lista de Arbitros \n");

            System.out.println("--------------------------------------------  Opciones Partida  ---------------------------------------------");
            System.out.println("9 Ingresar Partida  \t 10 Modificar Partida \t  11 Lista de Partida \n");

            System.out.println("--------------------------------------------  Opciones EXTRA  ---------------------------------------------");

            System.out.println("12 Ver Partidas de un Jugador \t  13 Ver Partidas de una Fecha  \t 14 Ver Pagos \n");

            System.out.println("--------------------------------------------  IMPORTAR / EXPORTAR  ---------------------------------------------");
            System.out.println("15 IMPORTAR DATOS  \t 16 EXPORTAR DATOS");




            userInput = scanner.nextLine();

            if (esNumero(userInput)) {
                opcion = Integer.parseInt(userInput);
                switch (opcion) {
                    case 1:
                        Jugadores.altaJugador();
                        break;
                    case 2:
                        Jugadores.bajaJugador();
                        break;
                    case 3:
                        Jugadores.updateJugador();
                        break;
                    case 4:
                        Jugadores.verListaDeJugadores();
                        break;
                    case 5:
                        Arbitro.altaArbitro();
                       break;
                    case 6:
                        bajaArbitro();
                        break;
                    case 7:
                        Arbitro.updateArbitro();
                        break;
                    case 8:
                        Arbitro.verListaDeArbitros();
                        break;
                    case 9:
                        Partida.altaPartida();
                        break;
                    case 10:
                        Partida.updatePartida();
                        break;
                    case 11:
                        Partida.verListaDePartidas();
                        break;
                    case 12:
                        Partida.verPartidasDeJugador();
                        break;
                    case 16:
                        exportarDatos(Jugadores.listaJugadores,Arbitro.listaArbitros,Partida.listaPartidas);
                        break;
//                    case 15:
//                        importarDatos();
//                        break;

                    case 13:
                        Partida.verPartidasDeUnaFecha();
                        break;
                    case 14:
                        System.out.println("---------------------------------------- VER PAGOS -----------------------------------------------------------");
                        Jugadores.verPagos();
                       Arbitro.verPagos();
                        break;

                    default:
                        if (opcion != 0) {
                            System.out.println("Ingrese un ejercicio válido");
                        } else {
                            System.out.println("¡SALISTE!");
                        }
                        scanner.nextLine(); // Espera a que el usuario presione Enter
                        break;
                }
            } else {
                System.out.println("Ingresa un número válido.");
                opcion = 1;
                scanner.nextLine(); // Espera a que el usuario presione Enter
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void exportarDatos(ArrayList<Jugadores> jugadores, ArrayList<Arbitro> arbitros, ArrayList<Partida> partidas) {
        try {
//            FileWriter archivo = new FileWriter("C:\\Users\\EnzoP\\OneDrive\\Escritorio\\Obligatorio1-Pontet-Chambon\\datos_torneo.txt");
            FileWriter archivo = new FileWriter("datos_torneo.txt");
            BufferedWriter escritor = new BufferedWriter(archivo);

            // Escribe los jugadores
            escritor.write("JUGADORES\n");
            for (Jugadores jugador : jugadores) {
                escritor.write(jugador.toString() + "\n");
            }

            // Escribe los árbitros
            escritor.write("ÁRBITROS\n");
            for (Arbitro arbitro : arbitros) {
                escritor.write(arbitro.toString() + "\n");
            }

            // Escribe las partidas
            escritor.write("PARTIDAS\n");
            for (Partida partida : partidas) {
                escritor.write(partida.toString() + "\n");
            }

            escritor.close();
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al exportar datos: " + e.getMessage());
        }
    }


//    public static void importarDatos(ArrayList<Jugadores> jugadores, ArrayList<Arbitro> arbitros, ArrayList<Partida> partidas) {
//        try {
//            FileReader archivo = new FileReader("datos_torneo.txt");
//            BufferedReader lector = new BufferedReader(archivo);
//
//            String linea;
//            String categoria = "";
//
//            while ((linea = lector.readLine()) != null) {
//                if (linea.equals("JUGADORES")) {
//                    categoria = "JUGADORES";
//                } else if (linea.equals("ÁRBITROS")) {
//                    categoria = "ÁRBITROS";
//                } else if (linea.equals("PARTIDAS")) {
//                    categoria = "PARTIDAS";
//                } else {
//                    switch (categoria) {
//                        case "JUGADORES":
//                            Jugadores jugador = Jugadores.fromString(linea);
//                            jugadores.add(jugador);
//                            break;
//                        case "ÁRBITROS":
//                            Arbitro arbitro = Arbitro.fromString(linea);
//                            arbitros.add(arbitro);
//                            break;
//                        case "PARTIDAS":
//                            Partida partida = Partida.fromString(linea);
//                            partidas.add(partida);
//                            break;
//                    }
//                }
//            }
//
//            lector.close();
//            System.out.println("Datos importados correctamente.");
//        } catch (IOException e) {
//            System.err.println("Error al importar datos: " + e.getMessage());
//        }
//    }
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
 }
}
}