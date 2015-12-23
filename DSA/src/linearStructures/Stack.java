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

            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }

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

            for (int i = 0; i < current; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
        }

        return popped;
    }

    public boolean isEmpty() {
        return current == 0;
    }

}
