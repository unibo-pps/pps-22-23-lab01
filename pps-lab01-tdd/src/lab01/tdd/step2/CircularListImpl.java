package lab01.tdd.step2;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<>() {

            private int pointer = 0;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                final int result = list.get(pointer);
                pointer = (pointer + 1) % size();
                return result;
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<>() {

            private int pointer = 0;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                pointer = pointer == 0 ? size() - 1 : pointer - 1;
                return list.get(pointer);
            }
        };
    }
}
