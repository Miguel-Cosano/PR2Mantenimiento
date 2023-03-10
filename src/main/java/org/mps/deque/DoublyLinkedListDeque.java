package org.mps.deque;

/**
 *
 * author: Miguel Angel Cosano Ramirez and Edgar Antonio Álvarez González
 */
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
        if(value == null){
            throw new DoubleEndedQueueException("The value cannot be null");
        }
        DequeNode<T> val = new DequeNode<>(value, null, first);
        if(first != null){ //En caso de que no sea el unico elemento de la lista
            first.setPrevious(val);
        }
        first=val;
        if(last==null){ //En caso de que sea el unico elemento de la lista
            last=val;
        }

        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        if(value ==null){
            throw new DoubleEndedQueueException("The value cannot be null");
        }
        DequeNode<T> val = new DequeNode<>(value, last, null);
        if(last != null){
            last.setNext(val);
        }
        last = val;
        if(first == null){
            first = val;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if(first == null){
            throw new DoubleEndedQueueException("The list is empty");
        }
        DequeNode <T> val = first;

        first = first.getNext();
        val=null;

        size--;

    }

    @Override
    public void deleteLast() {
        // TODO
        if(last == null){
            throw new DoubleEndedQueueException("The list is empty");
        }
        DequeNode <T> val = last;
        last = last.getPrevious();
        val=null;

        size--;

    }

    @Override
    public T first() {
        // TODO
        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
