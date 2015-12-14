package de.qudosoft.praktikum;

import java.util.Stack;

/**
 * Created by jburmester on 30.11.2015.
 */
public class StackMachineImpl implements StackMachine {
    Stack<Object> list = new Stack<>();
    @Override
    public void push(Object i) {
        list.push(i);
    }

    @Override
    public void push(StackMachineOperator operator) {
            operator.apply(list);
    }

    @Override
    public Object pop() {
        Object result = list.pop();
//        Stack<Object> result = new Stack<>();
//        result.push(list.pop());
//        result.push(list.pop());
//        result.push(list.pop());
        return result;
    }
}
