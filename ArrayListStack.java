


import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayListStack: Stores data using the abstract data type of a stack, utilizing the two main methods for
 * data manipulation push() and pop().
 *
 * @param <E> data type of elements to be stored in the arrayList
 *

 */

public class ArrayListStack<E> implements StackInterface<E> {
    private ArrayList<E> arrayStack;



    /**
     * Default Constructor, initializes an empty arrayList.
         */
    public ArrayListStack() {
        this.arrayStack = new ArrayList<>();
    }

    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     arrayList(can use any method belonging to the class)
     */
    public boolean empty() {
        return arrayStack.isEmpty();
    }


    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     last elementof my arrayStack which is an arraylist data type is on index of the size - 1
     */
    public E peek() {
        if (arrayStack.size() == 0) {
            throw new EmptyStackException();
        }
        int topElement = arrayStack.size() - 1;
        return arrayStack.get(topElement);
        //return arrayListStack.get(arrayListStack.size() - 1);
    }
 
    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    public E pop() { 
        if (arrayStack.size() == 0) {
            throw new EmptyStackException();
        }
        int topElement = arrayStack.size() - 1;
        return arrayStack.remove(topElement);
        //return arrayListStack.remove(arrayListStack.size() - 1);
    }
    
    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    public E push(E obj) {
        arrayStack.add(obj); //add method in javaArrayList
        return obj;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    public int size() {
        return arrayStack.size();
    }
}
