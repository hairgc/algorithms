package com.github.mahui53541.algorithms.c1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
 * @ClassName:  ResizingArrayStack   
 * @Description:动态栈（根据容量自动调整）缺点：posh（），和pop()会调整大小，耗时！
 * @author: mahui 
 * @date:   2017年7月10日 下午5:34:17   
 *     
 */ 
public class ResizingArrayStack<Item> implements Iterable<Item>{
	private Item[] a;//array
	private int n;//size
	@SuppressWarnings("unchecked")
	public ResizingArrayStack() {
		a=(Item[]) new Object[2];
		n=0;
	}
	
	/**   
	 * @Title: isEmpty   
	 * @Description: 判断是否为空  
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	public boolean isEmpty() {
		return n==0;
	}
	
	/**   
	 * @Title: size   
	 * @Description: size  
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	public int size() {
		return n;
	}
	
	/**   
	 * @Title: resize   
	 * @Description:  resize
	 * @param: @param capacity
	 * @throws   
	 */
	private void resize(int capacity) {
        assert capacity >= n;
        a=Arrays.copyOf(a, capacity);
    }
	
	/**   
	 * @Title: push   
	 * @Description: TODO  
	 * @param: @param item      
	 * @return: void      
	 * @throws   
	 */
	public void push(Item item) {
		if (n == a.length) resize(2*a.length);    // double size of array if necessary
        a[n++] = item;
	}
	
	/**   
	 * @Title: pop   
	 * @Description:退栈  
	 * @param: @return      
	 * @return: Item      
	 * @throws   
	 */
	public Item pop() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = a[n-1];
        a[n-1] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
	}
	
	/**   
	 * @Title: peek   
	 * @Description: TODO  
	 * @param: @return      
	 * @return: Item      
	 * @throws   
	 */
	public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }
	
	/**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
    
    /**
     * Unit tests the {@code Stack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
