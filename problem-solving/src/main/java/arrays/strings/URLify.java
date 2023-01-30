package arrays.strings;

/**
 * Question: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient spaces at the end to hold the additional characters, and that you are given the 'true'
 * length of the string.
 */
public class URLify {

    public static void replaceSpaces(char[] chars, int trueLength) {
        int whiteSpacesCount = countWhiteSpaces(chars, trueLength);
        int totalLength = trueLength + (whiteSpacesCount * 2);
        if (trueLength < chars.length)
            chars[trueLength] = '\0';

        int lastIndex = totalLength - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[lastIndex--] = '%';
                chars[lastIndex--] = '2';
                chars[lastIndex--] = '0';
            }
            else
                chars[lastIndex--] = chars[i];
        }
    }

    private static int countWhiteSpaces(char[] chars, int trueLength) {
        int whiteSpacesCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ')
                whiteSpacesCount++;
        }
        return whiteSpacesCount;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] chars = str.toCharArray();
        URLify.replaceSpaces(chars, 13);
        System.out.println(new String(chars));

        str = "MrJohnSmith    ";
        chars = str.toCharArray();
        URLify.replaceSpaces(chars, 11);
        System.out.println(new String(chars));
    }
}
