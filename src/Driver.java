import java.util.*;


public class Driver extends Course {
    public static void main(String[] args) {

        Course course1 = new Course();
        Assignment assignment1 = new Assignment();

        String userName;
        String password = "password";
        String passIn;

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to gradeSmartt \n" + "Please enter your Username: \n");
        userName = input.nextLine();

        System.out.println("\nPlease enter your password: ");

        passIn = input.nextLine();

        if (password.equals(passIn)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Verification Failed");
            System.exit(0);
        }

        System.out.println("Welcome " + userName);

        int select = -1;
        while (select != 0) {
            System.out.println("\nPlease make a selection from the menu below:\n");
            System.out.println("1.Add Course");
            System.out.println("2.Get Course Info");
            System.out.println("3.Calculate Grades");
            System.out.println("Enter 0 to Exit Program");
            select = input.nextInt();


            switch (select) {
                case 1:
                    course1.setCourseName();
                    course1.setLocation();
                    course1.setInstructorFirst();
                    course1.setInstructorLast();
                    course1.setEmail();
                    course1.setPhoneNumber();
                    break;
                case 2:
                    System.out.println("Course: " + course1.getCourseName());
                    System.out.println("Location: " + course1.getLocation());
                    System.out.println("Professor: " + course1.getInstructorFirst() +" " +course1.getInstructorLast());
                    System.out.println("Email: " + course1.getEmail());
                    System.out.println("Phone Number: " + course1.getPhoneNumber());
                    break;
                case 3:
                    assignment1.addTest();
                    assignment1.addHomework();
                    assignment1.addQuiz();
                    assignment1.addExam();
                    assignment1.calculate();
                    break;
                case 4:
                    System.exit(0);

            }
        }

    }
}

