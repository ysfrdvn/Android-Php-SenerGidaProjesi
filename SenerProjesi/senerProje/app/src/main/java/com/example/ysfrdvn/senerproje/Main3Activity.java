package com.example.ysfrdvn.senerproje;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tw=findViewById(R.id.textView);
        Button btn=findViewById(R.id.button2);
        tw.setText(getIntent().getStringExtra("value").toString());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.ErrorListener errorListener= new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                };



                RequestQueue queue = Volley.newRequestQueue(Main3Activity.this);

                String url = "http://192.168.1.2/deneme.php";    // Post atılan adres.
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(Main3Activity.this,response,Toast.LENGTH_LONG).show();

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Main3Activity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("request", "correct");
                        int lastindex=getIntent().getStringExtra("value").indexOf("Adı");
                        String id=getIntent().getStringExtra("value").substring(3,lastindex);
                        params.put("id",id);
                        return params;

                    }
                };
                queue.add(postRequest);


                Toast.makeText(Main3Activity.this,"İşlem Başarılı",Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_main2);
                new CountDownTimer(2000, 2000) {

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        setContentView(R.layout.activity_main2);
                    }

                }.start();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }


        });
    }
}
