package a4;

import java.util.ArrayDeque;

/**finds output for postfix problem
 * 
 * 
 * @author Frankie
 */
public class Postfix {

    /**finds output for postfix problem
     * 
     * @param tokens
     * @return Double: result of problem
     */
    public static double postfix(ArrayDeque<Object> tokens) {
        if (tokens.isEmpty()){
            throw new IllegalArgumentException();
        }
        
        ArrayDeque <Double> stack= new ArrayDeque<>();
        System.out.println(tokens.size());
        while (!tokens.isEmpty()){
            System.out.println("round");
            if (tokens.peek() instanceof Double){
                Double toAddStack= (Double)tokens.removeFirst();
                stack.push(toAddStack);
                System.out.println(stack);
            }
            else if (tokens.peekFirst() instanceof Character){
                if (stack.size()<=1){
                    throw new IllegalArgumentException();
                }
                Character operator= (Character) tokens.removeFirst();
                Double firstElem= stack.pop();
                Double secondElem= stack.pop();
                
                if (operator== Character.valueOf('*')){
                    Double result=secondElem*firstElem;
                    stack.push(result);
                }
                else if (operator== Character.valueOf('+')){
                    Double result=secondElem+firstElem;
                    stack.push(result);
                }
                else if (operator== '-'){
                    Double result=secondElem-firstElem;
                    stack.push(result);
                }
                else if (operator== '/'){
                    Double result=secondElem/firstElem;
                    stack.push(result);
                }
                else if (operator=='^'){
                    Double result= Math.pow(secondElem, firstElem);
                    stack.push(result);
                }
                else{System.out.println("error");}
            }
            else{ System.out.println ("object not recognized");}
        }
        return stack.pop();
    }
}