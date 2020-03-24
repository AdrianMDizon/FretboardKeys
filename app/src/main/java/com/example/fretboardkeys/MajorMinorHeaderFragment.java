package com.example.fretboardkeys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MajorMinorHeaderFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // Note: Taken from Android Studio's Fragment base
    private static final String DATE = "[Date]";
    private static final String TYPE = "[type]";

    public MajorMinorHeaderFragment(){
        //required empty public constructor
    }

    //Note: Taken from Android Studio's Fragment base
    public static MajorMinorHeaderFragment newInstance() {
        MajorMinorHeaderFragment fragment = new MajorMinorHeaderFragment();
        Bundle args = new Bundle();
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
        View view = inflater.inflate(R.layout.major_minor_header_layout,container, false);

        return view;
    }
}
