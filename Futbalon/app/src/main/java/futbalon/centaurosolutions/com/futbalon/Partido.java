package futbalon.centaurosolutions.com.futbalon;

import android.widget.ImageView;

/**
 * Created by Eduardo on 29/08/2015.
 */
public class Partido {

    private int idEquipo1;
    private int IdEquipo2;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int puntos;
    private int puntosTotales;
    private String status;
    private String fecha;


    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(int idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public int getIdEquipo2() {
        return IdEquipo2;
    }

    public void setIdEquipo2(int idEquipo2) {
        IdEquipo2 = idEquipo2;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }
}
