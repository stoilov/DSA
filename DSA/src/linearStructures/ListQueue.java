package linearStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * LinkedList alike implementation of a Queue linear structure
 * 
 * @author grade
 * @param <E>
 */
public class ListQueue<E> {

    private class QueueNode<T> {

        T data;
        QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }
    }

    QueueNode<E> first;
    QueueNode<E> last;
    private int count;

    public ListQueue() {
        first = null;
        last = null;
        count = 0;
    }

    public void enqueue(E element) {
        if (isEmpty()) {
            first = last = new QueueNode<>(element);
        } else {
            last.next = new QueueNode<>(element);
            last = last.next;
        }

        count++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        count--;
        QueueNode<E> dequeued = first;
        first = first.next;

        return dequeued.data;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static Queue<String> insertFromFile(String filename) {
        if (filename == null) {
            return null;
        }

        Queue<String> queue = new Queue<>();

        try (Scanner input = new Scanner(new File(filename))) {
            while (input.hasNext()) {
                queue.enqueue(input.next());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return queue;
    }

    @Override
    public String toString() {
        QueueNode current = first;
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (current.hasNext()) {
            sb.append(current.data);
            current = current.next;

            if (current.hasNext()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

}
