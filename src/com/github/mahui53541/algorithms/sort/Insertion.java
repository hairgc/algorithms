package com.github.mahui53541.algorithms.sort;
/**
 * 插入排序
 * @ClassName:  Insertion   
 * @Description:TODO
 * @author: mahui 
 * @date:   2017年10月26日 下午2:17:36   
 *
 */
public class Insertion {

	public static void main(String[] args) {
		Integer a[]= {1,5,3,2,4};
		Selection.sort(a);
		show(a);

	}

	private Insertion() {};
	
	
	public static void sort(Comparable[] a) {
		int n=a.length;
		for(int i=1;i<n;i++) {
			
			for(int j=i;j>0 && less(a[j-1],a[j]);j--) {
				exch(a,j,j-1);
			}
		}
	}
	
	//is v<w
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	//exchange i,j
	private static void exch(Object[] a,int i,int j) {
		Object swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	
	// print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
