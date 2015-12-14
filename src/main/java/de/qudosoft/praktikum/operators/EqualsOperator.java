package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 03.12.2015.
 */
public class EqualsOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> stack) {
        Object first = stack.pop();
        Object second = stack.pop();
        if (first.equals(second)){
            stack.push(true);
        }else {
            stack.push(false);
        }
    }
}
