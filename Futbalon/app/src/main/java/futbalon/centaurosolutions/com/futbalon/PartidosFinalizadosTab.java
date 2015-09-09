package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import futbalon.centaurosolutions.com.futbalon.controllers.ServiceController;

public class PartidosFinalizadosTab extends Activity implements Response.Listener<JSONObject>, Response.ErrorListener {

    ListView lv;
    Context context;
    ArrayList prgmName;
    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private String toDate;
    private String fromDate;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    Response.Listener<JSONObject> response;
    Response.ErrorListener responseError;

    ArrayList<Partido> partidos = new ArrayList<Partido>();
    ServiceController serviceController;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos_finalizados_tab);

        response = this;
        responseError=this;
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        findViewsById();

        setDateTimeField();
        toDate = toDateEtxt.getText().toString();
        fromDate = fromDateEtxt.getText().toString();

        serviceController = new ServiceController();
        String url = "http://services.futbalon.com/aggregators/matches/getFinishMatchesByDateRange?idUser=12018&fromValue="+fromDate+"&toValue="+ toDate;
        serviceController.jsonObjectRequest(url, Request.Method.GET, null, response, responseError);

        fromDateEtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog.show();
            }
        });

        toDateEtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDatePickerDialog.show();
            }
        });

        fromDateEtxt.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable s) {
                toDate = toDateEtxt.getText().toString();
                fromDate = fromDateEtxt.getText().toString();
                serviceController = new ServiceController();
                String url = "http://services.futbalon.com/aggregators/matches/getFinishMatchesByDateRange?idUser=12018&fromValue="+fromDate+"&toValue="+ toDate;

                if(CheckDates(fromDate,toDate))
                {
                    serviceController.jsonObjectRequest(url, Request.Method.GET, null, response, responseError);
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(PartidosFinalizadosTab.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Advertencia");

                    // Setting Dialog Message
                    alertDialog.setMessage("Verifique que la fecha inicial sea menor o igual a la fecha final ");

                    // Setting OK Button
                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();
                }

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        toDateEtxt.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable s) {
                toDate = toDateEtxt.getText().toString();
                fromDate = fromDateEtxt.getText().toString();
                serviceController = new ServiceController();
                String url = "http://services.futbalon.com/aggregators/matches/getFinishMatchesByDateRange?idUser=12018&fromValue="+fromDate+"&toValue="+ toDate;

                if(CheckDates(fromDate,toDate)){
                    serviceController.jsonObjectRequest(url, Request.Method.GET,null,response,responseError);
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(PartidosFinalizadosTab.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Advertencia");

                    // Setting Dialog Message
                    alertDialog.setMessage("Verifique que la fecha inicial sea menor o igual a la fecha final ");

                    // Setting OK Button
                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }


    public static boolean CheckDates(String from_date, String to_date)    {
        SimpleDateFormat dfDate  = new SimpleDateFormat("dd/MM/yyyy");
        boolean b = false;
        try {
            if(dfDate.parse(from_date).before(dfDate.parse(to_date)))
            {
                b = true;//If start date is before end date
            }
            else if(dfDate.parse(from_date).equals(dfDate.parse(to_date)))
            {
                b = true;//If two dates are equal
            }
            else
            {
                b = false; //If start date is after the end date
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }

    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(R.id.etxt_fromdate);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        toDateEtxt = (EditText) findViewById(R.id.etxt_todate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField()
    {
        Calendar currDate = Calendar.getInstance();
        toDateEtxt.setText(dateFormatter.format(currDate.getTime()));
        currDate.add(Calendar.DAY_OF_MONTH,-7);
        fromDateEtxt.setText(dateFormatter.format(currDate.getTime()));



        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onResponse(JSONObject response) {

        Log.d("Response", response.toString());
        // vista.setText(response.toString());

        JSONArray jsonArray ;
        JSONObject jsonObject;
        lv = (ListView) findViewById(R.id.listView);

        try
        {
            jsonArray = response.getJSONArray("matches");
            Partido miPartido = new Partido();

            partidos = miPartido.createArrayListPartidoFromResponse(jsonArray);
            lv.setAdapter(new CustomAdapter(this, partidos));
        }
        catch (Exception ex){

        }
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
        getMenuInflater().inflate(R.menu.menu_partidos_finalizados_tab, menu);
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
