package com.github.mahui53541.algorithms.sort;

public class Merge {

	public static void main(String[] args) {
		Integer a[]= {1,5,3,2,4};
		Selection.sort(a);
		show(a);
	}

	private Merge() {};
	
	private static Comparable[] aux;
	
	public static void sort(Comparable [] a) {
		aux=new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable [] a,int lo,int hi) {
		if(hi<=lo) return;
		int mid=(lo+hi)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	private static void merge(Comparable[] a,int lo,int mid,int hi) {
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++) {
			aux[k]=a[k];
		}
		
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	// is v < w ?
    private static boolean less(Comparable<Comparable> v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
 // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
