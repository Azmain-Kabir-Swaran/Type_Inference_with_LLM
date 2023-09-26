import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gwt_class_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sc.close();
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}