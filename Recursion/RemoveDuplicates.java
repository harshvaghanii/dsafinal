package Recursion;

public class RemoveDuplicates {
    public static String removeDuplicates(String s) {
        int index = 0;
        StringBuilder sb = new StringBuilder("");
        boolean[] map = new boolean[26];
        return utility(s.toLowerCase(), index, sb, map);
    }

    public static String utility(String s, int index, StringBuilder sb, boolean[] map) {
        if (index == s.length())
            return sb.toString();
        if (map[s.charAt(index) - 97])
            return utility(s, index + 1, sb, map);
        map[s.charAt(index) - 97] = true;
        sb.append(s.charAt(index));
        return utility(s, index + 1, sb, map);
    }

    public static void main(String[] args) {
        String s = "appnnacollege";
        String res = removeDuplicates(s);
        System.out.println(res);
    }
}
