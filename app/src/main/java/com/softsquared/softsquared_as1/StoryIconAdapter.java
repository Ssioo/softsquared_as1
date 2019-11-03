package com.softsquared.softsquared_as1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.softsquared_as1.Model.StoryIcon;

import java.util.ArrayList;

public class StoryIconAdapter extends RecyclerView.Adapter<StoryIconAdapter.ViewHolder> {
    private ArrayList<StoryIcon> storyIcons;
    private LayoutInflater layoutInflater;

    public StoryIconAdapter(ArrayList<StoryIcon> storyIcons, Context context) {
        this.storyIcons = storyIcons;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.storyicon_item, parent, false);
        StoryIconAdapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvUserId.setText("");
    }

    @Override
    public int getItemCount() {
        return storyIcons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserId;
        ImageView ivProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUserId = itemView.findViewById(R.id.story_profile_id);
            ivProfile = itemView.findViewById(R.id.story_profile_img);

        }
    }
}
