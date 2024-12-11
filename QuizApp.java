 import java.util.*;

public class QuizApp {
    static class Question {
        String question;
        String[] options;
        int correctOption;

        Question(String question, String[] options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }

        public static void main(String[] args) {
        // Define quiz questions
            List<Question> quiz = new ArrayList<>();
            quiz.add(
                    new Question("What is the capital of India?", new String[] { "Delhi", "Haryana", "Uttarpradesh", "Madras1" },
                            0));
            quiz.add(new Question("What is 3*9?", new String[] { "35", "36", "24", "27" }, 3));
            quiz.add(new Question("What is the largest planet in our solar system?",
                    new String[] { "Earth", "Mars", "Jupiter", "Venus" }, 2));
            quiz.add(new Question("Which programming language is owned by oracle?",
                    new String[] { "Python", "C++", "Java", "JavaScript" }, 2));
            quiz.add(new Question("What is the square root of 36?", new String[] { "2", "6", "8", "16" }, 1));
            runQuiz(quiz);
        }

        public static void runQuiz(List<Question> quiz) {
            Scanner scanner = new Scanner(System.in);
            int score = 0;
            List<String> summary = new ArrayList<>();

            for (int i = 0; i < quiz.size(); i++) {
                Question q = quiz.get(i);
                System.out.println("\nQuestion " + (i + 1) + ": " + q.question);

                // Display options
                for (int j = 0; j < q.options.length; j++) {
                    System.out.println((j + 1) + ". " + q.options[j]);
                }

                System.out.println("You have 10 seconds to answer!");
                int userAnswer = -1;
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("\nTime's up!");
                        System.exit(0);
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 10000);

                try {
                    System.out.print("Enter your choice (1-4): ");
                    userAnswer = scanner.nextInt() - 1;
                    timer.cancel();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Moving to the next question.");
                    scanner.next();
                }
                if (userAnswer == q.correctOption) {
                    System.out.println("Correct!");
                    score++;
                    summary.add("Question " + (i + 1) + ": Correct");
                } else if (userAnswer >= 0 && userAnswer < q.options.length) {
                    System.out.println("Incorrect! Correct answer: " + q.options[q.correctOption]);
                    summary.add("Question " + (i + 1) + ": Incorrect (Correct: " + q.options[q.correctOption] + ")");
                } else {
                    System.out.println("No Answer! Correct answer: " + q.options[q.correctOption]);
                    summary.add("Question " + (i + 1) + ": No Answer (Correct: " + q.options[q.correctOption] + ")");
                }
            }

            // Display final results
            System.out.println("\n--- Quiz Results ---");
            System.out.println("Your score: " + score + "/" + quiz.size());
            System.out.println("Summary:");
            for (String result : summary) {
                System.out.println(result);
            }
            scanner.close();
        }
    }
}