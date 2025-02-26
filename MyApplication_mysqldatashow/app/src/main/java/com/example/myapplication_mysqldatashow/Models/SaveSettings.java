package com.example.myapplication_mysqldatashow.Models;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.myapplication_mysqldatashow.LogIn;

/**
 * Created by hussienalrubaye on 12/17/15.
 */
public class SaveSettings {

    Context context;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs3";
    
    public static   String id_decoment="", UserID = "",TypeUser="",UserID_id="",Sol_end="",Sol_prid="",SolAll="",Count_decoment="",pass="";
    public static String ServerURL="http://selling.alruabye.net/";
    public static   int  Distance;
    public static String  APPURL="com.selling.hussienalrubaye.androidselling";
    public  SaveSettings(Context context) {
        this.context=context;
        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

    }
    public void SaveData()  {

        try

        {

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("pass",String.valueOf(pass));
            editor.putString("id_decoment",String.valueOf(Count_decoment));
    
            editor.putString("UserID",String.valueOf(UserID));
            editor.putString("TypeUser",String.valueOf(TypeUser));
            editor.putString("UserID_id",String.valueOf(UserID_id));
            editor.putString("amount_due",String.valueOf(Sol_end));
            editor.putString("amount_paid",String.valueOf(Sol_prid));
            
            editor.putString("SolAll",String.valueOf(SolAll));
    
    
            editor.putInt("Distance", Distance);
            editor.commit();
            LoadData();
        }

        catch( Exception e){}
    }
    public   void LoadData( ) {

        String TempUserID=sharedpreferences.getString("UserID","empty");
        String TempTypeUser=sharedpreferences.getString("TypeUser","empty");
        
        Distance=sharedpreferences.getInt("Distance",50); // add defaul distance
        if(!(TempUserID.equals("empty" ))) {
            UserID = TempUserID;
            TypeUser=TempTypeUser;
        }
        // load user name
        else {
            
            Intent intent=new Intent(context, LogIn.class);
            context.startActivity(intent);
        }
    }
}
