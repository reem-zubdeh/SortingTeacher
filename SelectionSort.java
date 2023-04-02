import java.util.ArrayList;

public class SelectionSort {

	private int[] a;
	ArrayList<String> arrayDis;
	ArrayList<String> comment;

	public SelectionSort(int[] a) {
		this.a = a;
		arrayDis = new ArrayList<String>();
		comment = new ArrayList<String>();
	}

	public void sort() {

		int n = a.length;

		arrayDis.add(Formatter.htmlString(a));
		comment.add("Iteration 1");

		for (int i = 0; i < n - 1; i++) {

			int min = i;

			for (int j = i + 1; j < n; j++) {

				arrayDis.add(Formatter.htmlStringSwap(a, j, -1));
				comment.add("Iteration " + (i + 1) + ", minimum so far: " + a[min]);

				if (a[j] < a[min]) {
					min = j;
					arrayDis.add(Formatter.htmlStringSwap(a, j, -1));
					comment.add("Iteration " + (i + 1) + ", minimum so far: " + a[min]);
				}

			}

			arrayDis.add(Formatter.htmlStringSwap(a, i, min));
			comment.add("Iteration " + (i + 1) + ", swapping " + a[i] + " with minimum " + a[min]);

			if (min != i)
				swap(a, min, i);

			arrayDis.add(Formatter.htmlString(a));
			comment.add("Iteration " + (i + 1) + ", swapping " + a[min] + " with minimum " + a[i]);

		}

	}

	public void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}