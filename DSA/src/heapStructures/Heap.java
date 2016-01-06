/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapStructures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stoilov
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {

    List<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public void insert(T element) {
        heap.add(element);
        filterUp(heap.size() - 1);
    }

    private void filterUp(int index) {
        int parent = parent(index);

        while (parent >= 0) {
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(parent, index);
                index = parent;
                parent = parent(index);
            } else {
                return;
            }
        }
    }

    public T remove() {
        T removed = heap.get(0);
        T last = heap.remove(heap.size());

        if (heap.size() > 0) {
            heap.set(0, last);
        }

        return removed;
    }

    private void filterDown(int index) {
        int left, right, smallest;

        while (index < heap.size()) {
            left = leftChild(index);
            right = rightChild(index);
            smallest = index;
            
            if (left < heap.size() && heap.get(left).compareTo(heap.get(right)) < 0) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(left).compareTo(heap.get(right)) > 0) {
                smallest = right;
            }
            
            if (smallest == index) {
                return;
            }
            
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int first, int second) {
        T temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }
}
