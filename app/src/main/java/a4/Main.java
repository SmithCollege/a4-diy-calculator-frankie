package a4;

import java.util.ArrayDeque;

class Main {
  public static void main(String[] args) {
    System.out.println("Calls from the command line:");
    System.out.println("    java Postfix <3 2 + 5 *>");
    System.out.println(Tokenizer.readTokens("3 2 +"));
    ArrayDeque<Object> tokens= Tokenizer.readTokens("3 2 +");
    System.out.println(Postfix.postfix(tokens));
    System.out.println("    java Calculate <infix-expr>");
  }
}