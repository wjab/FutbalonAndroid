package futbalon.centaurosolutions.com.futbalon;

/**
 * Created by Eduardo on 02/09/2015.
 */
public class Usuario {

    private String correo;
    private String password;
    private int puntos;


    public  Usuario(){
        setCorreo("");
        setPassword("");
        setPuntos(0);
    }

    public  Usuario(String pCorreo, String pPassword, int pPuntos){
        correo = pCorreo;
        password = pPassword;
        puntos = pPuntos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
