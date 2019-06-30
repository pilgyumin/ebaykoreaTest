package ebaykoreaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {
	
	public static int solution(String plain){

        String input = plain;
        int length = input.length();
        int[] arr = new int[length + 1];
        arr[length] = length;
        arr[length - 1] = length;

        for (int i = length - 2; i >= 0; i--) {
            char c = input.charAt(i);
            int j = arr[i+1];

            while (true) {
                if (c == input.charAt(j-1)) {
                    arr[i] = j-1;
                    break;
                }

                if (j == length) {
                    arr[i] = length;
                    break;
                }
                j = arr[j];
            }
        }

        int j = length;

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == input.charAt(j-1)) {
                j--;
            } 
            else {
                while (j < length) {
                    j = arr[j];
                    if (c == input.charAt(j-1)) {
                        j--;
                        break;
                    }
                }
            }
        }
        return length + j;
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String plain = br.readLine();
		int ans = solution(plain);
		System.out.println(ans);
	}
}
