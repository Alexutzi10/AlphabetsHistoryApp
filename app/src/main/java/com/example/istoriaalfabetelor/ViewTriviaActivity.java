package com.example.istoriaalfabetelor;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.istoriaalfabetelor.utils.Trivia;

import java.util.ArrayList;
import java.util.List;


public class ViewTriviaActivity extends AppCompatActivity {
    private Button bttnTakeTrivia;
    private ActivityResultLauncher<Intent> launcher;
    private ListView lvScores;
    private List<Trivia> scores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trivia);

        bttnTakeTrivia = findViewById(R.id.surugiu_george_alexandru_getScores);

        bttnTakeTrivia.setOnClickListener(click -> {
            Intent intent = new Intent(getApplicationContext(), TakeTriviaActivity.class);

            //pasul 1 din schema
            launcher.launch(intent);
        });

        lvScores = findViewById(R.id.surugiu_george_alexandru_triviaListView);
        ArrayAdapter<Trivia> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, scores);
        lvScores.setAdapter(adapter);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), getTriviaCallback());
    }

    private ActivityResultCallback<ActivityResult> getTriviaCallback() {
        return result -> {
            //pasul 4 din schema
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                Trivia trivia = (Trivia) result.getData().getSerializableExtra(TakeTriviaActivity.TRIVIA);
                scores.add(trivia);
                ArrayAdapter<Trivia> adapter = (ArrayAdapter<Trivia>) lvScores.getAdapter();
                adapter.notifyDataSetChanged();
            }
        };
    }
}