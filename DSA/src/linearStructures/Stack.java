package linearStructures;

/**
 *
 * @author stoilov
 * @param <T>
 */
public class Stack<T> {

    private int length;
    private T[] stack;
    private int current;

    public Stack() {
        current = 0;
        length = 2;
        stack = (T[]) new Object[length];
    }

    public void push(T element) {
        if (element == null) {
            return;
        }

        if (current == length - 1) {
            length *= 2;

            T[] newStack = (T[]) new Object[length];

            System.arraycopy(stack, 0, newStack, 0, stack.length);

            stack = newStack;
        }

        stack[current++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T popped = stack[--current];
        stack[current] = null;

        if (length == (current + 1) * 4) {
            length /= 2;
            T[] newStack = (T[]) new Object[length];

            System.arraycopy(stack, 0, newStack, 0, current);

            stack = newStack;
        }

        return popped;
    }
    
    public T top() {
        if (isEmpty()) {
            return null;
        }
        
        return stack[current];
    }

    public boolean isEmpty() {
        return current == 0;
    }

}
