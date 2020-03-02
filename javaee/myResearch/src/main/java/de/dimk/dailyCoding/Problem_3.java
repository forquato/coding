package de.dimk.dailyCoding;

import de.dimk.dailyCoding.BinaryTree.BinaryTree;
import de.dimk.dailyCoding.BinaryTree.Node;


/*
Good morning! Here's your coding interview problem for today.
        This problem was asked by Google.
        Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
*/



// see https://stackoverflow.com/questions/20731833/constructing-a-binary-tree-in-java
// https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/

public class Problem_3 {


    static String marker = "%";
    private static String ser = "";
    private static Node root_ = null;

    public static void main(String[] args) {

        // define Nodes
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(2);
        Node n4 = new Node(5);


        // define tree
        BinaryTree tree = new BinaryTree(3);
        Node root = tree.getRootNode();         //             3
        tree.add(root, n1, "left");   //             / \
        tree.add(root, n2, "right");  //            1   4
        tree.add(n2, n3, "left");     //               / \
        tree.add(n2, n4, "right");    //              2   5


        serialize(root);


        System.out.println(tree.getRootNode().getRight().getKey());
        System.out.println(ser);



        System.out.println(ser.split(" ")[1]);

        deserialize(root_,ser.split(" "),0);

        //deserialize(root_, ser.split(" "));



    }


    private static void serialize(Node root){
        if(root == null){
            ser += marker + " ";
            return;
        }
        ser += root.getKey() + " ";
        serialize(root.getLeft());
        serialize(root.getRight());
    }

    //todo: no suitable deserialization...
    //todo: read https://gist.github.com/BiruLyu/8d314ef55539176646476da3c7d3309c
    private static void deserialize(Node root,String[] split,int place){


        if(!split[place].equals("%")) {
            if(place > 0 && split[place-1].equals("%")){
                Node tmp = newNode(Integer.valueOf(split[place]));
                tmp.setParent(root);
                System.out.println(tmp.getKey());
                root.setRight(tmp);
                root = root.getRight();
            }
            else {
                if(root != null){
                    Node tmp = newNode(Integer.valueOf(split[place]));
                    tmp.setParent(root);
                    root.setLeft(tmp);
                    root = root.getLeft();
                } else {
                    Node newNode = newNode(Integer.valueOf(split[place]));
                    newNode.setParent(root);
                    root = newNode;
                }
            }

            if(split[place].equals("%")){
                root = root.getParent();
                place++;
            }

        }

        deserialize(root,split,place+1);
    }

    private static Node newNode(int key){
        Node temp = new Node(key);
        return temp;
    }

}
