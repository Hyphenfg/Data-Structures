public class tester{
    
    public static void main (String[] args){
//         SpellChecker s1 = new SpellChecker("/home/codio/workspace/words.txt");
//         System.out.println(s1.getIncorrectWords("/home/codio/workspace/test.txt"));
//         System.out.println(s1.getSuggestions("hello"));

        KBestCounter x = new KBestCounter(5);
        
        x.count(0);
        x.count(1);
        x.count(2);
        x.count(3);
        x.count(4);
        System.out.println(x.kbest());
        
        x.count(5);
        System.out.println(x.kbest());
        x.count(0);
        System.out.println(x.kbest());
        x.count(3);
        System.out.println(x.kbest());
    }
}