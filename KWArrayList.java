


public class KWArrayList<E> {
  private static final int INITIAL_CAPACITY = 10;
  private E[] theData;
  private int size;
  private int capacity= 0;

  public KWArrayList() {
    capacity = INITIAL_CAPACITY;
    theData = (E[]) new Object[capacity];
    size = 0;
    
  }
  public boolean add(E s) {
    if(size == capacity) {
       reallocate();
    }
    theData[size] = s;
    size++;
    return true;
  }
  public void add(int index, E element){
    if(index < 0 || index > size) {
      System.out.println("Out of range");
    } else {
        if (size == capacity) {
          reallocate();
        }
      this.size++;
      for(int i = size-1; i >= index; i--) {
        this.theData[i+1] = this.theData[i];
      }
      this.theData[index] = element;
        }
  }

  public E remove(int index) {
    if(index < 0 || index >= size) {
      System.out.print("System out of range");
      return null;
    } else{
      E element = theData[index]; //saves this first
      for(int i= index; i <size-1; i++) {
        theData[i] = theData[i+1]; 
        }
      
      //theData[size] = null; //not required
      size--;
      return element;
      
    }
  }

  public void reallocate() {
    this.capacity = this.capacity*2;
    E[] newData = (E[]) new Object[this.capacity];
    for(int i = 0; i < size; i++) {
      newData[i] = theData[i];
    }
    this.theData = newData;
  }

  public String toString(){
    String s = "[";
    for (int i = 0; i < size; i++) {
      s = s+ theData[i];
      if (i != size-1) {
        s =  s+ ", ";
      }
    }
    s+= "]";
    return s;
  }
}