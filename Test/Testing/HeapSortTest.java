package Testing;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import assignment3.*;


public class HeapSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildheap(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		h.BuildHeap(h,inp1,inp1.length);
		assertArrayEquals(new int[]{45,42,5,8,36}, h.array);
	}

	@Test
	public void testParent(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		h.BuildHeap(h,inp1,inp1.length);
		assertEquals(1, h.Parent(4));
	}

	@Test
	public void testLeftChild(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		h.BuildHeap(h,inp1,inp1.length);
		assertEquals(3, h.LeftChild(1));
	}

	@Test
	public void testRightChild(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		h.BuildHeap(h,inp1,inp1.length);
		assertEquals(4, h.RightChild(1));
	}

	@Test
	public void testMaximum(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		h.BuildHeap(h,inp1,inp1.length);
		assertEquals(45, h.GetMaximum());
	}
	@Test
	public void sortAscending_noRepeatedElements(){
		int [] inp1 = new int[]{8,75,12,56};
		HeapSort hsort = new HeapSort();
		assertArrayEquals(new int[]{8,12,56,75}, hsort.HeapSort(inp1, inp1.length));
	}

	@Test
	public void sortAscending_RepeatedElements(){
		int [] inp2 = new int[]{6,2,14,6,94};
		HeapSort hsort = new HeapSort();
		assertArrayEquals(new int[]{2,6,6,14,94}, hsort.HeapSort(inp2, inp2.length));
	}
	@Test
	public void sortAscending_NegativeElements(){
		int [] inp3 = new int[]{45,-4,32,85,65,-3,24,32};
		HeapSort hsort = new HeapSort();
		assertArrayEquals(new int[]{-4,-3,24,32,32,45,65,85}, hsort.HeapSort(inp3, inp3.length));
	}
	@Test
	public void testParentforlessthanzero(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		assertEquals(-1, h.Parent(0));
	}
	@Test
	public void testParentgreaterthancount(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		assertEquals(-1, h.Parent(6));
	}
	@Test
	public void testMaximumcountzero(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		assertEquals(-1, h.GetMaximum());
	}
	@Test
	public void testDeleteMax(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		h.BuildHeap(h,inp1,inp1.length);
		assertEquals(45, h.DeleteMax());
	}
	@Test
	public void testDeleteMaxcountzero(){
		int [] inp1 = new int[]{8,45,5,42,36};
		Heap h = new Heap(inp1.length,0);
		assertEquals(-1, h.DeleteMax());
	}
}
