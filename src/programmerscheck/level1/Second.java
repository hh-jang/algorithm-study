package programmerscheck.level1;

public class Second {
    public static void main(String[] args) {
        long n = 499999999;
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        double sqrt = Math.sqrt(n);
        int intValue = (int) sqrt;
        if(sqrt == intValue) return (long) Math.pow(sqrt + 1, 2);

        return -1;
    }
}
