
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>{
//Data Fields
  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;

  public void add(int index, E element) {
    listIterator(index).add(element);
  }
  public void addFirst(E element) {
    add(0,element);
  }
  public void addLast(E element) {
    add(size, element);
  }

  public E getFirst() {
    return head.data;
  }

 
  public E getLast() {
    return tail.data;
  }
  
  public int size() {
    return size;
  }

  public E get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    ListIterator<E> iter = listIterator(index);
    return iter.next();
  }

  public E remove(int index) {
    E returnValue = null;
    ListIterator<E> iter = listIterator(index); // -> new obhect ListIter(index)
    if(iter.hasNext()) {
      returnValue = iter.next();
      iter.remove();
    } else {
      throw new IndexOutOfBoundsException();
    }
    return returnValue;
    }
  

  
  public Iterator<E> iterator(){
    return new ListIter(0); //returns iterator at index0
  }

  public ListIterator<E> listIterator(){
    return new ListIter(0); //returns iterator at index0
  }

  public ListIterator<E> listIterator(int index) {
    return new ListIter(index);
  }

  public ListIterator<E> listIterator(ListIterator iter) { //copy constructor, passing iter that is a type listiter
    return new ListIter((ListIter) iter);
  }
////// some inner class node /////
  private static class Node<E> {
  //I do not know yet the data, so keep generic - data fields
    private E data;
    private Node<E> next= null ; 
    private Node<E> prev = null;

  // Constructor
  private Node(E dataItem) {
    data = dataItem; //this builds a node that points to null

  }
  }

////////////// inner class ListIter ////////////
// so we can move through our list
  public class ListIter implements ListIterator<E> {
    private Node<E> nextItem;
    private Node <E> lastItemReturned;
    private int index = 0;

  public ListIter(int i) { //our i can start anywhere (including null)
    if (i < 0 || i > size) {
      throw new IndexOutOfBoundsException("Invalid index" + i);
    }
    //rule is the last item returned should always equal null
    lastItemReturned = null; 
    if(i == size) {
      index = size;
      nextItem = null;
    } else {
      nextItem = head;
      for(index = 0; index < i; index++) { //keeps moving 
        nextItem = nextItem.next; 
        
        
      }
    }
  }
// copy constructor
  public ListIter(ListIter other) {
    nextItem = other.nextItem;
    index = other.index;
  }

  public boolean hasNext() {
  //returns true as long as index is less than size (reffering to )
   return index < size; 
}
  public boolean hasPrevious() {
    return index > 0; //element availible to return
  }
  public int previousIndex() {
    return index - 1;
  }
  public int nextIndex() {
    return index;
  }
  public int getIndex() {
    return index;
  }
  // to call the set method we need to first call next or prev== then we can have a lastItemReturned
  public void set(E e) throws IllegalStateException {
    if(lastItemReturned == null) {
      throw new IllegalStateException(); //nothing availble
    } else {
      lastItemReturned.data = e;
    }
   
  }
  //to call method, we first must call next() or prev() so there is a lastItemReturned other than null
  public void remove() throws IllegalStateException {
    if(lastItemReturned == null) {
      throw new IllegalStateException();
    } else {
      //case with one elemet on list
      if(size ==1) {
        head = null;
        tail = null;
        nextItem = null;
      } else if(lastItemReturned == head) { // last ItemReturned is on the head
        head = lastItemReturned.next; 
        head.prev = null;
      } else if(lastItemReturned == tail) { //last iteme returned is on the tail
        tail = lastItemReturned.prev;
        lastItemReturned.prev.next = null;
      } else { //somewhere in the middle
        lastItemReturned.prev.next = lastItemReturned.next;
        lastItemReturned.next.prev = lastItemReturned.prev;
        
      }
    
    lastItemReturned = null;
    index --;
    size --;
    }
    
  }
 

  public E next() throws NoSuchElementException {
    if(!hasNext()) {
      throw new NoSuchElementException();
    }
    E nextElement = nextItem.data;
    lastItemReturned = nextItem;
    nextItem = nextItem.next;
    index++;
    return nextElement;
  }
  public E previous() throws NoSuchElementException {
    if(!hasPrevious()) {
      throw new NoSuchElementException();
    }
    // check we are in the end and want to return right before
    if(nextItem ==null) {
      nextItem = tail;
    } else {
      nextItem = nextItem.prev; //shifts next item 
    }
    //last item returned
    lastItemReturned = nextItem;
    index--;
    return lastItemReturned.data;
    }
  
    
    
  public void add(E e) {
  //we know where we are in the list
    Node newNode = new Node(e); //new object of type node
    if(head == null) {
      head = newNode;
      tail = head;
      nextItem = head;
    } else if (nextItem == head) {
      nextItem.prev = newNode;
      newNode.next = nextItem;
      head = newNode;
    } else if (nextItem == null) {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    } else {
      newNode.next = nextItem;
      newNode.prev = nextItem.prev;
      nextItem.prev.next = newNode;
      nextItem.prev = newNode;
      
    }

    lastItemReturned = null;
    size ++;
    index++;
  }
  
    public E getLastItemReturned() {
        if (lastItemReturned != null) {
            return lastItemReturned.data;
        }
        return null;
    }
    
    
  
} 
}