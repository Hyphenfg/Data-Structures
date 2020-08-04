public class myTester{
    public static void main (String[] args){
         //MyStack s1 = new MyStack(3);
//         s1.push(2);
//         System.out.println("s1: "+ s1);
//         System.out.println("size: " +s1.size());
        
//         s1.push(56);
//         s1.push(39);
//         System.out.println("s1: "+ s1);
//         System.out.println("size: " +s1.size());
        
//         s1.push(4);
//         System.out.println("s1: "+ s1);
//         System.out.println("size: " +s1.size());
        
//         System.out.println("pop: "+s1.pop());
//         System.out.println("pop: "+s1.pop());
//         System.out.println("s1: "+ s1);
//         System.out.println("size: " +s1.size());
        
//         SymbolBalance sb1 = new SymbolBalance();
// //         sb1.setFile("/home/codio/workspace/TestFiles/stupidTest1.java");
// //         System.out.println(sb1.checkFile());
        
//         sb1.setFile("/home/codio/workspace/TestFiles/Test1.java");
//         System.out.println("\ntest1: "+sb1.checkFile());
        
//         SymbolBalance sb2 = new SymbolBalance();
//         sb2.setFile("/home/codio/workspace/TestFiles/Test2.java");
//         System.out.println("\ntest2: "+sb2.checkFile());
        
//         SymbolBalance sb3 = new SymbolBalance();
//         sb3.setFile("/home/codio/workspace/TestFiles/Test3.java");
//         System.out.println("\ntest3: "+sb3.checkFile());
        
        
//         SymbolBalance sb4 = new SymbolBalance();
//         sb4.setFile("/home/codio/workspace/TestFiles/Test4.java");
//         System.out.println("\ntest4: "+sb4.checkFile());
        
//         SymbolBalance sb5 = new SymbolBalance();
//         sb5.setFile("/home/codio/workspace/TestFiles/Test5.java");
//         System.out.println("\ntest5: "+sb5.checkFile());
        
//         SymbolBalance sb6 = new SymbolBalance();
//         sb6.setFile("/home/codio/workspace/TestFiles/Test6.java");
//         System.out.println("\ntest6: "+sb6.checkFile());
        
        TwoStackQueue q1 = new TwoStackQueue ();
        q1.enqueue(10);
        q1.enqueue(20);
        
        System.out.println("before " + q1);
        System.out.println(q1.size() );
        System.out.println(q1.isEmpty() );        
        System.out.println("~~~~~ ");
        
        
        q1.dequeue();
        System.out.println("1) after " + q1);
        System.out.println(q1.size() );
        System.out.println(q1.isEmpty() );       
        System.out.println("~~~~~ ");
        
        q1.dequeue();
        System.out.println("2) after " + q1);
        System.out.println(q1.size() );
        System.out.println(q1.isEmpty() );
    }
}
