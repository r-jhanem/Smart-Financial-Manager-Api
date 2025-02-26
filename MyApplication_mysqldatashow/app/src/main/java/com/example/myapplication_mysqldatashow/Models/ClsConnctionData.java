package com.example.myapplication_mysqldatashow.Models;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ClsConnctionData {
    
    
    
    public static boolean isConnectingToInternet(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            
            return isConnected;
            
            
        }
        return false;
    }
    
    public static void isConnectingToInternet_2(Context context){
       // NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.Type_);
    
    
        //NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
       // NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        ConnectivityManager connMgr = (ConnectivityManager)
              context.
              getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
 if(networkInfo != null && networkInfo.isConnected()) {
       // Toast connectedToast = Toast.makeText(context,
               //   "Network connected!", Toast.LENGTH_SHORT);
     
     String k="kk";
        //connectedToast.show();
    } else {
        Toast disconnectedToast = Toast.makeText(context,
                  "تاكد من الاتصال بالانترنت", Toast.LENGTH_SHORT);
        disconnectedToast.show();
    }}

}
