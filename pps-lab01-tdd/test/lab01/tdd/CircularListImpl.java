package lab01.tdd;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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
        final Optional<Integer> result = this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(pointer));
        if (!this.isEmpty()) {
            this.pointer = (this.pointer + 1) % this.size();
        }
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        if (!this.isEmpty()) {
            this.pointer = this.pointer == 0 ? this.size() - 1 : this.pointer-1;
        }
        final Optional<Integer> result = this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(this.pointer));
        return result;
    }

    @Override
    public void reset() {
        this.pointer = 0;
    }
}
