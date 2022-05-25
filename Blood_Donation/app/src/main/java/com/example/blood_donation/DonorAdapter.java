package com.example.blood_donation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.ViewHolder> {
    ArrayList<Person> people;
  ItemSelected activity;

    public  interface ItemSelected
    {
        void  onItemClicked(int index);
    }
    public  DonorAdapter(Context context, ArrayList<Person>list)
    {
         activity = (ItemSelected) context;
            people = list;
    }
    public  class  ViewHolder extends RecyclerView.ViewHolder {
        TextView rtxt_name;
        TextView rtxt_group;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rtxt_name = itemView.findViewById(R.id.rtxt_name);
            rtxt_group = itemView.findViewById(R.id.rtxt_group);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClicked(people.indexOf((Person) itemView.getTag()));

                }
            });

        }
    }

    @NonNull
    @Override
    public DonorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DonorAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.rtxt_name.setText(people.get(position).getD_Name());
        holder.rtxt_group.setText(people.get(position).getD_bgroup());
    }

    @Override
    public int getItemCount() {

        return people.size();
    }
}
