package wyd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class The0015 {

    public static void main(String[] args) {
        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{1,1,1};

        List<List<Integer>> lists = threeSum(nums);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0 || nums.length == 0 ) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            // 处理第一个数重复
            if (i>0 && nums[i-1] == nums[i] ){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if ( nums[i] + nums[left] + nums[right] > 0 ){
                    right --;
                } else if ( nums[i] + nums[left] + nums[right] < 0 ){
                    left ++;
                } else {
                    // 得到第一次可以返回的结果，然后要对right和left进行去重
                    List temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    right --;
                    left ++;
                }
            }
        }
        return result;
    }

}
