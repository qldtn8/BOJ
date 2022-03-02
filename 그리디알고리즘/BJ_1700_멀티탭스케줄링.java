package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1700_멀티탭스케줄링 {

    static int N;   // 멀티탭 구멍의 개수
    static LinkedList<Integer> multitap;    // 멀티탭에 꽂혀있는 기기

    static int K;   // 전기용품의 총 사용횟수
    static int[] order; // 전기용품 사용 순서
    static int[] count; // 각 전기용품 사용 횟수

    // 전기용품 사용 순서들 중 i+1부터 K사이에서 첫 data의 인덱스를 반환
    // 없을 때는 -1 반환
    public static int findFirstIndex(int start, int end, int data) {
        for(int i = start; i < end; i++) {
            if(order[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        multitap = new LinkedList<>();

        K = Integer.parseInt(token.nextToken());
        order = new int[K];
        count = new int[K+1];   // 전기용품이 1부터 K까지 이므로 인덱스 계산을 위해 배열을 K+1로 할당

        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(token.nextToken());
            count[order[i]]++;
        }
        // -------------------입력----------------------

        int total = 0;  // 플러그를 빼는 횟수
        for(int i = 0; i < K; i++) {    // 사용 순서만큼 반복
            count[order[i]]--;  // order[i]의 사용 횟수 차감.
            if(multitap.size() != 0 && multitap.contains(order[i])) {   // 멀티탭에 order[i] 전기용품이 꽂혀있는 경우.
                continue;
            }
            if(multitap.size() != N) {  // 멀티탭 구멍이 비어있을 경우
                multitap.add(order[i]);
            } else {    // 비어있지 않을 경우
                // 우선순위 1. 앞으로 쓰이지 않을 전기용품을 제거
                // 우선순위 2. 나머지 사용순서에서 가장 먼저나오는 전기용품은 제거하지 않는다.(가장 나중에 나올 전기용품을 뽑는다.)
                //       현재 멀티탭 2, 3 / 이 후 들어올 순서 1, 2, 3, 3, 3 일 때
                //       이 후 들어올 순서에서 2의 사용빈도보다 3의 사용빈도가 높다고해서 사용빈도가 낮은 걸 뽑아버리면 안됨...(반례)
                int firstIdx = -1;   // 이 후에 multitap.get(j) 전자기기가 처음 나오는 인덱스.
                int minIdx = -1;    // 그 때의 index
                for(int j = 0; j < multitap.size(); j++) {
                    if(count[multitap.get(j)] == 0) {   // 우선순위 1에 의해서 바로 break;
                        minIdx = j;
                        break;
                    }
                    int temp = findFirstIndex(i+1, K, multitap.get(j));
                    if(firstIdx < temp) {
                        firstIdx = temp;
                        minIdx = j;
                    }
                }
                multitap.set(minIdx, order[i]); // 해당 index의 전자제품을 새로 들어올 전자제품으로 변경!
                total++;    // 플러그를 뽑았으니 +1;
            }
        }
        System.out.println(total);
    }
}
