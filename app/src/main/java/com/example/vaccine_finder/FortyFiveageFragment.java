package com.example.vaccine_finder;

import androidx.fragment.app.Fragment;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine_finder.model.VaccineModel;

import java.util.ArrayList;



public class FortyFiveageFragment extends Fragment {

    private RecyclerView fortyfiverecyclerview;
    private LinearLayoutManager linearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_forty_fiveage, container, false);
        ArrayList<VaccineModel> arrayList=((FindVaccine)getActivity()).get45arraylist();
        Log.d("ARR",""+arrayList);
        fortyfiverecyclerview=view.findViewById(R.id.fortyfiverecyclerview);
        VaccineAdapter vaccineAdapter=new VaccineAdapter(getActivity(),arrayList);
        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
             fortyfiverecyclerview.setLayoutManager(linearLayoutManager);
            fortyfiverecyclerview.setAdapter(vaccineAdapter);
        return view;
    }
}
