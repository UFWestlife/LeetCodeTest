package Queue;

public class Queue {
    private int maxSize;//数组大小
    private long[] queArray;
    private int front;//队头
    private int rear;//队尾
    private int nItems;//数据项个数

    //create Queue
    public Queue(int s){
        maxSize = s;
        queArray = new long[s];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //insert Queue
    public void insert(long j){
        if(rear == maxSize-1)//循环
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    //remove Queue
    public long remove(){
        long temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;

        return temp;
    }

    public long peedFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public int ItemSize(){
        return nItems;
    }
}
