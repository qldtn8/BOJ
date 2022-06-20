package BJ.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2866_문자열잘라내기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] lines = new String[R];
        for(int r = 0; r < R; r++) {
            lines[r] = br.readLine();
        }

        List<String> list = new ArrayList<>();
        for(int c = 0; c < C; c++) {
            StringBuilder sb = new StringBuilder();
            for(int r = 0; r < R; r++) {
                sb.append(lines[r].charAt(c));
            }
            list.add(sb.toString());
        }

        int count = 0;
        int s = 0, e = R;
        while(s <= e) {
          Set<String> set = new HashSet<>();
          int mid = (s+e)/2;
          for(int i = 0; i < list.size(); i++) {
              String word = list.get(i).substring(mid);
              if(set.contains(word)) break;
              else set.add(word);
          }

          if(set.size() == list.size()) {
              count = mid;
              s = mid+1;
          } else {
              e = mid-1;
          }
        }
        System.out.println(count);
    }
}

/*
// 1800ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_2866_문자열잘라내기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] lines = new String[R];
        for(int r = 0; r < R; r++) {
            lines[r] = br.readLine();
        }

        Set<String> checkDup = new HashSet<>();
        for(int c = 0; c < C; c++) {
            StringBuilder sb = new StringBuilder();
            for(int r = 0; r < R; r++) {
                sb.append(lines[r].charAt(c));
            }
            checkDup.add(sb.toString());
        }

        int count = 0;
        for(int r = 0; r < R-1; r++) {
            Set<String> newCheckDup = new HashSet<>();

            Iterator<String> iter = checkDup.iterator();
            while(iter.hasNext()) {
                String word = iter.next();
                if(newCheckDup.contains(word.substring(1))) {
                    break;
                }
                newCheckDup.add(word.substring(1));
            }

            if(newCheckDup.size() != checkDup.size()) break;
            count++;
            checkDup = newCheckDup;
        }

        System.out.println(count);
    }
}
 */
