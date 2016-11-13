
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;




/**
 *  DataParse is a Java class that scans the html file given,
 *  extracts the content of certain HTML elements, and then
 *  concats the strings into a CSV file.
 */

public class DataParse {

    /**
     *
     *
     * @return returns a String to become a line in the CSV file.
     */
    public static void CSVString () {
        try {

            Scanner console = new Scanner(System.in);
            System.out.println("Enter the html file where data is stored: ");
            String file = console.nextLine();
            Document document = Jsoup.parse(new File(file), "utf-8");
            System.out.println(document.title());

        } catch(IOException e) {
            e.printStackTrace();
        }

    }



    public static void main(String [] args) {
        CSVString();

    }

}
