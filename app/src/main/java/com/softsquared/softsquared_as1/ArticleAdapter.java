package com.softsquared.softsquared_as1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.softsquared_as1.Model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends BaseAdapter {

    private ArrayList<Article> ArticleList;
    private LayoutInflater layoutInflater;

    public ArticleAdapter(ArrayList<Article> articleList, Context context) {
        ArticleList = articleList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ArticleList.size();
    }

    @Override
    public Object getItem(int position) {
        return ArticleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.post_full, parent, false);

            /* ViewHolder */
            holder = new ViewHolder();
            /* findViewByID */
            holder.ivProfileImg = convertView.findViewById(R.id.profile_img);
            holder.vpImages = convertView.findViewById(R.id.image_pager);
            holder.tvImgCount = convertView.findViewById(R.id.img_count);
            holder.tvNickname = convertView.findViewById(R.id.nickname);
            holder.tvPlace = convertView.findViewById(R.id.place);
            holder.tvDescription = convertView.findViewById(R.id.description_full);
            holder.tvFavoritePerson = convertView.findViewById(R.id.nickname_like1);
            holder.tvFavoriteCount = convertView.findViewById(R.id.like_count);
            holder.tvDate = convertView.findViewById(R.id.date_of_article);
            holder.tvMoreComments = convertView.findViewById(R.id.more_comment);
            holder.lvComments = convertView.findViewById(R.id.comment_container);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        /* Loading Article */
        final Article article = ArticleList.get(position);
        if (article != null) {
            /* View 조정 */
            holder.tvNickname.setText(article.getUserId()); // UserId
            if (article.getPlace().equals("")) {
                holder.tvPlace.setTextSize(0.f);
            }
            holder.tvPlace.setText(article.getPlace()); // Place
            holder.ivProfileImg.setImageDrawable(article.getProfile());// Profile
            holder.imagesPagerAdapter = new ImagesPagerAdapter(article.getImgs(), convertView.getContext());
            holder.vpImages.setAdapter(holder.imagesPagerAdapter); // Imgs
            holder.vpImages.setCurrentItem(holder.imgShowing);
            holder.tvImgCount.setText(holder.vpImages.getCurrentItem() + 1 + "/" + article.getImgs().size());// Img Count
            holder.vpImages.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    holder.tvImgCount.setText(position + 1 + "/" + article.getImgs().size());// Img Count
                    holder.imgShowing = position;
                }
            });
            holder.tvDescription.setText(article.getUserId() + " " + article.getDescription()); // Description

            // Comments
            if (article.getComments() != null) {
                holder.tvFavoritePerson.setText(article.getComments().get(0).getUserId());
                holder.tvFavoriteCount.setText(article.getComments().size() + "명");
                if (article.getComments().size() > 2)
                    holder.tvMoreComments.setText("댓글 " + (article.getComments().size() - 2) + "개 더보기");
                else
                    holder.tvMoreComments.setVisibility(View.GONE);
                // Comment ListView
                Log.i("commentSize", String.valueOf(article.getComments().size()));
                holder.commentAdapter = new CommentAdapter(article.getComments(), convertView.getContext());
                holder.lvComments.setAdapter(holder.commentAdapter);
            } else {
                holder.tvFavoritePerson.setVisibility(View.GONE);
                holder.tvFavoriteCount.setVisibility(View.GONE);
            }
            holder.tvDate.setText(article.getDate()); // Date
        }
        return convertView;
    }

    private static class ViewHolder {
        private ImageView ivProfileImg;
        private ImagesPagerAdapter imagesPagerAdapter;
        private int imgShowing = 0;
        private ViewPager vpImages;
        private TextView tvNickname;
        private TextView tvPlace;
        private TextView tvDescription;
        private TextView tvFavoritePerson;
        private TextView tvFavoriteCount;
        private TextView tvDate;
        private TextView tvImgCount;
        private ListView lvComments;
        private TextView tvMoreComments;
        private CommentAdapter commentAdapter;
    }
}
