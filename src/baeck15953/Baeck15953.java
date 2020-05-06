package baeck15953;

import java.util.Scanner;

public class Baeck15953 {

    public enum RewardCategory {
        REWARD_2017, REWARD_2018
    }

    private static int[] reward2017 = {500, 300, 200, 50, 30, 10};
    private static int[] rewardBorder2017 = {1, 3, 6, 10, 15, 21};

    private static int[] reward2018 = {512, 256, 128, 64, 32};
    private static int[] rewardBorder2018 = {1, 3, 7, 15, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(a, b));
        }
    }

    public static int solve(int a, int b) {
        int result = 0;

        int reward2017Tier = getTierByRank(a, RewardCategory.REWARD_2017);
        int reward2018Tier = getTierByRank(b, RewardCategory.REWARD_2018);

        if(reward2017Tier != 0) result += reward2017[reward2017Tier - 1];
        if(reward2018Tier != 0) result += reward2018[reward2018Tier - 1];

        return result * 10000;
    }

    private static int getTierByRank(int rank, RewardCategory rewardCategory) {
        if(rank == 0) return 0;

        int[] rewardBorder;

        switch (rewardCategory) {
            case REWARD_2017: rewardBorder = rewardBorder2017; break;
            case REWARD_2018: rewardBorder = rewardBorder2018; break;
            default:
                throw new IllegalStateException("Unexpected value: " + rewardCategory);
        }

        for(int i = 0; i < rewardBorder.length; i++) {
            if(rewardBorder[i] >= rank) return i + 1;
        }

        return 0;
    }
}
