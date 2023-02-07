package wyd;

public class The0005 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccbabccb"));
    }


    public static String MylongestPalindrome(String s) {
        int length = s.length();
        boolean[][] result = new boolean[length][length];
        // 初始化
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result[i][j] = false;
            }
        }

        int desI = 0,desJ = 0,desL = 0;
        // 赋值
        for (int i = length-1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 2){
                        if (j-i>=desL){
                            // 获取最长回文串起始位置和末尾位置
                            desL = j - i;
                            desI = i;
                            desJ = j;
                        }
                        result[i][j] = true;
                    }else if (result[i+1][j-1]){
                        if (j-i>=desL){
                            // 获取最长回文串起始位置和末尾位置
                            desL = j - i;
                            desI = i;
                            desJ = j;
                        }
                        result[i][j] = true;
                    }
                }else {
                    result[i][j] = false;
                    continue;
                }
            }
        }
        String resultString = s.substring(desI, desJ + 1);
        return resultString;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        int length = 1;
        int index = 0;
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            palindrome[i][i] = true;
        }

        for (int L = 2; L <= s.length(); L++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + L - 1;
                if (j >= s.length()) break;
                if (s.charAt(i) != s.charAt(j)) {
                    palindrome[i][j] = false;
                } else {
                    if (j - i < 3) {
                        palindrome[i][j] = true;
                    } else {
                        palindrome[i][j] = palindrome[i + 1][j - 1];
                    }
                }
                if (palindrome[i][j] && j - i + 1 > length) {
                    length = j - i + 1;
                    index = i;
                }
            }
        }
        return s.substring(index, index + length);
    }
}
