package Programmers;

public class lv1_recommand_new_id {
    public static void main(String args[]) {
        String new_id = "abcdefghijklmn.p";
        String answer = "";
        int lastIndex = new_id.length() - 1 < 0 ? 0 : new_id.length() - 1;

        // Step 1, 2
        answer = new_id
                .toLowerCase()
                .replaceAll("[~!@#$%^&*()=+[{]}:?,<>/]", "");
        lastIndex = updateLastIndex(answer, lastIndex);

        // Step 3
        while (true) {
            if (answer.contains("..")) {
                answer = answer.replace("..", ".");
            } else {
                break;
            }
        }
        lastIndex = updateLastIndex(answer, lastIndex);

        // Step 4
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.replaceFirst("[.]", "");
            lastIndex = updateLastIndex(answer, lastIndex);
        }
        if (!answer.isEmpty() && answer.charAt(lastIndex) == '.') {
            answer = answer.substring(0, lastIndex);
            lastIndex = updateLastIndex(answer, lastIndex);
        }

        // Step 5
        if (answer.isEmpty()) {
            answer = "a";
            lastIndex = updateLastIndex(answer, lastIndex);
        }

        // Step 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            lastIndex = updateLastIndex(answer, lastIndex);

            if (answer.charAt(lastIndex) == '.') {
                answer = answer.substring(0, lastIndex);
                lastIndex = updateLastIndex(answer, lastIndex);
            }
        }

        // Step 7
        while (true) {
            if (answer.length() <= 2) {
                answer = answer + answer.charAt(lastIndex);
                lastIndex = updateLastIndex(answer, lastIndex);
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

    public static int updateLastIndex(String answer, int lastIndex) {
        return lastIndex = answer.length() - 1 < 0 ? 0 : answer.length() - 1;
    }
}