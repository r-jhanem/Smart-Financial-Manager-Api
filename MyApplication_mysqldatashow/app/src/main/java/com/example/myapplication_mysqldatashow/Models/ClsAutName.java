package com.example.myapplication_mysqldatashow.Models;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.ListAdapter;
import com.example.myapplication_mysqldatashow.List_All_Users;
import com.example.myapplication_mysqldatashow.MainActivity4_drop;
import com.example.myapplication_mysqldatashow.MainActivity_mysqlserver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClsAutName  extends  ClsEmpleyy implements Decoment_Ectronic<ClsEmpleyy> {
    public static ArrayList<List_All_Users> mList = new ArrayList<List_All_Users>();
    public Context context;
    public ClsAutName(Context context)
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
    
    
        String TypeOprtion=t.getType();
        String date=t.getDate();
        
        String gresr=t.getDetails();
        String sol=t.getPassowrds();
    
    
    
        if (TextUtils.isEmpty(TypeOprtion)) {
            Toast.makeText(context, "يجب تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
           // Toast.makeText(context, "تم التسجيل بنجاح"+User_name, Toast.LENGTH_SHORT).show();
        
        }  else {
    
    
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                      SEND_DATA_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        JSONObject jsonResponse = jsonArray.getJSONObject(0);
                        String success = jsonResponse.getString("success");
                    
                        //String UserType2 = responsS.getString("type").trim();
                    
                    
                    
                    
                    
                        if (success.contains("Error")) {
                            //   Toast.makeText(LogIn.this, " تم تسجيل الدخول  ", Toast.LENGTH_SHORT).show();
                        
                        
                            Toast.makeText(context, "لم تتم العملية بنجاح", Toast.LENGTH_SHORT).show();
                        
                        }
                        else  if (success.contains("Reg_OK")) {
                        
                            Toast.makeText(context, "تمت العملية بنجاح", Toast.LENGTH_SHORT).show();
    
    
                            Intent in = new Intent(context, MainActivity_mysqlserver.class);
    
    
                            in.putExtra("infromation_user_intent", "decoment");
    
    
                          context.  startActivity(in);
                        
    
                    }
                        else
                        {
                        
                        
                            Toast.makeText(context, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                        
                        
                            //  Intent in=new Intent(LogIn.this,All_Users_list.class);
                        
                            //  in.putExtra("name",User_name);
                        
                        
                            //  startActivity(in);
                        
                            // startActivity(new Intent(LogIn.this, All_Users_list.class));
                        }
                        queue.stop();
                    
                    } catch (JSONException e) {
                        Toast.makeText(context, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                    
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
                    MapData.put("TypOpration", TypeOprtion);
                    MapData.put("date", date);
    
                    MapData.put("Sol", sol);
                    MapData.put("gresr", gresr);
                    
                    
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
    
    
    public static void Get_All_Data_Report(String nameh, String userid, String usertype, ListView listView,Context context) {
        ProgressDialog progressDialog = null;
        int sol_sum=0,sol_end=0,sol_prind=0
                  ;
        mList.clear();
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                    
                    
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
    
                        String User_name = responsS.getString("name").trim();
                        String Sol = responsS.getString("balance_due").trim();
                        String amount_due = responsS.getString("amount_due").trim();
                        String amount_paid = responsS.getString("amount_paid").trim();
    
                        int due = Integer.parseInt(amount_due);
                        int paid = Integer.parseInt(amount_paid);
    
                        
    
                        String CountDecoment = responsS.getString("CountDecoment").trim();
                        String Type7 = "0";
                        String Sol1 = "0";
                        Sol1=Sol;
                        //sol_sum+= Integer.parseInt(Sol);
                        if (Sol1 != null) {
                            int sols = Integer.parseInt(Sol);
                            // استخدم قيمة العدد الصحيح في الاستخدام اللاحق هنا
                            
                            
                            if (sols < 0) {
                                sols = sols * -1;
                                
                            }
                            
                            Sol1 = String.valueOf(sols);
                            
                            
                            if (sols < 0) {
                                Type7 = "علبه";
                                
                            } else
                                Type7 = "له";
                            
                            
                            
                            //String CountDecoment = responsS.getString("CountDecoment").trim();
                            
                            //String key_decoment2 = responsS.getString("key_decoment").trim();
                            
                        }
    
    
    
    
                        if(User_name.contains("الكل"))
    
                        {
                            String h="rr";
        
                        }
                        else
                            //    Toast.makeText(context, ":"+Staty+""+Type, Toast.LENGTH_SHORT).show();
                            //  mListss.add(new Employee(User_name, Sol, amount_paid, amount_due));
    
                        mList.add(new List_All_Users(10,  Sol1,  amount_paid, amount_due, Type7, amount_due, User_name));
                        
                        
                        queue.stop();
                    }
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
    

// قبل استخدام progressDialog، قم بالتحقق من تهيئته
            
    
           
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
            
                params.put("name", nameh);
               
                
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
}
