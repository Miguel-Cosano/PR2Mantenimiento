package org.mps.deque;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * author: Miguel Angel Cosano Ramirez and Edgar Antonio Álvarez González
 */
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
        public void testEmptyListSizeIsZero() {
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
            public void testAppendInEmptyList() {
                deque.append(1);

                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }

            @Test
            @DisplayName("in a list with one node")
            public void testAppendInAListWithOneNode() {
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
            public void testDeleteFirstNodeInAListWith2Nodes() {
                deque.append(1);
                deque.append(2);
                deque.deleteFirst();

                assertEquals(1, deque.size());
                assertEquals(2, deque.first());
                assertEquals(2, deque.last());
            }

            @Test
            @DisplayName("last node ")
            public void testDeleteLastNodeInListWithTwoNodes() {
                deque.append(1);
                deque.append(2);
                deque.deleteLast();

                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }







        }
        @Test
        @DisplayName("when delete last with empty list throws exception")
        public void testDeleteLastWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }
        @Test
        @DisplayName("when delete first with empty list throws exception")
        public void testDeleteFirstWithEmptyList() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }
        @Test
        @DisplayName("when append null value throws exception")
        public void testAppendWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.append(null));
        }
        @Test
        @DisplayName("when prepend with null value throws exception")
        public void testPrependWithNullValue() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.prepend(null));
        }
        @DisplayName("remove")
        @Nested
        class afterRemoveTestCases {
            @Test
            @DisplayName("first node ")
            public void testRemoveFirstNodeInAListWith2Nodes() {
                deque.append(1);
                deque.append(2);
                deque.remove(1);

                assertEquals(1, deque.size());
                assertEquals(2, deque.first());
                assertEquals(2, deque.last());
            }

            @Test
            @DisplayName("last node ")
            public void testRemoveLastNodeInListWithTwoNodes() {
                deque.append(1);
                deque.append(2);
                deque.remove(2);

                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }

            @Test
            @DisplayName ("intermediate node")
            public void testRemoveIntermediateNode() {
                deque.append(1);
                deque.append(2);
                deque.append(3);
                deque.remove(2);

                assertEquals(2, deque.size());
                assertEquals(1, deque.first());
                assertEquals(3, deque.last());


            }

            @Test
            @DisplayName("in empty list")
            public void testRemoveInEmptyList() {
                deque.remove(1);

                assertEquals(0, deque.size());
            }

            @Test
            @DisplayName("in a list with two elements with same value")
            public void testRemoveInAListWithTwoElementsWithSameValue() {
                deque.append(1);
                deque.append(1);
                deque.remove(1);

                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }
        }
    }



    @AfterEach
    public void tearDown() {
        deque = null;
    }

}