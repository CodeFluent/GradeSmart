package com.gradesmartt.w;

import java.util.Scanner;

public class Instructor extends Curve{

    public String instructorFirst;
    public String instructorLast;
    public String email;

    public int phoneNumber;
    public int officeHours;

    Scanner input = new Scanner(System.in);

    public String getInstructorFirst(){
        return instructorFirst;
    }

    public void setInstructorFirst(){
        System.out.println("Professor's First Name:");
        instructorFirst=input.nextLine();
    }
    public String getInstructorLast(){
        return instructorLast;
    }

    public void setInstructorLast(){
        System.out.println("Professor's Last Name:");
        instructorLast=input.nextLine();
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        System.out.println("Enter the Professor's Email address:");
        email=input.nextLine();
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(){
        System.out.println("Enter the Professor's Phone Number:");
        phoneNumber=input.nextInt();
    }

    public int getOfficeHours(){
        return officeHours;
    }

    public void setOfficeHours(int o){
        officeHours=o;
    }

}
