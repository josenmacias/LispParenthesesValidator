package org.jose.lispvalidator.logic;

import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.Stack;

public class ParenthesesValidator {
    private static final Map<Character, Character> PARENTHESES_MAP = Map.of('(', ')');

    public static boolean validate(final String val) {
        final Stack<Character> parenthesesStack = new Stack<>();

        if (ObjectUtils.isEmpty(val)) {
            return true;
        }

        for (Character c : val.toCharArray()) {
            if (PARENTHESES_MAP.containsKey(c)) {
                parenthesesStack.push(c);
            }

            if (PARENTHESES_MAP.containsValue(c)) {
                if (parenthesesStack.isEmpty()) {
                    return false;
                }
                if (PARENTHESES_MAP.get(parenthesesStack.peek()) == c) {
                    parenthesesStack.pop();
                } else {
                    return false;
                }
            }
        }
        return parenthesesStack.isEmpty();
    }
}
