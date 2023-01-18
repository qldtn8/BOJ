import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())});
        }

        PriorityQueue<Integer> classrooms = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            int[] time = pq.poll();

            if(classrooms.isEmpty())
                classrooms.add(time[1]);
            else {
                if(classrooms.peek() <= time[0])
                    classrooms.poll();
                classrooms.add(time[1]);
            }
        }
        System.out.println(classrooms.size());
    }
}