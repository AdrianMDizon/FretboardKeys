package com.example.fretboardkeys;

import android.content.Context;
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

    private ArrayList<Key_MM> keysMM;
    private ArrayList<String> numStrings;
    //private ArrayList<Contact> contacts;
    private Context context;
    //private ContactIO io;

    //constructor
    RecyclerAdapter(ArrayList<Key_MM> byMM){
        this.keysMM = byMM;
        //this.contacts = contacts;
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
        holder.accNum.setText(keysMM.get(position).accNum);
        holder.accType.setText(keysMM.get(position).accType);
        holder.majorKeyLetter.setText(keysMM.get(position).majorKey);
        holder.minorKeyLetter.setText(keysMM.get(position).minorKey);

        final int currentPos = holder.getAdapterPosition();

        //when a contact name is clicked, sends the user to view the contact details (new activity)
        holder.listLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //sends a Contact object, current index, names ArrayList, and boolean to the 2nd activity
                /*Intent intent = new Intent(context, DetailedContactsActivity.class);
                intent.putExtra("contact",contacts.get(currentPos));
                intent.putExtra("index",currentPos);
                intent.putExtra("existing",true);
                intent.putExtra("nameList",names);

                context.startActivity(intent);*/
            }
        });

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
}