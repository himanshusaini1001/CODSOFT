import java.util.Scanner;

public class Task2{

    public static void main(String[] args) {

        Scanner In= new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = In.nextInt();
        int[] marks = new int[numSubjects]; 
        int totalMarks = 0; 
        System.out.println("Enter marks obtained in each subject (out of 100): ");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = In.nextInt();
            
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                i--; 
            } else {
                totalMarks += marks[i]; 
            }
        }
        double averagePercentage = (double) totalMarks / numSubjects;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        In.close();
    }
}
