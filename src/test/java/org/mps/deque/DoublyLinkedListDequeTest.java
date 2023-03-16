package org.mps.deque;


import org.junit.jupiter.api.*;

import java.util.Comparator;

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
                assertEquals(false, deque.contains(1));
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
                assertEquals(false, deque.contains(2));
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
                assertEquals(false, deque.contains(2));


            }

            @Test
            @DisplayName("node not included in list")
            public void removeNodeNotIncludedReturnsSameList() {
                deque.append(1);
                deque.append(2);
                deque.append(3);
                deque.remove(4);

                assertEquals(3, deque.size());
                assertEquals(1, deque.first());
                assertEquals(3, deque.last());
                assertEquals(false, deque.contains(4));
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

            @Test
            @DisplayName("when you delete there is a reduction in size")
            public void testRemoveInAListReducesSize() {
                deque.append(1);
                deque.append(2);
                deque.append(3);
                deque.remove(2);

                assertEquals(2, deque.size());
            }
        }

        @Nested
        @DisplayName("get")
        class afterGetTestCases{

            @Test
            @DisplayName("first node ")
            public void testGetFirstNodeInAListWith2NodesReturnFirstNode() {
                deque.append(1);
                deque.append(2);

                assertEquals(1, deque.get(0));
            }

            @Test
            @DisplayName("last node ")
            public void testGetLastNodeInAListWith2NodesReturnLast() {
                deque.append(1);
                deque.append(2);

                assertEquals(2, deque.get(1));
            }

            @Test
            @DisplayName("intermediate node ")
            public void testGetIntermediateNodeInAListWith3NodesReturnsNode() {
                deque.append(1);
                deque.append(2);
                deque.append(3);

                assertEquals(2, deque.get(1));
            }

            @Test
            @DisplayName("in empty list")
            public void testGetInEmptyListThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.get(0));
            }

            @Test
            @DisplayName("when index is negative")
            public void testGetWithNegativeIndexThrowsException() {
                deque.append(1);

                assertThrows(DoubleEndedQueueException.class, () -> deque.get(-1));
            }

            @Test
            @DisplayName("when index is greater than size")
            public void testGetWithIndexGreaterThanSizeThrowsException() {
                deque.append(1);

                assertThrows(DoubleEndedQueueException.class, () -> deque.get(1));
            }

        }

        @Nested
        @DisplayName("contains")
        class afterContainsTestCases{
            @Test
            @DisplayName("value is present")
            public void testContainsWhenValueIsPresentReturnsTrue() {
                deque.append(1);
                deque.append(2);
                deque.append(3);

                assertEquals(true, deque.contains(2));
            }

            @Test
            @DisplayName("value is not present")
            public void testContainsWhenValueIsNotPresentReturnsFalse() {
                deque.append(1);
                deque.append(2);
                deque.append(3);

                assertEquals(false, deque.contains(4));
            }

            @Test
            @DisplayName("empty list")
            public void testContainsWhenListIsEmptyReturnFalse() {
                assertEquals(false, deque.contains(1));
            }


        }

        @Nested
        @DisplayName("sort")
        class afterSortTestCases{

            @Test
            @DisplayName("empty list")
            public void testSortWhenListIsEmptyReturnsZero() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;

                deque.sort(comparator);

                assertEquals(0, deque.size());
            }

            @Test
            @DisplayName("one element list")
            public void testSortWhenListHasOneElementReturnsListWithOneElement() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
                deque.append(1);

                deque.sort(comparator);

                assertEquals(1, deque.size());
                assertEquals(1, deque.first());
                assertEquals(1, deque.last());
            }

            @Test
            @DisplayName("two elements list")
            public void testSortWhenListHasTwoElementsReturnsListWithTwoElements() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
                deque.append(2);
                deque.append(1);

                deque.sort(comparator);

                assertEquals(2, deque.size());
                assertEquals(1, deque.first());
                assertEquals(2, deque.last());
            }

            @Test
            @DisplayName("three elements list")
            public void testSortWhenListHasThreeElementsReturnsListWithThreeElements() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
                deque.append(3);
                deque.append(2);
                deque.append(1);

                deque.sort(comparator);

                assertEquals(3, deque.size());
                assertEquals(1, deque.first());
                assertEquals(3, deque.last());
            }

            @Test
            @DisplayName("list with more than three elements")
            public void testSortWhenListHasMoreThanThreeElementsReturnsListWithMoreThanThreeElements() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
                deque.append(5);
                deque.append(4);
                deque.append(3);
                deque.append(2);
                deque.append(1);

                deque.sort(comparator);

                assertEquals(5, deque.size());
                assertEquals(1, deque.first());
                assertEquals(5, deque.last());
            }



            @Test
            @DisplayName("list with more than three elements and comparator is reverse")
            public void testSortWhenListHasMoreThanThreeElementsAndComparatorIsReverse() {
                Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
                deque.append(5);
                deque.append(4);
                deque.append(3);
                deque.append(2);
                deque.append(1);

                deque.sort(comparator);

                assertEquals(5, deque.size());
                assertEquals(5, deque.first());
                assertEquals(1, deque.last());
            }

            @Test
            @DisplayName("null comparator throws exception")
            public void testSortWhenComparatorIsNullThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.sort(null));
            }


        }


    }



    @AfterEach
    public void tearDown() {
        deque = null;
    }

}