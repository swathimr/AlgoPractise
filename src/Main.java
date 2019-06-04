import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map(cost -> cost + 0.12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

        LinkedList list = new LinkedList();
        list.addNode(10);
        list.addNode(15);
        list.addNode(98);
        list.addNode(2);
        list.addNode(44);
        list.printLinkedList();
        list.printMiddle();
        System.out.println(list.searchElement(20));
    }
}
