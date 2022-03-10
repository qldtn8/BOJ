package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {

    static class Position implements Comparable<Position> {
        int r, c;
        int friends;
        int empty;

        public Position(int r, int c, int friends, int empty) {
            this.r = r;
            this.c = c;
            this.friends = friends;
            this.empty = empty;
        }

        @Override
        public int compareTo(Position o) {
            if(this.friends != o.friends) {
                return o.friends-this.friends;
            }
            if(this.empty != o.empty) {
                return o.empty - this.empty;
            }
            if(this.r != o.r) {
                return this.r - o.r;
            }
            return this.c - o.c;
        }
    }

    static class Student {
        int no;
        int r, c;
        ArrayList<Integer> friends;

        public Student(int no, ArrayList<Integer> friends) {
            this.no = no;
            this.friends = friends;
            r = -1;
            c = -1;
        }
    }

    static int N;
    static int[][] arr;

    static Student[] students;
    static int[][] deltas = {{-1,0},{0,-1},{0,1},{1,0}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void noOneAssigned(int no) {
        int max = -1;
        int maxR = -1;
        int maxC = -1;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(arr[r][c] == 0) {
                    int count = 0;
                    for(int d = 0; d < deltas.length; d++) {
                        int nr = r + deltas[d][0];
                        int nc = c + deltas[d][1];
                        if(isIn(nr, nc) && arr[nr][nc] == 0) {
                            count++;
                        }
                    }
                    if(max < count) {
                        max = count;
                        maxR = r;
                        maxC = c;
                    }
                }
            }
        }
        arr[maxR][maxC] = no;
        students[no].r = maxR;
        students[no].c = maxC;
    }


    public static void assignSeat(Student s) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        for(int no : s.friends) {   // 좋아하는 친구들을 기준으로 주변 좌석을 살핀다.
            if(students[no] != null && students[no].r != -1 && students[no].c != -1) {  // 좋아하는 친구가 자리배정이 되었을 때
                for(int d = 0; d < deltas.length; d++) {    // 좋아하는 친구를 기준으로 인접한 곳에 빈칸을 찾는다.
                    int nr = students[no].r + deltas[d][0];
                    int nc = students[no].c + deltas[d][1];
                    if(isIn(nr, nc) && arr[nr][nc] == 0) {
                        int numOfFriends = 0;
                        int numOfEmpty = 0;
                        for(int d2 = 0; d2 < deltas.length; d2++) {
                            int nr2 = nr + deltas[d2][0];
                            int nc2 = nc + deltas[d2][1];
                            if(isIn(nr2, nc2)) {
                                if(arr[nr2][nc2] == 0)
                                    numOfEmpty++;
                                else if(s.friends.contains(arr[nr2][nc2]))
                                    numOfFriends++;
                            }
                        }
                        pq.offer(new Position(nr, nc, numOfFriends, numOfEmpty));
                    }
                }
            }
        }
        if(pq.isEmpty()) {
            noOneAssigned(s.no);
            return;
        }

        Position result = pq.poll();
        arr[result.r][result.c] = s.no;
        s.r = result.r;
        s.c = result.c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        students = new Student[N*N + 1];
        StringTokenizer token;
        for(int i = 0; i < N*N; i++) {
            token = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(token.nextToken());
            ArrayList<Integer> friends = new ArrayList<>();
            for(int j = 0; j < 4; j++) {
                friends.add(Integer.parseInt(token.nextToken()));
            }
            students[no] = new Student(no, friends);
            assignSeat(students[no]);
        }

        int total = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                int count = 0;
                for(int d = 0; d < deltas.length; d++) {
                    int nr = r + deltas[d][0];
                    int nc = c + deltas[d][1];
                    if(isIn(nr, nc) && students[arr[r][c]].friends.contains(arr[nr][nc])) {
                        count++;
                    }
                }
                if(count != 0)
                    total += (int) Math.pow(10, count-1);
            }
        }
        System.out.println(total);
    }
}
