public class TwoStackQueue <T> implements TwoStackQueueInterface<T> {
    private MyStack s1;
	private MyStack s2;
    //private MyStack tempS;
    
    TwoStackQueue(){
        this.s1 = new MyStack ();
        this.s2 = new MyStack ();
        //this.tempS = new MyStack(10);
    }
	
    public void enqueue(T x){
        s1.push(x);
        //tempS.push(x);
    }
	
    public T dequeue(){
        int temp = s1.size();
        for (int i = 0; i< temp;i++){
            s2.push(s1.pop());
        }
        return (T)s2.pop();
    }
	
    public int size(){
        return s1.size() + s2.size();
    }
	
    public boolean isEmpty(){
        return s1.isEmpty() & s2.isEmpty();
    }	
    
    public String toString(){
        //System.out.println("temp: "+ tempS);
        return "s1: " + s1+ "\ns2: "+ s2;
    }
}
