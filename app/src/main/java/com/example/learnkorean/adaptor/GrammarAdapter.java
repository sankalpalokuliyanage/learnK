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
import com.example.learnkorean.models.WordModel;

import java.util.List;

public class GrammarAdapter extends RecyclerView.Adapter<GrammarAdapter.GrammarViewHolder>  {

    private Context context;
    private List<GrammarModel> grammarModelList;

    public GrammarAdapter(Context context, List<GrammarModel> grammarModelList) {
        this.context = context;
        this.grammarModelList = grammarModelList;
    }

    @NonNull
    @Override
    public GrammarAdapter.GrammarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wlrecyc, parent, false);
        return new GrammarAdapter.GrammarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarAdapter.GrammarViewHolder holder, int position) {
        holder.GrammarName.setText(grammarModelList.get(position).getGrammarName());
    }

    @Override
    public int getItemCount() {
        return grammarModelList.size();
    }

    public class GrammarViewHolder extends RecyclerView.ViewHolder  {

        TextView GrammarName;
        public GrammarViewHolder(@NonNull View itemView) {
            super(itemView);
            GrammarName = itemView.findViewById(R.id.wlname);
        }
    }
}
