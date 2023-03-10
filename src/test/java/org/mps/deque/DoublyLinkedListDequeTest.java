package org.mps.deque;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("A DoublyLinkedListDeque")
public class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> deque;

    /**
     * Create a new empty list before each test.
     */
    @BeforeEach
    public void setUp() {
        deque = new DoublyLinkedListDeque<>();
    }

    /**
     * Set the list to null after each test.
     */

    @AfterEach
    public void tearDown() {
        deque = null;
    }
    @Nested
    @DisplayName("Basics tests cases")
    class EnqueueTestBasic{
        @Test
        @DisplayName("Empty list size is 0")
        public void testEmptyList() {
            assertEquals(0, deque.size());
        }

        @Test
        @DisplayName("Prepend with empty list")
        public void testPrependEmptyList() {
            deque.prepend(1);
            assertEquals(1, deque.size());
            assertEquals(1, deque.first());
            assertEquals(1, deque.last());
        }

        @Test
        @DisplayName("Append with empty list")
        public void testAppendEmptyList() {
            deque.append(1);
            assertEquals(1, deque.size());
            assertEquals(1, deque.first());
            assertEquals(1, deque.last());
        }

        @Test
        @DisplayName("Basic append")
        public void testPrepend() {
            deque.append(1);
            deque.prepend(2);
            assertEquals(2, deque.size());
            assertEquals(2, deque.first());
            assertEquals(1, deque.last());
        }

        @Test
        @DisplayName("Delete first node ")
        public void testDeleteFirst() {
            deque.append(1);
            deque.append(2);
            deque.deleteFirst();
            assertEquals(1, deque.size());
            assertEquals(2, deque.first());
            assertEquals(2, deque.last());
        }

        @Test
        @DisplayName("Delete last node ")
        public void testDeleteLast() {
            deque.append(1);
            deque.append(2);
            deque.deleteLast();
            assertEquals(1, deque.size());
            assertEquals(1, deque.first());
            assertEquals(1, deque.last());
        }
    }

    @Nested
    @DisplayName("Exceptions tests cases")
    class EnqueueTestExceptions{
        @Test
        @DisplayName("Exception when prepend with null value")
        public void testPrependWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.prepend(null));
        }

        @Test
        @DisplayName("Exception when append with null value")
        public void testAppendWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.append(null));
        }

        @Test
        @DisplayName("Exception when delete first with empty list")
        public void testDeleteFirstWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }

        @Test
        @DisplayName("Exception when delete last with empty list")
        public void testDeleteLastWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }
    }







}