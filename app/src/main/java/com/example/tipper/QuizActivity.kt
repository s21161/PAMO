package com.example.tipper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Inicjalizacja elementów interfejsu użytkownika
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        submitButton = findViewById(R.id.submitButton);

        // Inicjalizacja quizu
        quiz = new Quiz();

        // Ustawienie pierwszego pytania na ekranie
        displayQuestion();

        // Obsługa kliknięcia przycisku "Submit"
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    RadioButton selectedOptionRadioButton = findViewById(selectedOptionId);
                    int selectedOption = optionsRadioGroup.indexOfChild(selectedOptionRadioButton) + 1;
                    quiz.answerQuestion(selectedOption);

                    if (quiz.isQuizFinished()) {
                        // Quiz zakończony, wyświetlenie wyników
                        showQuizResults();
                    } else {
                        // Wyświetlenie kolejnego pytania
                        displayQuestion();
                    }
                }
            }
        });
    }

    private void displayQuestion() {
        // Wyświetlenie aktualnego pytania na ekranie
        Question currentQuestion = quiz.getCurrentQuestion();
        questionTextView.setText(currentQuestion.getQuestionText());
        RadioButton[] optionRadioButtons = new RadioButton[4];
        optionRadioButtons[0] = findViewById(R.id.option1RadioButton);
        optionRadioButtons[1] = findViewById(R.id.option2RadioButton);
        optionRadioButtons[2] = findViewById(R.id.option3RadioButton);
        optionRadioButtons[3] = findViewById(R.id.option4RadioButton);
        for (int i = 0; i < 4; i++) {
            optionRadioButtons[i].setText(currentQuestion.getOptions()[i]);
        }
        optionsRadioGroup.clearCheck();
    }

    private void showQuizResults() {
        // Wyświetlenie wyników quizu
        int correctAnswers = quiz.getCorrectAnswers();
        int totalQuestions = quiz.getTotalQuestions();
        double quizPercentage = quiz.getQuizPercentage();
        String results = String.format(Locale.getDefault(), "Wynik: %d/%d (%.2f%%)", correctAnswers, totalQuestions, quizPercentage);
        questionTextView.setText(results);
        optionsRadioGroup.setVisibility(View.GONE);
        submitButton.setEnabled(false);
    }
}

