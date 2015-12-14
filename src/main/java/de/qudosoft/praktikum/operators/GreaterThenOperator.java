package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 03.12.2015.
 */
public class GreaterThenOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> list) {
        int first = (int) list.pop();
        int second = (int) list.pop();
        if (first > second){
            list.push(true);
        }else {
            list.push(false);
        }
    }
}
