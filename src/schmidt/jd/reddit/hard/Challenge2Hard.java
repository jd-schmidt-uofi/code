package schmidt.jd.reddit.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Author: JD Schmidt
 * Link: http://www.reddit.com/r/dailyprogrammer/wiki/challenges
 *
 * Problem Description:
 * Your mission is to create a stopwatch program. this program should have start, stop,
 * and lap options, and it should write out to a file to be viewed later.
 */
public class Challenge2Hard {

  public static void main(String[] args) {
    Timer timer = new Timer();
    while (true) {
      getAction(timer);
    }
  }

    protected static void getAction(Timer timer) {
      System.out.println("Pick an action");
      System.out.println("1. Start timer");
      System.out.println("2. Stop timer");
      System.out.println("3. Lap timer");
      System.out.println("4. List Laps");
      System.out.println("5. Quit");
      Scanner scanner = new Scanner(System.in);
      int response = -9;
      int numTries = 3;
      while(--numTries > 0) {
        try {
          response = scanner.nextInt();
          break;
        } catch (Exception e) {
          continue;
        }
      }

      switch (response) {
        case 1:
          timer.start();
          break;
        case 2:
          timer.stop();
          break;
        case 3:
          timer.lap();
          break;
        case 4:
          timer.list();
          break;
        case 5:
          System.out.println("Outputting all laps");
          timer.list();
          exit(0);
        default:
          System.out.println("Wierd....");
          break;
      }
  }

  private static class Timer {
    private long starTime;
    private boolean running;
    private long stopTime;
    private List laps = new ArrayList<Long>();
    private void start() {
      if (running) {
        System.out.println("Clock already running for: " + ((System.currentTimeMillis() - starTime) / 1000) + " seconds");
      } else {
        running = true;
        starTime = System.currentTimeMillis();
      }
    }
    private void stop() {
      if (!running) {
        System.out.println("Clock hadn't been started yet");
      } else {
        running = false;
        stopTime = System.currentTimeMillis();
        System.out.println("Clock time: " + (stopTime - starTime)/1000 + " seconds");
      }
    }
    private void lap() {
      if (!running) {
        System.out.println("Clock hadn't been started yet");
      } else {
        long now = System.currentTimeMillis();
        laps.add(now - starTime);
        starTime = now;
        list();
      }
    }
    private void list() {
      laps.forEach(lap -> System.out.println(((long)lap / 1000) + " seconds"));
    }

  }
}

