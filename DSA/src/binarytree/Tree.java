package binarytree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author stoilov
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public Tree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T element) {
        if (element == null) {
            return;
        }

        if (isEmpty()) {
            root = new TreeNode<>(element);
        } else {
            root.insertObj(element);
        }
    }

    public int depth() {
        if (isEmpty()) {
            return 0;
        }

        return depth(root);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        return 1 + ((leftDepth > rightDepth) ? leftDepth : rightDepth);
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        return size(root);
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + size(node.left) + size(node.right);
    }

    public void writeTree(String filename) {
        if (filename == null || isEmpty()) {
            return;
        }

        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename))) {
            writeTree(root, stream);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void writeTree(TreeNode node, ObjectOutputStream stream) throws IOException {
        if (stream == null || node == null) {
            return;
        }

        writeTree(node.left, stream);
        stream.writeObject(node.getData());
        writeTree(node.right, stream);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        buildString(node.left, sb);
        sb.append(node.getData()).append(" ");
        buildString(node.right, sb);
    }

}
