public class Tester{
    public static void main (String[] args){
        Rectangle r1 = new Rectangle (20.68, 40.39);
        Rectangle r2 = new Rectangle (98.64, 35.43);
        Rectangle r3 = new Rectangle (36.24, 54.38);
        Rectangle r4 = new Rectangle (78.3, 5.37);
        Rectangle r5 = new Rectangle (3.0, 4.38);
        
        Rectangle [] arrRect = {r1,r2,r3,r4};
        for (int i = 0; i<arrRect.length; i++){
            System.out.print(arrRect[i]+", Perimeter:"+arrRect[i].getPerimeter()+"\n");
        }
        
//         System.out.println ("~~~~~~");
//         System.out.println("r1 perimeter: " +r1.getPerimeter());
//         System.out.println("r2 perimeter: " +r2.getPerimeter());
//         System.out.println(r1.compareTo(r2));
        
        System.out.println ("~~~~~~\nLinear Search");
        GenericMethods genMet = new GenericMethods();
//         System.out.println( genMet.linearSearch(arrRect, r1) );
//         System.out.println( genMet.linearSearch(arrRect, r4) );
//         System.out.println( genMet.linearSearch(arrRect, r5) );
        
        System.out.println ("~~~~~~\nBinary Search");
        System.out.println( genMet.binarySearch(arrRect, r1) );
        System.out.println( genMet.binarySearch(arrRect, r4) );
        System.out.println( genMet.binarySearch(arrRect, r5) );
    }
}
