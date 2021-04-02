package leetcode.longestpalindromicsubstring;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        String input = "uzhynqvopdbnkvuxizirzjsslptlhmvyfqhqvqffmqldkrrdwapbdcxqbchvxqixmvbbtalrgzvkobyxlkonkfknabjwzeoazankqzuhexhcwkbvwtioubrcujqqeqoedhploqklhgeilwwnndbnzeadzefkcvaxdhgnmocadvvzjocoweyoidhleuwhmavpdiizbwkukpstyorlwwyiwwyyyzqqgipzzlxsgcdjscdfvrrrqmllbdjkkuisxeqaprfblvjuixajhucmcvffmevaztvadrujbthlnsdrxzvbldwxbazxmilpkbccigkihcgjbtpvignmrgzdqnufaacxtihfgwrllrwgfhitxcaafunqdzgrmngivptbjgchikgiccbkplimxzabxwdlbvzxrdsnlhtbjurdavtzavemffvcmcuhjaxiujvlbfrpaqexsiukkjdbllmqrrrvfdcsjdcgsxlzzpigqqzyyywwiywwlroytspkukwbziidpvamhwuelhdioyewocojzvvdacomnghdxavckfezdaeznbdnnwwlieghlkqolphdeoqeqqjucrbuoitwvbkwchxehuzqknazaoezwjbankfknoklxybokvzgrlatbbvmxiqxvhcbqxcdbpawdrrkdlqmffqvqhqfyvmhltplssjzrizixuvknbdpovqnyhzu";
        //String input = "abcba";
        String input = "abcdbbfcba";
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome(input));
        long end = System.currentTimeMillis();

        System.out.println("result : " + (end - start));
    }

    // dp로 풀어봄, 219ms
    public static String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        String result = s.substring(0, 1);
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                max = 2;
                result = s.substring(i, i + 2);
            }
        }

        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                if(s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1] > 0) {
                    dp[j][j + i] = dp[j + 1][j + i - 1] + 2;

                    if(max < dp[j][j + i]) {
                        max = dp[j][j + i];
                        result = s.substring(j, j + i + 1);
                    }
                }
            }
        }

        return result;
    }

    // brute force -> 불통과
    public static String longestPalindrome_bruteForce(String s) {
        String result = null;
        int max = 0;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j + i <= s.length(); j++) {
                String subString = s.substring(j, j + i);

                if(isPalindrome(subString) && max < subString.length()) {
                    max = subString.length();
                    result = subString;
                }
            }
        }

        return result;
    }

    // brute force - 개선 version -> 892ms 통과(근데 하위 5.7퍼ㅋㅋㅋ)
    // 검색할 substring length가 지금까지 계산한 가장 긴 펠린드롬보다 짧아지면 더 이상 루프 필요없음
    public static String longestPalindrome_bruteForce_start_max_length(String s) {
        String result = null;
        int max = 0;

        for (int i = s.length(); i >= 1; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                String subString = s.substring(j, j + i);

                if(i < max) break;

                if (isPalindrome(subString) && max < subString.length()) {
                    max = subString.length();
                    result = subString;
                }
            }
        }

        return result;
    }

    private static boolean isPalindrome(String subString) {
        int start = 0;
        int end = subString.length() - 1;

        while (start < end) {
            if(subString.charAt(start++) != subString.charAt(end--)) return false;
        }

        return true;
    }
}
