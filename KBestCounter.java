import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
    private PriorityQueue<T> best;
    private int k;
    
    KBestCounter(int k){
        this.k=k;
        best = new PriorityQueue<>(k);
    }
    
    public void count(T x){//O(log k ) ==> cut work in half each time
        //process the next element
        //add it no matter what
        best.add(x);
        if(best.size()>k){//if larger than k pop off the smallest value
            best.poll();
        }
    }
	
    public List<T> kbest(){
        List bestList = new ArrayList(best);
        Collections.sort(bestList);
        return bestList;
    }
}