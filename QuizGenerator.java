package quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizGenerator 
{
	private static Map<String, Quiz> quizzes;

    static {
        quizzes = new HashMap<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quiz Generator");
            System.out.println("1. Create Quiz");
            System.out.println("2. Take Quiz");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createQuiz(scanner);
                    break;
                case 2:
                    takeQuiz(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createQuiz(Scanner scanner) {
        System.out.print("Enter quiz topic: ");
        String topic = scanner.nextLine();
        Quiz quiz = new Quiz(topic);
        quizzes.put(topic, quiz);

        while (true) {
            System.out.print("Enter question (or 'done' to finish): ");
            String question = scanner.nextLine();
            if (question.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter option 1: ");
            String option1 = scanner.nextLine();
            System.out.print("Enter option 2: ");
            String option2 = scanner.nextLine();
            System.out.print("Enter option 3: ");
            String option3 = scanner.nextLine();
            System.out.print("Enter correct answer: ");
            String correctAnswer = scanner.nextLine();
            quiz.addQuestion(question, option1, option2, option3, correctAnswer);
        }
    }

    private static void takeQuiz(Scanner scanner) {
        System.out.print("Enter quiz topic: ");
        String topic = scanner.nextLine();
        if (quizzes.containsKey(topic)) {
            quizzes.get(topic).takeQuiz();
        } else {
            System.out.println("Quiz not found. Please create a quiz first.");
        }
    }

}
