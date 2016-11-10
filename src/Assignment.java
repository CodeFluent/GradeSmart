
import java.util.Scanner;

public class Assignment extends Course{


    private double test;
    private int testNum;
    private double testWeight;
    private double testAvg;

    private double homework;
    private int hwNum;
    private double hwWeight;
    private double hwAvg;

    private double quiz;
    private int quizNum;
    private double quizWeight;
    private double quizAvg;

    private double exam;
    private double examWeight;

    public double finalGrade;

    Scanner input = new Scanner(System.in);

    public void addTest(){
        System.out.println("Enter number of tests:");
        testNum=input.nextInt();
        System.out.println("Enter the test weight(as a decimal):");
        testWeight=input.nextDouble();

        for (int i=1; i<=testNum; i++){
            System.out.println("What did you get on Test "+ i +"? (Out of 100 percentage points):");
            test+=input.nextDouble();
        }

        testAvg= (test/testNum);
    }

    public void addHomework(){
        System.out.println("Enter the number of Homework assignments:");
        hwNum=input.nextInt();
        System.out.println("Enter the Homework weight(as a decimal):");
        hwWeight=input.nextDouble();

        for (int i=1; i<=hwNum; i++){
            System.out.println("What did you get on Homework "+ i +"? (Out of 100 percentage points):");
            homework+=input.nextDouble();
        }

        hwAvg= (homework/hwNum);

    }
    public void addQuiz(){
        System.out.println("Enter the number of Quizzes:");
        quizNum=input.nextInt();
        System.out.println("Enter the Quiz weight(as a decimal):");
        quizWeight=input.nextDouble();

        for (int i=1; i<=quizNum; i++){
            System.out.println("What did you get on Quiz "+ i +"? (Out of 100 percentage points):");
            quiz+=input.nextDouble();
        }

        quizAvg= (quiz/quizNum);
    }

    public void addExam(){
        System.out.println("Enter Final Exam Weight(as a decimal):");
        examWeight=input.nextDouble();
        System.out.println("What did you get on the final? (Out of 100 percentage points):");
        exam=input.nextDouble();
    }

    public void calculate() {
        finalGrade = (testAvg * testWeight) + (hwAvg * hwWeight) + (quizAvg * quizWeight) + (exam * examWeight);
        System.out.println("Your score in the class was " + finalGrade);

        if (finalGrade > 90) {
            System.out.println("You received an A");
        } else if (finalGrade > 80) {
            System.out.println("You received a B");
        } else if (finalGrade > 70) {
            System.out.println("You received a C");
        }else if (finalGrade>60){
            System.out.println("You received a D");
        }
        else{
            System.out.println("You failed the course.");
        }


    }
}
