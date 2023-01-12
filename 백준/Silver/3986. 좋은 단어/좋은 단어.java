import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N-- > 0) {
            String word = br.readLine();
            if(word.length() % 2 != 0) continue;

            Stack<Character> stack = new Stack<>();

            for (char c : word.toCharArray()) {
                if(stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if(stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }


            boolean isGoodWord = true;
            while(!stack.isEmpty()) {
                char prev = stack.pop();
                if(stack.isEmpty()) {
                    isGoodWord = false;
                    break;
                }
                if(prev == stack.peek()) {
                    stack.pop();
                } else {
                    isGoodWord = false;
                    break;
                }
            }

            if(isGoodWord && stack.isEmpty()) {
                count++;
                continue;
            }
        }
        System.out.println(count);
    }
}