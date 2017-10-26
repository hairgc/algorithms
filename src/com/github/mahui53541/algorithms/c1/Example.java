package com.github.mahui53541.algorithms.c1;


class Father{
	public Father() {
		print();
	}
	static {
		System.out.println("static1");
	}
	{
		System.out.println("gz1");
	}
	public void print() {
		System.out.println("parent");
	}
}
public class Example extends Father{ 
//	  String str = new String("good"); 
//	  char[] ch = {'a','b','c'}; 
//	  public static void main(String[] args) { 
//	     Example ex = new Example(); 
//	     ex.change(ex.str, ex.ch); 
//	     System.out.print(ex.str +"and"); 
//	     System.out.print(ex.ch); 
//	  } 
//	    
//	  public void change(String str, char ch[]){ 
//	     str= "test ok"; 
//	     ch[0]= 'g'; 
//	  } 
	//private static Example e=new Example();
	
	static {
		System.out.println("static2");
	}
	
	{
		System.out.println("gz2");
	}
	public static void main(String[] args) { 
		Example ex=new Example();
	  }
	public Example() {
		print();
	}
	public void print() {
		System.out.println("SOn");
	}
//	public static void main(String[] args) { 
//		Example ex=new Example();
//  }
	
//	public static void main(String[] args) { 
////		String str1=new StringBuilder("计算机").append("软件").toString();
////		System.out.println(str1.intern()==str1);
////		String str2=new StringBuilder("计算机").append("软件").toString();
////		System.out.println(str2.intern()==str2);
////		int x=2;
////		double s1=(1+2)/x;
////		double s2=(2+2)/x;
////		System.out.println(s1);
////		System.out.println(s2);
//	}
	
	public void run() {
		
	}
	
	
} 
	
	