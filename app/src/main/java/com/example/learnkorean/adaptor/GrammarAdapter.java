// GrammarAdapter.java

package com.example.learnkorean.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnkorean.R;
import com.example.learnkorean.models.GrammarModel;

import java.util.List;

public class GrammarAdapter extends RecyclerView.Adapter<GrammarAdapter.GrammarViewHolder> {

    private Context context;
    private List<GrammarModel> grammarModelList;

    public GrammarAdapter(Context context, List<GrammarModel> grammarModelList) {
        this.context = context;
        this.grammarModelList = grammarModelList;
    }

    @NonNull
    @Override
    public GrammarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grammar_item, parent, false);
        return new GrammarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarViewHolder holder, int position) {
        GrammarModel grammarModel = grammarModelList.get(position);

        holder.grammarNameTextView.setText(grammarModel.getGrammarName());

        if (grammarModel.getTitles() != null && !grammarModel.getTitles().isEmpty()) {
            GrammarModel.TitleModel titleModel = grammarModel.getTitles().get(0);
            holder.titleNameTextView.setText(titleModel.getTitleName());
            // Further code...
        }
    }

    @Override
    public int getItemCount() {
        return grammarModelList.size();
    }

    public class GrammarViewHolder extends RecyclerView.ViewHolder {

        TextView grammarNameTextView;
        TextView titleNameTextView;

        public GrammarViewHolder(@NonNull View itemView) {
            super(itemView);
            grammarNameTextView = itemView.findViewById(R.id.textViewGrammarName);
            titleNameTextView = itemView.findViewById(R.id.textViewTitleName);
            // Add other views if needed...
        }
    }
}
