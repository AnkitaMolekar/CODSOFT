import java.util.Scanner;

public class StudentGradeCalculator {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the number of subjects: ");
	        int n = sc.nextInt();

	        int[] marks = new int[n];
	        double totalMarks = 0;

	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter marks for subject " +(i+1)+ " (out of 100): ");
	            marks[i] = sc.nextInt();
	            if (marks[i] < 0 || marks[i] > 100) {
	                System.out.println(" Marks should be between 0 and 100.");
	                i--;
	            } else {
	               totalMarks=totalMarks+marks[i];
	            }
	        }

	        double averagePercentage = totalMarks / n;

	        char grade;
	        if (averagePercentage >= 90) {
	            grade = 'A';
	        } else if (averagePercentage >= 80) {
	            grade = 'B';
	        } else if (averagePercentage >= 70) {
	            grade = 'C';
	        } else if (averagePercentage >= 60) {
	            grade = 'D';
	        } else {
	            grade = 'F';
	        }
	        
	        System.out.println("\n--- Result ---");
	        System.out.println("Total Marks: " + totalMarks);
	        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
	        System.out.println("Grade: " + grade);

	     
	    }
	}
