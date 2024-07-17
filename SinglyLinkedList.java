

public class SinglyLinkedList<E> {
//Data fields Singly Linked List implemntation
//need a head and a tail to make easier to access elements//
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public SinglyLinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  
  public int size(){
    return this.size;
  }
  public boolean isEmpty() {
    return this.size == 0; 
  }

public void set(int index, E element) {
  if (index < 0 || index >= this.size) {
    throw new IndexOutOfBoundsException();
  }
  Node<E> current = this.head;
  for (int i = 0; i < index; i++) {
    current = current.next;
  }
  current.data = element;
}
  public void add(int index, E element) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> newNode = new Node<>(element);
    if (index == 0) {
      newNode.next = this.head;
      this.head = newNode;
      if (this.tail == null) {
        this.tail = newNode;
      }
    } else {
      Node<E> current = this.head;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
      if (newNode.next == null) {
        this.tail = newNode;
      }
    }
    this.size++;
  }

public E first() {
  if (this.isEmpty()) {
    return null; 
  }
  return this.head.getData(); //this.head is node1, but we want to get data from node1, so we use getData() to obtain the data in node1. 
}
public E last(){
  if(this.isEmpty()) {
    return null;
  }
  return this.tail.getData();
}

//add elements

public void addFirst(E dataItem) {
//creates a new node containg the data and referencing the "next" node- new node and head pointing at same
  Node<E> newNode = new Node<>(dataItem, this.head); //this.head --> node 1
  this.head = newNode;
  if(size ==0){
    this.tail = newNode;
  }
  this.size++;
  System.out.println("Added head node with '" + this.head.getData() + "' data");
  
}
public void addLast(E dataItem) {
  Node<E> newNode = new Node<>(dataItem, null);
  if(this.isEmpty()) {
    this.head = newNode;
  }
  else{
    this.tail.setNext(newNode); //this tail -> node3 next is the new node
}
  this.tail = newNode;
  this.size++;
  System.out.println("Added tail node with '" + this.tail.getData() + "' data");
}

public E removeFirst() {
  if(this.isEmpty()) {
    return null;
  }
  E answer = this.head.getData(); //first element of head
  this.head = this.head.getNext(); //head should point to the next elememt
  this.size--;
  if(size == 0){
    this.tail = null;
  }
  System.out.println("Removed head node with '" + answer + "' data");
  return answer; //when we remove we want to return 
}

public boolean remove(Object obj){
  //list interface removes an object, not an element, so we mimic.
  if(obj ==null) {
    return false;
  }
  Node<E> temp = head;
  //move through every single node to see if current element matches the object we want to remove.
  for(int i = 0; i < size; i++) {
    if(obj.equals(temp.data)) {
      deleteNode(temp);
      return true;
    }
    temp = temp.next; //moves temp to next element
  }
  return false;
}

public void deleteNode(Node<E> removeNode){
  Node<E> nextNode = removeNode.next;
  Node<E> temp = head; //head itereates through SLL
  while(temp.next != null) { // as long as the node is not null, it moves to the next node
    if(temp.next.data.equals(removeNode.data)) {
  //does my tempNextdata equal what we want to remove?.. want to find the one right before
      E removeNodeData = removeNode.data;
      temp.next = nextNode; //temp.next = temp.next.next works too 
      removeNode.next = null; 
    } else {
      temp = temp.next;
    }
    
  }
  
}

public String toString(){
  Node<E> temp = head;
  String values = "";
  while(temp!= null) {
    values = values + "\n" + temp.data;
    temp = temp.next;
  }
  return values;
  }

public void clear() {
  this.head = null;
  this.tail = null;
  this.size = 0;
}


public E get(int index) {
  Node<E> temp = head;
  if(size <= 0 || index >= size) {
    throw new IndexOutOfBoundsException();
  }
  for (int i =0; i< index; i++) {
    temp = temp.next;
  }
  return temp.data;
}

  
 ////////implement the node - class in a class/////////////////
  private static class Node<E> {
    private E data;
    private Node<E> next; //--> finding a small location in   memory that referneces next element "little chunks of memory"

/* creates a new new node with node with null in the next field.
    @param dataItem -- the data stored 
    
  store data item into node to reference another node "null" */
    
  
    private Node(E dataItem) {
      this.data = dataItem;
      next = null;
    }

    /* creates a new node that regerences another node
        @param datItem -- the data stored
        @param nodeRef -- the node referenced by new node 
    
store data into E generic, the nodeRef references location of next node --> reference another node NOT null
    */
    
    private Node(E dataItem, Node<E> nodeRef) {
      this.data = dataItem;
      this.next = nodeRef; 
    }
  //getters 
  public E getData(){
    return this.data;
  }
  public Node<E> getNext(){
    return this.next; //next is a type node E
  }
  //setters
  public void setData(E dataItem) {
    this.data = dataItem;
}
  public void setNext(Node<E> nodeRef) {
    this.next = nodeRef;
  }
  }
  }
