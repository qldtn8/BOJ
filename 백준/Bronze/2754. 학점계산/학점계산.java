import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String score = br.readLine();
        double answer = 0.0;

        switch (score.charAt(0)) {
            case 'A' : answer += 4.0; break;
            case 'B' : answer += 3.0; break;
            case 'C' : answer += 2.0; break;
            case 'D' : answer += 1.0; break;
            default: break;
        }

        if(!score.equals("F")) {
            switch (score.charAt(1)) {
                case '+' : answer += 0.3; break;
                case '-' : answer -= 0.3; break;
            }
        }

        System.out.println(answer);
    }
}