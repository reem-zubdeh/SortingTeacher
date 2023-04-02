import java.util.ArrayList;

public class CountingSort {

	ArrayList<String> countingArr;
	ArrayList<String> arrDisp;
	ArrayList<String> comment;
	int[] array;
	int[] index;

	public CountingSort(int array[]) {

		this.array = array;
		countingArr = new ArrayList<String>();
		arrDisp = new ArrayList<String>();
		comment = new ArrayList<String>();
	}

	public void sort() {

		comment.add("Loop across the array and count the");
		comment.add("number of occurrences of each element");
		comment.add("Loop accross the counting array. In the original array,");
		comment.add("replace each element with the index, a number of times");
		comment.add("equal to the value at the index");
		comment.add("Array sorted");

		int max = array[0];
		for (int ele = 1; ele < array.length; ele++) {
			if (array[ele] > max)
				max = array[ele];

		}

		int temp[] = new int[max + 1];
		index = new int[max + 1];

		for (int i = 0; i <= max; i++) {
			index[i] = i;
		}

		countingArr.add(Formatter.htmlString(temp));

		for (int i = 0; i < array.length; i++) {

			temp[array[i]] += 1;
			countingArr.add(Formatter.htmlString(temp));

		}

		int k = 0;
		for (int j = 0; j < temp.length; j++) {
			if (temp[j] > 0) {

				for (int i = 1; i <= temp[j]; i++) {

					arrDisp.add(Formatter.htmlStringSelect(array, k));
					array[k++] = j;
					arrDisp.add(Formatter.htmlString(array));

				}
				arrDisp.add(Formatter.htmlString(array));

				temp[j]--;
			}
		}
	}

}
