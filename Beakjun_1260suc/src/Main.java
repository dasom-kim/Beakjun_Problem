import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] Visited;
	static int N, M, V;
	static int[][] Vertex;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		Vertex = new int[N+1][N+1];
		Visited = new boolean[N+1];
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Vertex[a][b] = 1;
			Vertex[b][a] = 1;
		}
		Visited[V] = true;
		DFS(V);
		System.out.println();
		for (int i = 1; i <= N; i++) Visited[i] = false;
		BFS(V);
	}
	public static void DFS(int Point) {
		System.out.print(Point+" ");
		for (int i = 1; i <= N; i++) {
			if (Vertex[Point][i] == 1 && Visited[i] == false) {
				Visited[i] = true;
				DFS(i);
			}
		}
	}
	public static void BFS(int Point) {
		System.out.print(Point+" ");
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(Point);
		Visited[V] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i <= N; i++) {
				if (Vertex[temp][i] == 1 && Visited[i] == false) {
					System.out.print(i+" ");
					Visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
