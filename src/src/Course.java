/**
 * Created by Zac on 10/11/2016.
 */
public class Course {

    public String courseName;
    public String location;
    public int courseTime;

    public int testWeight;
    public int quizWeight;
    public int assignmentWeight;

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String n){
        courseName=n;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String l){
        location=l;
    }

    public int getCourseTime(){
        return courseTime;
    }

    public void setCourseTime(int t){
        courseTime=t;
    }

    public int getTestWeight(){
        return testWeight;
    }

    public void setTestWeight(int w){
        testWeight=w;
    }

    public int getQuizWeight(){
        return quizWeight;
    }

    public void setQuizWeight(int q){
        quizWeight=q;
    }

    public int getAssignmentWeight(){
        return assignmentWeight;
    }
}
