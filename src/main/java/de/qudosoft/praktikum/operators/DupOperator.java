package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 03.12.2015.
 */
public class DupOperator implements StackMachineOperator {

    @Override
    public void apply(Stack<Object> list) {
        int first = (int) list.pop();
        list.push(first);
        list.push(first);
    }
}
