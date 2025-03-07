import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BitMapVersion {

    public static void main(String[] args) throws FileNotFoundException {
        //int pn;
        int[] pn = new int[4000000];
        byte[] bitmap = new byte[1000000];
        int count = 0;
        long startTime, endTime, timeElapsed;

        Scanner inFile = new Scanner(new FileReader("pn.txt"));
        PrintWriter outFile = new PrintWriter("out.txt");

        while (inFile.hasNext()) {
            int n = inFile.nextInt();
            pn[count++] = n;
        }
        inFile.close();
        startTime = System.nanoTime();
        for (int x = 0; x < pn.length; x++) {
            int n = pn[x] - 2000000;
            int by = n / 8;
            int bi = n % 8;
            bitmap[by] = (byte)(bitmap[by] | 0x80 >>> bi);
        }
        /*while (inFile.hasNext()) {
            pn = inFile.nextInt() - 2000000;
            int by = pn / 8;
            int bi = pn % 8;
            bitmap[by] = (byte)(bitmap[by] | 0x80 >>> bi);
        }
        inFile.close();

         */
        endTime = System.nanoTime();
        for (int x = 0; x < bitmap.length; x++)
            for (int y = 0; y < 8; y++)
                if ((bitmap[x] & 0x80 >>> y) != 0)
                    outFile.println(x * 8 + 2000000 + y);

        outFile.close();

        timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
    }
}
