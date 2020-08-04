public class Problem3{
    public static void main (String[] args){
        BigO bigO = new BigO();
        long startTime = 0;
        long endTime = 0;
        
        for (int i = 1 ; i< 30; i*=3){
            System.out.println ("i: "+i);
                startTime= System.nanoTime();
                bigO.cubic(i);
                endTime = System.nanoTime();
            System.out.println("Cubic \nTime Diff: " + (endTime -startTime));

            System.out.println ("~~~~~");
                startTime = System.nanoTime();
                bigO.exp(i);
                endTime = System.nanoTime();
            System.out.println("Exponent \nTime Diff: " + (endTime -startTime) );

            System.out.println ("~~~~~");
                startTime = System.nanoTime();
                bigO.constant(i);
                endTime = System.nanoTime();
            System.out.println("Constant \nTime Diff: " + (endTime -startTime));
        }
    }
}