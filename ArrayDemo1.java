import java.lang.*;
import java.util.*;
class ArrayDemo1{
    public static void main(String args[]){
       System.out.println("Array Implementation");
       int arr[] = new int[10];
       Scanner sc = new Scanner(System.in);
       for(int i=0;i<10;i++){
        System.out.println("Enter the element");
        arr[i] = sc.nextInt();

       }
       System.out.println();
       for(int i=0;i<10;i++){
        System.out.print(arr[i]+ " ");
       }
    

    }
}