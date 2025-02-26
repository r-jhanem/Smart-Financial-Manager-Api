package com.example.myapplication_mysqldatashow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQ =0 ;
    public static String Main_Link = "http://10.0.2.2/test_anroid_mysql_php/";
    public static String uri_P = "http://10.0.2.2/test_anroid_mysql_php2/getsearch_user.php";

    Button add;
    public static String Local_UserKey , Local_UserName, Local_UserEmail, Local_UserAvatar;

    public static String UserKey , UserName, UserEmail, UserAvatar;

    private SharedPreferences shared_getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_home);


        Intent intent = getIntent();
        String cu = intent.getStringExtra(MainActivity4_drop.CouresName);
        String cu2 = intent.getStringExtra("user_name");
/*
        if (cu.equals(HomeFragment.RCV_COURES1)) {
            Intent in= new Intent(MainActivity.this, All_Users_list.class);


            startActivity(in);
        }
        else if (cu.equals(HomeFragment.RCV_COURES2_1))
        {

            // setContentView(R.layout.activity_mainpdf);
            //Toast.makeText(getApplicationContext(),"raaddd",Toast.LENGTH_LONG).show();


        } else if (cu.equals(HomeFragment.RCV_COURES2)) {


        } else if (cu.equals(null))

        {
            Toast.makeText(getApplicationContext(),"raaddd",Toast.LENGTH_LONG).show();

        }



        add= findViewById(R.id.BTN_Show_Data);

        int ppr=0;







        add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

       // pfragment frgm=new pfragment();

       // frgm.show(getSupportFragmentManager(),null);

Toast.makeText(getApplicationContext(),"uuuu",Toast.LENGTH_LONG).show();


      Intent in= new Intent(MainActivity.this, All_Users_list.class);

      startActivity(in);
    }
});



        findViewById(R.id.BTN_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pr=getPreferences(MODE_PRIVATE);

                SharedPreferences.Editor pp=pr.edit();

                pp.putInt("xraad",5);

                pp.commit();
                
                startActivity(new Intent(MainActivity.this, MainActivity_mysqlserver.class));
            }
        });


        findViewById(R.id.BTN_LogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // User_Profile Y=new User_Profile();
              // startActivity(new Intent(MainActivity.this, User_Profile.class));
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
        String inr=data.getStringExtra("r1");
        String inr2=data.getStringExtra("r2");
        showss(inr,inr2);}
    }

    public void add_lo(View view) {
        Toast.makeText( MainActivity.this, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();

    }


    class pfragment extends DialogFragment
    {
        @Nullable
        int REQ=0;
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View v=inflater.inflate(R.layout.activity_log_in,container,false);
            Button h=v.findViewById(R.id.btn_Reg);
            EditText t1=v.findViewById(R.id.ETXT_Pass);
            EditText t2=v.findViewById(R.id.ETXT_UserName);
            String h1=t1.getText().toString();
            String h2=t2.getText().toString();
            h.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v1) {

                    /*
                    MainActivity m= (MainActivity)getActivity();


                    Intent activity=new Intent(getApplicationContext(),MainActivity.class);

                    activity.putExtra("r1",h1);
                    activity.putExtra("r2",h2);
                    m.onActivityResult(1,RESULT_OK,activity);


                }
            });


            return v;
        }


    }
    public  void showss(String t,String r)
    {

        Toast.makeText(this,"name:"+t+"\nage:"+r,Toast.LENGTH_LONG).show();
    }
}*/
    }}
