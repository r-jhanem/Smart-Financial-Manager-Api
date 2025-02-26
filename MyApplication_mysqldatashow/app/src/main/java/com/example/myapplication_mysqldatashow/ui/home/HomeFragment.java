package com.example.myapplication_mysqldatashow.ui.home;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.All_Users_list;
import com.example.myapplication_mysqldatashow.ClsSpinerInform;
import com.example.myapplication_mysqldatashow.ClsSpinerInform2;
import com.example.myapplication_mysqldatashow.ClsSpinnerAuths;
import com.example.myapplication_mysqldatashow.ClsSpinnerBrann;
import com.example.myapplication_mysqldatashow.GlobalClass;
import com.example.myapplication_mysqldatashow.ListAdapter;
import com.example.myapplication_mysqldatashow.List_All_Users;
import com.example.myapplication_mysqldatashow.MainActivity4_drop;
import com.example.myapplication_mysqldatashow.MainActivity_mysqlserver;
import com.example.myapplication_mysqldatashow.Models.ClsEmplayyContros;
import com.example.myapplication_mysqldatashow.Models.ClsSearch;
import com.example.myapplication_mysqldatashow.Models.SaveSettings;
import com.example.myapplication_mysqldatashow.Models.clsDecoment;
import com.example.myapplication_mysqldatashow.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment<ClsPrinReport> extends Fragment {
    private String nameText = "";
    //ClsReport clsReport =new ClsReport(context);
    ArrayList<ClsSpinerInform2> clsSpinerInforms2 = new ArrayList<ClsSpinerInform2>();
    
    ArrayList<ClsSpinerInform> clsSpinerInforms = new ArrayList<>();
    
    GlobalClass globalClass;
    ProgressDialog progressDialog = null;
    String h = "employss";
    String h_2;
   int  due=0;
    TextView TextDateFrom, TextDateTo;
   LinearLayout  liner_date;
    ArrayList<ClsSpinerInform2> clsSpinerInforms_emp= new ArrayList<>();
    ArrayList<ClsSpinerInform> clsSpinerInforms_boxex= new ArrayList<>();
    
    ArrayList<ClsSpinnerBrann> clsSpinerInforms_br= new ArrayList<>();
    ArrayList<ClsSpinnerAuths> clsSpinerInforms_authh= new ArrayList<>();
    
    Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    
    final int moath = calendar.get(Calendar.MONTH);
    final int moath_2 = calendar.get(Calendar.MONTH);
    final int moath_3 = calendar.get(Calendar.MONTH);
    
    
    ListAdapter listAdapter;
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    
    public Context context;
    
    
    public static ArrayList<List_All_Users> mList = new ArrayList<List_All_Users>();
    public static List<List_All_Users> mList_list = new ArrayList<List_All_Users>();
    
    public static ArrayList<String> mList2;
    public static String[] mList3 = new String[0];
    public static String[] mList_2 = new String[0];
    public static String[] mList_4 = new String[0];
    public static final String MyPREFERENCES = "MyPrefs3" ;
    public static  String MyPRE_box_print = "b" ,MyPRE_box_print_2="f",
     namees ,MyPRE_box_print_date_fr = "b" ,MyPRE_box_print_2_date_to="f",namees_serch="u",MyPRE_box_print_date_fr_date=""
              ;
    
    
    SharedPreferences sharedpreferences,sharedpreferences_data_user;
    
    public static String[] mList_3 = new String[0];
    ArrayList<ClsSpinerInform> clsSpinerInforms_box_2=new ArrayList<>();
    CardView cardView1, cardView2, cardView3, cardView2_1, cardView2_2, cardView2_3;
    public static final String RCV_COURES1 = "coures1";
    public static final String RCV_COURES2 = "coures2";
    public static final String RCV_COURES3 = "coures3";
    public static final String RCV_COURES2_1 = "coures2_1";
    public static final String RCV_COURES2_2 = "coures2_2";
    public static final String RCV_COURES2_3 = "coures2_3";
    private HomeViewModel homeViewModel;
    public Spinner spinner, spinner_2, spinner_3, spinner_4;
    public static String uri_P_1 = "http://192.168.1.116/test_anroid_mysql_php2/get_All_Users.php";
    
    public static String GetAllBrontion = "http://192.168.1.116/test_anroid_mysql_php2/GetAllBrontion.php",namees19;
    public BottomNavigationView bottomNavigationView;
    private OnFragmentClickListener listener;
    //private static List<String> mLists;
    public String UserId = SaveSettings.UserID,TextDateto,TextDateFr;
    public String UserType = SaveSettings.TypeUser;
    
    public static String uri_P_sp = "http://192.168.1.116/test_anroid_mysql_php2/getsearch_user.php";
    public static ListView listView;
    private TextView TextDateF_print;
    
    
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentClickListener)
            listener = (OnFragmentClickListener) context;
        else
            throw new ClassCastException("ظهر خطاء اثناء معالجة النوع");
    }
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                  new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.layout_list, container, false);
    
    
     
        /*
        
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("انتظر يتم تحميل  البيانات");
        progressDialog.setCancelable(true);
        progressDialog.show();*/
        //getTextDate
        TextDateFrom = root.findViewById(R.id.TextDateFrom);
        TextDateTo = root.findViewById(R.id.TextDateto);
        TextDateF_print = root.findViewById(R.id.TextDateF_print);
        
        // String m4=java.text.DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
int  md=moath+1;
    
        int d = day - 2;
        String date_show = d +""+ moath + "" + year;
    
        String date_2 = d +"/"+ moath + "/" + year;
        String date_3 = year+ "/" + md + "/"+day  ;
        String date_4 = year+ "/" + md + "/"+d  ;
    
        TextDateFrom.setHint(":من" + date_4);
        
        TextDateTo.setText(":الى" + date_3);
        clsDecoment clsDecomen=new clsDecoment(getActivity());
        TextDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    
    
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = year + "/" + moath_3 + "/" + dayOfMonth;
                        //  String dat = year  +""+ moath_2 + dayOfMonth;
    
    
                        TextDateFrom.setText(String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day));
    
    
                        TextDateFr = clsDecomen.getSendDataUrl_date(TextDateFrom.getText().toString())
                        ;
                        TextDateto = clsDecomen.getSendDataUrl_date(TextDateTo.getText().toString());
                         clsDecomen.Get_All_Data_Spiner_Login_date("date", TextDateFr, TextDateto, listView, context);
    
                        //   clsDecomen.Get_All_Data_Spiner_22("date", TextDateFr, TextDateto, listView, context);

    /*
    
    if( spinner_3.getSelectedItem().toString().length()>0)
    
    {
                        String namees = spinner_3.getSelectedItem().toString();
                        
                        if(namees.equals("الفروع")) {
                            String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_3.getSelectedItemPosition()).Id);
                          //  clsDecomen.Get_All_Data("date", "r", TextDateFr, TextDateto, listView, getActivity());
                            clsDecomen.Get_All_Data_Spiner_22("date",TextDateFr,TextDateto, listView, context);
                        }
                        else  if(!namees.equals("الصناديق")) {
    
                            MyPRE_box_print="a";
                            
                            String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_3.getSelectedItemPosition()).Id);
                            clsDecomen.Get_All_Data("date_box_date", auot_name_2, TextDateFr, TextDateto, listView, getActivity());
                        }*/
                        // ClsSearch clsReport=new ClsSearch();
                        // clsReport. Get_All_Data("date",TextDateFrom.getText().toString(),TextDateTo.getText().toString(),listView,getActivity());
                        // Toast.makeText(getActivity(), "hgh:"+dat , Toast.LENGTH_SHORT).show();
    
                        //clsReport. Get_All_Data_date("date",TextDateFrom.getText().toString(),TextDateFrom.getText().toString());
    
                    }
                }, year, moath_3, dayOfMonth);
                datePickerDialog.show();
                TextDateF_print.setVisibility(View.VISIBLE);
            }
    
        });
        TextDateF_print.setVisibility(View.GONE);
        TextDateF_print.setOnClickListener(new View.OnClickListener() {
    
    
            @Override
            public void onClick(View v) {
    
                
                
                MyPRE_box_print_date_fr_date="utyy";
                String namees = spinner_3.getSelectedItem().toString();
                namees_serch=namees;
                MyPRE_box_print_2_date_to=TextDateTo.getText().toString();;
                MyPRE_box_print_date_fr=TextDateFrom.getText().toString();
                MyPRE_box_print_2="p";
                    if(MyPRE_box_print.equals("a")) {
        
                    MyPRE_box_print="c";
        
                    String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_3.getSelectedItemPosition()).Id);
                    clsDecomen.Get_All_Data("date_box_date", auot_name_2, TextDateFr, TextDateto, listView, getActivity());
                }
    
              else   if(!MyPRE_box_print.equals("a")) {
    
                    All_Users_list.add_l_6(TextDateFr, TextDateto, context);
    
    
                }
    
                TextDateF_print.setVisibility(View.GONE);
            }
        
        
        }
                 );
        TextDateF_print.setVisibility(View.GONE);
    
        TextDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    
    
                openDate();
            }
        });
        
        
      
        
        
        context = getActivity();
        listView = root.findViewById(R.id.list_id);
        
        bottomNavigationView = root.findViewById(R.id.bottom_naguftion);
        liner_date= root.findViewById(R.id.iner_date);
        spinner = root.findViewById(R.id.spinner_addshow_4);
        spinner_2 = root.findViewById(R.id.spinner_addshow_3);
        spinner_3 = root.findViewById(R.id.spinner_addshow_2);
        spinner_4 = root.findViewById(R.id.spinner_addshow);
        
        CardView card_1_1=root.findViewById(R.id.card_1_1);
        CardView card_1_2=root.findViewById(R.id.card_1_2);
    
        CardView card_2_1=root.findViewById(R.id.card_2_1);
    
        CardView card_2_2=root.findViewById(R.id.card_2_2);
    
        LinearLayout liner_comle = root.findViewById(R.id.liner_comle);
    
    
        LinearLayout linearLayout = root.findViewById(R.id.liner_20);
        LinearLayout linearcard_1 = root.findViewById(R.id.liner_card_1);
        LinearLayout linearcard_2 = root.findViewById(R.id.liner_card_2);
    
        LinearLayout linearLayou_sol_user = root.findViewById(R.id.sol_user);
        LinearLayout linearLayou_sol_user_spiner = root.findViewById(R.id.liner_21);
        
        

        
        sharedpreferences =context.getSharedPreferences("SaveDateMain", Context.MODE_PRIVATE);
    
        
        sharedpreferences_data_user= context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    
        ClsSearch search=new ClsSearch(context) ;
    
    
    
    
        Button butt_1,butt_2,butt_3,butt_4;
   
        butt_1 = root.findViewById(R.id.butt_1);
        butt_2 = root.findViewById(R.id.butt_2);
    
        butt_3= root.findViewById(R.id.butt_3);
    
        butt_4= root.findViewById(R.id.butt_4);
      //  search.Get_All_Data_UserMain("decoment");
    
    
    
    
        ClsSearch searchepm = new ClsSearch
                  (context);
       // search.Get_All_Data_22("decomentone_search_spinner_empl", "i", spinner_4, clsSpinerInforms_emp, "ed_name");
        //search.Get_All_Data_box("decomentone_search_spinner_box", "u", spinner_3, clsSpinerInforms_boxex);
      //  search.Get_All_Data_brann("php_branchess", "op", spinner_2, clsSpinerInforms_br);
       // search.Get_All_Data_auth("decomentone_search_spinner_box", spinner, clsSpinerInforms_authh);
       // search.Get_All_Data_box("decomentone_search_spinner_box","u",spinner_2,clsSpinerInforms_boxex);
    
    
        String  ID_USER=sharedpreferences_data_user.getString("UserID_id","empty");
    
      
      //  search.Get_All_Data_UserMain_Find("data_user",ID_USER);
    
        String TempUserName=sharedpreferences_data_user.getString("UserID","empty");
    
        Toast.makeText(getActivity(), "مرحبا بك يا"+TempUserName , Toast.LENGTH_SHORT).show();
    
    
        String  Sol_end=sharedpreferences_data_user.getString("amount_due","empty");
        String  pass=sharedpreferences_data_user.getString("pass","empty");
    
        String  Sol_prid=sharedpreferences_data_user.getString("amount_paid","empty");
        String SolAll=sharedpreferences_data_user.getString("SolAll","empty");
    
    
        butt_1.setText(TempUserName);
        butt_2.setText(Sol_prid);
        butt_3.setText(Sol_end);
        butt_4.setText(SolAll);
    

            GetDate gg2 = new GetDate();
        int  md2=moath+1;
    
        
    
    
        int d2 = day - 2;
    
        String date_7 = year+ "" + md + ""+day  ;
        String date_5 = year+ "" + md + ""+d2  ;
        
    
        String TextDateFr=clsDecomen.getSendDataUrl_date(TextDateFrom.getText().toString())
                  ,TextDateto=clsDecomen.getSendDataUrl_date(TextDateTo.getText().toString());
    
    
        card_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2=new Intent(context, All_Users_list.class);
            
                in2.putExtra("infromation_user_intent", "yemen");
                in2.putExtra("name", "L");
            
            
                //All_Users_list N=new All_Users_list();
            
            
                //N.Get_All_Data_serch_one(Text_UserName.getText().toString());
                context.startActivity(in2);
            
            }
        });
    
        card_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2=new Intent(context, All_Users_list.class);
            
                in2.putExtra("infromation_user_intent", "yemen");
                in2.putExtra("name", "N");
            
            
                //All_Users_list N=new All_Users_list();
            
            
                //N.Get_All_Data_serch_one(Text_UserName.getText().toString());
                context.startActivity(in2);
            
            }
        });
    
    
        card_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2=new Intent(context, All_Users_list.class);
            
                in2.putExtra("infromation_user_intent", "yemen");
                in2.putExtra("name", "ss");
    
    
                //All_Users_list N=new All_Users_list();
            
            
                //N.Get_All_Data_serch_one(Text_UserName.getText().toString());
                context.startActivity(in2);
            
            }
        });
    
    
        card_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2=new Intent(context, All_Users_list.class);
    
                in2.putExtra("infromation_user_intent", "prossice_de");
              //  clsDecomen.Get_All_Data_Spiner_Login_date_date("date","ID_USER","20230824","20230824",listView,context);
    
    
                //All_Users_list N=new All_Users_list();
    
    
                //N.Get_All_Data_serch_one(Text_UserName.getText().toString());
               context.startActivity(in2);
    
            }
        });
    
       // ClsSearch b = new ClsSearch(context);
      //  b.Get_All_Data_spiner(context, spinner, spinner_2,clsSpinerInforms,clsSpinerInforms2);
    

     
        //  Get_All_Data_22("nameh9");
        
        //  Get_All_Data();
        
        
        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, MainActivity_mysqlserver.class);
                
                
                in.putExtra("infromation_user_intent", "decoment");
                
                
                startActivity(in);
            }
            
        });
    
    
        bottomNavigationView.setSelectedItemId(R.id.navigation_hom);
     //   Get_All_Data("employss");
        MainActivity4_drop fd = new MainActivity4_drop();
        if (!(fd.dd2 == "0")) {
          //  Get_All_Data_date2(fd.dd2);
            SearchUser(fd.dd2);
        }
        h = fd.dd;
        
        
        
        if (fd.dd == "report") {
            ClsReport g = new ClsReport(context);
            g.Get_All_Data(h);
            
            fd.dd = "";
        }
        linearLayout.setVisibility(View.VISIBLE);
    liner_date.setVisibility(View.GONE);
        //linearLayou_sol_user_spiner.setVisibility(View.GONE);
     //   listView.setVisibility(View.GONE);
    
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    
            
                switch (item.getItemId()) {
                    case R.id.navigation_decoment: {
    
    
    
                        search.Get_All_Data_22("decomentone_search_spinner_empl","i",spinner_3,clsSpinerInforms_emp);
    
                        search.Get_All_Data_box("decomentone_search_spinner_box","u",spinner_2,clsSpinerInforms_boxex);
    
                        //  search.Get_All_Data_box("decomentone_search_spinner_box", "u", spinner_3, clsSpinerInforms_boxex);
                      //  search.Get_All_Data_brann("php_branchess", "op", spinner_2, clsSpinerInforms_br);
                        search.Get_All_Data_auth("decomentone_search_spinner_box", spinner, clsSpinerInforms_authh);
    
                        listAdapter = new ListAdapter(context, mList_list);
                        listView.setAdapter(listAdapter);                         // Toast.makeText(context, "Please enter course id"+newItems, Toast.LENGTH_SHORT).show();
                        mList_list.clear();
                        liner_comle.setVisibility(View.GONE);
    
                        linearcard_2.setVisibility(View.GONE);
                        linearcard_1.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
    
                        ClsSearch bb = new ClsSearch(context);
                        // bb.Get_All_Data(context, spinner, spinner_2, spinner_3, spinner_4,clsSpinerInforms,clsSpinerInforms2,clsSpinerInforms_box_2,clsSpinerInforms_box_2, listView, getActivity());
    
    
                        int userid = Integer.parseInt(MainActivity4_drop.UserID_id);
    
                        linearLayou_sol_user.setVisibility(View.GONE);
    
                        // Get_All_Data3( );
                        linearLayout.setVisibility(View.GONE);
                        switch (MainActivity4_drop.TempTypeUser) {
    
    
                            case "0": {
        
        
                                liner_date.setVisibility(View.VISIBLE);
                                spinner_4.setVisibility(View.GONE);
                                fab.setVisibility(View.VISIBLE);
    
                                clsDecoment clsDecoment = new clsDecoment(context);
                                clsDecoment clsDecoment2 = new clsDecoment(context);
        
                                ClsSearch b2 = new ClsSearch(context);
                                ClsSearch b3= new ClsSearch(context);
                                //  b2.Get_All_Data(context, spinner, spinner_2, spinner_3, spinner_4,clsSpinerInforms,clsSpinerInforms2,clsSpinerInforms_box_2,clsSpinerInforms_box_2, listView, getActivity());
        
        
                                
                                
                             linearLayou_sol_user_spiner.setVisibility(View.VISIBLE);
        
                                fab.setVisibility(View.VISIBLE);
        
                                //    Get_All_Data("decoment");
                                h = "decoment";
                                // clsDecoment cldecoment=new clsDecoment(getActivity());
                                // cldecoment.Get_All_Data_date5("employss3", "raad",listView,getActivity());
    
    
                                
                                spinner_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                 namees  = spinner_3.getSelectedItem().toString();
    
    
                                        if (!namees.equals("admin")||!namees.equals("admin")) {
                                            
    
                                            
                                           // String auot_name_2 = String.valueOf(clsSpinerInforms_emp.get(spinner_2.getSelectedItemPosition()).Id);
    
                                            clsDecomen.Get_All_Data_Spiner("decomentone_uesrsss", "decomentone", namees, listView, context);
    
                                            clsDecoment clsDecomen = new clsDecoment(getActivity());
    
                                            //clsDecomen.Get_All_Data_Spiner("decomentone", "decomentone", auot_name_2, listView, getActivity());
                                       
                                        } else {
                                            
                                            gg2.Get_All_Data("SearchSpinner_22", "auot_name_2", UserType, context);
                                        }
                                    }
        
                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
            
                                    }
                                });
    
    /*
    
    
                                spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                                        @Override
                                                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                            
                                                                            
                                                                            String namees = spinner_2.getSelectedItem().toString();
                                                                            if (!namees.equals("الفروع")) {
                                                                            String auot_name_2 = String.valueOf(clsSpinerInforms_br.get(spinner_2.getSelectedItemPosition()).Id);
                                                                            GetDate gg2 = new GetDate();
            
                                                                            gg2.Get_All_Data("SearchSpinner_brann", auot_name_2, UserType, context);
                                                                        }}
        
                                                                        @Override
                                                                        public void onNothingSelected(AdapterView<?> parent) {
            
                                                                        }
        
                                                                    }
                                );
                                
        
            
                                    spinner_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            if (position >= 0 && position < clsSpinerInforms_emp.size()) {
                                                namees19 = spinner_4.getSelectedItem().toString();
                                                String auot_name_2 = String.valueOf(clsSpinerInforms_emp.get(spinner_4.getSelectedItemPosition()).Id);
    
    
                                                clsDecoment clsDecomen = new clsDecoment(getActivity());
    
                                                clsDecomen.Get_All_Data_Spiner("decomentone", "decomentone", auot_name_2, listView, getActivity());
                                            }
                                        }
                
                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {
                    
                                        }
                                    });
            
            
            
                                    spinner_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            //  String namees = spinner.getSelectedItem().toString();
                                            String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_3.getSelectedItemPosition()).Id);
                                            GetDate gg2 = new GetDate();
    
                                            gg2.Get_All_Data("SearchSpinner", auot_name_2, UserType, context);
                                            //   clsDecomen. Get_All_Data("decomentoneSpiner",auot_name_2,listView,getActivity());
                                            //Get_All_Data_serch(spinner.getSelectedItem().toString()) ;
                                        }
                
                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {
                    
                                        }
                
                                    });
                                    ClsEmplayyContros cv = new ClsEmplayyContros(getActivity());
                                    //cv.Get_All_Data("employss", listView, getActivity(),spinner_4);
            
            
                                    spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                                            @Override
                                                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                                String namees = spinner.getSelectedItem().toString();
                                                                                String auot_name_2 = String.valueOf(clsSpinerInforms_br.get(spinner_2.getSelectedItemPosition()).Id);
                                                                                GetDate gg2 = new GetDate();
    
                                                                                gg2.Get_All_Data("SearchSpinner_brann", auot_name_2, UserType, context);
                                                                            }
                
                                                                            @Override
                                                                            public void onNothingSelected(AdapterView<?> parent) {
                    
                                                                            }
                
                                                                        }
                                    );
                                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                                          @Override
                                                                          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                              String namees = spinner.getSelectedItem().toString();
                                                                              String auot_name_2 = String.valueOf(clsSpinerInforms_authh.get(spinner.getSelectedItemPosition()).Id);
                                                                              GetDate gg2 = new GetDate();
    
                                                                              gg2.Get_All_Data("SearchSpinner_autho", auot_name_2, UserType, context);
                                                                          }
    
    
                                        @Override
                                                                          public void onNothingSelected(AdapterView<?> parent) {
        
                                        }
                                                                      }
                                    );
            
            */
        
        
        
                                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                                    @Override
                                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                                        //  cv.loadMoreData_2( listView, getActivity());
    
                                    }
            
                                    @Override
                                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                               
                
                                        clsDecoment.loadMoreData_2(listAdapter, mList_list, listView,context);
                                    }
            
                     
                        });
                                break;
                }
    
    
                        // container.overridePendingTransition(0,0);
                        case "1": {
        
                            liner_date.setVisibility(View.GONE);
        
                            // Toast.makeText(getActivity(), "id::" + MainActivity4_drop.UserID_id, Toast.LENGTH_SHORT).show();
        
                            clsDecoment clsDecome = new clsDecoment(getActivity());
        
                            clsDecome.Get_All_Data_Spiner("decomentone", "decomentone", MainActivity4_drop.UserID_id, listView, getActivity());
        
                            break;
                        }
                    }
                        return true;
                    }
                        case R.id.navigation_emple: {
    
    
                            listAdapter=new ListAdapter(context,mList_list);
                            listView.setAdapter(listAdapter);                         // Toast.makeText(context, "Please enter course id"+newItems, Toast.LENGTH_SHORT).show();
                            mList_list.clear();
                            liner_comle.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
    
                            linearcard_2.setVisibility(View.GONE);
                            linearcard_1.setVisibility(View.GONE);
                            fab .setVisibility(View.GONE);
                            h = "employss";
    
                            liner_date.setVisibility(View.GONE);
                                linearLayou_sol_user.setVisibility(View.GONE);
                            // Get_All_Data3( );
                            linearLayout.setVisibility(View.GONE);
                            linearLayou_sol_user_spiner.setVisibility(View.GONE);
                            ClsEmplayyContros cv = new ClsEmplayyContros(getActivity());
    
                            
                            
    int totalItemCountVisible=0;
                          //  ClsEmplayyContros cv = new ClsEmplayyContros(getActivity());
                            // cv.Get_All_Data("employss", listView, getActivity())
    /*
    
                            mList.clear();
                            if (!ClsConnctionData.isConnectingToInternet(context)) {
                                //List<List_All_Users> itemList = new ArrayList<>();
                                mList.clear();
        
                                //List_All_Users  item=new List_All_Users(15, "لايوجد اتصال بالانترنت", "", "", "", "", "","");
        
                                //    mList.add(new List_All_Users(1, name, phone, Max_sol,"u","u2",UserKey));
                                //  itemList.add(item);
        
        
        
                                //  listnewsData.add(0, new ToolTicketItem(null,getResources().getString(R.string.nonetworkConnection),null,null, "No_new_data",null ));
                                //   listAdapter.notifyDataSetChanged();
                                //listView.setSelection(1);
        
                                mList.add(new List_All_Users(15,"لايوجد اتصال بالانترنت", "لايوجد اتصال بالانترنت", "لايوجد اتصال بالانترنت","لايوجد اتصال بالانترنت","لايوجد اتصال بالانترنت","لايوجد اتصال بالانترنت"));
        
        
                                ListAdapter     ld = new ListAdapter(context, mList);
                                listView.setAdapter(ld);
        
                                //    progressDialog = new ProgressDialog(getActivity());
                                // progressDialog.setMessage("تاكد من الاتصال بالانترنت");
                                // progressDialog.setCancelable(true);
                                //progressDialog.show();
                                //return;
                                // do not counine if there is internet service
                                
        
                          */
                                switch (MainActivity4_drop.TempTypeUser) {
        
        
                                    case "0": {
            
                                        fab.setVisibility(View.VISIBLE);
                                        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                                            @Override
                                            public void onScrollStateChanged(AbsListView view, int scrollState) {
                                                //  cv.loadMoreData_2( listView, getActivity());
                    
                                            }
                
                                            @Override
                                            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                                                //
                                    /*
                                    if ((totalItemCountVisible <= totalItemCount - 10) && ((firstVisibleItem > 2)))//loading items before  he be in the end it 15 news
                                    {
                                    cv.loadMoreData_2( listAdapter,mList_list,listView, getActivity());
            
                                    Toast.makeText(getActivity(), "id90:", Toast.LENGTH_SHORT).show();
                                }
                            */
                                                cv.loadMoreData_2(listAdapter, mList_list, listView, getActivity());
                                                //Toast.makeText(getActivity(), "id90:"+firstVisibleItem+"1w:"+totalItemCount, Toast.LENGTH_SHORT).show();
                                            }
                
                                        });
                                        break;
                                    }
        
                                    case "1": {
            
                                        ClsEmplayyContros clsEmplayyContros = new ClsEmplayyContros(getActivity());
                                        clsEmplayyContros.Get_All_Data("employss_one", MainActivity4_drop.UserID_id, listView, getActivity());
            
                                        break;
                                    }
                                }
                            /*
                            switch (MainActivity4_drop.TempTypeUser) {
        
        
                                case "1": {
    
    
                                    //  cv.loadMoreData_2(listAdapter, mList_list, listView, getActivity());
    
                                  
                                break;
                                }
    
                                    case "0": {
        
                                        ClsEmplayyContros clsEmplayyContros= new ClsEmplayyContros(getActivity());
                                        clsEmplayyContros.Get_All_Data("employss_one", MainActivity4_drop.UserID_id, listView, getActivity());
        
        
                                        break;
                                    } }
                                
                            
                            
                        
    
                            switch (MainActivity4_drop.TempTypeUser) {
        
        
                                case "0": {
    
                                    fab.setVisibility(View.VISIBLE);
                                    h = "employss";
                                    ClsEmplayyContros cv = new ClsEmplayyContros(getActivity());
                                    // cv.Get_All_Data("employss", listView, getActivity());
    
                                    listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                                        @Override
                                        public void onScrollStateChanged(AbsListView view, int scrollState) {
                                            cv.loadMoreData_2();
        
                                        }
    
                                        @Override
                                        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                                            cv.loadMoreData_2();
    
                                            Toast.makeText(getActivity(), "id90:", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                     break;
                                }
                                    case "1": {
        
                                    ClsEmplayyContros cv = new ClsEmplayyContros(getActivity());
                                    cv.Get_All_Data("employss_one", MainActivity4_drop.UserID_id, listView, getActivity());
                                        
    
                                        break;
                                }
                            }*/
                            
                            return true;
                        }
                      
                     
                        case R.id.navigation_hom: {
    
                            liner_comle.setVisibility(View.VISIBLE);
    
    
                            linearcard_2.setVisibility(View.VISIBLE);
                            linearcard_1.setVisibility(View.VISIBLE);
                            switch (MainActivity4_drop.TempTypeUser) {
        
        
        
                                case "0": {
            
            
                                    clsDecomen.Get_All_Data("date","ID_USER",date_5,date_7,listView,getActivity());
            
                                    break;
                                }
        
                                case "1": {
            
            
                                    clsDecomen.Get_All_Data("date_user_one",ID_USER,TextDateFr,TextDateto,listView,getActivity());
            
            
            
                                    break;
                                }
        
                            }
                            fab .setVisibility(View.GONE);
                            liner_date.setVisibility(View.GONE);
    
                            linearLayou_sol_user_spiner.setVisibility(View.GONE);
                            linearLayout.setVisibility(View.VISIBLE);
                            linearLayou_sol_user.setVisibility(View.VISIBLE);
                            GetDate ddf = new GetDate();
                           // search.Get_All_Data_UserMain("decoment");
    
                            //gg2.Get_All_Data("decoment", UserId, UserType);
    
                            //Get_All_Data3( );                        //  overridePendingTransition(0,0);
                            ClsSearch bb3 = new ClsSearch(context);
                          // bb3.Get_All_Data(context, spinner, spinner_2, spinner_3, spinner_4,clsSpinerInforms,clsSpinerInforms2,clsSpinerInforms_box_2,clsSpinerInforms_box_2, listView, getActivity());
    
    
                         //   clsDecomen. Get_All_Data_Spiner_Login(TempUserName,pass,context);
    
    
                        }
                        return true;
                }
                return false;
            }
        });
        
        
        return root;
        
    }
    
    public void Get_All_Data_date2(String qure) {
    
        //  Get_All_Data_date5("employss3",qure);
    
    
        clsDecoment clsDecomen = new clsDecoment(getActivity());
    
        clsDecomen.Get_All_Data("decomentone", "p","decomentone", qure, listView, getActivity());
    }
    void Get_All_Dat2() {
        
        
        ArrayList<String> mArray;
        mArray = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.types)));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                  context, android.R.layout.simple_list_item_1, mArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        listView.setAdapter(adapter);
        
    }
    
    
    public interface OnFragmentClickListener {
        boolean onMenuItemClick(int featureId, Menu menu);
        
        void OnFragmentInterAction(String name);
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        listView = null;
    }
    
    public void SearchUser(String Name)
    {
        clsDecoment clsDecomen=new clsDecoment(getActivity());
    
        clsDecomen. Get_All_Data("decomentone", "j","decomentone",Name,listView,getActivity());
    }
   
    
    public void Get_All_Data(String nameh) {
        
        
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
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
    
                        // String iduser = responsS.getString("UserKey");
    
                        // int idu= responsS.getInt("id");
                        String User_name = responsS.getString("name").trim();
                        String UserKey = responsS.getString("keyemple").trim();
                        //  String Count_Nmae = responsS.getString("incounts").trim();
                        String Max_Sumsol = responsS.getString("details").trim();
                        int idmax = responsS.getInt("Max_sal");
                        String Max_sol = String.valueOf(idmax);
    
                        String phone = responsS.getString("phone").trim();
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
                        String u = "t";
                        String u2 = "t";
    
                        mList.add(new List_All_Users(1, User_name, phone, Max_sol, u, u2, UserKey));
    
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
    
                        //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
    
    
                    }
    
    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
    
                ListAdapter ld = new ListAdapter(context, mList);
                listView.setAdapter(ld);
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
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
                //params.put("UserKey", MainActivity.Local_UserKey);
                params.put("name", nameh);
    
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    public void Get_All_Data3() {
        for (int i = 0; i < 77; i++) {
            if (i < 10)
                mList.add(new List_All_Users(i, "رعد محمد عبدالله غانم", "777448696", "60", "1", "L", "789"));
            else
                mList.add(new List_All_Users(i, "علي احمد علي", "777448696", "60", "1", "L", "789"));
    
    
        }
        
        ListAdapter ld = new ListAdapter(context, mList);
        listView.setAdapter(ld);
    }
    
    public void Get_All_Data2() {
        
        
        ArrayList<String> arrp = new ArrayList<>();
        
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  uri_P_1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                    String[] mListsadd = new String[5];
                    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    final String[] dd = new String[jsonArray_usersS.length()];
                    final String[] dd_2 = new String[jsonArray_usersS.length()];
                    
                    final String[] dd_3 = new String[jsonArray_usersS.length()];
                    
                    final String[] dd_4 = new String[jsonArray_usersS.length()];
                    //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    
                    
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    for (int i = 1; i < jsonArray_usersS.length() + 1; i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                        // String iduser = responsS.getString("UserKey");
                        mList3 = dd;
                        mList_2 = dd_2;
                        mList_3 = dd_3;
                        mList_4 = dd_4;

//                           int idu= responsS.getInt("idbox");
                        String User_name = responsS.getString("namebox").trim();
                        String User_name_2 = responsS.getString("namebox_2").trim();
                        
                        String User_name_3 = responsS.getString("namebox_3").trim();
                        String User_name_4 = responsS.getString("namebox_4").trim();
                        // String UserKey = responsS.getString("Datee").trim();
                        //  String Count_Nmae = responsS.getString("incounts").trim();
                        //  String Max_Sumsol = responsS.getString("SumSol").trim();
                        //  String Type_opation= responsS.getString("type_opration").trim();
                        //  String sum_sol= responsS.getString("sum_sol").trim();
                        
                        // String KeyUser= responsS.getString("KeyUser").trim();
                        //  Toast.makeText(All_Users_list.this, "مكرر"+User_name, Toast.LENGTH_SHORT).show();
                        
                        //   LogIn();
                        //Toast.makeText(All_Users_list.this, "hgh:"+User_name, Toast.LENGTH_SHORT).show();
                        //mListsadd =new String[jsonArray_usersS.length()];
                        
                        
                        //  mLists.add(responsS.getString("UserKey").trim());
                        // mLists.add( responsS.getString("UserName").trim());
                        // mLists.add(responsS.getString("Email").trim());
                        //mLists.add( responsS.getString("RegDate").trim());
                        //  Toast.makeText(All_Users_list.this, "تم حذف البيانات"+i, Toast.LENGTH_SHORT).show();
//mList.add(new List_All_Users(iduser));
//                        mList.add(new List_All_Users(2,User_name,"Count_Nmae","Max_Sumsol"));
                        
                        //   mList.add(new List_All_Users(idu,User_name));
                        
                        // mList.add(new List_All_Users(  User_name, User_name_3, User_name_3));
                        
                        mList3[0] = "الجهة";
                        mList_2[0] = "الفروع ";
                        mList_3[0] = "الصندوق";
                        mList_4[0] = "الحساب";
                        mList3[i] = User_name;
                        mList_2[i] = User_name_2;
                        mList_3[i] = User_name_3;
                        mList_4[i] = User_name_4;
                        
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                      //      mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                    }
                    
                    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //ListAdapter ld=new ListAdapter(MainActivity_mysqlserver.this,mList);
                // spinner.setAdapter(ld);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mList3);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mList_2);
                adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_2.setAdapter(adapter_2);
                ArrayAdapter<String> adapter_3 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mList_3);
                adapter_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_3.setAdapter(adapter_3);
                ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mList_4);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_4.setAdapter(adapter_4);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            
            }
            
        });
        
        
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    
    void Get_All_Data_serch(String nameText) {
        
        
        final RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GetAllBrontion, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
    
    
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
    
                    final String[] dd_3 = new String[jsonArray_usersS.length()];
    
                    //Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                    List<String> mListss = new ArrayList<>();
                    List<String> mListss2 = new ArrayList<>();
                    String[] dd = new String[jsonArray_usersS.length()];
                    String[] ddd = new String[jsonArray_usersS.length()];
                    String maness = "";
                    int cnam = 0;
                    int cn = 0;
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
    
                        String User_name = responsS.getString("namebox").trim();
                        mList_2 = dd_3;
                        mList_2[i] = User_name;
    
    
                    }
    
    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mList_2);
                adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_2.setAdapter(adapter_2);
                //ListAdapter ld=new ListAdapter(All_Users_list.this,mList);
                // listView.setAdapter(ld);
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
                params.put("name", nameText);
    
                return params;
            }
        };
        
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        
        
    }
    
    
    public   void Get_All_Data_date( String nameh,String ToDate_2) {
        
        final RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop. uri_P , new Response.Listener<String>() {
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
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
    
                        // String iduser = responsS.getString("UserKey");
    
                        // int idu= responsS.getInt("id");type
                        String User_name = responsS.getString("name").trim();
                        String Sol = responsS.getString("SumSol").trim();
                        String amount_due = responsS.getString("amount_due").trim();
                        String amount_paid = responsS.getString("amount_paid").trim();
    
                        int due = Integer.getInteger(amount_due);
                        int paid = Integer.getInteger(amount_paid);
                        String Type = "";
    
                        if (due > paid) {
                            Type = "علبه";
        
                        } else
                            Type = "له";
    
    
                        String CountDecoment = responsS.getString("CountDecoment").trim();
    
                        String key_decoment = responsS.getString("key_decoment").trim();
    
    
                        //    Toast.makeText(context, ":"+Staty+""+Type, Toast.LENGTH_SHORT).show();
    
                        mList.add(new List_All_Users(4, User_name, "0", Sol, Type, CountDecoment, key_decoment));
    
    
                        //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
    
                        //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
    
    
                    }
    
    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
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
   public  class  ClsReport {
       public   Context context;
      public ClsReport(    Context context
       )
       {
           this.context=context;
       }
       

        public   void Get_All_Data( String nameh) {


            final RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    MainActivity4_drop. uri_P , new Response.Listener<String>() {
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

                            // String iduser = responsS.getString("UserKey");

                            // int idu= responsS.getInt("id");type
                            String User_name = responsS.getString("name").trim();
                            String Staty = responsS.getString("stat").trim();
                            String Sol = responsS.getString("sol").trim();
                           String date = responsS.getString("date").trim();
                           
                            String Type = responsS.getString("type").trim();



                            String n=User_name;



                         
                            
                            
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
                                
                            

                            Toast.makeText(context, ":"+Staty+""+Type, Toast.LENGTH_SHORT).show();

                            mList.add(new List_All_Users(5, date, "0", Sol,Type,Staty,"g"));


                            //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));

                            //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));


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
    
    public static void Get_All_Data_Search_User(String nameh, String userid, String usertype,Context context) {
        
        
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
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
    public static class  GetDate {
    
        private ProgressDialog progressDialog;
    
    
    
        public void Get_All_Data_Search(String nameh, String userid, String usertype,Context context) {
        
        
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                      MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
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
    
        public void Get_All_Data(String nameh, String userid, String usertype,Context context) {
    
    
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
                            String User_id= responsS.getString("keyemple").trim();
    
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
    
    
                            mList.add(new List_All_Users(5, User_name, CountDecoment, soll, Type7, amount_due, amount_paid,User_id));
    
    
                            queue.stop();
    
                            if (progressDialog != null && progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        }
    
                    } catch (JSONException e) {
                        e.printStackTrace();
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
    
        public void Get_All_Data_Report(String nameh, String userid, String usertype,Context context) {
        int sol_sum=0,sol_end=0,sol_prind=0
;
        
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                      MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                    
                        JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                        JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                 
                        mList.clear();
                        for (int i = 0; i < jsonArray_usersS.length(); i++) {
                            JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                            // String iduser = responsS.getString("UserKey");
                        
                            // int idu= responsS.getInt("id");type
                           // String User_name = responsS.getString("name2").trim();
                            String Sol = responsS.getString("balance_due").trim();
                            String amount_due = responsS.getString("amount_due").trim();
                            String amount_paid = responsS.getString("amount_paid").trim();
                            String CountDecoment = responsS.getString("CountDecoment").trim();
                            
    //                            due = Integer.parseInt(Sol);
    
                                // استخدم قيمة العدد الصحيح في الاستخدام اللاحق هنا
                        
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
                            
                                mList.add(new List_All_Users(5, ":المبلغ" + Sol1, "له" + amount_paid, "علبه" + amount_due, Type7, amount_due, amount_paid));
                            
                        
                            queue.stop();
                        }
                    
                    } catch (JSONException e) {
                        e.printStackTrace();
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
    }
    
        public void openDate() {
        
            DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    
                    
                    
                    month = month + 1;
                    TextDateTo.setText(String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day));
                    clsDecoment clsDecomen = new clsDecoment(getActivity());
                 
    
    
                    if( spinner_3.getSelectedItem().toString().length()>0) {
                        String namees = spinner_3.getSelectedItem().toString();
    
                        if (namees.equals("الصناديق")) {
                            String TextDateFr = clsDecomen.getSendDataUrl_date(TextDateFrom.getText().toString()), TextDateto = clsDecomen.getSendDataUrl_date(TextDateTo.getText().toString());
                            //   Toast.makeText(getActivity(), "hgh:" + TextDateFr + " to:" + TextDateto, Toast.LENGTH_SHORT).show();
    
                            clsDecomen.Get_All_Data("date","k", TextDateFr, TextDateto, listView, getActivity());
    
    
    
                        } else if (!namees.equals("الصناديق")) {
        
                            MyPRE_box_print = "a";
        
                            String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_3.getSelectedItemPosition()).Id);
                            clsDecomen.Get_All_Data("date_box_date", auot_name_2, TextDateFr, TextDateto, listView, getActivity());
                        }
    
    
                    }
                    
    
                    TextDateF_print.setVisibility(View.VISIBLE);
    
    
    
    
                }
            }, year, moath_3, dayOfMonth);
        
            datePickerDialog.show();
        
        
    }}