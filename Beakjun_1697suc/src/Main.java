import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int minimumSec = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈이 위치
		int K = sc.nextInt(); // 동생 위치
		
		minimumSec = Math.abs(N-K);
		boolean[] Check = new boolean[100001];

		if (N < K && minimumSec != 0) {
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] { N, 0 });

			while (!q.isEmpty()) {
				int[] temp_Place = q.poll();
				int tempPla = temp_Place[0];
				int tempSec = temp_Place[1];
				if (tempPla == K) {
					minimumSec = tempSec;
					break;
				} else if (minimumSec > tempSec + 1) {
					if (tempPla + 1 <= 100000 && Check[tempPla + 1] == false) {
						q.offer(new int[] { tempPla + 1, tempSec + 1 });
						Check[tempPla + 1] = true;
					}
					if (tempPla - 1 > 0 && Check[tempPla - 1] == false) {
						q.offer(new int[] { tempPla - 1, tempSec + 1 });
						Check[tempPla - 1] = true;
					}
					if (tempPla * 2 <= 100000 && Check[tempPla * 2] == false) {
						q.offer(new int[] { tempPla * 2, tempSec + 1 });
						Check[tempPla * 2] = true;
					}
				}
			}
		}

		System.out.println(minimumSec);
	}

}
