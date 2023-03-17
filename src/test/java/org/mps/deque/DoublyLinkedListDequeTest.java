package org.mps.deque;


import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * author: Edgar Antonio Álvarez González and Miguel Angel Cosano Ramirez
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

    @AfterEach
    public void tearDown() {
        deque = null;
    }

    @Nested
    @DisplayName("When new")
    class whenNewTestCases {
        @Test
        @DisplayName("empty list size is 0")
        public void testEmptyList() {
            assertEquals(0, deque.size());
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

        @Nested
        @DisplayName("prepend()")
        class AfterPrependTestCases {
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
        @DisplayName("append()")
        class AfterAppendTestCases {
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
        @DisplayName("delete()")
        class afterDeleteTestCases {
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

        /**
         * Test cases in charge of the get() function.
         */
        @Nested
        @DisplayName("get()")
        class afterGetANodeFromTheDoublyLinkedListDequeTests {
            @Test
            @DisplayName("the empty list throws exception")
            void testGetWhenTheDoublyLinkedListDequeIsEmptyThrowsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> deque.get(0));
            }

            @Test
            @DisplayName("negative index value throws exception")
            void testGetWhenIndexIsANegativeValueThrowsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> deque.get(-1));
            }

            @Test
            @DisplayName("index value is bigger than the size of the deque")
            void testGetWhenIndexHasAValueBiggerThanDequeSizeThrowsIndexOutOfBoundsException() {
                deque.append(0);
                assertThrows(IndexOutOfBoundsException.class, () -> deque.get(1));
            }

            @Test
            @DisplayName("the first element of the deque")
            void testGetTheFirstElementOfTheDequeReturnsTheFirstElement() {
                deque.append(0);
                deque.append(1);
                deque.append(2);

                Integer expected = 0;

                Integer actual = deque.get(0);

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("the last element of the deque")
            void testGetTheLastElementOfTheDequeReturnsTheFirstElement() {
                deque.append(0);
                deque.append(1);
                deque.append(2);

                Integer expected = 2;

                Integer actual = deque.get(2);

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("any in-between element of the deque")
            void testGetAnyInBetweenElementsOfTheDequeReturnsTheFirstElement() {
                deque.append(0);
                deque.append(1);
                deque.append(2);

                Integer expected = 1;

                Integer actual = deque.get(1);

                assertEquals(expected, actual);
            }

        }

        /**
         * Test cases in charge of the contains() function.
         */
        @Nested
        @DisplayName("contains()")
        class afterContainsANodeInTheDoublyLinkedListDequeTests {
            @Test
            @DisplayName(" the value in the queue is present")
            public void testContainsWhenValueIsPresentReturnsTrue() {
                deque.append(1);

                boolean expected = true;

                boolean actual = deque.contains(1);

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName(" the value in the queue is not present")
            public void testContainsWhenValueIsNotPresentReturnsFalse() {
                deque.append(1);

                boolean expected = false;

                boolean actual = deque.contains(2);

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName(" the empty list does not contain any value ")
            public void testContainsWhenTheDoublyLinkedListDequeIsEmptyReturnFalse() {
                boolean expected = false;

                boolean actual = deque.contains(2);

                assertEquals(expected, actual);
            }
        }

        /**
         * Test cases in charge of the sort() function.
         */
        @Nested
        @DisplayName("sort()")
        class afterSortingTheDoublyLinkedListDequeTests {

        }

        /**
         * Test cases in charge of the remove() function.
         */
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
            @DisplayName("intermediate node")
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
            @DisplayName("size is reduced")
            public void testRemoveInAListReducesSize() {
                deque.append(1);
                deque.append(2);
                deque.append(3);
                deque.remove(2);

                assertEquals(2, deque.size());
                assertEquals(1, deque.first());
                assertEquals(3, deque.last());
            }

            @Test
            @DisplayName("in a list with one element")
            public void testRemoveInAListWithOneElement() {
                deque.append(1);
                deque.remove(1);

                assertEquals(0, deque.size());

            }
        }

        @Nested
        @DisplayName("sort")
        class afterSortTestCases {

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
                assertEquals(1, deque.get(0));
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
                assertEquals(1, deque.get(0));
                assertEquals(2, deque.get(1));

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
                assertEquals(1, deque.get(0));
                assertEquals(2, deque.get(1));
                assertEquals(3, deque.get(2));
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
                assertEquals(1, deque.get(0));
                assertEquals(2, deque.get(1));
                assertEquals(3, deque.get(2));
                assertEquals(4, deque.get(3));
                assertEquals(5, deque.get(4));

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
                assertEquals(5, deque.get(0));
                assertEquals(4, deque.get(1));
                assertEquals(3, deque.get(2));
                assertEquals(2, deque.get(3));
                assertEquals(1, deque.get(4));
            }

            @Test
            @DisplayName("when null comparator throws exception")
            public void testSortWhenComparatorIsNullThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.sort(null));
            }
        }
    }
}