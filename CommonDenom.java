import java.util.*;

public class CommonDenom {

  public static void main (String[] args) {
    long[][] lst;
    lst = new long[][] { {77,130}, {84,131}, {3,4} };
    System.out.println(CommonDenom.convertFrac(lst)); 
  }

  // your code
  public static String convertFrac(long[][] lst) {
    // your code    
    long[][] denoms = new long[lst.length][];

    for(int i = 0; i < lst.length; i ++) {
      denoms[i] = computeDenom(lst[i][1]);      
    }
    
    long denom = computeCommonDenom(denoms);
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
  
  public static long computeCommonDenom(long[][] denoms) {
      int outerIdx = 0;
      long commonDenom = 1;
      while (outerIdx < denoms.length) {        
        for (int i = 0; i < denoms[outerIdx].length; i++) {
          long oneDenom = denoms[outerIdx][i];
          if (oneDenom != 1) {
            commonDenom *= oneDenom;
            denoms[outerIdx][i] = 1;
            
            for (int j = outerIdx + 1; j < denoms.length; j++) {
              for (int k = 0; k < denoms[j].length; k ++) {
                if (denoms[j][k] == oneDenom) {
                  denoms[j][k] = 1;
                  break;
                }
              }
            }
          }
        }
        outerIdx ++;
      }
      
      return commonDenom;
  }

  public static long[] computeDenom(long num) {
    ArrayList<Long> denoms = new ArrayList<>();
    if (isPrimary(num)) {
      denoms.add(num);      
    } else {
      long i = 2;
      while(i <= num) {
        if (isPrimary(i)) {
          if (num % i == 0) {
            denoms.add(new Long(i));
            num /= i;            
            continue;
          } 
        }
        i ++;
      }      
    }

    long[] denomArray = new long[denoms.size()];
    for (int i = 0; i < denoms.size(); i ++) {
      denomArray[i] = denoms.get(i).longValue();
    }

    return denomArray;
  }

  public static boolean isPrimary(long num) {
    int squareRoot = (int) Math.sqrt(num);
    // System.out.println(squareRoot);
    for (int i = squareRoot; i > 1; i --) {
      if (num % i == 0) {
        return false;
      }
    }    
    return true;
  }
}