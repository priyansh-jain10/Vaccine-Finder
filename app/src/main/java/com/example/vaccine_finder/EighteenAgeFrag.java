package com.example.vaccine_finder;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine_finder.model.AgeArrayListModel;
import com.example.vaccine_finder.model.VaccineModel;

import java.util.ArrayList;


public class EighteenAgeFrag extends Fragment {

    private RecyclerView eighteenrecyclerview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_eighteen_age, container, false);
        ArrayList<VaccineModel> arrayList=((FindVaccine)getActivity()).get18arraylisr();
        VaccineAdapter vaccineAdapter=new VaccineAdapter(getActivity(),arrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        eighteenrecyclerview=view.findViewById(R.id.eighteenrecyclerview);
        eighteenrecyclerview.setLayoutManager(linearLayoutManager);
        eighteenrecyclerview.setAdapter(vaccineAdapter);
        return view;
    }


}
