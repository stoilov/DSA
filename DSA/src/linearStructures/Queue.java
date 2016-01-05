package linearStructures;

/**
 *
 * @author stoilov
 * @param <T>
 */
public class Queue<T> {

    private int front;
    private int rear;
    private int length;
    private T[] queue;

    public Queue() {
        length = 2;
        queue = (T[]) new Object[length];
        front = rear = 0;
    }

    public void enqueue(T element) {
        if (element == null) {
            return;
        }
        
        queue[rear++] = element;

        if (rear == length) {
            rear = 0;
        }

        if (rear == front) {
            resizeQueue(length * 2);
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T dequeued = queue[front];
        queue[front] = null;
        front++;

        if (front == length) {
            front = 0;
        }

        if (rear - front > 0 && (rear - front) * 4 == length) {
            length /= 2;
            T[] newQueue = (T[]) new Object[length];

            int filled = 0;
            for (int i = front; i < rear; i++) {
                newQueue[filled] = queue[i];
                filled++;
            }

            front = 0;
            rear = filled;
            queue = newQueue;
        }

        if (front - rear > 0 && (length - front + rear) * 4 == length) {
            resizeQueue(length / 2);
        }

        return dequeued;
    }

    private void resizeQueue(int newLength) {
        if (newLength >= 2) {
            length = newLength;
        }
        
        length = newLength;
        
        T[] newQueue = (T[]) new Object[length];

        int filled = 0;
        for (int i = front; i < queue.length; i++) {
            newQueue[filled] = queue[i];
            filled++;
        }

        for (int i = 0; i < rear; i++) {
            newQueue[filled] = queue[i];
            filled++;
        }

        front = 0;
        rear = filled;
        queue = newQueue;
    }
    
    public T peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return front == rear && queue[front] == null;
    }

}
