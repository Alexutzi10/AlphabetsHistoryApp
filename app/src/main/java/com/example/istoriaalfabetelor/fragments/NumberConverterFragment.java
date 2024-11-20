package com.example.istoriaalfabetelor.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.istoriaalfabetelor.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class NumberConverterFragment extends Fragment {

    private TextView questionTextView;
    private TextInputEditText answerText;
    private Button submitButton;
    private Button nextQuestionButton;
    private String currentQuestion;
    private String correctAnswer;
    private boolean isArabicToRoman;

    public NumberConverterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_converter, container, false);

        questionTextView = view.findViewById(R.id.surugiu_george_alexandru_questionTextView);
        answerText = view.findViewById(R.id.surugiu_george_alexandru_answerEditText);
        submitButton = view.findViewById(R.id.surugiu_george_alexandru_submitButton);
        nextQuestionButton = view.findViewById(R.id.surugiu_george_alexandru_nextQuestionButton);

        generateQuestion();

        submitButton.setOnClickListener(click -> {
            validateAnswer();
        });
        nextQuestionButton.setOnClickListener(click -> {
            generateQuestion();
        });

        return view;
    }

    private void generateQuestion() {
        answerText.setText("");

        Random random = new Random();
        isArabicToRoman = random.nextBoolean();
        int number = random.nextInt(100) + 1;

        if (isArabicToRoman) {
            currentQuestion = String.valueOf(number);
            correctAnswer = arabicToRoman(number);
            questionTextView.setText(getString(R.string.introdu_cifre_romane) + currentQuestion);
        } else {
            currentQuestion = arabicToRoman(number);
            correctAnswer = String.valueOf(number);
            questionTextView.setText(getString(R.string.introdu_cifre_arabe) + currentQuestion);
        }
    }

    private void validateAnswer() {
        String userAnswer = answerText.getText().toString().trim();

        if (TextUtils.isEmpty(userAnswer)) {
            Toast.makeText(getContext(), R.string.introdu_un_raspuns, Toast.LENGTH_SHORT).show();
            return;
        }

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            Toast.makeText(getContext(), R.string.corect, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), getString(R.string.incorect_raspunsul_corect_este) + correctAnswer, Toast.LENGTH_SHORT).show();
        }
    }

    private String arabicToRoman(int number) {
        String[] romanNumerals = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] arabicNumerals = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < arabicNumerals.length; i++) {
            while (number >= arabicNumerals[i]) {
                roman.append(romanNumerals[i]);
                number -= arabicNumerals[i];
            }
        }
        return roman.toString();
    }
}