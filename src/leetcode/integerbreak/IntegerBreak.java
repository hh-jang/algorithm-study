package leetcode.integerbreak;

public class IntegerBreak {

    public static void main(String[] args) {
        int input = 9;
        System.out.println(integerBreak(input));
    }

    // 규
//    3 = 2 * 1
//
//    4 = 2 * 2
//
//    5 = 3 * 2 = 6
//
//    6 = 3 * 3= 9
//
//    7 = 3 * 2 * 2= 12
//
//    8 = 3 * 3 * 2 = 18
//
//    9 = 3 * 3 * 3 = 27
//
//    10 = 3 * 3 * 2 * 2 = 36
    public static int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;

        int countOfThree = n / 3;
        int remain = n % 3;

        if(remain == 0) return (int) Math.pow(3, countOfThree);
        if(remain == 1) return 2 * 2 * (int) Math.pow(3, countOfThree - 1);
        return 2 * (int) Math.pow(3, countOfThree);
    }
}
