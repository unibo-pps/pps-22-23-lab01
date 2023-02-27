package lab01.tdd.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    private CircularList circularList;
    @BeforeEach
    void setUp() {
        circularList = new CircularListImpl();
    }

    @Test
    void testListIsInitiallyEmpty() {
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testCanAddElements() {
        this.populateList();
        assertEquals(3, this.circularList.size());
    }

    @Test
    void testForwardIterator() {
        this.populateList();
        testIterator(List.of(1, 2, 3, 1), this.circularList::forwardIterator);
    }

    @Test
    void testBackwardIterator() {
        this.populateList();
        testIterator(List.of(3, 2, 1, 3), this.circularList::backwardIterator);
    }

    private void populateList() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
    }

    @Test
    void testForwardIteratorOnEmptyList() {
        var iterator = this.circularList.forwardIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testBackwardIteratorOnEmptyList() {
        var iterator = this.circularList.backwardIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testForwardIteratorOnSingleElement() {
        this.circularList.add(2);
        testIterator(Collections.nCopies(100, 2), this.circularList::forwardIterator);
    }

    @Test
    void testBackwardIteratorOnSingleElement() {
        this.circularList.add(2);
        testIterator(Collections.nCopies(100, 2), this.circularList::backwardIterator);
    }

    @Test
    void testNewForwardIteratorAfterAdd() {
        this.populateList();
        testIterator(List.of(1, 2, 3, 1), this.circularList::forwardIterator);
        this.circularList.add(4);
        testIterator(List.of(1, 2, 3, 4, 1), this.circularList::forwardIterator);
    }

    @Test
    void testNewBackwardIteratorAfterAdd() {
        this.populateList();
        testIterator(List.of(3, 2, 1, 3), this.circularList::backwardIterator);
        this.circularList.add(4);
        testIterator(List.of(4, 3, 2, 1, 4), this.circularList::backwardIterator);
    }

    private void testIterator(List<Integer> expectedYields, Supplier<Iterator<Integer>> iteratorSupplier) {
        Iterator<Integer> iterator = iteratorSupplier.get();
        assertTrue(iterator.hasNext());
        isYieldingCorrectly(expectedYields, iterator);
    }

    private void isYieldingCorrectly(List<Integer> yieldings, Iterator<Integer> iterator) {
        for (int number : yieldings) {
            assertEquals(number, iterator.next());
        }
    }

}