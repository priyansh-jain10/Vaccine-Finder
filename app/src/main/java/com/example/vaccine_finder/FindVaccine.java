package com.example.vaccine_finder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.vaccine_finder.model.AgeArrayListModel;
import com.example.vaccine_finder.model.VaccineModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FindVaccine extends AppCompatActivity {
    private String pincode;
    private String date;
    private String url;
    private ArrayList<VaccineModel> Vaccine_45;
    private ArrayList<VaccineModel> Vaccine_18;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_vaccine);
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.d("FINDVACCINE", "unable to load bundle from getIntent()");
            } else {
                pincode = getIntent().getExtras().getString("Pin Code");
                date = getIntent().getExtras().getString("Date");
            }

            Log.d("FINDVACCINE","Pincode:"+pincode+"\n"+"Date:"+date);


        url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+pincode+"&date="+date;
         Vaccine_18=new ArrayList<>();
         Vaccine_45=new ArrayList<>();
        final AgeArrayListModel ageArrayListModel=new AgeArrayListModel();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("LOADRESPONSE", "onResponse: "+response.toString());

                        try {
                            JSONArray jsonArray=response.getJSONArray("sessions");
                            //String center=jsonArray.getJSONObject(1).getString("name");
                            for(int i=0;i<jsonArray.length();i++){
                                if(jsonArray.getJSONObject(i).getInt("min_age_limit")==18){
                                    VaccineModel vaccineModel=new VaccineModel();
                                    vaccineModel.setHospital_name(jsonArray.getJSONObject(i).getString("name"));
                                    vaccineModel.setAddress(jsonArray.getJSONObject(i).getString("address"));
                                    vaccineModel.setDistrict(jsonArray.getJSONObject(i).getString("district_name"));
                                    vaccineModel.setMinagelimit(jsonArray.getJSONObject(i).getInt("min_age_limit"));
                                    vaccineModel.setVaccine_Name(jsonArray.getJSONObject(i).getString("vaccine"));
                                    vaccineModel.setAvailable_from(jsonArray.getJSONObject(i).getString("from"));
                                    vaccineModel.setAvailable_till(jsonArray.getJSONObject(i).getString("to"));
                                    vaccineModel.setFee(jsonArray.getJSONObject(i).getString("fee"));
                                    vaccineModel.setDose1_capacity(jsonArray.getJSONObject(i).getInt("available_capacity_dose1"));
                                    vaccineModel.setDose2_capacity(jsonArray.getJSONObject(i).getInt("available_capacity_dose2"));
                                    Vaccine_18.add(vaccineModel);
                                    ageArrayListModel.setEighteenyearsAL(Vaccine_18);
                                }
                                if(jsonArray.getJSONObject(i).getInt("min_age_limit")==45){
                                    VaccineModel vaccineModel=new VaccineModel();
                                    vaccineModel.setHospital_name(jsonArray.getJSONObject(i).getString("name"));
                                    vaccineModel.setAddress(jsonArray.getJSONObject(i).getString("address"));
                                    vaccineModel.setDistrict(jsonArray.getJSONObject(i).getString("district_name"));
                                    vaccineModel.setMinagelimit(jsonArray.getJSONObject(i).getInt("min_age_limit"));
                                    vaccineModel.setVaccine_Name(jsonArray.getJSONObject(i).getString("vaccine"));
                                    vaccineModel.setAvailable_from(jsonArray.getJSONObject(i).getString("from"));
                                    vaccineModel.setAvailable_till(jsonArray.getJSONObject(i).getString("to"));
                                    vaccineModel.setFee(jsonArray.getJSONObject(i).getString("fee"));
                                    vaccineModel.setDose1_capacity(jsonArray.getJSONObject(i).getInt("available_capacity_dose1"));
                                    vaccineModel.setDose2_capacity(jsonArray.getJSONObject(i).getInt("available_capacity_dose2"));
                                    Vaccine_45.add(vaccineModel);
                                    ageArrayListModel.setFortyfiveAL(Vaccine_45);
                                }
                                Log.d("JSONResult",jsonArray.getJSONObject(i).getString("name"));
                            }

                            Log.d("VACCINE18","Vaccine for above 18"+Vaccine_18.toString());
                            Log.d("VACCINE45","Vaccine for above 18"+Vaccine_45.toString());

                            Log.d("FindCenterr", "onResponse: "+jsonArray.toString()+"\n"+jsonArray);
                        } catch (JSONException e) {
                            Log.d("JSONERROR","JSONException"+e.toString());
                        }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.d("LOADRESPONSE" ,"onErrorResponse: Something went wrong"+error);
                    }
                });
        queue.add(jsonObjectRequest);
        SetupViewPager();
//        BottomNavigationView bottomNavigationView =findViewById(R.id.ageGroupnavView);
//        getFragmentManager().beginTransaction().replace(R.id.ageGrouplayout, new EighteenAgeFrag()).commit();
//        bottomNavigationView.setOnNavigationItemSelectedListener(onNav);


    }
    public ArrayList<VaccineModel> get18arraylisr(){
        return Vaccine_18;
    }
    public ArrayList<VaccineModel> get45arraylist(){
        return Vaccine_45;
    }


    //Use of Botttom Naviview to switch between fragments later change to view Pager
//    private BottomNavigationView.OnNavigationItemSelectedListener onNav = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selected = null;
//            switch (item.getItemId()) {
//                case R.id.eighteen:
//                    selected = new EighteenAgeFrag();
//                    Log.d("AGENAVBAR","18+ selected");
//                    break;
//                case R.id.fortyfive:
//                    selected = new FortyFiveageFragment();
//                    Log.d("AGENAVBAR","45+ selected");
//                    break;
//            }
//            getFragmentManager().beginTransaction().replace(R.id.ageGrouplayout, selected).commit();
//            Log.d("ProfileNavigation Tests","Fragment is now replaced");
//            return true;
//        }
//    };
    private  void SetupViewPager(){
        SectionsPagerAdapter sectionsPagerAdapter=new SectionsPagerAdapter(getSupportFragmentManager(),2);
        viewPager=findViewById(R.id.view_pager_container);
        tabLayout=findViewById(R.id.tabBottom);
        // CreateNewFragment(new GalleryShareFragment(),"Gallery",0)
        sectionsPagerAdapter.addFrafment(new EighteenAgeFrag());
        sectionsPagerAdapter.addFrafment(new FortyFiveageFragment());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("18-44");
        tabLayout.getTabAt(1).setText("45+");

    }
}
