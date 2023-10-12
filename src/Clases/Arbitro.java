package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Arbitro extends Persona {

  private int NivelDeCertificacion;

  // region Constructor Lista TOSTRING(datos)
  public static ArrayList<Arbitro> listaArbitros = new ArrayList<>();

  public Arbitro(String nombre, String apellido, String pais, int partidos, int nivelDeCertificacion) {
    super(nombre, apellido, pais, partidos);
    NivelDeCertificacion = nivelDeCertificacion;
  }

  public void datos() {
    System.out.println("Arbitro{" +
        "id=" + this.getId() +
        ", Nombre='" + this.getNombre() + '\'' +
        ", Apellido='" + this.getApellido() + '\'' +
        ", Pais='" + this.getPais() + '\'' +
        ", Partidos='" + this.getPartidos() + '\'' +
        ", NivelDeCertificacion=" + NivelDeCertificacion +
        '}');
  }

  public static Arbitro fromString(String linea) {
    String datos = linea.substring(linea.indexOf('{') + 1, linea.indexOf('}'));

    String[] splitData = datos.split(",");
    int id = Integer.parseInt(separateDataValue(splitData[0]));
    if (BuscarArbitro(id) == null) {
      Arbitro elArbitro = new Arbitro(
          separateDataValue(splitData[1]).replaceAll("'", ""),
          separateDataValue(splitData[2]).replaceAll("'", ""),
          separateDataValue(splitData[3]).replaceAll("'", ""),
          Integer.parseInt(separateDataValue(splitData[4])),
          Integer.parseInt(separateDataValue(splitData[5])));
      listaPersonas.add(elArbitro);
      return elArbitro;
    }
    return null;

  }

  public static String separateDataValue(String data) {
    return data.substring(data.indexOf('=') + 1);
  }

  // endregion
  // region ABM
  public static void altaArbitro() {
    Scanner scanner = new Scanner(System.in);
    try {
      System.out.println("------- DATOS DE INGRESO DE ARBITRO -------");
      System.out.println("Ingrese Nombre: ");
      String pNombre = scanner.nextLine();
      System.out.println("Ingrese Apellido: ");
      String pApellido = scanner.nextLine();

      System.out.println("Ingrese Pais: ");
      String pPais = scanner.nextLine();
      System.out.println("Ingrese Nivel de Certificación: ");
      int pCErtifi = scanner.nextInt();
      System.out.println("Ingrese Partidos Arbitrados: ");
      int pPartidos = scanner.nextInt();
      Arbitro elJuez = new Arbitro(pNombre, pApellido, pPais, pPartidos, pCErtifi);
      listaPersonas.add(elJuez);
      listaArbitros.add(elJuez);
      System.out.println("Arbitro " + pNombre + " " + pApellido + " Ingresado Con Exito");

    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public static void updateArbitro() {
    Scanner scanner = new Scanner(System.in);
    Scanner enteros = new Scanner(System.in);
    verListaDeArbitros();
    System.out.println("Ingrese Id de Arbitro a Modificar: ");
    int elId = enteros.nextInt();
    for (Arbitro elArbitro : listaArbitros) {
      if (elId == elArbitro.getId()) {
        try {
          System.out.println("------- DATOS DE MODIFICACION DE Arbitro -------");
          System.out.println("Ingrese Nombre: ");
          String pNombre = scanner.nextLine();
          System.out.println("Ingrese Apellido: ");
          String pApellido = scanner.nextLine();

          System.out.println("Ingrese Pais: ");
          String pPais = scanner.nextLine();

          System.out.println("Ingrese Partidos Arbitrados : ");
          int pPartidos = enteros.nextInt();
          elArbitro.setNombre(pNombre);
          elArbitro.setApellido(pApellido);

          elArbitro.setPais(pPais);

          elArbitro.setPartidos(pPartidos);
          System.out.println("Arbitro  Modificado Con Exito");
          return;
        } catch (Exception e) {
          System.out.println(e);
        }

      }
    }

  }

  public static void bajaArbitro() {
    Scanner scanner = new Scanner(System.in);
    verListaDeArbitros();
    System.out.println("Ingrese Id de Arbitro a Eliminar");
    int elId = scanner.nextInt();
    try {
      for (Arbitro elArbitro : listaArbitros) {
        if (elArbitro.getId() == elId) {
          boolean jugo = arbitroPartida(elId);
          if (jugo) {
            System.out.println("NO SE PUEDE ELIMINAR UN Arbitro CON REGISTROS DE PARTIDAS");
            return;
          } else {
            listaArbitros.remove(elArbitro);

            System.out.println("Arbitro " + elArbitro.getNombre() + " " + elArbitro.getApellido()
                + " ha sido Eliminado");
            return;
          }
        }
      }

    } catch (Exception e) {
      System.out.println(e);
    }

  }

  // endregion

  // region METODOS

  public static Arbitro BuscarArbitro(int pId) {
    for (Arbitro arbitro : listaArbitros) {
      if (arbitro.getId() == pId) {
        return arbitro;
      }
    }
    return null;
  }

  public static void verPagos() {
    System.out.println("--------------------- PAGOS A Arbitros --------------------------------------");
    for (Arbitro elArbitro : listaArbitros) {
      String Nombre = elArbitro.getNombre();
      String Apellido = elArbitro.getApellido();

      int partidosJugados = elArbitro.getPartidos();
      int pagoAJugadores = 500;
      int PagoTotal = pagoAJugadores * partidosJugados;
      System.out.println(Nombre + " " + Apellido + ": Partidos Arbitrados: " + partidosJugados + "  ---- TOTAL: $"
          + PagoTotal);
    }
  }

  public static boolean arbitroPartida(int id) {

    for (Partida laPartida : Partida.listaPartidas) {
      if (laPartida.getArbitro().getId() == id) {
        return true;
      }
    }
    return false;

  }

  public static void verListaDeArbitros() {
    System.out.println("-------------------- LISTA DE ARBITROS ------------------------------");
    for (Arbitro elArbitro : listaArbitros) {
      elArbitro.datos();
    }
  }
  // endregion

  @Override
  public String toString() {
    return "Arbitro{" +
        "id=" + this.getId() +
        ", Nombre='" + this.getNombre() + '\'' +
        ", Apellido='" + this.getApellido() + '\'' +
        ", Pais='" + this.getApellido() + '\'' +
        ", Partidos=" + this.getPartidos() +
        ", NivelDeCertificacion=" + getNivelDeCertificacion() +
        '}';
  }

  // region GET Y SETERS
  public int getNivelDeCertificacion() {
    return NivelDeCertificacion;
  }

  public void setNivelDeCertificacion(int nivelDeCertificacion) {
    NivelDeCertificacion = nivelDeCertificacion;
  }

  // endregion
}
