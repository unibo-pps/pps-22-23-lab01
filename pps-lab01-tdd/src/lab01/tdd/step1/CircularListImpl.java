package lab01.tdd.step1;

import lab01.tdd.step1.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Integer> next() {
        if (!this.isEmpty()) {
            final Optional<Integer> result = Optional.of(this.list.get(pointer));
            this.pointer = (this.pointer + 1) % this.size();
            return result;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        if (!this.isEmpty()) {
            this.pointer = this.pointer == 0 ? this.size() - 1 : this.pointer - 1;
            return Optional.of(this.list.get(this.pointer));
        }
        return Optional.empty();
    }

    @Override
    public void reset() {
        this.pointer = 0;
    }
}
