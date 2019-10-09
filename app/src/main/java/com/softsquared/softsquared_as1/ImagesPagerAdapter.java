package com.softsquared.softsquared_as1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ImagesPagerAdapter extends PagerAdapter {
    private ArrayList<Drawable> imgs;
    private LayoutInflater inflater;

    public ImagesPagerAdapter(ArrayList<Drawable> imgs, Context context) {
        this.imgs = imgs;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (View) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView newImg = new ImageView(container.getContext());
        newImg.setImageDrawable(imgs.get(position));
        newImg.setLayoutParams(layoutParams);
        newImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(newImg);
        return newImg;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.invalidate();
    }


}
