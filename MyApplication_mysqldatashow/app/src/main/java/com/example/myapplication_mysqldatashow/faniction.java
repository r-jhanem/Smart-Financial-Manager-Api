package com.example.myapplication_mysqldatashow;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ActionMode;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class faniction  extends AppCompatActivity {
    private ActionMode myaction;
    public static String uri_P = "http://192.168.1.116/test_anroid_mysql_php2/getsearch_user.php";
    public static String GetAllBrontion = "http://192.168.1.116/test_anroid_mysql_php2/GetAllBrontion.php";

    public static String uri = "http://192.168.1.116/test_anroid_mysql_php2/get_All_Users.php";
    public static String uri2 = "http://10.0.2.2/test_anroid_mysql_php2/readCourses.php";
    // public static String uri3 = "http://10.0.2.2/test_anroid_mysql_php/getsearch_user.php";
    public static String uri3= "http://10.0.2.2/test_anroid_mysql_php2/show_user_cont.php";
    public static String uri6= "http://10.0.2.2/test_anroid_mysql_php2/serch_one_user.php";

    public static String uri5= "http://10.0.2.2/test_anroid_mysql_php2/2UpdateUserProfile.php";
    public static String uri_enter_users= "http://10.0.2.2/test_anroid_mysql_php2/g.php";

    public static String update_user_enter= "http://10.0.2.2/test_anroid_mysql_php2/UpdateUser_enter_app.php";

    Bitmap bitmap, scaleBitmap;
    int pageWidth = 1200;
    Date dateTime;
    DateFormat dateFormat;
    public static TextView namey;
    public static String tyyyps;

    String bo="admin",SumSol="",KeyUser="";




    private RecyclerView.LayoutManager mLayoutManager;

    All_Users_list All=new All_Users_list();
    Context context;

    faniction(Context context)
    {
        this.context=context;
    }

    void Get_All_Data_serch(String nameText) {

        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                All.uri6, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);


                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_User");
                  //  Toast.makeText(, "Please enter course id:"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);


                        String User_name = responsS.getString("name").trim();
                        String RegDate = responsS.getString("Datee").trim();
                        String phone = responsS.getString("phone").trim();
                        String sol = responsS.getString("sol").trim();
                        String sum_sol= responsS.getString("sum_sol").trim();

                        String KeyUser= responsS.getString("KeyUser").trim();
                        String getrse= responsS.getString("getres").trim();
                        String type_op= responsS.getString("state_open").trim();


                        //  mLists.add(responsS.getString("UserKey").trim());
                        // mLists.add( responsS.getString("UserName").trim());
                        // mLists.add(responsS.getString("Email").trim());
                        //mLists.add( responsS.getString("RegDate").trim());
                        // Toast.makeText(All_Users_list.this, "تم حذف البيانات"+i, Toast.LENGTH_SHORT).show();
//mList.add(new List_All_Users(iduser));


                        if(type_op.contains(
                                "نعم")) {


                            //  mLists.add(responsS.getString("UserKey").trim());
                            // mLists.add( responsS.getString("UserName").trim());
                            // mLists.add(responsS.getString("Email").trim());
                            //mLists.add( responsS.getString("RegDate").trim());
                            // Toast.makeText(All_Users_list.this, "تم حذف البيانات"+i, Toast.LENGTH_SHORT).show();
//mList.add(new List_All_Users(iduser));
                     //       All.mList.add(new List_All_Users(2,User_name,RegDate,phone,getrse,sol,sum_sol,KeyUser,type_op));
                        }
                        else {
                         //   All.mList.add(new List_All_Users(1,User_name,RegDate,phone,getrse,sol,sum_sol,KeyUser,type_op));

                        }

                    }




                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                ListAdapter ld=new ListAdapter(context,All.mList);
                All.listView.setAdapter(ld);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserKey", MainActivity.Local_UserKey);
                params.put("name", nameText);

                return params;
            }
        };

        queue.add(stringRequest);
        stringRequest.setShouldCache(false);


    }


}
