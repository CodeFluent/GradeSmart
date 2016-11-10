import java.util.Scanner;

/**
 * Created by Zac on 10/11/2016.
 */
public class Course extends Instructor{

    public String courseName;
    public String location;


    public int testWeight;
    public int quizWeight;
    public int assignmentWeight;
    Scanner input = new Scanner(System.in);

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(){
        System.out.println("Enter the name of the Course:");
        courseName=input.nextLine();
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(){
        System.out.println("Enter the Course Location:");
        location=input.nextLine();
    }

}
