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
        DequeNode<T> node = first;
        while(i < size && !node.getItem().equals(value)){
            node = node.getNext();
            i++;
        }

        /**
         * En caso de que el valor no se encuentre en la lista, el nodo sera null
         */
        return node != null;
    }

    @Override
    public void remove(T value) {
        int i = 0;
        DequeNode<T> node = first;
            if(contains(value)){
                /**
                 * First we search for the node with the value we want to delete
                 */
            while(!node.getItem().equals(value)){
                node = node.getNext();
                i++;
            }

            /**
             * Then we check if the node is the first and the last node
             */
            if(node == last){ //If the node is the last node
                last = last.getPrevious();
                last.setNext(null);
            }else if(node == first){ //If the node is the first node
                first = first.getNext();
                first.setPrevious(null);
            }else{//If the node is in the middle
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
            }
            size--;
        }
            //elemento menos, no debe estar, si hay dos elimina el primero
    }


    @Override
    public void sort(Comparator<? super T> comparator) {
        if(comparator== null){
            throw new DoubleEndedQueueException("The comparator cannot be null");
        }
        DequeNode<T> current = null, index = null;
        T temp;
        if (first == null) {
            return;
        } else {
            for (current = first; current.getNext() != null; current = current.getNext()) {
                for (index = current.getNext(); index != null; index = index.getNext()) {
                    if (comparator.compare(current.getItem(), index.getItem()) > 0) {
                        temp = current.getItem();
                        current.setItem(index.getItem());
                        index.setItem((T) temp);
                    }
                }
            }

        }


    }
}
