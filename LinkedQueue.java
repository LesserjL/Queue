
/**
 * Write a description of class LinkedQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    // instance variables - replace the example below with your own
    private int size;
    private LLNode<T> log;
    private LLNode<T> front;
    private LLNode<T> back;
    /**
     * Constructor for objects of class LinkedQueue
     */
    public LinkedQueue()
    {
        log = null;
        front = log;
        size = 0;
    }

    public int size()
    {
        return size;
    }
    
    // Returns true if this list contains no elements.
    public boolean empty()
    {
        return size == 0;
    }
     public T peek() throws QueueUnderflowException{
         if (size == 0 || log == null) {
            throw new QueueUnderflowException();
        }
        return log.getInfo();   
    }
    public T add(T item){
        LLNode<T> newNode = new LLNode<>(item);
        if (log == null) {
            log = newNode;
            front = log;
            back = log;
        }
        else{
            back.setLink(newNode);
            back = newNode;
        }
        size++;
        return item;
    }
    public T remove() throws QueueUnderflowException{
        if(size == 0 || log == null){
            throw new QueueUnderflowException();
        }
        else{
            T removedItem = front.getInfo();
            front = front.getLink();
            if(front == null){
                back = null;
            }
            size--;
            return removedItem;
        }
    }
    public void clear(){
        log = null;
        size = 0;
    }
}
