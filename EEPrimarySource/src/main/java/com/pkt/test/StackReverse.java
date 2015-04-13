package com.pkt.test;

import java.util.Stack;

/**
 * Created by pankaj on 06-04-2015.
 */
public class StackReverse {
    public static void main(String[] args) {
        Stack<Integer> integerStack=new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        System.out.println(integerStack.peek());
        reverseStack(integerStack);
        System.out.println(integerStack.peek());
    }


    private static void reverseStack(Stack<Integer> integerStack) {
        if(integerStack.size()==0){
            return;
        }
        Integer lastElement=getBottom(integerStack);
        reverseStack(integerStack);
        integerStack.push(lastElement);
    }

    private static Integer getBottom(Stack<Integer> integerStack) {
        Integer top=integerStack.pop();
        if(integerStack.size()==0){
            return top;
        }
       Integer element= getBottom(integerStack);
        integerStack.push(top);
        return element;
    }
}
