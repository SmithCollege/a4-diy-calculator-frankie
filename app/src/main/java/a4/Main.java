package a4;

import java.util.ArrayDeque;

class Main {
  public static void main(String[] args) {
    System.out.println("Calls from the command line:");
    ArrayDeque<Object> tokens= Tokenizer.readTokens("40*6^3/540");
    System.out.println(Infix.infixToPostfix(tokens));
    System.out.println("    java Calculate <infix-expr>");
  }
}