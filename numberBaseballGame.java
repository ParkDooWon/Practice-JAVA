import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class makeNumbers {
	Scanner input = new Scanner(System.in);
	Random random = new Random();
	String myStringNumbers;
	int[] RandomNumbers = new int[3];
	int[] myIntNumbers = new int[3];
	int strike = 0, ball = 0, retry;

	public void checkStrike(int i) {
		if (RandomNumbers[i] == myIntNumbers[i])
			strike++;
	}

	public void checkBall(int i) {
		for (int j = 0; j < RandomNumbers.length; j++) {
			if (i == j) {
			}
			else if (myIntNumbers[i] == RandomNumbers[j])
				ball++;
		}
	}

	public void Count() {
		for (int i = 0; i < RandomNumbers.length; i++)
			checkStrike(i);
		for (int i = 0; i < RandomNumbers.length; i++)
			checkBall(i);
	}

	public void printCount() {
		if (strike == 0 && ball == 0)
			System.out.println("Nothing");
		else if (strike > 0 && ball > 0)
			System.out.println(strike + " ��Ʈ����ũ " + ball + "��");
		else if (strike > 0)
			System.out.println(strike + "��Ʈ����ũ");
		else if (ball > 0)
			System.out.println(ball + "��");
	}

	public void getNums() {
		strike = ball = 0;
		System.out.print("���ڸ� �Է����ּ��� : ");
		System.out.println("now String : " + myStringNumbers);
		myStringNumbers = input.nextLine();
		input.nextLine();
		System.out.println("length of String = " + myStringNumbers.length());
		for (int i = 0; i < 3; i++)
			myIntNumbers[i] = Integer.parseInt(
				myStringNumbers.substring(i, i + 1));    //ó���� �Ǵµ� �ٽ� �����ϸ� String index out of range : 1 ���� �߻�
		Count();
		printCount();
	}

	public boolean checkOverlap(int tmp) {
		for (int randomNumber : RandomNumbers)
			if (tmp == randomNumber)
				return true;
		return false;
	}

	public void makeRandomNumbers() {
		int tmp;
		for (int i = 0; i < 3; i++) {
			tmp = random.nextInt(10);
			while (checkOverlap(tmp))
				tmp = random.nextInt(10);
			RandomNumbers[i] = tmp;
		}
		System.out.print("RandomNums : ");
		for (int i = 0; i < 3; i++)
			System.out.print(RandomNumbers[i]);
		System.out.println();
	}

	public void init() {
		Arrays.fill(RandomNumbers, -1);
		Arrays.fill(myIntNumbers, 0);
		myStringNumbers = null;
	}

	public boolean startGame() {
		init();
		makeRandomNumbers();
		strike = ball = 0;
		while (strike < 3)
			getNums();
		System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ��������");
		System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		retry = input.nextInt();
		return retry == 1;
	}
}

public class numberBaseballGame {
	public static void main(String[] args) {

		makeNumbers m = new makeNumbers();
		//while(m.startGame());
		String s;
		Scanner sc = new Scanner(System.in);
		while (true) {
			s = null;
			s = sc.nextLine();
			for (int i = 0; i < 3; i++)
				System.out.println(Integer.parseInt(s.substring(i, i + 1)));
		}
		//System.out.println("����Ǿ����ϴ�.");
	}
}