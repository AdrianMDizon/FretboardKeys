package com.example.fretboardkeys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MajorMinorListFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // Note: Taken from Android Studio's Fragment base
    private static final String DATE = "[Date]";
    private static final String TYPE = "[type]";
    ArrayList<Key_MM> byMM = new ArrayList<>();
    private static Context context;

    public MajorMinorListFragment(){
        //required empty public constructor
    }

    //Note: Taken from Android Studio's Fragment base
    public static MajorMinorListFragment newInstance(ArrayList<Key_MM> byMM, Context context1) {
        MajorMinorListFragment fragment = new MajorMinorListFragment();
        Bundle args = new Bundle();
        context = context1;
        /*args.putString(DATE, param1);
        args.putBoolean("isDate",isDate);
        args.putBoolean("isDOB",isDOB);

        if(isDOB){
            args.putString(TYPE,"birthdate");
        }
        else{
            args.putString(TYPE,"date of first contact");
        }*/

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    //Note: Taken from Android Studio's Fragment base
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            /*dateString = getArguments().getString(DATE);
            dateType = getArguments().getString(TYPE);
            mIs_Date = getArguments().getBoolean("isDate");
            mIsDOB = getArguments().getBoolean("isDOB");*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.major_minor_fragment_layout,container, false);
        TextView firstField, secondField, major, minor;

        initLists();
        initRecyclerView(view);

        firstField = view.findViewById(R.id.majorKeyLetter);
        major = view.findViewById(R.id.majorInd);
        secondField = view.findViewById(R.id.minorKeyLetter);
        minor = view.findViewById(R.id.minorInd);

        /*setOnClick(firstField,view);
        setOnClick(secondField,view);
        setOnClick(major,view);
        setOnClick(minor,view);*/

        /*firstField.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ImageActivity.class);
                startActivity(intent);
            }
        });*/

        initRecyclerView(view);




        return view;
    }

    public void initLists(){
        byMM.add(new Key_MM("0","[N/A]", "C","A"));
        byMM.add(new Key_MM("1","Sharp", "G","E"));
        byMM.add(new Key_MM("2","Sharps", "D","B"));
        byMM.add(new Key_MM("3","Sharps", "A","F♯"));
        byMM.add(new Key_MM("4","Sharps", "E","C♯"));
        byMM.add(new Key_MM("5","Sharps", "B","G♯"));
        byMM.add(new Key_MM("6","Sharps", "F♯","D♯"));
        byMM.add(new Key_MM("7","Sharps", "C♯","A♯"));
        byMM.add(new Key_MM("1","Flat", "F","D"));
        byMM.add(new Key_MM("2","Flats", "B♭","G"));
        byMM.add(new Key_MM("3","Flats", "E♭","C"));
        byMM.add(new Key_MM("4","Flats", "A♭","F"));
        byMM.add(new Key_MM("5","Flats", "D♭","B♭"));
        byMM.add(new Key_MM("6","Flats", "G♭","E♭"));
        byMM.add(new Key_MM("7","Flats", "C♭","A♭"));
    }

    private void initRecyclerView(View view){
        RecyclerView keyList = view.findViewById(R.id.recyclerview);
        System.out.println(byMM.get(0).majorKey);
        RecyclerAdapter adapter = new RecyclerAdapter(byMM, getActivity());
        keyList.setAdapter(adapter);
        keyList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setOnClick(TextView tv, View view){
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ImageActivity.class);
                startActivity(intent);
            }
        });
    }


}
