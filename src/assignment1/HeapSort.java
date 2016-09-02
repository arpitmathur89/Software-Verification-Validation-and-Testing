package assignment1;

public class HeapSort {
	
	public static  void main(String[] args){
		int []A={1,34,32,67,54};
		HeapSort(A,A.length);
		for(int a:A)
			System.out.println(a + " ");
	}
	public static void HeapSort(int[] A, int n){
		Heap h = new Heap(n,0);
		int old_size,i,temp;
		h.BuildHeap(h,A,n);
		old_size = h.count;
		for(i=n-1;i>0;i--){
			temp = h.array[0];
			h.array[0]= h.array[h.count-1];
			h.array[h.count-1]=temp;
			h.count--;
			h.PercolateDown(0);
		}
		h.count=old_size;
	}
}
