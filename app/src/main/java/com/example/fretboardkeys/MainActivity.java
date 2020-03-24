package com.example.fretboardkeys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Key_MM> byMM = new ArrayList<>();
    ArrayList<Key> byAcc;

    Fragment mmHeader;
    Fragment mmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initLists();

        mmHeader = MajorMinorHeaderFragment.newInstance();
        mmList = MajorMinorListFragment.newInstance(byMM,this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list,mmList).commit();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.header,mmHeader).commit();

    }

    /*public void initLists(){
        byMM.add(new Key_MM(0,"N/A", "C","A"));
        byMM.add(new Key_MM(1,"Sharps", "G","E"));
        byMM.add(new Key_MM(2,"Sharps", "D","B"));
        byMM.add(new Key_MM(3,"Sharps", "A","F♯"));
        byMM.add(new Key_MM(4,"Sharps", "E","C♯"));
        byMM.add(new Key_MM(5,"Sharps", "B","G♯"));
        byMM.add(new Key_MM(6,"Sharps", "F♯","D♯"));
        byMM.add(new Key_MM(7,"Sharps", "C♯","A♯"));
        byMM.add(new Key_MM(1,"Flats", "F","D"));
        byMM.add(new Key_MM(2,"Flats", "B♭","G"));
        byMM.add(new Key_MM(3,"Flats", "E♭","C"));
        byMM.add(new Key_MM(4,"Flats", "A♭","F"));
        byMM.add(new Key_MM(5,"Flats", "D♭","B♭"));
        byMM.add(new Key_MM(6,"Flats", "G♭","E♭"));
        byMM.add(new Key_MM(7,"Flats", "C♭","A♭"));
    }*/

    //initiates the recycler view with the array of names to be displayed
    private void initRecyclerView(){
        RecyclerView keyList = findViewById(R.id.recyclerview);
        RecyclerAdapter adapter = new RecyclerAdapter(byMM,this);
        keyList.setAdapter(adapter);
        keyList.setLayoutManager(new LinearLayoutManager(this));
    }

}
