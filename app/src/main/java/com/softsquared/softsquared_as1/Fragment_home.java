package com.softsquared.softsquared_as1;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_home extends Fragment {

    private ImageView profile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /* findViewById */
        profile = view.findViewById(R.id.profile);


        /* profile */
        profile.setBackground(new ShapeDrawable(new OvalShape()));
        profile.setClipToOutline(true);

        return view;
    }
}
