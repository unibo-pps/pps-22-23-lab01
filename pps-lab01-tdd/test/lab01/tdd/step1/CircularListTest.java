package lab01.tdd.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void setUp() {
        circularList = new CircularListImpl();
    }

    @Test
    void testIsListInitiallyEmpty() {
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testInitialSizeIsZero() {
        assertEquals(0, circularList.size());
    }

    @Test
    void testCanAddNumbers() {
        this.populateList();
        assertEquals(3, circularList.size());
    }

    @Test
    void testNext() {
        this.populateList();
        testMethodYieldings(List.of(1, 2, 3, 1), circularList::next);
    }

    @Test
    void testPrevious() {
        this.populateList();
        testMethodYieldings(List.of(3, 2, 1, 3), circularList::previous);
    }

    @Test
    void testPreviousAfterNext() {
        this.populateList();
        circularList.next();
        assertEquals(Optional.of(1), circularList.previous());
    }

    @Test
    void testNextAfterPrevious() {
        this.populateList();
        circularList.previous();
        assertEquals(Optional.of(3), circularList.next());
    }

    @Test
    void testReset() {
        this.populateList();
        circularList.next();
        circularList.next();
        circularList.previous();
        circularList.next();
        circularList.reset();
        assertEquals(Optional.of(1), circularList.next());
    }

    private void populateList() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
    }

    @Test
    void testNextOnEmptyList() {
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testPreviousOnEmptyList() {
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    void testNextOnSingleElement() {
        this.circularList.add(1);
        this.testMethodYieldings(Collections.nCopies(50, 1), circularList::next);
    }
    @Test
    void testPreviousOnSingleElement() {
        this.circularList.add(1);
        this.testMethodYieldings(Collections.nCopies(50, 1), circularList::previous);
    }

    private void testMethodYieldings(List<Integer> yieldings, Supplier<Optional<Integer>> method) {
        for (int number : yieldings) {
            assertEquals(Optional.of(number), method.get());
        }
    }
}