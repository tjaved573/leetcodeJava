import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProblemsLeetcodeTest {

    @Test
    void isMonotonicIncreasing() {
        int [] input = new int[] {8,5,4,3,2,1,2,3,4,5};
        ArrayProblemsLeetcode a = new ArrayProblemsLeetcode();
        System.out.println(a.isMonotonic(input));

    }

    @Test
    void isMonotonicDecreasing() {
        int [] input = new int[] {1,2,3,3,3,3,4,4,4,5,6,6};
        ArrayProblemsLeetcode a = new ArrayProblemsLeetcode();
        System.out.println(a.isMonotonic(input));

    }

    @Test
    void findMaxELementTest() {
        int [] input = new int[] {3,3,3};
        ArrayProblemsLeetcode a = new ArrayProblemsLeetcode();
        System.out.println(a.findShortestSubArray(input));
    }

    @Test
    void findShortestSubArrayTest() {
        int [] input = new int[] {2,1};
        ArrayProblemsLeetcode a = new ArrayProblemsLeetcode();
        int ans = a.findShortestSubArray(input);
        System.out.println(ans);
    }

    @Test
    void partitionArrayTest() {
        int [] input = new int[] {1,4,3,2};
        ArrayProblemsLeetcode a = new ArrayProblemsLeetcode();
        int ans = a.arrayPairSum(input);
        System.out.println(ans);
    }

    @Test
    void nestingTest() {
        int [] input = new int[] {5,4,0,3,1,6,2};
        ArrayProblemsLeetcode a = new ArrayProblemsLeetcode();
        int ans = a.arrayNesting(input);
        System.out.println(ans);
    }
}