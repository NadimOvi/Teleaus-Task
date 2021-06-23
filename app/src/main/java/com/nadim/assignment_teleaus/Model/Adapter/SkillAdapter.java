package com.nadim.assignment_teleaus.Model.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nadim.assignment_teleaus.R;

import java.util.ArrayList;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {
    private Context context;
    ArrayList<String> list;
    public SkillAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.skill_adapter_viewholder,viewGroup,false);
        return new SkillAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final String skills = list.get(position);
        holder.skillName.setText(skills);

        if (position %3 ==0 ){
            holder.hash.setTextColor(Color.parseColor("#62D9A2"));
            holder.skillName.setTextColor(Color.parseColor("#62D9A2"));
        }else if(position %3 ==1){
            holder.hash.setTextColor(Color.parseColor("#48C7EC"));
            holder.skillName.setTextColor(Color.parseColor("#48C7EC"));
        }else if(position %3 == 2){
            holder.hash.setTextColor(Color.parseColor("#3C587B"));
            holder.skillName.setTextColor(Color.parseColor("#3C587B"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hash,skillName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Initialise Skill adapter viewHolder
            hash = itemView.findViewById(R.id.hash);
            skillName = itemView.findViewById(R.id.skillName);
        }
    }
}
