import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Required automatic demo
        if (args.length > 0 && args[0].equalsIgnoreCase("--demo")) {
            runDemo();
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Channel (SMS/EMAIL): ");
        String channelInput = input.nextLine().trim().toUpperCase();

        System.out.print("Notification (REMINDER/URGENT): ");
        String notificationInput = input.nextLine().trim().toUpperCase();

        System.out.print("Input your text: ");
        String text = input.nextLine();

        MesseageChannel channel;

        switch (channelInput) {
            case "SMS" -> channel = new SMSChannel();
            case "EMAIL" -> channel = new EmailChannel();

            default -> {
                System.out.println("Error: use SMS or EMAIL.");
                return;
            }
        }

        Notification notification;

        switch (notificationInput) {
            case "REMINDER" -> notification = new Reminder(text, channel);
            case "URGENT" -> notification = new UrgentAlert(text, channel);

            default -> {
                System.out.println("Error: use REMINDER or URGENT.");
                return;
            }
        }

        System.out.println(notification.execute());
    }


    public static void runDemo() {

        String text = "Submit assignment";

        // T1 - Reminder + Email
        Notification t1 = new Reminder(text, new EmailChannel());
        System.out.println("T1:");
        System.out.println(t1.execute());
        System.out.println();


        // T2 - Reminder + SMS
        Notification t2 = new Reminder(text, new SMSChannel());
        System.out.println("T2:");
        System.out.println(t2.execute());
        System.out.println();


        // T3 - UrgentAlert + Email
        Notification t3 = new UrgentAlert(text, new EmailChannel());
        System.out.println("T3:");
        System.out.println(t3.execute());
        System.out.println();


        // T4 - UrgentAlert + SMS
        Notification t4 = new UrgentAlert(text, new SMSChannel());
        System.out.println("T4:");
        System.out.println(t4.execute());
        System.out.println();


        // T5 - Runtime implementation switching
        Reminder t5 = new Reminder(text, new EmailChannel());

        Reminder originalReference = t5;

        int originalId = t5.id;
        String originalText = t5.text;

        System.out.println("T5 BEFORE:");
        System.out.println(t5.execute());

        t5.setImplementation(new SMSChannel());

        System.out.println("T5 AFTER:");
        System.out.println(t5.execute());

        System.out.println("Same object: " + (originalReference == t5));
        System.out.println("Same ID: " + (originalId == t5.id));
        System.out.println("Same text: " + originalText.equals(t5.text));

        // T6
        Notification t6 = new Reminder(text, new PushChannel());

        String actualT6 = t6.execute();
        String expectedT6 = "Push" + text + "end of a Push";

        System.out.println("T6:");
        System.out.println("Expected: " + expectedT6);
        System.out.println("Actual:   " + actualT6);
        System.out.println(actualT6.equals(expectedT6) ? "PASS" : "FAIL");
        System.out.println();


// T7
        Notification t7 = new UrgentAlert(text, new PushChannel());

        String actualT7 = t7.execute();
        String expectedT7 = "Push" + "URGENT " + text + "end of a Push";

        System.out.println("T7:");
        System.out.println("Expected: " + expectedT7);
        System.out.println("Actual:   " + actualT7);
        System.out.println(actualT7.equals(expectedT7) ? "PASS" : "FAIL");
        System.out.println();
    }
}