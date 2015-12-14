package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 04.12.2015.
 */
public class RotOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> stack) {
        Object first = stack.pop();             //3
        Object second = stack.pop();            //2
        Object third = stack.pop();             //1
        stack.push(second);
        stack.push(first);
        stack.push(third);
    }
}
