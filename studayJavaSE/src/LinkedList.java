public class LinkedList<E>{
    private final Node<E> head = new Node<>(null); //调用了下面得Node类
    private int size = 0;
    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element){ //Node的构造函数在这里给出，必须要对element进行赋值
            this.element = element;
        }
    }

    public void add(E element, int index){  //这里有一个点在于，计数方式和数组计数是一样的，都是从0开始，head实际上处于-1的位置
        if(index < 0 || index > size)   //插入size的位置，实际上就是计数最大值加1
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        Node<E> prev = head;
        for(int i = 0; i < index; i++){ //这个表达式实际上得到的是index - 1的节点
            prev = prev.next;
        }
        Node<E> node = new Node<>(element);
        node.next = prev.next;
        prev.next = node;
        size++;
    }
    public E remove(int index){
        if(index < 0 || index > size - 1)   //删除最大值必定是size - 1
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        Node<E> prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node<E> node = prev.next;
        prev.next = prev.next.next;
        size--;
        return node.element;
    }

    public E get(int index){
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        Node<E> node = head;
        for(int i = 0; i <= index; i++){
            node = node.next;
        }
        return node.element;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node<E> node = head.next;
        while(node != null){
            builder.append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString();
    }

    public int size(){
        return size;
    }
}
