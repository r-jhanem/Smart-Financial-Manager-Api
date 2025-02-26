package com.example.myapplication_mysqldatashow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

        TextView show;
        int i;
        @SuppressLint("WrongConstant")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            show=(TextView)findViewById(R.id.textView2_treed);
    

            Thread tred=new  Thread(new  Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    for( i=3;i>0;i--)
                    {
                        try{

                            Thread.sleep(2000);
                        }
                        catch(InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        final int fin=i;

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                              //  show.setText(""+fin );
                                
                                
                                if(fin==1)
                                {
                                    //setContentView(R.layout.activity_main);

                                    Intent intent=new Intent(MainActivity2.this,LogIn.class);
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                }
            });


            tred.start();


            //Intent intent=new Intent(MainActivit9.this,Reprotes1.class);
            //startActivity(intent);

            //finish();


//setContentView(R.layout.display);

//finish();
        }

    }