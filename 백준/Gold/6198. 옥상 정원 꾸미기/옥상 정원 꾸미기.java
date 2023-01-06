import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long total = 0;
        Stack<Integer> building = new Stack<>();
        while(N-- > 0) {
            int h = Integer.parseInt(br.readLine());

            if(building.isEmpty()) {
                building.push(h);
                continue;
            }

            while(!building.isEmpty()) {
                if(building.peek() > h) {
                    total += building.size();
                    break;
                }
                building.pop();
            }
            building.push(h);
        }

        System.out.println(total);
    }
}