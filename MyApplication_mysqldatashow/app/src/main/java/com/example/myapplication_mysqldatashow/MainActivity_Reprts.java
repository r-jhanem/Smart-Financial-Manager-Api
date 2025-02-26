package com.example.myapplication_mysqldatashow;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

            public class MainActivity_Reprts extends AppCompatActivity {

                private static final int MANAGE_EXTERNAL_STORAGE=1;

                private static final String [] PEM={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,};
                EditText etName, etNoTlp, etJmlOne, etJmlTwo;
                Spinner itemSpinnerOne, itemSpinnerTwo;
                int pageWidth = 1200;
                Date dateTime;

                Bitmap bitmap, scaleBitmap;
                DateFormat dateFormat;
                float[] harga = new float[]{0, 21000,22000, 25000, 22500, 21500};

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main__reprts);



                    etName = (EditText)findViewById(R.id.etName);
                    etNoTlp = (EditText)findViewById(R.id.etNoTlp);
                    etJmlOne = (EditText)findViewById(R.id.etJmlOne);
                    etJmlTwo = (EditText)findViewById(R.id.etJmlTwo);



                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ammrann);
                    scaleBitmap = Bitmap.createScaledBitmap(bitmap, 1200, 518, false);

                    //permission
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                    //permission
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

                  //  createPDF();
                }

                public void add_log(View view) {



                            dateTime = new Date();

                            //get input
                            if (etName.getText().toString().length() == 0 ||
                                    etNoTlp.getText().toString().length() == 0 ||
                                    etJmlOne.getText().toString().length() == 0)
                                     {
                                Toast.makeText(MainActivity_Reprts.this, "Data tidak boleh kosong!", Toast.LENGTH_LONG).show();
                            } else {


                                PdfDocument pdfDocument = new PdfDocument();
                                Paint paint = new Paint();
                                Paint titlePaint = new Paint();

                                PdfDocument.PageInfo pageInfo
                                        = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                                PdfDocument.Page page = pdfDocument.startPage(pageInfo);

                                Canvas canvas = page.getCanvas();
                                canvas.drawBitmap(scaleBitmap, 0, 0, paint);

                                paint.setColor(Color.WHITE);
                                paint.setTextSize(30f);
                                paint.setTextAlign(Paint.Align.RIGHT);
                                canvas.drawText("Berbagai macam jenis Kopi", 1160, 40, paint);
                                canvas.drawText("Pesan di : 08123456789", 1160, 80, paint);

                                titlePaint.setTextAlign(Paint.Align.CENTER);
                                titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                                titlePaint.setColor(Color.BLUE);
                                titlePaint.setTextSize(70);
                                canvas.drawText("سند قب", pageWidth / 2, 500, titlePaint);

                                paint.setTextAlign(Paint.Align.LEFT);
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(45f);
                              //  canvas.drawText("انا الاخ : " + etName.getText(), 30, 590, paint);
                                //canvas.drawText("استلمت مبلغ وقدرة: " + etNoTlp.getText(), 30, 640, paint);

                                paint.setTextAlign(Paint.Align.RIGHT);
                                canvas.drawText("رقم السند: " + "232425", pageWidth - 20, 590, paint);
                                canvas.drawText("انا الاخ : " + etName.getText(),pageWidth - 20, 650, paint);
                                canvas.drawText("استلمت مبلغ وقدرة: " + etNoTlp.getText(),pageWidth - 20, 700, paint);
                                canvas.drawText("وذلك مقابل: " + etJmlOne.getText(),pageWidth - 20 , 760, paint);

                                dateFormat = new SimpleDateFormat("dd/MM/yy");
                                canvas.drawText("التاريخ : " + dateFormat.format(dateTime),  300, 590, paint);

                                dateFormat = new SimpleDateFormat("HH:mm:ss");
                                canvas.drawText(":الوقت "+ dateFormat.format(dateTime),  300, 650, paint);

                               // paint.setStyle(Paint.Style.STROKE);
                                //paint.setStrokeWidth(2);
                               // canvas.drawRect(20, 780, pageWidth - 20, 860, paint);
/*
                                paint.setTextAlign(Paint.Align.LEFT);
                                paint.setStyle(Paint.Style.FILL);
                                canvas.drawText("No.", 40, 830, paint);
                                canvas.drawText("Menu Pesanan", 200, 830, paint);
                                canvas.drawText("Harga", 700, 830, paint);
                                canvas.drawText("Jumlah", 900, 830, paint);
                                canvas.drawText("المجموع :", 1050, 830, paint);

                                canvas.drawLine(180, 790, 180, 840, paint);
                                canvas.drawLine(680, 790, 680, 840, paint);
                                canvas.drawLine(880, 790, 880, 840, paint);
                                canvas.drawLine(1030, 790, 1030, 840, paint);
*/
                                float totalOne = 0, totalTwo = 0;





                               // canvas.drawRect(680, 1050, pageWidth - 20, 1150, paint);


                              //  canvas.drawText(String.valueOf(subTotal + (20000 * 10 / 100)), pageWidth - 420, 1000, paint);

                                pdfDocument.finishPage(page);
                               // File file = new File(Environment.getExternalStorageState(), "/Raad.pdf");

                                 File file = new File(Environment.getExternalStorageDirectory(), "Download/Pesanan.pdf");
                                try {
                                    pdfDocument.writeTo(new FileOutputStream(file));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                pdfDocument.close();
                                Toast.makeText(MainActivity_Reprts.this, "PDF sudah dibuat", Toast.LENGTH_LONG).show();
                            }

                    openPDF();

                        }

                public void add_log_openpdf(View view) {

                    openPDF();
                }


                        //open




                // Access pdf from storage and using to Intent get options to view application in available applications.
                public void openPDF() {

                    // Get the File location and file name.
                    File file = new File(Environment.getExternalStorageDirectory(), "Download/Pesanan.pdf");
                    Log.d("pdfFIle", "" + file);

                    // Get the URI Path of file.
                    Uri uriPdfPath = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
                    Log.d("pdfPath", "" + uriPdfPath);

                    // Start Intent to View PDF from the Installed Applications.
                    Intent pdfOpenIntent = new Intent(Intent.ACTION_VIEW);
                    pdfOpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    pdfOpenIntent.setClipData(ClipData.newRawUri("", uriPdfPath));
                    pdfOpenIntent.setDataAndType(uriPdfPath, "application/pdf");
                    pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION |  Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                    try {
                        startActivity(pdfOpenIntent);
                    } catch (ActivityNotFoundException activityNotFoundException) {
                        Toast.makeText(this,"There is no app to load corresponding PDF",Toast.LENGTH_LONG).show();

                    }
                }

            }

/*
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.os.Build.VERSION.SDK_INT;
import static android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.File;

                public class MainActivity extends AppCompatActivity {

                    // Static CONSTANT VALUE
                    private static final int REQUEST_EXTERNAL_STORAGE = 1;
                    private static final String[] PERMISSION_STORAGE = {
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    };

                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);

                        // Verify Storage Access
                        verifyStoragePermission(this);

                        // Initialize Button on Activity
                        Button mButton = findViewById(R.id.pdfOpenButton);
                        // Add click listener on button to call openPDF method
                        mButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openPDF();
                            }
                        });

                    }

                    //Permissions Check
                    public void verifyStoragePermission(Activity activity) {
                        int permission = ActivityCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE);

                        // Surrounded with if statement for Android R to get access of complete file.
                        if (SDK_INT >= Build.VERSION_CODES.R) {
                            if (!Environment.isExternalStorageManager() && permission != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(
                                        activity,
                                        PERMISSION_STORAGE,
                                        REQUEST_EXTERNAL_STORAGE);

                                // Abruptly we will ask for permission once the application is launched for sake demo.
                                Intent intent = new Intent();
                                intent.setAction(ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                                Uri uri = Uri.fromParts("package", this.getPackageName(), null);
                                intent.setData(uri);
                                startActivity(intent);
                            }
                        }
                    }

                    // Access pdf from storage and using to Intent get options to view application in available applications.
                    private void openPDF() {

                        // Get the File location and file name.
                        File file = new File(Environment.getExternalStorageDirectory(), "Download/TRENDOCEANS.pdf");
                        Log.d("pdfFIle", "" + file);

                        // Get the URI Path of file.
                        Uri uriPdfPath = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
                        Log.d("pdfPath", "" + uriPdfPath);

                        // Start Intent to View PDF from the Installed Applications.
                        Intent pdfOpenIntent = new Intent(Intent.ACTION_VIEW);
                        pdfOpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        pdfOpenIntent.setClipData(ClipData.newRawUri("", uriPdfPath));
                        pdfOpenIntent.setDataAndType(uriPdfPath, "application/pdf");
                        pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION |  Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                        try {
                            startActivity(pdfOpenIntent);
                        } catch (ActivityNotFoundException activityNotFoundException) {
                            Toast.makeText(this,"There is no app to load corresponding PDF",Toast.LENGTH_LONG).show();

                        }
                    }



                }*/
