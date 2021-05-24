import java.util.*;

public class ctci_chap_one {

    // find all unique characters in string!!!!!
    public boolean isUnique(String param) {
        boolean flag = true;
        for (int i = 0; i < param.length() - 1; i++) {
            if (param.charAt(i) != param.charAt(i + 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // check if one string is permutation of the other
    public boolean checkPermutation(String param_1, String param_2) {
        boolean flag = true;
        int left_len = param_1.length();
        int right_len = param_2.length();

        if (left_len < 1 && right_len < 1) {
            return true;
        } else if (left_len != right_len) {
            return false;
        }

        Map<Character, Integer> visited = new HashMap<>();
        for (int i = 0; i < param_1.length(); i++) {
            visited.put(param_1.charAt(i), 1);
        }
        for (int j = 0; j < param_2.length(); j++) {
            if (!visited.containsKey(param_2.charAt(j))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // URLify - incorrect
    public char[] urlify(char[] param) {
        int i = 0;
        while (i < param.length) {
            if (param[i] == ' ') {
                param[i++] = '%';           // post increment - assign first, increment later
                param[i++] = '2';
                param[i] = '0';
            }
            i += 1;
        }
        return param;
    }

    // palindrome permutation
    // could also use bit manipulation for this. keep on shifting bits on and off. check if only 1 bit is one at the end
    public boolean palindromePermutation(String param) {
        boolean answer = true;
        if (param.length() <= 1) {
            return true;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < param.length(); i++) {
            if (charCount.containsKey(param.charAt(i))) {       // if the key exists in
                charCount.put(param.charAt(i), charCount.get(param.charAt(i)) + 1);
            } else {
                charCount.put(param.charAt(i), 1);
            }
        }

        int even_flag = 0;
        if (param.length() % 2 == 0) {
            even_flag = 1;
        }

        if (even_flag == 1) {
            for (char keyy : charCount.keySet()) {
                if (charCount.get(keyy) % 2 == 1) {       // if any key has odd sum of values
                    answer = false;
                    break;
                }
            }

            if (!answer) {
                return false;
            }

        } else {
            boolean local_flag = false;

            for (char keyy : charCount.keySet()) {
                if (!local_flag && charCount.get(keyy) % 2 == 1) {       // if any key has odd sum of values
                    local_flag = true;
                } else if (local_flag) {
                    System.out.println(keyy);
                    System.out.println(charCount.get(keyy));
                    if (charCount.get(keyy) % 2 == 1) {
                        return false;
                    }
                }
            }
        }

        return answer;
    }

    // One away: insert, replace or remove a character. Find if they are one edit away
    // merge this into one
    public boolean oneAway(String param1, String param2) {

        int lowest_index = -1;
        boolean answer = true;
        int numChanges = 0;
        int l1 = param1.length();
        int l2 = param2.length();

        // if both have the same length, can only replace the characters.
        if (l1 == l2) {
            for (int i = 0; i < l1; i++) {
                if (param1.charAt(i) != param2.charAt(i)) {
                    numChanges += 1;
                    if (numChanges > 1) {
                        answer = false;
                        break;
                    }
                }
            }

        } else if (l1 > l2) {        // if len left > len right, can insert/replace character
            int left_counter, right_counter, space_counter;
            left_counter = right_counter = space_counter = 0;
            while (left_counter < l1 && right_counter < l2) {
                if (param1.charAt(left_counter) != param2.charAt(right_counter)) {
                    // replace a new character
                    if (param1.charAt(left_counter + 1) == param2.charAt(right_counter)) {
                        left_counter++;
                        space_counter++;
                    }

                    // add a space character
                    numChanges++;
                    if (numChanges > 1) {
                        answer = false;
                        break;
                    }
                }

                left_counter++;
                right_counter++;
            }

            if (numChanges == 0 && l1 - right_counter > 1) {       // remaining substring length > 2
                answer = false;
            } else if (space_counter == 0 && numChanges == 1 && l1 - right_counter >= 1) {       // if remaining substring length >= 1
                answer = false;
            }

        } else {        // l1 < l2

            int left_counter, right_counter, space_counter;
            left_counter = right_counter = space_counter = 0;
            while (left_counter < l1 && right_counter < l2) {
                if (param1.charAt(left_counter) != param2.charAt(right_counter)) {
                    if (param1.charAt(left_counter) == param2.charAt(right_counter + 1)) {     // add a space
                        right_counter++; // add a space character
                        space_counter++;
                    }
                    numChanges++;
                    if (numChanges > 1) {
                        answer = false;
                        break;
                    }
                }
                left_counter++;
                right_counter++;
            }

            if (numChanges == 0 && l2 - left_counter > 1) {         // if the missing substring has length > 1
                answer = false;
            } else if (space_counter == 0 && numChanges == 1 && l2 - left_counter >= 1) {
                answer = false;
            }

        }
        return answer;
    }

    // String compression
    public String strCompression(String param1) {
        if (param1.length() == 0) {
            return param1;
        }

        StringBuilder answer = new StringBuilder(param1);
        StringBuilder compressedVersion = new StringBuilder();
        char currentChar = param1.charAt(0);
        int currCharLen = 1;
        compressedVersion.append(currentChar);

        for (int i = 1; i < param1.length(); i++) {
            if (param1.charAt(i) == currentChar) {
                currCharLen++;
            } else {
                compressedVersion.append(currCharLen);
                currentChar = param1.charAt(i);
                currCharLen = 1;
                compressedVersion.append(currentChar);
            }
        }
        compressedVersion.append(currCharLen);

        if (compressedVersion.length() >= answer.length()) {
            return answer.toString();
        }
        return compressedVersion.toString();
    }

    // Zero Matrix: if an element is zero, set entire row and column to zero
    public int[][] zeroMatrix(int[][] inpMatrix) {

        boolean update = false;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < inpMatrix.length; i++) {
            for (int j = 0; j < inpMatrix[i].length; j++) {
                if (inpMatrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                    update = true;
                }
            }
        }

        if (update) {
            for (int col : cols) {
                for (int rowIter = 0; rowIter < inpMatrix.length; rowIter++) {
                    inpMatrix[rowIter][col] = 0;
                }
            }

            for (int row : rows) {
                for (int colIter = 0; colIter < inpMatrix.length; colIter++) {
                    inpMatrix[row][colIter] = 0;
                }
            }
        }

        return inpMatrix;
    }

    // Given an N*N matrix, rotate the image by 90 degrees.
    // when rotating a matrix by 90 degree, the rows and columns become inverted
    public void fourWayRotate(int[][] inpMatrix) {
        int temp;
        int lastCol = inpMatrix.length;

        int tally = 0;
        int start = 0, end = lastCol;

        while (tally <= lastCol/2) {
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            if (start != end) {
                for (int i = start; i < 1 + end / 2; i++) {
                    // we run for only half + 1, because we don't want to override the corner
                    // points again. We only want to shift the number between the corner
                    // edges. We rotate layer by layer.

                    // save right col
                    temp = inpMatrix[i][end - 1];

                    // shift top row into right col
                    inpMatrix[i][end - 1] = inpMatrix[start][i];

                    // shift left col into top row  - problem on RHS!
                    inpMatrix[start][i] = inpMatrix[end - 1 - i][start];

                    // shift bottom row into left col - ****
                    inpMatrix[end - 1 - i][start] = inpMatrix[end - 1][end - 1 - i];

                    // shift temp into bottom row
                    inpMatrix[end - 1][end - 1 - i] = temp;
                }
            }
            start++;
            end--;
            tally++;
        }


    }

    public void rotateMatrix(int[][] inpMatrix) {
        System.out.println("original input matrix = ");
        System.out.println(Arrays.deepToString(inpMatrix));
        fourWayRotate(inpMatrix);

        System.out.println("rotated input matrix = ");
        System.out.println(Arrays.deepToString(inpMatrix));
    }

    // assume with one call to method isSubstring, check if s2 is a substring of s1.
    public boolean strRotation(String original, String shifted){

        // find first occurrence of mismatch between strings
        int mismatch_index = 0;
        int local = 0;
        boolean flag = true;

        // find substring IN SHIFTED string up to starting character in original string
        for (int i = 0; i < shifted.length(); i++) {
            if (shifted.charAt(i) != original.charAt(0)){
                mismatch_index++;
            } else break;
        }

        String subComp = shifted.substring(0, mismatch_index);
        if (isSubstring(original, subComp)){
            // check if substring [m...end] in SHIFTED matches ORIGINAL string
            for (int j = mismatch_index; j < shifted.length(); j++){
                if(shifted.charAt(j) != original.charAt(local)){
                    flag = false;
                    break;
                }
                local++;
            }
        } else flag = false;
        return flag;
    }

    // check if component is substring of org. GIVEN FUNCTION: works in O(nm)
    public boolean isSubstring(String org, String component){
        int curr = 0;
        int compLen = component.length();
        int orgLen = org.length();

        if (compLen == 0) return true;          // empty component string
        if (compLen > orgLen || orgLen == 0) return false;  // original string is empty

        while (curr <= orgLen-compLen){
            if (org.substring(curr, compLen+curr).equals(component)){
                return true;
            }
            curr++;
        }
        return false;
    }

    public static void main(String[] args) {
        ctci_chap_one cp = new ctci_chap_one();
        int [][] testInp = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        cp.rotateMatrix(testInp);
    }


}
