package com.example.myapplication_mysqldatashow;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.Models.ClsEmplayyContros;
import com.example.myapplication_mysqldatashow.Models.ClsEmpleyy;
import com.example.myapplication_mysqldatashow.Models.clsDecoment;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static com.example.myapplication_mysqldatashow.R.drawable;
import static com.example.myapplication_mysqldatashow.R.id;
import static com.example.myapplication_mysqldatashow.R.layout;
import static com.example.myapplication_mysqldatashow.R.menu;


public class ListAdapter extends BaseAdapter {
    
   public String Count_user="";
    
    int idname;
    private SharedPreferences shared_Save;
    
    SharedPreferences sharedpreferences;
    
    String MyPREFERENCES="fileUser";
    
    
    String User_name,User_name_doof;
    
    String bgg;
    public static String uri5= "http://192.168.1.116test_anroid_mysql_php/2UpdateUserProfile.php";


    TextView Text_types;
    Bitmap bitmap, scaleBitmap;
    int pageWidth = 1200;
    static  int pageWid = 1,pageWid_2;
    String      State;
    Date dateTime;
    Button bb;
    DateFormat dateFormat;
    public static TextView namey,ImgAvatar;
    public static String tyyyps;
    public ImageView ImgAvata;
    String bo="";
    private RecyclerView recyclerView;
    ListView listView;


    private static ArrayList<List_All_Users> mList;
    private RecyclerView.LayoutManager mLayoutManager;


    private String WordSearch = "";
       // ArrayList<List_All_Users> listclass1=new ArrayList<List_All_Users>();
    List<List_All_Users> listclass1=new ArrayList<List_All_Users>();
    
    private Context context;
    private Object triangledown;

    public ListAdapter(Context context, ArrayList<List_All_Users> listclass1){
        this.listclass1=listclass1;


                this.context = context;
            }
    public ListAdapter(Context context, List<List_All_Users> listclass1){
        this.listclass1=listclass1;
        
        
        this.context = context;
    }


        @Override
        public int getCount() {
        // TODO Auto-generated method stub
        return listclass1.size();

    }
        @Override
        public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listclass1.get(arg0).User_name ;
    }
        @Override
        public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

           idname=listclass1.get(arg0).idname;
            int idname_2=listclass1.get(arg0).idname_2;

        User_name= listclass1.get(arg0).User_name;
    
            String User_name_in= listclass1.get(arg0).User_name;
    
    
            User_name_doof= listclass1.get(arg0).doof;
        
         String RegDate= listclass1.get(arg0).RegDate;
           String PhoneUser= listclass1.get(arg0).PhoneUser;
           String Details= listclass1.get(arg0).Details;

          String Avatar_img;

          String Sol= listclass1.get(arg0).Sol;
          String Sum_sol= listclass1.get(arg0).sum_sol;
         String UserKey2= listclass1.get(arg0).UserKey2;
         String     Type_opation= listclass1.get(arg0).type;
                   State= listclass1.get(arg0).state;
    
            String Stata_2= listclass1.get(arg0).state;
    
            String Count_Name= listclass1.get(arg0).Count_Name;
             String Max_Sol= listclass1.get(arg0).Max_Sol;
    
            sharedpreferences  =context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


         //   All_Users_list N=new All_Users_list();
            TextView Text_UserName_2;
            TextView Email_2;

        TextView Text_UserName,Text_RegDate_4;
        TextView Text_sol;
        TextView Text_DateTime_All_Users;
        ImageView imageView_0;
        // TODO Auto-generated method stub
        Button but_show;
            LayoutInflater inf = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);


        View view=	inf.inflate(layout.row_item_all_users, null);
        CardView Row_Card_View;

ImageButton image_botton_show=view.findViewById(id.imageButton_count);

        Row_Card_View = view.findViewById(id.cardView_All_Users);
        ImgAvatar = view.findViewById(id.Img_Avatar);
            imageView_0 = view.findViewById(id.imageView2);
         ImgAvata = view.findViewById(id.img_Avata);
           // ImageView ImgAvat = view.findViewById(R.id.Img_Avat);
            Text_UserName = view.findViewById(id.Text_UserNam);
            Text_RegDate_4 = view.findViewById(id.Text_RegDate_4);
            Text_UserName_2 = view.findViewById(id.Text_UserNam_2);
            Email_2= view.findViewById(id.Text_Email_2);
        Text_sol = view.findViewById(id.Text_Email);
        Text_DateTime_All_Users = view.findViewById(id.Text_RegDate);
        Text_types = view.findViewById(id.textView5_styte);
        Button printim=view.findViewById(id.imageButton_print);

          //  Text_DateTime_All_Users.setBackgroundResource(drawable.ic_baseline_done_24);

               //  Toast.makeText(context, "ent id:"+N.xcolor, Toast.LENGTH_SHORT).show();

                //final TextView name=(TextView) view.findViewById(R.id.textView_name);
        int rp=0;
        //ImageView imag=(ImageView)view.findViewById(R.id.imageView_imag);




            if(idname==1)
            {
                
                
                ImgAvata.setVisibility(View.GONE);
    
             //   ImgAvata.setBackgroundResource(drawable.abc_edit_text_material);
                imageView_0.setImageResource(drawable.ic_baseline_edit_2_45);
    
    
                Text_UserName.setText(User_name);
                //Text_sol.setText(Count_Name);

                ImgAvatar.setText(RegDate);
                Text_DateTime_All_Users.setText(Sol);
    
                if (MainActivity4_drop.TempTypeUser.equals("0")) {
    
                    imageView_0.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
            
                            Toast.makeText(context, "id:" + Sol, Toast.LENGTH_LONG).show();
            
            
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setTitle(" تعديل معلومات الحساب");

// إنشاء حاوية لعرض تخطيط الحوار
                            LinearLayout layout = new LinearLayout(context);
                            layout.setOrientation(LinearLayout.VERTICAL);

// إضافة حقل النص للاسم
                            EditText nameEditText = new EditText(context);
                            nameEditText.setHint("الاسم");
                            nameEditText.setText(User_name_in);
                            layout.addView(nameEditText);

// إضافة حقل النص لرقم الهاتف
                            EditText phoneEditText = new EditText(context);
                            phoneEditText.setHint("رقم الهاتف");
            
                            phoneEditText.setText(RegDate);
            
                            layout.addView(phoneEditText);

// تعيين تخطيط للحاوية في المربع الحواري
                            builder.setView(layout);

// إضافة زر "حفظ" إلى المربع الحواري
                            builder.setPositiveButton("حفظ", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
    
                                    String n = nameEditText.getText().toString();
                                    String p = phoneEditText.getText().toString();
    
    
                                    // final String auot_name_2 =  String.valueOf(clsSpinerInforms.get(spinner_3.getSelectedItemPosition()).Id);
                                    ClsEmpleyy clsEmpleyy = new ClsEmpleyy();
    
                                    ClsEmplayyContros.typ_opion="updateUser";
                                    final String typadmin = "9";
                                    clsEmpleyy.setNameAuthor(UserKey2);
                                    clsEmpleyy.setUser_name(n);
                                    clsEmpleyy.setPhoneUser(p);
                                    clsEmpleyy.setDate("date");
                                    clsEmpleyy.setDetails("gresr");
                                    clsEmpleyy.setPassowrds("sol");
                                    clsEmpleyy.setType("typadmin");
    
                                    ClsEmplayyContros empleyy = new ClsEmplayyContros(context);
                                    empleyy.update(clsEmpleyy);
    
                                    // قم بتنفيذ الإجراء المطلوب عند النقر على زر "حفظ"
                                }
                            });

// إضافة زر "إلغاء" إلى المربع الحواري
                            builder.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

// عرض المربع الحوار
                            AlertDialog dialog = builder.create();
                            dialog.show();
            
                        }
        
        
                    });
    
                }
            }
            
            
    
            if(idname==12) {
        
                Count_user="ahmed";
        
                if(State.contains("معلق"))
                {
                    pageWid_2=1;
                    Text_types.setBackgroundResource(drawable.ic_baseline_remove_circle_24);
                    // State="معلق";
            
                }
                else  if(State.contains("مغلي"))
        
                {
                    pageWid_2=0;
            
            
                    Text_types.setBackgroundResource(drawable.ic_baseline_cancel_24);
            
            
            
                    // State="مغلي";
            
                }
                else  if(State.contains("جاهز"))
                {
                    pageWid_2=0;
            
                    //Text_types.setBackgroundResource(drawable);
                    Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);
            
                    // Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);                    State="معلق";
            
                    // State = "جاهز";
            
            
                }
                if(Type_opation.contains("له"))
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_up_24);
                }
                else
        
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_down_24);
                }
    
                Text_UserName.setText(User_name_doof);
    
                Text_UserName_2 .setText(RegDate);
        
                // Text_types.setBackgroundResource();
        
                //Text_sol.setText(Count_Name);
                //  Text_types.setText();
                //ImgAvatar.setText(RegDate);
                // Text_DateTime_All_Users.setText(Sol);
                // Text_sol.setText(Type_opation);
                //  ImgAvatar.setText(Count_Name);
                Text_DateTime_All_Users.setText(Sol);
        
                // Text_types.setText(State);
                ImgAvatar.setText( User_name);
        
        
            }
            if(idname==15) {
    
    
                Text_UserName.setVisibility(View.GONE);
                Text_UserName_2.setVisibility(View.GONE);
    
    
                // Text_types.setBackgroundResource();
    
                //Text_sol.setText(Count_Name);
                //  Text_types.setText();
                //ImgAvatar.setText(RegDate);
                // Text_DateTime_All_Users.setText(Sol);
                // Text_sol.setText(Type_opation);
                //  ImgAvatar.setText(Count_Name);
              //  Text_DateTime_All_Users.setText(Sol);
    
                // Text_types.setText(State);
               // ImgAvatar.setText( User_name);
                //Text_DateTime_All_Users.setText(Sol);
                Text_DateTime_All_Users.setVisibility(View.GONE);
    
                // Text_types.setText(State);
                ImgAvatar.setText( User_name);
                ImgAvata.setVisibility(View.GONE);
                imageView_0.setVisibility(View.GONE);
            }
        
                if(idname==3) {
    
                Count_user="ahmed";
    
                if(State.contains("معلق"))
                {
                    pageWid_2=1;
                    Text_types.setBackgroundResource(drawable.ic_baseline_remove_circle_24);
                 // State="معلق";
        
                }
                else  if(State.contains("مغلي"))
    
                {
                    pageWid_2=0;
    
    
                    Text_types.setBackgroundResource(drawable.ic_baseline_cancel_24);
                    
        
        
                  // State="مغلي";
        
                }
                else  if(State.contains("جاهز"))
                {
                    pageWid_2=0;
    
                    //Text_types.setBackgroundResource(drawable);
                    Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);
        
                    // Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);                    State="معلق";
        
                   // State = "جاهز";
        
        
                }
                if(Type_opation.contains("له"))
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_up_24);
                }
                else
    
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_down_24);
                }
    
                // Text_types.setBackgroundResource();
                Text_UserName.setText(User_name_doof);
                    Text_UserName_2.setText(RegDate);
    
    
                //Text_sol.setText(Count_Name);
              //  Text_types.setText();
                //ImgAvatar.setText(RegDate);
                // Text_DateTime_All_Users.setText(Sol);
                // Text_sol.setText(Type_opation);
              //  ImgAvatar.setText(Count_Name);
                
                
                Text_DateTime_All_Users.setText(Sol);
    
                // Text_types.setText(State);
                ImgAvatar.setText(User_name);
    
    
            }
    
            if(idname==10)
            {
    
                imageView_0.setVisibility(View.GONE);
    
                if(State.contains("معلق"))
                {
                    Text_types.setBackgroundResource(drawable.ic_baseline_remove_circle_24);
                    //   State="معلق";
        
                }
                else  if(State.contains("مغلي"))
    
                {
        
                    Text_types.setBackgroundResource(drawable.ic_baseline_cancel_24);
        
        
        
                    // State="مغلي";
        
                }
                else  if(State.contains("جاهز"))
                {
                    //Text_types.setBackgroundResource(drawable);
                    Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);                    State="معلق";
        
                    // Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);                    State="معلق";
        
                    // State = "جاهز";
        
        
                }
                if(Type_opation.contains("له"))
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_up_24);
    
                    
                }
                else
    
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_down_24);
                }
                Text_RegDate_4.setVisibility(View.VISIBLE);
                ImgAvata.setVisibility(View.GONE);
               // imageView_0.sette(User_name);
                // Text_types.setBackgroundResource();
              //  Text_UserName.setVisibility(View.GONE);
                Text_UserName_2.setText(UserKey2);
                //Text_sol.setText(Count_Name);
                Text_types.setText(RegDate);
                //ImgAvatar.setText(RegDate);
                Text_DateTime_All_Users.setText(Sol);
                // Text_sol.setText(Type_opation);
             //   ImgAvatar.setText(Type_opation);
    
               // imageView_0.setText(Sol);
                Text_RegDate_4.setText(User_name);
    
    
                // Text_types.setText(State);
    
    
    
            }
                if(idname==5)
            {
    
                Count_user="raad";
    
                if(State.contains("معلق"))
                {
                    Text_types.setBackgroundResource(drawable.ic_baseline_remove_circle_24);
                 //   State="معلق";
        
                }
                else  if(State.contains("مغلي"))
    
                {
        
                    Text_types.setBackgroundResource(drawable.ic_baseline_cancel_24);
                    
        
        
                    // State="مغلي";
        
                }
                else  if(State.contains("جاهز"))
                {
                    //Text_types.setBackgroundResource(drawable);
                     Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);                    State="معلق";
    
                    // Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);                    State="معلق";
        
                   // State = "جاهز";
        
        
                }
                if(Type_opation.contains("له"))
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_up_24);
                }
                else

                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_down_24);
                }
    
               // Text_types.setBackgroundResource();
                Email_2.setBackgroundResource(drawable.ic_baseline_add_24_2);
    
                Text_types.setBackgroundResource(drawable.ic_baseline_brightness_1_24);
                Text_UserName.setText(User_name);
                //Text_sol.setText(Count_Name);
                Text_types.setText(RegDate);
                Text_types.setTextColor(Color.WHITE);
    
                //ImgAvatar.setText(RegDate);
               // Text_DateTime_All_Users.setText(Sol);
               // Text_sol.setText(Type_opation);
                ImgAvatar.setText(Count_Name);
                Text_DateTime_All_Users.setText(Sol);

               // Text_types.setText(State);
    
    
                
    
    
    
                Text_types.setOnClickListener(new
                                                           View.OnClickListener() {
                                                               @Override
                                                               public void onClick(View v) {
    
                                                                   IfPrintReport cl = new IfPrintReport(context);
    
                                                                   pageWid++;
                                                                   //  bb.setVisibility(View.GONE);
                                                                   //ImgAvatar.setVisibility(View.GONE);
    
    
                                                                   cl.Sol_user = Sol;
                                                                   cl.ed_Sol_user = UserKey2;
                                                                   cl.pi_Sol_user = Stata_2;
    
                                                                   Intent in2=new Intent(context,All_Users_list.class);
                      
                                                                   in2.putExtra("infromation_user_intent", "empl_one");
                      
                                                                   in2.putExtra("name",Text_UserName.getText().toString());
                      
                                                                   //All_Users_list N=new All_Users_list();
                      
                      
                                                                   //N.Get_All_Data_serch_one(Text_UserName.getText().toString());
                                                                   context.startActivity(in2);
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                                                                   //      SharedPreferences.Editor editor = shared_Save.edit();
                                                                   //    editor.putString("Local_UserKey", UserKey.trim());
                                                                   //editor.putString("Local_UserName", User_name.trim());
                                                                   //  editor.putString("Local_Email", Email.trim());
                                                                   //  editor.putString("Local_PassWord", User_Password.trim());
                                                                   //     editor.putString("Local_UserAvatar",  Avatar_img.trim());
                                                                   //editor.apply();
                      
                                                               }
                                                           });
                Text_UserName.setOnClickListener(new
                                                           View.OnClickListener() {
                                                               @Override
                                                               public void onClick(View v) {
                                                                   IfPrintReport cl = new IfPrintReport(context);
    
    
                                                                   cl.Sol_user = Sol;
                                                                   cl.ed_Sol_user = UserKey2;
                                                                   cl.pi_Sol_user = Stata_2;
    
                                                                   pageWid++;
                                                                   //  bb.setVisibility(View.GONE);
                                                                   //ImgAvatar.setVisibility(View.GONE);
                                                                   Intent in2=new Intent(context,All_Users_list.class);
    
                                                                   in2.putExtra("infromation_user_intent", "empl_one");
    
                                                                   in2.putExtra("name",Text_UserName.getText().toString());
    
                                                                   //All_Users_list N=new All_Users_list();
                      
                      
                                                                   //N.Get_All_Data_serch_one(Text_UserName.getText().toString());
                                                                   context.startActivity(in2);
    
                                                                   
    
    
    
    
    
                                                                   
    
    
                                                                   
                      
                                                                   //      SharedPreferences.Editor editor = shared_Save.edit();
                                                                   //    editor.putString("Local_UserKey", UserKey.trim());
                                                                   //editor.putString("Local_UserName", User_name.trim());
                                                                   //  editor.putString("Local_Email", Email.trim());
                                                                   //  editor.putString("Local_PassWord", User_Password.trim());
                                                                   //     editor.putString("Local_UserAvatar",  Avatar_img.trim());
                                                                   //editor.apply();
                      
                                                               }
                                                           });
                
            }
            if(idname==4) {
                Count_user="ahmed";
                if(State.contains("معلق"))
                {
                    pageWid_2=1;
                    Text_types.setBackgroundResource(drawable.ic_baseline_remove_circle_24);
                    State="معلق";

                }
                else  if(State.contains("مغلي"))

                {

                    Text_types.setBackgroundResource(drawable.ic_baseline_cancel_24);
                    State="مغلي";


                   // State="مغلي";

                }
                else {
                    Text_types.setBackgroundResource(drawable.ic_baseline_cancel_24);

                   // Text_types.setBackgroundResource(drawable.ic_baseline_check_circle_24);                    State="معلق";

                    State = "جاهز";


                }
                if(Type_opation.contains("له"))
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_up_24);
                }
                else
                {
                    imageView_0.setImageResource(drawable.ic_baseline_arrow_drop_down_24);
                }
          Text_UserName.setText(User_name);
                //Text_sol.setText(Count_Name);
                Text_types.setText(RegDate);
    
                ImgAvatar.setText(Count_Name);
                Text_DateTime_All_Users.setText(Sol);
               // Text_sol.setText(Type_opation);
               // Text_types.setText(State);

            }
idname=0;

                //idname = listclass1.get(arg0).idname;


                //bgg = listclass1.get(arg0).UserKey2;
                // Sum_sol = listclass1.get(arg0).Details;
            if(rp==988)
            {
 Text_UserName.setText(Details);
                Text_sol.setText(Sol);
                Text_DateTime_All_Users.setText(RegDate);


                String hjd = listclass1.get(arg0).Avatar_img;
                String hj = listclass1.get(arg0).UserKey2;

                Text_types.setText(Type_opation);
            }
    
    
    if(MainActivity4_drop.TempTypeUser.equals("0")) {
        Email_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity4_drop.TempTypeUser.equals("0")) {
    
                    Intent in = new Intent(context, MainActivity_mysqlserver.class);
                    in.putExtra("infromation_user_intent", "decoment");
                    in.putExtra("Text_UserName", Text_UserName.getText().toString());
                    in.putExtra("Text_yemen", "yemen");
                    context.startActivity(in);
    
                }
            }
        });
    }
          
                      image_botton_show.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              int sumsal = 0, yg = 0, xj = 0;
        
        
                              xj = Integer.parseInt(Sol);
                              yg = Integer.parseInt(Sum_sol);
                              sumsal = yg - xj;
                              String vsum = String.valueOf(sumsal);
                              Intent in = new Intent(context, MainActivity_Reprts.class);
                              in.putExtra("find_user", "find_user");
                              in.putExtra("UserKey2", UserKey2);
                              in.putExtra("Sum_sol", vsum);
                              // context.startActivity(in);
        
                              insertdata_update(UserKey2, vsum);
                              //int sumsal = 0;
                              //Toast.makeText(context, "id:" + hj+"  " +hjd, Toast.LENGTH_LONG).show();
        
                              //Toast.makeText(context, "id:" +Sum_sol +" "+Sol, Toast.LENGTH_LONG).show();
                              // All_Users_list N=new All_Users_list();
        
        
                              //  context.startActivity(UserKey2, vsum);
        
        
                              //sumsal = 0;
        
                              // Intent in=new Intent(All_Users_list.this,All_Users_list.class);
        
        
                              // startActivity(in);
        
                          }
                      });


           // else
                //bb.setVisibility(View.GONE);
                // ImgAvatar.setVisibility(View.GONE);
            //  ImgAvata.setImageResource(R.drawable.triangleup);


            String finalSum_sol1 = Sum_sol;
            printim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(context,MainActivity_Reprts.class);
                in.putExtra("find_user","find_user");
                in.putExtra("raad",Text_UserName.getText().toString());
                in.putExtra("raad3",Text_DateTime_All_Users.getText().toString());

                in.putExtra("sol",Text_sol.getText().toString());
                in.putExtra("sumsol", finalSum_sol1);
               context. startActivity(in);
            }
        });
        
        
        bb=view.findViewById(id.button3_oktyp);

        String button=bb.getText().toString();
            String finalSum_sol = Sum_sol;
            bb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


               // all_users_list.insertdata_update_enter(bgg);


            int xj = Integer.parseInt(Text_sol.getText().toString());
            int yg = Integer.parseInt(finalSum_sol);
            int sumsal = yg - xj;
            String vsum = String.valueOf(sumsal);



           // insertdata_update(bgg, vsum);
          //  Toast.makeText(getApplicationContext(), "id:" + vsum, Toast.LENGTH_LONG).show();

            sumsal = 0;

            // Intent in=new Intent(All_Users_list.this,All_Users_list.class);


            // startActivity(in);

            }
        });

//String namedelete=String.valueOf(iduser);
        // id.setText(String.valueOf(listclass1.get(arg0).id));

        // imag.setImageResource(listclass1.get(arg0).imag);
        //  name.setText(listclass1.get(arg0).name);
        
        ImgAvata.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View arg0) {
                //   Toast.makeText(getApplicationContext(), "goodbiy"+x, 4000).show();
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                         @Override
                                                         public boolean onMenuItemClick(MenuItem item) {
                                                             switch (item.getItemId()) {
                                                                 case id.print: {
    
    
                                                                     IfPrintReport.Sol_user = Sol;
                                                                     IfPrintReport.ed_Sol_user = UserKey2;
                                                                     IfPrintReport.pi_Sol_user = Stata_2;
                                                                     IfPrintReport cl =new IfPrintReport(context);
                                                                     
                                                                     if (Count_user.equals("raad")) {
        
        
                                                                   
        
                                                                         cl.Get_All_Data_Spiner_print("get_print_deoment", Text_UserName.getText().toString(), UserKey2,
                                                                                  "uu", context);
                                                                     
                                                                         break;
        
                                                                     } else {
        
        
                                                                         //  cl.Get_All_Data("k","o");
        
        
                                                                         if (Stata_2.contains("معلق")) {
            
                                                                             cl.Sol_user_date = ImgAvatar.getText().toString();
                                                                             Toast.makeText(context, " :"+ImgAvatar.getText().toString(), Toast.LENGTH_SHORT).show();
    
                                                                             cl.Get_All_Data_Spiner_print_one("سند صرف", UserKey2, Sol, Text_UserName.getText().toString(), context);
            
            
                                                                             //   cl.PrinReportOne("سند صرف",HomeFragment.namees19, Sol, User_name);
                                                                         } else {
    
                                                                             cl.Sol_user_date = ImgAvatar.getText().toString();
                                                                             cl.Get_All_Data_Spiner_print_one("سند قبض", UserKey2, Sol, Text_UserName.getText().toString(), context);
            
                                                                             //cl.PrinReportOne("سند قبض", HomeFragment.namees19, Sol, User_name);
            
            
                                                                         }
                                                                     }
                                                                     //cl.Get_All_Data("u","8");
                                                                     return true;
                                                                 }
                                                                 case id.updateuser: {
    
    
                                                                     SharedPreferences.Editor editor = sharedpreferences.edit();
                                                                     editor.putString("User_name", User_name);
                                                                     editor.putString("RegDate", RegDate);
                                                                     editor.putString("option", "updateuser");
    
                                                                     editor.putString("Sol", Sol);
                                                                     editor.putString("UserKey2", User_name_doof);
                                                                     editor.commit();
                                                                     Intent in = new Intent(context, MainActivity5.class);
    
    
                                                                     context.startActivity(in);
                                                                     return true;
    
    
                                                                 }
                                                                 case id.detiles: {
    
    
                                                                     AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                                                     builder.setTitle(" تعديل معلومات الحساب");

// إنشاء حاوية لعرض تخطيط الحوار
                                                                     LinearLayout layout = new LinearLayout(context);
                                                                     layout.setOrientation(LinearLayout.VERTICAL);

// إضافة حقل النص للاسم
    
    
                                                                     TextView nameEditText = new TextView(context);
                                                                     nameEditText.setHint("الاسم");
                                                                     layout.addView(nameEditText);
    
                                                                     EditText nameEditText_2 = new EditText(context);
                                                                     nameEditText_2.setHint("الاسم");
                                                                     nameEditText_2.setEnabled(false);
    
                                                                     nameEditText_2.setText(User_name_in);
                                                                     layout.addView(nameEditText_2);

// إضافة حقل النص لرقم الهاتف
    
                                                                     TextView nameEditText_3 = new TextView(context);
                                                                     nameEditText_3.setHint("له");
                                                                     layout.addView(nameEditText_3);
    
                                                                     EditText phoneEditText = new EditText(context);
                                                                     phoneEditText.setHint("له");
                                                                     phoneEditText.setEnabled(false);
    
                                                                     phoneEditText.setText(UserKey2);
    
                                                                     layout.addView(phoneEditText);
    
    
                                                                     TextView nameEditText_4 = new TextView(context);
                                                                     nameEditText_4.setHint("عليه");
                                                                     layout.addView(nameEditText_4);
    
                                                                     EditText phoneEditText_5 = new EditText(context);
                                                                     phoneEditText_5.setHint("عليه");
                                                                     phoneEditText_5.setEnabled(false);
                                                                     phoneEditText_5.setText(Stata_2);
    
                                                                     layout.addView(phoneEditText_5);
    
    
                                                                     TextView nameEditText_6 = new TextView(context);
                                                                     nameEditText_6.setHint("الرصيد");
                                                                     layout.addView(nameEditText_6);
    
                                                                     EditText phoneEditText_7 = new EditText(context);
                                                                     phoneEditText_7.setHint("الرصيد");
    
                                                                     phoneEditText_7.setEnabled(false);
                                                                     phoneEditText_7.setTextSize(30);
                                                                     phoneEditText_7.setText(Sol);
    
                                                                     layout.addView(phoneEditText_7);
// تعيين تخطيط للحاوية في المربع الحواري
                                                                     builder.setView(layout);

// إضافة زر "حفظ" إلى المربع الحواري


// إضافة زر "إلغاء" إلى المربع الحواري
                                                                     builder.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                                                                         @Override
                                                                         public void onClick(DialogInterface dialog, int which) {
                                                                             dialog.dismiss();
                                                                         }
                                                                     });

// عرض المربع الحوار
                                                                     AlertDialog dialog = builder.create();
                                                                     dialog.show();
    
                                                                 
    
                                                         
                                                                     
                                                                     
                                                                     /*
                                                                     Toast.makeText(context, "enter :"+UserKey2, Toast.LENGTH_SHORT).show();
    
                                                                     SharedPreferences.Editor editor = sharedpreferences.edit();
                                                                     editor.putString("User_name",User_name);
                                                                     editor.putString("RegDate",RegDate);
        
                                                                     editor.putString("Sol", Sol);
    
                                                                     editor.putString("option", "detiles");
                                                                     editor.putString("UserKey2", UserKey2);
                                                                     editor.commit();
                                                                     Intent in=new Intent(context,MainActivity5.class);
        
        
                                                                     context. startActivity(in);
                                                                     
                                                                     */
                                                             return true;
                                                         }
                                                                 case id.delete: {
                                                                 
                                                                 
        
        /*
        
                                                                     SharedPreferences.Editor editor = sharedpreferences.edit();
                                                                     editor.putString("User_name",User_name);
                                                                     editor.putString("RegDate",RegDate);
        
                                                                     editor.putString("Sol", Sol);
        
                                                                     editor.putString("option", "delete");
                                                                     editor.putString("UserKey2", UserKey2);
                                                                     editor.commit();
                                                                     Intent in=new Intent(context,MainActivity5.class);
                                                                     
                                                                                                                                          context. startActivity(in);

        
        */
                                                 
                                                 if(Type_opation.contains("له"))
                                                     
                                                     Toast.makeText(context,"yes",Toast.LENGTH_SHORT).show();
                                                                    // Toast.makeText(context,"no",Toast.LENGTH_SHORT).show();
    
    
                                                                     if( Stata_2.contains("معلق")&& MainActivity4_drop.TempTypeUser.equals("1"))
                                                                     {
        
                                                                         
                                                                         //  pageWid_2=0;
        
                                                                         AlertDialog.Builder bu=new AlertDialog.Builder(context);
        
                                                                         bu.setTitle("توضيح")
                                                                         ;
                                                                         bu.setMessage("حدد نوع العملية ");
                                                                         bu.setPositiveButton("قبول ",new DialogInterface. OnClickListener(
                                                                         )
        
                                                                         {
            
                                                                             @SuppressLint("WrongConstant")
                                                                             @Override
                                                                             public void onClick(DialogInterface arg0, int arg1) {
                                                                              
                                                                                 clsDecoment clsd=new clsDecoment(context);
                                                                                 Toast.makeText(context,"key:"+UserKey2,Toast.LENGTH_SHORT).show();
    
                                                                                clsd.YesDecoment("Yes_dacoment",UserKey2,"u",context);
                                                                                 
                                                                             }
                                                                         });
        
                                                                         bu.setNegativeButton("رفض", new DialogInterface. OnClickListener() {
                      
                                                                                       @Override
                                                                                       public void onClick(DialogInterface arg0, int arg1) {
                                                                                      
    
    
                                                                                           AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                                                                           builder.setTitle("عملية رفض السند ");

// إنشاء حاوية لعرض تخطيط الحوار
                                                                                           LinearLayout layout = new LinearLayout(context);
                                                                                           layout.setOrientation(LinearLayout.VERTICAL);

// إضافة حقل النص للاسم
                                                                                           EditText nameEditText = new EditText(context);
                                                                                           nameEditText.setHint("التفاصيل");
                                                                                           layout.addView(nameEditText);

// إضافة حقل النص لرقم

// تعيين تخطيط للحاوية في المربع الحواري
                                                                                           builder.setView(layout);

// إضافة زر "حفظ" إلى المربع الحواري
                                                                                           builder.setPositiveButton("حفظ", new DialogInterface.OnClickListener() {
                                                                                               @Override
                                                                                               public void onClick(DialogInterface dialog, int which) {
            
                                                                                                   String n = nameEditText.getText().toString();
    
    
                                                                                                   final String gresr = nameEditText.getText().toString().trim();
    
    
                                                                                                   if ( TextUtils.isEmpty(gresr)) {
                                                                                                       Toast.makeText(context, "يجب تعبئة  الحقول", Toast.LENGTH_SHORT).show();
        
                                                                                                   }
                                                                                                   else
                                                                                                   {
                                                                                                       clsDecoment clsd=new clsDecoment(context);
        
                                                                                                       clsd.YesDecoment("No_dacoment",UserKey2,gresr,context);
        
                                                                                                   }
            
            
                                                                                                   // قم بتنفيذ الإجراء المطلوب عند النقر على زر "حفظ"
                                                                                               }
                                                                                           });

// إضافة زر "إلغاء" إلى المربع الحواري
                                                                                           builder.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                                                                                               @Override
                                                                                               public void onClick(DialogInterface dialog, int which) {
                                                                                                   dialog.dismiss();
                                                                                               }
                                                                                           });

// عرض المربع الحوار
                                                                                           AlertDialog dialog = builder.create();
                                                                                           dialog.show();
    
                                                                                       }
                                                                         
                          
                          
                                                                                       
                                                                                   }
                                                                         );
                                                                         bu.show();
                                                                         
                                                                     }
    
    
                                                                     else {
        
                                                                         Toast.makeText(context,"لايمكن التراجع", Toast.LENGTH_LONG).show();
        
                                                                         // State = "جاهز";
        
        
                                                                     }
    
                                                                     return true;
                                                                 }
                                                             }
                                                             return true;
                                                         }
                                                     }
                );
                popupMenu.inflate(menu.manu_3);
                popupMenu.show();
            }
            });

                // String m=  names.getText().toString();
                //showdata1_up(m);
              //  All_Users_list N=new All_Users_list();
               // N. Get_All_Data_serch_one(Text_UserName.getText().toString());
                    /*
                Intent in=new Intent(context,MainActivity_mysqlserver.class);
                in.putExtra("find_user","find_user");
                in.putExtra("infromation_user_intent",Text_UserName.getText().toString());
                in.putExtra("date_time",Text_DateTime_All_Users.getText().toString());

                in.putExtra("sol",Text_sol.getText().toString());
                in.putExtra("sumsol",Text_DateTime_All_Users.getText().toString());
                context.startActivity(in);
                // TODO Auto-generated method stub
*/





            // imag.setImageResource(listclass1.get(arg0).imag);

        return view;
    }


    public  void insertdata_update(String sa,String sum_sol) {
        //  final String phone = ed_phon.getText().toString().trim();
        final String name = "";

        // final String sol = ed_sol.getText().toString().trim();

        //   final String name=t1.getText().toString().trim();


        StringRequest request = new StringRequest(Request.Method.POST, uri5, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                //ed_sol.setText("");
                //   Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(context,"yes", Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                // param.put("name",name)

                param.put("type_opration","جاهز");

                param.put("id",sa);

                param.put("sum_sol",sum_sol);

                return param;
            }
        };


        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }


    }
