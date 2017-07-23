package com.github.mahui53541.algorithms.c1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
 * @ClassName:  EvaluatePostfix   
 * @Description:根据后序表达式求结果
 *  1 2 3 4 5 * + 6 * * +
 *  277
 * @author: mahui 
 * @date:   2017年7月17日 上午9:35:26   
 *     
 */ 
public class EvaluatePostfix {

	public static void main(String[] args) {
		Stack<Double> stack = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if      (s.equals("+")) stack.push(stack.pop()+stack.pop());
            else if (s.equals("*")) stack.push(stack.pop()*stack.pop());
            else stack.push(Double.valueOf(s));
        }
        StdOut.println(stack.pop());
	}

}
