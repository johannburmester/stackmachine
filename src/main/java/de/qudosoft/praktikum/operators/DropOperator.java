package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 04.12.2015.
 */
public class DropOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> list) {
        list.pop();
    }
}
