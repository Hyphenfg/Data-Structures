public class BigO implements BigOInterface{
    
    public void cubic(int n){
        int y = 0;
        for (int i = 0; i<(n*n*n); i++){
            y ++;
        }
    }
	
    public void exp(int n){
        int x = 0;
        for (int i = 0; i<n; i++){
           for (int j = 0; j<n; j++){
                x++;
           } 
        }
    }
    
	public void constant(int n){
        boolean even;
        if (n%2 ==0){
            even = true;
        }
        else {
            even = false;
        }
    }
}
