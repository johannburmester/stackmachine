package de.qudosoft.praktikum.operators;

import de.qudosoft.praktikum.StackMachineOperator;

import java.util.Stack;

/**
 * Created by jburmester on 03.12.2015.
 */
public class MultiplyOperator implements StackMachineOperator {
    @Override
    public void apply(Stack<Object> list) {
        if (list.size() < 3 && list.size() > 1) {
            int first = (int) list.pop();
            int second = (int) list.pop();
            int result = first * second;
            list.push(result);
        }
    }

//    @Override
//    public void addParameters(Stack<Integer> list) {
//    }
//
//    @Override
//    public void subParameters(Stack<Integer> list) {
//    }
//
//    @Override
//    public void mulParameters(Stack<Integer> list) {
//        if (list.size() < 3 && list.size() > 1) {
//            int first = list.pop();
//            int second = list.pop();
//            int result = first * second;
//            list.push(result);
//        }
//    }
}
