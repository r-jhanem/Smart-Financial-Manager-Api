package com.example.myapplication_mysqldatashow;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.Models.SaveSettings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyService extends Service  {
    
  
    public MyService() {
    }
    
    
    public static final String TAG = "DataRequestTag";
    RequestQueue queue;
    // Tag the request
    


  
    @Override
    public void onCreate() {
        super.onCreate();
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    
    
        Get_All_Data_auth();
    return START_STICKY;
    
    }
    
    public void Get_All_Data_auth() {
        
        
        
         RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                  MainActivity4_drop.uri_P_2 + "LogIn.php", new Response.Listener<String>() {
            
            @Override
            public void onResponse(String response) {
                try {
    
    
    
                    
                    
                    
                    
                    JSONArray jsonArray = new JSONArray(response);
                    
                    
                    JSONObject jsonResponse = jsonArray.getJSONObject(0);
    
            
                        JSONArray jsonArray_usersS = jsonResponse.getJSONArray("Users_Data");
    
                        final String[] dd_4 = new String[jsonArray_usersS.length()];
                        //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                        List<String> mListss = new ArrayList<>();
                        List<String> mListss2 = new ArrayList<>();
    
    
                        String maness = "";
                        int cnam = 0;
                        int cn = 0;
    
    
                        if (jsonArray_usersS.length() > 0) {
                            for (int i = 0; i < 1; i++) {
                                JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                                String CountDecoment = responsS.getString("CountDecoment").trim();
            
            
                                String User_name_id = responsS.getString("id").trim();
                                int idu = Integer.parseInt(CountDecoment);
                                int id_d = Integer.parseInt(MainActivity4_drop.id_decoment);
            
            
                                // String User_name_4 = responsS.getString("name").trim();
            
            
                                //  int c = Integer.parseInt(CountDecoment);
                                if (idu > id_d) {
                
                                    SharedPreferences sharedpreferences;
                
                                    sharedpreferences = MyService.this.getSharedPreferences(SaveSettings.MyPREFERENCES, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                
                                    editor.putString("id_decoment", String.valueOf(CountDecoment));
                                    editor.commit();
                
                                    SaveSettings.Count_decoment = CountDecoment;
                
                                    MainActivity4_drop.id_decoment = CountDecoment;
                                    String channelId = "my_channel_id";


// إنشاء قناة الإشعارات (للإصدارات الأحدث من Android فقط)
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        CharSequence channelName = "My Channel";
                                        String channelDescription = "Description of my channel";
                                        int importance = NotificationManager.IMPORTANCE_HIGH;
                    
                                        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
                                        notificationChannel.setDescription(channelDescription);
                    
                                        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                        notificationManager.createNotificationChannel(notificationChannel);
                                    }

// إنشاء Intent لفتح التطبيق عند النقر على الإشعار
                                    Intent intent = new Intent(MyService.this, MainActivity4_drop.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    PendingIntent pendingIntent = PendingIntent.getActivity(MyService.this, 0, intent, 0);

// إنشاء المنشئ للإشعار وتعيين الخصائص المطلوبة
                                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId)
                                              .setSmallIcon(R.drawable.ic_baseline_receipt_lg_24)
                                              .setContentTitle("السند الإلكتروني")
                                              .setContentText("رسالة جديدة")
                                              .setPriority(NotificationCompat.PRIORITY_MAX) // تعيين أعلى أولوية ممكنة
                                              .setAutoCancel(true)
                                              .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                              .setContentIntent(pendingIntent)
                                              .setTimeoutAfter(5000); // تعيين وقت محدد لظهور الإشعار (5 ثوانٍ)

// بناء الإشعار وعرضه
                                    Notification notification = builder.build();
                                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                
                                    notificationManager.cancel(1);
                                    notificationManager.notify(1, notification);
                
                                }
                            }
                        }
                   
                    queue.stop();
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                
                
                
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            
            }
           
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", MainActivity4_drop.TempUserID);
                params.put("phone", MainActivity4_drop.pass);
    
    
            
                return params;
            }
        };
       stringRequest.setTag(TAG);
    
        queue.add(stringRequest);
    
    
    
        Handler handler = new Handler();
       handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                
                
                if (queue != null) {
                    queue.cancelAll(TAG);
                    
                }
                
                
                 
                    Get_All_Data_auth();
             
                
            }
        }, 29000);
    
       
      
    }
    


    
    @Override
    
    public  void onDestroy()
          
          {
              Toast.makeText(MyService .this, "stop sirvices", Toast.LENGTH_SHORT).show();
    super.onDestroy();
          }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
 
}