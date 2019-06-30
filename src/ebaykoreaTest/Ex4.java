package ebaykoreaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex4 {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}

	public int[][] solution(int[][] city) {
		
		int xlen = city.length;
		int ylen = city[0].length;
		
		ArrayList<Node> mart = new ArrayList<>();
		
		for (int i = 0; i < xlen; i++) {
			for (int j = 0; j < ylen; j++) {
				if (city[i][j] == 0) {
					mart.add(new Node(i, j));
				} 
			}
		}
		int[][] answer = new int[xlen][ylen];
		for(int i = 0; i < xlen; i++) {
			for(int j = 0; j < ylen; j++) {
				if (city[i][j] == 1) {
					int ax = i;
					int ay = j;
					int dist = Integer.MAX_VALUE;
					
					for (int k = 0; k < mart.size(); k++) {
						int mx = mart.get(k).x;
						int my = mart.get(k).y;
						int calx = Math.abs(ax - mx);
						if(calx > dist) {
							continue;
						}
						int caly = Math.abs(ay - my);
						if(caly > dist) {
							continue;
						}
						int cal = calx + caly;
						dist = dist < cal ? dist : cal;
					}
					answer[ax][ay] = dist;
				} 
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
}
