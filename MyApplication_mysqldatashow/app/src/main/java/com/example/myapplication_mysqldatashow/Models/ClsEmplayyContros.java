
package com.example.myapplication_mysqldatashow.Models;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
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

public class ClsEmplayyContros implements Decoment_Ectronic<ClsEmpleyy> {
    public Context context;
    private ProgressDialog progressDialog;
   public static String typ_opion="";
    private RequestQueue mQueue;
    private ListView mListView;
    
    private ListAdapter mAdapter;
    private List<List_All_Users> mUserList;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private int mPageNumber = 1;
    
    
    private List<List_All_Users> items = new ArrayList<>(); // قائمة العناصر
    private ListAdapter adapter; // الـ Adapter المستخدم في ListView
    private  int page = 1; // عدد الصفحات المحملة
    
    
    
    
    
    
    private boolean isLoading = false; // مؤشر على حالة التحميل
    
    public ClsEmplayyContros(Context context)
    {
        this.context=context;
    }
    public static ArrayList<List_All_Users> mList=new ArrayList<List_All_Users>();
    
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
        
        String date=t.getDate();
        String types_admin=t.getType();
        String gresr=t.getDetails();
        String sol=t.getPassowrds();
        String User_name=t.getUser_name();
        String User_name_Aut=t.getNameAuthor();
        String Phone=t.getPhoneUser();
    
    
        if ( TextUtils.isEmpty(types_admin) ||  TextUtils.isEmpty(sol) ||TextUtils.isEmpty(User_name) || TextUtils.isEmpty(User_name_Aut) ) {
            Toast.makeText(context, "يجب تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
            
        }  else {
          
    
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                      MainActivity4_drop.uri_P_2+"g.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        JSONObject jsonResponse = jsonArray.getJSONObject(0);
                        String success = jsonResponse.getString("success");
                        
                        //String UserType2 = responsS.getString("type").trim();
                        
                        
                        
                        
                        
                        if (success.contains("Error")) {
                            //   Toast.makeText(LogIn.this, " تم تسجيل الدخول  ", Toast.LENGTH_SHORT).show();
                            
                            
                            Toast.makeText(context, " الاسم موجود مسبقا", Toast.LENGTH_SHORT).show();
                            
                        }
                        else  if (success.contains("Reg_OK")) {
                            
                            Toast.makeText(context, "تمت العملية بنجاح", Toast.LENGTH_SHORT).show();
    
                            Intent in = new Intent(context, MainActivity_mysqlserver.class);
    
    
                            in.putExtra("infromation_user_intent", "decoment");
    
    
                            context.  startActivity(in);
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
                    Log.e("velloy ","emply");
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> MapData = new HashMap<>();
                    
                    MapData.put("TypOpration", typ_opion);
                    MapData.put("nameAto", User_name_Aut);
                    
                    MapData.put("User_name", User_name);
                    
                    
                    MapData.put("Phone", Phone);
                    
                    
                    MapData.put("Sol", sol);
                    
                    MapData.put("types_admin", types_admin);
                    
                    
                    
                    return MapData;
                }
            };
            
            queue.add(stringRequest);
            stringRequest.setShouldCache(false);
            
        }
        
        
    }
    @Override
    public void update(ClsEmpleyy t) {
        
        String date=t.getDate();
        String types_admin=t.getType();
        String gresr=t.getDetails();
        String sol=t.getPassowrds();
        String User_name=t.getUser_name();
        String User_name_Aut=t.getNameAuthor();
        String Phone=t.getPhoneUser();
        
        
        if (TextUtils.isEmpty(User_name_Aut)  ||TextUtils.isEmpty(gresr)||TextUtils.isEmpty(Phone)) {
            Toast.makeText(context, "يجب تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
            //Toast.makeText(context, "تم التسجيل بنجاح"+User_name, Toast.LENGTH_SHORT).show();
            
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
                    
                    MapData.put("TypOpration",typ_opion );
                    MapData.put("nameAto", User_name_Aut);
                    
                    MapData.put("User_name", User_name);
                    MapData.put("date", date);
                    
                    
                    MapData.put("Phone", Phone);
                    
                    MapData.put("gresr", gresr);
                    
                    MapData.put("Sol", sol);
                    
                    MapData.put("types_admin", types_admin);
                    
                    
                    
                    return MapData;
                }
            };
            
            queue.add(stringRequest);
            stringRequest.setShouldCache(false);
            
        }
        
        
    }
    
    @Override
    public void delete(String key) {
        Toast.makeText(context, "key:"+key, Toast.LENGTH_SHORT).show();
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  SEND_DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    String success = jsonResponse.getString("success");
                    
                    
                    
                    
                    
                    
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
                
                MapData.put("TypOpration","deleteUser");
                MapData.put("nameAto", key);
                
                
                
                
                
                return MapData;
            }
        };
        
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
    }
  

    public   void Get_All_Data(String nameh,String id_user, ListView listView,Context context) {
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop. uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    mList.clear();
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                    Toast.makeText(context, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    
                    //   mList.clear();
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        // String iduser = responsS.getString("UserKey");
                        
                        // int idu= responsS.getInt("id");
                        String User_name = responsS.getString("name").trim();
                        String UserKey = responsS.getString("keyemple").trim();
                        //  String Count_Nmae = responsS.getString("incounts").trim();
                        String Max_Sumsol = responsS.getString("details").trim();
                       // int  idmax= responsS.getInt("Max_sal");
                        String Max_sol = responsS.getString("Max_sal");
                        
                        String phone= responsS.getString("phone").trim();
                        //  String sum_sol= responsS.getString("sum_sol").trim();
                        
                        // String KeyUser= responsS.getString("KeyUser").trim();
                        //  Toast.makeText(All_Users_list.this, "مكرر"+User_name, Toast.LENGTH_SHORT).show();
                        
                        //   LogIn();
                        //Toast.makeText(All_Users_list.this, "hgh:"+User_name, Toast.LENGTH_SHORT).show();
                        
                        
                        //  mLists.add(responsS.getString("UserKey").trim());
                        // mLists.add( responsS.getString("UserName").trim());
                        // mLists.add(responsS.getString("Email").trim());
                        //mLists.add( responsS.getString("RegDate").trim());
                        //  Toast.makeText(All_Users_list.this, "تم حذف البيانات"+i, Toast.LENGTH_SHORT).show();
//mList.add(new List_All_Users(iduser));
                        // mList.add(new List_All_Users(2,User_name,Count_Nmae,Max_Sumsol));
                        String  u="t";
                        String  u2="t";
                        if(Max_sol.contains("0"))
                        {
                            Max_sol="مدير"  ;
                        }
                        else
                        {
                            Max_sol="موظف"  ;
                            
                        }
                        
                        mList.add(new List_All_Users(1, User_name, phone, Max_sol,u,u2,UserKey));
                        
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                        //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                    }
                    
                    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                
                
                
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                //   if (progressDialog.isShowing()) {
                //    progressDialog.dismiss();
                // }
                
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
                params.put("id_user", id_user);
    
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
        
        String url = MainActivity4_drop.uri_P_2 + "insert_new_user.php?page=" + page;
        
        Thread thread = new Thread(() -> {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
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
    
                String UserKey = jsonObject.optString("keyemple").trim();
                //  String Count_Nmae = responsS.getString("incounts").trim();
                String Max_Sumsol =  jsonObject.optString("details").trim();
                // int  idmax= responsS.getInt("Max_sal");
                String Max_sol = jsonObject.optString("Max_sal");
    
                String phone= jsonObject.optString("phone").trim();
                
                int id = jsonObject.optInt("id_em");
                String name = jsonObject.optString("name");
                String description = jsonObject.optString("phone");
    
                if(Max_sol.contains("0"))
                {
                    Max_sol="مدير"  ;
                }
                else
                {
                    Max_sol="موظف"  ;
        
                }
                if(name.contains("الكل"))
    
                {
                    String h="rr";
        
                }
                else
                    //    Toast.makeText(context, ":"+Staty+""+Type, Toast.LENGTH_SHORT).show();
                {   //  mListss.add(new Employee(User_name, Sol, amount_paid, amount_due));
        
    
    
    
                //    mList.add(new List_All_Users(1, name, phone, Max_sol,"u","u2",UserKey));
                List_All_Users item = new List_All_Users(1, name, phone, Max_sol,"u","u2",UserKey);
                itemList.add(item);
    
             
                
            }}
        } catch (JSONException e) {
            e.printStackTrace();
        }
    
   
        return itemList;
    }
    
    
    private void fetchData() {
        String url = MainActivity4_drop.uri_P_2+"insert_new_user.php?limit=10&page=" + mPageNumber;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                  new Response.Listener<JSONObject>() {
                      @Override
                      public void onResponse(JSONObject response) {
                          try {
                              JSONArray jsonArray = response.getJSONArray("All_Users");
                              
                              // مسح البيانات السابقة إذا كانت هناك
                              if (mPageNumber == 1) {
                                  mUserList.clear();
                              }
                              
                              // إضافة البيانات الجديدة إلى القائمة
                              for (int i = 0; i < jsonArray.length(); i++) {
                                  JSONObject user = jsonArray.getJSONObject(i);
                                  
                                  String userId = user.getString("id_em");
                                  String name = user.getString("name");
                                  String date = user.getString("date");
                                  String phone = user.getString("phone");
                                  String details = user.getString("details");
                                  String maxSal = user.getString("Max_sal");
                                  String keyEmple = user.getString("keyemple");
    
                                  if(maxSal.contains("0"))
                                  {
                                      maxSal="مدير"  ;
                                  }
                                  else
                                  {
                                      maxSal="موظف"  ;
        
                                  }
    
                                  List_All_Users     newUser = new List_All_Users(1, name, date, phone, details, maxSal, keyEmple);
                                  mUserList.add(newUser);
                              }
                              
                              // تحديث عرض القائمة
                              mAdapter.notifyDataSetChanged();
                              
                              // إخفاء علامة التحميل وعرض زر التحميل المزيد
                              mSwipeRefreshLayout.setRefreshing(false);
                              // mLoadMoreButton.setVisibility(View.VISIBLE);
                          } catch (JSONException e) {
                              e.printStackTrace();
                          }
                      }
                  }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(context, "Error fetching data", Toast.LENGTH_SHORT).show();
                
                // إخفاء علامة التحميل وعرض زر التحميل المزيد
                mSwipeRefreshLayout.setRefreshing(false);
                //  mLoadMoreButton.setVisibility(View.VISIBLE);
            }
        });
        
        // إضافة الطلب إلى قائمة الطلبات وتنفيذه
        mQueue.add(request);
    }
    
    private void loadMoreData() {
        // عرض علامة التحميل وإخفاء زر التحميل المزيد
        mSwipeRefreshLayout.setRefreshing(true);
        // mLoadMoreButton.setVisibility(View.GONE);
        
        // زيادة رقم الصفحة بمقدار واحد
        mPageNumber++;
        
        // استدعاء البيانات الجديدة
        fetchData();
    }
    
    public   void Get_All_Data(String nameh, ListView listView, Spinner sp) {
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop. uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    mList.clear();
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                    //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    
                    //   mList.clear();
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        // String iduser = responsS.getString("UserKey");
                        
                        // int idu= responsS.getInt("id");
                        String User_name = responsS.getString("name").trim();
                        String UserKey = responsS.getString("keyemple").trim();
                        //  String Count_Nmae = responsS.getString("incounts").trim();
                        String Max_Sumsol = responsS.getString("details").trim();
                        int  idmax= responsS.getInt("Max_sal");
                        String Max_sol = String.valueOf(idmax);
                        
                        String phone= responsS.getString("phone").trim();
                        //  String sum_sol= responsS.getString("sum_sol").trim();
                        
                        // String KeyUser= responsS.getString("KeyUser").trim();
                        //  Toast.makeText(All_Users_list.this, "مكرر"+User_name, Toast.LENGTH_SHORT).show();
                        
                        //   LogIn();
                        //Toast.makeText(All_Users_list.this, "hgh:"+User_name, Toast.LENGTH_SHORT).show();
                        
                        
                        //  mLists.add(responsS.getString("UserKey").trim());
                        // mLists.add( responsS.getString("UserName").trim());
                        // mLists.add(responsS.getString("Email").trim());
                        //mLists.add( responsS.getString("RegDate").trim());
                        //  Toast.makeText(All_Users_list.this, "تم حذف البيانات"+i, Toast.LENGTH_SHORT).show();
//mList.add(new List_All_Users(iduser));
                        // mList.add(new List_All_Users(2,User_name,Count_Nmae,Max_Sumsol));
                        String  u="t";
                        String  u2="t";
                        if(Max_sol.contains("0"))
                        {
                            Max_sol="مدير"  ;
                        }
                        else
                        {
                            Max_sol="موظف"  ;
                            
                        }
                        
                        mList.add(new List_All_Users(1, User_name, phone, Max_sol,u,u2,UserKey));
                        
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                        //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                    }
                    
                    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                
                
                
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                //   if (progressDialog.isShowing()) {
                //    progressDialog.dismiss();
                // }
                
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
                
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    
    
}

