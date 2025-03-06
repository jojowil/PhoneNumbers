import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneThingy {

    public static void main(String[] args) throws FileNotFoundException {

        int n;
        int[] pn = new int[4000000];
        int count=0;
        long startTime, endTime, timeElapsed;

        startTime = System.nanoTime();
        Scanner inFile = new Scanner(new FileReader("pn.txt"));
        PrintWriter outFile = new PrintWriter("out.txt");

        while(inFile.hasNext()) {
            n = inFile.nextInt();
            pn[count++] = n;
        }
        inFile.close();

        Arrays.sort(pn);

        int last = -1;
        for (int x = 0; x < count; x++) {
            if ( pn[x] != last ) {
                outFile.println(pn[x]);
                last = pn[x];
            }
        }
        outFile.close();
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
    }
}
