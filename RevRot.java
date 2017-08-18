import java.util.Arrays;

public class RevRot {
	public static void main(String[] args) {
		String s = "733049910872815764";
        System.out.println(RevRot.revRot(s, 5));
        System.out.println(RevRot.rev(s.toCharArray()));
        System.out.println(RevRot.rot(s.toCharArray()));
	}

	public static String revRot(String strng, int sz) {
		if (strng == null || sz == 0 || sz > strng.length()) {
          return "";
        }

        System.out.println(strng);
        char[] chars = strng.toCharArray();
        int idx = 0;
        int baseIdx = 0;
        int max = chars.length;
        StringBuilder result = new StringBuilder();
        for(; baseIdx < max; baseIdx += sz) {
        	char[] buff = new char[sz];
        	if (baseIdx + sz <= max) {
        		int acculate = 0;
        		for (;idx < baseIdx + sz && idx < max; idx ++) {        		        	
        			char c = chars[idx];
        			acculate += Character.digit(c, 10);
        			buff[idx - baseIdx] = c;
        		}        	

        		if (acculate % 2 == 0) {
        			result.append(rev(buff));        			
        		} else {
        			result.append(rot(buff));        			
        		}
        		
        	}        	
        }        
        return result.toString();	
	}

	public static String rev(char[] chars) {		
		StringBuilder builder = new StringBuilder(chars.length);
		for(int i = chars.length - 1; i >= 0; i--) {
			builder.append(chars[i]);
		}
		return builder.toString();
	}

	public static String rot(char[] chars) {
		char first = chars[0];
		for(int i = 1; i < chars.length; i++) {
			chars[i - 1] = chars[i];
		}
		chars[chars.length - 1] = first;
		return new String(chars);
	}
}