package com.example.istoriaalfabetelor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.istoriaalfabetelor.utils.Trivia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TakeTriviaActivity extends AppCompatActivity {
    public static int score;
    public static final String TRIVIA = "trivia";
    private RadioGroup question1;
    private RadioGroup question2;
    private RadioGroup question5;
    private RadioGroup question7;
    private EditText question3;
    private EditText question4;
    private EditText question6;
    private EditText question9;
    private EditText question10;
    private Spinner question8;
    private Button sendBttn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_take_trivia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.surugiu_george_alexandru_constraintLayout_quiz), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeComponents();

        intent = getIntent();

        sendBttn.setOnClickListener(click -> {
            if (!validateInputs()) {
                return;
            }

            Trivia trivia = buildTrivia();
            Log.i("TakeTriviaActivity", trivia.toString());

            intent.putExtra(TRIVIA, trivia);
            setResult(RESULT_OK, intent);

            if (generateScore() >= 50) {
                Toast.makeText(getApplicationContext(), getString(R.string.score_shower1) + generateScore() + getString(R.string.score_shower2), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.score_shower1) + generateScore() + getString(R.string.score_shower3), Toast.LENGTH_LONG).show();
            }

            finish();
        });
    }

    private Trivia buildTrivia() {
        String name = getString(R.string.trivia_name);
        score = generateScore();
        return new Trivia(name, score);
    }

    private void initializeComponents() {
        question1 = findViewById(R.id.surugiu_george_alexandru_radioGroup_q1);
        question2 = findViewById(R.id.surugiu_george_alexandru_radioGroup_q2);
        question3 = findViewById(R.id.surugiu_george_alexandru_editText_q3);
        question4 = findViewById(R.id.surugiu_george_alexandru_editText_q4);
        question5 = findViewById(R.id.surugiu_george_alexandru_radioGroup_q5);
        question6 = findViewById(R.id.surugiu_george_alexandru_editText_q6);
        question7 = findViewById(R.id.surugiu_george_alexandru_radioGroup_q7);
        question8 = findViewById(R.id.surugiu_george_alexandru_spinnerQ8);
        question9 = findViewById(R.id.surugiu_george_alexandru_editText_q9);
        question10 = findViewById(R.id.surugiu_george_alexandru_editText_q10);

        sendBttn = findViewById(R.id.surugiu_george_alexandru_bttnSend);
    }

    private boolean validateInputs() {
        if (question1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.toast_q1, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.toast_q2, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question3.getText() == null || question3.getText().toString().trim().length() <= 3 || question3.getText().toString().trim().equals("Answer here:")) {
            Toast.makeText(getApplicationContext(), R.string.toast_q3, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question4.getText() == null || question4.getText().toString().trim().length() <=3 || question4.getText().toString().trim().equals("Answer here:")) {
            Toast.makeText(getApplicationContext(), R.string.toast_q4, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question5.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.toast_q5, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question6.getText() == null || question6.getText().toString().trim().equals("Answer here:")) {
            Toast.makeText(getApplicationContext(), R.string.toast_q6, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question7.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), R.string.toast_q7, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question9.getText() == null || question9.getText().toString().trim().length() <=3 || question9.getText().toString().trim().equals("Answer here:")) {
            Toast.makeText(getApplicationContext(), R.string.toast_q9, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (question10.getText() == null || question10.getText().toString().trim().length() <=3 || question10.getText().toString().trim().equals("Answer here:")) {
            Toast.makeText(getApplicationContext(), R.string.toast_q10, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private int generateScore() {
        int finalScore = 0;

        if (question1.getCheckedRadioButtonId() == R.id.surugiu_george_alexandru_scriereaCuneiforma) {
            finalScore += 10;
        }
        if (question2.getCheckedRadioButtonId() == R.id.surugiu_george_alexandru_egiptulAntic){
            finalScore += 10;
        }
        if (question3.getText().toString().trim().equals("Scandinavia")) {
            finalScore += 10;
        }
        if (question4.getText().toString().trim().equals("Alfabetul fenician")) {
            finalScore += 10;
        }
        if (question5.getCheckedRadioButtonId() == R.id.surugiu_george_alexandru_constantin) {
            finalScore += 10;
        }
        String q6String = question6.getText().toString();
        int inputText = Integer.parseInt(q6String);
        if (inputText == 26) {
            finalScore += 10;
        }
        if (question7.getCheckedRadioButtonId() == R.id.surugiu_george_alexandru_1857) {
            finalScore += 10;
        }
        String q8String = question8.getSelectedItem().toString();
        int selectedNumber = Integer.parseInt(q8String);
        if (selectedNumber == 2) {
            finalScore += 10;
        }
        if (question9.getText().toString().trim().equals("Irlanda")) {
            finalScore += 10;
        }
        if (question10.getText().toString().trim().equals("Alfabetul etrusc")){
            finalScore += 10;
        }

        return finalScore;
    }

}