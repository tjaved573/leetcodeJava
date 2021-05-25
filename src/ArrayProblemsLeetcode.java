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
    // key: keep track of the first occurrence of element as well
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

    // arrayPartitionI to solve
    public int arrayPairSum(int[] nums) {

        //[6,2,6,5,1,2]


        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

    // LC: #565. Array Nesting
    public int arrayNesting(int[] nums) {

        int maxLen = 0;
        Set <Integer> valuesExplored = new HashSet<>();     // to keep track of visited values

        Set <Integer> allValues = new HashSet<>();          // to track which values have not been visited
        for (int i = 0; i < nums.length; i++) {
            allValues.add(i);
        }

        int currentValueIndex;
        int currentValue;
        int count = 0;

        while(allValues.size() != 0){
            currentValueIndex = allValues.iterator().next();  // fetch next unexplored value in hashset
            allValues.remove(currentValueIndex);
            currentValue = nums[currentValueIndex];
            maxLen = Integer.max( maxLen, dfs(nums, currentValue, valuesExplored,allValues));
        }

        return maxLen;
    }

        public int dfs(int [] nums, int currVertex, Set<Integer> valuesExplored, Set<Integer> allValues){

            if (valuesExplored.contains(currVertex)) return 0;

            valuesExplored.add(currVertex);
            allValues.remove(currVertex);

            int currentVal = nums[currVertex];              // next value
            int ans = dfs(nums, currentVal, valuesExplored, allValues);

            return ans+1;
        }
}

// start with brute force
//        /for (int i = 0; i < nums.length; i++) {
//
//            Set<Integer> valuesVisited = new HashSet<>();
//            int start = i;
//            valuesVisited.add(nums[start]);
//            int next = nums[nums[start]];
//
//            while (!valuesVisited.contains(next)){
//                valuesVisited.add(next);
//                next = nums[next];
//            }
//
//            if (valuesVisited.size() > maxLen) maxLen = valuesVisited.size();
//        }


