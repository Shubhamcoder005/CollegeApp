package com.example.collegeapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Report_a_Complaint extends AppCompatActivity {

    TextView Attachment,file_path,file_size;
    ImageView file_image;

    LinearLayout file_layout;
    ImageButton removeFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_acomplaint);

        getSupportActionBar().setTitle("Report a Complaint");

        Attachment=findViewById(R.id.attachment);
        file_image=findViewById(R.id.file_image);
        file_path=findViewById(R.id.file_path);
        file_layout=findViewById(R.id.file_layout);
        file_size=findViewById(R.id.file_size);
        removeFile=findViewById(R.id.removeFile);

        Attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermission()){
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("*/*");
                    intent=Intent.createChooser(intent,"choose file");
                    startActivityForResult(intent,101);
                }else{
                    requestPermission();
                }

            }
        });

        removeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file_layout.setVisibility(View.GONE);
            }
        });
    }

    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(Report_a_Complaint.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(result==PackageManager.PERMISSION_GRANTED){
            return true;
        }else {
            return false;
        }
    }

    private void requestPermission(){
        Toast.makeText(this, "Storage Permission is Requires ,Please allow From Settings", Toast.LENGTH_SHORT).show();
        if(ActivityCompat.shouldShowRequestPermissionRationale(Report_a_Complaint.this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    ActivityCompat.requestPermissions(Report_a_Complaint.this,new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},101 );
                    timer.cancel();
                }
            },0,3000);
        }else{
            ActivityCompat.requestPermissions(Report_a_Complaint.this,new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},101 );
        }
    }

    @SuppressLint("Range")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            if(resultCode==RESULT_OK){
                Uri uri = data.getData();
                file_layout.setVisibility(View.VISIBLE);
                String file_name=null;
                if (uri.getScheme().equals("content")) {
                    Cursor cursor= getContentResolver().query(uri,null,null,null,null);
                    try {

                        if (cursor != null && cursor.moveToFirst()) {
                            file_name=cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                            String filesize= cursor.getString(cursor.getColumnIndex(OpenableColumns.SIZE));
                            long newSize= Long.parseLong(filesize);
                            String uri1= file_name.toString();
                            String extention=uri1.substring(uri1.lastIndexOf("."));
                            file_path.setText(file_name);
//                            file_size.setText(filesize);

                            if(extention.equals(".jpeg") || extention.equals(".jpg")){
                                file_image.setImageResource(R.drawable.jpg_vgrepo_com);
                            }else if(extention.equals(".png")){
                                file_image.setImageResource(R.drawable.png_svgrepo_com);
                            }else if(extention.equals(".pdf")){
                                file_image.setImageResource(R.drawable.pdf_svgrepo_com);
                            }else if(extention.equals(".mp3")){
                                file_image.setImageResource(R.drawable.mp3_svgrepo_com);
                            }else if(extention.equals(".zip")){
                                file_image.setImageResource(R.drawable.zip_svgrepo_com);
                            }else {
                                file_image.setImageResource(R.drawable.baseline_insert_drive_file_24);
                            }

                            if(newSize < 1000 && newSize>0){
                                file_size.setText(filesize+" Bytes");
                            }
                            else if(newSize < 999999 && newSize>0){
                                String a = filesize.substring(0,filesize.length()-3);
                                file_size.setText(a+" KB");
                            }
                            else{
                                String a = filesize.substring(0,filesize.length()-6);
                                file_size.setText(a+" MB");
                            }
                        }
                    }finally {
                        cursor.close();
                    }
                }
//

//                Toast.makeText(this, ex, Toast.LENGTH_SHORT).show();

            }
        }
    }

}