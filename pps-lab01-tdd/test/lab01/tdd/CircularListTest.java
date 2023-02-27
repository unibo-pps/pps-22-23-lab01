package lab01.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}