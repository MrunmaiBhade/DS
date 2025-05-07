import java.util.*;

public class BerkelyeAlgorithm {
    public static void main(String[] args) {
        double mastertime = System.currentTimeMillis() / 1000.0;

        double[] slavestime = {
                mastertime + Math.random() * 10 - 5,
                mastertime + Math.random() * 10 - 5,
                mastertime + Math.random() * 10 - 5
        };
        System.out.println("Original master time:" + mastertime);
        System.out.println("Original slave time" + Arrays.toString(slavestime));
        double[] differences = new double[slavestime.length];
        double totaldifference = 0;
        for (int i = 0; i < slavestime.length; i++) {
            differences[i] = slavestime[i] - mastertime;
            totaldifference += differences[i];
        }
        double averagedifference = totaldifference / (slavestime.length + 1);
        mastertime += averagedifference;
        for (int i = 0; i < slavestime.length; i++) {
            slavestime[i] -= differences[i];
            slavestime[i] += averagedifference;
        }
        System.out.println("Synchronized master time is:" + mastertime);
        System.out.println("Synchornized slave time:" + Arrays.toString(slavestime));
    }
}