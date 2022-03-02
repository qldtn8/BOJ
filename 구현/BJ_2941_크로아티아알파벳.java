package BJ.구현;

import java.util.Scanner;

public class BJ_2941_크로아티아알파벳 {

    static String[] alpha = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        int total = 0;
        for(int i = 0; i < line.length(); i++) {
            if(i < line.length()-2) {
                String temp = line.substring(i, i+3);
                if("dz=".equals(temp)) {
                    i += 2;
                    total++;
                    continue;
                }
            }
            if(i < line.length()-1) {
                String temp = line.substring(i, i+2);
                for(int j = 0; j < alpha.length; j++) {
                    if(alpha[j].equals(temp)) {
                        i++;
                        break;
                    }
                }
            }
            total++;
        }
        System.out.println(total);
    }
}
