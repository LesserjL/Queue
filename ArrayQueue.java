
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
    for(int i = 0; i < log.length; i++){
        if(log[i] != null){
            return log[i];
     
        }
    }
    return null;
    }
    public T remove() throws QueueUnderflowException{
        int index = 0;
        if (size == 0 || log == null) {
        throw new QueueUnderflowException();
        }
        else{
        for(int i = 0; i < log.length; i++){
        if(log[i] != null){
            index = i;
     
        }
    }
        T removedElement = log[index];
        log[index] = null;
        size--;
        return removedElement;
        }
}
    public boolean isFull()
    {
        return size == log.length;
    }
    public T add(T item){
        if (isFull()) {
        // Double the array size if it's full
        T[] log2 = (T[]) new Object[log.length * 2];
        System.arraycopy(log, 0, log2, 0, log.length);
        log = log2;
    }
    log[size++] = item;
    return item;
    }
    public void clear(){
        log = null;
        size =0;
    }
    public int search(Object o){
        for(int i = size-1; i >= 0; i--){
            if(log[i].equals(o)){
                return size - i;
            }
        }
        return -1;
    }
}
