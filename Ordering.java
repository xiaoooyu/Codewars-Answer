import java.util.Arrays;

public class Ordering {
	public static void main (String[] args) {
		System.out.println(args[0]);
		System.out.println(orderWord(args[0]));
	}

	public static String orderWord(String strng){
    	String result = "Invalid String!";
    	if (strng != null && strng.length() > 0) {
    		char[] chars = strng.toCharArray();
    		Arrays.parallelSort(chars);
    		result = new String(chars);
    	}

    	return result;
  	}	
}