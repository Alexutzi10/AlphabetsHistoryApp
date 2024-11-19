package com.example.istoriaalfabetelor;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.istoriaalfabetelor.utils.Trivia;

import java.util.ArrayList;
import java.util.List;

public class ViewTriviaActivity extends AppCompatActivity {
    private Button bttnScores;
    private ListView listView;
    private List<Trivia> triviaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trivia);

        bttnScores = findViewById(R.id.surugiu_george_alexandru_getScores);
        listView = findViewById(R.id.surugiu_george_alexandru_triviaListView);

        ArrayAdapter<Trivia> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, triviaList);
        listView.setAdapter(adapter);

        bttnScores.setOnClickListener(click -> {
            Trivia trivia = new Trivia("Istoria alfabetelor", TakeTriviaActivity.score);
            triviaList.add(trivia);
            adapter.notifyDataSetChanged();
        });
    }
}