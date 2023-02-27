package lab01.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(2), circularList.next());
        assertEquals(Optional.of(3), circularList.next());
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testPrevious() {
        this.populateList();
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
        assertEquals(Optional.of(1), circularList.previous());
        assertEquals(Optional.of(3), circularList.previous());
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

    @Test
    void testNextOnEmptyList() {
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testPreviousOnEmptyList() {
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testNextOnSingleElement() {
        final int numberOfAttempts = 100;
        final int expected = 2;
        circularList.add(expected);
        for (var i = 0; i < numberOfAttempts; i++) {
            assertEquals(Optional.of(expected), circularList.next());
        }
    }
    @Test
    void testPreviousOnSingleElement() {
        final int numberOfAttempts = 100;
        final int expected = 2;
        circularList.add(expected);
        for (var i = 0; i < numberOfAttempts; i++) {
            assertEquals(Optional.of(expected), circularList.previous());
        }
    }

    private void populateList() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
    }
}