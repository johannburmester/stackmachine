package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 04.12.2015.
 */
public class OverOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> list) {
        int first = (int) list.pop();
        int second = (int) list.pop();
        list.push(second);
        list.push(first);
        list.push(second);
    }
}
