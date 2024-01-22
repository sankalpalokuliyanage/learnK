package com.example.learnkorean.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnkorean.R;
import com.example.learnkorean.models.WordModel;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordsViewHolder> {

    private Context context;
    private List<WordModel> wordModelList;

    public WordAdapter(Context context, List<WordModel> wordModelList) {
        this.context = context;
        this.wordModelList = wordModelList;
    }

    @NonNull
    @Override
    public WordsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wordlistitem_layout, parent, false);
        return new WordsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsViewHolder holder, int position) {
        WordModel wordModel = wordModelList.get(position);

        holder.english.setText(wordModel.getEnglish());
        holder.korean.setText(wordModel.getKorean());
        holder.sentence.setText(wordModel.getSentence());
    }

    @Override
    public int getItemCount() {
        return wordModelList.size();
    }

    public class WordsViewHolder extends RecyclerView.ViewHolder {

        TextView english, korean, sentence;

        public WordsViewHolder(@NonNull View itemView) {
            super(itemView);
            english = itemView.findViewById(R.id.english);
            korean = itemView.findViewById(R.id.korean);
            sentence = itemView.findViewById(R.id.sentence);
        }
    }
}
