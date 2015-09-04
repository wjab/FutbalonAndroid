package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.app.VoiceInteractor;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrador on 9/4/2015.
 */

public class WS_Futbalon
{
    String result = "";

    public String Request(Activity activity)
    {
        try
        {
            Volley v = new Volley();

            // Instantiate the RequestQueue.
            RequestQueue queue = v.newRequestQueue(activity);
            String url ="http://www.google.com";

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            result = response;
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    result = "That didn't work!";
                }
            });
            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }
        catch (Exception ex)
        {
            result = ex.getMessage().toString();
        }

        return result;
    }
}
