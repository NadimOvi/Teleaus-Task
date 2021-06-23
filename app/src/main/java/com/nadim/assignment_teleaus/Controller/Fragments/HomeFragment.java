package com.nadim.assignment_teleaus.Controller.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nadim.assignment_teleaus.Api.Client;
import com.nadim.assignment_teleaus.Api.Service;
import com.nadim.assignment_teleaus.Controller.ProfileActivity;
import com.nadim.assignment_teleaus.Model.Adapter.HomeAdapter;
import com.nadim.assignment_teleaus.Model.Data;
import com.nadim.assignment_teleaus.Model.MainModel;
import com.nadim.assignment_teleaus.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView homeAdapterRecycler;
    private HomeAdapter.RecyclerViewClickListener listener;
    private ProgressDialog progressDialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        defineViews(view);
        progressDialog.show();
        dataLoad();
        return view;
    }

    private void defineViews(View view) {

        //Initialise
        homeAdapterRecycler = view.findViewById(R.id.homeAdapterRecycler);
        homeAdapterRecycler.setHasFixedSize(true);
        homeAdapterRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
    }

    private void dataLoad() {
        Service service = Client.retrofit.create(Service.class);
        Call<MainModel> call = service.getData();
        call.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    List<Data> data = response.body().getData();

                    adapterView(data);

                }else{
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Failed To access", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void adapterView(List<Data> list) {
        setOnClickListener(list);
        HomeAdapter homeAdapter = new HomeAdapter(list,getContext(),listener);

        homeAdapterRecycler.setAdapter(homeAdapter);
    }

    private void setOnClickListener(final List<Data> list) {
        listener = new HomeAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                intent.putExtra("firstName", list.get(position).getFirst_name());
                intent.putExtra("lastName", list.get(position).getLast_name());
                intent.putExtra("companyName", list.get(position).getProfile().getCompany_name());
                intent.putExtra("profileImageShow", list.get(position).getProfile().getAvatar_url());
                intent.putExtra("experience", list.get(position).getProfile().getExperience());
                intent.putExtra("coverLetter", list.get(position).getProfile().getCover_letter());
                intent.putExtra("qualification", list.get(position).getProfile().getQualification());
                intent.putExtra("phoneNumber", list.get(position).getProfile().getPhone());
                intent.putExtra("email", list.get(position).getEmail());
                intent.putExtra("location", list.get(position).getProfile().getLocation());
                startActivity(intent);

                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            }
        };
    }


}
