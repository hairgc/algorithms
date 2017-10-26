package com.github.mahui53541.algorithms.sort;


/**
 * 选择排序时间复杂度为N^2
 * @ClassName:  Selection   
 * @Description:TODO
 * @author: mahui 
 * @date:   2017年10月26日 下午1:19:30   
 *
 */
public class Selection {

	public static void main(String[] args) {
		Integer a[]= {1,5,3,2,4};
		Selection.sort(a);
		show(a);

	}
	private Selection() {};
	
	
	public static void sort(Comparable[] a) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(less(a[j],a[min])) min=j;
			}
			
			exch(a,i,min);
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
