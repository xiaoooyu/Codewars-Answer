import java.util.function.Function;
import java.util.stream.*;
import java.util.*;

/***
This kata is the first of a sequence of four about "Squared Strings".

You are given a string of n lines, each substring being n characters long: For example:

s = "abcd\nefgh\nijkl\nmnop"

We will study some transformations of this square of strings.

Vertical mirror: vert_mirror (or vertMirror or vert-mirror)
vert_mirror(s) => "dcba\nhgfe\nlkji\nponm"
Horizontal mirror: hor_mirror (or horMirror or hor-mirror)
hor_mirror(s) => "mnop\nijkl\nefgh\nabcd"
or printed:

vertical mirror   |horizontal mirror   
abcd --> dcba     |abcd --> mnop 
efgh     hgfe     |efgh     ijkl 
ijkl     lkji     |ijkl     efgh 
mnop     ponm     |mnop     abcd
#Task:

Write these two functions
and

high-order function oper(fct, s) where

fct is the function of one variable f to apply to the string s (fct will be one of vertMirror, horMirror)
#Examples:

s = "abcd\nefgh\nijkl\nmnop"
oper(vert_mirror, s) => "dcba\nhgfe\nlkji\nponm"
oper(hor_mirror, s) => "mnop\nijkl\nefgh\nabcd"
Note:

The form of the parameter fct in oper changes according to the language. You can see each form according to the language in "Your test cases".
Forthcoming katas will study other tranformations.
***/

public class MovesInSquaredStrings {
    public static void main(String[] args) {
        System.out.println("Fixed Tests vertMirror");
        String s = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu";
        System.out.println(Opstrings.oper(Opstrings::vertMirror, s));

        System.out.println("Fixed Tests horMirror");
        s = "lVHt\nJVhv\nCSbg\nyeCt";
        System.out.println(Opstrings.oper(Opstrings::horMirror, s));        
    }

    static class Opstrings {
        static final String boundary = "\n";

        public static String oper(Function<String, String> operator, String s) {
            return operator.apply(s);
        }

        public static String vertMirror (String strng) {
            return split(strng)
                .stream()
                .map(s -> reverse(s))
                .collect(Collectors.joining(boundary));
        }

        public static String horMirror (String strng) {
            return reverse(split(strng)).stream().collect(Collectors.joining(boundary));
        }

        public static List<String> split(String strng) {
            return Arrays.asList(strng.split(boundary));
        }

        public static String reverse(String strng) {
            return new StringBuffer(strng).reverse().toString();
        }        

        public static List<String> reverse(List<String> list) {
            Collections.reverse(list);
            return list;
        }        
    }
}