import java.util.*;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process");
        int n = sc.nextInt();

        // display ring formation
        for (int i = 0; i < n; i++) {
            System.out.println(i + " ");
        }
        System.out.println("0 [Loop back to 0]");
        System.out.println("Initally token is at node 0");

        int choice = 0;
        int token = 0;
        int sender, receiver;

        do {
            // simulating mutual exclusion
            System.out.println("[Mutual Exclusion] Only node with token holder can send data");

            // validating sender
            while (true) {
                System.out.println("Enter sender.Sender must be token");
                sender = sc.nextInt();
                if (sender == token)
                    break;
                else
                    System.out.println("Enter valid sender");
            }
            // validating receiver
            while (true) {
                System.out.println("Enter receiver.");
                receiver = sc.nextInt();
                if (receiver < 0 || receiver >= n || receiver == sender)
                    System.out.println("enter valid receiver");
                else
                    break;
            }

            System.out.println("Enter data to send");
            int data = sc.nextInt();
            System.out.println(" " + sender);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = sender; i != receiver; i = (i + 1) % n) {
                System.out.println(" " + i + "->");
            }
            token = (sender + 1) % n;
            System.out.println(" " + receiver);
            System.out.println("receiver" + receiver + "received data" + data);

            System.out.println("\n Do you again want to send data?");
            choice = sc.nextInt();

        } while (choice == 1);
        System.out.println("\n Simulation ended");
        sc.close();
    }
}