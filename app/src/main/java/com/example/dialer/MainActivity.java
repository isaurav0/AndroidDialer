package com.example.dialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity{

    private EditText edit_display;
    private ImageButton backspace;
    int j= 0;
    Button[] btn = new Button[13];
    ImageButton call_button;
    String phone_number = "";



    public void initialize(){
        btn[0] = findViewById(R.id.btn_0);
        btn[1] = findViewById(R.id.btn_1);
        btn[2] = findViewById(R.id.btn_2);
        btn[3] = findViewById(R.id.btn_3);
        btn[4] = findViewById(R.id.btn_4);
        btn[5] = findViewById(R.id.btn_5);
        btn[6] = findViewById(R.id.btn_6);
        btn[7] = findViewById(R.id.btn_7);
        btn[8] = findViewById(R.id.btn_8);
        btn[9] = findViewById(R.id.btn_9);
        btn[10] = findViewById(R.id.btn_ast);
        btn[11] = findViewById(R.id.btn_hash);
        backspace = findViewById(R.id.btn_back);
        edit_display = findViewById(R.id.edit_display);
        call_button = findViewById(R.id.call_btn);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();



        //backspace
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                erase();
            }
        });


        //buttons
        for(int i=0;i<12;i++)
        {
            j=i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Clicked(v.getId());
                }
            });
        }

        //ontouch
        edit_display.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+phone_number));
                startActivity(intent);
                phone_number = "";
                edit_display.setText(phone_number);
            }
        });


    }


    void Clicked(int id){
        Button click = (Button)findViewById(id);
        String num = click.getText().toString();
        phone_number += num;
        edit_display.setText(phone_number);
    }


    void erase(){
        try{
            phone_number = phone_number.substring(0, phone_number.length()-1);
            edit_display.setText(phone_number);
        }
        catch(Exception e){

        }
    }
}


