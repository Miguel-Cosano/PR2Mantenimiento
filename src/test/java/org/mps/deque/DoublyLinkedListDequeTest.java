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
    @Test
    @DisplayName("is instantiated with new DoublyLinkedListDeque()")
    public void setUp() {
        deque = new DoublyLinkedListDeque<>();
    }

    /**
     * Set the list to null after each test.
     */


    @Nested
    @DisplayName("When new")
    class whenNewTestCases{
        @Test
        @DisplayName("empty list size is 0")
        public void testEmptyList() {
            assertEquals(0, deque.size());
        }
        @Nested
        @DisplayName("prepend")
        class AfterPrependTestCases{
            @Test
            @DisplayName("in empty list")
            public void testPrependEmptyList() {
                deque.prepend(1);
                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }

            @Test
            @DisplayName("in a list with one node")
            public void testPrepend() {
                deque.append(1);
                deque.prepend(2);
                assertEquals(2, deque.size());
                assertEquals(2, deque.first());
                assertEquals(1, deque.last());
            }

        }
        @Nested
        @DisplayName("append")
        class AfterAppendTestCases{
            @Test
            @DisplayName("in empty list")
            public void testAppendEmptyList() {
                deque.append(1);
                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }

            @Test
            @DisplayName("in a list with one node")
            public void testAppend() {
                deque.append(1);
                deque.append(2);
                assertEquals(2, deque.size());
                assertEquals(1, deque.first());
                assertEquals(2, deque.last());
            }


        }

        @Nested
        @DisplayName("delete")
        class afterDeleteTestCases{
            @Test
            @DisplayName("first node ")
            public void testDeleteFirst() {
                deque.append(1);
                deque.append(2);
                deque.deleteFirst();
                assertEquals(1, deque.size());
                assertEquals(2, deque.first());
                assertEquals(2, deque.last());
            }

            @Test
            @DisplayName("last node ")
            public void testDeleteLast() {
                deque.append(1);
                deque.append(2);
                deque.deleteLast();
                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }




        }
        @Test
        @DisplayName("throws exception when delete last with empty list")
        public void testDeleteLastWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }
        @Test
        @DisplayName("throws exception when delete first with empty list")
        public void testDeleteFirstWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }
        @Test
        @DisplayName("throws exception when append with null value")
        public void testAppendWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.append(null));
        }
        @Test
        @DisplayName("throws exception when prepend with null value")
        public void testPrependWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.prepend(null));
        }
    }


    @AfterEach
    public void tearDown() {
        deque = null;
    }

}