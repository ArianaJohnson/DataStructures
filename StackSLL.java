
//adappter class lets us delegate method implementation

//adapted other methods to adapt this struture 

import java.util.LinkedList;
public class StackSLL<E> implements StackInterface<E> {

  private SinglyLinkedList<E> list;

  //defualt constructor
  public StackSLL() {
    list = new  SinglyLinkedList<E>();
  }
  //all elements of stack is in a linkedlist (different than whats in the main!)

  
  //adds element to the top of the stack
  public E push(E item) {
    list.addFirst(item);
    return item;
    
  }

  //remove and return element from the top of the stack
  public E pop() {
    return list.removeFirst();
    
  }

  //return element from the top of the stack
  public E peek() {
    return list.get(0);
  }

  //return true if the stack is empty, false otherwise
  public boolean isEmpty() {
    return list.size() == 0;

  }
public String toString() {
  return list.toString();
}

  
}