package a4;

import java.util.ArrayDeque;

public class Postfix {

    public static boolean postfix(ArrayDeque<Object> tokens) {
        ArrayDeque <Double> stack= new ArrayDeque<>();
        if (tokens.peek() instanceof Double){
            Double toAddStack= (Double)tokens.removeFirst();
            stack.addFirst(toAddStack);
            System.out.println(stack);
        }
        tokens.removeFirst();
        return (tokens.peekFirst() instanceof Character);
            // Double firstElem= stack.removeFirst();
            // Double secondElem= stack.removeFirst();
            // Character operator= (Character) tokens.removeFirst();
            // if (operator== '*'){
            //     Double result=secondElem*firstElem;
            //     stack.addFirst(result);
            // }
            // else if (operator== '+'){
            //     Double result=secondElem+firstElem;
            //     return result;
            // }
            // else if (operator== '-'){
            //     Double result=secondElem-firstElem;
            //     stack.addFirst(result);
            // }
            // else if (operator== '/'){
            //     Double result=secondElem/firstElem;
            //     stack.addFirst(result);
            // }
            // else{}
        }
    }