package com.github.mahui53541.algorithms.c1;

import java.util.Arrays;

import javax.management.OperationsException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**   
 * @ClassName:  CompleteBrackets   
 * @Description:括号补全，如输入1+2)*3-4)*5-6)))输出((1+2)*((3-4)*(5-6)))
 * @author: mahui 
 * @date:   2017年7月12日 下午4:40:05   
 *     
 */ 
public class CompleteBrackets {
	
	public static void main(String[] args) {
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		
		In in = new In();
        String s = in.readAll().trim();
        
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*'||s.charAt(i)=='/')
        		ops.push(String.valueOf(s.charAt(i)));
        	else if(s.charAt(i)==')') {
        		
        	}else {
        		//vals.push(Double.);
        	}
        }
	}

}
