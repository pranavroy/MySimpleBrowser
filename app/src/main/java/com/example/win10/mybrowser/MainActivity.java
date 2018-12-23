package com.example.win10.mybrowser;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    public static final String extra=" ";
    public static final int IMAGE_REQUEST=1;String currentimagepath=null;
    private EditText address;boolean inserted;
    private Button go,google,fb,youtube,saavn,gmail,tutorial,cricbuzz,hotstar,history;database mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        address=(EditText)findViewById(R.id.editText);
        go=(Button)findViewById(R.id.button9);
        google=(Button)findViewById(R.id.button);
        fb=(Button)findViewById(R.id.button2);
        youtube=(Button)findViewById(R.id.button3);
        saavn=(Button)findViewById(R.id.button4);
        gmail=(Button)findViewById(R.id.button6);
        tutorial=(Button)findViewById(R.id.button5);
        cricbuzz=(Button)findViewById(R.id.button8);
        hotstar=(Button)findViewById(R.id.button7);
        history=(Button)findViewById(R.id.button11);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x=address.getText().toString();
               // inserted= mydb.insertdata(x);
                Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(extra,x);
                startActivity(intent);
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String x=address.getText().toString();
                Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(extra,"http://www.google.com");
                startActivity(intent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String x=address.getText().toString();
                Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(extra,"http://www.facebook.com");
                startActivity(intent);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String x=address.getText().toString();
                Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(extra,"http://www.youtube.com");
                startActivity(intent);
            }
        });
        saavn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String x=address.getText().toString();
                Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(extra,"http://www.saavn.com");
                startActivity(intent);
            }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String x=address.getText().toString();
                Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(extra,"http://www.gmail.com");
                startActivity(intent);
            }
        });
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String x=address.getText().toString();
                Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(extra,"http://www.tutorialspoint.com");
                startActivity(intent);
            }
        });
        hotstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String x=address.getText().toString();
               // Toast.makeText(MainActivity.this,"opening please wait",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra("imagepath",currentimagepath);
                startActivity(intent);
            }
        });}
    private File getImageFile()throws IOException{
        String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imagename="jpg"+timestamp+"_";
        File storagedir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File imagefile=File.createTempFile(imagename,".jpg",storagedir);
        currentimagepath=imagefile.getAbsolutePath();
        return imagefile;
    }
    public void capture(View view){
        Intent camera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(camera.resolveActivity(getPackageManager())!=null)
        {
            File imagefile=null;
            try {
                imagefile=getImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(imagefile!=null){
                Uri imageuri= FileProvider.getUriForFile(this,"com.example.android.FileProvider",imagefile);
                camera.putExtra(MediaStore.EXTRA_OUTPUT,imageuri);
                startActivityForResult(camera,IMAGE_REQUEST);
            }
        }


    }
    }
        /*history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res= mydb.getdata();
                if(res.getCount()==0){
                    showmessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buff=new StringBuffer();
                while (res.moveToNext()){
                    buff.append(res.getString(0)+"\n");
                }
                showmessage("Data",buff.toString());
            }
        });}
    public void showmessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }*/



