package com.example.ysfrdvn.senerproje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity  {

    Spinner spinner;
    showProducts show;

   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = findViewById(R.id.spinner);
       String[] items = new String[]{"Lütfen Departman Seçiniz","lokum", "recel", "pekmez","helva","cikolata","akide","uretilen"};

       ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("Lütfen Departman Seçiniz"))
                    Toast.makeText(MainActivity.this,"LUTFEN BİR DEPARTMAN SECİNİZ",Toast.LENGTH_LONG).show();
                else{
                    show = new showProducts(MainActivity.this,spinner);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final ListView lst= findViewById(R.id.ertan);
       lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               if(spinner.getSelectedItem().toString()!="uretilen") {
                   String item = show.showPage(position);
                   Intent i = new Intent(MainActivity.this, Main2Activity.class);
                   i.putExtra("value", item);
                   i.putExtra("table", spinner.getSelectedItem().toString());
                   startActivity(i);
               }
               else{
                   String item = show.showPage(position);
                   Intent i = new Intent(MainActivity.this, Main3Activity.class);
                   i.putExtra("value", item);
                   startActivity(i);
               }
              // Toast.makeText(MainActivity.this,item,Toast.LENGTH_LONG).show();
               return false;
           }
       });

   }

}
