import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int full_Tomato = 0, half_Tomato = 0, empty_Tomato = 0;
	static int[][] Visited;
	static int[][] dir = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 2<=M,N<=1000
		int N = sc.nextInt();
		int[][] Tomato_Info = new int[N][M]; // M은 가로 칸의 수(열), N은 세로 칸의 수(행)
		Visited = new int[N][M];
		int[][] full_Days = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();

		// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 들어있지 않은 곳
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Tomato_Info[i][j] = sc.nextInt();
				if (Tomato_Info[i][j] == 1) {
					full_Tomato++;
					q.offer(new int[] { i, j });
				} else if (Tomato_Info[i][j] == 0) {
					half_Tomato++;
					full_Days[i][j] = -1;
				}
				else {
					empty_Tomato++;
				}
			}
		}

		int temp_Tomato = half_Tomato;
		int answer = 0;

		if (full_Tomato > 0 && temp_Tomato != 0) {
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				int a = temp[0];
				int b = temp[1];

				if (full_Days[a][b] > answer)
					answer = full_Days[a][b];

				if (a + dir[0][0] >= 0 && Visited[a + dir[0][0]][b] == 0 && Tomato_Info[a + dir[0][0]][b] != -1 && full_Days[a + dir[0][0]][b] == -1) {
					q.offer(new int[] { a + dir[0][0], b });
					Visited[a + dir[0][0]][b] = 1;
					full_Days[a + dir[0][0]][b] = full_Days[a][b] + 1;
					temp_Tomato--;
				}

				if (b + dir[1][1] >= 0 && Visited[a][b + dir[1][1]] == 0 && Tomato_Info[a][b + dir[1][1]] == 0 && full_Days[a][b + dir[1][1]] == -1) {
					q.offer(new int[] { a, b + dir[1][1] });
					Visited[a][b + dir[1][1]] = 1;
					full_Days[a][b + dir[1][1]] = full_Days[a][b] + 1;
					temp_Tomato--;
				}

				if (a + dir[2][0] < N && Visited[a + dir[2][0]][b] == 0 && Tomato_Info[a + dir[2][0]][b] == 0 && full_Days[a + dir[2][0]][b] == -1) {
					q.offer(new int[] { a + dir[2][0], b });
					Visited[a + dir[2][0]][b] = 1;
					full_Days[a + dir[2][0]][b] = full_Days[a][b] + 1;
					temp_Tomato--;
				}

				if (b + dir[3][1] < M && Visited[a][b + dir[3][1]] == 0 && Tomato_Info[a][b + dir[3][1]] == 0 && full_Days[a][b + dir[3][1]] == -1) {
					q.offer(new int[] { a, b + dir[3][1] });
					Visited[a][b + dir[3][1]] = 1;
					full_Days[a][b + dir[3][1]] = full_Days[a][b] + 1;
					temp_Tomato--;
				}
			}
		}

		if (temp_Tomato > 0) {
			answer = -1;
		}

		System.out.println(answer);
	}

}
