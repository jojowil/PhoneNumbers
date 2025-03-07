import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneThingy {

    public static void main(String[] args) throws FileNotFoundException {

        int n;
        int[] pn = new int[4000000];
        int count = 0;
        long startTime, endTime, timeElapsed;


        Scanner inFile = new Scanner(new FileReader("pn.txt"));
        PrintWriter outFile = new PrintWriter("out.txt");


        while (inFile.hasNext()) {
            n = inFile.nextInt();
            pn[count++] = n;
        }
        inFile.close();
        startTime = System.nanoTime();
        Arrays.sort(pn);
        endTime = System.nanoTime();
        int last = -1;
        for (int x = 0; x < count; x++) {
            if (pn[x] != last) {
                outFile.println(pn[x]);
                last = pn[x];
            }
        }
        outFile.close();

        timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
    }
}
