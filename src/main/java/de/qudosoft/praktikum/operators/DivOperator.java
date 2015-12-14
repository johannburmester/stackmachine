package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 03.12.2015.
 */
public class DivOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> list) {
        int first = (int) list.pop();
        int second = (int) list.pop();
        int result = first / second;
        list.push(result);
    }
}
