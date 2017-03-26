package strings;

public class StringCompress {
    public static void main(String[] args) {
        String string = "aaabbbcc";
        String temp = "Harsssshitppfriend";

        System.out.println(strCompress(string));
        System.out.println(strCompress(temp));
        System.out.println(strCompress2(temp));
        System.out.println(strCompress2(string));
    }

    private static String strCompress(String string) {
        String result = "";
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                count++;
            } else {
                result += getCharAndCount(string, count, i);
                count = 1;
            }
            if (i == string.length() - 1)
                result += getCharAndCount(string, count, ++i);
        }
        return result;
    }

    private static String getCharAndCount(String string, int count, int i) {
        return "" + string.charAt(i - 1) + (count > 1 ? count : "");
    }

    private static String strCompress2(String string) {
        if (string.length() < 2) {
            return string;
        }
        
        for (int i = 0; i < string.length(); i++) {
            int c = i + 1;
            while (c < string.length() && string.charAt(c) == string.charAt(i)) {
                c++;
            }
            if (c - i >1) {
                string = string.substring(0, i + 1) + (c - i) + string.substring(c);
                i++;
            }
        }
        return string;
    }
}
