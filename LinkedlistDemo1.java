import java.lang.*;
import java.util.*;
public class LinkedlistDemo1 {

     class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
     }

     Node head=null;
     Node tail=null;

     public void insert(int data){
            Node newNode = new Node(data);
            if(head==null){
                head=tail=newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }

     }
     public void display(){
        Node temp = head;
        if(head==null){
            System.out.println(" List is Empty ");

        }
        else{
            while(temp!=null){
                System.out.print(temp.data+ " ");
                temp= temp.next;
            }
        }
     }




    public static void main(String args[]){
        System.out.println(" Linked List Implementation ");
        LinkedlistDemo1 demo = new LinkedlistDemo1();
        demo.display();
        demo.insert(2);
        demo.insert(4);
        demo.insert(6);
        demo.insert(1);
        demo.display();

    }
    
}
