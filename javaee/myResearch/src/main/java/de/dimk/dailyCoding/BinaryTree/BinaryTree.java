package de.dimk.dailyCoding.BinaryTree;

public class BinaryTree {

    public Node getRootNode() {
        return root;
    }

    public void setRootNode(Node root) {
        this.root = root;
    }

    public Node root;

    public BinaryTree(int data) {
        root = new Node(data);
    }

    public void add(Node parent, Node child, String orientation) {
        if(orientation.equals("left")){
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
        parent.setParent(parent);
    }
}

