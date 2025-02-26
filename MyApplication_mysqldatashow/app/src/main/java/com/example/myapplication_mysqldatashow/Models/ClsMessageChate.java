package com.example.myapplication_mysqldatashow.Models;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClsMessageChate extends ClsEmpleyy implements Decoment_Ectronic<ClsEmpleyy> {
    public static final String SEND_DATA_UR = "http://192.168.1.105/test_anroid_mysql_php2/insert_decoment.php";
    
    Context context;
    public ClsMessageChate(Context context)
    {
        this.context=context;
    }
    
    @Override
    public List<ClsEmpleyy> list() {
        return null;
    }
    
    @Override
    public ClsEmpleyy Find(int id) {
        return null;
    }
    
    @Override
    public void add(ClsEmpleyy t) {
        String sol=t.getDate();
    
        String gresr=t.getDetails();
       // String sol=t.getPassowrds();
    
    
        if (TextUtils.isEmpty(sol) || TextUtils.isEmpty(gresr)) {
         //   Toast.makeText(context, "يجب تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
           // Toast.makeText(context, "تم التسجيل بنجاح"+User_name, Toast.LENGTH_SHORT).show();
        
        }  else {
        
          //  Toast.makeText(context,gresr+" "+sol, Toast.LENGTH_SHORT).show();
        
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                      SEND_DATA_UR, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        JSONObject jsonResponse = jsonArray.getJSONObject(0);
                        String success = jsonResponse.getString("success");
                    
                        //String UserType2 = responsS.getString("type").trim();
                    
                    
                    
                        Toast.makeText(context, "id:"+success, Toast.LENGTH_SHORT).show();
                    
                    
                        if (success.contains("Error")) {
                            //   Toast.makeText(LogIn.this, " تم تسجيل الدخول  ", Toast.LENGTH_SHORT).show();
                        
                        
                            Toast.makeText(context, "لم يتم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                        
                        }
                        else  if (success.contains("Reg_OK")) {
                        
                            Toast.makeText(context, " يتم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                        }
                     
                        queue.stop();
                    
                    } catch (JSONException e) {
                        //Toast.makeText(context, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                    
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> MapData = new HashMap<>();
                
                
                    MapData = new HashMap<>();
                    MapData.put("TypOpration", "messagechat");
                
                    MapData.put("Sol", sol);
                    MapData.put("date", gresr);
                
                
                    return MapData;
                }
            };
        
            queue.add(stringRequest);
            stringRequest.setShouldCache(false);
        
        }
    }
    
    @Override
    public void update(ClsEmpleyy t) {
    
    }
    
    @Override
    public void delete(String key) {
    
    }
}
