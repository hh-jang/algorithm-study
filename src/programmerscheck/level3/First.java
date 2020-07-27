package programmerscheck.level3;

public class First {
    public static void main(String[] args) {
        String value = "abcdcba";
        System.out.println(solution(value));
    }

    public static int solution(String s)
    {
        int answer = 1;

        for(int i = 0; i < s.length() - 1; i++) {
            int oddValue = getOddPalindrome(i, s.length(), s);
            int evenValue = getEvenPalindrome(i, s.length(), s);

            if(answer < oddValue) answer = oddValue;
            if(answer < evenValue) answer = evenValue;
        }

        return answer;
    }

    public static int getOddPalindrome(int pos, int length, String s) {
        int maxCount = 1;

        for(int i = 1; i <= length / 2; i++) {
            if(pos-i < 0 || pos + i >= length) {
                break;
            }
            if(s.charAt(pos - i) == s.charAt(pos + i)) {
                maxCount += 2;
            }else {
                break;
            }
        }
        return maxCount;
    }

    public static int getEvenPalindrome(int pos, int length, String s) {
        int maxCount = 0;

        if(s.charAt(pos) == s.charAt(pos + 1)) {
            maxCount = 2;
            for(int i = 1; i <= length / 2; i++) {
                if(pos-i < 0 || pos+1+i >= length) break;
                if(s.charAt(pos - i) == s.charAt(pos + 1 + i)) {
                    maxCount += 2;
                } else {
                    break;
                }
            }
        }
        return maxCount;
    }
}
