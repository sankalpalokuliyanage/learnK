package com.example.learnkorean.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnkorean.R;
import com.example.learnkorean.models.IntroModel;
import com.example.learnkorean.models.WordLModel;

import java.util.List;

public class WordLAdapter extends RecyclerView.Adapter<WordLAdapter.WordLViewHolder> {

    private Context context;
    private List<WordLModel> wordLModelList;

    public WordLAdapter(Context context, List<WordLModel> wordLModelList) {
        this.context = context;
        this.wordLModelList = wordLModelList;
    }

    @NonNull
    @Override
    public WordLAdapter.WordLViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wlrecyc, parent, false);
        return new WordLAdapter.WordLViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordLAdapter.WordLViewHolder holder, int position) {
        holder.WLessonName.setText(wordLModelList.get(position).getLesson());
    }

    @Override
    public int getItemCount() {
        return wordLModelList.size();
    }

    public class WordLViewHolder extends RecyclerView.ViewHolder {

        TextView WLessonName;
        public WordLViewHolder(@NonNull View itemView) {
            super(itemView);
            WLessonName = itemView.findViewById(R.id.wlname);
        }
    }
}
