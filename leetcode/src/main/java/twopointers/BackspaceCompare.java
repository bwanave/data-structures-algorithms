package twopointers;

/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 * <p>
 * Example 1:
 * <p>
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * <p>
 * Example 2:
 * <p>
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * <p>
 * Example 3:
 * <p>
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * <p>
 * Example 4:
 * <p>
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
class BackspaceCompare {

    public static boolean compare(String str1, String str2) {

        int i = str1.length() - 1, j = str2.length() - 1;
        while (i >= 0 || j >= 0) {

            i = getValidIdx(i, str1);
            j = getValidIdx(j, str2);

            if (i < 0 && j < 0) return true;

            if (i < 0 || j < 0) return false;

            if (str1.charAt(i) != str2.charAt(j)) return false;

            i -= 1;
            j -= 1;
        }

        return true;
    }

    private static int getValidIdx(int i, String str) {
        int backspaces = 0;
        while (i >= 0) {

            if (str.charAt(i) == '#') backspaces += 1;
            else if (backspaces > 0) backspaces -= 1;
            else break;

            i -= 1;
        }
        return i;
    }
}