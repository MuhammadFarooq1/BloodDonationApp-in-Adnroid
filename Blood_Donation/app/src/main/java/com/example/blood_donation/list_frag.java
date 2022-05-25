package com.example.blood_donation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class list_frag extends Fragment {

   RecyclerView recyclerView;
   RecyclerView.Adapter myAdaper;
   RecyclerView.LayoutManager layoutManager;
  View view;

    public list_frag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_frag, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
          recyclerView = view.findViewById(R.id.listfage);
          recyclerView.setHasFixedSize(true);

          layoutManager = new LinearLayoutManager(this.getActivity());
          recyclerView.setLayoutManager(layoutManager);
        myAdaper = new DonorAdapter(this.getContext() , myApplication.people);
        recyclerView.setAdapter(myAdaper);

    }
    public  void dataChanged()
    {
        myAdaper.notifyDataSetChanged();
    }
}