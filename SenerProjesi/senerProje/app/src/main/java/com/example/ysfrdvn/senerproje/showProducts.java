package com.example.ysfrdvn.senerproje;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class showProducts {
    private ListView mainListView ;
    private ArrayList<String> list;
    private ArrayAdapter<String> listAdapter ;
    Response.Listener<String> mListener;
    Activity ss = new Activity();
    public showProducts(Activity c, final Spinner spinner){
            ss = c;
           final Spinner s = spinner;
        Response.ErrorListener errorListener= new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        if(true)
        {
            RequestQueue queue = Volley.newRequestQueue(ss);

            String url = "http://192.168.1.2/deneme.php";    // Post atılan adres.
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            //response=response.replace("[","{");
                           //response=response.replace("]","}");
                           // Toast.makeText(ss,response,Toast.LENGTH_LONG).show();
                            jsonParser jsonParser=new jsonParser(ss);
                            try {
                                if(spinner.getSelectedItem().toString()=="uretilen")
                                    list=jsonParser.parser(response,spinner.getSelectedItem().toString());
                                else
                                    list= jsonParser.parser(response);
                               setListView();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            // Toast.makeText(ss,response,Toast.LENGTH_LONG).show();
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
                    params.put("request", "andShowProduct");
                    params.put("table", s.getSelectedItem().toString());
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
    public void setListView(){

        // Create ArrayAdapter using the planet list.
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(ss,android.R.layout.simple_list_item_1,list);

        mainListView=ss.findViewById(R.id.ertan);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );
    }
    public String showPage(int positon){
        String i=list.get(positon);
        return i;
    }
}
