package com.example.myapplication_mysqldatashow.Models;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.IfPrintReport;
import com.example.myapplication_mysqldatashow.ListAdapter;
import com.example.myapplication_mysqldatashow.List_All_Users;
import com.example.myapplication_mysqldatashow.MainActivity4_drop;
import com.example.myapplication_mysqldatashow.MainActivity_mysqlserver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.myapplication_mysqldatashow.MainActivity4_drop.uri_P_2;

public  class clsDecoment implements Decoment_Ectronic<clsDecomentPropertis> {
    
    public static String typ_option = "";
    public static String url_post_add =
              
              "";
    
    
    private List<List_All_Users> items = new ArrayList<>(); // قائمة العناصر
    private ListAdapter adapter; // الـ Adapter المستخدم في ListView
    private int page = 1; // عدد الصفحات المحملة
    
    
    public JSONArray jsonArray_usersS = null;
    
    private boolean isLoading = false;
    
    List<clsDecomentPropertis> list;
    DateFormat dateFormat;
    public Context context;
    private ProgressDialog progressDialog;
    private static int i = 0;
    public int xd = 0;
    private static final String SEND_DATA_URL = uri_P_2 + "insert_decoment.php";
    // public ListView listView;
    public static ArrayList<List_All_Users> mList = new ArrayList<List_All_Users>();
    
    public clsDecoment(Context context) {
        this.context = context;
    }
    
    @Override
    public List<clsDecomentPropertis> list() {
        return list;
    }
    
    @Override
    public clsDecomentPropertis Find(int id) {
        return null;
    }
    
    @Override
    public void add(clsDecomentPropertis t) {
        int z = 0, n = 0;
    
        String d = t.Date, x = "", k = "";
    
    
        String date = getSendDataUrl_date(d);
        String types_admin = t.Type;
        String gresr = t.Details;
        String sol = t.getSol();
        String User_name = t.User_name;
    
        String NameAuthor = t.NameAuthor;
    
    
        if (TextUtils.isEmpty(types_admin) || TextUtils.isEmpty(User_name) || TextUtils.isEmpty(date) || TextUtils.isEmpty(sol) || TextUtils.isEmpty(gresr)) {
            Toast.makeText(context, "يجب تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
            return;
        } else {
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Method.POST,
                      uri_P_2 + "insert_decoment.php", new Response.Listener<String>() {
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
                        
                        } else if (success.contains("Reg_OK")) {
                        
                            Toast.makeText(context, "تمت العملية بنجاح", Toast.LENGTH_SHORT).show();
                        
                        
                            Intent in = new Intent(context, MainActivity_mysqlserver.class);
                        
                        
                            in.putExtra("infromation_user_intent", "decoment");
                        
                        
                            context.startActivity(in);
                        
                        
                        } else {
                        
                        
                            Toast.makeText(context, "تمت العملية", Toast.LENGTH_SHORT).show();
                        
                        
                            //  Intent in=new Intent(LogIn.this,All_Users_list.class);
                        
                            //  in.putExtra("name",User_name);
                        
                        
                            //  startActivity(in);
                        
                            // startActivity(new Intent(LogIn.this, All_Users_list.class));
                        }
                        queue.stop();
                    
                    } catch (JSONException e) {
                        Toast.makeText(context, "خطا تاكد من البيانات", Toast.LENGTH_SHORT).show();
                    
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Velle", "Error");
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("TypOpration", typ_option);
                    params.put("User_name_decoment", User_name);
                    params.put("date_decoment", date);
                    params.put("Sol_decoment", sol);
                    params.put("gresr_decoment", gresr);
                    params.put("NameAuthor_decoment", NameAuthor);
                
                    params.put("types_admin_decoment", types_admin);
                
                
                    return params;
                }
            };
        
            queue.add(stringRequest);
            stringRequest.setShouldCache(false);
        
        }
    
    
    }
    
    @Override
    public void update(clsDecomentPropertis t) {
    
    }
    
    @Override
    public void delete(String key) {
    
    }
    
    
    public void Get_All_Data_date5(String nameh, String ToDate_2, ListView listView, Context context) {
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.POST,
                  uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    mList.clear();
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                    Toast.makeText(context, "Please enter course id" + jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        // String iduser = responsS.getString("UserKey");
                        
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("sol").trim();
                        String Sol = responsS.getString("TYPE").trim();
                        String amount_due = responsS.getString("key_decoment").trim();
                        String amount_paid = responsS.getString("DATE").trim();
                        
                        int due = 0;
                        int paid = 4;
                        String Type = "";
                        
                        if (due > paid) {
                            Type = "علبه";
                            
                        } else
                            Type = "له";
                        
                        
                        String CountDecoment = responsS.getString("CountDecoment").trim();
                        
                        String key_decoment = responsS.getString("key_decoment").trim();
                        
                        
                        Toast.makeText(context, ":" + Type, Toast.LENGTH_SHORT).show();
                        
                        mList.add(new List_All_Users(4, User_name, "0", Sol, Type, CountDecoment, key_decoment));
                        
                        
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                        //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                    }
                    
                    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Log.d("Error.ResponseAPI", e.toString());
                    Log.e("TAG", "Error message: " + e.getMessage());
                    
                }
    
    
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
                
                
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserKey", MainActivity.Local_UserKey);
                params.put("name", nameh);
                //  params.put("FromDate", FromDate_1);
                params.put("ToDate", ToDate_2);
                
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    
    public void Get_All_Datyya(String nameh, String nameh_id, String decomentone, String ToDate_2, ListView listView, Context context) {
        
        mList.clear();
    
    
        String uril = "https://eis.amu.edu.ye/getsearch_user.php";
    
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest igRequest = new JsonObjectRequest(Method.GET,
                  uri_P_2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
    
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        });
        queue.add(igRequest);
        
    }
    
    
    public void Get_All_Data(String nameh, String nameh_id, String decomentone, String ToDate_2, ListView listView, Context context) {
    
        mList.clear();
    
        // String uril="https://eis.amu.edu.ye/getsearch_user.php";
        String uril = "https://raadjhanem.000webhostapp.com/dbraadfile/getsearch_user.php";
    
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST,
                  uril, null, (Response.Listener<JSONObject>) response -> {
            try {
        
                JSONArray jsonArray_user = response.getJSONArray("All_Users");
        
        
                JSONObject jsonArray_usersS = jsonArray_user.getJSONObject(0);
        
        
                //  JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
        
        
                mList.clear();
                for (int i = 0; i < jsonArray_user.length(); i++) {
            
            
                    JSONObject responsS = jsonArray_user.getJSONObject(i);
            
                    String iduser = responsS.getString("key_decoment");
            
                    // int idu= responsS.getInt("id");type
                    String User_name = responsS.getString("name").trim();
                    String Staty = responsS.getString("stat").trim();
                    String Sol = responsS.getString("sol").trim();
                    String date = responsS.getString("date").trim();
                    String datty = responsS.getString("type").trim();
                    String Detils = responsS.getString("detils").trim();
            
                    String n = User_name;
            
                    int sols = Integer.parseInt(Sol);
                    if (sols < 0) {
                        sols = sols * -1;
                
                    }
                    xd = 10;
            
                    if (Staty.contains("L")) {
                        Staty = "معلق";
                
                    } else if (Staty.contains("N")) {
                        Staty = "مغلي";
                    } else
                
                        Staty = "جاهز";
            
                    String soll = String.valueOf(sols);
            
            
                    // mList.add(new List_All_Users(5));
                    mList.add(new List_All_Users(12, Detils, date, soll, datty, Staty, iduser, User_name));
            
            
                    //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
            
                    //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
            
                }
        
        
                queue.stop();
            } catch (JSONException e) {
                e.printStackTrace();
            }
    
            ListAdapter ld = new ListAdapter(context, mList);
            listView.setAdapter(ld);
          
                      
                      /*
                      if(!HomeFragment.MyPRE_box_print.equals("c")) {
              
              
                          ListAdapter ld = new ListAdapter(context, mList);
                          listView.setAdapter(ld);
                      }
                      
                      if(HomeFragment.MyPRE_box_print.equals("c")) {
          
          
                          IfPrintReport cl = new IfPrintReport(context);
                          cl.createReportDocument(mList);
          
          
                      }
          */
    
    
            // قبل استخدام progressDialog، قم بالتحقق من تهيئته
    
            // listView.setAdapter(ld);
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserKey", MainActivity.Local_UserKey);
                params.put("name", nameh);
    
                params.put("FromDate", decomentone);
                params.put("ToDate", ToDate_2);
                
                params.put("nameh_id", nameh_id);
    
                return params;
            }
        };
        queue.add(stringRequest);
        
        
    }
    
    public void Get_All_Data_Spiner_22(String nameh, String decomentone, String ToDate_2, ListView listView, Context context) {
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.POST,
                  uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                    //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    mList.clear();
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
    
    
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        String iduser = responsS.getString("key_decoment");
                        
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Staty = responsS.getString("stat").trim();
                        String Sol = responsS.getString("sol").trim();
                        String date = responsS.getString("date").trim();
                        String datty = responsS.getString("type").trim();
                        String Detils = responsS.getString("detils").trim();
                        
                        // String Type = responsS.getString("type").trim();
                        // dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                        String hdate=dateFormat.format(date);
                        
                        String n = User_name;
                        
                        int sols = Integer.parseInt(Sol);
                        if (sols < 0) {
                            sols = sols * -1;
                            
                        }
                        
                        
                        if (Staty.contains("L")) {
                            Staty = "معلق";
                            
                        } else if (Staty.contains("N")) {
                            Staty = "مغلي";
                        } else
                            
                            Staty = "جاهز";
                        
                        String soll = String.valueOf(sols);
                        
                        
                        // mList.add(new List_All_Users(5));
                        mList.add(new List_All_Users(3, Detils, date, soll, datty, Staty, iduser));
                        
                        
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                        //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                    }
                    
                    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
    
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
                
                listView.setAdapter(ld);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserKey", MainActivity.Local_UserKey);
                params.put("name", nameh);
                params.put("ToDate", ToDate_2);
                params.put("FromDate", decomentone);
                params.put("nameh_id", decomentone);
    
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    public void Get_All_Data_Spiner(String nameh, String decomentone, String ToDate_2, ListView listView, Context context) {
    
        mList.clear();
    
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.POST,
          
                  uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
    
    
                    mList.clear();
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
    
    
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        String iduser = responsS.getString("key_decoment");
                        String dite = responsS.getString("dite").trim();
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Staty = responsS.getString("stat").trim();
                        String Sol = responsS.getString("sol").trim();
                        String date = responsS.getString("date").trim();
                        String datty = responsS.getString("type").trim();
                        String Detils = responsS.getString("detils").trim();
    
    
                        String n = User_name;
    
                        int sols = Integer.parseInt(Sol);
                        if (sols < 0) {
                            sols = sols * -1;
        
                        }
    
    
                        if (Staty.contains("L")) {
                            Staty = "معلق";
                            
                        } else if (Staty.contains("N")) {
                            Staty = "مغلي";
                        } else
                            
                            Staty = "جاهز";
                        
                        String soll = String.valueOf(sols);
    
    
                        // mList.add(new List_All_Users(5));
                        mList.add(new List_All_Users(3, Detils, date, soll, datty, Staty, iduser, dite));
    
    
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                        //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                    }
                    
                    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
    
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
    
                //  listView.setAdapter(ld);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserKey", MainActivity.Local_UserKey);
                params.put("name", nameh);
                params.put("ToDate", ToDate_2);
                params.put("FromDate", decomentone);
                
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    public static String getSendDataUrl_date(String datex) {
        
        int z = 0, n = 0, y = 0, f = 0;
        String d = datex, x = "", k = "";
        
        
        for (char c : d.toCharArray()) {
            if (!(c == '/')) {
                if (z > 0 && z < 2) {
    
                    k += c;
                } else if (z == 2 && f == d.length() - 1) {
    
    
                    x += "0";
                    x += c;
                } else {
                    if (z == 2)
                        z++;
    
                    x += c;
    
                }
            } else {
    
    
                if (z > 0) {
                    n = Integer.parseInt(String.valueOf(k));
                    if (n < 10 && k.length() < 2) {
    
                        x += "0";
                        x += k;
    
                    } else
                        x += k;
        
        
                }
                z++;
    
    
            }
            
            f++;
            
        }
        return x;
    }
    
    public void Get_All_Data_Spiner_Login_date_date(String nameh, String nameh_id, String decomentone, String ToDate_2, ListView listView, Context contextt) {
    
    
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.GET,
                  uri_P_2 + "UpdateUser_enter_app.php?name=" + nameh + "&FromDate=" + decomentone + "&ToDate=" + ToDate_2 + "&nameh_id=" + nameh_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
    
                    JSONArray jsonArray = new JSONArray(response);
    
    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
    
    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
    
    
                    mList.clear();
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
    
    
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
    
                        String iduser = responsS.getString("key_decoment");
    
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Staty = responsS.getString("stat").trim();
                        String Sol = responsS.getString("sol").trim();
                        String date = responsS.getString("date").trim();
                        String datty = responsS.getString("type").trim();
                        String Detils = responsS.getString("detils").trim();
    
                        String n = User_name;
    
                        int sols = Integer.parseInt(Sol);
                        if (sols < 0) {
                            sols = sols * -1;
    
                        }
                        xd = 10;
    
                        if (Staty.contains("L")) {
                            Staty = "معلق";
        
                        } else if (Staty.contains("N")) {
                            Staty = "مغلي";
                        } else
        
                            Staty = "جاهز";
    
                        String soll = String.valueOf(sols);
    
    
                        // mList.add(new List_All_Users(5));
                        mList.add(new List_All_Users(12, Detils, date, soll, datty, Staty, iduser, User_name));
    
    
                    }
    
    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
          
                      
                      /*
                      if(!HomeFragment.MyPRE_box_print.equals("c")) {
              
              
                          ListAdapter ld = new ListAdapter(context, mList);
                          listView.setAdapter(ld);
                      }
                      
                      if(HomeFragment.MyPRE_box_print.equals("c")) {
          
          
                          IfPrintReport cl = new IfPrintReport(context);
                          cl.createReportDocument(mList);
          
          
                      }
          */
    
    
                // قبل استخدام progressDialog، قم بالتحقق من تهيئته
            }
            // listView.setAdapter(ld);
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
        
            }
        });
        queue.add(stringRequest);
    
    
    }
    
    public static void Get_All_Data_Spiner_Login_print(Context context){
    
        IfPrintReport cl = new IfPrintReport(context);
        cl.createReportDocument(mList);
    
}

    
                    public   void Get_All_Data_Spiner_Login_date( String nameh,String decomentone, String ToDate_2, ListView listView, Context context) {
    
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.GET,
                  uri_P_2+"UpdateUser_enter_app.php?name="+nameh+"&FromDate="+decomentone+"&ToDate="+ToDate_2+"&nameh_id="+decomentone, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                  
                    JSONArray jsonArray = new JSONArray(response);
    
    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
    
    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
    
    
                    //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    
                    mList.clear();
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
        
        
        
        
        
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
        
                        String iduser = responsS.getString("key_decoment");
        
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Staty = responsS.getString("stat").trim();
                        String Sol = responsS.getString("sol").trim();
                        String date = responsS.getString("date").trim();
                        String datty = responsS.getString("type").trim();
                        String Detils = responsS.getString("detils").trim();
        
                        // String Type = responsS.getString("type").trim();
                        // dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                        String hdate=dateFormat.format(date);
        
                        String n=User_name;
        
                        int sols=Integer.parseInt(Sol);
                        if(sols<0)
                        {
                            sols=sols*-1;
            
                        }
        
        
                        if(Staty.contains("L"))
                        {
                            Staty="معلق";
            
                        }
                        else  if(Staty.contains("N"))
        
                        {
                            Staty="مغلي";
                        }
                        else
            
                            Staty="جاهز";
        
                        String soll=String.valueOf(sols);
        
        
                        mList.add(new List_All_Users(3,Detils, date, soll,datty,Staty,iduser));
        
        
                       
                    }
    
    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
    
    
    
                ListAdapter     ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
    
                listView.setAdapter(ld);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
        
            }
        }) ;
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    
    
    }
    
    
    public   void Get_All_Data_Spiner_Login( String nameh,String Passowrod, Context context) {
        
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.GET,
                  uri_P_2+"LogIn.php?name="+nameh+"&phone="+Passowrod, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("Users_Data");
                    
                    String g=String.valueOf(jsonArray_usersS);
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
            
                              //  int idu = Integer.parseInt(id_user);
            
                                String pass = responsS.getString("pass").trim();
            
                                String User_name = responsS.getString("name").trim();
                                //    String Staty = responsS.getString("phone").trim();
                                String Type = responsS.getString("type").trim();
            
            
                                String Sol_user = responsS.getString("balance_due").trim();
                                String amount_due = responsS.getString("amount_due").trim();
                                String amount_paid = responsS.getString("amount_paid").trim();
                                String CountDecoment = responsS.getString("CountDecoment").trim();
            
                                //String datty = responsS.getString("type").trim();
                                SaveSettings.id_decoment = "j";
            
            
                                SaveSettings.UserID = User_name;
                                SaveSettings.TypeUser = Type;
                                SaveSettings.UserID_id = id_user;
                                SaveSettings.SolAll = Sol_user;
                                SaveSettings.pass = pass;
                                SaveSettings.Sol_end = amount_due;
                                SaveSettings.Sol_prid = amount_paid;
                                SaveSettings.Count_decoment = CountDecoment;
            
                                SaveSettings sv = new SaveSettings(context);
                                sv.SaveData();
                                //Toast.makeText(LogIn.this, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();
            
                                Intent intent = new Intent(context, MainActivity4_drop.class);
                                context.startActivity(intent);
            
            
                            }
        
                        } else {
                            Toast.makeText(context, "لم تم تسجيل الدخول", Toast.LENGTH_SHORT).show();
        
                        }
                    }
                        else
                        {
                            i++;
                            if(i==3)
                                System.exit(0);
                            Toast.makeText(context, "اسم المستخدم او كلمة المرور غير صحيح"+g, Toast.LENGTH_SHORT).show();
        
                        }
    
    
    
                        queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                
                
                
              
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            
            }
        })
        
       ;
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    
    
    public   void YesDecoment( String nameh,String Passowrod,String gresr , Context context)
    {
        
        
        
        
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.POST,
                  uri_P_2+"insert_decoment.php", new Response.Listener<String>() {
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
                    }
                    else
                    {
        
        
                        Toast.makeText(context, "لم تتم العملية بنجاح", Toast.LENGTH_SHORT).show();
        
        
                        //  Intent in=new Intent(LogIn.this,All_Users_list.class);
        
                        //  in.putExtra("name",User_name);
        
        
                        //  startActivity(in);
        
                        // startActivity(new Intent(LogIn.this, All_Users_list.class));
                    }
                    queue.stop();
                } catch (JSONException e) {
                    Toast.makeText(context, "خطا تاكد من البيانات", Toast.LENGTH_SHORT).show();
    
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
                Map<String, String> params = new HashMap<>();
            
                params.put("TypOpration", nameh);
                params.put("date", Passowrod);
                params.put("gresr", gresr);
    
    
    
    
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
        
        
    }
    
    
    
    public void loadMoreData_2(ListAdapter listAdapter, List<List_All_Users> mList_list, ListView listView, Context context) {
    

        
            if (isLoading) {
                return;
            }
            isLoading = true;
        
            String url = uri_P_2 + "2UpdateUserProfile.php?page=" + page;
        
            Thread thread = new Thread(() -> {
                JsonObjectRequest request = new JsonObjectRequest(Method.GET, url, null,
                          response -> {
                              List<List_All_Users> newItems = parseResponse(response);
                              if (newItems != null) {
                                  mList_list.addAll(newItems);
                                  page++;
                                  listAdapter.notifyDataSetChanged();
                              }
                              isLoading = false;
                          },
                          error -> isLoading = false);
                Volley.newRequestQueue(context).add(request);
            });
        
            thread.start();
        }
    
    
    
    
    private List<List_All_Users> parseResponse(JSONObject response) {
        List<List_All_Users> itemList = new ArrayList<>();
        try {
            JSONArray jsonArray = response.getJSONArray("All_Users");
            // Toast.makeText(context, "Please enter course id"+jsonArray.length(), Toast.LENGTH_SHORT).show();
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
              
                // String iduser = responsS.getString("UserKey");
    
                // int idu= responsS.getInt("id");type
                String User_id= jsonObject.optString("keyemple").trim();
    
                String User_name =jsonObject.optString("name").trim();
                String Sol =jsonObject.optString("balance_due").trim();
                String amount_due =jsonObject.optString("amount_due").trim();
                String amount_paid = jsonObject.optString("amount_paid").trim();
                String CountDecoment =jsonObject.optString("CountDecoment").trim();
    
                int due = Integer.parseInt(Sol);
                int paid = Integer.parseInt(amount_paid);
                String Type7 = "0";
    
    
                int sols = Integer.parseInt(Sol);
                if (sols < 0) {
                    sols = sols * -1;
        
                }
    
                String soll = String.valueOf(sols);
    
    
                if (due < 0) {
                    Type7 = "علبه";
        
                } else
                    Type7 = "له";
    
    
                //String CountDecoment = responsS.getString("CountDecoment").trim();
    
                //String key_decoment2 = responsS.getString("key_decoment").trim();
    
    
                List_All_Users  item=new List_All_Users(5, User_name, CountDecoment, soll, Type7, amount_due, amount_paid,User_id);
    
                //    mList.add(new List_All_Users(1, name, phone, Max_sol,"u","u2",UserKey));
                itemList.add(item);
                
                
                
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        
        return itemList;
    }
    

}
