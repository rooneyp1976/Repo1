package com.rooney.sts;

/**
 * Please implement a function that checks whether a positive number is a palindrome or not. For example, 121 is a palindrome, but 123 is not.
 */
public class Palindrome {

      public static void main(String[] args) {
          int numToTest = 1234;
//          System.out.println(i % 10); //from right
//          System.out.println(i / 1); //up to left

          //* mod by 10 on loop and check !> i
          //System.out.println(i / 1 %10); //up to left, then pluck off rightmost 4 - 1, 3 - 10 , 2 - 100, 1 - 1000

          System.out.println(numToTest % 100 ); //from right



//        System.out.println(isPalindrome(9));
//        System.out.println(isPalindrome(10));
//        System.out.println(isPalindrome(11));
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(123));
//        System.out.println(isPalindrome(12321));
//        System.out.println(isPalindrome(12344321));
        System.out.println(isPalindrome(12344329));
    }

    //try with modulus?
    private static boolean isPalindrome(int numToTest) {
        for(int i = 1; i <= numToTest; i*=10) {
            int rhs = numToTest / i % 10;
            System.out.println("rhs: " + rhs);
//            int rhs =
        }

        return true;
    }

    //needs a String
    private static boolean isPalindromeUsingString(int numToTest) {
        System.out.println("testing " + numToTest);

        char[] numAsChars = ("" + numToTest).toCharArray();
        for(int lhs=0; lhs< numAsChars.length /2; lhs++) {
            if(numAsChars[lhs] != numAsChars[(numAsChars.length -1) - lhs]) {
                return false;
            }
        }
        return true;
    }


}
