import java.lang.*;
import java.util.*;
public class TreeDemo2 {

    //Node 
    class Node{
        int data;
        Node left,right;
        //constructor to create a node 
        Node(int data)
        {
            this.data = data;
            left=right=null;
        }
    }

    // method to create the tree
    public Node createTree(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value ");
        int data = sc.nextInt();
        if(data==-1){
            return null;
        }
        Node newNode = new Node(data);
        System.out.println("Enter the LEFT child "+ newNode.data);
        newNode.left = createTree();
        System.out.println("Enter the RIGHT child"+ newNode.data);
        newNode.right=createTree();
        return newNode;
       
    }

    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }


    public static void main(String args[]){
        System.out.println("*******  BINARY TREE IMPLEMENTATION ********");
        System.out.println("Enter -1 for NULL ");
        TreeDemo2 t = new TreeDemo2();
        Node root =  t.createTree();
        t.inOrder(root);
        


    }
}
