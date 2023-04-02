import java.util.ArrayList;

public class MergeSort {

	int[] a;
	ArrayList<String> subArrL;
	ArrayList<String> subArrR;
	ArrayList<String> arr;
	ArrayList<String> mergedArr;
	int[] ogArr;

	public MergeSort(int[] a) {
		this.a = a;
		subArrL = new ArrayList<String>();
		subArrR = new ArrayList<String>();
		arr = new ArrayList<String>();
		mergedArr = new ArrayList<String>();
		ogArr = a;
	}

	public void sort(int[] a) {

		int n = a.length;

		if (n == 1)
			return;

		int mid = n / 2;

		int[] aL = new int[mid];
		int[] aR = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			aL[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			aR[i - mid] = a[i];
		}

		subArrL.add(Formatter.arrayString(aL));
		subArrR.add(Formatter.arrayString(aR));
		arr.add(Formatter.htmlString(ogArr));
		mergedArr.add(Formatter.htmlString(a));

		sort(aL);

		mergedArr.add(Formatter.htmlString(a));
		subArrL.add(Formatter.arrayString(aL));
		subArrR.add(Formatter.arrayString(aR));
		arr.add(Formatter.htmlString(ogArr));
		sort(aR);
		// System.out.println("merging arrays " + Arrays.toString(aL) + " and " +
		// Arrays.toString(aR) + " into " + Arrays.toString(a));
		merge(a, aL, aR);

	}

	public void merge(int[] a, int[] aL, int[] aR) {

		// System.out.println("merging arrays " + Arrays.toString(aL) + " and " +
		// Arrays.toString(aR) + " into " + Arrays.toString(a));

		int l = 0, r = 0;

		for (int i = 0; i < a.length; i++) {

			if (aL[l] < aR[r]) {

				subArrL.add(Formatter.arrayString(aL));
				subArrR.add(Formatter.arrayString(aR));
				mergedArr.add(Formatter.htmlStringSelect(a, i));
				arr.add(Formatter.htmlString(ogArr));

				a[i] = aL[l++];

				subArrL.add(Formatter.arrayString(aL));
				subArrR.add(Formatter.arrayString(aR));
				mergedArr.add(Formatter.htmlString(a));
				arr.add(Formatter.htmlString(ogArr));

				if (l == aL.length) {
					break;
				}
			} else {
				subArrL.add(Formatter.arrayString(aL));
				subArrR.add(Formatter.arrayString(aR));
				mergedArr.add(Formatter.htmlStringSelect(a, i));
				arr.add(Formatter.htmlString(ogArr));

				a[i] = aR[r++];

				arr.add(Formatter.htmlString(ogArr));
				subArrL.add(Formatter.arrayString(aL));
				subArrR.add(Formatter.arrayString(aR));
				mergedArr.add(Formatter.htmlString(a));
				if (r == aR.length) {
					break;
				}
			}

		}

		for (int i = l; i < aL.length; i++) {

			subArrL.add(Formatter.arrayString(aL));
			subArrR.add(Formatter.arrayString(aR));
			mergedArr.add(Formatter.htmlStringSelect(a, i + r));
			arr.add(Formatter.htmlString(ogArr));
			a[i + r] = aL[i];
			subArrL.add(Formatter.arrayString(aL));
			subArrR.add(Formatter.arrayString(aR));
			mergedArr.add(Formatter.htmlString(a));
			arr.add(Formatter.htmlString(ogArr));
		}

		for (int i = r; i < aR.length; i++) {

			subArrL.add(Formatter.arrayString(aL));
			subArrR.add(Formatter.arrayString(aR));
			mergedArr.add(Formatter.htmlStringSelect(a, i + l));
			arr.add(Formatter.htmlString(ogArr));
			a[i + l] = aR[i];
			subArrL.add(Formatter.arrayString(aL));
			subArrR.add(Formatter.arrayString(aR));
			mergedArr.add(Formatter.htmlString(a));
			arr.add(Formatter.htmlString(ogArr));

		}

		// System.out.println("merged arrays " + Arrays.toString(aL) + " and " +
		// Arrays.toString(aR) + " into " + Arrays.toString(a));

	}

}
