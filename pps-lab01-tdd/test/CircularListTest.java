import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImplementation;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList cl;

    @BeforeEach
    void before(){
        this.cl = new CircularListImplementation();
    }

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @Test
    public void addTest() {
        this.cl.add(23);
        assertEquals(this.cl.size(), 1);
    }

    @Test
    public void sizeTest() {
        IntStream.range(0, 200)
        .forEach((element) -> this.cl.add(element));
        assertEquals(this.cl.size(), 200);
    }

    @Test
    public void isEmptyTest() {
        assertEquals(this.cl.size(), 0);
    }

    @Test
    public void nextTestEmpty() {
        assertEquals(Optional.empty(), this.cl.next());
    }

    @Test
    public void nextTest() {
        this.cl.add(23);
        Optional<Integer> nextElem = this.cl.next();
        assertEquals(Optional.of(23), nextElem);
        this.cl.add(49);
        assertEquals(Optional.of(49), this.cl.next());
    }

    @Test
    public void nextTestSeq() {
        this.cl.add(23);
        Optional<Integer> nextElem = this.cl.next();
        assertEquals(Optional.of(23), nextElem);
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
        assertEquals(Optional.of(23), this.cl.next());
    }

    @Test
    public void previousTest() {
        this.cl.add(23);
        this.cl.add(99);
        assertEquals(Optional.of(23), this.cl.previous());
        assertEquals(Optional.of(99), this.cl.previous());
        assertEquals(Optional.of(23), this.cl.previous());
        assertEquals(Optional.of(99), this.cl.previous());
    }

    @Test
    public void resetTest() {
        this.nextTest();
        this.cl.add(21);
        this.cl.reset();
        assertEquals(Optional.of(23), this.cl.next());
    }

    @Test
    public void testForwardAndBack() {
        this.cl.add(21);
        this.cl.add(39);
        this.cl.add(74);
        assertEquals(Optional.of(21), this.cl.next());
        assertEquals(Optional.of(39), this.cl.previous());
        assertEquals(Optional.of(21), this.cl.previous());
    }
}
