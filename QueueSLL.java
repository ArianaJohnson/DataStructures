import java.util.Queue;

public class QueueSLL<E> implements QueueInterface<E> {
  private SinglyLinkedList<E> list;

  //tail front, head rear
  public QueueSLL() {
    list = new SinglyLinkedList<E>();
  }
  //add to rear of q illegalStateException thrown if no space return true if element is added and false if not
  public boolean add(E item) {
    list.addLast(item);
    return true;
}

  //add an element to teh rear without capacirty violation
  public boolean offer(E item) {
    list.addLast(item);
    return true;
  }

  //remove and return element at front of the q
  public E remove() {
    return list.removeFirst();
  
  }
  //removes the front of this queue, or returns null if this queue is empty
  public E poll() {
    return list.removeFirst();
  }

// return the element at the front of the q
  public E peek() {
    return list.get(0);
  }

  //return the element at the front with nu;l if empty
  public E element() {
    return list.get(0);
  }

  public String toString() {
    return list.toString();
  }
  
}