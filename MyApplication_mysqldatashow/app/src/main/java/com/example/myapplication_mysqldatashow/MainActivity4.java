package com.example.myapplication_mysqldatashow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
public static String nameinf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void add_lo(View view) {
        //Toast.makeText(MainActivity4.this, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();

        Intent in=new Intent(MainActivity4.this, MainActivity_mysqlserver.class);

in.putExtra("infromation_user_intent","name1");

        startActivity(in);
    }

    public void add_emp(View view) {

    //    Toast.makeText(MainActivity4.this, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();

        Intent in=new Intent(MainActivity4.this, MainActivity4_drop.class);
       // nameinf="employss";

        nameinf="report";
       // in.putExtra("infromation_user","employss");

        startActivity(in);
    }

    public void add_decoment(View view) {
      //  Toast.makeText(MainActivity4.this, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();

        Intent in=new Intent(MainActivity4.this, MainActivity4_drop.class);
        nameinf="decoment";

       // in.putExtra("infromation_user","decoment");

        startActivity(in);
    }

    public void add_box(View view) {
        Intent in=new Intent(MainActivity4.this, MainActivity4_drop.class);

        nameinf="box";

        startActivity(in);
    }

    public void add_report(View view) {

        Intent in=new Intent(MainActivity4.this, MainActivity4_drop.class);
        nameinf="report";

        //in.putExtra("infromation_user","report");

        startActivity(in);
    }

}