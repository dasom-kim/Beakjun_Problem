import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main { // BFS
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] Maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				Maze[i][j] = Integer.parseInt(temp.substring(j, j + 1));
			}
		}
		Maze[0][0] = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] dist = new int[N][M];
		dist[0][0] = 1;
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] Position = q.poll();
			int a = Position[0];
			int b = Position[1];
			if (Position[0] + 1 < N && b < M && Maze[a + 1][b] == 1) { // 아래
				q.offer(new int[] { a + 1, b });
				Maze[a + 1][b] = 0;
				dist[a + 1][b] = dist[a][b] + 1;
			}
			if (a - 1 >= 0 && b >= 0 && Maze[a - 1][b] == 1) { // 위
				q.offer(new int[] { a - 1, b });
				Maze[a - 1][b] = 0;
				dist[a - 1][b] = dist[a][b] + 1;
			}
			if (a < N && b + 1 < M && Maze[a][b + 1] == 1) { // 오른쪽
				q.offer(new int[] { a, b + 1 });
				Maze[a][b + 1] = 0;
				dist[a][b + 1] = dist[a][b] + 1;
			}
			if (a >= 0 && b - 1 >= 0 && Maze[a][b - 1] == 1) { // 왼쪽
				q.offer(new int[] { a, b - 1 });
				Maze[a][b - 1] = 0;
				dist[a][b - 1] = dist[a][b] + 1;
			}
		}
		System.out.print(dist[N - 1][M - 1]);
	}
}
