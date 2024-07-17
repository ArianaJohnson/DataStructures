import java.io.Serializable;
import java.util.Scanner;

/**
 * BinaryTree.java:
 *
 * @param <E> data type of the tree.
 **
 * @author
 * @version 1.0
 */
public class BinaryTree<E>  {

    // DATA FIELD //
    protected Node<E> root; //root stores location of the node on top of the tree (all can be accessed due to the left and right child)

    /**
     * Default constructor
     */
    public BinaryTree() { //no parameters -> create empty tree
        this.root = null;
    }

    /**
     * Constructor, assigns the node to the root of the tree.
     *
     * @param root node being assigned to the root.
// IF we have a root, can we copy that binary tree?
    */
    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Tree constructor, builds a tree by adding two existing trees root node to the
     * left and right nodes of a new root node. The root node is created from the data passed
     * to method.
     *
     * @param data to be assigned to the root node.
     * @param leftTree tree being added to left side of the tree.
     * @param rightTree tree being added to the right side of the tree.
     */
    //want to unite the tree and binary tree
        //create a new node ex (node: jeje) -->  bt1.root = left, bt2.root = right
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
    //root pointed to the TOP new node
        this.root = new Node<E>(data);
        //differece in having left tree == null and leftTree.root == null 
        if(leftTree == null) {
            this.root.left = null;
        } else {
            this.root.left = leftTree.root;
        }
         if(rightTree == null) {
             this.root.right = null;
         } else {
             this.root.right = rightTree.root;
         }
    }

    /**
     * Returns the subtree to the left of the root. Returns null if the tree is empty
     * or there is no left subtree.
     *
     * @return the left subtree of the root node.
     */
    public BinaryTree<E> getLeftSubtree() {
        if (this.root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        }
        return null;
        
    }

   

    /**
     * Returns the subtree to the right of the root. Returns null if the tree is empty
     * or there is no right subtree.
     *
     * @return the right subtree if the root node.
     */
     public BinaryTree<E> getRightSubtree() {
         if (this.root != null && root.right != null) {
             return new BinaryTree<E>(root.right);
         }
         return null;
     }


    /**
     * Checks to see if the current node is a leaf.
     *
     * @return boolean if the node is a leaf.
     */

    public boolean isLeaf() {
        //"the local tree"
        return (root.left == null && root.right == null);
    }

    /**
     * Returns the roots node data value.
     *
     * @return data of root node.
     */

    public E getData() {
        return root.data; //pointer is pointed at the root "the local root"
    }

    /**
     * Returns a representation of the tree where each subtree is indented by the number of its depth.
     * Calls preOrderTraverse to recursively traverse the tree.
     *
     * @return String representation of the tree.
     */

    //createe a toString method, takes all the data and displays it in a tree format

    public String toString() {
    //A string is immutable (can not modify ie add or replace or remove any characters in the string)
    //A String builder is MUTABLE --> allows us to make modifications , by adding, removing or            replacing characters to string builder
        StringBuilder sb  =  new StringBuilder();  
        preOrderTransverse(root,1,sb); //recursion method to transverse through tree to extract info and return back into string.
        return sb.toString();
        
    }
    
    /**
     * Recursively traverse the tree and adds to the string.
     *
     * @param node current node in the tree.
     * @param depth depth of the node in the tree.
     * @param sb String representation of the tree.
     */
    //helper method, so we keep private
    //preOrder --> Root, Left, Right 
    private void preOrderTransverse(Node<E> node, int depth, StringBuilder sb) {
      for(int i = 1; i<depth; i++ ) {
          sb.append(" "); //if we are level 2 we just want 1 white space in front, and so on
      }
        if(node == null) {
            sb.append("null\n"); //if node == null, we want to add to sb is null and we go back
        }
        else {
            sb.append(node.toString() + "\n"); //root
            preOrderTransverse(node.left, depth+1, sb); //now we move to the left
            preOrderTransverse(node.right, depth+1, sb);
        }
    }


    /**
     * Reconstructs the tree created by the toString method. Returns a new binary tree
     * constructed by the tree constructor.
     *
     * @param scan scanner used to read a file.
     * @return BinaryTree constructed from the read file.
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan)  {
        String data = scan.next(); //read info from user
        if(data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan); 
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
        
    }




    ///////////////////////// !INNER CLASS NODE! /////////////////////////
    /**
     * Tree node represents data in a binary tree.
     * @param <E> data type of the binary tree.
     */
    protected static class Node<E>  {
        
    //DATA FIELDS:
    protected E data; //can also be private --> accessible by any sub class
    protected Node<E> left; //reference to left node
    protected Node<E> right; //reference to right node

    //CONSTRUCTORS:
    public Node(E data) { //when called, new node is created --> mostly starts at null
        this.data = data;
        this.left = null;
        this.right = null; //we do not need to know what they are yet
    }
    @Override //always want a string representation of the node
    public String toString(){
        return this.data.toString(); //gurentees string return
    }
  }
}
