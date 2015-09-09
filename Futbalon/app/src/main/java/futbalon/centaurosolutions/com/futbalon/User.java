package futbalon.centaurosolutions.com.futbalon;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Eduardo on 02/09/2015.
 */
public class User implements Serializable
{
    private String email, password, fullname, teamDistribution;
    private int puntos, userId, gamestate;
    private boolean authenticated, registered ;

    public User()
    {
        setCorreo("");
        setPassword("");
        setFullName("");
        setAuthenticated(false);
        setRegistered(false);
        setTeamDistribution("");
        setPuntos(0);
        setUserId(0);
        setGameState(0);
    }

    public User(String pCorreo, String pPassword, String pFullname,
                boolean pAuthenticated, boolean pRegistered, String pTeamDistribution, int pPuntos,
                int pUserId, int pGamestate)
    {
        this.email = pCorreo;
        this.password = pPassword;
        this.puntos = pPuntos;
        this.fullname = pFullname;
        this.authenticated = pAuthenticated;
        this.registered = pRegistered;
        this.teamDistribution = pTeamDistribution;
        this.puntos = pPuntos;
        this.userId = pUserId;
        this.gamestate = pGamestate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCorreo(String value) {
        this.email = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int value) {
        this.puntos = value;
    }

    public String getFullName(){return this.fullname;}
    public void setFullName(String value){this.fullname = value;}

    public boolean getAuthenticated(){return this.authenticated;}
    public void setAuthenticated(boolean value){this.authenticated = value;}

    public boolean getRegistered(){return this.registered;}
    public void setRegistered(boolean value){this.registered = value;}

    public String getTeamDistribution(){return this.teamDistribution;}
    public void setTeamDistribution(String value){this.teamDistribution = value;}

    public int getUserId(){return this.userId;}
    public void setUserId(int value){this.userId = value;}

    public int getGameState(){return this.gamestate;}
    public void setGameState(int value){this.gamestate = value;}

}
