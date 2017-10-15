import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] dir = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		int[][] apartment_Place = new int[N][N];
		boolean[][] Visited = new boolean[N][N];
		String tempS = "";
		
		for (int i = 0; i < N; i++) {
			tempS = sc.nextLine();
			String[] tempJ = tempS.split("");
			for (int j = 0; j < N; j++) {
				apartment_Place[i][j] = Integer.parseInt(tempJ[j]);
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		HashMap<Integer, Integer> answer = new HashMap<Integer, Integer>();
		
		int Sequence = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (apartment_Place[i][j] == 1 && Visited[i][j] == false) {
					Sequence++;
					q.offer(new int[] {i, j});
					Visited[i][j] = true;
					int apart_Num = 1;
					
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						int tempX = temp[0];
						int tempY = temp[1];
						
						if (0 <= tempX + dir[0][0] && apartment_Place[tempX + dir[0][0]][tempY] == 1 && Visited[tempX + dir[0][0]][tempY] == false) {
							apartment_Place[tempX + dir[0][0]][tempY] = 0;
							Visited[tempX + dir[0][0]][tempY] = true;
							q.offer(new int[] {tempX + dir[0][0], tempY});
							apart_Num++;
						}
						
						if (tempX + dir[2][0] < N && apartment_Place[tempX + dir[2][0]][tempY] == 1 && Visited[tempX + dir[2][0]][tempY] == false) {
							apartment_Place[tempX + dir[2][0]][tempY] = 0;
							Visited[tempX + dir[2][0]][tempY] = true;
							q.offer(new int[] {tempX + dir[2][0], tempY});
							apart_Num++;
						}

						if (0 <= tempY + dir[1][1] && apartment_Place[tempX][tempY + dir[1][1]] == 1 && Visited[tempX][tempY + dir[1][1]] == false) {
							apartment_Place[tempX][ tempY + dir[1][1]] = 0;
							Visited[tempX][ tempY + dir[1][1]] = true;
							q.offer(new int[] {tempX, tempY + dir[1][1]});
							apart_Num++;
						}
						
						if (tempY + dir[3][1] < N && apartment_Place[tempX][tempY + dir[3][1]] == 1 && Visited[tempX][tempY + dir[3][1]] == false) {
							apartment_Place[tempX][ tempY + dir[3][1]] = 0;
							Visited[tempX][ tempY + dir[3][1]] = true;
							q.offer(new int[] {tempX, tempY + dir[3][1]});
							apart_Num++;
						}
					}
					
					answer.put(Sequence, apart_Num);
				}
			}
		}
		
		int first_answer = answer.size();
		System.out.println(first_answer);
		int[] temp_answer = new int[first_answer];
		for (int i = 0; i < first_answer; i++) temp_answer[i] = answer.get(i);
		Arrays.sort(temp_answer);
		for (int i = 0; i < first_answer; i++) System.out.println(temp_answer[i]);
	}

}
