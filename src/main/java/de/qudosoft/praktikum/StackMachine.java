package de.qudosoft.praktikum;

/**
 * Created by jburmester on 30.11.2015.
 */
public interface StackMachine {

    void push(Object i);

    void push(StackMachineOperator operator);

    Object pop();
}
