import java.util.*;

/*
In this kata you parse RGB colors represented by strings. The formats are primarily used in HTML and CSS. Your task is to implement a function which takes a color as a string and returns the parsed color as a map (see Examples).

Input:

The input string represents one of the following:

6-digit hexadecimal - "#RRGGBB"
e.g. "#012345", "#789abc", "#FFA077"
Each pair of digits represents a value of the channel in hexadecimal: 00 to FF
3-digit hexadecimal - "#RGB"
e.g. "#012", "#aaa", "#F5A"
Each digit represents a value 0 to F which translates to 2-digit hexadecimal: 0->00, 1->11, 2->22, and so on.
Preset color name
e.g. "red", "BLUE", "LimeGreen"
You have to use the predefined map PRESET_COLORS (JavaScript, Python, Ruby), presetColors (Java, C#, Haskell), or preset-colors (Clojure). The keys are the names of preset colors in lower-case and the values are the corresponding colors in 6-digit hexadecimal (same as 1. "#RRGGBB").
Examples:
```
parse("#80FFA0")   === new RGB(128, 255, 160))
parse("#3B7")      === new RGB( 51, 187, 119))
parse("LimeGreen") === new RGB( 50, 205,  50))

// RGB class is defined as follows:
final class RGB {
    public int r, g, b;

    public RGB();
    public RGB(int r, int g, int b);
}
```
*/
public class HtmlColorParser {        
    // private final Map<String, String> presetColors;

    // public HtmlColorParser(Map<String, String> presetColors) {
    //     this.presetColors = presetColors;
    // }

    // public RGB parse(String color) {
    //     if (!color.startWith("#")) {
    //         return presetColors.get(color.toLowerCase());
    //     }

    //     return new RGB(0, 128, 255);
    // }

    private final Map<String, String> presetColors;

    public HtmlColorParser(Map<String, String> presetColors) {
        this.presetColors = presetColors;
    }

    public RGB parse(String color) {
        if (!color.startsWith("#")) {
            color = presetColors.get(color.toLowerCase());
        }
              
        if (color != null && color.startsWith("#")) {
          color = color.substring(1, color.length());
          if (color.length() == 3) {
            return parseRGB(color);
          } else if (color.length() == 6) {
            return parseRRGGBB(color);
          }
        }
        
        return new RGB(0, 0, 0);
    }
    
    public RGB parseRGB(String rgb) {
      return parseRRGGBB(doubleRGB(rgb));
    }
    
    public RGB parseRRGGBB(String rrggbb) {
      return new RGB(parseInt(rrggbb.substring(0,2)), parseInt(rrggbb.substring(2, 4)), parseInt(rrggbb.substring(4)));
    }
    
    public int parseInt(String str) {
      return Integer.parseInt(str, 16);
    }
    
    public static String doubleRGB(String rgb) {
      char[] chars = rgb.toCharArray();
      char[] finalChars = new char[chars.length * 2];
      for (int i = 0; i < chars.length; i++) {          
          finalChars[2 * i] = chars[i];
          finalChars[2 * i + 1] = chars[i];
      }
      return new String(finalChars);
    }

    public static void main(String[] args) {
        System.out.println(doubleRGB("abc"));
        System.out.println(Integer.parseInt("80", 16));
    }
    
    // RGB class is defined as follows:
    final static class RGB {
      public int r, g, b;

      public RGB(){};
      public RGB(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
      };
    }
}