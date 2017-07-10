package com.github.mahui53541.algorithms.c1;

import java.util.Arrays;
import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
 * @ClassName:  Evaluate   
 * @Description:双栈算术表达式求值
 * @author: mahui 
 * @date:   2017年7月9日 上午10:42:27   
 *     
 */ 
public class Evaluate { 
	public static void main(String[] args) {
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		
		String []operation= {"+","-","*","/","sqrt"};
		
		while(!StdIn.isEmpty()) {
			String s=StdIn.readString();
			if(s.equals("("));
			else if(Arrays.asList(operation).contains(s)) {
				ops.push(s);
			}else if(s.equals(")")) {
				//如果是结束括号，弹出运算符和操作数，计算结果并压入栈中
				String op=ops.pop();
				double v=vals.pop();
				if(op.equals("+"))
					v=vals.pop()+v;
				else if(op.equals("-"))
					v=vals.pop()-v;
				else if(op.equals("*"))
					v=vals.pop()*v;
				else if(op.equals("/"))
					v=vals.pop()/v;
				else if(op.equals("sqrt"))
					v=Math.sqrt(v);
				vals.push(v);
			}else if(s.equals("quit"))
				break;
			else vals.push(Double.parseDouble(s));
			
		}
		StdOut.println(vals.pop());
	}

}
