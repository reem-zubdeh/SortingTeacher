import java.util.ArrayList;

public class BubbleSort {

	public int[] a;
	ArrayList<String> arrayDis;
	ArrayList<String> comment;

	public BubbleSort(int[] a) {
		this.a = a;
		arrayDis = new ArrayList<String>();
		comment = new ArrayList<String>();
	}

	public void sort() {

		int n = a.length;

		boolean done = false;

		arrayDis.add(Formatter.htmlString(a));
		comment.add("Iteration 1");

		for (int i = 0; i < n - 1; i++) {
			done = true;
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j + 1]) {

					arrayDis.add(Formatter.htmlStringSwap(a, j, j + 1));
					swap(a, j, j + 1);
					arrayDis.add(Formatter.htmlString(a));
					done = false;
					comment.add("Iteration " + (i + 1));
					comment.add("Iteration " + (i + 1));

				}
			}

			if (done) {
				comment.add("Array sorted");
				break;
			}
		}

	}

	public void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}
