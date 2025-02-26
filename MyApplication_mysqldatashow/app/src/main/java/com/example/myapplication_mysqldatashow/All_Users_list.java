package com.example.myapplication_mysqldatashow;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.Models.ClsAutName;
import com.example.myapplication_mysqldatashow.Models.clsDecoment;
import com.example.myapplication_mysqldatashow.ui.home.HomeFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class All_Users_list extends AppCompatActivity {
    String bgg;
    String success = "";
    String namesuresers = "";
    TextView Text_types;
    private ActionMode actionMode;
    int pageWids = 1,x_pr=0;
    public static  String name_prints_decoment="",name_prints="",name_prints_user="";
    String cu2bdf = "";
    Calendar calendar = Calendar.getInstance();
    
    final int year = calendar.get(Calendar.YEAR);
    
    final int moath = calendar.get(Calendar.MONTH);
    final int moath_2 = calendar.get(Calendar.MONTH);
    final int moath_3 = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    
    
    private ActionMode myaction;
    public static String uri_P = "http://192.168.1.116/test_anroid_mysql_php2/getsearch_user.php",TextDateto,TextDateFr;
    public static String GetAllBrontion = "http://192.168.1.116/test_anroid_mysql_php2/GetAllBrontion.php";
    
    public static String uri = "http://192.168.1.116/test_anroid_mysql_php2/get_All_Users.php";
    public static String uri2 = "http://192.168.1.116/test_anroid_mysql_php2/readCourses.php";
    // public static String uri3 = "http://10.0.2.2/test_anroid_mysql_php/getsearch_user.php";
    public static String uri3 = "http://10.0.2.2/test_anroid_mysql_php2/show_user_cont.php";
    public static String uri6 = "http://192.168.1.116/test_anroid_mysql_php2/serch_one_user.php";
    
    public static String uri5 = "http://192.168.1.116/test_anroid_mysql_php2/2UpdateUserProfile.php";
    public static String uri_enter_users = "http://192.168.1.116/test_anroid_mysql_php2/g.php";
    
    public static String update_user_enter = "http://192.168.1.116/test_anroid_mysql_php2/UpdateUser_enter_app.php";
    
    Bitmap bitmap, scaleBitmap;
    int pageWidth = 1200;
    Date dateTime;
    DateFormat dateFormat;
    public static TextView namey;
    public static String tyyyps;
    
    String bo = "admin", SumSol = "", KeyUser = "";
    
    private RecyclerView recyclerView;
    public static ListView listView;
    public static List<String> mLists;
    
    ProgressDialog progressDialog = null;
    
    public static ArrayList<List_All_Users> mList;
    private RecyclerView.LayoutManager mLayoutManager;
    LinearLayout liner1,lineer2,iner_date;
    
    private String WordSearch = "";
    static int xcolor = 0;
    int count_type = 0;
    TextView TextDateFrom,TextDateTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        listView = findViewById(R.id.list_id);
        iner_date= findViewById(R.id.iner_date);
    
        liner1 = findViewById(R.id.liner_user);
        lineer2 = findViewById(R.id.liner_user_2);
    
        iner_date.setVisibility(View.VISIBLE);
    
        TextDateFrom = findViewById(R.id.TextDateFrom);
        TextDateTo = findViewById(R.id.TextDateto);
    
        HomeFragment.MyPRE_box_print="pp";
        
  
    
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (myaction != null) {
    
    
                    return false;
                }
    
                // myaction=startActionMode(myActioncluback);
                return true;
    
            }
        });
        
        
        bo = "0";
        Intent intent = getIntent();
        
        
        String cu = intent.getStringExtra(MainActivity4_drop.CouresName);
        Intent intent2 = getIntent();
        String cu2 = intent2.getStringExtra("WWW");
        
        
        mLists = new ArrayList<>();
        mList = new ArrayList<>();
        mLists.clear();
        mList.clear();
        Intent in = getIntent();
        
        
        cu2bdf = in.getStringExtra("infromation_user_intent");
/*
        int cz=in.getIntExtra("nam",0);
        bo=in.getStringExtra("name");
        Intent inn=getIntent();
        String G= String.valueOf(R.id.action_sort_by_types);
        String gbo=inn.getStringExtra("raadd4");
      // Toast.makeText(All_Users_list.this, "enter  id:"+bo, Toast.LENGTH_SHORT).show();

        Toast.makeText(All_Users_list.this, "enter course id:"+cz, Toast.LENGTH_SHORT).show();
*/
        //  Toast.makeText(All_Users_list.this, "errroo:"+gbo, Toast.LENGTH_SHORT).show();
        if (bo == null)
            bo = "admin";
        
        String tt = "admin";
        if (cu2bdf.equals("admin")) {
            
            //faniction n=new faniction(this);
            //  n.Get_All_Data();
            //Intent in2=new Intent(All_Users_list.this,MainActivity_open_2.class);
//startActivity(in2);
            //faniction ff=new faniction(this);
            Get_All_Data("employss_one_uy", MainActivity4_drop.UserID_id);
            
            // Get_All_Data_serch_one("h");
            
            // Toast.makeText(All_Users_list.this, "enter course id:"+bo, Toast.LENGTH_SHORT).show();
        }
        else if (cu2bdf.equals("prossice_print")) {
            iner_date.setVisibility(View.GONE);
            liner1.setVisibility(View.GONE);
    
    
            IfPrintReport clsPrinReport = new IfPrintReport(All_Users_list.this);
            clsPrinReport.Get_All_Data_printiess("date_printes","r",TextDateFr,TextDateto,listView,All_Users_list.this);
    
        }
        
        else if (cu2bdf.equals("Auth")) {
            iner_date.setVisibility(View.GONE);
    
            name_prints="المناطق"  ;
            
            
            getSupportActionBar().setTitle("المناطق");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            
            
            ClsAutName.Get_All_Data_Report("SearchSpinner_All_Auth_report", "i", "u", listView, this);
            
        }
        else if (cu2bdf.equals("yemen")) {
            iner_date.setVisibility(View.GONE);
            liner1.setVisibility(View.GONE);
    
            name_prints_user = in.getStringExtra("name");
    
    
            clsDecoment clsDecomen=new clsDecoment(this);
    
            switch (MainActivity4_drop.TempTypeUser) {
        
        
        
                case "0": {
    
                    iner_date.setVisibility(View.VISIBLE);
    
    
                    name_prints_decoment="admin";
                    
                   // Toast.makeText(All_Users_list.this, "enter course id:"+name_prints_user, Toast.LENGTH_SHORT).show();
    
                    clsDecomen.Get_All_Data_Spiner_Login_date_date("date_decoment_true",name_prints_user,"date_5","date_7",listView,this);
    
                 //   clsDecomen.Get_All_Data("date_decoment_true",name_prints_user,"date_5","date_7",listView,this);
            
                    break;
                }
        
                case "1": {
    
                    name_prints_decoment="User";
    
                    clsDecomen.Get_All_Data_Spiner_Login_date_date("date_decoment_true_USER",name_prints_user,MainActivity4_drop.TempUserID,"TextDateto",listView,this);
            
            
            
                    break;
                }
        
        
            }}
            
        else if (cu2bdf.equals("prossice_de")) {
            iner_date.setVisibility(View.GONE);
            liner1.setVisibility(View.GONE);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);
            final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    
            int  md=moath+1;
    
    
            int d = day - 2;
            clsDecoment clsDecomen=new clsDecoment(this);
    
    
    
            int d2 = day - 2;
    
           // String date_7 = year+ "" + md + ""+day ;
           // String date_5 = year+ "" + md + ""+d2  ;
    
            String date_7 = String.valueOf(year)+"/"+String.valueOf(md)+"/"+String.valueOf(day);
            String date_5= String.valueOf(year)+"/"+String.valueOf(md)+"/"+String.valueOf(d2);
    
            String TextDateFr=clsDecomen.getSendDataUrl_date(date_5)
                      ,TextDateto=clsDecomen.getSendDataUrl_date(date_7);
    
    
            getSupportActionBar().setTitle("العمليات الاخيرة");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    
            int  md2=moath+1;
    
    
    
            switch (MainActivity4_drop.TempTypeUser) {
        
        
        
                case "0": {
            
            
                    clsDecomen.Get_All_Data_Spiner_Login_date_date("date","ID_USER",TextDateFr,TextDateto,listView,this);
            
                    break;
                }
        
                case "1": {
    
    
                    clsDecomen.Get_All_Data_Spiner_Login_date_date("date_user_one",MainActivity4_drop.UserID_id,TextDateFr,TextDateto,listView,this);
            
            
            
                    break;
                }
        
            }
    
    
        }
    
        
        else if (cu2bdf.equals("empl_one")) {
            liner1.setVisibility(View.GONE);
            iner_date.setVisibility(View.VISIBLE);
    
            lineer2.setVisibility(View.VISIBLE);
    
    
            HomeFragment.MyPRE_box_print="ii";
            
            int  md=moath+1;
    
    
            int d = day - 2;
            String date_show = d +""+ moath + "" + year;
    
            String date_2 = d +"/"+ moath + "/" + year;
            String date_3 = year+ "/" + md + "/"+day  ;
            String date_4 = year+ "/" + md + "/"+d  ;
    
            TextDateFrom.setHint(":من" + date_4);
    
            TextDateTo.setText(":الى" + date_3);
    
    
            name_prints_user = in.getStringExtra("name");
            
            
            
            name_prints = "empl_one";
    
    
            getSupportActionBar().setTitle(name_prints_user);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    
    
            clsDecoment clsDecomen = new clsDecoment(this);
    
            clsDecomen.Get_All_Data_Spiner("decomentone_uesrsss", "decomentone", name_prints_user, listView, this);
    
    
    
    
    
            TextDateFrom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            
            
                    DatePickerDialog datePickerDialog = new DatePickerDialog(All_Users_list.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            month = month + 1;
                            String date = year + "/" + moath_3 + "/" + dayOfMonth;
                            //  String dat = year  +""+ moath_2 + dayOfMonth;
    
                            x_pr=9;
                            TextDateFrom.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day));
                    
                            clsDecoment clsDecomen=new clsDecoment(All_Users_list.this);
                             TextDateFr=clsDecomen.getSendDataUrl_date(TextDateFrom.getText().toString());
                                      TextDateto=clsDecomen.getSendDataUrl_date(TextDateTo.getText().toString());
    
                            clsDecomen.Get_All_Data_Spiner_Login_date_date("date_user_one_2",name_prints_user,TextDateFr,TextDateto,listView,All_Users_list.this);
                    
                         //   clsDecomen.Get_All_Data("date","r",TextDateFr,TextDateto,listView,this);
                            // ClsSearch clsReport=new ClsSearch();
                            // clsReport. Get_All_Data("date",TextDateFrom.getText().toString(),TextDateTo.getText().toString(),listView,getActivity());
                            // Toast.makeText(getActivity(), "hgh:"+dat , Toast.LENGTH_SHORT).show();
                    
                            //clsReport. Get_All_Data_date("date",TextDateFrom.getText().toString(),TextDateFrom.getText().toString());
                        }
                    }, year, moath_3, dayOfMonth);
                    datePickerDialog.show();
            
                }
        
            });
    
    
            TextDateTo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    
                    DatePickerDialog datePickerDialog = new DatePickerDialog(All_Users_list.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            x_pr=9;
                            month = month + 1;
                            TextDateTo.setText(String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day));
                            clsDecoment clsDecomen = new clsDecoment(All_Users_list.this);
                            String TextDateFr = clsDecomen.getSendDataUrl_date(TextDateFrom.getText().toString()), TextDateto = clsDecomen.getSendDataUrl_date(TextDateTo.getText().toString());
                               Toast.makeText(All_Users_list.this, "hgh:1:" +x_pr, Toast.LENGTH_SHORT).show();
            
                            clsDecomen.Get_All_Data_Spiner_Login_date_date("date_user_one_2",name_prints_user, TextDateFr, TextDateto, listView,All_Users_list.this);
            
            
                        }
                    }, year, moath_3, dayOfMonth);
    
                    datePickerDialog.show();
    
    
                }
            });
            
    
        }
        else if (cu2bdf.equals("Brann")) {
    
    
            name_prints="الفروع"  ;
    
            getSupportActionBar().setTitle("الفروع");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            
            
            ClsAutName.Get_All_Data_Report("SearchSpinner_All_brann_report", "i", "u", listView, this);
            
        } else if (cu2bdf.equals("Box")) {
    
    
            name_prints="الصناديق"  ;
    
            getSupportActionBar().setTitle("الصناديق");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            
            
            ClsAutName.Get_All_Data_Report("SearchSpinner_All_box_report", "i", "u", listView, this);
            
        } else if (cu2bdf.equals("Empl")) {
    
    
            name_prints="الحسابات"  ;
    
            getSupportActionBar().setTitle("الحسابات");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            
            
            ClsAutName.Get_All_Data_Report("SearchSpinner_All_emp_report", "i", "u", listView, this);
            
        } else {
            xcolor = 9;
            Get_All_Data_serch(bo);
            // Get_All_Data_serch_one("h");
            // Get_All_Data() ;
            
        }
    
        TextDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            
            
                DatePickerDialog datePickerDialog = new DatePickerDialog(All_Users_list.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = year + "/" + moath_3 + "/" + dayOfMonth;
                        //  String dat = year  +""+ moath_2 + dayOfMonth;
                    
                        x_pr=9;
                        TextDateFrom.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day));
                    
                        clsDecoment clsDecomen=new clsDecoment(All_Users_list.this);
                        TextDateFr=clsDecomen.getSendDataUrl_date(TextDateFrom.getText().toString());
                        TextDateto=clsDecomen.getSendDataUrl_date(TextDateTo.getText().toString());
    
    
    
                        switch (MainActivity4_drop.TempTypeUser) {
        
        
        
                            case "0": {
            
                     if (cu2bdf.equals("yemen")) {
                         //clsDecomen.Get_All_Data_Spiner_Login_date_date("date_decoment_true",name_prints_user,"date_5","date_7",listView,All_Users_list.this);
    
                         clsDecomen.Get_All_Data_Spiner_Login_date_date("date_frm_to", name_prints_user, TextDateFr, TextDateto, listView,     All_Users_list.this);
    
                     }
                     
                     
                                break;
                            }
        
                            case "1": {
            
            
                                clsDecomen.Get_All_Data_Spiner_Login_date_date("date_user_one",MainActivity4_drop.UserID_id,TextDateFr,TextDateto,listView, All_Users_list.this);
            
            
            
                                break;
                            }
        
                        }
                        clsDecomen.Get_All_Data_Spiner_Login_date_date("date_user_one_2",name_prints_user,TextDateFr,TextDateto,listView,All_Users_list.this);
                    
                        //   clsDecomen.Get_All_Data("date","r",TextDateFr,TextDateto,listView,this);
                        // ClsSearch clsReport=new ClsSearch();
                        // clsReport. Get_All_Data("date",TextDateFrom.getText().toString(),TextDateTo.getText().toString(),listView,getActivity());
                        // Toast.makeText(getActivity(), "hgh:"+dat , Toast.LENGTH_SHORT).show();
                    
                        //clsReport. Get_All_Data_date("date",TextDateFrom.getText().toString(),TextDateFrom.getText().toString());
                    }
                }, year, moath_3, dayOfMonth);
                datePickerDialog.show();
            
            }
        
        });
    
    
        TextDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            
                DatePickerDialog datePickerDialog = new DatePickerDialog(All_Users_list.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        x_pr=9;
                        month = month + 1;
                        TextDateTo.setText(String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day));
                        clsDecoment clsDecomen = new clsDecoment(All_Users_list.this);
                        String TextDateFr = clsDecomen.getSendDataUrl_date(TextDateFrom.getText().toString()), TextDateto = clsDecomen.getSendDataUrl_date(TextDateTo.getText().toString());
                        //Toast.makeText(All_Users_list.this, "hgh:1:" +x_pr, Toast.LENGTH_SHORT).show();
                    
                        clsDecomen.Get_All_Data_Spiner_Login_date_date("date_user_one_2",name_prints_user, TextDateFr, TextDateto, listView,All_Users_list.this);
                    
                    
                    }
                }, year, moath_3, dayOfMonth);
            
                datePickerDialog.show();
            
            
            }
        });
    
    
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view = getLayoutInflater().inflate(R.layout.row_item_all_users, null);
                TextView Text_UserName;
                Text_UserName = view.findViewById(R.id.Text_UserNam);
                // ;
    
                ArrayList<List_All_Users> listclass1 = new ArrayList<List_All_Users>();
    
                //   Text_UserName.setText();
    
    
            }
        });
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_print, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings: {
                Toast.makeText(All_Users_list.this,"Eng. Raad Jhanem",Toast.LENGTH_SHORT).show();
                break;
            }
        
                case R.id.nav_shopping_list_print: {
                if (cu2bdf.equals("Auth")) {
                    name_prints="المناطق"  ;
    
                    IfPrintReport clsPrinReport = new IfPrintReport(All_Users_list.this);
                    //clsPrinReport.Get_All_Data("decoment");
                    // clsPrinReport.Get_All_Data3();
                    clsPrinReport.Get_All_Data("SearchSpinner_All_Auth_report", "t");
    
    
                    break;
                } else if (cu2bdf.equals("Empl")) {
    
                    IfPrintReport clsPrinReport = new IfPrintReport(All_Users_list.this);
                    //clsPrinReport.Get_All_Data("decoment");
                    // clsPrinReport.Get_All_Data3();
                    clsPrinReport.Get_All_Data("SearchSpinner_All_emp_report", "t");
                    break;
    
                }
                else if (cu2bdf.equals("yemen")) {
    
                                  
                                       clsDecoment.Get_All_Data_Spiner_Login_print(All_Users_list.this);
                                   
    break;
                }
                else if (cu2bdf.equals("prossice_de")) {
    
    
                    clsDecoment.Get_All_Data_Spiner_Login_print(All_Users_list.this);
    
    break;
                }

                else if (cu2bdf.equals("empl_one")) {
    
    
                    IfPrintReport cl = new IfPrintReport(this);
    
    
    
                    if(x_pr!=9)
                    {
    
                        cl.Get_All_Data_Spiner_print("get_print_deoment", name_prints_user, "yt", "jj", this);//clsPrinReport.Get_All_Data("decoment");
    
    
                        // clsPrinReport.Get_All_Data3();
                        
                    }
    else {
    
    
                        Toast.makeText(All_Users_list.this, "hgh:" + TextDateFr+":"+TextDateto, Toast.LENGTH_SHORT).show();
    
    
                        cl.Get_All_Data_Spiner_print("date_user_one_4",name_prints_user,TextDateFr,TextDateto,this);//clsPrinReport.Get_All_Data("decoment");
                        // clsPrinReport.Get_All_Data3();
                    }
                        break;
                    
                }
                else if (cu2bdf.equals("Box")) {
    
                    IfPrintReport clsPrinReport = new IfPrintReport(All_Users_list.this);
                    //clsPrinReport.Get_All_Data("decoment");
                    // clsPrinReport.Get_All_Data3();
                    clsPrinReport.Get_All_Data("SearchSpinner_All_box_report", "t");
                    break;
    
                } else if (cu2bdf.equals("Brann")) {
    
                    IfPrintReport clsPrinReport = new IfPrintReport(All_Users_list.this);
                    //clsPrinReport.Get_All_Data("decoment");
                    // clsPrinReport.Get_All_Data3();
                    clsPrinReport.Get_All_Data("SearchSpinner_All_brann_report", "t");
    
                    break;
                }
    
                break;
            }
            // إجراء عند النقر على عنصر القائمة 1
        }
        
                return super.onOptionsItemSelected(item);
    
        
    }
    
    
    
    
 
  
    public   void Get_All_Data(String nameh,String id_user) {
        
        
        
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop. uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    mList.clear();
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                  //  Toast.makeText(context, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    
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
                
                
                
                
                ListAdapter ld = new ListAdapter(All_Users_list.this, mList);
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
    
    
    
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
//soft




    //END


    //kkkk




  


    void Get_All_Data_serch(String nameText) {
    
    
        DateFormat dateFormat;





        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,GetAllBrontion, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    JSONObject jsonResponse = jsonArray.getJSONObject(0);



                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");


                    Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    List<String> mListss=new ArrayList<>();
                    List<String> mListss2=new ArrayList<>();
                    String [] dd=new String[jsonArray_usersS.length()];
                    String [] ddd=new String[jsonArray_usersS.length()];
                    String maness="";
                    int cnam=0;
                    int cn=0;
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                   JSONObject responsS = jsonArray_usersS.getJSONObject(i);

                        // String iduser = responsS.getString("UserKey");

                        //    int idu= responsS.getInt("id");
                        String User_name = responsS.getString("namebox").trim();
                        //String UserKey = responsS.getString("Datee").trim();
                        String Count_Nmae = responsS.getString("incounts").trim();
                        String Max_Sumsol = responsS.getString("SumSol").trim();
                        //  String Type_opation= responsS.getString("type_opration").trim();
                        //  String sum_sol= responsS.getString("sum_sol").trim();

                        // String KeyUser= responsS.getString("KeyUser").trim();
                        //  Toast.makeText(All_Users_list.this, "مكرر"+User_name, Toast.LENGTH_SHORT).show();
                        namesuresers=User_name;
                        //   LogIn();
                        //Toast.makeText(All_Users_list.this, "hgh:"+User_name, Toast.LENGTH_SHORT).show();



                        //  mLists.add(responsS.getString("UserKey").trim());
                        // mLists.add( responsS.getString("UserName").trim());
                        // mLists.add(responsS.getString("Email").trim());
                        //mLists.add( responsS.getString("RegDate").trim());
                        Toast.makeText(All_Users_list.this, "تم حذف البيانات"+i, Toast.LENGTH_SHORT).show();
//mList.add(new List_All_Users(iduser));
                        // mList.add(new List_All_Users(2,User_name,Count_Nmae,Max_Sumsol));


                       // mList.add(new List_All_Users(1,User_name,Count_Nmae,Max_Sumsol,User_name,Count_Nmae,"llo","oo","o"));
                    }



                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //ListAdapter ld=new ListAdapter(All_Users_list.this,mList);
               // listView.setAdapter(ld);
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
    //sires


    //DELETE


 public String LogIn() {

      String  user_name = namesuresers;
       String User_Password = namesuresers;

        //progressDialog.setMessage("انتظر ارسال البيانات");
        // progressDialog.setCancelable(true);
        //progressDialog.show();

        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                uri_P, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    success = jsonResponse.getString("success");
                  //  mList.add(new List_All_Users(success));
                    //if (success.contains("LogIn_Error")) {
                    // Toast.makeText(com.example.test_mysql.LogIn.this, "تم تسجيل الدخول  ", Toast.LENGTH_SHORT).show();

                    // JSONArray jsonArray_usersS = jsonResponse.getJSONArray("Users_Data");
                    // JSONObject responsS = jsonArray_usersS.getJSONObject(0);
                            /*
                            String UserKey = responsS.getString("UserKey").trim();
                            String User_name = responsS.getString("UserName").trim();
                            String Email = responsS.getString("Email").trim();
                            String Avatar_img = responsS.getString("Avatar").trim();
/*
                        SharedPreferences.Editor editor = shared_Save.edit();
                        editor.putString("Local_UserKey", UserKey.trim());
                        editor.putString("Local_UserName", User_name.trim());
                        editor.putString("Local_Email", Email.trim());
                        editor.putString("Local_PassWord", User_Password.trim());
                        editor.putString("Local_UserAvatar",  Avatar_img.trim());
                        editor.apply();
*/
/*
                        MainActivity.Local_UserKey = UserKey.trim();
                        MainActivity.Local_UserName = User_name.trim();
                        MainActivity.Local_UserEmail = Email.trim();
                        MainActivity.Local_UserAvatar = Avatar_img.trim();

                        MainActivity.UserKey = UserKey.trim();
                        MainActivity.UserName = User_name.trim();
                        MainActivity.UserEmDRRFail = Email.trim();
                        MainActivity.UserAvatar = Avatar_img.trim();
*/
                    //Log.d("UserKey==========>",UserKey);

                    // startActivity(new Intent(LogIn.this, All_Users_list.class));
                    //  Toast.makeText(LogIn.this, "لم يتم تسجيل الدخول", Toast.LENGTH_SHORT).show();

                    // }
                    //  if (success.contains("LogIn_OK")) {
                    //Toast.makeText(LogIn.this, "لم يتم تسجيل الدخول", Toast.LENGTH_SHORT).show();

                    Toast.makeText(All_Users_list.this, "تم تسجيل الدخول"+success, Toast.LENGTH_SHORT).show();
                    //  Intent in=new Intent(LogIn.this,All_Users_list.class);


                    //in.putExtra("user_name",User_name);


                    // startActivity(in);


                    // startActivity(new Intent(LogIn.this, All_Users_list.class));
                    //}
                    // else
                    // {


                    //   Toast.makeText(LogIn.this, "لم يتم تسجيل الدخول", Toast.LENGTH_SHORT).show();

                    //}

                    queue.stop();

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
                params.put("name", namesuresers);
                params.put("phone", User_Password);
                return params;
            }
        };

        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
     return success;
    }

    public void onclic_button_add(View view) {

        Intent in=new Intent(All_Users_list.this,MainActivity_mysqlserver.class);
        in.putExtra(    "infromation_user_intent","find_use");
        startActivity(in);


        //startActivity(new Intent(All_Users_list.this,MainActivity_mysqlserver.class));
    }

    public void add_lo(View view) {
        Toast.makeText(All_Users_list.this, "تم تسجيل الدخول"+success, Toast.LENGTH_SHORT).show();


    }
    public static void add_l_6(String t,String g,Context context) {
    
        IfPrintReport clsPrinReport = new IfPrintReport(context);
    
        clsPrinReport. Get_All_Data_printiess("date_printes","r",t,g,listView,context);
        
    }
    
    
    
}

