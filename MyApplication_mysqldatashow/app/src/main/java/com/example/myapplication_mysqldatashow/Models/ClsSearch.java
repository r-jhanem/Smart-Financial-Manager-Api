
package com.example.myapplication_mysqldatashow.Models;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.ClsSpinerInform;
import com.example.myapplication_mysqldatashow.ClsSpinerInform2;
import com.example.myapplication_mysqldatashow.ClsSpinnerAuths;
import com.example.myapplication_mysqldatashow.ClsSpinnerBrann;
import com.example.myapplication_mysqldatashow.GlobalClass;
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



public class ClsSearch {
   public  String ed_name_use="",ed_name_use_2="";
   
    
    public GlobalClass globalClass;
    public static String uri_P = "http://192.168.1.116/test_anroid_mysql_php2/get_All_Users.php";
    
    public Context context;
    
    public ClsSearch(Context context) {
        this.context = context;
    }
    
    public ClsSearch() {
    
    }
    
    public Spinner ass;
    private Spinner authSpinner;
    private Spinner brSpinner;
    private Spinner boxSpinner;
    private Spinner empSpinner;
    private ArrayList<String> authList;
    private ArrayList<String> brList;
    private ArrayList<String> boxList;
    private ArrayList<String> empList;
    private RequestQueue requestQueue;
    ProgressDialog progressDialog = null;
    
    public static String[] mList_3 = new String[0];
    public static ArrayList<List_All_Users> mList = new ArrayList<>();
    public static ArrayList<String> mList2;
    public static String[] mList3 = new String[0];
    public static String[] mList_2 = new String[0];
    public static String[] mList_box = new String[0];
    public String[] mList_4 = new String[0];
    ArrayList<ClsSpinerInform2> clsSpinerInforms2 = new ArrayList<ClsSpinerInform2>();
    public static ArrayList<ClsSpinerInform2> clsSpinerInforms = new ArrayList<ClsSpinerInform2>();
    //public static ArrayList<List_All_Users> mList=new ArrayList<List_All_Users>();
    
    
    public void Get_All_Data(String nameh, String FromDate, String ToDate_2, ListView listView, Context context) {
        
        
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
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
                        // String Type = responsS.getString("type").trim();
    
    
                        String n = User_name;
    
    
                        if (Staty.contains("L")) {
                            Staty = "معلق";
                        } else if (Staty.contains("N")) {
                            Staty = "مغلي";
                        } else
                            
                            Staty = "جاهز";
    
    
                        mList.add(new List_All_Users(5));
                        mList.add(new List_All_Users(5, date, "0", Sol, datty, Staty, iduser));
                        
                        
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
                params.put("FromDate", FromDate);
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
  
        
        
        public void Get_All_Data_(String nameh, String userid, String usertype) {
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    mList.clear();
                    String count_user = "8", Na = "op", key_decoment = "", p0 = "", p2 = "", Staty = "", Type = "";
                    int s = 0, s1 = 0, s2 = 0, s3 = 0;
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        // String iduser = responsS.getString("UserKey");
                        
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Sol = responsS.getString("balance_due").trim();
                        String amount_due = responsS.getString("amount_due").trim();
                        String amount_paid = responsS.getString("amount_paid").trim();
                        String CountDecoment = responsS.getString("CountDecoment").trim();
                        
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
                        
                        
                        mList.add(new List_All_Users(5, User_name, CountDecoment, soll, Type7, amount_due, amount_paid));
                        
                        
                        queue.stop();
                    }
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                
                ListAdapter ld = new ListAdapter(context, mList);
                //     listView.setAdapter(ld);
    
    
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("usertype", usertype);
                //  params.put("name", nameh);
                //   params.put("userid", userid);
                
                
                params.put("name", nameh);
                params.put("FromDate", userid);
                params.put("ToDate", userid);
                
                
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    public static ArrayList Get_All_Data_Spiner_print(String nameh, String decomentone, String ToDate_2, Context context) {
    
    
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
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
    
    
                // ListAdapter     ld = new ListAdapter(context, mList);
                // listView.setAdapter(ld);
    
                //   listView.setAdapter(ld);
                //ClsPrinReport cl = new ClsPrinReport(context);
    
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
                params.put("ToDate", decomentone);
                
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    
    
        return mList;
    }
    
    
    
    public void Get_All_Data_2(String name_op, String naum, Context context, AutoCompleteTextView h4, ArrayList<ClsSpinerInform> clsSpinerInforms2) {
       // List<String> mList_4_3 = new ArrayList<>();
     //   clsSpinerInforms2.clear();
        
        
        /*
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    mList.clear();
                    
                    final String[] dd_4 = new String[jsonArray_usersS.length()];
                    Toast.makeText(context, "Please ::" + jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
    
                    String count_user = "8", Na = "op", key_decoment = "", p0 = "", p2 = "", Staty = "", Type = "";
                    int s = 0, s1 = 0, s2 = 0, s3 = 0;
                    mList_4_3.clear();
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        String User_name_id = responsS.getString("id").trim();
                        int idu = Integer.parseInt(User_name_id);
                        String User_name_4 = responsS.getString("name").trim();
                        mList_4_3.add(User_name_4);
                        clsSpinerInforms2.add(new ClsSpinerInform(2, User_name_4));
                    }
                    
                    queue.stop();
                    
                    ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, mList_4_3);
                    h4.setAdapter(adapter_4);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                */
    
    
        mList_box = new String[0];
    
        clsSpinerInforms2.clear();
    
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                
                
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                
                
                    String[] mListsadd = new String[5];
                
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                
                    final String[] dd_4 = new String[jsonArray_usersS.length()];
                
                    if (jsonArray_usersS.length() > 0) {
                        for (int i = 0; i < jsonArray_usersS.length(); i++) {
                            JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                            mList_box = dd_4;
                            String User_name_id = responsS.getString("id").trim();
                            int idu = Integer.parseInt(User_name_id);
                            String User_name_4 = responsS.getString("name").trim();
                        
                            mList_box[i] = User_name_4;
    
                            clsSpinerInforms2.add(new ClsSpinerInform(idu, User_name_4));
                        
                        }
                    }
                
                
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
                ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, mList_box);
                h4.setAdapter(adapter_4);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name_op);
                params.put("name_id", naum);
                return params;
            }
        };
        
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    }
    public void Get_All_Data(Context context, Spinner h1, Spinner h2, Spinner h3, Spinner h4, ArrayList<ClsSpinerInform> clsSpinerInforms2, ArrayList<ClsSpinerInform2> spinerInforms2, ArrayList<ClsSpinerInform> clsSpinerInforms_box, ArrayList<ClsSpinerInform> clsSpinerInformsBox, ListView listView, FragmentActivity activity) {
    
    
        //   requestQueue = Volley.newRequestQueue(context);
        
        authList = new ArrayList<>();
        brList = new ArrayList<>();
        boxList = new ArrayList<>();
        empList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        String uri_P_2 = "http://192.168.1.106/test_anroid_mysql_php2/";
    
        int es = 0;
    
    
        int mn = 90;
    
    
        String url = MainActivity4_drop.uri_P_2 + "get_All_Users.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                  url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray1 = response.getJSONArray("All_Users");
                    JSONArray jsonArray2 = response.getJSONArray("All_Users1");
                    JSONArray jsonArray3 = response.getJSONArray("All_Users2");
                    JSONArray jsonArray4 = response.getJSONArray("All_Users3");
        
                    authList = new ArrayList<>();
                    brList = new ArrayList<>();
                    boxList = new ArrayList<>();
                    empList = new ArrayList<>();
        
        
                    // جلب بيانات السلطات وإضافتها إلى authList
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        JSONObject jsonObject = jsonArray1.getJSONObject(i);
                        String name = jsonObject.getString("name_auth");
                        authList.add(name);
                        Toast.makeText(context, "Please ::" + name, Toast.LENGTH_SHORT).show();
            
                        // authList.add(name);
                    }
        
                    // جلب بيانات الفروع وإضافتها إلى brList
                    for (int i = 0; i < jsonArray2.length(); i++) {
                        JSONObject jsonObject = jsonArray2.getJSONObject(i);
                        String name = jsonObject.getString("br_name");
                        brList.add(name);
            
                        //  brList.add(name);
                    }
        
                    // جلب بيانات الصناديق وإضافتها إلى boxList
                    for (int i = 0; i < jsonArray3.length(); i++) {
                        JSONObject jsonObject = jsonArray3.getJSONObject(i);
                        String name = jsonObject.getString("box_name");
                        boxList.add(name);
            
            
                        // boxList.add(name);
                    }
        
                    Toast.makeText(context, "Please ::" + "ii", Toast.LENGTH_SHORT).show();
        
        
                    // جلب بيانات الموظفين وإضافتها إلى empList
                    for (int i = 0; i < jsonArray4.length(); i++) {
                        JSONObject jsonObject = jsonArray4.getJSONObject(i);
                        String name = jsonObject.getString("namebox_4");
                        empList.add(name);
                        //  empList.add(name);
                        mList.add(new List_All_Users(1, name, "oo", "jj", "datty", "Staty", "iduser"));
            
                    }
                    Toast.makeText(context, "Please ::" + spinerInforms2, Toast.LENGTH_SHORT).show();
        
        
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, authList);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    h1.setAdapter(adapter);
                    ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, brList);
                    adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    h2.setAdapter(adapter_2);
                    ArrayAdapter<String> adapter_3 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, boxList);
                    adapter_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    h3.setAdapter(adapter_3);
                    ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, empList);
                    adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    h4.setAdapter(adapter_4);
        
        
                    //requestQueue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //ListAdapter ld=new ListAdapter(MainActivity_mysqlserver.this,mList);
                // spinner.setAdapter(ld);
    
                // h4.setSelection(0);
    
    
                // mList.add(new List_All_Users(5));
    
    
                //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
    
                //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
    
    
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
    
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
            
        });
        
        requestQueue.add(jsonObjectRequest);
    
        // requestQueue.add(stringRequest);
        //   requestQueue(false);
        
        
    }
    
    public void Get_All_Data_UserMain(String nameh) {
        // String uri_P = "http://10.0.2.2/test_anroid_mysql_php2/getsearch_user.php?name="+nameh;
    
    
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity_mysqlserver.uri_P_33, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    mList.clear();
                    String count_user = "8", Na = "op", key_decoment = "", p0 = "", p2 = "", Staty = "", Type = "";
                    int s = 0, s1 = 0, s2 = 0, s3 = 0;
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        // String iduser = responsS.getString("UserKey");
                        
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Sol = responsS.getString("balance_due").trim();
                        String amount_due = responsS.getString("amount_due").trim();
                        String amount_paid = responsS.getString("amount_paid").trim();
                        String CountDecoment = responsS.getString("CountDecoment").trim();
    
                        int due = Integer.parseInt(Sol);
                        int paid = Integer.parseInt(amount_paid);
                        String Type7 = "0";
                        
                        if (due < 0) {
                            Type7 = "علبه";
                            
                        } else
                            Type7 = "له";
    
                        SharedPreferences sharedpreferences;
                        sharedpreferences = context.getSharedPreferences("SaveDateMain", Context.MODE_PRIVATE);
    
                        //String CountDecoment = responsS.getString("CountDecoment").trim();
                        
                        //String key_decoment2 = responsS.getString("key_decoment").trim();
                        
                        
                        //    Toast.makeText(context, ":"+Staty+""+Type, Toast.LENGTH_SHORT).show();
    
    
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("UserName", User_name);
                        editor.putString("UserSet", amount_due);
                        editor.putString("UserGet", amount_paid);
                        editor.putString("UserSol", Sol);
    
    
                        editor.commit();
    
    
                        mList.add(new List_All_Users(4, User_name, "0", Sol, Type7, amount_due, amount_paid));
    
    
                        queue.stop();
                    }
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
    
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        })
        
        
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("usertype", usertype);
                params.put("name", nameh);
                //   params.put("userid", userid);
    
    
                // params.put("name", nameh);
                //  params.put("FromDate", FromDate_1);
                //params.put("ToDate", userid);
                
                
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    
    public void Get_All_Data_UserMain_Find(String nameh, String name_user) {
    
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
    
    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
    
    
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    mList.clear();
                    String count_user = "8", Na = "op", key_decoment = "", p0 = "", p2 = "", Staty = "", Type = "";
                    int s = 0, s1 = 0, s2 = 0, s3 = 0;
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
    
                        // String iduser = responsS.getString("UserKey");
    
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Sol = responsS.getString("balance_due").trim();
                        String amount_due = responsS.getString("amount_due").trim();
                        String amount_paid = responsS.getString("amount_paid").trim();
                        String CountDecoment = responsS.getString("CountDecoment").trim();
    
                        int due = Integer.parseInt(Sol);
                        int paid = Integer.parseInt(amount_paid);
                        String Type7 = "0";
    
                        if (due < 0) {
                            Type7 = "علبه";
        
                        } else
                            Type7 = "له";
    
                        SharedPreferences sharedpreferences;
                        sharedpreferences = context.getSharedPreferences("SaveDateMain", Context.MODE_PRIVATE);
    
                        //String CountDecoment = responsS.getString("CountDecoment").trim();
    
                        //String key_decoment2 = responsS.getString("key_decoment").trim();
    
    
                        Toast.makeText(context, ":" + Staty + "" + Type, Toast.LENGTH_SHORT).show();
    
    
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("UserName", User_name);
                        editor.putString("UserSet", amount_due);
                        editor.putString("UserGet", amount_paid);
                        editor.putString("UserSol", Sol);
    
    
                        editor.commit();
    
    
                        queue.stop();
                    }
    
                } catch (JSONException e) {
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
                params.put("ToDate", name_user);
                params.put("name", nameh);
    
    
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    
    
    }
    
    public void Get_All_Data_spiner(Context context, Spinner spinner, Spinner spinner_2, ArrayList<ClsSpinerInform> clsSpinerInforms, ArrayList<ClsSpinerInform2> clsSpinerInforms2) {
    }
    
    
    public void Get_All_Data_22(String h, String name, Spinner spinner_empl, ArrayList<ClsSpinerInform2> clsSpinerInforms_emp) {
     mList_4 = new String[0];
        clsSpinerInforms_emp.clear();
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    mList.clear();
    
                    ed_name_use="";
                    
    
    
                    final String[] dd_4 = new String[jsonArray_usersS.length()];
                    String count_user = "8", Na = "op", key_decoment = "", p0 = "", p2 = "", Staty = "", Type = "";
                    int s = 0, s1 = 0, s2 = 0, s3 = 0;
    
                    if (jsonArray_usersS.length() > 0) {
    
                        for (int i = 0; i < jsonArray_usersS.length(); i++) {
                            JSONObject responsS = jsonArray_usersS.getJSONObject(i);
        
                            String User_name_id = responsS.getString("id").trim();
                            int idu = Integer.parseInt(User_name_id);
                            String User_name_4 = responsS.getString("name").trim();
        
                            mList_4 = dd_4;
                             ed_name_use=User_name_4;
    
                            if(User_name_4.contains("الكل")) {
                                User_name_4="الصناديق";
                            }
                            mList_4[i] = User_name_4;
    
                            clsSpinerInforms_emp.add(new ClsSpinerInform2(idu, User_name_4));
                        }
                       queue.stop();
    
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            
                ArrayAdapter<String> adapter_4 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, mList_4);
                adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_empl.setAdapter(adapter_4);
   }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                
                
                params.put("name", h);
                params.put("name_id", name);
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    }
    
    
    public void Get_All_Data_box(String h, String ame_id, Spinner spinner_e, ArrayList<ClsSpinerInform> clsSpinerInforms_bo) {
        mList_box = new String[0];
    
        clsSpinerInforms_bo.clear();
        
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "readCourses.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    String[] mListsadd = new String[5];
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    final String[] dd_4 = new String[jsonArray_usersS.length()];
                 
                    if (jsonArray_usersS.length() > 0) {
                        for (int i = 0; i < jsonArray_usersS.length(); i++) {
                            JSONObject responsS = jsonArray_usersS.getJSONObject(i);
            
                            mList_box = dd_4;
                            String User_name_id = responsS.getString("id").trim();
                            int idu = Integer.parseInt(User_name_id);
                            String User_name_4 = responsS.getString("name").trim();
            
                            
                            if(User_name_4.contains("الكل")) {
                                User_name_4="الفروع";
                            }
                            mList_box[i] = User_name_4;
                            clsSpinerInforms_bo.add(new ClsSpinerInform(idu, User_name_4));
    
                        }
                    }
                    
                    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mList_box);
                adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_e.setAdapter(adapter_4);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Velle","Error_2");
    
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                
                params.put("name", h);
    
                params.put("name_id", ame_id);
    
    
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    }
    
    public void Get_All_Data_brann(String h, String nameid, Spinner spinner_emp, ArrayList<ClsSpinnerBrann> clsSpinerInforms_box) {
        mList_box = new String[0];
        ArrayList<String> arrp = new ArrayList<>();
        clsSpinerInforms_box.clear();
        
        final RequestQueue queue = Volley.newRequestQueue(context);
        
        Thread thread = new Thread(() -> {
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                      MainActivity4_drop.uri_P_2 + "serch_one_user.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        
                        JSONObject jsonResponse = jsonArray.getJSONObject(0);
                        
                        String[] mListsadd = new String[5];
                        
                        JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                        
                        final String[] dd_4 = new String[jsonArray_usersS.length()];
                        List<String> mListss = new ArrayList<>();
                        List<String> mListss2 = new ArrayList<>();
                        
                        String maness = "";
                        int cnam = 0;
                        int cn = 0;
                        if (jsonArray_usersS.length() > 0) {
                            for (int i = 0; i < jsonArray_usersS.length(); i++) {
                                JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                                
                                mList_box = dd_4;
                                String User_name_id = responsS.getString("id").trim();
                                int idu = Integer.parseInt(User_name_id);
                                String User_name_4 = responsS.getString("name").trim();
    
    
                                if(User_name_4.contains("الكل")) {
                                    User_name_4="الفروع";
                                }
                                mList_box[i] = User_name_4;
                                
                                clsSpinerInforms_box.add(new ClsSpinnerBrann(idu, User_name_4));
                            }
                        }
                        
                        ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mList_box);
                        adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_emp.setAdapter(adapter_4);
                    } catch (JSONException e) {
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
                    
                    params.put("name", h);
                    params.put("id", nameid);
                    
                    return params;
                }
            };
            
            queue.add(stringRequest);
            stringRequest.setShouldCache(false);
        });
        
        thread.start();
    }
    public void Get_All_Data_auth(String h, Spinner spinner_emp, ArrayList<ClsSpinnerAuths> clsSpinerInforms_Auth) {
    
        ArrayList<String> arrp = new ArrayList<>();
        clsSpinerInforms_Auth.clear();
        mList_box = new String[0];
        // String []uy=new String[-1];
    
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "show_user_cont.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
    
    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
    
    
                    String[] mListsadd = new String[5];
    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
    
                    final String[] dd_4 = new String[jsonArray_usersS.length()];
                    //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
    
    
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    if (jsonArray_usersS.length() > 0) {
                        for (int i = 0; i < jsonArray_usersS.length(); i++) {
                            JSONObject responsS = jsonArray_usersS.getJSONObject(i);
    
                            mList_box = dd_4;
                            String User_name_id = responsS.getString("id").trim();
                            int idu = Integer.parseInt(User_name_id);
    
                            String User_name_4 = responsS.getString("name").trim();
    
    
                            if(User_name_4.contains("الكل")) {
                                User_name_4="المناطق";
                            }
                            mList_box[i] = User_name_4;
    
                            clsSpinerInforms_Auth.add(new ClsSpinnerAuths(idu, User_name_4));
    
                        }
                    }
    
    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
                ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mList_box);
                adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_emp.setAdapter(adapter_4);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
    
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
    
                params.put("name", h);
    
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    
    
        Handler handler = new Handler();
        boolean b = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 29000);
    }
}