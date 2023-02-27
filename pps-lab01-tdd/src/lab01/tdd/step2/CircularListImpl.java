package lab01.tdd.step2;

import java.util.*;
import java.util.function.Function;
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
        return fromStream(isEmpty() ? Stream::empty : this.list::stream);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return fromStream(() -> isEmpty() ? Stream.empty() :
            IntStream.iterate(this.size() - 1, index -> index - 1)
                .limit(this.size())
                .mapToObj(this.list::get)
        );

    }

    private Iterator<Integer> fromStream(Supplier<Stream<Integer>> streamSupplier) {
        if (streamSupplier.get().findFirst().isEmpty()) {
            return Stream.<Integer>empty().iterator();
        }
        return Stream.generate(streamSupplier).flatMap(Function.identity()).iterator();
    }
}
