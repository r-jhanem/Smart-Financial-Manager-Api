package com.example.myapplication_mysqldatashow;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.myapplication_mysqldatashow.Models.clsDecomentPropertis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Salim3DD on 11/5/2020.
 */
public class Send_Data_Registration extends StringRequest {

    private static final String SEND_DATA_URL = MainActivity4_drop.uri_P_2+"insert_decoment.php";
    private Map<String, String> MapData;
    clsDecomentPropertis bn=new clsDecomentPropertis();
    
    public Send_Data_Registration(
            String TypeOpration,

            String UserName,
            String UserEmail,
            String UserPassWord,

            Response.Listener<String> listener)
    {

        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();
        MapData.put("TypOpration", TypeOpration);
        MapData.put("date", UserName);

        MapData.put("Sol", UserEmail);
        MapData.put("gresr", UserPassWord);


    }
   

    public Send_Data_Registration(
            String TypeOpration,
            String name,
            String date,

            String Sol,

            String   gresr,

            String types_admin,

            Response.Listener<String> listener)


    {

        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();
        MapData.put("TypOpration", TypeOpration);
        MapData.put("User_name", name);

        MapData.put("date", date);
        MapData.put("Sol", Sol);

        MapData.put("gresr", gresr);
        MapData.put("types_admin", types_admin);


    }


    public Send_Data_Registration(
            String TypeOpration,
            String nameAto,

            String name,
            String date,
            String Phone,


            String   gresr,
            String Sol,

            String types_admin,

            Response.Listener<String> listener)


    {

        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();

        MapData.put("TypOpration", TypeOpration);
        MapData.put("nameAto", nameAto);

        MapData.put("User_name", name);
        MapData.put("date", date);


        MapData.put("Phone", Phone);

        MapData.put("gresr", gresr);

        MapData.put("Sol", Sol);

        MapData.put("types_admin", types_admin);


    }




    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}

