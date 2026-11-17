
package Chapter4.Deque;


public class Deque<T>{
    private class Node<T>{
        T data;
        Node<T> next;
        Node<T> priv;
            Node(T data){
            this.data=data;
            this.next=null;
            this.priv=null;
        }
        
    }
    private Node<T> front;
    private Node<T> rear;
    private int size;
    public Deque(){
        this.front=null;
        this.rear=null;
        this.size=0;
    }
    public void addFirst(T item){
        Node<T> newNode=new Node<>(item);
        if(isEmpty()){
            front=rear=newNode;
        }else{
            newNode.next=front;
            front.priv=newNode;
            front=newNode;
        }
        size++;
    }
    public void addLast(T item){
        Node<T> newNode=new Node<T>(item);
        if(isEmpty()){
            front=rear=newNode;
        }else{
            newNode.priv=rear;
            rear.next=newNode;
            rear=newNode;
        }
        size++;
    }
    public T removeFrist(){
        if(isEmpty()){
            System.out.println("Deque Is Empty");
            return null;
        }
        T data=front.data; // فحصت البيانات الي في الامام 
         front=front.next;// تقدم خطوة 
         if(front==null){
             rear=null;
         }else{
             front.priv=null;
         }
         size--;
         return data;
    }
    public T removeLast(){
        if(isEmpty()){
            System.out.println("Deque IS Empty..!");
            return null;
        }
        T data= rear.data;
        rear=rear.priv;
        if(rear==null){
            front=null;
        }else{
            rear.next=null;
        }
        size--;
        return data;
    }
    public T peekLast(){
        if(isEmpty()){
            System.out.println("Deque is Empty..!");
            return null;
        }
        return rear.data;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
}
