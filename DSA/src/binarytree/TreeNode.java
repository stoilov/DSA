package binarytree;

/**
 *
 * @author stoilov
 * @param <T>
 */
public class TreeNode<T extends Comparable<T>> {

    TreeNode<T> left;
    private T data;
    TreeNode<T> right;

    public TreeNode(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void insertObj(T element) {
        if (element == null || element.compareTo(data) == 0) {
            return;
        }

        if (element.compareTo(data) < 0) {
            if (left == null) {
                left = new TreeNode(element);
            } else {
                left.insertObj(element);
            }
        } else {
            if (right == null) {
                right = new TreeNode(element);
            } else {
                right.insertObj(element);
            }
        }
    }

}
