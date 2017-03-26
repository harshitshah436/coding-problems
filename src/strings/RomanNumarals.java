package strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class RomanNumarals {

    
    public static void main(String[] args) {
        System.out.println("Enter two positive integers");
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        
        int n = n1+n2;
        
        System.out.println(convertToRoman(n));
        in.close();
    }

    public static String convertToRoman(int n) {
        Map<String, Integer> romanMap = new LinkedHashMap<String, Integer>();
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);
        String str = "";
        for(Map.Entry<String, Integer> entry : romanMap.entrySet()){
          int matches = n/entry.getValue();
          str += repeat(entry.getKey(), matches);
          n = n % entry.getValue();
        }
        return str;
      }
    
      public static String repeat(String s, int n) {
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
      }

}
