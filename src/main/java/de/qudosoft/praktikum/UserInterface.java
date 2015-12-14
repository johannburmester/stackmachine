package de.qudosoft.praktikum;

import de.qudosoft.praktikum.operators.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Hello world!
 */
public class UserInterface {
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

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StackMachine sm = new StackMachineImpl();
        System.out.println("Operatorlist:\n");
        System.out.println("+ -> Adds both numbers");
        System.out.println("- -> Subtracts the second number with the first");
        System.out.println("* -> Multiplys both numbers");
        System.out.println("/ -> divides the second by the first number");
        System.out.println("== -> Chechs if both numbers are equal");
        System.out.println("!= -> Checks if both numbers are unequal");
        System.out.println("> -> Chechs if the ");
        System.out.println("< -> <");
        System.out.println("dup -> duplicates the entered number");
        System.out.println("swap -> switches the two entered numbers around");
        System.out.println("drop -> drops the number entered in second");
        System.out.println("over -> puts a duplicate of the number entered in first at the end");
        System.out.println("rot -> rotates the two numbers entered in last to the front");
        System.out.println("tuck -> rotates a duplicate of the number entered in last to the front ");
        System.out.println("enter numbers with a space inbetween, then a comma followed by one Operator, below");
        String s = reader.readLine();
        if (s.endsWith("+")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(ADD);
            Object result = sm.pop();
            System.out.println("The result to the operation "+first+" + "+second+" is: "+result);
        }
        if (s.endsWith("-")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(SUB);
            Object result = sm.pop();
            System.out.println("The result to the operation "+second+" - "+first+" is: "+result);
        }
        if (s.endsWith("*")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(MUL);
            Object result = sm.pop();
            System.out.println("The result to the operation "+first+" * "+second+" is: "+result);
        }
        if (s.endsWith("/")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(DIV);
            Object result = sm.pop();
            System.out.println("The result to the operation "+second+" / "+first+" is: "+result);
        }
        if (s.endsWith("==")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(Equals);
            Object result = sm.pop();
            System.out.println("The result to the operation "+first+" = "+second+" is: "+result);
        }
        if (s.endsWith("!=")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(Unequal);
            Object result = sm.pop();
            System.out.println("The result to the operation "+first+" != "+second+" is: "+result);
        }
        if (s.endsWith(">")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(GreaterThen);
            Object result = sm.pop();
            System.out.println("The result to the operation "+second+" > "+first+" is: "+result);
        }
        if (s.endsWith("<")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(SmallerThen);
            Object result = sm.pop();
            System.out.println("The result to the operation "+first+" < "+second+" is: "+result);
        }

        // TODO ab hier wirds kniflig !!!

        if (s.endsWith("dup")) {
            Object a = s.substring(0, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            sm.push(first);
            sm.push(DUP);
            Object result = sm.pop();
            System.out.println("The result to your operation is: "+result);
        }
        if (s.endsWith("swap")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(SWAP);
            Object result = sm.pop();
            System.out.println("The result to your operation is: "+result);
        }
        if (s.endsWith("drop")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(DROP);
            Object result = sm.pop();
            System.out.println("The result to your operation is: "+result);
        }
        if (s.endsWith("over")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(OVER);
            Object result = sm.pop();
            System.out.println("The result to your operation is: "+result);

        }
        if (s.endsWith("rot")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.lastIndexOf(' '));
            Object c = s.substring(s.lastIndexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            int third = Integer.parseInt(String.valueOf(c));
            sm.push(first);
            sm.push(second);
            sm.push(third);
            sm.push(ROT);
            Object result = sm.pop();
            Object result1 = sm.pop();
            Object result2 = sm.pop();
            System.out.println("The rotated version of the entered Stack ["+first+","+second+","+third+"] looks like this ["+result2+","+result1+","+result+"]");
        }
        if (s.endsWith("tuck")) {
            Object a = s.substring(0, s.indexOf(' '));
            Object b = s.substring(s.indexOf(' ')+1, s.indexOf(','));
            int first = Integer.parseInt(String.valueOf(a));
            int second = Integer.parseInt(String.valueOf(b));
            sm.push(first);
            sm.push(second);
            sm.push(TUCK);
            Object result = sm.pop();
            Object result1 = sm.pop();
            Object result2 = sm.pop();
            System.out.println("The tucked version of ["+first+","+second+"] is ["+result+","+result1+","+result2+"] Happy Days!!!");
        }
    }

}
