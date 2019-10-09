package com.softsquared.softsquared_as1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.softsquared.softsquared_as1.Model.Article;
import com.softsquared.softsquared_as1.Model.Comment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Fragment_home extends Fragment {

    private ListView mlvArticles;
    private ArrayList<Article> mArticles = new ArrayList<>();
    private ArticleAdapter articleAdapter;
    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /* findViewById */
        mlvArticles = view.findViewById(R.id.articles);

        /* Article 세팅 - JSON Parsing */
        mArticles = jsonParsing(getJsonString(getActivity()), getActivity());

        /* ListView & Adapter Binding */
        articleAdapter = new ArticleAdapter(mArticles, getActivity());
        mlvArticles.setAdapter(articleAdapter);

        return view;
    }

    private String getJsonString(Context context) {
        String json = "";
        try {
            InputStream is = context.getAssets().open("Articles.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private ArrayList<Article> jsonParsing(String json, Context context) {
        ArrayList<Article> articles = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray articleArray = jsonObject.getJSONArray("Articles");
            Log.d("length", String.valueOf(articleArray.length()));
            for (int i=0; i < articleArray.length(); i++) {
                JSONObject articleObject = articleArray.getJSONObject(i);

                Article article = new Article();

                article.setUserId(articleObject.getString("userId"));
                article.setPlace(articleObject.getString("place"));
                article.setDescription(articleObject.getString("description"));
                article.setDate(articleObject.getString("date"));
                article.setProfile(getResources().getDrawable(getResources().getIdentifier(articleObject.getString("profile"), "drawable", context.getPackageName())));

                JSONArray imgsArray = articleObject.getJSONArray("imgs");
                ArrayList<Drawable> imgs = new ArrayList<>();
                for (int j=0; j<imgsArray.length(); j++) {
                    JSONObject imgsObject = imgsArray.getJSONObject(j);

                    imgs.add(getResources().getDrawable(getResources().getIdentifier(imgsObject.getString("img"), "drawable", context.getPackageName())));
                }
                article.setImgs(imgs);

                JSONArray commentArray = articleObject.getJSONArray("comments");
                ArrayList<Comment> comments = new ArrayList<>();
                for (int j=0; j<commentArray.length(); j++) {
                    JSONObject commentObject = commentArray.getJSONObject(j);

                    Comment comment = new Comment();
                    comment.setUserId(commentObject.getString("userId"));
                    comment.setComments(commentObject.getString("comment"));
                    comment.setFavorited(commentObject.getBoolean("isFavorited"));

                    JSONArray peopleFavoritesArray = commentObject.getJSONArray("favoritesPeople");
                    ArrayList<String> peopleFavorites = new ArrayList<>();
                    for (int k=0; k< peopleFavoritesArray.length(); k++) {
                        JSONObject peopleFavoritesObject = peopleFavoritesArray.getJSONObject(k);

                        peopleFavorites.add(peopleFavoritesObject.getString("userId"));
                    }
                    comment.setPeopleFavorites(peopleFavorites);

                    comments.add(comment);
                }
                article.setComments(comments);

                articles.add(article);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
