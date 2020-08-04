import java.util.Arrays;

public class GenericMethods implements GenericMethodsInterface{


    public <AnyType extends Comparable<AnyType>> int linearSearch(AnyType[] a, AnyType x){
        for (int i = 0; i< a.length; i++){
            if(a[i].compareTo(x)==0){
                return i;
            }
        }
        return -1;
    }
    
    public <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){
        Arrays.sort(a);
        int i  = a.length/2; 
        
//         for (int b = 0; b<a.length; b++){
//             System.out.print(a[b]+"\n");
//         }
        
        return binaryHelper(a, x, i);
    }
    
    private <AnyType extends Comparable<AnyType>> int binaryHelper (AnyType[] a, AnyType x, int i){
        if (i>-1 && i<a.length){
            if (x.compareTo (a[i]) == 0 )
                return i;
            else if(x.compareTo(a[i])> 0){
                return binaryHelper(a,x, i+1);
            }
            else if(x.compareTo(a[i])< 0){
                return binaryHelper(a,x, i-1);
            }
        }
        
        return -1;
    }
    
}