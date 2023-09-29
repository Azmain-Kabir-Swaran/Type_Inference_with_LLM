import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        
        for (int num : list) {
            System.out.println(num);
        }
    }
}