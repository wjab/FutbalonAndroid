package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class WsTestActivity extends Activity {

    Button button;
    WS_Futbalon ws_futbalon = new WS_Futbalon();
    TextView tv_response;
    String wsResponse;

    private static WsTestActivity sInstance;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws_test);

        mRequestQueue = Volley.newRequestQueue(this);
        sInstance = this;

        button = (Button)findViewById(R.id.b_request);
        tv_response = (TextView)findViewById(R.id.tv_response);

        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyBmSXUzVZBKQv9FJkTpZXn0dObKgEQOIFU&cx=014099860786446192319:t5mr0xnusiy&q=AndroidDev&alt=json&searchType=image";

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                tv_response.setText("Response => " + response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });

        WsTestActivity.getInstance().getRequestQueue().add(request);


        //tv_response.setText(wsResponse);
    }

    public synchronized static WsTestActivity getInstance()
    {
        return sInstance;
    }

    public RequestQueue getRequestQueue()
    {
        return mRequestQueue;
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
