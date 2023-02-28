package lab01.tdd.step3;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int pointer = 0;

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
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
         Optional<Integer> nextElementIndex = IntStream.iterate(0, index -> index + 1)
                 .limit(this.size())
                 .mapToObj(index -> (pointer + index) % this.size())
                 .filter(index -> predicate.test(this.list.get(index)))
                 .findFirst();
        nextElementIndex.ifPresent(index -> this.pointer = index + 1);
        return nextElementIndex.map(this.list::get);
    }
}
