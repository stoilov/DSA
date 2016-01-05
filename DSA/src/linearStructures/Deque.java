/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearStructures;

/**
 *
 * @author stoilov
 * @param <T>
 */
public class Deque<T> {

    private int front;
    private int rear;
    private int length;
    private T[] deque;

    public Deque() {
        length = 2;
        deque = (T[]) new Object[length];
        front = rear = 0;
    }

    public void insertFirst(T element) {
        if (element == null) {
            return;
        }

        front--;

        if (front == -1) {
            front = length - 1;
        }

        deque[front] = element;

        if (front == rear) {
            resizeQueue(length * 2);
        }
    }

    public void insertLast(T element) {
        if (element == null) {
            return;
        }

        deque[rear++] = element;

        if (rear == length) {
            rear = 0;
        }

        if (rear == front) {
            resizeQueue(length * 2);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T dequeued = deque[front];
        deque[front] = null;
        front++;

        if (front == length) {
            front = 0;
        }

        resizeQueueAtRemoval();

        return dequeued;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        rear--;

        if (rear == -1) {
            rear = length - 1;
        }

        T dequeued = deque[rear];
        deque[rear] = null;

        resizeQueueAtRemoval();

        return dequeued;
    }

    private void resizeQueue(int newLength) {
        if (newLength >= 2) {
            length = newLength;
        }

        length = newLength;

        T[] newDeque = (T[]) new Object[length];

        int filled = 0;
        for (int i = front; i < deque.length; i++) {
            newDeque[filled] = deque[i];
            filled++;
        }

        for (int i = 0; i < rear; i++) {
            newDeque[filled] = deque[i];
            filled++;
        }

        front = 0;
        rear = filled;
        deque = newDeque;
    }

    private void resizeQueueAtRemoval() {
        if (rear - front > 0 && (rear - front) * 4 == length) {
            length /= 2;
            T[] newDeque = (T[]) new Object[length];

            int filled = 0;
            for (int i = front; i < rear; i++) {
                newDeque[filled] = deque[i];
                filled++;
            }

            front = 0;
            rear = filled;
            deque = newDeque;
        }

        if (front - rear > 0 && (length - front + rear) * 4 == length) {
            resizeQueue(length / 2);
        }
    }

    public boolean isEmpty() {
        return front == rear && deque[front] == null;
    }
}
