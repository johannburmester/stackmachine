package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 04.12.2015.
 */
public class TuckOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> list) {
        Object first = list.pop();
        Object second = list.pop();
        list.push(first);
        list.push(second);
        list.push(first);
    }
}
