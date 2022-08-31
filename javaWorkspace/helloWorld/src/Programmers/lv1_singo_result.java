package Programmers;

import java.util.*;;

public class lv1_singo_result {
    public static void main(String args[]) {
        String[] id_list = { "con", "ryan" };
        String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
        int k = 3;

        int[] answer = new int[id_list.length];
        int[] reportedP = new int[id_list.length];
        ArrayList<String> ids = new ArrayList<>(Arrays.asList(id_list));
        //////////// 신고 대상
        // 신고 한 사람
        boolean[][] board = new boolean[id_list.length][id_list.length];

        for (int i = 0; i < report.length; i++) {
            String value[] = report[i].split(" ");
            int personIndex = ids.indexOf(value[0]);
            int oppositeIndex = ids.indexOf(value[1]);

            if (!board[personIndex][oppositeIndex]) {
                board[personIndex][oppositeIndex] = true;
                reportedP[oppositeIndex] += 1;
            }
        }

        for (int i = 0; i < reportedP.length; i++) {
            if (reportedP[i] >= k) {
                for (int j = 0; j < reportedP.length; j++) {
                    if (board[j][i]) {
                        answer[j] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
