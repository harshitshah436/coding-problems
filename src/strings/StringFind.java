package strings;

public class StringFind {
    public static void main(String[] args) {
        String s = "Harshitsshahdimaesigoad adkfoa kd aldfksk";
        String s1 = "a";
        String s2 = "d";

        int min_string_length = s.length() - 1, min_index = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                String str = s.substring(i);
                int j = str.indexOf(s2);
                if (j < min_string_length) {
                    min_string_length = j + 1;
                    min_index = i;
                    s1 = s.substring(min_index, min_index + min_string_length);
                }
            }
        }
        if (min_index == s.length() - 1)
            System.out.println("No string combination found");
        else {
            System.out.println(min_index);
            System.out.println(s1);
        }
    }
}
