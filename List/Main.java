import list.ArrayList;
import list.LinkedList;
import list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(1, 30);
        list.add(0, 10);
        list.add(40);

        System.out.println(list);
        System.out.println(list.removeValue(10));
        System.out.println(list.remove(2));
        System.out.println(list);

        list = new ArrayList<>();
        list.add(20);
        list.add(1, 30);
        list.add(0, 10);
        list.add(40);

        System.out.println(list);
        System.out.println(list.removeValue(10));
        System.out.println(list.remove(2));
        System.out.println(list);
    }
}
