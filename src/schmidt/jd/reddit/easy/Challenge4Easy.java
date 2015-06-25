package schmidt.jd.reddit.easy;

import java.util.Random;
import java.util.Scanner;

/**
 * Author: JD Schmidt
 * Link: http://www.reddit.com/r/dailyprogrammer/wiki/challenges
 *
 * Problem Description
 *
 *
 * You're challenge for today is to create a random password generator!
 * Let the user specify the length
 * */
public class Challenge4Easy {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("How long would you like this password");
    int length = scanner.nextInt();
    Random r = new Random();

    StringBuilder password = new StringBuilder();
    System.out.println((char)33);
    for (int i = 0 ; i < length ; i++) {
      char c = 0;
      boolean isBadCharacter = true;
      while (isBadCharacter) {
        c = (char) (r.nextInt(126 - 33) + 33);
        if (c != '\\') {
          isBadCharacter = false;
        }
      }

      password.append(c);
    }
    System.out.println("Your new password is : " + password.toString());

  }
}
