package com.example.myapplication_mysqldatashow;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication_mysqldatashow.Models.ClsConnctionData;
import com.example.myapplication_mysqldatashow.Models.ClsSearch;
import com.example.myapplication_mysqldatashow.Models.SaveSettings;
import com.example.myapplication_mysqldatashow.Models.clsDecoment;
import com.example.myapplication_mysqldatashow.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity4_drop extends AppCompatActivity  implements HomeFragment.OnFragmentClickListener, NavigationView.OnNavigationItemSelectedListener {
            public static String uri_P = "http://192.168.1.105/test_anroid_mysql_php2/getsearch_user.php";
    
    
            public static String j=" ",id_decoment="",UserID_id="",pass="",TempTypeUser="",TempUserID="",Sol_end="",Sol_prid="",SolAll="",Count_decoment="";
           
            
            
     //  public static String uri_P_2 = "http://phpctud9900.infinityfreeapp.com/";
    //public static String uri_P_2 = "http://192.168.1.107/test_anroid_mysql_php2/";
    
    
    //public static String uri_P_2 = "https://eis.amu.edu.ye/";
   // public static String uri_P_2 = "https://eis.amu.edu.ye/getsearch_user.php?name=";
    
    public static String uri_P_2 = "https://raadjhanem.000webhostapp.com/dbraadfile/";
    
    
    
            // public static String uri_P_2 = "";
           // j="192.168.43.216";
          //  uri_P_2 = "http://"+j+"/test_anroid_mysql_php2/";
            ProgressDialog progressDialog = null;
    
   // public static String uri_P_decoment = "http://192.168.1.116/test_anroid_mysql_php2/";
            public static String GetAllBrontion = "http://192.168.1.116/test_anroid_mysql_php2/GetAllBrontion.php";
            private SharedPreferences shared_getData;
            public static final String MyPREFERENCES = "MyPrefs3" ;
    MainActivity4 d=new MainActivity4();
Button butt_1,butt_2,butt_3,butt_4;
 public String dd=d.nameinf;
            public  String dd2="0";
            private AppBarConfiguration mAppBarConfiguration;
            static final String CouresName="coures";
            static final String CouresName2="coures2";
GlobalClass globalClass;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main_list_drop);
    
    
                ClsConnctionData.isConnectingToInternet_2(MainActivity4_drop.this);
    
                Intent intent=new Intent(      MainActivity4_drop.this,MyService.class);
                startService(intent);
               
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                              WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
                }
    
                
                
                
                SharedPreferences sharedpreferences,sharedpreferences2;
    
        //        sharedpreferences =getSharedPreferences("SaveDateMain", Context.MODE_PRIVATE);
                sharedpreferences2 =getSharedPreferences("SaveDateMain_2", Context.MODE_PRIVATE);
                
               SaveSettings ds=new SaveSettings(MainActivity4_drop.this) ;
                
               ds.LoadData();
    
                sharedpreferences= getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                sharedpreferences2= getSharedPreferences("SaveDateMain_2", Context.MODE_PRIVATE);
                id_decoment=sharedpreferences.getString("id_decoment","empty");
                pass=sharedpreferences.getString("pass","empty");
                TempUserID=sharedpreferences.getString("UserID","empty");
                 TempTypeUser=sharedpreferences.getString("TypeUser","empty");
                 UserID_id=sharedpreferences.getString("UserID_id","empty");
                Sol_end=sharedpreferences.getString("amount_due","empty");
                Sol_prid=sharedpreferences.getString("amount_paid","empty");
                SolAll=sharedpreferences.getString("SolAll","empty");
    
                String h=sharedpreferences2.getString("UserName_url","empty");
               j="192.168.43.216";
                
                
            //    getSupportActionBar().setTitle("TempUserID");
                //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    
                
    

                ClsSearch search=new ClsSearch(MainActivity4_drop.this) ;
               //search.Get_All_Data_UserMain("decoment");
               
                
                
    
                butt_1 = findViewById(R.id.butt_1);
                butt_2 = findViewById(R.id.butt_2);
    
                butt_3= findViewById(R.id.butt_3);
    
                butt_4= findViewById(R.id.butt_4);
                

                globalClass=(GlobalClass)getApplicationContext();


globalClass.setName_1("م/رعد غانم");
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                NavigationView navigationView = findViewById(R.id.nav_view);
                // Passing each menu ID as a set of Ids because each
                // menu should be considered as top level destinations.
                mAppBarConfiguration = new AppBarConfiguration.Builder(
                        R.id.nav_home, R.id.nav_about)
                        .setDrawerLayout(drawer)
                        .build();
                NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
                NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
                NavigationUI.setupWithNavController(navigationView, navController);


                navigationView.setNavigationItemSelectedListener(this);


              //  Toast.makeText(this," Glopal:"+                globalClass.getName_1()
                    //    ,Toast.LENGTH_SHORT).show();


            }
    
    
    
            //END
    
    
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                super.onCreateContextMenu(menu, v, menuInfo);
                MenuInflater menuInflater = getMenuInflater();
        
                menuInflater.inflate(R.menu.context_menu, menu);
        
        
            }
    
            @Override
            public boolean onContextItemSelected(MenuItem item) {
        
                switch (item.getItemId()) {
            
                    case R.id.edit:
                
                        return true;
                    case R.id.update_quantity:
                
                        return true;
                   
                    default:
                        return super.onOptionsItemSelected(item);
                }
            }
    
    
    
            //kkkk
    
    
            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
    
                    case R.id.mune_refresh: {
    
    
                        Intent intent = new Intent(this, MainActivity4_drop.class);
    
                        startActivity(intent);
    
                        return true;
                    }
                        case R.id.action_sort_by_type:
                    {
    
                        /*
                        ClsPrinReport clsPrinReport=new ClsPrinReport(MainActivity4_drop.this);
                        //clsPrinReport.Get_All_Data("decoment");
                       // clsPrinReport.Get_All_Data3();
                        clsPrinReport.Get_All_Data("SearchSpinner_All_Auth_report","t");
    
                        //Toast.makeText(MainActivity4_drop.this,"raad",Toast.LENGTH_LONG).show();
    */
                        return true;}
                    case R.id.action_sort_by_types:
                        // item.setTitle(bo);
                       // startActivity(new Intent(All_Users_list.this, MainActivity_Reprts.class));
                
                        return true;
    
    
                    case R.id.action_sort_by_type_url:
                        /*
                        Intent in2=new Intent(MainActivity4_drop.this,MainActivity_mysqlserver.class);
                        //  in2.putExtra("name",Text_UserName.getText().toString());
                        in2.putExtra("infromation_user_intent","urldaoment_url");
                       
                        startActivity(in2);
    */
                        return true;
                    case R.id.giving_enter: {
                        // item.setTitle(bo);
                        //startActivity(new Intent(All_Users_list.this, MainActivity_Reprts.class));
                
                
                       // Get_All_Data_enter_user();
                        //  bb.setText("قبول");
                    }
                    return true;
            
            
            
            
                    
                    
                }
                return super.onOptionsItemSelected(item);
            }
    
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {


                getMenuInflater().inflate(R.menu.main_maue,menu);
        
                SearchView search=(SearchView)menu.findItem(R.id.mune_search).getActionView();
        
        
                //String searchs=menu.findItem(R.id.action_sort_by_types).getActionView();
                search.setSubmitButtonEnabled(true);
        
                search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
            
                    public boolean onQueryTextSubmit(String query) {
                        if(TempTypeUser.equals("0")) {
                            HomeFragment.Get_All_Data_Search_User("decomentone_search", query, "f", MainActivity4_drop.this);
                            return false;}
                        Toast.makeText(MainActivity4_drop.this,"غير مخول"+TempTypeUser,Toast.LENGTH_SHORT).show();
    
                        return false;
                    }
            
            
                    @Override
                    public boolean onQueryTextChange(String newText) {
    
                        if(TempTypeUser.equals("0")) {
                            HomeFragment.Get_All_Data_Search_User("decomentone_search", newText, "f", MainActivity4_drop.this);
                            return false;}
    
                        return false;
                    }
            
                });
                // showdata1();
                // Get_All_Data() ;
        
                return true;
            }

           
            @Override
            public boolean onSupportNavigateUp() {
                NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
                return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                        || super.onSupportNavigateUp();
            }


            @Override
            public boolean onMenuItemClick(int featureId, Menu menu) {
                return false;
            }

            public void OnFragmentInterAction(String name) {
  //Toast.makeText(this," Name"+name,Toast.LENGTH_SHORT).show();
                //   if (name.equals(HomeFragment.RCV_COURES2_1||HomeFragment.RCV_COURES2_2||HomeFragment.RCV_COURES2_3))

                Intent ini=getIntent();
                String  bo=ini.getStringExtra("user_name");
                Intent intent=new Intent(this,All_Users_list.class);
               intent.putExtra(CouresName,name);
               intent.putExtra("user_name",bo);
                startActivity(intent);
            }

            @Override
            public void onBackPressed() {
    
    
    
                Intent intent=new Intent(      MainActivity4_drop.this,MyService.class);
                startService(intent);
                finishAffinity();

           //     messgYesOrNo("هل تريد فعلا الخروج من البرنامج");
    
            }

            public void messgYesOrNo(String messg) {
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage(messg)
                        .setCancelable(false)
                        .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
    
    
                                Intent intent=new Intent(      MainActivity4_drop.this,MyService.class);
                                startService(intent);
                                
                                MainActivity4_drop. super.onBackPressed();
//                MainActivity4_drop.super.finish();
                            }
                        })
                        .setNegativeButton("لا", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    Toast.makeText(this, "Please enter course id:", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity4_drop.class);

                    startActivity(intent);
                }

                else if (id == R.id.navigation_report) {
                    if(TempTypeUser.equals("0")) {
                    Toast.makeText(this, "hgh:", Toast.LENGTH_SHORT).show();

                }}
                else if (id == R.id.nav_shopping_list_box) {
                    if(TempTypeUser.equals("0")) {
                    Intent in = new Intent(this, All_Users_list.class);
    
    
    
    
    
                    in.putExtra("infromation_user_intent", "Box");
    
    
                    startActivity(in);
                }}
                else if (id == R.id.nav_shopping_list_brann) {
    
    
                    if(TempTypeUser.equals("0")) {
                    Intent in = new Intent(this, All_Users_list.class);
    
    
    
    
    
                    in.putExtra("infromation_user_intent", "Brann");
    
    
                    startActivity(in);
                
                }}
                else if (id == R.id.nav_shopping_list_emp) {
    
                    if(TempTypeUser.equals("0")) {
    
                    Intent in = new Intent(this, All_Users_list.class);
    
    
    
    
    
                    in.putExtra("infromation_user_intent", "Empl");
    
    
                    startActivity(in);
    
                }}
                else if (id == R.id.nav_shopping_list) {
    
    if(TempTypeUser.equals("0")) {
        Intent in = new Intent(this, All_Users_list.class);
    
    
        in.putExtra("infromation_user_intent", "Auth");
    
    
        startActivity(in);
    }
                    
   // All_Users_list all_users_list=new All_Users_list();
   // all_users_list.Get_All_Data("employss_one", MainActivity4_drop.UserID_id);
    
                  //  ClsPrinReport clsPrinReport=new ClsPrinReport(MainActivity4_drop.this);
                    //clsPrinReport.Get_All_Data("decoment");
                    // clsPrinReport.Get_All_Data3();
                   // clsPrinReport.Get_All_Data("SearchSpinner_All_Auth_report","t");
                  //  HomeFragment.GetDate gg2 = new HomeFragment.GetDate();
    
                  //  gg2.Get_All_Data_Report("SearchSpinner_autho_report", "auot_name_2", "UserType", MainActivity4_drop.this);
                }
                else if (id == R.id.nav_delete) {
    
                    Intent intent = new Intent(this, MainActivity_mysqlserver.class);
                    intent.putExtra("infromation_user_intent","UpatePassword");
    
                    startActivity(intent);
    
                    
/*
                    
                    Intent intwep=new Intent(Intent.ACTION_VIEW);

                    intwep.setData(Uri.parse
                            ("https://www.amu.edu.ye/"));

                    if(intwep.resolveActivity(getPackageManager())!=null)
                    {
                        startActivity(intwep);
                    }
*/
                }
                
              else if (id == R.id.nav_add_remove) {
    
                    clsDecoment clsDecomen=new clsDecoment(MainActivity4_drop.this);
    
                    clsDecomen. Get_All_Data_Spiner_Login(TempUserID,pass,MainActivity4_drop.this);
    
                    progressDialog = new ProgressDialog(MainActivity4_drop.this);
                    progressDialog.setMessage("انتظر يتم تحديث  البيانات....");
                    progressDialog.setCancelable(true);
                    progressDialog.show();
                    SaveSettings ds=new SaveSettings(MainActivity4_drop.this) ;
                  //  ds.LoadData();
                    
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            // تنفيذ العملية الثانية بعد انتهاء المدة المحددة (ثلاث ثواني في هذه الحالة)
    
                            if (progressDialog.isShowing()&& progressDialog!=null) {
                                progressDialog.dismiss();
                            }
    
                        }
                    };
                 
// جدولة المهمة المجدولة بعد فترة زمنية محددة
                    timer.schedule(task, 6000);
    
                    Toast.makeText(this, "تم تحديث البيانات", Toast.LENGTH_SHORT).show();
    
                    Intent intent = new Intent(this, MainActivity4_drop.class);
    
                    startActivity(intent);
    
                }
                
                

                else if (id == R.id.nav_exit) {
                    shared_getData = getSharedPreferences("MyPrefs3", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = shared_getData.edit();
                    editor.remove("UserID");
                    editor.remove("UserID_id");
                 editor.remove("TypeUser");
    
                    editor.remove("amount_due");
                    editor.remove("amount_paid");
                    editor.remove("SolAll");
                    editor.remove("id_decoment");
    
                    SaveSettings.UserID="";
                    SaveSettings.TypeUser="";
                    SaveSettings.Count_decoment="";
                    SaveSettings.UserID_id="";
                    MainActivity4_drop.TempUserID="";
                    MainActivity4_drop.UserID_id="";
                    MainActivity4_drop.Sol_prid="";
                    MainActivity4_drop.Sol_end="";
                    MainActivity4_drop.SolAll="";
                    
                    MainActivity4_drop.TempUserID="";
                    
                    editor.apply();
              //      MainActivity4_drop. super.onBackPressed();
                    
                    
                    finishAffinity();
                    
    
                }

                else if (id == R.id.nav_about) {
                    Toast.makeText(this, "قيد التطوير", Toast.LENGTH_SHORT).show();
    
                }
    
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
    
            /*
    
            @Override
            protected void onResume() {
                super.onResume();
                Intent intent=new Intent(      MainActivity4_drop.this,MyService.class);
                startService(intent);
    
            }
*/
    
            @Override
            protected void onStop() {
                Intent intent=new Intent(      MainActivity4_drop.this,MyService.class);
                startService(intent);
    
                super.onStop();
            }
    
         
}