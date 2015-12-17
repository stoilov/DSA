package squirrels;

// I am using the example implementation of Binary Tree in order to help
// my roommate solve some problem including squirrels.

// Fig. 17.17: Tree.java
// Definition of class TreeNode and class Tree.
// class TreeNode definition
class TreeNode {

    // package access members
    TreeNode leftNode; // left node  
    String data; // node value
    TreeNode rightNode; // right node

    // constructor initializes data and makes this a leaf node
    public TreeNode(String nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    } // end TreeNode constructor

    // locate insertion point and insert new node; ignore duplicate values
    public void insert(String insertValue) {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null) {
                leftNode = new TreeNode(insertValue);
            } else // continue traversing left subtree
            {
                leftNode.insert(insertValue);
            }

        } // end if
        else if (insertValue.compareTo(data) > 0) // insert in right subtree
        {
            // insert new TreeNode
            if (rightNode == null) {
                rightNode = new TreeNode(insertValue);
            } else // continue traversing right subtree
            {
                rightNode.insert(insertValue);
            }
        } // end else if
    } // end method insert
} // end class TreeNode

// class Tree definition
public class Tree {

    private TreeNode root;

    // constructor initializes an empty Tree of integers
    public Tree() {
        root = null;
    } // end Tree no-argument constructor

    // insert a new node in the binary search tree
    public void insertNode(String insertValue) {
        if (root == null) {
            root = new TreeNode(insertValue); // create the root node here
        } else {
            root.insert(insertValue); // call the insert method
        }
    } // end method insertNode
    
    public void inorderSearch(String query) {
        inorderSearch(root, query);
    }
    
    public void inorderSearch(TreeNode node, String query) {
        if (node == null) {
            return;
        }
        
        inorderSearch(node.leftNode, query);
        
        if (node.data.startsWith(query)) {
            System.out.println(node.data);
        }
        
        inorderSearch(node.rightNode, query);
    }

    // begin inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
    } // end method inorderTraversal

    // recursive method to perform inorder traversal
    private void inorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.leftNode);        // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode);       // traverse right subtree
    } // end method inorderHelper
} // end class Tree

/**
 * ************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 * ***********************************************************************
 */
