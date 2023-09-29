import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");

        for (String s : list) {
            System.out.println(s);
        }
    }
}