package com.softsquared.softsquared_as1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.softsquared.softsquared_as1.Model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends BaseAdapter {

    private ArrayList<Article> ArticleList;
    private LayoutInflater layoutInflater;

    private ImageView ivProfileImg;
    private FrameLayout flImages;
    private ViewPager vpImages;
    private TextView tvNickname;
    private TextView tvPlace;
    private TextView tvDescription;
    private TextView tvFavoritePerson;
    private TextView tvFavoriteCount;
    private TextView tvDate;

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
        convertView = layoutInflater.inflate(R.layout.post_full, parent, false);

        /* Loading Article */
        Article article = ArticleList.get(position);
        if (article == null) {
            return convertView;
        }
        /* findViewByID */
        ivProfileImg = convertView.findViewById(R.id.profile_img);
        flImages = convertView.findViewById(R.id.image_container);
        vpImages = convertView.findViewById(R.id.image_pager);
        tvNickname = convertView.findViewById(R.id.nickname);
        tvPlace = convertView.findViewById(R.id.place);
        tvDescription = convertView.findViewById(R.id.description_full);
        tvFavoritePerson = convertView.findViewById(R.id.nickname_like1);
        tvFavoriteCount = convertView.findViewById(R.id.like_count);
        tvDate = convertView.findViewById(R.id.date_of_article);


        /* View 조정 */
        tvNickname.setText(article.getUserId()); // UserId
        tvPlace.setText(article.getPlace()); // Place
        ivProfileImg.setImageDrawable(article.getProfile());// Profile
        // Imgs
        vpImages.setAdapter(new ImagesPagerAdapter(article.getImgs(), convertView.getContext()));
        tvDescription.setText(article.getUserId() + " " + article.getDescription()); // Description
        // Comments
        if (article.getComments() != null) {
            tvFavoritePerson.setText(article.getComments().get(0).getUserId());
            tvFavoriteCount.setText(article.getComments().size() + "명");
        } else {
            tvFavoritePerson.setText("");
            tvFavoriteCount.setText("");
        }
        tvDate.setText(article.getDate()); // Date


        return convertView;
    }
}
