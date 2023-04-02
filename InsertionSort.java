import java.util.ArrayList;

public class InsertionSort {

	int[] a;
	ArrayList<String> array;
	ArrayList<String> comment;

	public InsertionSort(int[] a) {
		this.a = a;
		array = new ArrayList<String>();
		comment = new ArrayList<String>();
	}

	public void sort() {

		int n = a.length;

		if (n > 0 && a[1] < a[0])
			swap(a, 1, 0);

		array.add(Formatter.htmlStringSwap(a, 0, 1));
		comment.add("Iteration 1, make sure the first two elements are sorted");

		array.add(Formatter.htmlStringSwap(a, -1, -1));
		comment.add("Iteration 1, make sure the first two elements are sorted");

		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				array.add(Formatter.htmlStringSwap(a, j, j + 1));
				comment.add("Iteration " + (i + 1) + ", insert " + a[j + 1] + " in the correct spot");
				if (a[j] <= a[j + 1]) {
					array.add(Formatter.htmlStringSwap(a, -1, -1));
					comment.add("Iteration " + (i + 1) + ", insert " + a[j + 1] + " in the correct spot");
					break;
				}
				swap(a, j, j + 1);
				if (j == 0) {
					array.add(Formatter.htmlStringSwap(a, j, j + 1));
					comment.add("Iteration " + (i + 1) + ", insert " + a[j + 1] + " in the correct spot");
					array.add(Formatter.htmlStringSwap(a, -1, -1));
					comment.add("Iteration " + (i + 1) + ", insert " + a[j + 1] + " in the correct spot");
				}
			}
		}

		array.add(Formatter.htmlStringSwap(a, -1, -1));
		comment.add("Array sorted");

	}

	public void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}
