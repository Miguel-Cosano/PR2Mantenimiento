package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * author: Edgar Antonio Álvarez González and Miguel Angel Cosano Ramirez
 */

@DisplayName("A Node")
public class DequeNodeTest
{
    DequeNode<Integer> head, node, tail;

    /**
     * Create the node and the previous and next node for it.
     */
    @BeforeEach
    void setUp()
    {
        head = new DequeNode<>(0, null, null);
        node = new DequeNode<>(1, null, null);
        tail = new DequeNode<>(2, null, null);

        head.setNext(node);
        node.setPrevious(head);
        node.setNext(tail);
        tail.setPrevious(node);
    }

    /**
     * We destroy everything after each test.
     */
    @AfterEach
    void tearDown()
    {
        // Destroy the deque nodes
        node = null;
        head = null;
        tail = null;
    }

    @Nested
    @DisplayName("when new")
    class whenNewTests
    {

        @Nested
        @DisplayName("head")
        class headDequeNodeTests
        {
            @Test
            @DisplayName("is not null")
            void testHeadNodeIsNotNullReturnsTrue()
            {
                assertNotNull(head);
            }

            @Test
            @DisplayName("is the first node")
            void testHeadNodeIsFirstNodeReturnsTrue()
            {
                boolean expected = true;

                boolean actual = head.isFirstNode();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("is a terminal node")
            void testHeadNodeIsNotATerminalNodeReturnsFalse()
            {
                boolean expected = false;

                boolean actual = head.isNotATerminalNode();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("is not the last node")
            void testHeadNodeIsTheLastNodeReturnsFalse()
            {
                boolean expected = false;

                boolean actual = head.isLastNode();

                assertEquals(expected, actual);
            }
        }

        @Nested
        @DisplayName("node")
        class nodeDequeNodeTests
        {
            @Test
            @DisplayName("is not null")
            void testNodeIsNotNullReturnsTrue()
            {
                assertNotNull(node);
            }

            @Test
            @DisplayName("is not the first node")
            void testNodeIsFirstNodeReturnsFalse()
            {
                boolean expected = false;

                boolean actual = node.isFirstNode();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("is not a terminal node")
            void testNodeIsNotATerminalNodeReturnsTrue()
            {
                boolean expected = true;

                boolean actual = node.isNotATerminalNode();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("is not the last node")
            void testNodeIsTheLastNodeReturnsFalse()
            {
                boolean expected = false;

                boolean actual = node.isLastNode();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("the node value is changed successful")
            void testChangingTheValueOfANodeReturnsTheExpectedValue()
            {
                int expected = 33;

                node.setItem(33);
                int actual = node.getItem();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("the previous node of our middle node is the head")
            void testPreviousNodeOfMiddleNodeIsTheHeadReturnsTrue()
            {
                boolean expected = true;

                boolean actual = node.getPrevious() == head;

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("the next node of our middle node is the tail")
            void testNextNodeOfMiddleNodeIsTheTailReturnsTrue()
            {
                boolean expected = true;

                boolean actual = node.getNext() == tail;

                assertEquals(expected, actual);
            }
        }

        @Nested
        @DisplayName("tail")
        class tailDequeNodeTests
        {
            @Test
            @DisplayName("is not null")
            void testTailNodeIsNotNullReturnsTrue()
            {
                assertNotNull(tail);
            }

            @Test
            @DisplayName("is not the first node")
            void testTailNodeIsFirstNodeReturnsFalse()
            {
                boolean expected = false;

                boolean actual = tail.isFirstNode();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("is a terminal node")
            void testTailNodeIsNotATerminalNodeReturnsFalse()
            {
                boolean expected = false;

                boolean actual = tail.isNotATerminalNode();

                assertEquals(expected, actual);
            }

            @Test
            @DisplayName("is the last node")
            void testTailNodeIsTheLastNodeReturnsTrue()
            {
                boolean expected = true;

                boolean actual = tail.isLastNode();

                assertEquals(expected, actual);
            }
        }
    }

}