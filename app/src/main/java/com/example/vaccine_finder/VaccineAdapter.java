package com.example.vaccine_finder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine_finder.model.VaccineModel;

import java.util.ArrayList;


public class VaccineAdapter extends RecyclerView.Adapter<VaccineAdapter.Viewholder> {
    @NonNull
    private Context context;
    private ArrayList<VaccineModel> ageArraylist;
    public VaccineAdapter(Context context, ArrayList<VaccineModel> arrayList) {
        this.context = context;
        this.ageArraylist = arrayList;
    }
    public VaccineAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VaccineAdapter.Viewholder holder, int position) {
            holder.vaccine_center_name.setText(ageArraylist.get(position).getHospital_name());
            holder.vaccine_dose_name.setText(ageArraylist.get(position).getVaccine_Name());
            holder.dose_1_capacity.setText(String.valueOf(ageArraylist.get(position).getDose1_capacity()));
            holder.dose_2_capacity.setText(String.valueOf(ageArraylist.get(position).getDose2_capacity()));
            holder.from_time.setText(ageArraylist.get(position).getAvailable_from());
            holder.to_time.setText(ageArraylist.get(position).getAvailable_till());
            holder.fees.setText(ageArraylist.get(position).getFee());
            if(ageArraylist.get(position).getDose1_capacity()>0||ageArraylist.get(position).getDose2_capacity()>0){
                holder.VaccineCard.setCardBackgroundColor(Color.parseColor("#a5e1ad"));
            }
            else{
                holder.VaccineCard.setCardBackgroundColor(Color.parseColor("#f5c0c0"));
            }
    }

    @Override
    public int getItemCount() {
        return ageArraylist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView vaccine_center_name;
        private TextView vaccine_dose_name;
        private TextView dose_1_capacity;
        private TextView dose_2_capacity;
        private TextView from_time;
        private TextView to_time;
        private TextView fees;
        private CardView VaccineCard;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            vaccine_center_name=itemView.findViewById(R.id.vaccine_center_name);
            vaccine_dose_name=itemView.findViewById(R.id.vaccine_name);
            dose_1_capacity=itemView.findViewById(R.id.Dose1_capacity_text);
            dose_2_capacity=itemView.findViewById(R.id.Dose2capacitytext);
            from_time=itemView.findViewById(R.id.fromtext);
            to_time=itemView.findViewById(R.id.totext);
            fees=itemView.findViewById(R.id.rupeetext);
            VaccineCard=itemView.findViewById(R.id.cardViewLayout);
        }
    }
}
