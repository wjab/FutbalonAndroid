package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import futbalon.centaurosolutions.com.futbalon.controllers.ServiceController;

public class WsTestActivity extends Activity implements Response.Listener<JSONObject>, Response.ErrorListener {

    Button button;
    WS_Futbalon ws_futbalon = new WS_Futbalon();
    TextView tv_response;
    String wsResponse;
    ArrayList listaPartidos;


    String url = "http://services.futbalon.com/aggregators/matches/getFinishMatchesByDateRange?idUser=12018&fromValue=27/08/2015&toValue=03/09/2015";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws_test);


        tv_response = (TextView)findViewById(R.id.tv_response);

        ServiceController serviceController = new ServiceController();

        serviceController.jsonObjectRequest("http://api.openweathermap.org/data/2.5/weather?q=San%20Jose,cr", Request.Method.POST, null, this, this);

    }


    @Override
    public void onResponse(JSONObject response) {

        Log.d("Response", response.toString());
        // vista.setText(response.toString());

        JSONArray jsonArray;
        JSONObject jsonObject;

        try{
            tv_response.setText(response.toString());



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
        getMenuInflater().inflate(R.menu.menu_ws_test, menu);
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
