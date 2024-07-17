public class KWArrayListString{

  private String[] array;
  private int size;
  private int capacity;

  public KWArrayListString() {
    array = new String[10];
    size = 0;
    capacity = 10;
  }
  public void add(String s) {
    array[size] = s;
    size++;
  }
  public String toString(){
    String s = "[";
    for (int i = 0; i < size; i++) {
      s = s+ array[i];
      if (i != size-1) {
        s =  s+ ", ";
      }
    }
    s+= "]";
    return s;
  }
}