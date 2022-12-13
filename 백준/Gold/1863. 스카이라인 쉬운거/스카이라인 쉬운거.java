import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> building = new Stack<>();
        building.push(0);
        int count = 0;
        while (N-- > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            token.nextToken();
            int y = Integer.parseInt(token.nextToken());

            if(y == 0) {
                building = new Stack<>();
                building.push(0);
            } else {
                while(!building.isEmpty()) {
                    int prev = building.peek();

                    if(prev > y) building.pop();
                    else {
                        if(prev != y) {
                            count++;
                            building.push(y);
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}