import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        for (String str : list) {
            System.out.println(str);
        }
    }
}