package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Eduardo on 03/09/2015.
 */
public class CustomAdapter extends BaseAdapter{
    ArrayList<Partido> result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Activity mainActivity, ArrayList<Partido> partidos) {
        // TODO Auto-generated constructor stub
        result=partidos;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView partido;
        TextView fecha;
        ImageView equipo1;
        ImageView equipo2;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        String match_score=result.get(position).getEquipo1() + " " + result.get(position).getGolesEquipo1() + " - " + result.get(position).getGolesEquipo2() + " " + result.get(position).getEquipo2();
        rowView = inflater.inflate(R.layout.activity_lista_partidos, null);
        holder.partido=(TextView) rowView.findViewById(R.id.partido);
        holder.equipo1= (ImageView) rowView.findViewById(R.id.img_equipo1);
        holder.equipo2= (ImageView) rowView.findViewById(R.id.img_equipo2);

        getImagenEquipo(result.get(position).getEquipo1(), holder.equipo1);
        getImagenEquipo(result.get(position).getEquipo2(), holder.equipo2);
        holder.partido.setText(match_score);

        holder.fecha=(TextView) rowView.findViewById(R.id.fecha);
        holder.fecha.setText(result.get(position).getFecha());

  /*      rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });*/
        return rowView;
    }

    public void getImagenEquipo(String nombreEquipo, ImageView imagen){

        nombreEquipo = nombreEquipo.toLowerCase();

        if(nombreEquipo.indexOf("belén") != -1){
            imagen.setImageResource(R.mipmap.belen);
        }
        if(nombreEquipo.indexOf("uruguay") != -1){
            imagen.setImageResource(R.mipmap.uruguay);
        }
        if(nombreEquipo.indexOf("saprissa") != -1){
            imagen.setImageResource(R.mipmap.saprissa);
        }
        if(nombreEquipo.indexOf("cartaginés") != -1){
            imagen.setImageResource(R.mipmap.cartago);
        }
        if(nombreEquipo.indexOf("carmelita") != -1){
            imagen.setImageResource(R.mipmap.carmelita);
        }
        if(nombreEquipo.indexOf("liberia") != -1){
            imagen.setImageResource(R.mipmap.liberia);
        }
        if(nombreEquipo.indexOf("perez") != -1){
            imagen.setImageResource(R.mipmap.perez);
        }
        if(nombreEquipo.indexOf("ucr") != -1){
            imagen.setImageResource(R.mipmap.ucr);
        }
        if(nombreEquipo.indexOf("santos") != -1){
            imagen.setImageResource(R.mipmap.santos);
        }
        if(nombreEquipo.indexOf("limón") != -1){
            imagen.setImageResource(R.mipmap.limon);
        }
        if(nombreEquipo.indexOf("alajuelense") != -1){
            imagen.setImageResource(R.mipmap.liga);
        }
        if(nombreEquipo.indexOf("herediano") != -1){
            imagen.setImageResource(R.mipmap.heredia);
        }

    }
}
