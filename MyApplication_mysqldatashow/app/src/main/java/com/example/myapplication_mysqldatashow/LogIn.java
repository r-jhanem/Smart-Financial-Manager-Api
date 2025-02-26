package com.example.myapplication_mysqldatashow;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_mysqldatashow.Models.clsDecoment;

public class

LogIn extends AppCompatActivity {
    public static String uri_P = "http://192.168.1.116/test_anroid_mysql_php2/LogIn.php";
    private EditText ETXT_User_Name;
    private SharedPreferences shared_Save;
    private String User_name = "", User_Password = "";
    public String UserType2 ="",UserType="";
    ProgressDialog progressDialog;
    
    private EditText passwordEditText;
    private Button showHideButton;
    private boolean isPressed = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        ETXT_User_Name = findViewById(R.id.ETXT_UserName);
        passwordEditText = findViewById(R.id.ETXT_Pass);
    
    
    /*
        passwordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
             
                        togglePasswordVisibility();
                        //  passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        //   passwordEditText.setText("Text");
                        // تعديل نص الحقل عند الضغط
                        // editText.setText("Pressed");
                       // isPressed = true;
                       
     
    
                }
                return false;
            
    
        });
    */


        
        
    
        passwordEditText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        togglePasswordVisibility();
                    }
                });
    
    
      //  passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    
    
    
    
    
        findViewById(R.id.BTN_LogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    
    
        
                    //postDataUsingVolley(ETXT_User_Name.getText().toString(), ETXTpassword.getText().toString());
                clsDecoment clsDecomen=new clsDecoment(LogIn.this);
                User_name = ETXT_User_Name.getText().toString().trim();
                User_Password = passwordEditText.getText().toString().trim();
    
                clsDecomen. Get_All_Data_Spiner_Login(User_name,User_Password,LogIn.this);
    
             //   FetchDataAsyncTask fetchDataAsyncTask = new FetchDataAsyncTask(User_name, User_Password, LogIn.this);
              //  fetchDataAsyncTask.execute();
               // LogIn();
            }
        });
    }
    
  

    public void add_login(View view) {


      //  Intent in=new Intent(LogIn.this,MainActivity_mysqlserver.class);

        //in.putExtra("infromation_user_intent","Login_add_users_new");
       // startActivity(in);

    }
    @Override
    public void onBackPressed() {
  
            // إغلاق جميع الأنشطة والخروج من التطبيق بالكامل
            finishAffinity();
       

    }
    
    
    private void togglePasswordVisibility() {
        if (isPressed) {
            passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
           // showHideButton.setText("Show");
            isPressed = false;
        } else {
            passwordEditText.setTransformationMethod(null);
            //showHideButton.setText("Hide");
            isPressed = true;
        }
    }
}