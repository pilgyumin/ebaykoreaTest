package ebaykoreaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Ex1 {
	static class NumStr implements Comparable<NumStr> {
		int n;
		String s;

		public NumStr(int n, String s) {
			this.n = n;
			this.s = s;
		}

		@Override
		public String toString() {
			return "NumStr [n=" + n + ", s=" + s + "]";
		}

		@Override
		public int compareTo(NumStr arg0) {
			String s1 = this.s;
			String s2 = arg0.s;
			int ret = 0;
			int size = s1.length();
			if (s1.length() < s2.length()) {
				ret = -1;
				size = s1.length();
			} else if (s1.length() > s2.length()) {
				ret = 1;
				size = s2.length();
			}
			for (int i = 0; i < size; i++) {
				if (s1.charAt(i) < s2.charAt(i)) {
					ret = -1;
					break;
				} else if (s1.charAt(i) > s2.charAt(i)) {
					ret = 1;
					break;
				} else {
					continue;
				}
			}
			return ret;
		}
	}

	public static int[] solution(int[] numbers) {
		NumStr[] numstr = new NumStr[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			String[] s = String.valueOf(numbers[i]).split("");
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length; j++) {
				switch (s[j]) {
				case "0":
					sb.append("zero");
					break;
				case "1":
					sb.append("one");
					break;
				case "2":
					sb.append("two");
					break;
				case "3":
					sb.append("three");
					break;
				case "4":
					sb.append("four");
					break;
				case "5":
					sb.append("five");
					break;
				case "6":
					sb.append("six");
					break;
				case "7":
					sb.append("seven");
					break;
				case "8":
					sb.append("eight");
					break;
				case "9":
					sb.append("nine");
					break;
				}
			}
			numstr[i] = new NumStr(numbers[i], sb.toString());
		}
		
		Arrays.sort(numstr);

		int[] answer = new int[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			answer[i] = numstr[i].n;
		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(s[i]);
		}
		solution(ar);
	}
}
