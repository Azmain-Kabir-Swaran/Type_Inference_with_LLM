import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        
        for (String s : list) {
            System.out.println(s);
        }
    }
}