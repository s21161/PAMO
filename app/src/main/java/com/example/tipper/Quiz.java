package com.example.tipper;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswers;

    public Quiz() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        correctAnswers = 0;
        // Dodaj pytania do listy
        addQuestions();
    }

    private void addQuestions() {
        // Dodaj pytania do listy
        questions.add(new Question("Co jest najlepszym źródłem białka?", "Mięso", "Ryby", "Warzywa", "Owoce", 1));
        questions.add(new Question("Które z poniższych nie jest zdrowym tłuszczem?", "Masło", "Awokado", "Orzechy", "Oliwa z oliwek", 1));
        questions.add(new Question("Ile wody powinno się pić dziennie?", "1 litr", "2 litry", "3 litry", "4 litry", 2));
        questions.add(new Question("Które z poniższych jest źródłem węglowodanów złożonych?", "Chleb pełnoziarnisty", "Biały chleb", "Cukier", "Bakłażan", 1));
        questions.add(new Question("Które z poniższych jest najbogatszym źródłem witaminy C?", "Marchewka", "Pomarańcza", "Banany", "Gruszka", 2));
        questions.add(new Question("Które z poniższych nie jest źródłem wapnia?", "Mleko", "Ser", "Jogurt", "Kiełbasa", 4));
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public void answerQuestion(int selectedOption) {
        if (selectedOption == getCurrentQuestion().getCorrectOption()) {
            correctAnswers++;
        }
        currentQuestionIndex++;
    }

    public boolean isQuizFinished() {
        return currentQuestionIndex == questions.size();
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public double getQuizPercentage() {
        return (double) correctAnswers / questions.size() * 100;
    }}
