package com.example.ysfrdvn.senerproje;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ekleme {
    Activity ss = new Activity();
    EditText userTut;
    EditText passTut;
    public ekleme(Activity c,EditText a,EditText b){
        ss = c;
        userTut = a;
        passTut=b;

        Response.ErrorListener errorListener= new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };

        if(true)
        {
            RequestQueue queue = Volley.newRequestQueue(ss);

            String url = "http://192.168.1.2/kaydol.php";    // Post atılan adres.
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(ss,response,Toast.LENGTH_LONG).show();

                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(ss,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("username", userTut.getText().toString());
                    params.put("password", passTut.getText().toString());

                    return params;
                }
            };
            queue.add(postRequest);
        }
        else
        {
            Toast.makeText(ss,"Lütfen Gerekli Alanları Doldurun",Toast.LENGTH_LONG).show();
        }

    }
}
/*
        EditText txtUsername;
        EditText txtPassword;
        xtUsername= (EditText) findViewById(R.id.txtUsername);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        Button btn = findViewById(R.id.btnEkle);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    ekleme e = new ekleme(MainActivity.this,txtUsername,txtPassword);
            }});

            Button toastbtn = findViewById(R.id.toast);
       toastbtn.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,"Merhaba",Toast.LENGTH_LONG).show();
           }
       });

 */
//    tw.setText(spinner.getSelectedItem().toString());

//Toast.makeText(MainActivity.this,spinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();