import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int Testcase = sc.nextInt();
		int answer[] = new int[Testcase];
		
		for (int i = 0; i < Testcase; i++) {
			int M = sc.nextInt(); //배추밭의 가로 길이 (1<=M<=50)
			int N = sc.nextInt(); //배추밭의 세로 길이 (1<=N<=50)
			int K = sc.nextInt(); //배추가 심어져있는 위치의 개수 (1<=K<=2500)
			int cabbage_Place[][] = new int[M][N];
			boolean Visited[][] = new boolean[M][N];
			Queue<int[]> q = new LinkedList<int[]>();
			
			for (int j = 0; j < K; j++) { //배추의 위치 저장쓰
				int X = sc.nextInt();
				int Y = sc.nextInt();
				cabbage_Place[X][Y] = 1;
			}
			
			for (int a = 0; a < M; a++) {
				for (int b = 0; b < N; b++) {
					if (cabbage_Place[a][b] == 1 && Visited[a][b] == false) {
						q.offer(new int[] {a, b});
						Visited[a][b] = true;
						answer[i]++;
						while (!q.isEmpty()) {
							int temp[] = q.poll();
							int tempX = temp[0];
							int tempY = temp[1];
							
							if (0 <= tempX -1 && cabbage_Place[tempX -1][tempY] == 1 && Visited[tempX -1][tempY] == false) {
								cabbage_Place[tempX -1][tempY] = 0;
								Visited[tempX -1][tempY] = true;
								q.offer(new int[] {tempX -1, tempY});
							}
							
							if (tempX + 1 < M && cabbage_Place[tempX + 1][tempY] == 1 && Visited[tempX + 1][tempY] == false) {
								cabbage_Place[tempX + 1][tempY] = 0;
								Visited[tempX + 1][tempY] = true;
								q.offer(new int[] {tempX + 1, tempY});
							}
								
							if (0 <= tempY -1 && cabbage_Place[tempX][tempY -1] == 1 && Visited[tempX][tempY -1] == false) {
								cabbage_Place[tempX][tempY -1] = 0;
								Visited[tempX][tempY -1] = true;
								q.offer(new int[] {tempX, tempY -1});
							}
							
							if (tempY + 1 < N && cabbage_Place[tempX][tempY + 1] == 1 && Visited[tempX][tempY + 1] == false) {
								cabbage_Place[tempX][tempY + 1] = 0;
								Visited[tempX][tempY + 1] = true;
								q.offer(new int[] {tempX, tempY + 1});
							}
							
						}
					}
				}
			}
		}
		
		for (int q = 0; q < Testcase; q++) System.out.println(answer[q]);
	}

}
