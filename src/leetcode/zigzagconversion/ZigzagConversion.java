package leetcode.zigzagconversion;

public class ZigzagConversion {

    /*
    지그 재그를 통해 1번의 로테이션이 돌 때에(V자 형태가 그려지는 만큼 이동)
    첫번째 줄과 끝 줄의 경우 1회, 그 외에 줄은 2번씩 반복 된다
    로테이션의 길이 V는 numRows * 2 - 2이다.
    그 외에 줄에 해당할 떄에 2번씩 반복되는데 그때의 좌표는 다음좌표 - (첫줄까지의 idx * 2)이다.
     */
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int numRows = 5;
        String convert = convert(input, numRows);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;

        StringBuilder sb = new StringBuilder();
        String topString = getBorderString(s, 1, numRows);
        String bottomString = getBorderString(s, numRows, numRows);
        sb.append(topString);

        for(int i = 2; i < numRows; i++) {
            sb.append(getPartialStringByIdx(s, i, numRows));
        }
        sb.append(bottomString);

        return sb.toString();
    }

    private static String getBorderString(String s, int start, int numRows) {
        StringBuilder sb = new StringBuilder();
        // 1회 로테이션까지 텀
        int idx = numRows * 2 - 2;

        for(int i =  start - 1; i < s.length(); i += idx) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static String getPartialStringByIdx(String s, int start, int numRows) {
        StringBuilder sb = new StringBuilder();
        // 1회 로테이션까지 텀
        int idx = numRows * 2 - 2;
        sb.append(s.charAt(start - 1));
        int next = start - 1 + idx - ((start - 1) * 2);
        if(next > s.length() - 1) return sb.toString();

        for(int i = start - 1 + idx - ((start - 1) * 2); i < s.length(); i += idx) {
            sb.append(s.charAt(i));
            if(((start - 1) * 2) + i < s.length()) {
                sb.append(s.charAt(i + ((start - 1) * 2)));
            }
        }
        return sb.toString();
    }
}
