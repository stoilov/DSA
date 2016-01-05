package heapStructures;

import java.util.ArrayList;

/**
 *
 * @author stoilov
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> data;

    public PriorityQueue() {
        data = new ArrayList<>();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int leftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public void add(E element) {
        data.add(element);
        filterUp(data.size() - 1);
    }

    private void filterUp(int index) {
        int parent = parentIndex(index);

        while (parent >= 0) {
            if (data.get(index).compareTo(data.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
                parent = parentIndex(index);
            } else {
                return;
            }
        }
    }

    public E remove() {
        E removed = data.get(0);
        E last = data.remove(data.size() - 1);

        if (data.size() > 0) {
            data.set(0, last);
        }

        filterDown(0);
        return removed;
    }

    private void filterDown(int index) {
        int left, right, smallest;

        while (index < data.size()) {
            left = leftChildIndex(index);
            right = rightChildIndex(index);
            smallest = index;

            if (left < data.size() && data.get(left).compareTo(data.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < data.size() && data.get(right).compareTo(data.get(smallest)) < 0) {
                smallest = right;
            }

            if (index == smallest) {
                return;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int first, int second) {
        E temp = data.get(first);
        data.set(first, data.get(second));
        data.set(second, temp);
    }

}
