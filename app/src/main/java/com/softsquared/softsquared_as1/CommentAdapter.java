package com.softsquared.softsquared_as1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.softsquared.softsquared_as1.Model.Comment;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {
    private ArrayList<Comment> comments;
    private LayoutInflater layoutInflater;

    public CommentAdapter(ArrayList<Comment> comments, Context context) {
        this.comments = comments;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.comment_item, parent, false);

            viewHolder = new ViewHolder();
            /* findViewById */
            viewHolder.tvCommentUserId = convertView.findViewById(R.id.nickname_comment);
            viewHolder.tvComment = convertView.findViewById(R.id.comment_description);
            viewHolder.ivHeart = convertView.findViewById(R.id.favorite_on_comment);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Comment comment = comments.get(position);
        if (comment != null) {
            viewHolder.tvCommentUserId.setText(comment.getUserId());
            viewHolder.tvComment.setText(comment.getComments());
        }
        return convertView;
    }

    private static class ViewHolder {
        private TextView tvCommentUserId;
        private TextView tvComment;
        private ImageView ivHeart;
    }
}
