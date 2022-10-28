package Programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lv2_largest_num {
    public static void main(String args[]) {
        int[] numbers = { 3, 30, 34, 5, 9 };
        String answer = "";
        int index = 0; // 가장 큰 수로 선정된 수의 인덱스
        int largest = 0; // 가장 큰 수로 선정된 수의 첫번 째 수
        List<Integer> numList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        while (numList.size() != 0) {
            for (int i = 0; i < numList.size(); i++) {
                int num = numList.get(i);
                if (num < 10) {
                    if (largest < num) {
                        index = i;
                        largest = num;
                    } else if (largest == num) {
                        String temp1 = Integer.toString(numList.get(index));
                        String temp2 = Integer.toString(num);
                        if (temp1.length() != temp2.length()) {
                            int length1 = temp1.length();
                            int length2 = temp2.length();
                            int shortLength = Math.min(length1, length2);
                            int num1 = numList.get(index);
                            int num2 = num;

                            if (shortLength == length1) {
                                num1 *= Math.pow(10, length2 - length1);
                            }

                            if (shortLength == length2) {
                                num2 *= Math.pow(10, length1 - length2);
                            }

                            if (num2 > num1) {
                                index = i;
                                largest = num;
                            } else if (num2 == num1) {
                                if (length2 < length1) {
                                    index = i;
                                    largest = num;
                                }
                            }
                        }
                    }
                } else if (num < 100) {
                    if (largest < num / 10) {
                        index = i;
                        largest = num / 10;
                    } else if (largest == num / 10) {
                        String temp1 = Integer.toString(numList.get(index));
                        String temp2 = Integer.toString(num);
                        if (temp1.length() != temp2.length()) {
                            int length1 = temp1.length();
                            int length2 = temp2.length();
                            int shortLength = Math.min(length1, length2);
                            int num1 = numList.get(index);
                            int num2 = num;

                            if (shortLength == length1) {
                                num1 *= Math.pow(10, length2 - length1);
                            }

                            if (shortLength == length2) {
                                num2 *= Math.pow(10, length1 - length2);
                            }

                            if (num2 > num1) {
                                index = i;
                                largest = num / 10;
                            } else if (num2 == num1) {
                                if (length2 < length1) {
                                    index = i;
                                    largest = num / 10;
                                }
                            }

                        } else if (temp1.length() == temp2.length()) {
                            if (num > numList.get(index)) {
                                index = i;
                                largest = num / 10;
                            }
                        }
                    }
                } else if (num < 1000) {
                    if (largest < num / 100) {
                        index = i;
                        largest = num / 100;
                    } else if (largest == num / 100) {
                        String temp1 = Integer.toString(numList.get(index));
                        String temp2 = Integer.toString(num);
                        if (temp1.length() != temp2.length()) {
                            int length1 = temp1.length();
                            int length2 = temp2.length();
                            int shortLength = Math.min(length1, length2);
                            int num1 = numList.get(index);
                            int num2 = num;

                            if (shortLength == length1) {
                                num1 *= Math.pow(10, length2 - length1);
                            }

                            if (shortLength == length2) {
                                num2 *= Math.pow(10, length1 - length2);
                            }

                            if (num2 > num1) {
                                index = i;
                                largest = num / 100;
                            } else if (num2 == num1) {
                                if (length2 < length1) {
                                    index = i;
                                    largest = num / 100;
                                }
                            }
                        } else if (temp1.length() == temp2.length()) {
                            if (num > numList.get(index)) {
                                index = i;
                                largest = num / 100;
                            }
                        }
                    }
                } else {
                    if (largest < 1) {
                        index = i;
                        largest = 1;
                    } else if (largest == 1) {
                        /* do nothing */
                    }
                }
            }
            answer = answer + numList.get(index).toString();
            numList.remove(index);
            index = 0;
            largest = 0;
        }

        System.out.println(answer);

    }
}
