package com.example.ysfrdvn.senerproje;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class jsonParser extends MainActivity {

    Activity ss=new Activity();


    public jsonParser(){


    }
 public jsonParser(Activity c){
        ss=c;

 }
    public ArrayList<String> parser(String json) throws JSONException {
        String val_test1 = "";
        String val_test2 = "";

        JSONArray jResultArray = new JSONArray(json);
        MainActivity ma=new MainActivity();
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<jResultArray.length(); i++){
            JSONObject jResultObj = jResultArray.getJSONObject(i);
            list.add("id="+jResultObj.getString("id")+
                    " Adı="+jResultObj.getString("name")+
                    " İstenilen Adet="+jResultObj.getString("count")+
                     " Üretilen Adet="+jResultObj.getString("produced")+
                    " barcode="+jResultObj.getString("barcode"));
            //String val_Test1 = jResultObj.getString("test1");
            //String val_Test2 = jResultObj.getString("test2");

        }
        return list;
       // Toast.makeText(ss,val_test1+" "+val_test2,Toast.LENGTH_LONG).show();
    }
    public ArrayList<String> parser(String json,String departmant) throws JSONException {
        String val_test1 = "";
        String val_test2 = "";

        JSONArray jResultArray = new JSONArray(json);
        MainActivity ma=new MainActivity();
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<jResultArray.length(); i++){
            JSONObject jResultObj = jResultArray.getJSONObject(i);
            if(jResultObj.getInt("isCorrect")==0) {
                list.add("id=" + jResultObj.getString("id") +
                        "Departman=" + departmant +
                        " Adı=" + jResultObj.getString("name") +
                        " İstenilen Adet=" + jResultObj.getString("count") +
                        " Üretilen Adet=" + jResultObj.getString("produced") +
                        " barcode=" + jResultObj.getString("barcode"));
            }
            //String val_Test1 = jResultObj.getString("test1");
            //String val_Test2 = jResultObj.getString("test2");

        }
        return list;
        // Toast.makeText(ss,val_test1+" "+val_test2,Toast.LENGTH_LONG).show();
    }


}
