package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.app.VoiceInteractor;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by Administrador on 9/4/2015.
 */

public class WS_Futbalon
{
    String result = "";
    private int MY_SOCKET_TIMEOUT_MS = 5000;
    private static WsTestActivity sInstance;
    private RequestQueue mRequestQueue;

    public String Request(Activity activity, String WsURL)
    {
        try
        {

        }
        catch (Exception ex)
        {
            result = ex.getMessage().toString();
        }

        return result;
    }

    public synchronized static WsTestActivity getInstance()
    {
        return sInstance;
    }

    public RequestQueue getRequestQueue()
    {
        return mRequestQueue;
    }
}
