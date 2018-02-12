package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import mina.com.jokeslib.joker;
import mina.com.mylibrary.jokesActivity;





public class MainActivity extends AppCompatActivity {

    public static final String GENYMOTION_ROOTURL   = "http://10.0.3.2:8080/_ah/api/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke(View view) {


        joker myjocker = new joker();
        final String joke = myjocker.getJoke();
        final Context context = MainActivity.this;

       // Toast.makeText(this, myjocker.getJoke(), Toast.LENGTH_SHORT).show();



        EndpointAsyncTask jokeFetcherTask = new EndpointAsyncTask(){

            @Override
            protected void onPostExecute(String s) {
                Class jokesactivityclass = jokesActivity.class;
                Intent intent = new Intent(context,jokesactivityclass);
                intent.putExtra("joke",joke);
                startActivity(intent);
            }
        };

        jokeFetcherTask.execute();
    }


}
