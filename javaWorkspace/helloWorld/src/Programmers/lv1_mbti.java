package Programmers;

public class lv1_mbti {
    public static void main(String args[]) {
        String survey[] = { "TR", "RT", "TR" };
        int choice[] = { 7, 1, 3 };
        String answer = "";

        // - +
        // R T
        // C F
        // J M
        // A N
        int mbti[] = new int[4];
        String result[] = new String[4];

        for (int i = 0; i < survey.length; i++) {
            int arr[] = checkIndex(survey[i]);

            mbti[arr[0]] += arr[1] * (4 - choice[i]);
        }

        if (mbti[0] > 0) {
            result[0] = "T";
        } else {
            result[0] = "R";
        }

        if (mbti[1] > 0) {
            result[1] = "F";
        } else {
            result[1] = "C";
        }

        if (mbti[2] > 0) {
            result[2] = "M";
        } else {
            result[2] = "J";
        }

        if (mbti[3] > 0) {
            result[3] = "N";
        } else {
            result[3] = "A";
        }

        answer = String.join("", result);
        System.out.println(answer);
    }

    public static int[] checkIndex(String survey) {
        int result[] = new int[2];

        switch (survey.charAt(0)) {
            default:
            case 'R':
                result[0] = 0;
                result[1] = -1;
                break;
            case 'T':
                result[0] = 0;
                result[1] = 1;
                break;
            case 'C':
                result[0] = 1;
                result[1] = -1;
                break;
            case 'F':
                result[0] = 1;
                result[1] = 1;
                break;
            case 'J':
                result[0] = 2;
                result[1] = -1;
                break;
            case 'M':
                result[0] = 2;
                result[1] = 1;
                break;
            case 'A':
                result[0] = 3;
                result[1] = -1;
                break;
            case 'N':
                result[0] = 3;
                result[1] = 1;
                break;
        }

        return result;
    }
}