import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class makeNumbers {
	Scanner input = new Scanner(System.in);
	Random random = new Random();
	String myStringNumbers;
	int[] RandomNumbers = new int[3];
	int[] myIntNumbers = new int[3];
	int strike=0, ball=0, retry;
	
	public void checkStrike(int i) {
		if(RandomNumbers[i] == myIntNumbers[i]) strike++;
	}
	public void checkBall(int i) {
		for(int j=0;j<RandomNumbers.length;j++) {
			if(i==j) continue;
			else if (myIntNumbers[i] == RandomNumbers[j]) ball++;
		}
	}
	public void Count() {
		for(int i=0;i<RandomNumbers.length;i++) checkStrike(i);
		for(int i=0;i<RandomNumbers.length;i++) checkBall(i);
	}
	public void printCount() {
		if(strike == 0 && ball == 0) System.out.println("Nothing");
		else if(strike > 0 && ball > 0) System.out.println(strike+" 스트라이크 "+ball+"볼");
		else if(strike > 0) System.out.println(strike + "스트라이크");
		else if(ball > 0) System.out.println(ball + "볼");
	}
	public void getNums() {
		strike = ball = 0;
		System.out.print("숫자를 입력해주세요 : ");
		System.out.println("now String : "+ myStringNumbers);
		myStringNumbers = input.nextLine();
		input.nextLine();
		System.out.println("length of String = "+myStringNumbers.length());
		for(int i=0;i<3;i++) 
			myIntNumbers[i] = Integer.parseInt(myStringNumbers.substring(i,i+1));	//처음엔 되는데 다시 시작하면 String index out of range : 1 오류 발생
		Count();
		printCount();
	}	
	
	public boolean checkOverlap(int tmp) {
		for(int i=0;i<RandomNumbers.length;i++) if(tmp==RandomNumbers[i]) return true;
		return false;
	}
	
	public void makeRandomNumbers() {
		int tmp;
		for(int i=0;i<3;i++) {
			tmp = random.nextInt(10);
			while (checkOverlap(tmp)) tmp=random.nextInt(10);
			RandomNumbers[i]=tmp;
		}
		System.out.print("RandomNums : ");
		for(int i=0;i<3;i++) System.out.print(RandomNumbers[i]);
		System.out.println();
	}
	public void init() {
		Arrays.fill(RandomNumbers, -1);
		Arrays.fill(myIntNumbers, 0);
		myStringNumbers=null;
	}
	public boolean startGame() {
		init();
		makeRandomNumbers();
		strike = ball = 0;
		while(strike < 3) 
			getNums();
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		retry = input.nextInt();
		if(retry == 1) return true;
		return false;
	}
}

public class numberBaseballGame {
	public static void main(String[] args) {
		
		makeNumbers m = new makeNumbers();
		//while(m.startGame());
		String s;
		Scanner sc = new Scanner(System.in);
		while(true) {
			s=null;
			s = sc.nextLine();
			for(int i=0;i<3;i++)
				System.out.println(Integer.parseInt(s.substring(i,i+1)));
		}
		//System.out.println("종료되었습니다.");
	}
}