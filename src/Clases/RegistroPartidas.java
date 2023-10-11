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

    @Override
    public String toString() {
        return "RegistroPartidas{" +
                "id=" + id +
                ", eloJugador1=" + eloJugador1 +
                ", eloJugador2=" + eloJugador2 +
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
