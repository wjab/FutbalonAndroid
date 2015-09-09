package futbalon.centaurosolutions.com.futbalon;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TabHost;
import android.util.Log;
import android.widget.TabWidget;
import android.widget.TextView;

public class Partidos extends TabActivity implements TabHost.OnTabChangeListener {

    TabHost tabHost;
    User userObject = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_partidos);

        tabHost = getTabHost();

        // Set TabChangeListener called when tab changed
        tabHost.setOnTabChangedListener(this);

        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent();
        userObject = (User)intent.getSerializableExtra("user");


        // Create  Intents to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, PartidosPendientesTab.class);
        spec = tabHost.newTabSpec("First").setIndicator("Partidos")
                .setContent(intent);

        //Add intent to tab
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, PartidosFinalizadosTab.class);
        spec = tabHost.newTabSpec("Second").setIndicator("Partidos Finalizados")
                .setContent(intent);
        tabHost.addTab(spec);


        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.color.futbalon_background);
        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.color.futbalon_background);

        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.color.futbalon_blue);


        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setAllCaps(false);
            tv.setTextColor(Color.WHITE);
        }



    }

    @Override
    public void onTabChanged(String tabId) {

        /************ Called when tab changed *************/

        //********* Check current selected tab and change according images *******/

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.futbalon_background);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.futbalon_background);

        }


        Log.i("tabs", "CurrentTab: "+tabHost.getCurrentTab());

        if(tabHost.getCurrentTab()==0)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.color.futbalon_blue);
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.color.futbalon_blue);
        else if(tabHost.getCurrentTab()==2)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.color.futbalon_blue);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_partidos, menu);
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
