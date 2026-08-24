class Solution {
    public int[] plusOne(int[] digits) {
        // base case.
        if (digits.length == 0)
            return new int[0];

        int n = digits.length - 1;
        int carry = 0;

        if (digits[n] < 9) {
            digits[n]++;
            return digits;
        }

        if (digits[n] == 9) {
            digits[n] = 0;
            carry++;
        }

        for (int j = n - 1; j >= 0; j--) {
            if (digits[j] == 9 && carry == 1) {
                digits[j] = 0;
            }

            else if (digits[j] != 9 && carry == 1) {
                digits[j]++;
                carry = 0;
            }
        }

        int newDigitsArray[] = new int[digits.length + 1];

        if (carry == 1 && digits[0] == 0) {
            newDigitsArray[0] = 1;

            for (int i = 1; i < newDigitsArray.length; i++) {
                newDigitsArray[i] = 0;
            }

            return newDigitsArray;
        }

        return digits;
    }
}
