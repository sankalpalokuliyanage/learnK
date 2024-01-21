package com.example.learnkorean.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.learnkorean.R;
import com.example.learnkorean.models.IntroModel;

import java.util.List;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.IntroViewHolder> {

    private Context context;
    private List<IntroModel> list;

    public IntroAdapter(Context context, List<IntroModel> list) {
        this.context = context;
        this.list = list;
    }

    static class IntroViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
        TextView titleTextView;
        TextView paragraphTextView;

        public IntroViewHolder(@NonNull View itemView) {
            super(itemView);
//            imageView = itemView.findViewById(R.id.imageView);
            paragraphTextView = itemView.findViewById(R.id.paragraphTextView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }

    @NonNull
    @Override
    public IntroAdapter.IntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_list_item_layout, parent, false);
        return new IntroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntroAdapter.IntroViewHolder holder, int position) {
//        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.titleTextView.setText(list.get(position).getTitle());
        holder.paragraphTextView.setText(list.get(position).getParagraph());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
