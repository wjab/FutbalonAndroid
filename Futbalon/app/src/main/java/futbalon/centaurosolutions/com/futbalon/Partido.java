package futbalon.centaurosolutions.com.futbalon;

import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private String ImagenEquipo1;
    private String ImagenEquipo2;


    public ArrayList<Partido> createArrayListPartidoFromResponse(JSONArray myPartidoJSON){

        final String imageUrl = "http://play.futbalon.com/";
        String imagenEquipo2 = "";
        String imagenEquipo1 = "";

        ArrayList<Partido> listaPartidos = new ArrayList<Partido>();

        try
        {
            for (int i = 0; i < myPartidoJSON.length(); i++) {

                Partido miPartido = new Partido();
                JSONObject row = myPartidoJSON.getJSONObject(i);
                miPartido.setIdEquipo1(Integer.parseInt(row.getString("teamA")));
                miPartido.setIdEquipo2(Integer.parseInt(row.getString("teamB")));
                miPartido.setGolesEquipo1(Integer.parseInt(row.getString("teamGoalA")));
                miPartido.setGolesEquipo2(Integer.parseInt(row.getString("teamGoalB")));
                miPartido.setStatus(row.getString("status"));
                miPartido.setEquipo1(row.getString("teamNameA"));
                miPartido.setEquipo2(row.getString("teamNameB"));
                imagenEquipo1 = imageUrl + row.getString("logotypeTeamA");
                imagenEquipo2 = imageUrl + row.getString("logotypeTeamB");
                miPartido.setImagenEquipo1(imagenEquipo1);
                miPartido.setImagenEquipo2(imagenEquipo2);
                miPartido.setFecha(matchDateFormat(row.getString("matchDate").toString()));
                listaPartidos.add(miPartido);
            }
        }
        catch (Exception ex){

        }

        return listaPartidos;
    }

    public String matchDateFormat(String fecha_partido){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        Date date =new Date();
        try
        {
            date=format.parse(fecha_partido);

        }
        catch (ParseException ex) {

        }
        SimpleDateFormat hourdateFormat = new SimpleDateFormat("dd MMMM, yyyy - hh:mm aa");

        String var = (hourdateFormat.format(date).toString());

        return var;


    }




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

    public String getImagenEquipo1() {
        return ImagenEquipo1;
    }

    public void setImagenEquipo1(String imagenEquipo1) {
        ImagenEquipo1 = imagenEquipo1;
    }

    public String getImagenEquipo2() {
        return ImagenEquipo2;
    }

    public void setImagenEquipo2(String imagenEquipo2) {
        ImagenEquipo2 = imagenEquipo2;
    }
}
