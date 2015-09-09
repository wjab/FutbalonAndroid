package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import futbalon.centaurosolutions.com.futbalon.controllers.ServiceController;

public class PartidosPendientesTab extends Activity implements Response.Listener<JSONArray>, Response.ErrorListener
{
    ListView lv;
    Context context;

    ArrayList<Partido> partidos = new ArrayList<Partido>();
    ServiceController serviceController;
    Response.Listener<JSONArray> response;
    Response.ErrorListener responseError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos_pendientes_tab);

        response = this;
        responseError = this;

        try
        {
            serviceController = new ServiceController();
            String url = "http://services.futbalon.com/aggregators/matches/getPending";
            serviceController.jsonArrayRequest(url, Request.Method.GET, null, response, responseError);
        }
        catch (Exception ex)
        {
            Log.d("Response", ex.getMessage().toString());
        }
    }

    @Override
    public void onResponse(JSONArray response)
    {
        Log.d("Response", response.toString());
        // vista.setText(response.toString());

        JSONArray jsonArray;
        JSONObject jsonObject;

        try
        {
            Partido miPartido = new Partido();
            partidos = miPartido.createArrayListPartidoFromResponse(response);

            lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(new CustomAdapter(this, partidos));
        }
        catch (Exception ex){

        }



//        User user = new User();
//        user.name = "David";
//        user.last_name = "Cortes";
//        DatabaseManager.getInstance().addUser(user);
    }

    @Override
    public void onErrorResponse(VolleyError error)
    {
        Log.d("Response", error.toString());
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
