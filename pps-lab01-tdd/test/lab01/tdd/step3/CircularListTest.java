package lab01.tdd.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void setUp() {
        this.circularList = new CircularListImpl();
    }

    @Test
    void testIsInitiallyEmpty() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void testElementsCanBeAdded() {
        this.populateList();
        assertEquals(3, this.circularList.size());
    }

    @Test
    void testFilteredNextOnEmptyList() {
        assertEquals(Optional.empty(), this.circularList.filteredNext(number -> true));
    }

    @Test
    void testNeverMatchingCondition() {
        this.populateList();
        assertEquals(Optional.empty(), this.circularList.filteredNext(number -> number > 3));
    }

    @Test
    void testAlwaysMatchingCondition() {
        this.populateList();
        final Predicate<Integer> alwaysMatchingPredicate = number -> true;
        assertEquals(Optional.of(1), this.circularList.filteredNext(alwaysMatchingPredicate));
        assertEquals(Optional.of(2), this.circularList.filteredNext(alwaysMatchingPredicate));
        assertEquals(Optional.of(3), this.circularList.filteredNext(alwaysMatchingPredicate));
        assertEquals(Optional.of(1), this.circularList.filteredNext(alwaysMatchingPredicate));
    }

    @Test
    void testOneElementMatchingCondition() {
        this.populateList();
        testCondition(Collections.nCopies(7, 3), number -> number > 2);
    }

    @Test
    void testMultipleMatchingCondition() {
        this.populateListWith(List.of(1, 2, 4, 4, 5, 2, 10, 3, 6));
        testCondition(List.of(2, 4, 4, 2, 10, 6, 2, 4), number -> number % 2 == 0);
    }

    private void populateList() {
        populateListWith(List.of(1, 2, 3));
    }

    private void populateListWith(List<Integer> list) {
        list.forEach(this.circularList::add);
    }

    private void testCondition(List<Integer> expectedYieldings, Predicate<Integer> condition) {
        for (int number : expectedYieldings) {
            assertEquals(Optional.of(number), this.circularList.filteredNext(condition));
        }
    }
}