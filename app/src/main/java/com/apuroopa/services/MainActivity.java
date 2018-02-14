package com.apuroopa.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener//implements View.OnClickListener//
 {

    private Button startService;
    private Button stopService;
    private Intent serviceIntent;
    private String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startService = findViewById(R.id.startService);
        stopService= findViewById(R.id.stopService);

        serviceIntent = new Intent(getApplicationContext(),MyService.class);

         startService.setOnClickListener(this);
         stopService.setOnClickListener(this);

       /* startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("-------on start service clicked");

                startService(serviceIntent);

            }
        });*/
        Log.i(TAG," "+Thread.currentThread().getId());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*@Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.startService:
                System.out.println("-------on start service clicked");
                startService(serviceIntent);
                break;

            case R.id.stopService:
                break;
        }
    }*/

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



     @Override
     public void onClick(View v) {
         switch (v.getId()){
             case R.id.startService:
                 System.out.println("-------on start service clicked");
                 startService(serviceIntent);
                 break;

             case R.id.stopService:
                 stopService(serviceIntent);
                 break;
         }
     }
 }
