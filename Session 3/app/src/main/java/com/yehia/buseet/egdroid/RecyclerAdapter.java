package com.yehia.buseet.egdroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private List<Data> myList;
    private Context mContext;
    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<Data> list, Context context, OnItemClickListener listener) {
        this.myList = list;
        this.mContext = context;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, final int position) {
        holder.bind(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.myList.size();
    }


    class RecyclerHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private LinearLayout root;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            imageView = itemView.findViewById(R.id.item_img);
            textView = itemView.findViewById(R.id.item_text);
        }

        void bind(final Data data) {
            textView.setText(data.getName());
            imageView.setImageResource(data.getImgId());

            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(data);
                }
            });
        }
    }
}
