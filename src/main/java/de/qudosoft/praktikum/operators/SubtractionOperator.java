package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 03.12.2015.
 */
public class SubtractionOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> list) {
        if (list.size() < 3 && list.size() > 1) {
            int first = (int) list.pop();
            int second = (int) list.pop();
            int result = first - second;
            list.push(result);
        }
    }
}
