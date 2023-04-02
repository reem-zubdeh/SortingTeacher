import java.util.ArrayList;

public class HeapSort {

	int N;
	int[] a;
	ArrayList<String> heap;
	ArrayList<String> array;
	ArrayList<String> current;
	ArrayList<String> comment;

	public HeapSort(int[] a) {

		this.a = new int[a.length + 1];
		this.a[0] = 0;
		N = 0;

		heap = new ArrayList<String>();
		array = new ArrayList<String>();
		current = new ArrayList<String>();
		comment = new ArrayList<String>();

		array.add(Formatter.htmlStringSelect(a, -1));
		heap.add("");
		current.add("");
		comment.add("Add each element of the array to the end of a binary heap");

		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}

		for (int i = 0; i < 3; i++) {
			array.add(Formatter.htmlStringSelect(this.a, -1));
			heap.add(Formatter.htmlBinaryHeap(this.a, -1, -1));
			current.add("");
			comment.add("Binary heap is complete and valid. Start sorting original array");
		}

		sort();

		array.add(Formatter.htmlStringSelect(this.a, -1));
		heap.add(Formatter.htmlBinaryHeap(this.a, -1, -1));
		current.add("");
		comment.add("Array sorted");

	}

	public void sort() {
		while (N > 1) {

			array.add(Formatter.htmlStringSwap(a, 1, N));
			heap.add(Formatter.htmlBinaryHeap(a, 1, N));
			current.add("");
			comment.add("Swap max element " + a[1] + " with last element in the binary heap " + a[N]);

			array.add(Formatter.htmlStringSwap(a, 1, N));
			heap.add(Formatter.htmlBinaryHeap(a, 1, N));
			current.add("");
			comment.add("Swap max element " + a[1] + " with last element in the binary heap " + a[N]);

			swap(1, N--);
			if (N != 1)
				sink(1);

		}
	}

	public void insert(int k) {

		N++;
		array.add(Formatter.htmlStringSelect(a, N));
		heap.add(Formatter.htmlBinaryHeap(a, N, -1));
		current.add(k + "");
		comment.add("Add " + k);
		a[N] = k;
		swim(N);

	}

	public void swim(int i) {

		array.add(Formatter.htmlStringSelect(a, -1));
		heap.add(Formatter.htmlBinaryHeap(a, -1, -1));
		current.add(a[i] + "");
		comment.add("Add " + a[i]);

		while (i > 1 && a[i / 2] < a[i]) {

			array.add(Formatter.htmlStringSelect(a, i));
			heap.add(Formatter.htmlBinaryHeap(a, i, -1));
			current.add(a[i] + "");
			comment.add("Swim " + a[i]);

			swap(i / 2, i);
			i /= 2;

			array.add(Formatter.htmlStringSelect(a, i));
			heap.add(Formatter.htmlBinaryHeap(a, i, -1));
			current.add(a[i] + "");
			comment.add("Swim " + a[i]);

		}

	}

	public void sink(int i) {

		int s;

		array.add(Formatter.htmlStringSelect(a, i));
		heap.add(Formatter.htmlBinaryHeap(a, i, -1));
		current.add(a[i] + "");
		comment.add("Sink " + a[i]);

		do {

			array.add(Formatter.htmlStringSelect(a, i));
			heap.add(Formatter.htmlBinaryHeap(a, i, -1));
			current.add(a[i] + "");
			comment.add("Sink " + a[i]);

			s = i * 2;
			if (s < N && a[s] < a[s + 1])
				s++;
			if (a[i] < a[s])
				swap(s, i);
			else
				break;
			i = s;

			array.add(Formatter.htmlStringSelect(a, i));
			heap.add(Formatter.htmlBinaryHeap(a, i, -1));
			current.add(a[i] + "");
			comment.add("Sink " + a[i]);

		} while (i * 2 <= N);

	}

	public void swap(int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}
