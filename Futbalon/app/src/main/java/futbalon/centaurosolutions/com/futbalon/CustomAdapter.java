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
}
