package de.qudosoft.praktikum;

import de.qudosoft.praktikum.operators.*;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Stack;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jburmester on 30.11.2015.
 */
public class StackMachineTest {

    private static final StackMachineOperator ADD = new AdditionOperator();
    private static final StackMachineOperator SUB = new SubtractionOperator();
    private static final StackMachineOperator MUL = new MultiplyOperator();
    private static final StackMachineOperator DIV = new DivOperator();
    private static final StackMachineOperator Equals = new EqualsOperator();
    private static final StackMachineOperator Unequal = new UnequalOperator();
    private static final StackMachineOperator GreaterThen = new GreaterThenOperator();
    private static final StackMachineOperator SmallerThen = new SmalerThenOperator();
    private static final StackMachineOperator DUP = new DupOperator();
    private static final StackMachineOperator SWAP = new SwapOperator();
    private static final StackMachineOperator DROP = new DropOperator();
    private static final StackMachineOperator OVER = new OverOperator();
    private static final StackMachineOperator ROT = new RotOperator();
    private static final StackMachineOperator TUCK = new TuckOperator();


    @Test
    public void testStackFirst() {
        StackMachine sm = new StackMachineImpl();
        sm.push(1);
        sm.push(2);
        sm.push(ADD);
        int result = (int) sm.pop();
        assertEquals(result, 3);
    }

    @Test
    public void testStackSecond() {
        StackMachine sm = new StackMachineImpl();
        sm.push(1);
        sm.push(2);
        sm.push(SUB);
        int result = (int) sm.pop();
        assertEquals(result, 1);
    }

    @Test
    public void testStackThird() {
        StackMachine sm = new StackMachineImpl();
        sm.push(2);
        sm.push(3);
        sm.push(MUL);
        int result = (int) sm.pop();
        assertEquals(result, 6);
    }

    @Test
    public void testStackFourth() {
        StackMachine sm = new StackMachineImpl();
        sm.push(2);
        sm.push(4);
        sm.push(DIV);
        int result = (int) sm.pop();
        assertEquals(result, 2);
    }

    @Test
    public void testEqualsStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(5);
        sm.push(5);
        sm.push(Equals);
        Object result = sm.pop();
        assertEquals(result, true);
        sm.push(new Date(3));
        sm.push(new Date(3));
        sm.push(Equals);
        result = sm.pop();
        assertEquals(result, true);
    }
    @Test
    public void testEqualStringStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push("hallo");
        sm.push("hallo");
        sm.push(Equals);
        Object result = sm.pop();
        assertEquals(result, true);
    }

    @Test
    public void testUnEqualStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(8);
        sm.push(4);
        sm.push(Unequal);
        Object result = sm.pop();
        assertEquals(result, true);
    }

    @Test
    public void testStackValueGreater() {
        StackMachine sm = new StackMachineImpl();
        sm.push(1);
        sm.push(3);
        sm.push(GreaterThen);
        Object result = sm.pop();
        assertEquals(result, true);
    }

    @Test
    public void testStackValueSmaller() {
        StackMachine sm = new StackMachineImpl();
        sm.push(3);
        sm.push(1);
        sm.push(SmallerThen);
        Object result = sm.pop();
        assertEquals(result, true);
    }

    @Test
    public void testDupStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(18);
        sm.push(DUP);
        assertEquals(sm.pop(), 18);
        assertEquals(sm.pop(), 18);
    }

    @Test
    public void testSwapStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(1);
        sm.push(2);
        sm.push(SWAP);
        assertEquals(sm.pop(), 2);
        assertEquals(sm.pop(), 1);
    }

    @Test
    public void testDropStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(2);
        sm.push(2);
        sm.push(DROP);
        assertEquals(sm.pop(), 2);
    }

    @Test
    public void testDropStack1() {
        StackMachine sm = new StackMachineImpl();
        sm.push(2);
        sm.push(4);
        sm.push(2);
        sm.push(DROP);
        assertEquals(sm.pop(), 4);
        assertEquals(sm.pop(), 2);
    }

    @Test
    public void testOverStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(2);
        sm.push(4);
        sm.push(OVER);
        assertEquals(sm.pop(), 2);
        assertEquals(sm.pop(), 4);
        assertEquals(sm.pop(), 2);
    }

    @Test
    public void testRotStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(1);
        sm.push(2);
        sm.push(3);
        sm.push(ROT);
        assertEquals(sm.pop(), 1);
        assertEquals(sm.pop(), 3);
        assertEquals(sm.pop(), 2);
    }

    @Test
    public void testRotStack1() {
        StackMachine sm = new StackMachineImpl();
        sm.push('a');
        sm.push('b');
        sm.push('c');
        sm.push(ROT);
        assertEquals(sm.pop(), 'a');
        assertEquals(sm.pop(), 'c');
        assertEquals(sm.pop(), 'b');
    }

    /*
    @Test
    public void testRotStack23() {
        StackMachine sm = new StackMachineImpl();
        sm.push('a', 'b', 'c', ROT);
        assertEquals(sm.stack(), Arrays.asList('b', 'c', 'a'));
    }
    */

    @Test
    public void testTuckStack() {
        StackMachine sm = new StackMachineImpl();
        sm.push(3);
        sm.push(5);
        sm.push(TUCK);
        assertEquals(sm.pop(), 5);
        assertEquals(sm.pop(), 3);
        assertEquals(sm.pop(), 5);
    }

    @Test
    public void testTuckStack1() {
        StackMachine sm = new StackMachineImpl();
        sm.push(9);
        sm.push(8);
        sm.push(TUCK);
        assertEquals(sm.pop(), 8);
        assertEquals(sm.pop(), 9);
        assertEquals(sm.pop(), 8);
    }

    @Test
    public void testTuckStack2() {
        StackMachine sm = new StackMachineImpl();
        sm.push(1);
        sm.push(2);
        sm.push(TUCK);
        assertEquals(sm.pop(), 2);
        assertEquals(sm.pop(), 1);
        assertEquals(sm.pop(), 2);
    }

//    @Test
//    public void test() {
//        StackMachine sm = new StackMachineImpl();
//        sm.push(23);
//        sm.push('a');
//        sm.push(DUP);
//        assertEquals(sm.pop(), 'a');
//        assertEquals(sm.pop(), 'a');
//        assertEquals(sm.pop(), 23);
//    }

}
