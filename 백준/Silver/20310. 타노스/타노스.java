import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        List<Character> slist = new LinkedList<>();
        int zero = 0;
        int one = 0;
        for (char c : s.toCharArray()) {
            slist.add(c);
            if(c == '1') one++;
            else zero++;
        }

        zero = zero/2;
        one = one/2;
        for(int i = 0; i < slist.size() && one != 0; i++) {
            if(slist.get(i) == '1') {
                slist.remove(i--);
                one--;
            }
        }
        for(int i = slist.size()-1; i >= 0 && zero != 0; i--) {
            if(slist.get(i) == '0') {
                slist.remove(i);
                zero--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : slist) {
            sb.append(c);
        }
        System.out.println(sb.toString());

    }
}