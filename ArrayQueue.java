
/**
 * Write a description of class ArrayStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    private int size;
    private T[] log;
    private int front = 0;
    private int back = 0;
    /**
     * Constructor for objects of class ArrayStack
     */
    public ArrayQueue()
    {
        size = 0;
        log = (T[]) new Object[4];
    }
    // Returns the logical size of this StringLog.
    public int size()
    {
        return size;
    }
    
    // Returns true if this list contains no elements.
    public boolean empty()
    {
        return size == 0;
    }
    
    public T peek() throws QueueUnderflowException {
    if (size == 0 || log == null) {
        throw new QueueUnderflowException();
    }
    return log[front];
    }
    public T remove() throws QueueUnderflowException{
        if (size == 0 || log == null) {
        throw new QueueUnderflowException();
        }
        T removedElement = log[front];
        log[front] = null;
        size--;
        front = (front+1)%log.length;
        return removedElement;
        }
    public boolean isFull()
    {
        return size == log.length;
    }
    public T add(T item){
        if (isFull()) {
        T[] log2 = (T[]) new Object[log.length * 2];
        for (int i = 0; i < size; i++) {
            log2[i] = log[(front + i) % log.length];
        }
        front = 0;
        back = size;
        log = log2;
    }
    log[back] = item;
    size++;
    back = (back + 1) % log.length;
    return item;
    }
    public void clear(){
        log = null;
        size = 0;
        front = 0;
        back = 0;
    }
}
