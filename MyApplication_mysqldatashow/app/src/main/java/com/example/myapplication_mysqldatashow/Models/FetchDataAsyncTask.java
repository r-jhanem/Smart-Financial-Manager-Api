package com.example.myapplication_mysqldatashow.Models;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.List_All_Users;
import com.example.myapplication_mysqldatashow.MainActivity4_drop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FetchDataAsyncTask extends AsyncTask<Void, Void, String> {
    public static ArrayList<List_All_Users> mList=new ArrayList<List_All_Users>();
    
    private String name;
    private String password;
    private Context context;
    
    public FetchDataAsyncTask(String name, String password, Context context) {
        this.name = name;
        this.password = password;
        this.context = context;
    }
    
    @Override
    protected String doInBackground(Void... voids) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, MainActivity4_drop.uri_P_2 + "LogIn.php",
                  new Response.Listener<String>() {
                      @Override
                      public void onResponse(String response) {
                          try {
                              JSONArray jsonArray = new JSONArray(response);
                              JSONObject jsonResponse = jsonArray.getJSONObject(0);
                              JSONArray jsonArray_usersS = jsonResponse.getJSONArray("Users_Data");
                              String g = String.valueOf(jsonArray_usersS);
                              List<String> mListss = new ArrayList<>();
                              List<String> mListss2 = new ArrayList<>();
                              String[] dd = new String[jsonArray_usersS.length()];
                              String[] ddd = new String[jsonArray_usersS.length()];
                              String maness = "";
                              int cnam = 0;
                              int cn = 0;
                              mList.clear();
                              if (!(g.contains("error"))) {
                                  if (jsonArray_usersS.length() > 0) {
                                      for (int i = 0; i < jsonArray_usersS.length(); i++) {
                                          JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                                          String id_user = responsS.getString("id").trim();
                                          int idu = Integer.parseInt(id_user);
                                          String pass = responsS.getString("pass").trim();
                                          String User_name = responsS.getString("name").trim();
                                          String Type = responsS.getString("type").trim();
                                          String Sol_user = responsS.getString("balance_due").trim();
                                          String amount_due = responsS.getString("amount_due").trim();
                                          String amount_paid = responsS.getString("amount_paid").trim();
                                          String CountDecoment = responsS.getString("CountDecoment").trim();
                                          
                                          String iduer = String.valueOf(idu);
                                          SaveSettings.id_decoment = "j";
                                          
                                          SaveSettings.UserID = User_name;
                                          SaveSettings.TypeUser = Type;
                                          SaveSettings.UserID_id = iduer;
                                          SaveSettings.SolAll = Sol_user;
                                          SaveSettings.pass = pass;
                                          SaveSettings.Sol_end = amount_due;
                                          SaveSettings.Sol_prid = amount_paid;
                                          SaveSettings.Count_decoment = CountDecoment;
                                          
                                          SaveSettings sv = new SaveSettings(context);
                                          sv.SaveData();
                                          
                                          Intent intent = new Intent(context, MainActivity4_drop.class);
                                          context.startActivity(intent);
                                      }
                                  } else {
                                      Toast.makeText(context, "لم تم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                                  }
                              } else {
                                  Toast.makeText(context, "اسم المستخدم او كلمة المرور غير صحيح" + g, Toast.LENGTH_SHORT).show();
                              }
                              queue.stop();
                          } catch (JSONException e) {
                              e.printStackTrace();
                          }
                      }
                  }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("phone", password);
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        return null;
    }
    
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Handle the result if needed
    }
}