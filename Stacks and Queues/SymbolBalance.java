import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolBalance implements SymbolBalanceInterface {
    private File f;
    private Scanner in;
    private MyStack stack;
    private MismatchError mismatch;
    private EmptyStackError empty;
    private NonEmptyStackError nonEmpty;
    
    public void setFile(String filename){
        try{
            f = new File( filename );
            in = new Scanner (f);
        }
        catch(FileNotFoundException e){
            System.out.println("That's not a valid file path");
        }
    }

    public BalanceError checkFile(){
        stack = new MyStack();
        char[] openDelim = {'{', '(', '[',  '\"', '/', '*'};
        char[] closeDelim = {'}', ')', ']', '\"','*','/'};
        int lineCount = 0;
        boolean isComment = false;
        boolean isString = false;
        
        while(in.hasNextLine()){
            String line = in.nextLine();
            lineCount++;
            
            for (int i = 0; i < line.length(); i++){
                char currCh = line.charAt(i);
                char nextCh =' ';
                if (i <line.length()-1)
                    nextCh = line.charAt(i+1);
                
                for (int j = 0; j<openDelim.length; j++){
                    if ( currCh == openDelim[j] & !isString ){
                        if(currCh == openDelim[4] & nextCh == openDelim[5] & isComment == false){
                            isComment = true;
                            stack.push(currCh);
                            stack.push(nextCh);
                        }
                        else if (!isComment & !(nextCh == openDelim[4] || nextCh == openDelim[5])
                                & !(currCh == openDelim[4] || currCh == openDelim[5]) ){// only happens when not in a comment
                            stack.push(currCh);
                            isString = (currCh == openDelim[3]);
                            
//                             System.out.println("I was pushed! " + currCh);
//                             System.out.println("here be the stack: "+ stack);
                        }
                    }
                    else if ( currCh == closeDelim[j] & currCh!=closeDelim[5] ){
                        if(isComment){// & 
                           if (currCh == closeDelim[4] & nextCh == closeDelim[5]) {// ) {
                                //System.out.println("curr: " + currCh + ", "+ closeDelim[4] + " next: "+ nextCh);
                                isComment = false;
                                stack.pop();
                                stack.pop();
                           }
                        }
                        else if(isString){
                            if (currCh == openDelim[3]){
                                    isString = false;//if string closes the string now
                                    stack.pop();
                            }
                        }
                        else{
                            
//                             System.out.println ("1) stack.peek(): " + stack.peek());
//                             System.out.println ("1) currCh: " + currCh);
//                             System.out.println(stack.peek().equals(openDelim[j]));
                            
                            if (stack.isEmpty()){
                                empty = new EmptyStackError (lineCount);
                                return empty;
                            }
                            else if( stack.peek().equals(openDelim[j]) ) {
//                                 if (currCh == openDelim[3])
//                                     isString = false;//if string closes the string now
                                stack.pop();
                            }
                            else{
//                                 System.out.println ("2) stack.peek(): " +stack.peek());
//                                 System.out.println ("2) currCh: " + currCh);
                                
                                char tempCh = (char)stack.peek();
                                mismatch = new MismatchError(lineCount, currCh, tempCh);
                                return mismatch;
                            }
                        }   
                    }
                }
            
//                 System.out.println(lineCount+ " : " + stack);
            }
        }
        
        if (!stack.isEmpty()){
            nonEmpty = new NonEmptyStackError((char)stack.pop(), stack.size()+1);
            return nonEmpty;
        }
        return null; 
    }
    
}
