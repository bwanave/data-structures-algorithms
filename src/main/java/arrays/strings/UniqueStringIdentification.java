package arrays.strings;

/**
 * Question: Implement an algorithm to determine if a string has all unique characters. What if
 * you can't use additional data structures?
 */
public class UniqueStringIdentification {

    public static boolean isUnique(String str) {
        if (str.length() > 128)
            return false;
        boolean[] charAsciiArray = new boolean[128];
        for (int charAscii : str.toCharArray()) {
            if (charAsciiArray[charAscii])
                return false;
            charAsciiArray[charAscii] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(UniqueStringIdentification.isUnique("Balaji"));
        System.out.println(UniqueStringIdentification.isUnique("ABC"));
    }
}
