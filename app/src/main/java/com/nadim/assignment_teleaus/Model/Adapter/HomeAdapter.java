package com.nadim.assignment_teleaus.Model.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nadim.assignment_teleaus.Model.Data;
import com.nadim.assignment_teleaus.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Data> list;
    private Context context;
    private RecyclerViewClickListener listener;

    public HomeAdapter(List<Data> list, Context context, RecyclerViewClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_adapter_viewholder,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Data data = list.get(position);
        String url = data.getProfile().getAvatar_url();
        String firstName = data.getFirst_name();
        String lastName = data.getLast_name();
        String countryName = data.getProfile().getCountry();
        String type = data.getType();
        String designation = data.getProfile().getExperience();

        holder.profileFirstName.setText(firstName);
        holder.profileLastName.setText(lastName);
        holder.countryName.setText(countryName);
        holder.aboutExpert.setText(type);
        holder.designation.setText(designation);
        Glide.with(context).load(url).into(holder.profileImage);

        ArrayList<String> skill = data.getProfile().getSkills();
        SkillAdapter skillAdapter = new SkillAdapter(context,skill);
        holder.skillRecyclerView.setHasFixedSize(true);
        holder.skillRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        holder.skillRecyclerView.setAdapter(skillAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView profileImage;
        TextView profileFirstName,profileLastName,countryName,aboutExpert,designation;
        RecyclerView skillRecyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Initialise Home adapter viewHolder
            profileImage = itemView.findViewById(R.id.profileImage);
            profileFirstName = itemView.findViewById(R.id.profileFirstName);
            profileLastName = itemView.findViewById(R.id.profileLastName);
            countryName = itemView.findViewById(R.id.countryName);
            aboutExpert = itemView.findViewById(R.id.aboutExpert);
            designation = itemView.findViewById(R.id.designation);
            skillRecyclerView = itemView.findViewById(R.id.skillRecyclerView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }
}
