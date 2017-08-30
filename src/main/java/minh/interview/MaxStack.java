package minh.interview;

import java.util.Stack;

public class MaxStack {

    Stack stack = new Stack();

    Stack listOfMax = new Stack();

    Integer max = Integer.MIN_VALUE;

    void push (Integer i) {
        // if we find new max
        if (i > max) {
            // keep old max in stack for later
            listOfMax.push(max);
            // update current max
            max = i;
        }

        stack.push(i);
    }

    Integer pop () {
        Integer val = (Integer) stack.pop();

        // if we got current max
        if (val == max) {
            max = (Integer) listOfMax.pop();
        }

        return val;
    }

    Integer getMax() {
        return max;
    }
}
