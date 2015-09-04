package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.os.Bundle;
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

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class WsTestActivity extends Activity {

    Button button;
    WS_Futbalon ws_futbalon = new WS_Futbalon();
    TextView tv_response;
    String wsResponse;
    ArrayList listaPartidos;

    private static WsTestActivity sInstance;
    private RequestQueue mRequestQueue;
    private int MY_SOCKET_TIMEOUT_MS = 5000;
    private String result;
    String url = "http://services.futbalon.com/aggregators/matches/getFinishMatchesByDateRange?idUser=12018&fromValue=27/08/2015&toValue=03/09/2015";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws_test);

        button = (Button)findViewById(R.id.b_request);
        tv_response = (TextView)findViewById(R.id.tv_response);

        mRequestQueue = Volley.newRequestQueue(this);
        sInstance = this;
        //String json = Request(this, url );

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                tv_response.setText(response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                tv_response.setText(error.toString());
            }
        });

        WsTestActivity.getInstance().getRequestQueue().add(request);

        request.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        listaPartidos = (ArrayList<Partido>) fromJson(tv_response.getText().toString(),
                new TypeToken<ArrayList<Partido>>() {
                }.getType());
    }

    public String Request(Activity activity, String WsURL)
    {
        try
        {
            mRequestQueue = Volley.newRequestQueue(activity);
            //String url = "http://services.futbalon.com/aggregators/matches/getFinishMatchesByDateRange?idUser=12018&fromValue=27/08/2015&toValue=03/09/2015";

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, WsURL, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    // TODO Auto-generated method stub
                    //tv_response.setText(response.toString());
                    result = response.toString();
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO Auto-generated method stub
                    //tv_response.setText(error.toString());
                    result = error.toString();
                }
            });

            WsTestActivity.getInstance().getRequestQueue().add(request);

            request.setRetryPolicy(new DefaultRetryPolicy(
                    MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        }
        catch (Exception ex)
        {
            result = ex.getMessage().toString();
        }

        return result;
    }

    private synchronized static WsTestActivity getInstance()
    {
        return sInstance;
    }

    private RequestQueue getRequestQueue()
    {
        return mRequestQueue;
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
