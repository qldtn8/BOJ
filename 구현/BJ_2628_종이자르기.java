package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2628_종이자르기 {

    static class Rectangle{
        int sx, sy;
        int ex, ey;
        public Rectangle(int sx, int sy, int ex, int ey) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }

        public int getArea(){
            return (ex-sx) * (ey - sy);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int ex = Integer.parseInt(token.nextToken());
        int ey = Integer.parseInt(token.nextToken());
        Queue<Rectangle> queue = new LinkedList<>();
        queue.offer(new Rectangle(0, 0, ex, ey));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int horizon = Integer.parseInt(token.nextToken());
            int nth = Integer.parseInt(token.nextToken());
            int size = queue.size();
            while(size-- > 0) {
                Rectangle rect = queue.poll();
                if(horizon == 0 && rect.sy < nth && nth < rect.ey) {
                    queue.offer(new Rectangle(rect.sx, rect.sy, rect.ex, nth));
                    queue.offer(new Rectangle(rect.sx, nth, rect.ex, rect.ey));
                } else if(horizon == 1 && rect.sx < nth && nth < rect.ex) {
                    queue.offer(new Rectangle(rect.sx, rect.sy, nth, rect.ey));
                    queue.offer(new Rectangle(nth, rect.sy, rect.ex, rect.ey));
                } else {
                    queue.offer(rect);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            Rectangle rect = queue.poll();
            max = Math.max(max, rect.getArea());
        }
        System.out.println(max);
    }
}
