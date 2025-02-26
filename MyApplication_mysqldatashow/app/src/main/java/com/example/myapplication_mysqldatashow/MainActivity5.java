package com.example.myapplication_mysqldatashow;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_mysqldatashow.Models.ClsEmplayyContros;
import com.example.myapplication_mysqldatashow.Models.ClsEmpleyy;

public class MainActivity5 extends AppCompatActivity {
    public EditText ed_auot,ed_branchess_name,ed_box_name,ed_name,ed_date,ed_sol,ed_phon,ed_gresr,max_sol;
    SharedPreferences sharedpreferences;
    String MyPREFERENCES="fileUser";
    ClsEmpleyy clsEmpleyy=new ClsEmpleyy();
    
    String UserKey2,option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        
        sharedpreferences  =MainActivity5.this.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    
    
        String TempUserID=sharedpreferences.getString("User_name","empty");
        String TempTypeUser=sharedpreferences.getString("RegDate","empty");
         option=sharedpreferences.getString("option","empty");
        
    
    
        String TempUserID2=sharedpreferences.getString("Sol","empty");
         UserKey2=sharedpreferences.getString("UserKey2","empty");
         
         
         
    
        ed_name=findViewById(R.id.editTextTextPersonName_name);
        ed_date=findViewById(R.id.editTextTextPersonName_date);
        ed_phon=findViewById(R.id.editTextTextPersonName4_phone);
        ed_gresr=findViewById(R.id.editTextTextPersonName_grest);
        ed_sol=findViewById(R.id.editTextTextPersonName6_sol);
        max_sol=findViewById(R.id.editTextTextPersonName6_so_2);
        
        
          ed_name.setText(TempUserID);
    
        ed_date.setText(TempTypeUser);
        ed_gresr.setText(UserKey2);
        ed_sol.setText(TempUserID2);
         ed_phon.setText("78");
        
        
        
        final String date = ed_date.getText().toString().trim();
        final String gresr = ed_gresr.getText().toString().trim();
        final String sol = ed_sol.getText().toString().trim();
    
    }
    
    public void radioClick(View view) {
    }
    
    public void add_date(View view) {
    
    
        
    
    
    
    }
    
    public void Update_onclik(View view) {
    
        switch (option)
        {
            case "updateuser":
            {
    
                final String name = ed_name.getText().toString().trim();
                final String phone = ed_phon.getText().toString().trim();
                final String date = ed_date.getText().toString().trim();
                final String gresr = ed_gresr.getText().toString().trim();
                final String sol = ed_sol.getText().toString().trim();
    
    
    
                // final String auot_name_2 =  String.valueOf(clsSpinerInforms.get(spinner_3.getSelectedItemPosition()).Id);
    
                Toast.makeText(this, "enter :"+UserKey2, Toast.LENGTH_SHORT).show();
    
    
                final String typadmin ="9";
                clsEmpleyy.setNameAuthor(UserKey2);
                clsEmpleyy.setUser_name(name);
                clsEmpleyy.setPhoneUser(phone);
                clsEmpleyy.setDate(date);
                clsEmpleyy.setDetails(gresr);
                clsEmpleyy.setPassowrds(sol);
                clsEmpleyy.setType(typadmin);
    
                ClsEmplayyContros empleyy=new ClsEmplayyContros(MainActivity5.this);
                empleyy.update(clsEmpleyy);
                
                break;
            }
    
            case "UpatePassword":
            {
        
                final String name = ed_name.getText().toString().trim();
                final String phone = ed_phon.getText().toString().trim();
                final String date = ed_date.getText().toString().trim();
                final String gresr = ed_gresr.getText().toString().trim();
                final String sol = ed_sol.getText().toString().trim();
        
        
        
                // final String auot_name_2 =  String.valueOf(clsSpinerInforms.get(spinner_3.getSelectedItemPosition()).Id);
        
        
        
                final String typadmin ="9";
                clsEmpleyy.setNameAuthor(UserKey2);
                clsEmpleyy.setUser_name(name);
                clsEmpleyy.setPhoneUser(phone);
                clsEmpleyy.setDate(date);
                clsEmpleyy.setDetails(gresr);
                clsEmpleyy.setPassowrds(sol);
                clsEmpleyy.setType(typadmin);
        
                ClsEmplayyContros empleyy=new ClsEmplayyContros(MainActivity5.this);
                empleyy.update(clsEmpleyy);
        
                break;
            }
            case "delete": {
                ClsEmplayyContros empleyy2 = new ClsEmplayyContros(MainActivity5.this);
                empleyy2.delete(UserKey2);
            }
               break;
        }}
    
    
    
}