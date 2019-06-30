package ebaykoreaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3 {
	
	public String solution(int k) {
		int count = 0;
		int n = k;
		long num = 0;
		StringBuilder sb = new StringBuilder();
		
		if (n > 1022) {
			sb.append("-1");
			return sb.toString();
		}

		while (true) {
			boolean isDsc = true;
			long temp = num;
			long jump = 1;
			long before = -1;

			// �����ڸ����� ���ڸ��� ��
			while (temp != 0) {
				
				if (temp % 10 >= before) {
					isDsc = false;
				}

				// jump�� �ִ�ġ�� �ø��� ����.
				if (!isDsc && temp % 10 < before) {
					break;
				}
				
				// jump�� � �ڸ������� �����ϴ� ���� �ƴ����� �ĺ��Ѵ�.
				jump *= 10;
				before = temp % 10;
				temp /= 10;
			}
			
			if (isDsc) {
				if (n == count++) {
					break;
				}
				num++;
			} else {

				jump /= 10;
				num += jump;
				num = num / jump * jump;
				continue;
			}
			
		}
		return String.valueOf(num);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
}
