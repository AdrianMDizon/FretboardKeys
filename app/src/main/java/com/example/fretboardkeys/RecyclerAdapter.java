package com.example.fretboardkeys;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    /*
    This class is an implementation of the RecyclerView Adapter that allows the contact list to be shown in the recyclerview
     */

    //TODO: Set click listeners for the rest of the textview objects
    //TODO: Change the image that is displayed based on what was clicked

    private ArrayList<Key_MM> keysMM;
    private ArrayList<String> numStrings;
    //private ArrayList<Contact> contacts;
    private Context context;
    //private ContactIO io;
    private String mAccNum, mAccType, mMajor, mMinor;

    //constructor
    RecyclerAdapter(ArrayList<Key_MM> byMM, Context context){
        this.keysMM = byMM;
        //this.contacts = contacts;
        this.context = context;
        //this.io = io;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creates the holder that will hold all of the items to be recycled
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.major_minor_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        mAccNum = keysMM.get(position).accNum;
        mAccType = keysMM.get(position).accType;
        mMajor = keysMM.get(position).majorKey;
        mMinor = keysMM.get(position).minorKey;

        holder.accNum.setText(mAccNum);
        holder.accType.setText(mAccType);
        holder.majorKeyLetter.setText(mMajor);
        holder.minorKeyLetter.setText(mMinor);

        int currentPos = holder.getAdapterPosition();

        setOnClick(holder.majorKeyLetter, true, currentPos);
        setOnClick(holder.minorKeyLetter,false, currentPos);

    }

    @Override
    public int getItemCount() {
        return keysMM.size();
    }

    //viewholder implementation
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView accNum;
        TextView accType;
        TextView majorKeyLetter;
        TextView minorKeyLetter;
        ConstraintLayout listLayout;

        //constructor that takes the name field and layout for the recycler view
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            listLayout = itemView.findViewById(R.id.majorMinorLayout);
            accNum = itemView.findViewById(R.id.accNum);
            accType = itemView.findViewById(R.id.accType);
            majorKeyLetter = itemView.findViewById(R.id.majorKeyLetter);
            minorKeyLetter = itemView.findViewById(R.id.minorKeyLetter);
        }
    }

    private void setOnClick(TextView tv, final boolean isMajor, final int currentPos){

        tv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ImageActivity.class);
                intent.putExtra("key",keysMM);
                intent.putExtra("pos",currentPos);
                intent.putExtra("isMajor", isMajor);
                context.startActivity(intent);
            }
        });
    }
}