import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Eagerly flattens a nested list using recursive DFS.
 * NestedInteger is supplied by the problem platform.
 *
 * Constructor: O(T) time, O(N + D) peak auxiliary space.
 * next() and hasNext(): O(1) time each.
 * T = all NestedInteger occurrences, N = integers,
 * D = maximum number of active flattening calls.
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> result = null;
    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<>();
        flattening(nestedList);
        // iterator() returns an object implementing Iterator<Integer>.
        it = result.iterator();
    }

    public void flattening(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result.add(ni.getInteger());
            } else {
                flattening(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        // Delegation also throws NoSuchElementException when exhausted.
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}
