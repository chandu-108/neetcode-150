class MyCircularQueue {
    private int deq[];
    private int rear;
    private int front;
    private int currcnt;
    private int K;
    public MyCircularQueue(int k) {
        K=k;
        deq=new int[k];
        rear=k-1;
        front=0;
        currcnt=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear=(rear+1)%K;
        deq[rear]=value;
        currcnt++;

        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front=(front+1)%K;
        currcnt--;

        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return deq[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return deq[rear];
    }
    
    public boolean isEmpty() {
        return currcnt==0;
    }
    
    public boolean isFull() {
       return currcnt==K; 
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */