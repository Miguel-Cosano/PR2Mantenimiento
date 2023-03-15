package org.mps.deque;

import java.util.Comparator;

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

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new DoubleEndedQueueException("The index is out of bounds");
        }
        int i = 0;

        while(i < index){
            first = first.getNext();
            i++;
        }

        return first.getItem();
    }

    @Override
    public boolean contains(T value) {
        int i = 0;

        while(i < size && !first.getItem().equals(value)){
            first = first.getNext();
            i++;
        }

        return first.getItem().equals(value);
    }

    @Override
    public void remove(T value) {
        int i = 0;
            if(contains(value)){
            while(i < size && !first.getItem().equals(value)){
                first = first.getNext();
                i++;
            }
            if(first == last){
                first = null;
                last = null;
            }else if(first == last.getPrevious()){
                first.getPrevious().setNext(last);
                last.setPrevious(first.getPrevious());
                first = first
            }else if(first == first.getNext()){
                first = null;
                last.setNext(null);
            }else{
                first.getPrevious().setNext(first.getNext());
                first.getNext().setPrevious(first.getPrevious());
            }
            size--;
        }
            //elemento menos, no debe estar, si hay dos elimina el primero
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        // TODO
        if(comparator == null){
            throw new DoubleEndedQueueException("The comparator cannot be null");
        }
        if(size > 1){
            boolean swapped = true;
            while(swapped){
                swapped = false;
                DequeNode<T> current = first;
                while(current.getNext() != null){
                    if(comparator.compare(current.getItem(), current.getNext().getItem()) > 0){
                        T temp = current.getItem();
                        current.setItem(current.getNext().getItem());
                        current.getNext().setItem(temp);
                        swapped = true;
                    }
                    current = current.getNext();
                }
            }
        }
    }
}
