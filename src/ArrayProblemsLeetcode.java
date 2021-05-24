import java.util.*;

public class ArrayProblemsLeetcode {

    // monotonic array - both ways
    public boolean isMonotonic(int[] inpArray) {
        int increase = -1;
        for (int i = 1; i < inpArray.length; i++) {

            if (increase == -1 && inpArray[i] > inpArray[i - 1]) {
                increase = 1;
            } else if (increase == -1 && inpArray[i] < inpArray[i - 1]) {
                increase = 0;
            }

            if (increase > -1) {
                if (increase == 1 && inpArray[i] < inpArray[i - 1]) {
                    return false;
                } else if (increase == 0 && inpArray[i] > inpArray[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    // degree of an array - #697
    // key: keep track of the first occurence of element as well
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> countStore = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int index = 0;
        int max_freq = 1;
        int max_freq_element = nums[0];
        int result = 1;

        int left_count = 0, right_count = nums.length;
        for (int num : nums) {
            int new_count = countStore.getOrDefault(num, 0) + 1;
            if (new_count == 1) {
                first.put(num, index);
                countStore.put(num, 1);
            } else {
                countStore.put(num, new_count);
                if (new_count > max_freq) {
                    max_freq = new_count;
                    max_freq_element = num;
                    result = index - first.get(num) + 1;

                } else if (new_count == max_freq) {
                    if (index - first.get(num) + 1 < result) {
                        max_freq_element = num;
                        result = index - first.get(num) + 1;
                    }
                }
            }
            index++;
        }
        return result;
    }

    // arrayPartitionI . to solve
    public int arrayPairSum(int[] nums) {

        //[6,2,6,5,1,2]


        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

}


//     public int findShortestSubArray(int[] nums) {
//        int maxElement = maxFrequencyElementCount(nums);
//        int left_count = 0, right_count = nums.length-1;
//
//        while (left_count != right_count){
//            if(nums[left_count] != maxElement){
//                left_count++;
//            }
//
//            if(nums[right_count] != maxElement){
//                right_count--;
//            }
//
//            if(nums[right_count] == maxElement && nums[left_count]== maxElement)
//                break;
//        }
//        return right_count-left_count+1;
//    }
//
//    public int maxFrequencyElementCount (int [] nums){
//        Map<Integer, Integer> countStore = new HashMap<>();
//        int maxFrequency = 1;
//        int maxFrequencyElement = nums[0];
//
//        for (int num: nums) {
//            if(countStore.containsKey(num)){
//                int new_count = countStore.get(num) + 1;
//                if(new_count > maxFrequency){
//                    maxFrequency = new_count;
//                    maxFrequencyElement = num;
//                }
//                countStore.put(num, new_count);
//
//            } else{
//                countStore.put(num, 1);
//            }
//        }
//        return maxFrequencyElement;
//    }
