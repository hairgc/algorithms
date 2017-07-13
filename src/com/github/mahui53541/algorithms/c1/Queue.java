package com.github.mahui53541.algorithms.c1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{

	private Node<Item> first;//最早添加节点的链接
	private Node<Item> last;//最近添加节点的链接
	private int N;//元素数量
	
	@SuppressWarnings("hiding")
	private class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	public Queue() {
		first=null;
		last=null;
		N=0;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public int size() {
		return N;
	}
	
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("");
		return first.item;
	}
	
	public void enqueue(Item item) {
		Node<Item> oldlast=last;
		last.item=item;
		last.next=null;
		if(isEmpty())first=last;
		else oldlast.next=last;
		N++;
	}
	
	public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException("");
		Item item=first.item;
		first=first.next;
		N--;
		if(isEmpty()) last=null;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);  
	}

	// an iterator, doesn't implement remove() since it's optional
    @SuppressWarnings("hiding")
	private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
