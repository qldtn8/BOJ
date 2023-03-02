import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;

    static int[][] deltas = {{},{},{},{}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            R = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());
            map = new char[R][C];

            int minR = Integer.MAX_VALUE;
            int maxR = Integer.MIN_VALUE;
            int minC = Integer.MAX_VALUE;
            int maxC = Integer.MIN_VALUE;
            for(int r = 0; r < R; r++) {
                String line = br.readLine();
                for(int c = 0; c < C; c++) {
                    map[r][c] = line.charAt(c);
                    if(map[r][c] == '#') {
                        if(minR > r) minR = r;
                        if(maxR < r) maxR = r;
                        if(minC > c) minC = c;
                        if(maxC < c) maxC = c;
                    }
                }
            }

            if((maxR - minR + 1) != (maxC - minC + 1)) {
                bw.write("0\n");
                continue;
            }

            int minRInRatte = Integer.MAX_VALUE;
            int maxRInRatte = Integer.MIN_VALUE;
            int minCInRatte = Integer.MAX_VALUE;
            int maxCInRatte = Integer.MIN_VALUE;

            for(int r = minR; r <= maxR; r++) {
                for(int c = minC; c <= maxC; c++) {
                    if(map[r][c] == '.') {
                        if(minRInRatte > r) minRInRatte = r;
                        if(minCInRatte > c) minCInRatte = c;

                        if(maxRInRatte < r) maxRInRatte = r;
                        if(maxCInRatte < c) maxCInRatte = c;
                    }
                }
            }
            
            if((maxRInRatte - minRInRatte + 1) != (maxCInRatte - minCInRatte + 1)) {
                bw.write("0\n");
                continue;
            }
            
            if((maxRInRatte - minRInRatte + 1) == (maxR - minR + 1)) {
                bw.write("0\n");
                continue;
            }

            boolean isTrue2 = true;
            for(int r = minRInRatte; r <= maxRInRatte; r++) {
                for(int c = minCInRatte; c <= maxCInRatte; c++) {
                    if(map[r][c] == '#'){
                        isTrue2 = false;
                        break;
                    }
                }
                if(!isTrue2)
                    break;
            }

            if(!isTrue2) {
                bw.write("0\n");
                continue;
            }

            // 모서리 체크
            if((minR == minRInRatte && minC == minCInRatte)
                || (minR == minRInRatte && maxC == maxCInRatte)
                || (maxR == maxRInRatte && minC == minCInRatte)
                || (maxR == maxRInRatte && maxC == maxCInRatte)) {

                boolean isTrue = true;
                for(int r = minR; r <= maxR; r++) {
                    for(int c = minC; c <= maxC; c++) {
                        if(minRInRatte <= r && r <= maxRInRatte
                                && minCInRatte <= c && c <= maxCInRatte)
                            continue;
                        if(map[r][c] == '.') {
                            isTrue = false;
                            break;
                        }
                    }
                    if(!isTrue)
                        break;
                }

                bw.write(isTrue ? "1\n" : "0\n");
            } else
                bw.write("0\n");
        }

        bw.flush();
        bw.close();
    }

}