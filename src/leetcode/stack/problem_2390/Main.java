package leetcode.stack.problem_2390;

import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

  public static void main(final String[] args) {
    final String s = removeStars("erase*****");
    System.out.println(s);
  }

  public static String removeStars(final String s) {
    final Stack<Character> input = new Stack<>();
    final Stack<Character> output = new Stack<>();
    for (char ch : new StringBuilder(s).reverse().toString().toCharArray()) {
      input.push(ch);
    }

    while (!input.isEmpty()) {
      if (input.peek() == '*') {
        input.pop();
        output.pop();
      }
      if (!input.isEmpty() && Character.isLetter(input.peek())) {
        output.push(input.pop());
      }
    }
    return output.stream().map(String::valueOf).collect(Collectors.joining());
  }
}
