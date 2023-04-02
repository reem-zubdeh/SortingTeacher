import java.util.ArrayList;

public class QuickSort {

	int[] a;
	ArrayList<String> array;
	ArrayList<String> part;
	ArrayList<String> piv;
	ArrayList<String> comment;

	public QuickSort(int[] a) {

		this.a = a;

		array = new ArrayList<String>();
		part = new ArrayList<String>();
		piv = new ArrayList<String>();
		comment = new ArrayList<String>();

		array.add(Formatter.htmlQuick(a, 0, a.length - 1, -1, -1));
		part.add("");
		piv.add("");
		comment.add("Recursively partition the array according to a chosen pivot");

	}

	public int partition(int left, int right) {

		int pivot = a[right];

		array.add(Formatter.htmlQuick(a, 0, a.length - 1, -1, -1));
		part.add(Formatter.htmlQuick(a, left, right, -1, -1));
		piv.add(pivot + "");
		comment.add("Partition the subarray with the pivot");

		int i = (left - 1);

		for (int j = left; j <= right - 1; j++) {

			if (a[j] < pivot) {

				i++;

				if (i != j) {

					array.add(Formatter.htmlQuick(a, 0, a.length - 1, i, j));
					part.add(Formatter.htmlQuick(a, left, right, i, j));
					piv.add(pivot + "");
					comment.add("Swap " + a[i] + " and " + a[j]);

					swap(a, i, j);

					array.add(Formatter.htmlQuick(a, 0, a.length - 1, -1, -1));
					part.add(Formatter.htmlQuick(a, left, right, -1, -1));
					piv.add(pivot + "");
					comment.add("Swap " + a[j] + " and " + a[i]);

				}

			}
		}
		array.add(Formatter.htmlQuick(a, 0, a.length - 1, i+1, right));
		part.add(Formatter.htmlQuick(a, left, right, i+1, right));
		piv.add(pivot + "");
		comment.add("Swap " + a[i+1] + " and " + a[right]);
		swap(a, i + 1, right);
		array.add(Formatter.htmlQuick(a, 0, a.length - 1, -1, -1));
		part.add(Formatter.htmlQuick(a, left, right, -1, -1));
		piv.add(pivot + "");
		comment.add("Swap " + a[right] + " and " + a[i+1]);
		return (i + 1);
	}

	public void sort() {

		array.add(Formatter.htmlQuick(a, 0, a.length - 1, -1, -1));
		part.add("");
		piv.add("");
		comment.add("Recursively partition the array according to a chosen pivot");

		sort(0, a.length - 1);
	}

	public void sort(int left, int right) {
		if (left < right) {

			int p = partition(left, right);
			sort(left, p - 1);
			sort(p + 1, right);

		}
	}

	public void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}
