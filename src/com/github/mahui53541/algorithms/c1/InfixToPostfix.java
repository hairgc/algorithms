package com.github.mahui53541.algorithms.c1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
 * @ClassName:  InfixToPostfix   
 * @Description:
 	1、当输入的是操作数时候，直接输出
	2、当输入开括号时候，把它压栈
	3、当输入的是闭括号时候，先判断栈是否为空，若为空，则发生错误并进行相关处理。若非空，把栈中元素依次出栈输出，直到遇到第一个开括号，若没有遇到开括号，也发生错误，进行相关处理
	4、当输入是运算符op（+、- 、×、/）时候
		a)循环，当（栈非空and栈顶不是开括号and栈顶运算符的优先级不低于输入的运算符的优先级）时，反复操作：将栈顶元素出栈输出
		b)把输入的运算符op压栈
	5、当中序表达式的符号序列全部读入后，若栈内仍有元素，把他们依次出栈输出。若弹出的元素遇到空括号，则说明不匹配，发生错误，并进行相关处理
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
        StdOut.println("");
	}

}
