public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1, 0);
        list.add(2,0);
        list.add(3, 0);
        list.add(4,2);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}