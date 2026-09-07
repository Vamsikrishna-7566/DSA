import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if ((current == ')' && opening != '(') ||
                    (current == ']' && opening != '[') ||
                    (current == '}' && opening != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
