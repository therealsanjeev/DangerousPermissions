package com.example.dangerouspermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.button);
        editText= findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int prem= ContextCompat.checkSelfPermission(
                        MainActivity.this, Manifest.permission.CALL_PHONE
                );
                if(prem== PackageManager.PERMISSION_GRANTED){
                    callPhone();
                }else{
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{
                                    Manifest.permission.CALL_PHONE
                            },121

                    );
                }


            }
        });
    }
    void callPhone(){

        String telNo=editText.getText().toString();
        Uri uri= Uri.parse("tel:"+telNo);
        Intent i= new Intent(Intent.ACTION_CALL,uri);
        startActivity(i);
    }
}
