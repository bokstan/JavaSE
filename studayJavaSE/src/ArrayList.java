public class ArrayList<E> {
    int capacity = 10;
    int size = 0;
    private Object[] array = new Object[capacity];

    public void add(E element, int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("插入位置非法，合法插入位置为：0 ~ " + size);
        }
        if(capacity == size){
            int newCapacity = capacity + (capacity >> 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            capacity = newCapacity;
        }
        for(int i = size; i > index; --i){
            array[i] = array[i + 1];
        }
        array[index] = element;
        size++;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < size; i++) builder.append(array[i]).append(" ");
        return builder.toString();
    }

    public E remove(int index){
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("非法的位置，合法的位置为0 ~ " + (size - 1));
        E e = (E) array[index];
        for(int i = index; i < size; i++){
            array[i] = array[i + 1];
        }
        size--;
        return e;
    }

    public E getElement(int index){
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("非法的位置，合法的位置为0 ~ " + (size - 1));
        E e = (E) array[index];
        return e;

    }

    public int size(){
        return this.size;
    }
}
