import java.util.Scanner;

public class Main {
	static int[][] Graph_Info;
	static int[][] Graph_Ans;
	static boolean[] Visited;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Graph_Info = new int[N][N];
		Graph_Ans = new int[N][N];
		Visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Graph_Info[i][j] = sc.nextInt();
				Graph_Ans[i][j] = -1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Graph_Ans[i][j] == -1) {
					Graph_Ans[i][j] = 0;
					DFS(i, i, j, 0);
					Visited = new boolean[N];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(Graph_Ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void DFS(int x, int mid, int y, int step) {
		if (mid == y && step != 0) {
			Graph_Ans[x][y] = 1;
		} else {
			for (int i = 0; i < N; i++) {
				if (Graph_Info[mid][i] == 1 && Visited[i] == false) {
					Visited[i] = true;
					if (x == y && step == 0)
						Visited[i] = false;
					DFS(x, i, y, step + 1);
				}
			}
		}
	}

}
