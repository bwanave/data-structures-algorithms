package fastslowpointers;

class HappyNumber {

    public static boolean find(int num) {

        int slow = num;
        int fast = num;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int getNext(int num) {
        int sumOfDigitSquares = 0;
        while (num > 0) {
            int digit = num % 10;
            sumOfDigitSquares += digit * digit;
            num /= 10;
        }
        return sumOfDigitSquares;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}