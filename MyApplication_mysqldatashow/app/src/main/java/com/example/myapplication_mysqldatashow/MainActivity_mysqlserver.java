    package com.example.myapplication_mysqldatashow;

    import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.Models.ClsAutName;
import com.example.myapplication_mysqldatashow.Models.ClsEmplayyContros;
import com.example.myapplication_mysqldatashow.Models.ClsEmpleyy;
import com.example.myapplication_mysqldatashow.Models.ClsSearch;
import com.example.myapplication_mysqldatashow.Models.clsDecoment;
import com.example.myapplication_mysqldatashow.Models.clsDecomentPropertis;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

    public  class MainActivity_mysqlserver extends AppCompatActivity  {
    // creating variables for our edit text
   private String types_admin="";
    DatePickerDialog.OnDateSetListener setLisiner;
    public EditText courseIDEdt,t1,t2,t3;
    private SharedPreferences shared_Save;
    private SharedPreferences shared_getData;
   String box_name , bren_name,auot_name;
    private RadioButton rbYes;
    public String date_2="";
    private static final int REQUEST_SELECT_CONTACT = 1;
    public    int iduser;
    int u=0;
    int x_op=7;
    int yu=0;
        String Strin_return_user_5="";
    
        private RadioButton rbNo;
    private RadioGroup rdGroup;
    ClsSpinerInform clsSpinerInfor;
    ArrayList<ClsSpinerInform2> clsSpinerInforms2=new ArrayList<ClsSpinerInform2>();
ArrayList<ClsSpinerInform> clsSpinerInforms=new ArrayList<>();
    ArrayList<ClsSpinerInform> clsSpinerInforms_box=new ArrayList<>();
    
    ArrayList<ClsSpinerInform2> clsSpinerInforms_emp= new ArrayList<>();
    ArrayList<ClsSpinerInform> clsSpinerInforms_boxex= new ArrayList<>();
    
    private TextInputLayout textInputLayout;
    private TextInputEditText editText;
    
    ArrayList<ClsSpinnerBrann> clsSpinerInforms_br= new ArrayList<>();
    
    ArrayList<ClsSpinnerAuths> clsSpinerInforms_authh= new ArrayList<>();
    
    
    ArrayList<ClsSpinerInform> clsSpinerInforms_box_id=new ArrayList<>();
    String vsum="",vsu,Strin_return_user_UserKey2,Strin_return_user_sol;
    public static String GetAllBrontion = "http://192.168.1.116/test_anroid_mysql_php2/GetAllBrontion.php";
    public static String uri_P_33 = "http://192.168.1.116/test_anroid_mysql_php2/getsearch_user.php";

    public static String uri_P = "http://192.168.1.116/test_anroid_mysql_php2/get_All_Users.php";
    public static String uri_P_2 = "http://192.168.1.116/test_anroid_mysql_php2/insert_decoment.php";
    
    private AutoCompleteTextView ed_name;

    // public static String uri = "http://10.0.2.2/test_anroid_mysql_php/get_All_Users.php";
   public static String uri2 = "http://192.168.1.116/test_anroid_mysql_php/readCourses.php";
    public static String uri3= "http://192.168.1.116/test_anroid_mysql_php/2UpdateUserProfile.php";
    SharedPreferences sharedpreferences2;
    // creating variable for button
    private Button getCourseDetailsBtn,addCourseDetailsBtn,but2,  but,button3_add_box;
    int  result_ok;

String result="";
    String result_2="";

    // creating variable for card view and text views.
    private CardView courseCV;
private Spinner spinner,spinner_2_2,spinner_3,spinner_4 ;
    private TextView courseNameTV, courseDescTV, courseDurationTV;
    private static final String url1="http://10.0.2.2/test_anroid_mysql_php2/db_insert.php";
    private static final String url_new_user="http://10.0.2.2/test_anroid_mysql_php/insert_new_user.php";

    //private static final String url2="http://10.0.2.2/system_decoment/db_insert.php";

    int f,ur=0;
Calendar calendar=Calendar.getInstance();
final int year=calendar.get(Calendar.YEAR);

    final int moath=calendar.get(Calendar.MONTH);

    final int day=calendar.get(Calendar.DAY_OF_MONTH);
    
    
    
    
    
    
    Button BTN_Reg;
    private ImageView imageView_avatar;
    private String User_name = "", User_Email = "", User_Password = "",NameSol="";
    public EditText ed_auot,ed_branchess_name,ed_box_name,ed_name2,ed_date,ed_sol,ed_phon,ed_gresr,max_sol;
static String sals="0";
   static String sals2 ="0";
    String bo2="l";
    String bod,yemen="yem";
    String bo3;
    public static ArrayList<List_All_Users> mList;
    public static ArrayList<String> mList2;
    public static String[] mList3=new String[0];
    public static String[] mList_2=new String[0];
    public static String[] mList_4=new String[0];
LinearLayout linearLayout,linearLayou_2, linearLayout_21,linearLayou_22, linearLayout_23,
          linearLayout_0,linearLayou_24,l_auth,l_brnn,l_box,l_emp;
    public static String[] mList_3=new String[0];

    int xx=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_add);
      //  ed_name=findViewById(R.id.editTextTextPersonName_name);
        button3_add_box=findViewById(R.id.button3_add_box);
    
        ClsSearch search=new ClsSearch
                  (MainActivity_mysqlserver.this);
    
        textInputLayout = findViewById(R.id.textInputLayout);
        editText = findViewById(R.id.editTextTextPersonName4_phone_2);
        ed_date=findViewById(R.id.editTextTextPersonName_date);
        ed_phon=findViewById(R.id.editTextTextPersonName4_phone);
        ed_gresr=findViewById(R.id.editTextTextPersonName_grest);
        ed_sol=findViewById(R.id.editTextTextPersonName6_sol);
        max_sol=findViewById(R.id.editTextTextPersonName6_so_2);

        linearLayout_21=findViewById(R.id.liner_21);
        linearLayou_22=findViewById(R.id.liner_22);

        linearLayout_23=findViewById(R.id.liner_23);
      //  linearLayou_2=findViewById(R.id.liner_22);
        linearLayout_0=findViewById(R.id.liner_2);
        l_auth=findViewById(R.id.l_auth);
        l_brnn=findViewById(R.id.l_brnn);
    
        l_box=findViewById(R.id.l_box);
    
        l_emp=findViewById(R.id.l_emp);
        //  linearLayou_2=findViewById(R.id.liner_22);
        linearLayout_0=findViewById(R.id.liner_2);



        linearLayout=findViewById(R.id.liner_3);
        linearLayou_2=findViewById(R.id.liner_4);
        ed_auot=findViewById(R.id.editTextTextPersonName_Auot);
        ed_branchess_name=findViewById(R.id.editTextTextPersonName4_branchess_name);
        ed_box_name=findViewById(R.id.editTextTextPersonName_box_name);
        spinner=findViewById(R.id.spinner_addshow);
        spinner_2_2=findViewById(R.id.spinner_addshow_2);
        spinner_3=findViewById(R.id.spinner_addshow_3);
        spinner_4=findViewById(R.id.spinner_addshow_4);
    
    
    
    
    
        max_sol.setVisibility(View.GONE);
    
    
    
    
    
//        final String auot_name_2 =  String.valueOf(clsSpinerInforms_boxex.get(spinner_3.getSelectedItemPosition()).Id);
    
        ClsSearch bb2=new ClsSearch(this);
    
    
    
    
    
        search.Get_All_Data_box("decomentone_search_spinner_box","u",spinner_3,clsSpinerInforms_boxex);
        search.Get_All_Data_brann("php_branchess","op",spinner_2_2,clsSpinerInforms_br);
        search.Get_All_Data_auth("decomentone_search_spinner_box",spinner,clsSpinerInforms_authh);
    
        search.Get_All_Data_22("decomentone_search_spinner_empl","i",spinner_4,clsSpinerInforms_emp);
    
        but=(Button)findViewById(R.id.button2_op) ;
        but2=(Button)findViewById(R.id.button_op2) ;
        rbYes = (RadioButton) findViewById(R.id.radioButton4);
        rbNo = (RadioButton) findViewById(R.id.radioButton3);

        rdGroup = (RadioGroup) findViewById(R.id.radiogroup);

        String m4=java.text.DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
    
        int md=moath+1;
        
        String date_3 =  year +"/" +md+"/" +day ;
    
    
        sharedpreferences2= MainActivity_mysqlserver.this.getSharedPreferences("SaveDateMain_2", Context.MODE_PRIVATE);
    
    
        ed_date.setText(date_3);
    
    
    
        ed_phon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContacts();
            }
        });
    
        ed_name = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        bb2.Get_All_Data_2("decomentone_search_auttext", "uu", MainActivity_mysqlserver.this, ed_name, clsSpinerInforms);
    
    
        ed_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // لا يتم استخدامه في هذا المثال
            }
        
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // يتم استدعاءه عندما يتم تغيير النص داخل حقل النص
                String newText = s.toString();
            
            
                yemen="tize";
            
                String newTex_2;
                if (spinner.getSelectedItem() != null) {
                    newTex_2 = spinner.getSelectedItem().toString();
                
                    if (!newTex_2.equals("المناطق")) {
                        
                        
    
                        final String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_2_2.getSelectedItemPosition()).Id);
    
                        bb2.Get_All_Data_2("decomentone_search_auttext_2", auot_name_2, MainActivity_mysqlserver.this, ed_name, clsSpinerInforms);
                    
                    }
                } else {
                    // قيمة سابقة في حالة القيمة المحددة هي null
                    newTex_2 = ""; // أو أي قيمة أخرى تعامل كمعامل افتراضي
                }
            
            
                // قم بتنفيذ الإجراء المطلوب عند تغيير النص
                // على سبيل المثال، يمكنك تحديث واجهة المستخدم أو تنفيذ معالجة خاصة بالنص المدخل
            
            }
            @Override
            public void afterTextChanged(Editable s) {
                // لا يتم استخدامه في هذا المثال
            }
        });
        
        button3_add_box.setOnClickListener(new View.OnClickListener() {


                @SuppressLint("WrongConstant")
                @Override
                public void onClick(View arg0) {
                    spinner_4.setVisibility(View.GONE);



                    //   Toast.makeText(getApplicationContext(), "goodbiy"+x, 4000).show();
                    PopupMenu popupMenu = new PopupMenu(MainActivity_mysqlserver.this, arg0);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                             @Override
                                                             public boolean onMenuItemClick(MenuItem item) {
                                                                 ShowLayout();
                                                                 switch (item.getItemId()) {
                                                                     case R.id.update_quantity: {
                                                                         button3_add_box.setVisibility(View.GONE);
    
                                                                         l_box.setVisibility(View.GONE);
                                                                         l_brnn.setVisibility(View.GONE);
                                                                         l_auth.setVisibility(View.GONE);
                                                                         linearLayout_23.setVisibility(View.VISIBLE);
                                                                         // linearLayout_21.setVisibility(View.GONE);
                                                                         //spinner_4.setVisibility(View.GONE);
                                                                         ed_auot.setHint("المنطقة");
                                                                         ed_box_name.setVisibility(View.GONE);
                                                                         ed_branchess_name.setVisibility(View.GONE);
    
                                                                         ed_box_name.setHint("الصندوق");
                                                                         ed_branchess_name.setHint("الفرع");
                                                                         result = "No_addAout";
                                                                         spinner_3.setVisibility(View.GONE);
                                                                         spinner_2_2.setVisibility(View.GONE);
                                                                         spinner.setVisibility(View.GONE);
    
                                                                     }
                                                                     return true;
                                                                     case R.id.edit: {
                                                                         button3_add_box.setVisibility(View.GONE);
                                                                         spinner_3.setVisibility(View.GONE);
                                                                         l_box.setVisibility(View.GONE);
                                                                         l_brnn.setVisibility(View.GONE);
                                                                         l_auth.setVisibility(View.VISIBLE);
                                                                         linearLayout_23.setVisibility(View.VISIBLE);
                                                                         result = "No_addBre";
                                                                         ed_branchess_name.setVisibility(View.VISIBLE);
                                                                         ed_box_name.setVisibility(View.GONE);
                                                                         spinner_4.setVisibility(View.GONE);
                                                                         ed_auot.setVisibility(View.GONE);
                                                                         ed_box_name.setVisibility(View.GONE);
                                                                         // ed_box_name.setHint("الصندوق");
                                                                         ed_branchess_name.setHint("الفرع");
    
                                                                         spinner_3.setVisibility(View.GONE);
                                                                         spinner_2_2.setVisibility(View.GONE);
                                                                     }
                                                                     return true;
/*
                                                                     case R.id.consume:
                                                                     {
                                                                         button3_add_box.setVisibility(View.GONE);
    
                                                                         l_auth.setVisibility(View.VISIBLE);
                                                                         l_brnn.setVisibility(View.VISIBLE);
                                                                         l_box.setVisibility(View.GONE);
                                                                         linearLayout_23.setVisibility(View.VISIBLE);

                                                                         result="No_addBox";
                                                                         ed_auot.setVisibility(View.GONE);
                                                                         ed_branchess_name.setVisibility(View.GONE);
                                                                         ed_box_name.setHint("الصندوق");
                                                                         spinner_3.setVisibility(View.GONE);

                                                                 }}*/
                                                                 }
                                                                 return true;
                                                             
                                                         }}
                    );
                    popupMenu.inflate(R.menu.context_menu);
                    popupMenu.show();
                }
            });
    
    
        rbNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    
    
                types_admin="1";
                
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_mysqlserver.this);
                builder.setTitle("معلومات المستلم");

// إنشاء حاوية لعرض تخطيط الحوار
                LinearLayout layout = new LinearLayout(MainActivity_mysqlserver.this);
                layout.setOrientation(LinearLayout.VERTICAL);

// إضافة حقل النص للاسم
                EditText nameEditTex_5 = new EditText(MainActivity_mysqlserver.this);
                nameEditTex_5.setHint("اسم المستلم(اختياري)");
                
                
     
                //nameEditText.setText();
                layout.addView(nameEditTex_5);
                builder.setView(layout);
                
    
                builder.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
    
                        NameSol=nameEditTex_5.getText().toString();
                        
                        dialog.dismiss();
                    }
                });

// عرض المربع الحواري
                AlertDialog dialog = builder.create();
                dialog.show();
    
            }
        });
ed_date.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity_mysqlserver.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               
                month = month + 1;
                ed_date.setText(String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(dayOfMonth));
            }
        }, year, moath, day);
        datePickerDialog.show();
    }
});
    
    
    

        // ed_name=findViewById(R.id.editTextTextPersonName_name);


        Intent Intent_Information_User =getIntent();
        String Strin_return_user_name=Intent_Information_User.getStringExtra("user_name");
        String Strin_return_user_date=Intent_Information_User.getStringExtra("date_time");
         Strin_return_user_sol=Intent_Information_User.getStringExtra("sol");

        String Strin_return_user_Sumsol=Intent_Information_User.getStringExtra("sumsol");

         Strin_return_user_UserKey2=Intent_Information_User.getStringExtra("UserKey2");
        ClsSearch bb=new ClsSearch();
        
        
    //    bb.Get_All_Data(MainActivity_mysqlserver.this,spinner,spinner_2_2,spinner_3,spinner_4,clsSpinerInforms,clsSpinerInforms2,clsSpinerInforms_box,clsSpinerInforms_box_id, listView, getActivity());
        //Get_All_Data_22("nameh9");


        // ed_name.setText(Strin_return_user_name);
            //ed_name.setText(Strin_return_user_sol);
            //ed.setText(Strin_return_user_Sumsol);
           String Strin_return_user = Intent_Information_User.getStringExtra("infromation_user_intent");
    
        if(Strin_return_user.contains("AddNewBox")) {
    
    
            search.Get_All_Data_22("decomentone_search_spinner_empl","i",spinner_4,clsSpinerInforms_emp);
            search.Get_All_Data_box("decomentone_search_spinner_box","u",spinner_3,clsSpinerInforms_boxex);
            search.Get_All_Data_brann("php_branchess","op",spinner_2_2,clsSpinerInforms_br);
            search.Get_All_Data_auth("decomentone_search_spinner_box",spinner,clsSpinerInforms_authh);
    
            button3_add_box.setVisibility(View.GONE);
    
            l_auth.setVisibility(View.VISIBLE);
            l_brnn.setVisibility(View.VISIBLE);
    
            linearLayout_23.setVisibility(View.GONE);
    
            result="No_addBox";
            ed_auot.setVisibility(View.GONE);
            ed_branchess_name.setVisibility(View.GONE);
            ed_box_name.setHint("الصندوق");
            spinner_3.setVisibility(View.GONE);
            
        }

        if(Strin_return_user.contains("Sitataoment")) {
    
            button3_add_box.setVisibility(View.GONE);
    
            linearLayou_2.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
// linearLayout_21.setVisibility(View.GONE);
            linearLayout_23.setVisibility(View.GONE);
            linearLayou_22.setVisibility(View.GONE);

            /// ed_phon.setText("كلمة المرور");
            //ed_name.setText("المبلغ");
            //  ed_gresr.setText("كلمة المرور");
            //ed_sol.setText("اعادة كلمة الرور");
            ed_sol.setVisibility(View.GONE);
            //   ed_gresr.setVisibility(View.GONE);
            ed_phon.setVisibility(View.GONE);
            result = "220";
            ur=20;
    
            
    
        }

        else if(Strin_return_user.contains("UpatePassword")) {
            linearLayou_2.setVisibility(View.GONE);
    
            ed_phon.setVisibility(View.GONE);
            button3_add_box.setVisibility(View.GONE);
            l_emp.setVisibility(View.GONE);
            l_auth.setVisibility(View.GONE);
            l_brnn.setVisibility(View.GONE);
            l_box.setVisibility(View.GONE);
            
            //ed_sol. setInputType(InputType.TYPE_CLASS_TEXT);
    
    
            ed_gresr.setVisibility(View.VISIBLE);
            ed_sol.setVisibility(View.VISIBLE);
            ed_gresr.setHint("كلمة المرورالجديدة");
            ed_sol.setHint("اعادة كلمة المرور");
            ed_sol. setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    
            //   linearLayout.setVisibility(View.GONE);
//            linearLayout_21.setVisibility(View.GONE);
            linearLayout_23.setVisibility(View.GONE);
            linearLayou_22.setVisibility(View.GONE);
            /// ed_phon.setText("كلمة المرور");
            //ed_name.setText("المبلغ");
            //  ed_gresr.setText("كلمة المرور");
            //ed_sol.setText("اعادة كلمة الرور");
            
    
            //   ed_gresr.setVisibility(View.GONE);
          //  editText.setVisibility(View.VISIBLE);
         //   ed_phon.setVisibility(View.GONE);
            ur=10;
            result = "UpatePassword";
            
            
        }

        else if(Strin_return_user.contains("urldaoment_url")) {
            result = "urldaoment_url";
        }
else if(Strin_return_user.contains("decoment")) {
            // button3_add_box.setVisibility(View.GONE);
            ///spinner_3.setVisibility(View.GONE);
            //spinner_2.setVisibility(View.GONE);
            //spinner.setVisibility(View.GONE);
            button3_add_box.setVisibility(View.VISIBLE);
            max_sol.setVisibility(View.VISIBLE);
    
            l_box.setVisibility(View.GONE);
    
            Strin_return_user_5 = Intent_Information_User.getStringExtra("Text_UserName");
    
            l_emp.setVisibility(View.GONE);
            if( Strin_return_user_5!="")
            {
                ed_name.setText(Strin_return_user_5);
        
            }
            
            
            search.Get_All_Data_22("decomentone_search_spinner_empl","i",spinner_4,clsSpinerInforms_emp);
            search.Get_All_Data_box("decomentone_search_spinner_box","u",spinner_2_2,clsSpinerInforms_boxex);
            //search.Get_All_Data_brann("php_branchess","op",spinner_2_2,clsSpinerInforms_br);
            search.Get_All_Data_auth("decomentone_search_spinner_box",spinner,clsSpinerInforms_authh);
            // search.Get_All_Data_22("",spinner_4,clsSpinerInforms_emp);
            //search.Get_All_Data_22("",spinner_4,clsSpinerInforms_emp);
            // Get_All_Data_22("decomentone_search_spinner" );
            
            
            
            rbYes.setText("له");
    
            rbNo.setText("عليه");
            ed_date.setVisibility(View.VISIBLE);
    
            ed_gresr.setHint("المبلغ");
            ed_gresr. setInputType(InputType.TYPE_CLASS_NUMBER);
    
            // ed_date.setText( date_37);
            /// ed_phon.setText("كلمة المرور");
            ed_name.setHint("الاسم");
            max_sol.setHint("التفاصيل");
    
            //  ed_gresr.setText("كلمة المرور");
            //ed_sol.setText("اعادة كلمة الرور");
            ed_sol.setVisibility(View.GONE);
            //   ed_gresr.setVisibility(View.GONE);
            ed_phon.setVisibility(View.GONE);
            //  ed_name.setVisibility(View.GONE);
            result = "employss";
    
    
    
        }



            else if(Strin_return_user.contains("employss"))
        {

           result="decoment";

        }
      else
        {
             result_2="3";
            result="employss";
//Get_All_Data();
            spinner_4.setVisibility(View.GONE);
            //ed_name.setText(Strin_return_user+"");
        }

        Intent v_user=getIntent();
         bod=v_user.getStringExtra("find_user");
         bo3=v_user.getStringExtra("find_user2");

      //  Get_All_Data_select_sum_sal(bo);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


finish();
                //Send_Data_Registration se=new Send_Data_Registration(name,uname,pwd,);
                //startActivity(new Intent(MainActivity_mysqlserver.this,LogIn.class));

            }
        });



            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    
    yu=9;
                    ClsAutName clsAutName = new ClsAutName(MainActivity_mysqlserver.this);
                    ClsEmpleyy clsEmpleyy = new ClsEmpleyy();
    
    
                    auot_name = ed_auot.getText().toString().trim();
                    bren_name = ed_branchess_name.getText().toString().trim();
                    box_name = ed_box_name.getText().toString().trim();
    
                    clsEmpleyy.setDate(auot_name);
                    clsEmpleyy.setDetails(bren_name);
                    clsEmpleyy.setPassowrds(box_name);
    
                    if (result == "No_addAout") {
        
                        clsEmpleyy.setType("add_authorities");
                        if (TextUtils.isEmpty(ed_auot.getText().toString().trim())) {
                            Toast.makeText(getApplicationContext(), "يجب تعبية جميع الحقول" + result, Toast.LENGTH_LONG).show();
                            return;
                        }
        
                        clsAutName.add(clsEmpleyy);
                    } else if (result == "No_addBre") {
        
                        String newTex_2 = spinner.getSelectedItem().toString();
        
                        if (newTex_2.equals("المناطق")) {
                            Toast.makeText(getApplicationContext(), "يرجا تحديدالمنطقة", Toast.LENGTH_LONG).show();
            
                            return;
                        }
        
        
                        clsEmpleyy.setType("add_bre");
                        final String auot_name_2 = String.valueOf(clsSpinerInforms_authh.get(spinner.getSelectedItemPosition()).Id);
                        //   Toast.makeText(getApplicationContext(), "iu:"+auot_name_2, Toast.LENGTH_LONG).show();
                        clsEmpleyy.setPassowrds(bren_name);
        
                        clsEmpleyy.setDate(auot_name_2);
                        if (TextUtils.isEmpty(auot_name_2) || TextUtils.isEmpty(bren_name)) {
                            Toast.makeText(getApplicationContext(), "يجب تعبية جميع الحقول" + result, Toast.LENGTH_LONG).show();
                            return;
                        }
        
        
                        //if(auot_name_2!="الجهة")
                        clsAutName.add(clsEmpleyy);
                    } else if (result == "No_addBox") {
                        clsEmpleyy.setType("No_addBox");
        
                        final String bran_name1 = String.valueOf(clsSpinerInforms_br.get(spinner_2_2.getSelectedItemPosition()).Id);
        
                        String newTex_2 = spinner.getSelectedItem().toString();
                        String newTex_3 = spinner_2_2.getSelectedItem().toString();
        
                        if (newTex_2.equals("المناطق")) {
                            Toast.makeText(getApplicationContext(), "يرجا تحديد المنطقة", Toast.LENGTH_LONG).show();
            
                            return;
                        }
                        if (newTex_3.equals("الفروع")) {
                            Toast.makeText(getApplicationContext(), "يرجا تحديد الفرع", Toast.LENGTH_LONG).show();
    
                            return;
                        }
        
        
                        if (TextUtils.isEmpty(bran_name1) || TextUtils.isEmpty(box_name)) {
                            Toast.makeText(getApplicationContext(), "يجب تعبية جميع الحقول" + result, Toast.LENGTH_LONG).show();
                            return;
                        }
        
        
                        clsEmpleyy.setDate(bran_name1);
                        clsAutName.add(clsEmpleyy);
                    } else if (result == "nodaoment_url") {
        
        
                        MainActivity4_drop.j = ed_gresr.getText().toString().trim();
                        SharedPreferences.Editor editor = sharedpreferences2.edit();
                        editor.putString("UserName_url", ed_gresr.getText().toString().trim());
        
        
                        editor.commit();
        
        
                    } else if (result == "UpatePassword") {
        
                        final String name = ed_name.getText().toString().trim();
                        final String phone = ed_phon.getText().toString().trim();
                        final String date = ed_date.getText().toString().trim();
                        final String gresr = ed_gresr.getText().toString().trim();
                        final String sol = ed_sol.getText().toString().trim();
        
                        if (gresr.equals(sol)) {
            
            
                            // final String auot_name_2 =  String.valueOf(clsSpinerInforms.get(spinner_3.getSelectedItemPosition()).Id);
            
            
                            final String typadmin = "69";
                            clsEmpleyy.setNameAuthor(MainActivity4_drop.UserID_id);
                            clsEmpleyy.setUser_name(name);
                            clsEmpleyy.setPhoneUser("UpatePassword");
                            clsEmpleyy.setDate(date);
                            clsEmpleyy.setDetails(gresr);
                            clsEmpleyy.setPassowrds(sol);
                            clsEmpleyy.setType(typadmin);
                            ClsEmplayyContros.typ_opion = "UpatePassword";
                            ClsEmplayyContros empleyy = new ClsEmplayyContros(MainActivity_mysqlserver.this);
                            empleyy.update(clsEmpleyy);
            
                        } else
                            Toast.makeText(getApplicationContext(), "كلمه المرور غبر متطابقه", Toast.LENGTH_LONG).show();
        
        
                    } else if (result == "220") {
        
        
                        // Toast.makeText(getApplicationContext(), "jgg7:" + Strin_return_user_UserKey2, Toast.LENGTH_LONG).show();
        
                        final String gresr = ed_gresr.getText().toString().trim();
        
        
                        if (TextUtils.isEmpty(gresr)) {
                            Toast.makeText(MainActivity_mysqlserver.this, "يجب تعبئة  الحقول", Toast.LENGTH_SHORT).show();
            
                        } else {
                            clsDecoment clsd = new clsDecoment(MainActivity_mysqlserver.this);
            
                            clsd.YesDecoment("No_dacoment", Strin_return_user_UserKey2, gresr, MainActivity_mysqlserver.this);
            
                        }
                    } else if (result == "employss") {
    
                        if (MainActivity4_drop.TempTypeUser.equals("0")) {
                            final String typadmin = types_admin;
        
                            if ( TextUtils.isEmpty(ed_name.getText().toString()) || TextUtils.isEmpty(ed_date.getText().toString()) || TextUtils.isEmpty(ed_gresr.getText().toString()) || TextUtils.isEmpty(max_sol.getText().toString())) {
                                Toast.makeText(MainActivity_mysqlserver.this, "يجب تعبئة  الحقول", Toast.LENGTH_SHORT).show();
                                return;
                            }
        
                            if (spinner.getCount() == 0 || spinner_2_2.getCount() == 0 || spinner_3.getCount() == 0) {
                                Toast.makeText(MainActivity_mysqlserver.this, "تأكد من تعبئة جميع البيانات", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            String inputName = ed_name.getText().toString();
                            boolean nameExists = false;
        
                            if (!TextUtils.isEmpty(Strin_return_user_5) && Strin_return_user_5.equals(ed_name.getText().toString().trim())) {
                                nameExists = true;
                            } else {
            
                                for (ClsSpinerInform item : clsSpinerInforms) {
                                    if (item.Name.equals(inputName)) {
    
                                        iduser = item.IdEmp;
                                        nameExists = true;
                                        break;
                                    }
                                }
                            }
        
                            if (nameExists) {
            
                                String uer = String.valueOf(iduser);
            
                                //   final String auot_name_2 =  String.valueOf(clsSpinerInforms_emp.get(spinner_4.getSelectedItemPosition()).Id);
            
                                //   Toast.makeText(MainActivity_mysqlserver.this, auot_name_2+" بنجاح", Toast.LENGTH_SHORT).show();
            
            
                                if (spinner.getCount() == 0 || spinner_2_2.getCount() == 0 ) {
                                    Toast.makeText(MainActivity_mysqlserver.this, "تأكد من تعبئة جميع البيانات", Toast.LENGTH_SHORT).show();
                                    return;
                                }
            
                                clsDecomentPropertis cldecoment = new clsDecomentPropertis();
            
            
                                final String gresr = max_sol.getText().toString().trim();
                                final String sol = ed_gresr.getText().toString().trim();
                                final String date = ed_date.getText().toString().trim();
                                cldecoment.NameAuthor="0";
                                
                                
        
                cldecoment.NameAuthor = NameSol;
                
            
                                
            
                                cldecoment.User_name = ed_name.getText().toString();
                                cldecoment.Date = date;
                                cldecoment.Details = gresr;
                                cldecoment.setSol(sol);
                                cldecoment.Type = typadmin;
                                clsDecoment.typ_option = "insert_dacoment";
                                clsDecoment.url_post_add = "insert_dacoment";
            
            
                                clsDecoment cld = new clsDecoment(MainActivity_mysqlserver.this);
            
                                cld.add(cldecoment);
            
            
                                //    Toast.makeText(getApplicationContext(), "ok:" , Toast.LENGTH_LONG).show();
                            } else {
            
            
                                String newTex_2 = spinner.getSelectedItem().toString();
                                String newTex_3 = spinner_2_2.getSelectedItem().toString();
                                String newTex_4 = spinner_3.getSelectedItem().toString();
    
    
                                if (newTex_2.equals("المناطق")) {
                                    Toast.makeText(getApplicationContext(), "الرجا تحديد المنطقة", Toast.LENGTH_LONG).show();
        
                                    return;
                                }
                                if (newTex_3.equals("الفروع")) {
                                    Toast.makeText(getApplicationContext(), "الرجا تحديد الفرع", Toast.LENGTH_LONG).show();
        
                                    return;
                                }
    
    
                                /*
                                if (newTex_4.equals("الصناديق")) {
                                    Toast.makeText(getApplicationContext(), "الرجا تحديد الصندوق", Toast.LENGTH_LONG).show();
                
                                    return;
                                }*/
            
                                AlertDialog.Builder bu = new AlertDialog.Builder(MainActivity_mysqlserver.this);
            
                                bu.setTitle("اضافه اسم جديد")
                                ;
                                bu.setMessage(ed_name.getText().toString());
                                bu.setPositiveButton("نعم ", new DialogInterface.OnClickListener(
                                ) {
    
                                    @SuppressLint("WrongConstant")
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
        
        
                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_mysqlserver.this);
                                        builder.setTitle("معلومات الحساب");

// إنشاء حاوية لعرض تخطيط الحوار
                                        LinearLayout layout = new LinearLayout(MainActivity_mysqlserver.this);
                                        layout.setOrientation(LinearLayout.VERTICAL);

// إضافة حقل النص للاسم
                                        EditText nameEditText = new EditText(MainActivity_mysqlserver.this);
                                        nameEditText.setHint("الاسم");
                                        nameEditText.setText(ed_name.getText().toString());
                                        layout.addView(nameEditText);

// إضافة حقل النص لرقم الهاتف
                                        EditText phoneEditText = new EditText(MainActivity_mysqlserver.this);
                                        phoneEditText.setHint("رقم الهاتف اختياري");
                                        layout.addView(phoneEditText);

// تعيين تخطيط للحاوية في المربع الحواري
                                        builder.setView(layout);

// إضافة زر "حفظ" إلى المربع الحواري
                                        builder.setPositiveButton("حفظ", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                nameEditText.setText(ed_name.getText().toString());
    
                                                String name = nameEditText.getText().toString().trim();
                                                String phone = phoneEditText.getText().toString();
    
                                                final String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_2_2.getSelectedItemPosition()).Id);
    
                                                if (spinner.getCount() == 0 || spinner_2_2.getCount() == 0 ) {
                                                    Toast.makeText(MainActivity_mysqlserver.this, "تأكد من تعبئة جميع البيانات 4", Toast.LENGTH_SHORT).show();
                                                    return;
                                                }
                                                if (phone == "") {
                                                    phone = "null";
                                                }
    
                                                final String editT = editText.getText().toString().trim();
                                                final String date = ed_date.getText().toString().trim();
                                                final String gresr = max_sol.getText().toString().trim();
                                                final String sol = ed_gresr.getText().toString().trim();
                                                final String typadmin = types_admin;
    
                                                clsEmpleyy.setNameAuthor(auot_name_2);
                                                clsEmpleyy.setUser_name(name);
                                                clsEmpleyy.setPhoneUser(phone);
                                                clsEmpleyy.setDate(date);
                                                clsEmpleyy.setDetails(gresr);
                                                clsEmpleyy.setPassowrds("admin123");
                                                clsEmpleyy.setType("1");
                                                ClsEmplayyContros empleyy = new ClsEmplayyContros(MainActivity_mysqlserver.this);
    
                                                ClsEmplayyContros.typ_opion = "add_user_and_decoment";
    
    
                                                if (spinner.getCount() == 0 || spinner_2_2.getCount() == 0 ) {
                                                    Toast.makeText(MainActivity_mysqlserver.this, "تأكد من تعبئة جميع البيانات654", Toast.LENGTH_SHORT).show();
                                                    return;
                                                }
    
                                                clsDecomentPropertis cldecoment = new clsDecomentPropertis();
    
                                                final String gresr_2 = max_sol.getText().toString().trim();
                                                final String sol_2 = ed_gresr.getText().toString().trim();
                                                final String date_2 = ed_date.getText().toString().trim();
                                                final String typadmin_2 = types_admin;
    
                                               cldecoment.NameAuthor = "0";
    
    
                                                    cldecoment.NameAuthor=NameSol;
    
                                                cldecoment.User_name = ed_name.getText().toString();
                                                cldecoment.Date = date_2;
                                                cldecoment.Details = gresr_2;
                                                cldecoment.setSol(sol_2);
                                                cldecoment.Type = typadmin_2;
    
                                                clsDecoment.typ_option = "add_user_and_decoment";
                                                clsDecoment cld = new clsDecoment(MainActivity_mysqlserver.this);

// تنفيذ العملية الأولى
                                                empleyy.add(clsEmpleyy);
                                                Strin_return_user_5 = "";

// إنشاء المؤقت
                                                Timer timer = new Timer();
                                                TimerTask task = new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        // تنفيذ العملية الثانية بعد انتهاء المدة المحددة (ثلاث ثواني في هذه الحالة)
                                                        cld.add(cldecoment);
                                                    }
                                                };

// جدولة المهمة المجدولة بعد فترة زمنية محددة
                                                timer.schedule(task, 3000);
    
    
                                                // استخدم الاسم ورقم الهاتف المدخلين هنا
                                                // يمكنك عرضهما في سجل النتائج أو إجراء أي إجراء آخر
                                            }
                                        });

// إضافة زر "إلغاء" إلى المربع الحواري
                                        builder.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });

// عرض المربع الحواري
                                        AlertDialog dialog = builder.create();
                                        dialog.show();
        
        
                                    }
                                });
            
                                bu.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                
                                    @Override
                                              public void onClick(DialogInterface arg0, int arg1) {
                    
                    
                                    }
                                          }
                                );
                                bu.show();
            
            
                            }
                        
                    }

                    else if (result == "decoment") {
                
                                String User_name = "k";
                
                             
                
                            } else
                
                                //  Registration(MainActivity_mysqlserver.this);
                
                
                                //String CountDecoment = responsS.getString("CountDecoment").trim();
                
                                //String key_decoment2 = responsS.getString("key_decoment").trim();
                
                
                                Toast.makeText(MainActivity_mysqlserver.this, ":", Toast.LENGTH_SHORT).show();
                
                                // MainActivity4_drop.j= ed_gresr.getText().toString().trim();
                
                
                                // SharedPreferences.Editor   editor = sharedpreferences2.edit();
                                //   editor.putString("UserName_url",ed_gresr. getText().toString().trim());
                
                
                                // editor.commit();
                
                
            
                            //insertdata2();
            
            
                            // finish();
            
            
                        }
                    
                }
            });
    
        ed_auot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registration(MainActivity_mysqlserver.this);



            }
        });
     
        spinner_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    
    
                if (position < clsSpinerInforms_boxex.size()) {
                    // استخدام items.get(position) للوصول إلى العنصر في القائمة
                    String auot_name_2 = String.valueOf(clsSpinerInforms_boxex.get(spinner_3.getSelectedItemPosition()).Id);
    
    
                    String newTex_2, newTex_3;
                    ClsSearch search = new ClsSearch
                              (MainActivity_mysqlserver.this);
                    search.Get_All_Data_22("decomentone_search_spinner_empl_2", auot_name_2, spinner_4, clsSpinerInforms_emp);
    
    
                    String newTex_2_2;
                    if (spinner_4.getSelectedItem() != null) {
                        newTex_2 = spinner_4.getSelectedItem().toString();
                        newTex_3 = spinner_3.getSelectedItem().toString();
        
                        if (!newTex_3.equals("الصناديق")&&yu==0) {
    
   // List <String>list=new ArrayList<>();
  //  list.add(newTex_2);
    
                           // ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(MainActivity_mysqlserver.this, android.R.layout.simple_dropdown_item_1line, list);
                            ed_name.setText(String.valueOf(newTex_2));
    
                        }
                    } else if(yu==0) {
    
                        ed_name.setText(String.valueOf(""));
    
                        // قيمة سابقة في حالة القيمة المحددة هي null
                        newTex_2 = ""; // أو أي قيمة أخرى تعامل كمعامل افتراضي
                    }
                  
                    
                    /*
                          //  newTex_2 = spinner_4.getSelectedItem().toString();
                            String newTex_3 = spinner_3.getSelectedItem().toString();
    
    switch (newTex_3 ) {
        case "الصناديق": {
            String newTex_24 = "k";
            break;
        }
    
        default:
        {
            if (!newTex_3.equals("الصناديق") && !newTex_3.equals("") && !spinner_4.getSelectedItem().equals("")) {
                ed_name.setText(spinner_4.getSelectedItem().toString());
    
    
            } else if(newTex_3.equals("")||spinner_4.getSelectedItem().equals("") ) {
    
                String kk = "";
    
    
            }
    }
    break;
    }*/
                      
                            // تنفيذ الإجراءات اللازمة بناءً على العنصر المحدد
                        
                    
                }
                //  Toast.makeText(MainActivity_mysqlserver.this, auot_name_2+" بنجاح", Toast.LENGTH_SHORT).show();
              //  Get_All_Data_serch("SearchSpinner_auth",auot_name_2) ;
            }
        
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            
            }
        
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position < clsSpinerInforms_authh.size()) {
                    String auot_name_2 = String.valueOf(clsSpinerInforms_authh.get(position).Id);
        
                    ClsSearch search = new ClsSearch(MainActivity_mysqlserver.this);
                    
                    
                    search.Get_All_Data_box("decomentone_search_spinner_box_id",auot_name_2,spinner_2_2,clsSpinerInforms_boxex);
    
                   // search.Get_All_Data_brann("decomentone_search_spinner_box_id", auot_name_2, spinner_2_2, clsSpinerInforms_br);
                }
    
                //    String auot_name_2 = String.valueOf(clsSpinerInforms.get(spinner.getSelectedItemPosition()).Id);
              //  Toast.makeText(MainActivity_mysqlserver.this, auot_name_2+" بنجاح", Toast.LENGTH_SHORT).show();
               //Get_All_Data_serch("SearchSpinner_auth",auot_name_2) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        /*
    
        spinner_2_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    
          
    
                
                
                if (position < clsSpinerInforms_br.size()) {
                    String auot_name_2 = String.valueOf(clsSpinerInforms_br.get(spinner_2_2.getSelectedItemPosition()).Id);
    
    
                    search.Get_All_Data_box("decomentone_search_spinner_box_id",auot_name_2,spinner_3,clsSpinerInforms_boxex);
    
                }
    
                //    String auot_name_2 = String.valueOf(clsSpinerInforms.get(spinner.getSelectedItemPosition()).Id);
                // Toast.makeText(MainActivity_mysqlserver.this,auot_name_2 +" بنجاح", Toast.LENGTH_SHORT).show();
                //Get_All_Data_serch("SearchSpinner_auth",auot_name_2) ;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
        
            }
    
        });
    
        
        */
    
    
    
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String phoneNumber = cursor.getString(numberIndex);
                cursor.close();
                ed_phon.setText(phoneNumber);
            }
        }
    }
            
        
    
    
    private boolean isValidNumber(String input) {
        // قم بتنفيذ التحقق من صحة الرقم هنا
        // في هذا المثال، نتحقق فقط مما إذا كان النص قابلًا للتحويل إلى رقم صحيح
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public    void ShowLayout() {

        linearLayou_2.setVisibility(View.GONE);
        linearLayout.setVisibility(View.GONE);
       // linearLayout_21.setVisibility(View.GONE);

        linearLayou_22.setVisibility(View.GONE);
        linearLayout_0.setVisibility(View.GONE);
    }
 public    void Registration(Context context)
 {
 
 }


 


        @Override
        public void onBackPressed() {
            // إغلاق النشاط الحالي
            finish();
        
            // فتح نشاط آخر
            Intent intent = new Intent(this, MainActivity4_drop.class);
            startActivity(intent);
        }
public  String sola()
{
    final String name = ed_name.getText().toString().trim();



    sals= Get_All_Data_select_sum_sal(name);
    String k=sals2;
    if(sals=="0")
    {
        return sola();
    }
    else
    {
        return sals2;
    }

}
    private void openContacts() {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, REQUEST_SELECT_CONTACT);
    }
    


    public  void insertdata_decoment() {




        final String date = ed_date.getText().toString().trim();






        StringRequest request = new StringRequest(Request.Method.POST, uri_P_2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                ed_date.setText("");

             //   Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> param = new HashMap<String, String>();

               param.put("dates",date);

                return param;
            }
        };


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }


    private RadioGroup getRdGroup() {
        return rdGroup;
    }



    public String Get_All_Data_select_sum_sal(String nameText) {
         String up="";
        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                uri2 , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    
                    String kk="";
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);

                  //  mList.clear();
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                  //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        // String UserKey = responsS.getString("UserKey").trim();
                       // String User_name = responsS.getString("UserName").trim();
                        // String Email = responsS.getString("Email").trim();
                         sals2 = responsS.getString("sol").trim();
                         kk=sals2;

                    }


                    Intent in=new Intent(MainActivity_mysqlserver.this,MainActivity_mysqlserver.class);

                    in.putExtra("raad4",sals2);
                    startActivity(in);
                   //// SharedPreferences.Editor editor = shared_Save.edit();
                  //  editor.putString("Local_UserKey", kk.trim());

                   // editor.apply();



                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

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

return sals2;
    }
    public   int Get_All_Data_spi( ) {
        int c=0;
        for (int i = 1; i < mList3.length + 1; i++) {
            if (mList3[i] == vsu) {
                c = i;
break;

            }


        }

        return c;
    }



    public   void Get_All_Data_22(String h ) {
    
        ArrayList<String> arrp = new ArrayList<>();
        clsSpinerInforms.clear();
    
        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
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
                    
                    for (int i = 0; i < jsonArray_usersS.length() + 1; i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
    
                        mList_4 = dd_4;
    
                        int idu = responsS.getInt("id");
    
                        String User_name_4 = responsS.getString("name").trim();
    
                        mList_4[i] = User_name_4;
    
                        clsSpinerInforms2.add(new ClsSpinerInform2(idu, User_name_4));
    
                    }
    
    
                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
                ArrayAdapter<String> adapter_4 = new ArrayAdapter<String>(MainActivity_mysqlserver.this, android.R.layout.simple_list_item_1, mList_4);
                adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_4.setAdapter(adapter_4);
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
                params.put("name", h);
    
                return params;
            }
        };
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
    }
    void Get_All_Data_serch(String nameText,String name) {
    
    
    
    


        final RequestQueue queue = Volley.newRequestQueue(this);  StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "getsearch_user.php", new Response.Listener<String>() {
            
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
                
                
                    JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
    
    
    
    
                    spinner_2_2.setAdapter(null);
                    Arrays.fill(mList_2, null);
    
    
                    List<String> mListss=new ArrayList<>();
                    List<String> mListss2=new ArrayList<>();
                    String [] dd=new String[jsonArray_usersS.length()];
                    String [] ddd=new String[jsonArray_usersS.length()];
                    String maness="";
                    int cnam=0;
                    int cn=0;
                    final String[] dd_4 = new String[jsonArray_usersS.length()];
                    for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        int idu= responsS.getInt("id");

                        String User_name = responsS.getString("name").trim();

                        
                        Toast.makeText(MainActivity_mysqlserver.this, User_name+" بنجاح", Toast.LENGTH_SHORT).show();
                        mList_2=dd_4;
                        mList_2[i]=User_name;
    
                      //  String User_name_2 = responsS.getString("name_auth").trim();
                        //clsSpinerInforms2.add(new ClsSpinerInform(idu,"User_name"));
    
                    }



                    queue.stop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
    
    
                final    ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(MainActivity_mysqlserver.this, android.R.layout.simple_list_item_1, mList_2);
                adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    
                if(mList_2==null ){
                    adapter_2.add(null);
                }
                spinner_2_2.setAdapter(adapter_2);
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
                params.put("ToDate", name);
    
                return params;
            }
        };

        queue.add(stringRequest);
        stringRequest.setShouldCache(false);


    }

    public void add_date(View view) {


        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity_mysqlserver.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setLisiner, year, moath, day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();
        setLisiner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = moath + 1;
                String date = day + "/" + month + "/" + year;

                ed_date.setText(date);

            }
        };


    }
    

    public void radioClick(View view) {

        if(view.getId()==R.id.radioButton3)
        {
            types_admin="1";
        }
        else
        {
            types_admin="0";
        }
    }
  
}

