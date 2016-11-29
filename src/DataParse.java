
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;




/**
 *  DataParse is a Java class that scans the html file given,
 *  extracts the content of certain HTML elements, and then
 *  concats the strings into a CSV file.
 *
 *  DataParse is NOT executed in the main application. It is a utility class meant to grab and parse data for input
 *  only once and would not be provided to the end user.
 */

public class DataParse {


    public static void FileOutput () {
        try {

            Scanner console = new Scanner(System.in);
            // Will be C:\Users\Wasfi\IdeaProjects\GradeSmart\src\data\Class Schedule Listing.html
            System.out.println("Enter the html file where data is stored: ");
            String file = console.nextLine();
            Document document = Jsoup.parse(new File(file), "utf-8");

            CSVString(document); // returns the line to be put into the CSV file




        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static String CSVString (Document document) {

        // CRN, Course ID, Course Name, Instructor, Location

        ArrayList <String> data = new ArrayList<String>();

        Element table = document.select(".datadisplaytable").get(0);
//      String tables = table.toString(); // to get the table data.
        Elements rows = table.select("tr");

        try{
            PrintWriter writer = new PrintWriter("file.csv", "UTF-8");

        for(int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);
            String rows1 = row.text().toString();
            writer.println(rows1);
//            System.out.println(row.text().toString()); //
//            Elements cols = row.select("td.dddefault");
//            for (Element d : cols){
//                data.add(d.text());
//            }
        }

        writer.close();
        } catch (IOException e) {
            System.out.println("Error in creating CSV file.");
        }


        String tables ="";
        return tables;


    }

    /**
     *
     * Alphabetize the CSV file by Course Name.
     */


    public static void main(String [] args) {
        FileOutput();

    }

}
