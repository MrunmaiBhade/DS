import java.util.*;

public class Bully {
    int coordinator;
    int max_process;
    boolean[] processes;

    public Bully(int max) {
        max_process = max;
        processes = new boolean[max_process];
        coordinator = max;

        for (int i = 0; i < max_process; i++) {
            processes[i] = true;
            System.out.println("Process P" + (i + 1) + "is created and now up");

        }
        System.out.println("Initial coordinator is:" + coordinator);
        System.out.println("Current coordinator is:" + coordinator);
    }

    void upprocess(int process_id) {
        if (!processes[process_id - 1]) {
            processes[process_id - 1] = true;
            System.out.println("Process P" + process_id + "is up now");
        } else {
            System.out.println("Process P" + process_id + "is already up");
        }
    }

    void downprocess(int process_id) {
        if (!processes[process_id - 1]) {
            System.out.println("Process P" + process_id + "is already down");
        } else {
            processes[process_id - 1] = false;
            System.out.println("Process P" + process_id + "is down now");
        }
    }

    void runelection(int process_id) {
        if (!processes[process_id - 1]) {
            System.out.println("Process cannot initate message");

        }
        System.out.println("Process P" + process_id + "is initating process");
        boolean higherprocessfound = false;
        for (int i = process_id; i < max_process; i++) {
            if (processes[i]) {
                System.out.println("Election message is send from process P" + process_id + "to process P" + (i + 1));
                higherprocessfound = true;
            }
        }
        if (higherprocessfound) {
            for (int i = max_process - 1; i >= 0; i--) {
                if (processes[i]) {
                    coordinator = i + 1;
                    break;
                }
            }
        } else {
            coordinator = process_id - 1;
        }
        System.out.println("New Coordinator " + coordinator);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process");
        int n = sc.nextInt();

        Bully bully = new Bully(n);
        System.out.println("Enter which process you want to initate");
        int initiator = sc.nextInt();

        bully.runelection(initiator);
    }

}