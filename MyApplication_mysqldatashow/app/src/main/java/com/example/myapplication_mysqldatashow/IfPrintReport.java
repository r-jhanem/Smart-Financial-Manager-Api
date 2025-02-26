package com.example.myapplication_mysqldatashow;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
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
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication_mysqldatashow.ui.home.HomeFragment;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


   public class IfPrintReport {
    
   
      public static   String userr_names_ditais="", userr_names_datess="",uset_name="",user_id="",userr_names="",Sol_user="",ed_Sol_user="",pi_Sol_user="";
      public  static String Sol_user_date="";
    
      Context context;
      Employee [] employeeed;
    
      public static ArrayList<List_All_Users> mList_2=new ArrayList<List_All_Users>();
      public static ArrayList<Employee> mList=new ArrayList<Employee>();
      public static ArrayList<Employee> gg=new ArrayList<Employee>();
    
      private static final int MANAGE_EXTERNAL_STORAGE=1;
      float[] harga = new float[]{0, 21000,22000, 25000, 22500, 21500};

      private static final String [] PEM={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,};
      EditText etName, etNoTlp, etJmlOne, etJmlTwo;
      Spinner itemSpinnerOne, itemSpinnerTwo;
      int pageWidth = 1200;
      Date dateTime;

      public  Bitmap bitmap, scaleBitmap;
      DateFormat dateFormat;
      ArrayList<List_All_Users> listclass1=new ArrayList<List_All_Users>();
    
      public IfPrintReport(Context context)
      {
          this.context=context;

          bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.jhk);
          scaleBitmap = Bitmap.createScaledBitmap(bitmap, 1200, 518, false);
    
          //permission
          ActivityCompat.requestPermissions((Activity) context, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
          //permission
          ActivityCompat.requestPermissions((Activity) context, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    
          
    
      }
      
      IfPrintReport(Context context, ArrayList<List_All_Users> listclass1) {
          this.context=context;
          this.listclass1 = listclass1;
       
      }
    
    
  
    public void PrinReportOne(String NameAout_1,String NameAout, String NameBre, String NameBox) {
    String NameType="انا الاخ:",namesol="استلمت مبلغ وقدرة: ";
          if(NameAout_1.contains("سند صرف"))
        
          {
              namesol=" مبلغ وقدرة: ";
              NameType="يتم صرف للاخ:";
          }
           String fileName="";
        
              Date   dateTime = new Date();
    
          //get input
          if (NameAout != null ||
                    NameBre != null ||
                    NameBox != null)
          {
              //Toast.makeText(context, "Data tidak boleh kosong!", Toast.LENGTH_LONG).show();
         
    
              Random random = new Random();
              double k=random.nextDouble();
               
                    String gg=String.valueOf(k);
                    
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
              canvas.drawText(NameAout_1, pageWidth / 2, 500, titlePaint);
        
              paint.setTextAlign(Paint.Align.LEFT);
              paint.setColor(Color.BLACK);
              paint.setTextSize(45f);
              //  canvas.drawText("انا الاخ : " + etName.getText(), 30, 590, paint);
              //canvas.drawText("استلمت مبلغ وقدرة: " + etNoTlp.getText(), 30, 640, paint);
        
              paint.setTextAlign(Paint.Align.RIGHT);
              canvas.drawText("رقم السند: " +user_id, pageWidth - 20, 590, paint);
              
              canvas.drawText(NameType+ userr_names,pageWidth - 20, 650, paint);
              canvas.drawText(namesol + NameBre,pageWidth - 20, 700, paint);
              canvas.drawText("وذلك مقابل: " + userr_names_ditais,pageWidth - 20 , 760, paint);
        
            //  dateFormat = new SimpleDateFormat("dd/MM/yy");
              dateFormat = new SimpleDateFormat("yy/MM/dd");
              canvas.drawText("التاريخ: " + userr_names_datess,  400, 590, paint);
        
        
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
            //  File file = new File(Environment.getExternalStorageState(), "Download/Pesanan.pdf");
              fileName = "Pesanan_" + System.currentTimeMillis() + ".pdf";
    
              try {
                  // إنشاء ملف PDF في الذاكرة الداخلية
                  File internalDir = context.getFilesDir();
                  File pdfFile = new File(internalDir, fileName);
        
                  // إنشاء OutputStream للكتابة إلى الملف
                  OutputStream outputStream = new FileOutputStream(pdfFile);
        
                  // كتابة محتوى المستند PDF إلى الملف
                  pdfDocument.writeTo(outputStream);
        
                  // إغلاق OutputStream
                  outputStream.close();
        
                  Toast.makeText(context, "تم حفظ الملف PDF", Toast.LENGTH_LONG).show();
        
                  pdfDocument.close();
        
                  // فتح الملف PDF باستخدام تطبيق فاتح PDF المثبت على الجهاز
                  Uri pdfUri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", pdfFile);
                  Intent intent = new Intent(Intent.ACTION_VIEW);
                  intent.setDataAndType(pdfUri, "application/pdf");
                  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                  intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        
                  // التحقق مما إذا كان التطبيق المستهدف مثبتًا على الجهاز
                  PackageManager packageManager = context.getPackageManager();
                  if (intent.resolveActivity(packageManager) != null) {
                      context.startActivity(intent);
                  } else {
                      // إذا لم يتم العثور على تطبيق فاتح PDF، عرض رسالة حول ضرورة تثبيت التطبيق
                      Toast.makeText(context, "يرجى تثبيت تطبيق فاتح PDF", Toast.LENGTH_SHORT).show();
                  }
        
              } catch (IOException e) {
                  e.printStackTrace();
              }
             
             
             /*
              File file = new File(Environment.getExternalStorageDirectory(), "Download/" + fileName);
              try {
                  pdfDocument.writeTo(new FileOutputStream(file));
              } catch (IOException e) {
                  e.printStackTrace();
              }
        
              pdfDocument.close();
              Toast.makeText(context, "PDF sudah dibuat", Toast.LENGTH_LONG).show();
          }
*/

         //   openPDF(fileName);

        }}
    
    
      public void PrinReportAll() {
          String fileName="";
          Toast.makeText(context, "Dat: "+listclass1.size(), Toast.LENGTH_LONG).show();
    
          String h="iii";
int s11= listclass1.size()/15+1,s12=0;

              dateTime = new Date();

              //get input
              if  (h.length() == 0 ||
                        h.length() == 0 ||
                        h.length() == 0||
                        h.length() == 0)
 {
                  //Toast.makeText(MainActivity_Reprts.this, "Data tidak boleh kosong!", Toast.LENGTH_LONG).show();
              } else {
                  int idr = 0, name, sol, detlis, tolt;

                  PdfDocument pdfDocument = new PdfDocument();
for(int f=0;f<s11;f++) {

    PdfDocument pdfDocument2 = new PdfDocument();
    Paint paint = new Paint();
    Paint titlePaint = new Paint();

    PdfDocument.PageInfo pageInfo
            = new PdfDocument.PageInfo.Builder(1200, 2000, f+1).create();


    PdfDocument.Page page = pdfDocument.startPage(pageInfo);
    Canvas canvas = page.getCanvas();


    paint.setTextAlign(Paint.Align.LEFT);
    paint.setStyle(Paint.Style.FILL);

    canvas.drawText("الرقم ", 40, 40, paint);
    canvas.drawText("الاسم", 200, 40, paint);
    canvas.drawText("الملغ", 700, 40, paint);
    canvas.drawText("التفاصيل", 900, 40, paint);
    canvas.drawText("الاجمالي", 1050, 40, paint);


    canvas.drawLine(180, 790, 180, 840, paint);
    canvas.drawLine(680, 790, 680, 840, paint);
    canvas.drawLine(880, 790, 880, 840, paint);
    canvas.drawLine(1030, 790, 1030, 840, paint);

    float totalOne = 0, totalTwo = 0;
  


     int id= name = sol = detlis = tolt = 160;
        for (int i = 0; i < listclass1.size(); i++) {
            s12++;
            String y = String.valueOf(s12);


            canvas.drawText(y, 40, id, paint);
            canvas.drawText( listclass1.get(i).User_name, 200, id, paint);
            canvas.drawText(listclass1.get(i).Sol, 700, id, paint);
            canvas.drawText(listclass1.get(i).Sol, 900, id, paint);
            totalTwo = Float.parseFloat("0") * harga[4];
            paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(String.valueOf(totalTwo), pageWidth - 40, id, paint);
            paint.setTextAlign(Paint.Align.LEFT);

            if(i==15)
            {
                break;
            }



        id +=80;
if(i==15)
{
    break;
}
    }

if(f==f-1) {
    Toast.makeText(context, "PDF sudah dibuat", Toast.LENGTH_LONG).show();

    float subTotal = 80 + 90;
    canvas.drawLine(400, id, pageWidth - 20, id, paint);
    canvas.drawText("Sub Total", 700, id + 50, paint);
    canvas.drawText(":", 900, id + 50, paint);
    paint.setTextAlign(Paint.Align.RIGHT);
    canvas.drawText(String.valueOf(subTotal), pageWidth - 40, id + 50, paint);

    paint.setTextAlign(Paint.Align.LEFT);
    canvas.drawText("PPN (10%)", 700, id + 100, paint);
    canvas.drawText(":", 900, id + 100, paint);
    paint.setTextAlign(Paint.Align.RIGHT);
    canvas.drawText(String.valueOf(subTotal * 10 / 100), pageWidth - 40, id + 100, paint);
    paint.setTextAlign(Paint.Align.LEFT);

    paint.setColor(Color.rgb(247, 147, 30));
    canvas.drawRect(680, id + 150, pageWidth - 20, id + 250, paint);

    paint.setColor(Color.BLACK);
    paint.setTextSize(90f);
    paint.setTextAlign(Paint.Align.LEFT);
    canvas.drawText("Total", 700, id + 235, paint);
    paint.setTextAlign(Paint.Align.RIGHT);

    canvas.drawText(String.valueOf(subTotal + (subTotal * 10 / 100)), pageWidth - 40, id + 235, paint);
}
    pdfDocument.finishPage(page);
}
                  // File file = new File(Environment.getExternalStorageState(), "/Raad.pdf");
                 // File file = new File(Environment.getExternalStorageState(), "Download/Pesanan.pdf");
    
                  fileName = "Pesanan_" + System.currentTimeMillis() + ".pdf";
    
                  File file = new File(Environment.getExternalStorageDirectory(), "Download/" + fileName);                  try {
                      pdfDocument.writeTo(new FileOutputStream(file));
                  } catch (IOException e) {
                      e.printStackTrace();
                  }

                  pdfDocument.close();
                  //   Toast.makeText(MainActivity_Reprts.this, "PDF sudah dibuat", Toast.LENGTH_LONG).show();
          }


          openPDF(fileName);
      }
    
    
    
      public void openPDF(String filename) {
          File file = new File(context.getFilesDir(), filename);
          Uri uriPdfPath = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file);
    
          Intent pdfOpenIntent = new Intent(Intent.ACTION_VIEW);
          pdfOpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          pdfOpenIntent.setClipData(ClipData.newRawUri("", uriPdfPath));
          pdfOpenIntent.setDataAndType(uriPdfPath, "application/pdf");
          pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
    
          new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                  context.startActivity(pdfOpenIntent);
              }
          }, 1000);
    
      }
          /*
          // Get the File location and file name.
          File file = new File(Environment.getExternalStorageDirectory(), "Download/" + filename);
          Log.d("pdfFile", "" + file);
        
          // Get the URI Path of the file.
          Uri uriPdfPath = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file);
          Log.d("pdfPath", "" + uriPdfPath);
        
          // Start Intent to View PDF from the Installed Applications.
          Intent pdfOpenIntent = new Intent(Intent.ACTION_VIEW);
          pdfOpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          pdfOpenIntent.setClipData(ClipData.newRawUri("", uriPdfPath));
          pdfOpenIntent.setDataAndType(uriPdfPath, "application/pdf");
          pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        
          new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                  context.startActivity(pdfOpenIntent);
              }
          }, 1000); // تأخير لمدة ثانية واحدة (1000 مللي ثانية)
      }
    
    
          public void openPDF(String filename) {
    
              // Get the File location and file name.
              File file = new File(Environment.getExternalStorageDirectory(), "Download/"+filename);
              Log.d("pdfFIle", "" + file);
    
              // Get the URI Path of file.
              Uri uriPdfPath = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file);
              Log.d("pdfPath", "" + uriPdfPath);
    
              // Start Intent to View PDF from the Installed Applications.
              Intent pdfOpenIntent = new Intent(Intent.ACTION_VIEW);
              pdfOpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              pdfOpenIntent.setClipData(ClipData.newRawUri("", uriPdfPath));
              pdfOpenIntent.setDataAndType(uriPdfPath, "application/pdf");
              pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION |  Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
    
              try {
               context.   startActivity(pdfOpenIntent);
              } catch (ActivityNotFoundException activityNotFoundException) {
                  Toast.makeText(context,"There is no app to load corresponding PDF",Toast.LENGTH_LONG).show();
        
              }
          }
    */
      
          
    
              
                // استيراد المكتبة
  
      // الكلاس الرئيسي
        
          // مصفوفة تحتوي على بيانات الموظفين
       
        
          // دالة إنشاء التقرير
    
    
    
       public void createReportDocument(ArrayList<List_All_Users> listclass1) {
           try {
            
               int sum_1=0,sum_2=0,sum_3=0;
               Paint paint = new Paint();
               Document document = new Document();
               PdfDocument pdfDocument = new PdfDocument();
            
               PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(1000, 2000, 1).create();
            
               Paint titlePaint = new Paint();
               PdfDocument.Page page = pdfDocument.startPage(pageInfo);
               Canvas canvas = page.getCanvas();
            
               String fileName = "Pesanan_" + System.currentTimeMillis() + ".pdf";
              // File file = new File(Environment.getExternalStorageDirectory(), "Download/" + fileName);
             //  File file = new File(Environment.getDataDirectory(), "Download/" + fileName);
               File file = new File(context.getFilesDir(), fileName);
    
               if(!file.exists())
    {
        file.createNewFile();
        
    }
               // إنشاء ملف PDF جديد
               FileOutputStream fOut = new FileOutputStream(file);
               PdfWriter writer = PdfWriter.getInstance(document, fOut);
               // فتح المستند
               document.open();
            
               BaseFont bf = BaseFont.createFont("assets/fonts/Almarai-Light.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
               Font headerFont = new Font(bf, 12, Font.BOLD);
               PdfPTable table2 = new PdfPTable(1);
               table2.setWidthPercentage(100);
               table2.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            
            
            
               String clom1="الاسم";
            
               if(HomeFragment.MyPRE_box_print_date_fr_date.equals("utyy")) {
                
                
                   PdfPCell cel = new PdfPCell(new Paragraph("كشف حساب باسم: " + HomeFragment.namees_serch + " " + "من:" + HomeFragment.MyPRE_box_print_date_fr + " " + "الى:" + HomeFragment.MyPRE_box_print_2_date_to, headerFont));
                   cel.setBorder(Rectangle.NO_BORDER);
                   table2.addCell(cel);
                
                
               }
            
               if(!HomeFragment.MyPRE_box_print_date_fr_date.equals("utyy")) {
                
                   PdfPCell cel2 = new PdfPCell(new Paragraph("كشف حساب باسم: " + uset_name, headerFont));
                   cel2.setBorder(Rectangle.NO_BORDER);
                   table2.addCell(cel2);
                
                
                
               }
            
               if(!HomeFragment.MyPRE_box_print_2.equals("p")) {
                   clom1 = "الرقم";
                
               }
            
               document.add(table2);
            
               // إضافة عنوان التقرير
            
               HomeFragment.namees_serch="";
               HomeFragment.MyPRE_box_print_date_fr_date="";
            
            
               PdfPTable table = new PdfPTable(6);
               table.setWidthPercentage(100);
               table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            
               PdfPCell cell = new PdfPCell(new Paragraph(clom1, headerFont));
               cell.setBackgroundColor(BaseColor.CYAN);
               cell.setPaddingTop(10f);
               cell.setPaddingBottom(10f);
               table.addCell(cell);
            
            
               cell = new PdfPCell(new Paragraph("التاريخ", headerFont));
               cell.setBackgroundColor(BaseColor.CYAN);
               cell.setPaddingTop(10f);
               cell.setPaddingBottom(10f);
               table.addCell(cell);
            
               cell = new PdfPCell(new Paragraph("التفاصيل", headerFont));
               cell.setBackgroundColor(BaseColor.CYAN);
               cell.setPaddingTop(10f);
               cell.setPaddingBottom(10f);
               table.addCell(cell);
            
               cell = new PdfPCell(new Paragraph("المبلغ", headerFont));
               cell.setBackgroundColor(BaseColor.CYAN);
               cell.setPaddingTop(10f);
               cell.setPaddingBottom(10f);
               table.addCell(cell);
            
               cell = new PdfPCell(new Paragraph("النوع", headerFont));
               cell.setBackgroundColor(BaseColor.CYAN);
               cell.setPaddingTop(10f);
               cell.setPaddingBottom(10f);
               table.addCell(cell);
            
               cell = new PdfPCell(new Paragraph("الحالة", headerFont));
               cell.setBackgroundColor(BaseColor.CYAN);
               cell.setPaddingTop(10f);
               cell.setPaddingBottom(10f);
               table.addCell(cell);
            
               for (int i = 0; i < listclass1.size(); i++) {
                
                   if(HomeFragment.MyPRE_box_print_2.equals("p")) {
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).doof, headerFont)));
                    
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).RegDate, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).User_name, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).Sol, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).type, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).state, headerFont)));
                    
                   }
                   if(!HomeFragment.MyPRE_box_print_2.equals("p")) {
                       table.addCell(new PdfPCell(new Phrase(String.valueOf(i+1), headerFont)));
                    
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).RegDate, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).User_name, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).Sol, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).type, headerFont)));
                       table.addCell(new PdfPCell(new Phrase(listclass1.get(i).state, headerFont)));
                   }
                   String dd=listclass1.get(i).state;
                   switch (dd)
                   {
                       case "جاهز" : {
                           String soles = listclass1.get(i).Sol;
                           int s1=Integer.parseInt(soles);
                           sum_3+=s1;
                           String dd2 = listclass1.get(i).type;
                           switch (dd2)
                           {
                               case "له":
                                
                                   sum_1+=s1;
                                
                                
                                   break;
                            
                               case "عليه":
                                
                                   sum_2+=s1;
                                
                                
                                   break;
                           }
                        
                       }
                       break;
                    
                   }}
            
               document.add(table);
            
            
            
               PdfPTable table4 = new PdfPTable(1); // 1 column
               table4.setWidthPercentage(100); // table width to 100% of page width
               table4.setRunDirection(PdfWriter.RUN_DIRECTION_RTL); // set the run direction to RTL
            
               PdfPCell cle4 = new PdfPCell(new Paragraph("تفاصيل الحساب الاجمالي "+uset_name, headerFont));
               table2.addCell(cle4);
               document.add(table4);
            
            
               PdfPTable table3 = new PdfPTable(3); // 1 column
               table3.setWidthPercentage(100); // table width to 100% of page width
               table3.setRunDirection(PdfWriter.RUN_DIRECTION_RTL); // set the run direction to RTL
            
               PdfPCell cel2 =new PdfPCell(new Paragraph("له", headerFont));
               cel2.setBorder(Rectangle.NO_BORDER); // remove cell borders
               cel2.setBackgroundColor(BaseColor.CYAN);
               cel2.setPaddingTop(10f); // increase top padding
               cel2.setPaddingBottom(10f);
               table3.addCell(cel2);
            
            
               cel2 = new PdfPCell(new Paragraph("عليه", headerFont));
               cel2.setBorder(Rectangle.NO_BORDER);
            
               cel2.setPaddingTop(10f); // increase top padding
               cel2.setPaddingBottom(10f);
               cel2.setBackgroundColor(BaseColor.CYAN);
            
               table3.addCell(cel2);
               cel2 = new PdfPCell(new Paragraph("الرصيد", headerFont));
               cel2.setBorder(Rectangle.NO_BORDER);
               cel2.setBackgroundColor(BaseColor.CYAN);
            
            
               cel2.setPaddingTop(10f); // increase top padding
               cel2.setPaddingBottom(10f);
            
               table3.addCell(cel2);
            
               table3.addCell(new PdfPCell(new Phrase( String.valueOf(sum_1), headerFont)));
               table3.addCell(new PdfPCell(new Phrase(String.valueOf(sum_2), headerFont)));
               table3.addCell(new PdfPCell(new Phrase(String.valueOf(sum_3), headerFont)));
               document.add(table3);
// Add the table to the document
              
                  /*
                  // إضافة بيانات الموظفين
                  for (int i = 0; i < 200; i++) {
                      Paragraph employee = new Paragraph("Name: "+ "\nDepartment: " );
    
              س      //  Paragraph employee = new Paragraph("Name: " + employeeData[i][0] + "\nDepartment: " + employeeData[i][1] + "\nEmail: " + employeeData[i][2] + "\n");
                      document.add(employee);
                  }*/
            
            
            
            
            
               // إغلاق المستند
               document.close();
               listclass1.clear();
            
               // عرض رسالة بالنجاح
               Toast.makeText(context, "Report created successfully", Toast.LENGTH_SHORT).show();
            
            
            
               openPDF(fileName);
            
           } catch (DocumentException de) {
               // عرض رسالة بالخطأ
               Toast.makeText(context, "Error creating report", Toast.LENGTH_SHORT).show();
           } catch (IOException e) {
               // عرض رسالة بالخطأ
               Toast.makeText(context, "Error creating file", Toast.LENGTH_SHORT).show();
           }
        
       }
    
    
      public void createReport(ArrayList<Employee>listclass1) {
           //   Toast.makeText(context,"There is no app to load corresponding PDF"+listclass1.length(),Toast.LENGTH_LONG).show();
              
              try {
    
    
    
                  int pageWidth = 1000;
    
    
                  Paint paint = new Paint();
                  Document document = new Document();
                  PdfDocument pdfDocument = new PdfDocument();
    
                
    
                  PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(1200, 2000, 1).create();
    
                  Paint titlePaint = new Paint();
                  PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                  Canvas canvas = page.getCanvas();
    
                  paint.setTextAlign(Paint.Align.LEFT);
                  paint.setColor(Color.BLACK);
                  paint.setTextSize(45f);
                  //  canvas.drawText("انا الاخ : " + etName.getText(), 30, 590, paint);
                  //canvas.drawText("استلمت مبلغ وقدرة: " + etNoTlp.getText(), 30, 640, paint);
    
                  paint.setTextAlign(Paint.Align.RIGHT);
                  canvas.drawText("رقم السند: " + "1", pageWidth - 20, 590, paint);
    
    
              
    
                  paint.setTextAlign(Paint.Align.LEFT);
                  paint.setStyle(Paint.Style.FILL);
    
                  canvas.drawText("الرقم ", 40, 40, paint);
                  canvas.drawText("الاسم", 200, 40, paint);
                  canvas.drawText("الملغ", 700, 40, paint);
                  canvas.drawText("التفاصيل", 900, 40, paint);
                  canvas.drawText("الاجمالي", 1050, 40, paint);
    
    
                  canvas.drawLine(180, 790, 180, 840, paint);
                  canvas.drawLine(680, 790, 680, 840, paint);
                  canvas.drawLine(880, 790, 880, 840, paint);
                  canvas.drawLine(1030, 790, 1030, 840, paint);


                  
                  
// توليد اسم ملف فريد باستخدام الوقت الحالي
    
                  String fileName = "Pesanan_" + System.currentTimeMillis() + ".pdf";
                  // File file = new File(Environment.getExternalStorageDirectory(), "Download/" + fileName);
                  //  File file = new File(Environment.getDataDirectory(), "Download/" + fileName);
                  File file = new File(context.getFilesDir(), fileName);
    
                  if(!file.exists())
                  {
                      file.createNewFile();
        
                  }
                  // إنشاء ملف PDF جديد
                  FileOutputStream fOut = new FileOutputStream(file);
                  PdfWriter writer = PdfWriter.getInstance(document, fOut);
                  // فتح المستند
                  // إضافة عنوان التقرير
                  BaseFont bf = BaseFont.createFont("assets/fonts/Almarai-Light.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                  Font headerFont = new Font(bf, 12, Font.BOLD);
    
                  Font headerFont_3 = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
                  Phrase title_3 = new Phrase("كشف حساب كافة "+All_Users_list.name_prints, headerFont_3);
                  
    
                  PdfPTable table3 = new PdfPTable(1);
                  PdfPCell cell_2 = new PdfPCell(title_3);
                  cell_2.setHorizontalAlignment(Element.ALIGN_CENTER);
                  cell_2.setBorder(Rectangle.NO_BORDER);
    
                  table3.addCell(cell_2);
                  document.add(table3);
                  
                  
              
                  
                  
                  
// إضافة العنوان إلى المستند
                  
                  
                  
                  PdfPTable table2 = new PdfPTable(1); // 1 column
                  table2.setWidthPercentage(100); // table width to 100% of page width
                  table2.setRunDirection(PdfWriter.RUN_DIRECTION_RTL); // set the run direction to RTL
    
                  PdfPCell cel = new PdfPCell(new Paragraph("كشف حساب كافة "+All_Users_list.name_prints, headerFont));
                  table2.addCell(cel);
                  document.add(table2);
    
                  PdfPTable table = new PdfPTable(4); // 4 columns
                  table.setWidthPercentage(100); // table width to 100% of page width
    
                
                  
                  
                  table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL); // set the run direction to RTL
    
    
                 
                  PdfPCell cell = new PdfPCell(new Paragraph("الاسم", headerFont));
    
                  
                  cell.setBackgroundColor(BaseColor.CYAN);
                  cell.setPaddingTop(10f);
                  cell.setPaddingBottom(10f);
                  table.addCell(cell);
                  
                  
                  
                  

                  cell = new PdfPCell(new Paragraph("عليه", headerFont));
    
                  cell.setBackgroundColor(BaseColor.CYAN);
                  cell.setPaddingTop(10f);
                  cell.setPaddingBottom(10f);
                  table.addCell(cell);
                  cell = new PdfPCell(new Paragraph("له", headerFont));
    
                  cell.setBackgroundColor(BaseColor.CYAN);
                  cell.setPaddingTop(10f);
                  cell.setPaddingBottom(10f);
                  table.addCell(cell);
                  cell = new PdfPCell(new Paragraph("الاجمالي", headerFont));
    
                  cell.setBackgroundColor(BaseColor.CYAN);
                  cell.setPaddingTop(10f);
                  cell.setPaddingBottom(10f);
                  table.addCell(cell);
    
                  int x=0;
                  for (int i = 0; i < listclass1.size(); i++) {
                      x++;
                      table.addCell(new PdfPCell(new Phrase(listclass1.get(i).name, headerFont)));
                      table.addCell(new PdfPCell(new Phrase(listclass1.get(i).amount_due, headerFont)));
                      table.addCell(new PdfPCell(new Phrase(listclass1.get(i).department, headerFont)));
                      table.addCell(new PdfPCell(new Phrase(listclass1.get(i).amount_paid, headerFont)));
    
                  }
// Add the table to the document
                  document.add(table);
                  /*
                  // إضافة بيانات الموظفين
                  for (int i = 0; i < 200; i++) {
                      Paragraph employee = new Paragraph("Name: "+ "\nDepartment: " );
    
                    //  Paragraph employee = new Paragraph("Name: " + employeeData[i][0] + "\nDepartment: " + employeeData[i][1] + "\nEmail: " + employeeData[i][2] + "\n");
                      document.add(employee);
                  }*/
    
                  // إغلاق المستند
                  document.close();
    
                  // عرض رسالة بالنجاح
                 Toast.makeText(context, "Report created successfully", Toast.LENGTH_SHORT).show();
                 
             
                 
                  openPDF(fileName);
    
              } catch (DocumentException de) {
                  // عرض رسالة بالخطأ
                  Toast.makeText(context, "Error creating report", Toast.LENGTH_SHORT).show();
              } catch (IOException e) {
                  // عرض رسالة بالخطأ
                Toast.makeText(context, "Error creating file", Toast.LENGTH_SHORT).show();
              }
    
          }
    
          
          public class Employee {
           int id;
              public String name;
              public  String department;
              public Employee (){
              }
              public String amount_paid;
              public String amount_due;
          public Employee( String name, String department,String amount_paid
                     ,String amount_due) {
              this.name = name;
              this.department = department;
              this. amount_paid=amount_paid;
              this.amount_due=amount_due;
          }
        
          public int getId() {
              return id;
          }
        
          public String getName() {
              return name;
          }
        
          public String getDepartment() {
              return department;
          }
      }

    public void createReport() {
              String[][] employeeData = {
                        {"John Doe", "Marketing", "johndoe@email.com"},
                        {"Jane Smith", "Sales", "janesmith@email.com"},
                        {"Bob Johnson", "Finance", "bobjohnson@email.com"}
              };
    
              // إنشاء مستند PDF جديد
    
    
              Document document = new Document();
              try {
                  // إنشاء ملف PDF جديد
                  String fileName = "Pesanan_" + System.currentTimeMillis() + ".pdf";
    
                  File file = new File(Environment.getExternalStorageDirectory(), "Download/" + fileName);
                  FileOutputStream fOut = new FileOutputStream(file);
                  PdfWriter.getInstance(document, fOut);
    
                  // فتح المستند
                  document.open();
                  // إضافة عنوان التقرير
                  Paragraph title = new Paragraph("Employee Report");
                  document.add(title);
    
                  // إضافة بيانات الموظفين
                  for (int i = 0; i < 200; i++) {
                      Paragraph employee = new Paragraph("Name: "+ "\nDepartment: " );
    
                    //  Paragraph employee = new Paragraph("Name: " + employeeData[i][0] + "\nDepartment: " + employeeData[i][1] + "\nEmail: " + employeeData[i][2] + "\n");
                      document.add(employee);
                  }
    
                  // إغلاق المستند
                  document.close();
    
                  // عرض رسالة بالنجاح
                 Toast.makeText(context, "Report created successfully", Toast.LENGTH_SHORT).show();
                  openPDF(fileName);
    
              } catch (DocumentException de) {
                  // عرض رسالة بالخطأ
                  Toast.makeText(context, "Error creating report", Toast.LENGTH_SHORT).show();
              } catch (IOException e) {
                  // عرض رسالة بالخطأ
                Toast.makeText(context, "Error creating file", Toast.LENGTH_SHORT).show();
              }
    
          }



    
      public   void Get_All_Data3( ) {
          for (int i = 0; i < 40; i++) {
    
              mList.add(new Employee("User_name", "Sol", "amount_paid", "amount_due"));
    
            
          }
          createReport(mList);
    
      }
      public   void Get_All_Data( String nameh,String name_2) {
        
           RequestQueue queue = Volley.newRequestQueue(context);
          StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    MainActivity4_drop.uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                  try {
                      JSONArray jsonArray = new JSONArray(response);
                    
                      JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                      JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                      List<Employee> mListss = new ArrayList<>();
                    
                    Toast.makeText(context, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                      
                      List<String> mListss2 = new ArrayList<>();
                      String[] dd = new String[jsonArray_usersS.length()];
                      String[] ddd = new String[jsonArray_usersS.length()];
                      String maness = "";
                      int cnam = 0;
                      int cn = 0;
                    //  mList.clear();
                      String count_user="8",Na="op",key_decoment="",p0="",p2="",Staty="",Type="";
                      int s=0,s1=0,s2=0,s3=0;
                      for (int i = 0; i < jsonArray_usersS.length(); i++) {
                          JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                          // String iduser = responsS.getString("UserKey");
                        
                          // int idu= responsS.getInt("id");type
                          String User_name = responsS.getString("name").trim();
                          String Sol = responsS.getString("balance_due").trim();
                          String amount_due = responsS.getString("amount_due").trim();
                          String amount_paid = responsS.getString("amount_paid").trim();
                        
                          int due = Integer.parseInt(amount_due);
                          int paid = Integer.parseInt(amount_paid);
                        
                        Employee employeem;
                        
                          String CountDecoment = responsS.getString("CountDecoment").trim();
                        
                        //  String key_decoment2 = responsS.getString("key_decoment").trim();
                        
                        if(!User_name.contains("الكل"))
                        
                        {
                           String h="rr";
                            gg.add(new Employee(User_name, Sol, amount_paid, amount_due));
                        }
                          //    Toast.makeText(context, ":"+Staty+""+Type, Toast.LENGTH_SHORT).show();
                        //  mListss.add(new Employee(User_name, Sol, amount_paid, amount_due));
                        
    
                      
    
                          queue.stop();
                      }
                    
                  } catch (JSONException e) {
                      e.printStackTrace();
                  }
    
                  createReport(gg);
                  
                
              
                
              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
              
              }
          }) {
              @Override
              protected Map<String, String> getParams() throws AuthFailureError {
                  Map<String, String> params = new HashMap<>();
                  
                  params.put("name", nameh);
                
                  return params;
              }
          };
          queue.add(stringRequest);
          stringRequest.setShouldCache(false);
        
        
      
  }
    
    
      public  static  void Get_All_Data_Spiner_print( String nameh,String decomentone,String ToDate_2, String ToDate_fr, Context context) {
    
          uset_name=decomentone;
    
    
          mList_2.clear();
          RequestQueue queue = Volley.newRequestQueue(context);
          StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    MainActivity4_drop.uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                  try {
                      JSONArray jsonArray = new JSONArray(response);
                    
                    
                      JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                      JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                      //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                      List<String> mListss = new ArrayList<>();
                      List<String> mListss2 = new ArrayList<>();
                      String[] dd = new String[jsonArray_usersS.length()];
                      String[] ddd = new String[jsonArray_usersS.length()];
                      String maness = "";
                      int cnam = 0;
                      int cn = 0;
                      mList.clear();
                      for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        
                        
                        
                        
                        
                          JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                          String iduser = responsS.getString("key_decoment");
                        
                          // int idu= responsS.getInt("id");type
                          String User_name = responsS.getString("name").trim();
                          String Staty = responsS.getString("stat").trim();
                          String Sol = responsS.getString("sol").trim();
                          String date = responsS.getString("date").trim();
                          String datty = responsS.getString("type").trim();
                          String Detils = responsS.getString("detils").trim();
                        
                          // String Type = responsS.getString("type").trim();
                          // dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                        String hdate=dateFormat.format(date);
                        
                          String n=User_name;
                        
                          int sols=Integer.parseInt(Sol);
                          if(sols<0)
                          {
                              sols=sols*-1;
                            
                          }
                        
                        
                          if(Staty.contains("L"))
                          {
                              Staty="معلق";
                            
                          }
                          else  if(Staty.contains("N"))
                        
                          {
                              Staty="مغلي";
                          }
                          else
                            
                              Staty="جاهز";
                        
                          String soll=String.valueOf(sols);
                        
                        
                          // mList.add(new List_All_Users(5));
                          mList_2.add(new List_All_Users(3,Detils, date, soll,datty,Staty,iduser));
                        
                        
                          //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                          //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                      }
                    
                    
                      queue.stop();
                  } catch (JSONException e) {
                      e.printStackTrace();
                  }
                
                
                
                  // ListAdapter     ld = new ListAdapter(context, mList);
                  // listView.setAdapter(ld);
                
                  //   listView.setAdapter(ld);
               
                  IfPrintReport cl = new IfPrintReport(context);
                  cl.createReportDocument(mList_2);
    
              }
            
            
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
              
              
              
              }
          }) {
              @Override
              protected Map<String, String> getParams() throws AuthFailureError {
                  Map<String, String> params = new HashMap<>();
                  //params.put("UserKey", MainActivity.Local_UserKey);
                  params.put("name", nameh);
                  params.put("ToDate", decomentone);
                  params.put("FromDate",ToDate_fr);
                  params.put("ToDate_id", ToDate_2);
                  
                  return params;
              }
          };
          queue.add(stringRequest);
          stringRequest.setShouldCache(false);
        
        
          
      }
    
      public    static  void Get_All_Data_printiess(String nameh, String nameh_id, String decomentone, String ToDate_2, ListView listView, Context context) {
        
        mList_2.clear();
        
          RequestQueue queue = Volley.newRequestQueue(context);
          StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    MainActivity4_drop.uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                  try {
                      JSONArray jsonArray = new JSONArray(response);
                    
                    
                      JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                      JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                      //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                      List<String> mListss = new ArrayList<>();
                      List<String> mListss2 = new ArrayList<>();
                      String[] dd = new String[jsonArray_usersS.length()];
                      String[] ddd = new String[jsonArray_usersS.length()];
                      String maness = "";
                      int cnam = 0;
                      int cn = 0;
                      mList.clear();
                      for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        
                        
                          JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                          String iduser = responsS.getString("key_decoment");
                        
                          // int idu= responsS.getInt("id");type
                          String User_name = responsS.getString("name").trim();
                          String Staty = responsS.getString("stat").trim();
                          String Sol = responsS.getString("sol").trim();
                          String date = responsS.getString("date").trim();
                          String datty = responsS.getString("type").trim();
                          String Detils = responsS.getString("detils").trim();
                        
                          // String Type = responsS.getString("type").trim();
                          // dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                        String hdate=dateFormat.format(date);
                        
                          String n=User_name;
                        
                          int sols=Integer.parseInt(Sol);
                          if(sols<0)
                          {
                              sols=sols*-1;
                            
                          }
                        
                          if(Staty.contains("L"))
                          {
                              Staty="معلق";
                            
                          }
                          else  if(Staty.contains("N"))
                        
                          {
                              Staty="مغلي";
                          }
                          else
                            
                              Staty="جاهز";
                        
                          String soll=String.valueOf(sols);
                        
                        
                          // mList.add(new List_All_Users(5));
                          mList_2.add(new List_All_Users(12,Detils, date, soll,datty,Staty,iduser,User_name));
                        
                        
                          //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                          //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                      }
                    
                    
                      queue.stop();
                  } catch (JSONException e) {
                      e.printStackTrace();
                  }
                
                
                
                  IfPrintReport cl = new IfPrintReport(context);
                  cl.createReportDocument(mList_2);



// قبل استخدام progressDialog، قم بالتحقق من تهيئته
                
                  // listView.setAdapter(ld);
              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
              
              }
          }) {
              @Override
              protected Map<String, String> getParams() throws AuthFailureError {
                  Map<String, String> params = new HashMap<>();
                  //params.put("UserKey", MainActivity.Local_UserKey);
                  params.put("name", nameh);
                  params.put("ToDate", ToDate_2);
                  params.put("FromDate", decomentone);
                  params.put("nameh_id", nameh_id);
                
                  return params;
              }
          };
          queue.add(stringRequest);
          stringRequest.setShouldCache(false);
        
        
      }
    
    
    
    
    
      public  static  void Get_All_Data_Spiner_print_one( String nameh,String decomentone, String nameh_2,String decomento_2,Context context) {
        
          uset_name=decomentone;
        
        
          mList_2.clear();
          RequestQueue queue = Volley.newRequestQueue(context);
          StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    MainActivity4_drop.uri_P_2+"getsearch_user.php", new Response.Listener<String>() {
              @RequiresApi(api = Build.VERSION_CODES.N)
              @Override
              public void onResponse(String response) {
                  try {
                      JSONArray jsonArray = new JSONArray(response);
                    
                    
                      JSONObject jsonResponse = jsonArray.getJSONObject(0);
                    
                    
                      JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_Users");
                    
                    
                      //  Toast.makeText(All_Users_list.this, "Please enter course id"+jsonArray_usersS.length(), Toast.LENGTH_SHORT).show();
                      List<String> mListss = new ArrayList<>();
                      List<String> mListss2 = new ArrayList<>();
                      String[] dd = new String[jsonArray_usersS.length()];
                      String[] ddd = new String[jsonArray_usersS.length()];
                      String maness = "";
                      int cnam = 0;
                      int cn = 0;
                      mList.clear();
                      for (int i = 0; i < jsonArray_usersS.length(); i++) {
                        
                        
                        
                        
                        
                          JSONObject responsS = jsonArray_usersS.getJSONObject(i);
                        
                   
                          // int idu= responsS.getInt("id");type
                          user_id= responsS.getString("id").trim();
                          userr_names = responsS.getString("name").trim();
                          userr_names_datess = responsS.getString("date").trim();
    
                          userr_names_ditais = responsS.getString("detils").trim();
    
    
    
                          // mList.add(new List_All_Users(5));
                          
                        
                        
                          //mList.add List_All_Users(1,"UserKey",User_name,"Email","RegDate","Type_opation","KeyUser","c"));
                        
                          //    mList.add(new List_All_Users(idu,UserKey,User_name,Email,RegDate,Type_opation,KeyUser,"c"));
                        
                        
                      }
                    
                    
                      queue.stop();
                  } catch (JSONException e) {
                      e.printStackTrace();
                  }
    
                  IfPrintReport cl = new IfPrintReport(context);
    
                  cl.PrinReportOne(nameh,userr_names, nameh_2, decomento_2);
    
    
    
              }
            
            
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
              
              
              
              }
          }) {
              @Override
              protected Map<String, String> getParams() throws AuthFailureError {
                  Map<String, String> params = new HashMap<>();
                  //params.put("UserKey", MainActivity.Local_UserKey);
                  params.put("name", "Get_All_Data_Spiner_print_one");
                  params.put("ToDate", decomentone);
                
                  return params;
              }
          };
          queue.add(stringRequest);
          stringRequest.setShouldCache(false);
        
        
        
      }
    
  }

