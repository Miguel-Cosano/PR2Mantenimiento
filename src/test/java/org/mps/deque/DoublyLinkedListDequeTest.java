package org.mps.deque;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test DoublyLinkedListDeque")
public class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> deque;
    @BeforeEach
    public void setUp() {
        deque = new DoublyLinkedListDeque<>();
    }

    @AfterEach
    public void tearDown() {
        deque = null;
    }
    @Nested
    @DisplayName("Basics tests cases")
    class EnqueueTestBasic{
        @Test
        public void testEmptyList() {
            assertEquals(0, deque.size());
        }

        @Test
        public void testPrependEmptyList() {
            deque.prepend(1);
            assertEquals(1, deque.size());
            assertEquals(1, deque.first());
            assertEquals(1, deque.last());
        }

        @Test
        public void testAppendEmptyList() {
            deque.append(1);
            assertEquals(1, deque.size());
            assertEquals(1, deque.first());
            assertEquals(1, deque.last());
        }

        @Test
        public void testPrepend() {
            deque.append(1);
            deque.prepend(2);
            assertEquals(2, deque.size());
            assertEquals(2, deque.first());
            assertEquals(1, deque.last());
        }

        @Test
        public void testDeleteFirst() {
            deque.append(1);
            deque.append(2);
            deque.deleteFirst();
            assertEquals(1, deque.size());
            assertEquals(2, deque.first());
            assertEquals(2, deque.last());
        }

        @Test
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
        public void testPrependWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.prepend(null));
        }

        @Test
        public void testAppendWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.append(null));
        }

        @Test
        public void testDeleteFirstWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }

        @Test
        public void testDeleteLastWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }
    }







}