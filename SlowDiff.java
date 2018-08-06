import java.io.BufferedReader;
import java.nio.file.*;

/**
 * Read two files line by line and compare.
 * If a pair of lines matches, there is no output.
 * Otherwise, each line in the pair is printed and prefixed by the line
 * number.  A line containing 10 dashes separates differing pairs.
 *
 * Useful for very large (many GB) files on limited-memory
 * systems (e.g. small VMs).
 */
public class SlowDiff {

  public static void main(String[] args) throws Exception {
    BufferedReader a = Files.newBufferedReader(Paths.get(args[0]));
    BufferedReader b = Files.newBufferedReader(Paths.get(args[1]));

    String aLine = a.readLine();
    String bLine = b.readLine();

    int count = 1;
    while (aLine != null && bLine != null) {
      if (!aLine.equals(bLine)) {
        System.out.println(count + ": " + aLine);
        System.out.println(count + ": " + bLine);
        System.out.println("----------");
      }

      aLine = a.readLine();
      bLine = b.readLine();
      count++;
    }
  }

}
