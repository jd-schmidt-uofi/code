package schmidt.jd.reddit.hard;

import java.util.Scanner;

/**
 * we all know the classic "guessing game" with higher or lower prompts.
 * lets do a role reversal; you create a program that will guess numbers between 1-100,
 * and respond appropriately based on whether users say that the number is too high or too low.
 */
public class Challenge1Hard {
  int between = 100;
  public static void main(String[] args) {
    doMain();
    }
    private static void doMain() {
      int higher = getInt("Please enter the maxmium number boundary");
      int lower = 0;
      int[] range = {lower, higher};
      while (true) {

        range = compute(range[0], range[1]);

      }
    }

    private static int[] compute(int x, int y) {
      int guess =(x + y) / 2;
      System.out.println("Is your number: " + guess);
      System.out.println("You may say higher, lower, or yes");
      Scanner scanner = new Scanner(System.in);
      String response = scanner.nextLine().toLowerCase();

      int[] ret;
      switch (response) {
        case "yes":
          System.out.println("About time I got the correct answer!! The number was: " + response);
          System.exit(0);
        case "higher":
          System.out.println("OK higher");
          ret = new int[]{guess, y};
          return ret;
        case "lower":
          System.out.println("OK Lower");
          ret = new int[]{x, guess};
          return ret;
        default:
          System.out.println("NO idea what that means I'm just quitting");
          System.exit(1);
      }
      return new int[]{0,0};
    }
    private static int getInt(String message) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(message);
      return scanner.nextInt();
    }
  }

