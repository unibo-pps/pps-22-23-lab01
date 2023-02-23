package lab01.tdd;

import java.util.Optional;

/**
 * Represents a circular list of integers, where the following element of the last one into the list
 * is the first element of the list itself.
 */
public interface CircularList {

    /**
     * Adds an element into the first available place
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Provides the next element of the list. Example: having a list like {1,2,3} the first call of next() returns 1,
     * the second call returns 2, then 3 is returned to the third call. Finally, the fourth one return 1 again,
     * because the circular mechanism.
     * @return the next element into the list
     */
    Optional<Integer> next();

    /**
     * Provides the previous element of the list. Its behaviour is dual of the next() method.
     * @return the previous element into the list
     */
    Optional<Integer> previous();

    /**
     * Reset the current element to the first one of the list. The first one is the first added to the list.
     */
    void reset();

    /**
     * Provides the next element of the list according to the injected strategy.
     * @param strategy the strategy to be used (e.g., the next even element, the next odd element, etc.)
     * @return the next element of the list according to the strategy.
     */
    Optional<Integer> next(final SelectStrategy strategy);
}
