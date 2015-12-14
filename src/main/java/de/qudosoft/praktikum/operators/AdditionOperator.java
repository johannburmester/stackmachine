package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 30.11.2015.
 */
public class AdditionOperator  implements StackMachineOperator {

    @Override
    public void apply(Stack<Object> list) {
        if (list.size() < 3 && list.size() > 1) {
            Object first = list.pop();
            Object second =  list.pop();
            int result = (int) first + (int) second;
            list.push(result);
        }
    }
}
