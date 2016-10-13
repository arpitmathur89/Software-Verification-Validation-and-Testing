package assignment3;

public class HeapSort {
	
	public int[] HeapSort(int[] A, int n) {
		// 1st Bug
		Integer x = new Integer(0);
		//
		// 2nd Bug
		if(A.length < 0)
			System.out.println("I can never be printed");
		//
		Heap h = new Heap(n,0);	
		int i,temp;
		int old_size;
		h.BuildHeap(h,A,n);
		old_size = h.count;
		for(i=n-1;i>0;i--){
			temp = h.array[0];
			h.array[0]= h.array[h.count-1];
			h.array[h.count-1] = temp;
			h.count--;
			h.PercolateDown(0);
		}
		// 3rd Bug
		h = null;
		//
		h.count=old_size;
		for(int j=0;j<n;j++)
			A[j]=h.array[j];
		return A;
	}
}
