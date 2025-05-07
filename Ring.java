import java.util.*;

public class Ring {
    int coordinator;
    int max_process;
    boolean[] processes;

    public Ring(int max) {
        max_process = max;
        processes = new boolean[max_process];
        coordinator = max;

        for (int i = 0; i < max_process; i++) {
            processes[i] = true;
            System.out.println("Process P" + (i + 1) + "is created and is up now");

        }
        System.out.println("Initial coordinator is:" + coordinator);
        System.out.println("Current coordinator is:" + coordinator);
    }

    void upprocess(int process_id) {
        if (!processes[process_id - 1]) {
            processes[process_id - 1] = true;
            System.out.println("Process P" + process_id + "is up now");
        } else {
            System.out.println("Process P" + process_id + "is already active");
        }
    }

    void downprocess(int process_id) {
        if (!processes[process_id - 1]) {
            System.out.println("Process p" + process_id + "is alrady down");
        } else {
            processes[process_id - 1] = false;
        }
    }

    void initelection(int process_id) {
        if (!processes[process_id - 1]) {
            System.out.println("Process cannot initiate");
        }
        System.out.println("Process P" + process_id + "is initiating process");
        ArrayList<Integer> pidlist = new ArrayList<>();
        int current = process_id - 1;
        do {
            if (processes[current]) {
                pidlist.add(current);
                System.out.println("Process P" + (current + 1) + "can send message");
                System.out.println(pidlist);
            }
            current = (current + 1) % max_process;
        } while (current != process_id - 1);
        coordinator = Collections.max(pidlist);
        System.out.println("New coordinator" + coordinator);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process");
        int n = sc.nextInt();

        Ring ring = new Ring(n);
        System.out.println("Enter which process to initate");
        int initator = sc.nextInt();

        ring.initelection(initator);
    }

}