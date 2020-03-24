package com.example.fretboardkeys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    TextView title;
    ImageView fretboard;
    ArrayList<Key_MM> keysMM = new ArrayList<>();
    int index;
    boolean isMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String titleBuf="";
        String resourceBuf="";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fretboard_image);
        Intent intent = getIntent();
        intent.getExtras();

        Bundle args = intent.getExtras();
        keysMM = (ArrayList<Key_MM>) args.getSerializable("key");
        index = args.getInt("pos");
        isMajor = args.getBoolean("isMajor");

        String letter;
        String type = keysMM.get(index).accType;
        Boolean isSharp;

        if(type.substring(0,type.length()-1).equals("Sharp")){
            isSharp = true;
        }
        else{
            isSharp = false;
        }

        if(isMajor){
            letter = keysMM.get(index).majorKey;
            titleBuf += letter;
            titleBuf += " Major";
            resourceBuf += letter.substring(0,1).toLowerCase();

            if(letter.length() > 1 && isSharp){
                resourceBuf += "s";
            }
            else if(letter.length() > 1 && !isSharp){
                resourceBuf += "b";
            }

            resourceBuf += "_major";
        }
        else if(!isMajor){
            letter = keysMM.get(index).minorKey;
            titleBuf += letter;
            titleBuf += " Minor";
            resourceBuf += letter.substring(0,1).toLowerCase();

            if(letter.length() > 1 && isSharp){
                resourceBuf += "s";
            }
            else if(letter.length() > 1 && !isSharp){
                resourceBuf += "b";
            }

            resourceBuf += "_minor";
        }

        title = findViewById(R.id.title);
        title.setText(titleBuf);

        fretboard = findViewById(R.id.imageView);
        setImage(resourceBuf);

    }

    private void setImage(String name){
        switch(name){
            case "a_major":
                fretboard.setImageResource(R.drawable.a_major);
                break;
            case "a_minor":
                fretboard.setImageResource(R.drawable.a_minor);
                break;
            case "ab_major":
                fretboard.setImageResource(R.drawable.ab_major);
                break;
            case "ab_minor":
                fretboard.setImageResource(R.drawable.ab_minor);
                break;
            case "as_minor":
                fretboard.setImageResource(R.drawable.as_minor);
                break;
            case "b_major":
                fretboard.setImageResource(R.drawable.b_major);
                break;
            case "b_minor":
                fretboard.setImageResource(R.drawable.b_minor);
                break;
            case "bb_major":
                fretboard.setImageResource(R.drawable.bb_major);
                break;
            case "bb_minor":
                fretboard.setImageResource(R.drawable.bb_minor);
                break;
            case "c_major":
                fretboard.setImageResource(R.drawable.c_major);
                break;
            case "c_minor":
                fretboard.setImageResource(R.drawable.c_minor);
                break;
            case "cb_major":
                fretboard.setImageResource(R.drawable.cb_major);
                break;
            case "cs_major":
                fretboard.setImageResource(R.drawable.cs_major);
                break;
            case "cs_minor":
                fretboard.setImageResource(R.drawable.cs_minor);
                break;
            case "d_major":
                fretboard.setImageResource(R.drawable.d_major);
                break;
            case "d_minor":
                fretboard.setImageResource(R.drawable.d_minor);
                break;
            case "db_major":
                fretboard.setImageResource(R.drawable.db_major);
                break;
            case "ds_minor":
                fretboard.setImageResource(R.drawable.ds_minor);
                break;
            case "e_major":
                fretboard.setImageResource(R.drawable.e_major);
                break;
            case "e_minor":
                fretboard.setImageResource(R.drawable.e_minor);
                break;
            case "eb_major":
                fretboard.setImageResource(R.drawable.eb_major);
                break;
            case "eb_minor":
                fretboard.setImageResource(R.drawable.eb_minor);
                break;
            case "f_major":
                fretboard.setImageResource(R.drawable.f_major);
                break;
            case "f_minor":
                fretboard.setImageResource(R.drawable.f_minor);
                break;
            case "fs_major":
                fretboard.setImageResource(R.drawable.fs_major);
                break;
            case "fs_minor":
                fretboard.setImageResource(R.drawable.fs_minor);
                break;
            case "g_major":
                fretboard.setImageResource(R.drawable.g_major);
                break;
            case "g_minor":
                fretboard.setImageResource(R.drawable.g_minor);
                break;
            case "gb_major":
                fretboard.setImageResource(R.drawable.gb_major);
                break;
            case "gs_minor":
                fretboard.setImageResource(R.drawable.gs_minor);
                break;
            default:
                break;
        }
    }
}
