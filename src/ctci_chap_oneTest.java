import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ctci_chap_oneTest {

    @Test
    void isUnique() {
        ctci_chap_one sb = new ctci_chap_one();
        StringBuilder sp = new StringBuilder("aaaa");
        assertEquals(true, sb.isUnique(sp.toString()));
    }

    @Test
    void isNotUnique() {
        ctci_chap_one sb = new ctci_chap_one();
        StringBuilder sp = new StringBuilder("hadfha");
        assertEquals(false, sb.isUnique(sp.toString()));
    }

    @Test
    void isPermutationIncorrectString() {
        ctci_chap_one sb = new ctci_chap_one();
        String left = "alpha";
        String right = "bravo";
        boolean ans = sb.checkPermutation(left, right);
        assertEquals(false, ans);
    }

    @Test
    void isPermutationDifferentLengthString() {
        ctci_chap_one sb = new ctci_chap_one();
        String left = "alphfadsfasa";
        String right = "bravo";
        boolean ans = sb.checkPermutation(left, right);
        assertEquals(false, ans);
    }

    @Test
    void isPermutationCorrect() {
        ctci_chap_one sb = new ctci_chap_one();
        String left = "please";
        String right = "elpase";
        boolean ans = sb.checkPermutation(left, right);
        assertEquals(true, ans);
    }

    @Test
    void isPermutationEmptyString() {
        ctci_chap_one sb = new ctci_chap_one();
        String left = "";
        String right = "";
        boolean ans = sb.checkPermutation(left, right);
        assertEquals(true, ans);
    }

   //  -------------- PALINDROME PERMUTATION --------
    @Test
    void checkValidPermutationExistsCorrect() {
        ctci_chap_one sb = new ctci_chap_one();
        boolean answer = sb.palindromePermutation("oolss");
        assertEquals(true, answer);
    }

    @Test
    void checkValidPermutationExistsIncorrect() {
        ctci_chap_one sb = new ctci_chap_one();
        boolean answer = sb.palindromePermutation("fdsafjlds");
        assertEquals(false, answer);
    }

    // ONE AWAY -----
    @Test
    void oneAway() {
        ctci_chap_one sb = new ctci_chap_one();
        String str1 = "okk";
        String str2 = "kkp";
        boolean answer = sb.oneAway(str1, str2);
        assertEquals(false,answer);
    }

    // Compressed Version   --------
    @Test
    void compStringCheckForEmptyString() {
        ctci_chap_one sb = new ctci_chap_one();
        String str1 = "";
        String answer = sb.strCompression(str1);
        System.out.println(answer);
        assertEquals(str1 ,answer);
    }

    @Test
    void compStringCompressLength() {
        ctci_chap_one sb = new ctci_chap_one();
        String str1 = "aabbccdddsdssssssssssssee";
        String answer = sb.strCompression(str1);
        System.out.println(answer);
        assertNotEquals(str1 ,answer);
    }

    @Test
    void compStringCompressEqualsOriginal() {
        ctci_chap_one sb = new ctci_chap_one();
        String str1 = "aabbccddee";
        String answer = sb.strCompression(str1);
        assertEquals(str1 ,answer);
    }

    @Test
    void zeroMatrixNoZeros() {
        ctci_chap_one sb = new ctci_chap_one();
        int [][] testInp = new int[][]{
                {1,2,3},
                {4,5,5},
                {7,8,9},
        };
        System.out.println(Arrays.deepToString(sb.zeroMatrix(testInp)));
    }

    @Test
    void zeroMatrixZeros() {
        ctci_chap_one sb = new ctci_chap_one();
        int [][] testInp = new int[][]{
                {1,0,3},
                {4,5,0},
                {7,8,9},
        };
        System.out.println(Arrays.deepToString(sb.zeroMatrix(testInp)));
    }

    @Test
    void checkForSubstring() {
        ctci_chap_one inst = new ctci_chap_one();
        String big = "alpha";
        String small = "aha";
        System.out.println(inst.isSubstring(big, small));
    }

    @Test
    void testRotatedArray4DArray() {
        ctci_chap_one sb = new ctci_chap_one();
        int [][] testMatrix = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };


        int [][] expected = new int [][]{
                {13,9,5,1},
                {14,10,6,2},
                {15,11,7,3},
                {16,12,8,4},
        };
        sb.rotateMatrix(testMatrix);
        assertEquals(expected,testMatrix);
    }


    @Test
    void testRotatedArray3DArray() {
        ctci_chap_one sb = new ctci_chap_one();
        int [][] testMatrix = new int[][] {
                {1,2,3},
                {5,6,7},
                {8,9,10}
        };


        int [][] expected = new int [][]{
                {8,5,1},
                {9,6,2},
                {10,7,3},
        };
        sb.rotateMatrix(testMatrix);
        assertEquals(expected,testMatrix);

    }
}

