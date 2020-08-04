public class MyStack <T> implements MyStackInterface<T> {
    private T stack[];
    private int theSize;
    
    MyStack(){
        stack = (T[]) new Object [10];//0bject type array and casting to generic
        theSize = 0;
    }
    
    public void push(T x){//pushing item at the top
        if(stack.length-1 == size() ){
            reSize( size()*2 +1);
        }
        stack[theSize++] = x;
    }
	
    public T pop(){//popping top
        if (isEmpty()){
            return null;
        }
        return stack[--theSize];
    }
	
    public T peek(){
        if (isEmpty()){
            return null;
        }
        return stack[size()-1];
    }
    
//     public T peekBottom(){
//         return stack[0];
//     }
	
    public boolean isEmpty(){
        return (size() == 0);// returns true if stack size is 0
    }
	
    public int size(){
        return theSize;
    }
    
    @SuppressWarnings("unchecked")
    public void reSize(int newSize){
        if (newSize < theSize){
            return;
        }
        
        T [] temp = (T[]) new Object [theSize];
        for (int i = 0; i < size(); i++){
           temp[i] = stack[i];
        }
        
        stack = (T[]) new Object [newSize];
        
        for (int i = 0; i < size(); i++){
            stack [i] = temp[i];
        }
    }
    
    public String toString(){
        String output="";
        for (int i = 0; i<size(); i++){
            output += ""+stack[i]+", ";
        }
        return output;
    }
   
}