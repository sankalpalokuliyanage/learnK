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
    private OnItemClickListener listener;

    public GrammarAdapter(Context context, List<GrammarModel> grammarModelList, OnItemClickListener listener) {
        this.context = context;
        this.grammarModelList = grammarModelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GrammarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grammar, parent, false);
        return new GrammarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarViewHolder holder, int position) {
        holder.bind(grammarModelList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return grammarModelList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class GrammarViewHolder extends RecyclerView.ViewHolder {

        TextView grammarNameTextView;

        public GrammarViewHolder(@NonNull View itemView) {
            super(itemView);
            grammarNameTextView = itemView.findViewById(R.id.textViewGrammarName);
        }

        public void bind(final GrammarModel grammarModel, final OnItemClickListener listener) {
            grammarNameTextView.setText(grammarModel.getGrammarName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
