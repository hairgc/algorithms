package com.github.mahui53541.algorithms.c1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
 * @ClassName:  InfixToPostfix   
 * @Description:中序转后序
 * @author: mahui 
 * @date:   2017年7月15日 下午1:35:38   
 *     
 */ 
public class InfixToPostfix {

	public static void main(String[] args) {
		 Stack<String> stack = new Stack<String>();
	        while (!StdIn.isEmpty()) {
	            String s = StdIn.readString();
	            if      (s.equals("+")) stack.push(s);
	            else if (s.equals("*")) stack.push(s);
	            else if (s.equals(")")) StdOut.print(stack.pop() + " ");
	            else if (s.equals("(")) StdOut.print("");
	            else                    StdOut.print(s + " ");
	        }
	        StdOut.println("aa");
	}

}
