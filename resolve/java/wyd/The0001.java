package wyd;

import java.util.HashMap;
import java.util.Map;

public class The0001 {
    // 两数之和
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public static int[] myTwoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap();
        for(int i = 0; i < nums.length ; i ++ ){
            int num = nums[i];
            int needed = target - num;
            Integer neededIndex = map.get(needed);
            if(neededIndex == null){
                map.put(nums[i], i);
                continue;
            }
            return new int[]{ neededIndex,i};
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }
}
