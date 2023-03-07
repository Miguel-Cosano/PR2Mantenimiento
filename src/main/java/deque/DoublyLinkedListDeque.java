package deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        // TODO
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        // TODO
        DequeNode<T> val = new DequeNode<>(value, null, first);
        first.setPrevious(val);
        first=val;
        if(last==null){ //En caso de que sea el unico elemento de la lista
            last=val;
        }

        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> val = new DequeNode<>(value, null, null);
        if(first == null){
            first = val;
        }

        last = val;
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        first = first.getNext();
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}
