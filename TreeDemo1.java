import java.lang.*;
import java.util.*;
public class TreeDemo1{

   static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left= right = null;
        }
    }

    static class BinaryTree{

        static int idx = -1;
        public Node create(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = create(nodes);
            newNode.right = create(nodes);
            return newNode;

        }

        public void preOrder(Node root){
            if(root==null){
                return;
            }
            
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);

        }

        public void inOrder(Node root){
            if(root==null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);

        }

        public void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");

        }
        public void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                
                Node currNode = q.poll();
                if(currNode==null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(currNode);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                    
                   

                }
            }


        }

        public int countOfNode(Node root){
            if(root==null){
                return 0;
            }
            int left = countOfNode(root.left);
            int right = countOfNode(root.right);

            return left+right+1;

        }
        public int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int left = sumOfNodes(root.left);
            int right = sumOfNodes(root.right);

            return left+right+root.data;

        }

        public int heightOfTree(Node root ){
            if(root==null){
                return 0;
            }
            int leftheight = heightOfTree(root.left);
            int rightheight = heightOfTree(root.right);
            if(leftheight>rightheight){
                return leftheight+1;
            }
            else{
                return rightheight+1;
            }
        }


        public int diameter(Node root){
            
            if(root==null){
                return 0;
            }

            int dia1 = diameter(root.left);
            int dia2 = diameter(root.right);
            int dia3 = heightOfTree(root.left)+heightOfTree(root.right)+1;

            return Math.max(dia3,Math.max(dia1,dia2));


        }

        static class TreeInfo{
            int height;
            int diameter;
            TreeInfo(int height,int diameter){
                this.height = height;
                this.diameter = diameter;
            }
        }

        public static TreeInfo diameter2(Node root){

            if(root==null){
                return new TreeInfo(0,0);
            }

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int myHeight = Math.max(left.height,right.height)+1;

            int diameter1 = left.diameter;
            int diameter2 = right.diameter;
            int diameter3 = left.height + right.height+1;

            int myDia = Math.max(diameter3,Math.max(diameter1,diameter2));

            TreeInfo myInfo = new TreeInfo(myHeight,myDia);
            return myInfo;




        }




    }

    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.create(nodes);
        System.out.println("Root "+root.data);
        System.out.println("PREORDER TRAVERSAL ");
        tree.preOrder(root);
        System.out.println("");
        System.out.println("INORDER TRAVERSAL ");
        tree.inOrder(root);
        System.out.println("");
        System.out.println("POSTORDER TRAVERSAL ");
        tree.postOrder(root);
        System.out.println(" ");
        System.out.println(tree.countOfNode(root));
        System.out.println(" Sum of Nodes ");
        System.out.println(tree.sumOfNodes(root));
        System.out.println("Height of tree ");
        System.out.println(tree.heightOfTree(root));
        // diameter calculation time complexity o(n^2)
        System.out.println("Diameter of a tree ");
        System.out.println(tree.diameter(root));

        // diameter calculation but time complexity is o(n)
        System.out.println(tree.diameter2(root).diameter);


    }


}