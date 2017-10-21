import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] dirN = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // �Ʒ�, ��, ��, ��;
		int[][] dirE = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // �Ʒ�, ��, ��, ��;
		int[][] dirS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // �Ʒ�, ��, ��, ��;
		int[][] dirW = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // �Ʒ�, ��, ��, ��;
		int[] direction = { 3, 0, 1, 2 }; // 0, 1, 2, 3�� ���� �����

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int nowx = sc.nextInt(), nowy = sc.nextInt(), d = sc.nextInt(); // d = 0(��), d = 1(��), d = 2(��), d = 3(��)
		int[][] CleanBase = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				CleanBase[i][j] = sc.nextInt();
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { nowx, nowy, d, 0 });
		CleanBase[nowx][nowy] = 2;
		int answer = 1;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int tempx = temp[0], tempy = temp[1], tempd = temp[2], tempcount = temp[3];
			int[][] tempdir;

			if (tempd == 0) {
				tempdir = dirN;
			} else if (tempd == 1) {
				tempdir = dirE;
			} else if (tempd == 2) {
				tempdir = dirS;
			} else {
				tempdir = dirW;
			}

			int newdir = direction[tempd]; // ���� �������� ȸ��
			if (tempcount < 4 && 0 <= tempx + tempdir[2][0] && tempx + tempdir[2][0] < N && 0 <= tempy + tempdir[2][1]
					&& tempy  + tempdir[2][1] < M) { // ���� ������ ���� Ž�� ����
				if (CleanBase[tempx + tempdir[2][0]][tempy + tempdir[2][1]] == 0) { // û���� ���� ���� ���
					CleanBase[tempx + tempdir[2][0]][tempy + tempdir[2][1]] = 2; // û�� �Ϸ�
					answer++;
					q.offer(new int[] { tempx + tempdir[2][0], tempy + tempdir[2][1], newdir, 0 });
				} else {
					q.offer(new int[] { tempx, tempy, newdir, tempcount + 1 });
				}
			} else if (tempcount == 4) {
				if (0 < tempx + tempdir[0][0] && tempx + tempdir[0][0] < N - 1 && 0 < tempy + tempdir[0][1]
						&& tempy + tempdir[0][1] < M - 1 && CleanBase[tempx + tempdir[0][0]][tempy + tempdir[0][1]] != 1) { // ������ �� ������
					q.offer(new int[] { tempx + tempdir[0][0], tempy + tempdir[0][1], tempd, 0 });
				} else {
					break;
				}
			}
		}

		System.out.println(answer);
	}

}
