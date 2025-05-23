package a4;

import java.util.ArrayDeque;

/**
 * Converts from infix to postfix expression then calculates answer
 * @author Frankie
 */
public class Infix {

/**
 * 
 * @param ch
 * @return precedence score of operator
 */
    static int getPrecedence(char ch)
    {

        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }

/**
 * 
 * @param ch
 * @return whether operator has left associativity
 */
     static boolean hasLeftAssociativity(char ch) {
        if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            return true;
        } else {
            return false;
        }
    }

/**
 * 
 * @param tokens infix expression tokenized
 * @return answer via postfix calculation
 */
    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque <Object> stack= new ArrayDeque<>();
        ArrayDeque <Object> output= new ArrayDeque<>();
        while (!tokens.isEmpty()){
            System.out.println("round");
            
            if (tokens.peek() instanceof Double){
                output.add(tokens.removeFirst());
            }
            else if( tokens.peek() instanceof Character){
                Character operator= (Character) tokens.removeFirst();
                if (operator== '('){
                    stack.push(operator);
                }
                else if (operator == ')') {
                    while (!stack.isEmpty()&& (Character) stack.peek() != '('){
                        output.add(stack.pop());
                    }

                    stack.pop();
                }
                else if (operator=='^'){
                    stack.push(operator);
                }
                else {
                    while (!stack.isEmpty()&& getPrecedence(operator)<= getPrecedence((Character)stack.peek()) && hasLeftAssociativity(operator)) {
                        output.add(stack.pop());
                    }
                    stack.push(operator);
                }
               
            }
            else{ 
                System.out.println ("object not recognized");
                throw new IllegalArgumentException();
            }
        }
        while (!stack.isEmpty()) {
            if ((Character)stack.peek() == '('){
                throw new IllegalArgumentException();
            }
            output.add(stack.pop());
        }
       return Postfix.postfix(output);
    }

}

