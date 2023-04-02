import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("unchecked")

public class BucketSort {

	public int[] a;
	public int b;
	public ArrayList<String> arrayDisplay;
	public ArrayList<String> bucketsDisplay;
	public ArrayList<String> sortedbucketsDisplay;
	public ArrayList<String> comment;

	public BucketSort(int[] a, int b) {

		this.a = a;
		this.b = b;
		arrayDisplay = new ArrayList<String>();
		bucketsDisplay = new ArrayList<String>();
		sortedbucketsDisplay = new ArrayList<String>();
		comment = new ArrayList<String>();
	}

	public void sort() {

		comment.add("Add each element to its bucket");
		comment.add("Sort each smaller bucket using another algorithm, e.g. QuickSort");
		comment.add("Copy the elements from the buckets to the original array");
		comment.add("Array sorted");

		int n = a.length;
		int min = a[0], max = a[0];

		for (int i = 1; i < n; i++) {
			if (a[i] < min)
				min = a[i];
			if (a[i] > max)
				max = a[i];
		}

		LinkedList<Integer>[] buckets = new LinkedList[b];

		for (int i = 0; i < b; i++) {
			buckets[i] = new LinkedList<Integer>();
		}

		bucketsDisplay.add(Formatter.bucketString(buckets));

		for (int i = 0; i < n; i++) {
			int index = (a[i] - min) / ((max - min) / b);
			if (index >= b)
				index = b - 1;
			buckets[index].addFirst(a[i]);
			bucketsDisplay.add(Formatter.bucketString(buckets));
		}

		for (int i = 0; i < b; i++) {
			quickSort(buckets[i]);
			sortedbucketsDisplay.add(Formatter.bucketString(buckets));
		}

		arrayDisplay.add(Formatter.htmlString(a));

		int count = 0;
		for (int i = 0; i < b; i++) {
			for (int j : buckets[i]) {
				arrayDisplay.add(Formatter.htmlStringSelect(a, count));
				a[count++] = j;
				arrayDisplay.add(Formatter.htmlString(a));
			}
		}

	}

	public void quickSort(LinkedList<Integer> a) {
		quickSort(a, 0, a.size() - 1);
	}

	public void quickSort(LinkedList<Integer> a, int left, int right) {

		if (left >= right)
			return;

		int ret = partition(a, a.get((left + right) / 2), left, right);

		quickSort(a, left, ret - 1);
		quickSort(a, ret, right);

	}

	public int partition(LinkedList<Integer> a, int pivot, int left, int right) {

		int iL = left;
		left--;
		right++;

		while (left < right) {

			while (a.get(++left) < pivot)
				;
			while (right > 0 && a.get(--right) > pivot)
				;
			if (left < right) {
				Collections.swap(a, left, right);
			}

		}

		if (iL == left)
			return ++left;
		else
			return left;
	}

}
