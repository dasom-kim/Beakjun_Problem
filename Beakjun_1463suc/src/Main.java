import java.util.Scanner;

class Main {
	static int ori_N = 0;
	static int t_ans = 0;
	public static void main(String args[]) throws Exception	{    
		Scanner sc = new Scanner(System.in);
		int N;
		int answer = 0;
		ori_N = N = sc.nextInt();
		if (N > 1) {
			answer = Calculate(N, 0);
		} else if (N == 1) {
			answer = 0;
		}
		System.out.println(answer);
	}
	
	public static int Calculate(int N, int answer) {
		if (N == 1) {
			if (t_ans == 0 || t_ans > answer) t_ans = answer;
			return answer;
		} else {
			if (t_ans != 0 && t_ans < answer + 1) return ori_N;
			int temp1 = ori_N, temp2 = ori_N, temp3 = ori_N;
			if (N % 3 == 0) {
				temp1 = Calculate(N/3, answer + 1);
			}
			if (N % 2 == 0) {
				temp2 = Calculate(N/2, answer + 1);
			}
			temp3 = Calculate(N-1, answer + 1);
			int out_answer = Math.min(Math.min(temp1, temp2), temp3);
			return out_answer;
		}
	}
}