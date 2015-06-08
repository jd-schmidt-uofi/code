package schmidt.jd.reddit.intermediate;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: JD Schmidt
 * @link: http://www.reddit.com/r/dailyprogrammer/wiki/challenges
 *
 * Problem Description:
 *
Create a menu driven program
Using the menu drive program allow a user to add/delete items
The menu should be based on an events calender where users enter the events by hour
No events should be hard-coded.

 */


public class Challenge1Intermediate {
  protected static int counter = 1;
  public static void main(String[] args) {
    while (true) {
      doMain();
    }
  }

  // an event class (calendar entry)
  private static class Event {
    protected String description;
    protected int hour;
    protected int id;

    public Event(String description, int hour) {
      this.id = counter++;
      this.description = description;
      this.hour = hour;
    }
  }
  public static List<Event> events = new ArrayList<>();


  private static void listEvents() {
    System.out.println("++  EVENTS  ++");
    if (events.size() == 0) {
      System.out.println("ZERO EVENTS!!");
    } else {
      for (Event e : events) {
        System.out.format("%2s%32s%10s", "" + e.id, "Description: " + e.description, "Hour: " + e.hour);
        System.out.println();
      }
    }
  }


  private static void prompt() {
    showActions();
    System.out.println("What would you like to do?");
    Scanner input = new Scanner(System.in);
    int action = input.nextInt();

    switch (action) {
      case 1:
        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter a description");
        String desc = input1.nextLine();

        System.out.println("Please enter a hour");
        int hour = -1;
        while (hour < 0 || hour > 24) {
          hour = input1.nextInt();
        }

        events.add(new Event(desc,hour));
        break;
      case 2:
        listEvents();
        break;
      case 3:
        System.out.println("Which event id do you want to delete?");
        Scanner input2 = new Scanner(System.in);
        int toDelete = input2.nextInt();
        events.remove(toDelete - 1);
        break;
      default:
        System.out.println("Unknown action");
        break;
    }

  }

  private static void showActions() {
    System.out.println("++  Actions  ++");
    System.out.println("1. Add event");
    System.out.println("2. List events");
    System.out.println("3. Delete event");

  }

  private static void doMain() {
    prompt();
  }
}
