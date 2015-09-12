package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import futbalon.centaurosolutions.com.futbalon.controllers.ServiceController;

public class Login extends Activity implements Response.Listener<JSONObject>, Response.ErrorListener {

    Button b_login;
    EditText et_usuario, et_password;
    ServiceController serviceController;
    Response.Listener<JSONObject> response;
    Response.ErrorListener responseError;
    User userObject = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        response = this;
        responseError=this;

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
        imageView.setImageBitmap(bImage);

        b_login = (Button)findViewById(R.id.login);
        et_usuario = (EditText)findViewById(R.id.usuario);
        et_password = (EditText)findViewById(R.id.password);

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!et_usuario.getText().toString().isEmpty() && !et_password.getText().toString().isEmpty()){
                    serviceController = new ServiceController();
                    String url = "http://services.futbalon.com/aggregators/users/login";
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("email", et_usuario.getText().toString());
                    map.put("password", et_password.getText().toString());

                    serviceController.jsonObjectRequest(url, Request.Method.POST, map, response, responseError);
                }
                else{

                    Toast toast = Toast.makeText(getApplicationContext(), "Usuario y contraseña requeridos", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    @Override
    public void onResponse(JSONObject response) {

        Log.d("Response", response.toString());

        try
        {
            userObject.setCorreo(response.getString("email"));
            userObject.setPassword(response.getString("password"));
            userObject.setFullName(response.getString("nombreCompleto"));
            userObject.setAuthenticated(response.getBoolean("authenticated"));
            userObject.setRegistered(response.getBoolean("registered"));
            userObject.setTeamDistribution(response.getString("formation"));
            userObject.setUserId(response.getInt("id"));
            userObject.setGameState(response.getInt("state"));

            if(userObject.getAuthenticated()){

                Intent intent = new Intent(getApplicationContext(), Partidos.class);
                intent.putExtra("user", userObject);
                startActivity(intent);
            }
        }
        catch (Exception ex){
            Toast toast = Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("Login Error", error.toString());
    }


}
