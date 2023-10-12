package Clases;

import java.util.ArrayList;

public class RegistroPartidas {
    private final int id;
    private int eloJugador1;
    private int eloJugador2;

    private int puntos;
    public static ArrayList<RegistroPartidas> listadeRegistro = new ArrayList<>();

    public RegistroPartidas(int id, int eloJugador1, int eloJugador2,int puntos) {
        this.id = id;
        this.eloJugador1 = eloJugador1;
        this.eloJugador2 = eloJugador2;
        this.puntos = puntos;
    }

    public static RegistroPartidas fromString(String linea) {
        String datos = linea.substring(linea.indexOf('{') + 1, linea.indexOf('}'));
    
        String[] splitData = datos.split(",");
        int id = Integer.parseInt(separateDataValue(splitData[0]));
        if (buscarRegistro(id) == null) {
          RegistroPartidas registro = new RegistroPartidas(
              id,
              Integer.parseInt(separateDataValue(splitData[1])),
              Integer.parseInt(separateDataValue(splitData[2])),
              Integer.parseInt(separateDataValue(splitData[3]))
              );
          return registro;
        }
        return null;
      }
    
      public static String separateDataValue(String data) {
        return data.substring(data.indexOf('=') + 1);
      }

      public static RegistroPartidas buscarRegistro(int pId){
        for(RegistroPartidas reg:listadeRegistro){
            if(reg.getId()==pId){
                return reg;
            }
        }
        return null;
      }

    @Override
    public String toString() {
        return "RegistroPartidas{" +
                "id=" + id +
                ", eloJugador1=" + eloJugador1 +
                ", eloJugador2=" + eloJugador2 +
                ", puntos=" + puntos +
                '}';
    }

    // region GET Y SETERS
    public int getId() {
        return id;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getEloJugador1() {
        return eloJugador1;
    }

    public void setEloJugador1(int eloJugador1) {
        this.eloJugador1 = eloJugador1;
    }

    public int getEloJugador2() {
        return eloJugador2;
    }

    public void setEloJugador2(int eloJugador2) {
        this.eloJugador2 = eloJugador2;
    }

    // endregion
}
