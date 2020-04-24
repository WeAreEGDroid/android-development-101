package com.yehia.buseet.egdroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.callback.OnPostActionListener;
import com.yehia.buseet.egdroid.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {


    private List<Post> postList;
    private Context mContext;
    private OnPostActionListener onPostActionListener;

    public PostAdapter(List<Post> postList, Context mContext, OnPostActionListener listener) {
        this.postList = postList;
        this.mContext = mContext;
        this.onPostActionListener = listener;
    }

    @NonNull
    @Override
    public PostAdapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(mContext).inflate(R.layout.item_posts, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostHolder holder, int position) {
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {

        private TextView titleTV;
        private TextView descriptionTV;
        private View root;


        public PostHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
            root = itemView.findViewById(R.id.root);
        }

        public void bind(Post post) {
            titleTV.setText(post.getTitle());
            descriptionTV.setText(post.getDescription());

            root.setOnLongClickListener(v -> {
                onPostActionListener.onPostLongClicked(post);
                return true;
            });
        }
    }
}
