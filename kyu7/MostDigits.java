import java.util.stream.*;
import java.util.*;

public class MostDigits {

  public static void main(String[] args) {
    System.out.println(MostDigits.findLongest(new int[] {-10, 1, 0, 1, 10}));
  }

  public static int findLongest(int[] numbers) {
    return Arrays.stream(numbers).reduce((a, b) -> {
        if (Math.ceil(Math.log10(Math.abs(b))) > Math.ceil(Math.log10(Math.abs(a)))) {
            return b;
        } else {
            return a;
        }
    }).getAsInt();
  }
}