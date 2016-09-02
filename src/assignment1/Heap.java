package assignment1;

public class Heap {
	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;
	// Creating Heap
	public Heap(int capacity, int heap_type){
		this.heap_type = heap_type;
		this.count = 0;
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	//Parent of a Node
	public int Parent(int i){
		if(i<=0 || i>=this.count)
			return -1;
		return (i-1)/2;
	}
	//Children of a Node
	public int LeftChild(int i){
		int left = 2*i+1;
		if(left>=this.count)
			return -1;
		return left;
	}
	public int RightChild(int i){
		int right = 2*i+1;
		if(right>=this.count)
			return -1;
		return right;
	}
	//Maximum Element
	public int GetMaximum(){
		if(this.count == 0)
			return -1;
		return this.array[0];
	}
	//Heapifying the element at location i
	public void PercolateDown(int i){
		int l,r,max,temp;
		l=LeftChild(i);
		r=RightChild(i);
		if(l!=-1 && this.array[l]>this.array[i])
			max = l;
		else 
			max = i;
		if(r!=-1 && this.array[r]>this.array[max])
			max = r;
		if(max!=-1){
			temp =  this.array[i];
			this.array[i]=this.array[max];
			this.array[max]=temp;
		}
		PercolateDown(max);
	}
	//Deleting an Element
	int DeleteMax(){
		if(this.count==0)
			return -1;
		int data = this.array[0];
		this.array[0]= this.array[this.count-1];
		this.count--;
		PercolateDown(0);
		return data;
	}
	//Inserting an Element
	public void Insert(int data){
		int i;
		if(this.count == this.capacity)
			ResizeHeap();
		this.count++;
		i= this.count-1;
		while(i>=0 && data>this.array[(i-1)/2]){
			this.array[i]=this.array[(i-1)/2];
			i=(i-1)/2;
		}
		this.array[i]=data;
	}
	public void ResizeHeap(){
		int[] array_old = new int[this.capacity];
		System.arraycopy(this.array, 0, array_old, this.count-1, this.capacity);
		this.array = new int[this.capacity*2];
		if(this.array==null){
			System.out.println("Memory Error");
			return;
		}
		for(int i=0;i<capacity;i++)
			this.array[i]=array_old[i];
		this.capacity*=2;
		array_old=null;
	}
	//Destroying the Heap
	public void DestroyHeap(){
		this.count=0;
		this.array=null;
	}
	//Heapifying the Array
	public void BuildHeap(Heap h, int[] A, int n){
		if(h==null)
			return;
		while(n>this.capacity)
			h.ResizeHeap();
		for(int i=0;i<n;i++)
			h.array[i]=A[i];
		this.count=n;
		for(int i=(n-1)/2;i>=0;i--)
			h.PercolateDown(i);
	}
}
