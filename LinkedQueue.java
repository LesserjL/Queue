
/**
 * Write a description of class LinkedQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedQueue<T>
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
        size = 0;
        log = null;
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
        LLNode<T> currIndex = log;
        int count = 0;
        while (count < size - 1) {
            if(currIndex.getInfo() != null){
                return currIndex.getInfo();
            }
            currIndex = currIndex.getLink();
            count++;
        }
        return currIndex.getInfo();   
    }
    public T add(T item){
        LLNode<T> newNode = new LLNode<>(item);
    if (log == null) {
        log = newNode;
    } else {
        LLNode<T> currIndex = log;
        while (currIndex.getLink() != null) {
            currIndex = currIndex.getLink();
        }
        currIndex.setLink(newNode);
        back = currIndex.getLink();
    }
    size++;
    return item;
    }
    public void remove() throws QueueUnderflowException{
        if(log == null || size == 0){
            throw new QueueUnderflowException();
        }
        LLNode<T> currIndex = log;
        while(true){
            if(currIndex.getLink() != null){
                front = currIndex.getLink();
            }
            else{
                continue;
            }
        }
    }
    public void clear(){
        log = null;
        size =0;
    }
}
