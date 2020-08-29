package baeck1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baeck1541 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solve(s));
    }

    private static int solve(String s) {
        int result = 0;
        String[] chunkOfNumbers = s.split("\\-");

        int onlyAddedNumber = getSumOfNumberByExpression(chunkOfNumbers[0]);
        result += onlyAddedNumber;

        for(int i = 1; i < chunkOfNumbers.length; i++) {
            result -= getSumOfNumberByExpression(chunkOfNumbers[i]);
        }

        return result;
    }

    private static int getSumOfNumberByExpression(String chunkOfNumber) {
        String[] numbers = chunkOfNumber.split("\\+");
        int result = 0;
        for(int i = 0; i < numbers.length; i++)
            result += Integer.parseInt(numbers[i]);

        return result;
    }
}
