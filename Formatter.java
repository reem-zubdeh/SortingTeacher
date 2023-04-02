import java.util.LinkedList;

public class Formatter {

	public static String arrayString(int[] arr) {

		String temp = "";

		for (int i = 0; i < arr.length - 1; i++) {

			temp += arr[i] + "   ";
		}

		temp += arr[arr.length - 1];

		return temp;

	}

	public static String bucketString(LinkedList<Integer>[] arr) {

		String temp = "";

		for (int i = 0; i < arr.length; i++) {

			temp += "Bucket " + (i + 1) + ":    ";

			for (int j : arr[i]) {

				temp += j + "   ";

			}

			temp += "\n";
		}

		return temp;

	}

	public static String htmlStringSwap(int[] arr, int swap1, int swap2) {

		String temp = "<p style=\"font-size:180%;font-family:Tahoma; text-align:center; color: white\">   ";

		for (int i = 0; i < arr.length; i++) {

			if (i == swap1) {

				temp += "<span style=\"color: #a8f0a5\">" + arr[i] + "</span>   ";
			}

			else if (i == swap2) {

				temp += "<span style=\"color: #f0a5dd\">" + arr[i] + "</span>   ";
			}

			else {

				temp += arr[i] + "   ";

			}
		}

		temp += "</p>";

		return temp;

	}

	public static String htmlString(int[] arr) {

		String temp = "<p style=\"font-size:180%;font-family:Tahoma; text-align:center; color: white\">   ";

		for (int i = 0; i < arr.length; i++) {

			temp += arr[i] + "   ";

		}

		temp += "</p>";

		return temp;

	}

	public static String htmlStringSelect(int[] arr, int num) {

		String temp = "<p style=\"font-size:180%;font-family:Tahoma; text-align:center; color: white\">   ";

		for (int i = 0; i < arr.length; i++) {

			if (i == num) {

				temp += "<span style=\"color: #a8f0a5\">" + arr[i] + "</span>   ";
			}

			else {

				temp += arr[i] + "   ";

			}
		}

		temp += "</p>";

		return temp;

	}

	public static String htmlQuick(int[] arr, int l, int r, int swap1, int swap2) {

		String temp = "<p style=\"font-size:180%;font-family:Tahoma; text-align:center; color: white\">   ";

		for (int i = l; i <= r; i++) {

			if (i == swap1) {

				temp += "<span style=\"color: #a8f0a5\">" + arr[i] + "</span>   ";
			}

			else if (i == swap2) {

				temp += "<span style=\"color: #f0a5dd\">" + arr[i] + "</span>   ";
			}

			else {

				temp += arr[i] + "   ";

			}
		}

		temp += "</p>";

		return temp;

	}

	public static String htmlBinaryHeap(int[] arr, int num1, int num2) {

		String temp = "<p style=\"font-size:150%;font-family:Tahoma; text-align:center; color: white\">   ";

		int level[] = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			level[i] = (int) (Math.log(i) / Math.log(2)) + 1;
			if (i > 1 && level[i] != level[i - 1])
				temp += "<br>";
			if (i == num1 || i == num2) {
				temp += "<span style=\"color: #a8f0a5\">" + arr[i] + "</span>   ";
			} else {
				temp += arr[i] + " ";
			}
		}

		int n = arr.length + 1;
		double lg = Math.log(n) / Math.log(2);

		while (Math.floor(lg) != lg) {
			temp += "&nbsp;&nbsp;";
			lg = Math.log(++n) / Math.log(2);
		}

		temp += "</p>";

		return temp;

	}

}
