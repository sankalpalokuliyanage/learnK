package com.example.learnkorean.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnkorean.Activities.IntroductionActivity;
import com.example.learnkorean.Activities.MainActivity;
import com.example.learnkorean.Activities.QuizActivity;
import com.example.learnkorean.R;


public class HomeFragment extends Fragment {

    CardView cardView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view.findViewById(R.id.row1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), IntroductionActivity.class));
            }
        });

        view.findViewById(R.id.qui).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), QuizActivity.class));
            }
        });


        return view;

    }
}