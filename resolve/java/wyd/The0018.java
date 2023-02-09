package wyd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class The0018 {
    // 四数之和
    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        List<List<Integer>> lists = fourSum(nums, -11);
        lists.stream().forEach(p -> {
            for (int i = 0; i < p.size(); i++) {
                System.out.print(p.get(i) + " ");
            }
            System.out.println();
        });
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        int length = nums.length;

        if (length < 4 ) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            int test = nums[i];
            // 对第一个数进行去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < length; j++) {

                // 对第二个数进行去重
                if (j - i > 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = length - 1;
                while (right > left) {
                    long sum = (long) nums[j] + nums[left] + nums[right] + nums[i];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        // 得到一个符合条件的结果
                        List<Integer> oneResult = new ArrayList<>();
                        oneResult.add(nums[i]);
                        oneResult.add(nums[j]);
                        oneResult.add(nums[left]);
                        oneResult.add(nums[right]);
                        result.add(oneResult);

                        // 对第三个数进行去重
                        while (left < right && nums[left] == nums[left+1])left++ ;
                        // 对第四个数进行去重
                        while (left < right && nums[right] == nums[right-1])right-- ;

                        left++;
                        right--;
                    }
                }
            }

        }
        return result;
    }
}
