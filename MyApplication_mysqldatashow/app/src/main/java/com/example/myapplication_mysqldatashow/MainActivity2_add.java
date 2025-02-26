package com.example.myapplication_mysqldatashow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2_add extends AppCompatActivity {
    public EditText ed_name,ed_email,ed_,ed_leve,ed_phon;


    private static final String url1="http://192.168.1.116/android_db_pool/db_insert.php";
    Button butt_1,butt_2,butt_3,butt_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
    
      
        // إنشاء خيط جديد لتنفيذ عملية التحقق بشكل دوري
        //  Thread dbCheckerThread = new Thread(new HomeFragment.MyDatabaseChecker(MainActivity4_drop.this));
        // dbCheckerThread.start(); // تشغيل الخيط
        //SaveSettings saveSettings=new SaveSettings(this);
        //  saveSettings.LoadData();
        //  saveSettings.LoadData();
    
    
        ed_name=findViewById(R.id.editTextTextPersonName_name);

        // ed_name=findViewById(R.id.editTextTextPersonName_name);
        Button but=(Button)findViewById(R.id.button2_op) ;
        Button but2=(Button)findViewById(R.id.button_op2) ;
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=ed_phon.getText().toString().trim();
                final String uname=ed_name.getText().toString().trim();
                final String pwd=ed_leve.getText().toString().trim();
                //Send_Data_Registration se=new Send_Data_Registration(name,uname,pwd,);

            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  setContentView(R.layout.activity_main_open);


            }
        });

    }


}