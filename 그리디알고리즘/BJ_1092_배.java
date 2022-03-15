package BJ.그리디알고리즘;

import java.util.*;

public class BJ_1092_배 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<Integer> cranes = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            cranes.add(scanner.nextInt());
        }

        int M = scanner.nextInt();
        ArrayList<Integer> boxes = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            boxes.add(scanner.nextInt());
        }

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        // 모든 박스를 배로 옮길 수 없는 경우
        if(cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while(!boxes.isEmpty()) {
            int idx = 0;
            for(int i = 0; i < cranes.size();) {
                if(idx == boxes.size()) break;

                int crane = cranes.get(i);
                if (crane >= boxes.get(idx)) {
                    boxes.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}

/*
public class BJ_1092_배 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> cranes = new LinkedList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(token.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        LinkedList<Integer> boxes = new LinkedList<>();
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(token.nextToken()));
        }

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        // 모든 박스를 배로 옮길 수 없는 경우
        if(cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while(!boxes.isEmpty()) {
            int idx = 0;
            for(int i = 0; i < cranes.size();) {
                if(idx == boxes.size()) break;

                int crane = cranes.get(i);
                if (crane >= boxes.get(idx)) {
                    boxes.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
 */
