package quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Quiz 
{
    @SuppressWarnings("unused")
	private String topic;
    private List<String> questions;
    private Map<String, String> options;
    private Map<String, String> correctAnswers;

    public Quiz(String topic) {
        this.topic = topic;
        this.questions = new ArrayList<>();
        this.options = new HashMap<>();
        this.correctAnswers = new HashMap<>();
    }

    public void addQuestion(String question, String option1, String option2, String option3, String correctAnswer) {
        questions.add(question);
        options.put(question, option1 + "," + option2 + "," + option3);
        correctAnswers.put(question, correctAnswer);
    }

    public void takeQuiz() {
        int score = 0;
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        for (String question : questions) {
            System.out.println(question);
            String[] optionsArray = options.get(question).split(",");
            for (int i = 0; i < optionsArray.length; i++) {
                System.out.println((i + 1) + ". " + optionsArray[i]);
            }
            System.out.print("Enter your answer: ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals(correctAnswers.get(question))) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers.get(question));
            }
        }
        System.out.println("Your score is " + score + " out of " + questions.size());
    }

}