package wyd;

import java.util.ArrayList;
import java.util.List;

public class The0017 {

    public static void main(String[] args) {
        The0017 the0017 = new The0017();
        List<String> strings = the0017.letterCombinations("23");
        strings.stream().forEach(p-> System.out.print(p + " "));
    }

    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        // 初始化手机按键映射
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return result;
    }

    public void backTracking(String digits, String[] numString, int num) {
        if (num == digits.length()){
            result.add(sb.toString());
            // 递归函数终点
            return;
        }

        // 第一层开始树横向（宽度）的遍历
        String letters = numString[(digits.charAt(num) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            // 交给下一层开始遍历
            backTracking(digits, numString, num + 1 );
            // 下一层调用完成，回溯，使得可以当前for可以遍历下一个元素
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
