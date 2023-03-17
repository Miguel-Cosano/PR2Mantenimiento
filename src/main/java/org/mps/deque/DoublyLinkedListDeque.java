package org.mps.deque;

import java.util.Comparator;

/**
 * author: Edgar Antonio Álvarez González and Miguel Angel Cosano Ramirez
 */
public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T>
{
    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque()
    {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value)
    {
        if (value == null)
        {
            throw new DoubleEndedQueueException("The value cannot be null");
        }
        DequeNode<T> val = new DequeNode<>(value, null, first);
        if (first != null)
        { //En caso de que no sea el unico elemento de la lista
            first.setPrevious(val);
        }
        first = val;
        if (last == null)
        { //En caso de que sea el unico elemento de la lista
            last = val;
        }

        size++;
    }

    @Override
    public void append(T value)
    {
        if (value == null)
        {
            throw new DoubleEndedQueueException("The value cannot be null");
        }
        DequeNode<T> val = new DequeNode<>(value, last, null);
        if (last != null)
        {
            last.setNext(val);
        }
        last = val;
        if (first == null)
        {
            first = val;
        }
        size++;
    }

    @Override
    public void deleteFirst()
    {
        if (first == null)
        {
            throw new DoubleEndedQueueException("The list is empty");
        }
        DequeNode<T> val = first;

        first = first.getNext();
        val = null;

        size--;

    }

    @Override
    public void deleteLast()
    {
        if (last == null)
        {
            throw new DoubleEndedQueueException("The list is empty");
        }
        DequeNode<T> val = last;
        last = last.getPrevious();
        val = null;

        size--;

    }

    @Override
    public T first()
    {
        return first.getItem();
    }

    @Override
    public T last()
    {
        return last.getItem();
    }

    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns the element at the specified position in this deque.
     * Element at the front of the deque is at position 0.
     *
     * @param index of the element to return
     * @return the element at the specified position in this deque
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T get(int index)
    {
        // If the index parameter is out of bounds we throw an IndexOutOfBoundsException
        if (index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Out of bounds index");
        }

        int counter = 0;

        // Iterate through the queue until we reach the desired index
        while (counter < index)
        {
            this.first = this.first.getNext();
            counter++;
        }

        return this.first.getItem();
    }

    /**
     * Returns {@code true} if this deque contains the specified element.
     * <p>
     * More formally, returns {@code true} if and only if this deque contains at least one
     * element {@code e} such that {@code Objects.equals(e, value)}.
     *
     * @param value whose presence in this deque is to be tested
     * @return {@code true} if this deque contains the specified element
     */
    @Override
    public boolean contains(T value)
    {
        int counter = 0;

        // Iterate through the queue until we find a node with the desired value
        while (counter < size && !first.getItem().equals(value))
        {
            first = first.getNext();
            counter++;
        }

        return first.getItem().equals(value);
    }

    /**
     * Removes the first occurrence of the specified element from this deque, if it is present.
     *
     * @param value to be removed from this deque, if present
     */
    @Override
    public void remove(T value)
    {
        // Create a cursor to iterate through the queue, indicates our current position in the queue
        DequeNode<T> current = first;
        int counter = 0;

        // Iterate through the queue until we find the first node containing our value
        while (counter < size && !current.getItem().equals(value))
        {
            current = current.getNext();
            counter++;
        }

        /**
         * If our cursor is at the first node, we just set first to its next node.
         * If our cursor is at the last node, we set last to its previous node.
         * If it's in between:
         *      1) Our current.previous.next will be set to our current.next
         *      2) Our current.next.previous will be set to our current.previous
         */
        if (current == first)
        {
            first = first.getNext();
            first.setPrevious(null);
        } else if (current == last)
        {
            last = last.getPrevious();
            last.setNext(null);
        } else
        {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }

        // Remove an element from the total size of the queue
        size--;
    }

    /**
     * Sorts this deque according to the order induced by the specified {@code Comparator}.
     *
     * <h3>Implementation Requirements:</h3>
     * The implementation must use an in-place sorting algorithm; i.e., it is not allowed to
     * allocate any new object on the heap.
     *
     * @param comparator the {@code Comparator} used to compare deque elements
     */
    @Override
    public void sort(Comparator<? super T> comparator)
    {
        if (comparator == null)
        {
            throw new DoubleEndedQueueException("The comparator cannot be null");
        }
        DequeNode<T> current, index;
        T temp;
        if (first != null)
        {
            for (current = first; current.getNext() != null; current = current.getNext())
            {
                for (index = current.getNext(); index != null; index = index.getNext())
                {
                    if (comparator.compare(current.getItem(), index.getItem()) > 0)
                    {
                        temp = current.getItem();
                        current.setItem(index.getItem());
                        index.setItem(temp);
                    }
                }
            }

        }
    }
}
