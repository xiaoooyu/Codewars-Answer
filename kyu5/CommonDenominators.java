import java.util.*;

/*
Common denominators

You will have a list of rationals in the form

 { {numer_1, denom_1} , ... {numer_n, denom_n} }
or

 [ [numer_1, denom_1] , ... [numer_n, denom_n] ]
or

 [ (numer_1, denom_1) , ... (numer_n, denom_n) ]
where all numbers are positive ints.

You have to produce a result in the form

 (N_1, D) ... (N_n, D)
or

 [ [N_1, D] ... [N_n, D] ]
or

 [ (N_1', D) , ... (N_n, D) ]
or

{{N_1, D} ... {N_n, D}}
depending on the language (See Example tests)

in which D is as small as possible and

 N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
Example:

convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
 */

public class CommonDenominators {

  public static void main (String[] args) {
    long[][] lst;
    lst = new long[][] { {77,130}, {84,131}, {3,4} };
    // System.out.println(Fracts.convertFrac(lst)); 

    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    System.out.println(greatestCommonFactor(a, b));
  }

  // your code
  public static String convertFrac(long[][] lst) {
    // your code        
    long denom = 1;
    for(int i = 0; i < lst.length; i ++) {
      denom = lowestCommonDenom(denom, lst[i][1]);      
    }          

    System.out.println(String.format("denom: %d", denom));

    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < lst.length; i++) {
      long factor = denom / lst[i][1];
      builder.append(String.format("(%d,%d)",       
        lst[i][0] * factor, 
        lst[i][1] * factor));
    }

    return builder.toString();
  }  

  public static long lowestCommonDenom(long a, long b) {    
    return a * b / greatestCommonFactor(a, b);
  }

  public static long greatestCommonFactor(long a, long b) {
    System.out.println(String.format("%d, %d", a, b));
    return b == 0 ? a : greatestCommonFactor(b, a % b);
  }
}