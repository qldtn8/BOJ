package BJ.구현;

public class BJ_4673_셀프넘버 {

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();

        boolean[] notSelfNumber = new boolean[10001];
        for(int i = 1; i <= 10000; i++) {
            if(!notSelfNumber[i]) {  // 셀프넘버인 경우
                output.append(i + "\n");
            }
            // 자신이 생성자가 되어 d(n) 만든다.
            int number = i;
            int dN = i;
            while(number > 0) {
                dN += number % 10;
                number /= 10;
            }
            if(dN < 10001)
                notSelfNumber[dN] = true;
        }
        System.out.println(output);
    }
}
