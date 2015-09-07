package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PartidosPendientesTab extends  Activity implements Response.Listener<JSONObject>, Response.ErrorListener{

    ListView lv;
    Context context;

    public Partido partido1= new Partido();
    public Partido partido2= new Partido();
    ArrayList<Partido> array_mejenga = new ArrayList<Partido>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos_pendientes_tab);
    /*    partido1.setEquipo1("Municipal Liberia");
        partido1.setEquipo2("Belén");
        partido1.setGolesEquipo1(2);
        partido1.setGolesEquipo2(3);
        partido1.setStatus("PEN");
        partido1.setFecha("6 Septiembre, 2015 - 08:00 PM");

        partido2.setEquipo1("UCR");
        partido2.setEquipo2("Limón");
        partido2.setGolesEquipo1(3);
        partido2.setGolesEquipo2(2);
        partido2.setStatus("PEN");
        partido2.setFecha("4 Septiembre, 2015 - 05:00 PM");

        array_mejenga.add(partido1);
        array_mejenga.add(partido2);





        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, array_mejenga));*/
    }

    @Override
    public void onResponse(JSONObject response) {

        Log.d("Response", response.toString());
        // vista.setText(response.toString());

        JSONArray jsonArray;
        JSONObject jsonObject;

        try{
           //tv_response.setText(response.toString());



        }
        catch (Exception ex){

        }



//        User user = new User();
//        user.name = "David";
//        user.last_name = "Cortes";
//        DatabaseManager.getInstance().addUser(user);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public static String toJson(Object jsonObject)
    {
        return new Gson().toJson(jsonObject);
    }

    public static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_partidos_pendientes_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
