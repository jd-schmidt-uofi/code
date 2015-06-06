package schmidt.jd.reddit.easy;
/**
 * @author: JD Schmidt
 * @link: http://www.reddit.com/r/dailyprogrammer/wiki/challenges
 *
 * Problem Description:
 *
 * create a program that will ask the users name, age, and reddit username. have it tell them the information back, in the format:
   your name is (blank), you are (blank) years old, and your username is (blank)
   for extra credit, have the program log this information in a file to be accessed later.

 * */
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Challenge1Easy {

  public static void main(String[] args) {
    try {
      StringBuilder sb = new StringBuilder();
      Scanner scanner = new Scanner(System.in);

      // Logfile
      File logFile = new File("exercise_1_easy.log");
      FileWriter fos = new FileWriter(logFile,true);
      // Output logfile location
      System.out.println("The logfile is located at: "  + logFile.getAbsolutePath());

      // 1. Get name
      System.out.println("Please enter your name");
      sb.append("Your name is '" + scanner.nextLine());

      // 2. Get age
      System.out.println("How old are you?");
      sb.append("' and your age is " + scanner.nextInt() + ", your reddit name is '");

      // 1. Get Reddit username
      System.out.println("What is your addiction username?");

      // not sure why this is necessary
      scanner.nextLine();

      sb.append(scanner.nextLine() + "'");

      // write to outputfile
      fos.write(sb.toString());
      fos.write(System.getProperty("line.separator"));
      fos.flush();

      System.out.println(sb.toString());
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getCause());
    }

  }
}
