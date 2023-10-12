import Clases.Arbitro;
import Clases.Jugadores;
import Clases.Partida;
import Clases.RegistroPartidas;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // region DATOS DE PREUBA

    // Jugadores Jugador1 = new Jugadores("Enzo", "Pontet", "Uruguay", 44, 200, 22);
    // Persona.listaPersonas.add(Jugador1);
    // Jugadores.listaJugadores.add(Jugador1);

    // Jugadores Jugador2 = new Jugadores("Lucas", "Chambon", "Argentina", 100, 100, 32);
    // Persona.listaPersonas.add(Jugador2);
    // Jugadores.listaJugadores.add(Jugador2);
    // Jugadores Jugador3 = new Jugadores("Luis", "Aquino", "Peru", 212, 1921, 66);
    // Persona.listaPersonas.add(Jugador3);
    // Jugadores.listaJugadores.add(Jugador3);
    // Jugadores Jugador4 = new Jugadores("Maxi", "Colman", "Chileno", 10, 30, 20);
    // Persona.listaPersonas.add(Jugador4);
    // Jugadores.listaJugadores.add(Jugador4);

    // Arbitro arbitro1 = new Arbitro("Gustavo", "Erramuspe", "Paraguay", 2, 1);
    // Persona.listaPersonas.add(arbitro1);
    // Arbitro.listaArbitros.add(arbitro1);
    // Arbitro arbitro2 = new Arbitro("Agustin", "Maciel", "Venezolano", 100, 2);
    // Persona.listaPersonas.add(arbitro2);
    // Arbitro.listaArbitros.add(arbitro2);
    // Arbitro arbitro3 = new Arbitro("Alen", "Lopez", "Uruguay", 33, 3);
    // Persona.listaPersonas.add(arbitro3);
    // Arbitro.listaArbitros.add(arbitro3);

    // endregion

    clearConsole();
    int opcion = 1;
    boolean flag = false;
    String userInput;
    Scanner scanner = new Scanner(System.in);

    // #region MENU
    do {
      while (opcion != 0) {
        System.out.println("----------- TORNEO DE AJEDREZ -----------\n");
        flag = false;
        System.out.println("1 | --------  Opciones Jugadores  --------");
        System.out.println("2 | --------  Opciones Arbitros  --------");
        System.out.println("3 | --------  Opciones Partida  --------");
        System.out.println("4 | --------  Opciones EXTRA  --------");
        System.out.println("5 | --------  IMPORTAR / EXPORTAR  --------");
        System.out.println("0 | Para salir de la Consola");
        System.out.print("\nOpcion: ");
        userInput = scanner.nextLine();
        if (esNumero(userInput)) {
          opcion = Integer.parseInt(userInput);
          clearConsole();
          switch (opcion) {
            case 1:
              while (flag != true) {
                System.out.println("--------  Opciones Jugadores  --------\n");
                System.out.println(
                    " 1 | Ingresar Jugador\n 2 | Eliminar Juagdor\n 3 | Modificar Juagdor\n 4 | Lista de Jugadores\n -1 | Salir al Menu\n");
                System.out.print("Ingrese Accion a Realizar: ");
                userInput = scanner.nextLine();
                if (esNumero(userInput)) {
                  opcion = Integer.parseInt(userInput);
                  clearConsole();
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
                    case -1:
                      flag = true;
                      break;
                    default:
                      flag = false;
                      System.out.println("Ingresa un número válido.");
                      break;
                  }
                } else {
                  clearConsole();
                  System.out.println("Ingresa un número.");
                  opcion = 1;
                }

              }
              break;
            case 2:
              while (flag != true) {
                System.out.println("--------  Opciones Arbitros  --------\n");
                System.out.println(
                    " 1 | Ingresar Arbitro\n 2 | Eliminar Arbitro\n 3 | Modificar Arbitro\n 4 | Lista de Arbitros\n -1 | Salir al Menu\n");
                System.out.print("Ingrese Accion a Realizar: ");
                userInput = scanner.nextLine();
                if (esNumero(userInput)) {
                  opcion = Integer.parseInt(userInput);
                  clearConsole();
                  switch (opcion) {
                    case 1:
                      Arbitro.altaArbitro();
                      break;
                    case 2:
                      Arbitro.bajaArbitro();
                      break;
                    case 3:
                      Arbitro.updateArbitro();
                      break;
                    case 4:
                      Arbitro.verListaDeArbitros();
                      break;
                    case -1:
                      flag = true;
                      break;
                    default:
                      flag = false;
                      System.out.println("Ingresa un número válido.");
                      break;
                  }
                } else {
                  clearConsole();
                  System.out.println("Ingresa un número.");
                  opcion = 1;
                }
              }

              break;
            case 3:
              while (flag != true) {
                System.out.println("--------  Opciones Partida  --------\n");
                System.out.println(
                    " 1 | Ingresar Partida\n 2 | Modificar Partida\n 3 | Lista de Partidas\n 4 | Partidas de Jugador\n 5 | Partidas de Fecha\n -1 | Salir al Menu\n");
                System.out.print("Ingrese Accion a Realizar: ");
                userInput = scanner.nextLine();
                if (esNumero(userInput)) {
                  opcion = Integer.parseInt(userInput);
                  clearConsole();
                  switch (opcion) {
                    case 1:
                      Partida.altaPartida();
                      break;
                    case 2:
                      Partida.updatePartida();
                      break;
                    case 3:
                      Partida.verListaDePartidas();
                      break;
                    case 4:
                      Partida.verPartidasDeJugador();
                      break;
                    case 5:
                      Partida.verPartidasDeUnaFecha();
                      break;
                    case -1:
                      flag = true;
                      break;
                    default:
                      flag = false;
                      System.out.println("Ingresa un número válido.");
                      break;
                  }
                } else {
                  clearConsole();
                  System.out.println("Ingresa un número.");
                  opcion = 1;
                }
              }
              break;
            case 4:
              while (flag != true) {
                System.out.println("--------  Opciones EXTRA  --------\n");
                System.out.println(
                    " 1 | Ver Pagos\n -1 | Salir al Menu\n");
                System.out.print("Ingrese Accion a Realizar: ");
                userInput = scanner.nextLine();
                if (esNumero(userInput)) {
                  opcion = Integer.parseInt(userInput);
                  clearConsole();
                  switch (opcion) {
                    case 1:
                      Jugadores.verPagos();
                      Arbitro.verPagos();
                      break;
                    case -1:
                      flag = true;
                      break;
                    default:
                      flag = false;
                      System.out.println("Ingresa un número válido.");
                      break;
                  }
                } else {
                  clearConsole();
                  System.out.println("Ingresa un número.");
                  opcion = 1;
                }
              }
              break;
            case 5:
              while (flag != true) {
                System.out.println("--------  IMPORTAR / EXPORTAR  --------\n");
                System.out.println(
                    " 1 | Importar Datos\n 2 | Exportar Datos\n -1 | Salir al Menu\n");
                System.out.print("Ingrese Accion a Realizar: ");
                userInput = scanner.nextLine();
                if (esNumero(userInput)) {
                  opcion = Integer.parseInt(userInput);
                  clearConsole();
                  switch (opcion) {
                    case 1:
                      importarDatos();
                      break;
                    case 2:
                      exportarDatos(Jugadores.listaJugadores, Arbitro.listaArbitros,
                          Partida.listaPartidas, RegistroPartidas.listadeRegistro);
                      break;
                    case -1:
                      flag = true;
                      break;
                    default:
                      flag = false;
                      System.out.println("Ingresa un número válido.");
                      break;
                  }
                } else {
                  clearConsole();
                  System.out.println("Ingresa un número.");
                  opcion = 1;
                }
              }
              break;
          }
          clearConsole();
        } else {
          System.out.println("Ingresa un número válido.");
          opcion = 1;
          scanner.nextLine(); // Espera a que el usuario presione Enter
        }
      }
    } while (opcion != 0);
    // #endregion MENU
    scanner.close();
  }

  //#region EXPORTAR/IMPORTAR
  public static void exportarDatos(ArrayList<Jugadores> jugadores, ArrayList<Arbitro> arbitros,
      ArrayList<Partida> partidas, ArrayList<RegistroPartidas> registros) {
    try {
      // FileWriter archivo = new
      // FileWriter("C:\\Users\\EnzoP\\OneDrive\\Escritorio\\Obligatorio1-Pontet-Chambon\\datos_torneo.txt");
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

      // Escribe las registros
      escritor.write("REGISTROS\n");
      for (RegistroPartidas reg : registros) {
        escritor.write(reg.toString() + "\n");
      }

      escritor.close();
      System.out.println("Datos exportados correctamente.");
    } catch (IOException e) {
      System.err.println("Error al exportar datos: " + e.getMessage());
    }
  }

  public static void importarDatos() {
    try {
      ArrayList<Jugadores> jugadores = Jugadores.listaJugadores;
      ArrayList<Arbitro> arbitros = Arbitro.listaArbitros;
      ArrayList<Partida> partidas = Partida.listaPartidas;
      ArrayList<RegistroPartidas> registros = RegistroPartidas.listadeRegistro;
      FileReader archivo = new FileReader("datos_torneo.txt");
      BufferedReader lector = new BufferedReader(archivo);

      String linea;
      String categoria = "";

      while ((linea = lector.readLine()) != null) {
        if (linea.equals("JUGADORES")) {
          categoria = "JUGADORES";
        } else if (linea.equals("ÁRBITROS")) {
          categoria = "ÁRBITROS";
        } else if (linea.equals("PARTIDAS")) {
          categoria = "PARTIDAS";
        } else if (linea.equals("REGISTROS")) {
          categoria = "REGISTROS";
        } else {
          switch (categoria) {
            case "JUGADORES":
              Jugadores jugador = Jugadores.fromString(linea);
              if (jugador != null) {
                jugadores.add(jugador);
              }
              break;
            case "ÁRBITROS":
              Arbitro arbitro = Arbitro.fromString(linea);
              if (arbitro != null) {
                arbitros.add(arbitro);
              }
              break;
            case "PARTIDAS":
              Partida partida = Partida.fromString(linea);
              if (partida != null) {
                partidas.add(partida);
              }
              break;
            case "REGISTROS":
              RegistroPartidas reg = RegistroPartidas.fromString(linea);
              if (reg != null) {
                registros.add(reg);
              }
              break;
          }
        }
      }

      lector.close();
      System.out.println("Datos importados correctamente.");
    } catch (

    IOException e) {
      System.err.println("Error al importar datos: " + e.getMessage());
    }
  }
  //#endregion

  //PARA LIMPIAR LA CONSOLA
  public static void clearConsole() {
    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        Runtime.getRuntime().exec("clear");
      }
    } catch (final Exception e) {
      // Manejo de excepciones
    }
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