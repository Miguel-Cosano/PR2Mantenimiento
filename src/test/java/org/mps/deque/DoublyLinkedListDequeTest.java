package org.mps.deque;


import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Test cases for DoublyLinkedListDeque
1.Empty list size is 0 :-> In an empty list, the size is 0
2.Prepend
    2.1 in empty list :-> In an empty list, when we prepend a node it becomes the first and last element and the size is 1
    2.2 in a list with one node :-> In a list with one node, when we prepend a node it becomes the first element and the size is 2
    2.3 when prepend with null value throws exception :-> When prepend with null value throws exception
3.Append
    3.1 in empty list :-> In an empty list, when we append a node it becomes the last and first element and the size is 1
    3.2 in a list with one node :-> In a list with one node, when we append a node it becomes the last element and the size is 2
    3.3 when append with null value throws exception :-> When append with null value throws exception
4.DeleteFirst
    4.1 when delete first in empty list throws exception :-> When delete first in empty list throws exception
    4.2 in a list with two nodes :-> In a list with two nodes, when we delete the first node, the first node is the second node and the size is 1. Is the same for a list with more nodes.
5.DeleteLast
    5.1 when delete last in empty list throws exception :-> When delete last in empty list throws exception
    5.2 in a list with two nodes :-> In a list with two nodes, when we delete the last node, the last node is the first node and the size is 1. Is the same for a list with more nodes.
6.Get
    6.1 when the list is empty throws exception :-> When the list is empty throws exception
    6.2 when negative index value throws exception :-> When negative index value throws exception
    6.3 when index value is bigger than the size of the deque throws exception :-> When index value is bigger than the size of the deque throws exception
    6.4 the first element of the deque  :-> When the index value is 0, we get the first element of the deque
    6.5 the last element of the deque :-> When the index value is the size of the deque - 1, we get the last element of the deque
    6.6 any in-between element of the deque :-> When the index value is any in-between element of the deque, we get the element in that position
7.Contains
    7.1 the vale int the queue is not present :-> The value is not present in the queue so the method returns false
    7.2 the vale int the queue is present :-> The value is present in the queue so the method returns true
    7.3 the empty list does not contain any value :-> The empty list does not contain any value so the method returns false
8.Remove
    8.1 size is reduced by one :-> When we remove a node, the size is reduced by one
    8.2 in a list with one element :-> When we remove the only element of the list, the list is empty
    8.3 in a list with two elements with same value :-> When we remove a value that is repeated in the list, it removes the first node with that value
    8.4 node not included in list :-> When we try to remove a node that is not included in the list, the list is not modified
    8.5 intermediate node :-> When we remove an intermediate node, the list is modified correctly
    8.6 last node :-> When we remove the last node, the list is modified correctly
    8.7 first node :-> When we remove the first node, the list is modified correctly
    8.8 in empty list :-> When we try to remove a node in an empty list, the list is not modified
9.Sort
    9.1 when null comparator throws exception :-> When null comparator throws exception
    9.2 list with more than three elements and comparator is reverse :-> When the list has more than three elements and the comparator is reverse, the list is sorted in reverse order correctly
    9.3 two elements list :-> When the list has two elements, the list is sorted correctly
    9.4 list with more than three elements :-> When the list has more than three elements, the list is sorted correctly
    9.6 empty list :-> When the list is empty, the list is not modified
    9.7 one element list :-> When the list has one element, it returns the same list
    9.8 three elements list :-> When the list has three elements, the list is sorted correctly
 */

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

        @Nested
        @DisplayName("prepend")
        class AfterPrependTestCases {
            @Test
            @DisplayName("in empty list")
            public void testPrependEmptyList() {

                int expectedSize = 1;
                int expectedFirst = 1;
                int expectedLast = 1;

                deque.prepend(1);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
            }

            @Test
            @DisplayName("in a list with one node")
            public void testPrependInLisWithOneNode() {
                deque.append(1);

                int expectedSize = 2;
                int expectedFirst = 2;
                int expectedLast = 1;

                deque.prepend(2);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);

            }

            @Test
            @DisplayName("when prepend with null value throws exception ")
            public void testPrependWithNullValue() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.prepend(null));
            }

        }

        @Nested
        @DisplayName("append")
        class AfterAppendTestCases {
            @Test
            @DisplayName("in empty list")
            public void testAppendEmptyList() {
                int expectedSize = 1;
                int expectedFirst = 1;
                int expectedLast = 1;

                deque.append(1);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
            }

            @Test
            @DisplayName("in a list with one node")
            public void testAppend() {
                deque.append(1);

                int expectedSize = 2;
                int expectedFirst = 1;
                int expectedLast = 2;

                deque.append(2);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
            }

            @Test
            @DisplayName("when append with null value throws exception")
            public void testAppendWithNullValue() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.append(null));
            }
        }

        @Nested
        @DisplayName("deleteFirst")
        class afterDeleteFistTestCases {
            @Test
            @DisplayName("in a list with two nodes")
            public void testDeleteFirst() {
                deque.append(1);
                deque.append(2);

                int expectedSize = 1;
                int expectedFirst = 2;
                int expectedLast = 2;


                deque.deleteFirst();

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
            }

            @Test
            @DisplayName("when delete first with empty list throws exception")
            public void testDeleteFirstWithEmptyList() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
            }
        }

        @Nested
        @DisplayName("deleteLast")
        class afterDeleteLastTestCases {
            @Test
            @DisplayName("in a list with two nodes")
            public void testDeleteLast() {
                deque.append(1);
                deque.append(2);

                int expectedSize = 1;
                int expectedFirst = 1;
                int expectedLast = 1;

                deque.deleteLast();

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
            }

            @Test
            @DisplayName("when delete last with empty list throws exception")
            public void testDeleteLastWithEmptyList() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
            }
        }

        /**
         * Test cases in charge of the get() function.
         */
        @Nested
        @DisplayName("get")
        class afterGetANodeFromTheDoublyLinkedListDequeTests {
            @Test
            @DisplayName("when the list is empty throws exception")
            void testGetWhenTheDoublyLinkedListDequeIsEmptyThrowsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> deque.get(0));
            }

            @Test
            @DisplayName("when negative index value throws exception")
            void testGetWhenIndexIsANegativeValueThrowsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> deque.get(-1));
            }

            @Test
            @DisplayName("when index value is bigger than the size of the deque throws exception")
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
        @DisplayName("contains")
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
        @DisplayName("sort")
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

                int expectedSize= 1;
                int expectedFirst= 2;
                int expectedLast= 2;
                boolean expectedContains= false;

                deque.remove(1);

                int actualSize= deque.size();
                int actualFirst= deque.first();
                int actualLast= deque.last();
                boolean actualContains= deque.contains(1);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedContains, actualContains);
            }

            @Test
            @DisplayName("last node ")
            public void testRemoveLastNodeInListWithTwoNodes() {
                deque.append(1);
                deque.append(2);

                int expectedSize= 1;
                int expectedFirst= 1;
                int expectedLast= 1;
                boolean expectedContains= false;

                deque.remove(2);

                int actualSize= deque.size();
                int actualFirst= deque.first();
                int actualLast= deque.last();
                boolean actualContains= deque.contains(2);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedContains, actualContains);
            }

            @Test
            @DisplayName("intermediate node")
            public void testRemoveIntermediateNode() {
                deque.append(1);
                deque.append(2);
                deque.append(3);

                int expectedSize= 2;
                int expectedFirst= 1;
                int expectedLast= 3;
                boolean expectedContains= false;

                deque.remove(2);

                int actualSize= deque.size();
                int actualFirst= deque.first();
                int actualLast= deque.last();
                boolean actualContains= deque.contains(2);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedContains, actualContains);


            }

            @Test
            @DisplayName("node not included in list")
            public void removeNodeNotIncludedReturnsSameList() {
                deque.append(1);
                deque.append(2);
                deque.append(3);

                int expectedSize= 3;
                int expectedFirst= 1;
                int expectedLast= 3;
                boolean expectedContains= false;

                deque.remove(4);

                int actualSize= deque.size();
                int actualFirst= deque.first();
                int actualLast= deque.last();
                boolean actualContains= deque.contains(4);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedContains, actualContains);
            }

            @Test
            @DisplayName("in empty list")
            public void testRemoveInEmptyList() {
                int expectedSize= 0;

                deque.remove(1);

                int actualSize= deque.size();

                assertEquals(expectedSize, actualSize);
            }


            @Test
            @DisplayName("in a list with two elements with same value")
            public void testRemoveInAListWithTwoElementsWithSameValue() {
                deque.append(1);
                deque.append(1);

                int expectedSize= 1;
                int expectedFirst= 1;
                int expectedLast= 1;

                deque.remove(1);

                int actualSize= deque.size();
                int actualFirst= deque.first();
                int actualLast= deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);


            }

            @Test
            @DisplayName("size is reduced by one")
            public void testRemoveInAListReducesSize() {
                deque.append(1);
                deque.append(2);
                deque.append(3);

                int expectedSize= 2;
                int expectedFirst= 1;
                int expectedLast= 3;

                deque.remove(2);

                int actualSize= deque.size();
                int actualFirst= deque.first();
                int actualLast= deque.last();

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
            }

            @Test
            @DisplayName("in a list with one element")
            public void testRemoveInAListWithOneElement() {
                deque.append(1);

                int expectedSize= 0;

                deque.remove(1);

                int actualSize= deque.size();

                assertEquals(expectedSize, actualSize);

            }
        }

        @Nested
        @DisplayName("sort")
        class afterSortTestCases {

            @Test
            @DisplayName("empty list")
            public void testSortWhenListIsEmptyReturnsZero() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;

                int expected = 0;

                deque.sort(comparator);

                int actual = deque.size();


                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("one element list")
            public void testSortWhenListHasOneElementReturnsListWithOneElement() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
                deque.append(1);

                int expectedSize = 1;
                int expectedFirst = 1;
                int expectedLast = 1;
                int expectedElement = 1;

                deque.sort(comparator);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();
                int actualElement = deque.get(0);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedElement, actualElement);
            }

            @Test
            @DisplayName("two elements list")
            public void testSortWhenListHasTwoElementsReturnsListWithTwoElements() {
                Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
                deque.append(2);
                deque.append(1);

                int expectedSize = 2;
                int expectedFirst = 1;
                int expectedLast = 2;
                int expectedFirstElement = 1;
                int expectedSecondElement = 2;

                deque.sort(comparator);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();
                int actualFirstElement = deque.get(0);
                int actualSecondElement = deque.get(1);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedFirstElement, actualFirstElement);
                assertEquals(expectedSecondElement, actualSecondElement);

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

                int expectedSize = 5;
                int expectedFirst = 1;
                int expectedLast = 5;
                int expectedFirstElement = 1;
                int expectedSecondElement = 2;
                int expectedThirdElement = 3;
                int expectedFourthElement = 4;
                int expectedFifthElement = 5;


                deque.sort(comparator);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();
                int actualFirstElement = deque.get(0);
                int actualSecondElement = deque.get(1);
                int actualThirdElement = deque.get(2);
                int actualFourthElement = deque.get(3);
                int actualFifthElement = deque.get(4);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedFirstElement, actualFirstElement);
                assertEquals(expectedSecondElement, actualSecondElement);
                assertEquals(expectedThirdElement, actualThirdElement);
                assertEquals(expectedFourthElement, actualFourthElement);
                assertEquals(expectedFifthElement, actualFifthElement);
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

                int expectedSize = 5;
                int expectedFirst = 5;
                int expectedLast = 1;
                int expectedFirstElement = 5;
                int expectedSecondElement = 4;
                int expectedThirdElement = 3;
                int expectedFourthElement = 2;
                int expectedFifthElement = 1;


                deque.sort(comparator);

                int actualSize = deque.size();
                int actualFirst = deque.first();
                int actualLast = deque.last();
                int actualFirstElement = deque.get(0);
                int actualSecondElement = deque.get(1);
                int actualThirdElement = deque.get(2);
                int actualFourthElement = deque.get(3);
                int actualFifthElement = deque.get(4);

                assertEquals(expectedSize, actualSize);
                assertEquals(expectedFirst, actualFirst);
                assertEquals(expectedLast, actualLast);
                assertEquals(expectedFirstElement, actualFirstElement);
                assertEquals(expectedSecondElement, actualSecondElement);
                assertEquals(expectedThirdElement, actualThirdElement);
                assertEquals(expectedFourthElement, actualFourthElement);
                assertEquals(expectedFifthElement, actualFifthElement);
            }

            @Test
            @DisplayName("when null comparator throws exception")
            public void testSortWhenComparatorIsNullThrowsException() {
                assertThrows(DoubleEndedQueueException.class, () -> deque.sort(null));
            }
        }
    }
}