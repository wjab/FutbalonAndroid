package futbalon.centaurosolutions.com.futbalon;

/**
 * Created by Eduardo on 02/09/2015.
 */
public class Equipo {

    private int IdEquipo;

    private String  nombre;

    private String país;

    private String nombreEntrenador;


    public Equipo (){
        setIdEquipo(0);
        setNombre("");
        setPaís("");
        setNombreEntrenador("");
    }

    public Equipo(int pId, String pNombre, String pPaís, String pEntrenador){
        setIdEquipo(pId);
        setNombre(pNombre);
        setPaís(pPaís);
        setNombreEntrenador(pEntrenador);
    }

    public int getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        IdEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }
}
