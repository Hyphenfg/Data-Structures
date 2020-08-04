import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class SpellChecker implements SpellCheckerInterface{
    private File f;
    private Scanner in;
    private HashSet<String> h;
    
    SpellChecker(String filename){
        try{
            f = new File( filename );
            in = new Scanner (f);
        }
        catch(FileNotFoundException e){
            System.out.println("That's not a valid file path");
        }
        
        h = new HashSet<String>();
        while(in.hasNextLine()){
            String line = in.nextLine();
            line = line.toLowerCase();
            h.add(line);
        }
        //test print first and last item of dictionary
        //Iterator<String> i = h.iterator(); 
        //System.out.println(h);
    }
    
    public List<String> getIncorrectWords(String filename){
        try{
            f = new File( filename );
            in = new Scanner (f);
        }
        catch(FileNotFoundException e){
            System.out.println("That's not a valid file path");
        }
        List <String> incorrect = new ArrayList <>();
        //int counter = 0;
        
        while (in.hasNextLine()){
            String line = in.nextLine();
            line = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
            String[] words = line.split(" ");
            //counter++;
            
            for (int i =0; i<words.length; i++){
                if(words[i].equals("")){//no empty spots
                    continue;
                }
                if( !h.contains(words[i]) ){//checks dictionary
                    //System.out.println (counter+" , "+ i);
                    incorrect.add(words[i]);//adds all words to the list
                }
            }
        }
        
        return incorrect;
    }
	
    public Set<String> getSuggestions(String word){
        Set<String> suggestions = new HashSet<String>();
        char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //add a character
        for (int i=0; i<abc.length; i++){
            suggestions.add(abc[i]+word);//before
            suggestions.add(word+abc[i]);//after
            for (int j=0; j<word.length(); j++){//in btwn
                String temp1 = word.substring(0,j);
                String temp2 = word.substring(j);
                
                suggestions.add(temp1+abc[i]+temp2);
            }
        }
        
        //remove a character
        for (int j=0; j<word.length(); j++){//in btwn
            String temp1 = word.substring(0,j);
            String temp2 = word.substring(j+1);
            //System.out.println("j("+j+") :" +"temp1-"+temp1+ ", temp2-" +temp2);
            
            suggestions.add(temp1+temp2);
        }
        
        //swap adjacent characters
        for (int j=0; j<word.length()-1; j++){//in btwn
            String temp1 = word.substring(0,j);
            String temp2 = word.substring(j+2);
            String swap1 = word.substring(j,j+1);
            String swap2 = word.substring(j+1,j+2);
            //System.out.println("j("+j+") :" +"temp1-"+temp1+ ", temp2-" +temp2);
            
            suggestions.add(temp1+swap2+swap1+temp2);
        }
        
        return suggestions;
    }
}