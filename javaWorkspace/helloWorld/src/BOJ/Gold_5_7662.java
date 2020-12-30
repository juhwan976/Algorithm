package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Gold_5_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());
        PriorityQueue<Pair> minqueue = new PriorityQueue<>(new ComparatorUp());
        PriorityQueue<Pair> maxqueue = new PriorityQueue<>(new ComparatorDown());

        for (int i = 0; i < length; i++) {
            minqueue.clear();
            maxqueue.clear();
            int numcount = 0;
            int mincount = 0;
            int maxcount = 0;

            int commandNum = Integer.parseInt(input.readLine());
            boolean visited[] = new boolean[commandNum];

            for (int j = 0; j < commandNum; j++) {
                String data[] = input.readLine().split(" ");

                if (data[0].equals("I")) {
                    Pair pair = new Pair(j, Integer.parseInt(data[1]));
                    minqueue.add(pair);
                    maxqueue.add(pair);
                    numcount++;
                } else if (data[0].equals("D")) {
                    if (numcount == 0) {
                    } else {
                        if (Integer.parseInt(data[1]) == 1) {
                            while (true) {
                                Pair pair = maxqueue.remove();
                                if (visited[pair.index]) {
                                    /* do nothing */
                                }
                                else {
                                    visited[pair.index] = true;
                                    maxcount++;
                                    break;
                                }
                            }
                        }
                        else if(Integer.parseInt(data[1]) == -1) {
                            while(true) {
                                Pair pair = minqueue.remove();
                                if(visited[pair.index]) {
                                    /* do nothing */
                                }
                                else {
                                    visited[pair.index] = true;
                                    mincount++;
                                    break;
                                }
                            }
                        }

                        if(mincount + maxcount == numcount) {
                            minqueue.clear();
                            maxqueue.clear();
                            numcount = 0;
                            mincount = 0;
                            maxcount = 0;
                        }
                    }
                }
            }

            if(numcount == 0) {
                output.write("EMPTY");
            }
            else {
                Pair min;
                Pair max;
                while(true) {
                    min = minqueue.remove();
                    if(!visited[min.index]) break;
                }
                while(true) {
                    max = maxqueue.remove();
                    if(!visited[max.index]) break;
                }

                output.write(max.value + " " + min.value);
            }
        }

        output.flush();
        output.close();
        input.close();
    }
}

class Pair {
    Integer index;
    Integer value;

    public Pair(Integer index, Integer value) {
        this.index = index;
        this.value = value;
    }
}

class ComparatorUp implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        if (a.value > b.value) {
            return 1;
        } else
            return -1;
    }
}

class ComparatorDown implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        if (a.value > b.value) {
            return -1;
        } else
            return 1;
    }
}
