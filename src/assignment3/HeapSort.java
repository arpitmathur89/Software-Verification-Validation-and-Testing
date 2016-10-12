package assignment3;

public class HeapSort {
	
	public int[] HeapSort(int[] A, int n){
		Heap h = new Heap(n,0);	
		int x;
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
		h.count=old_size;
		for(int j=0;j<n;j++)
			A[j]=h.array[j];
		return A;
	}
}
