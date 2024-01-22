package com.example.learnkorean.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnkorean.R;
import com.example.learnkorean.models.WordLModel;

import java.util.List;

public class WordLAdapter extends RecyclerView.Adapter<WordLAdapter.WordLViewHolder> {

    private Context context;
    private List<WordLModel> wordLModelList;
    private OnItemClickListener listener;

    public WordLAdapter(Context context, List<WordLModel> wordLModelList, OnItemClickListener listener) {
        this.context = context;
        this.wordLModelList = wordLModelList;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    static class WordLViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView WLessonName;
        OnItemClickListener listener;

        public WordLViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            WLessonName = itemView.findViewById(R.id.wlname);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }
            }
        }
    }

    @NonNull
    @Override
    public WordLViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wlrecyc, parent, false);
        return new WordLViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull WordLViewHolder holder, int position) {
        holder.WLessonName.setText(wordLModelList.get(position).getLesson());
    }

    @Override
    public int getItemCount() {
        return wordLModelList.size();
    }
}
