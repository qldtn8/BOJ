package BJ.그리디알고리즘;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException, ScriptException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        String[] syntax = br.readLine().split("-");
        for(int i = 0; i < syntax.length; i++) {
            String[] subSyntax = syntax[i].split("\\+");
            int sum = 0;
            for(int j = 0; j < subSyntax.length; j++) {
                sum += Integer.parseInt(subSyntax[j]);
            }

            if(i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
