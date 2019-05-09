package homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Baseball {

	ArrayList<Integer> num = new ArrayList<>();		// 3개의 난수 저장
	ArrayList<Integer> user = new ArrayList<>();	// 3개의 입력 받은 값 저장
	
	int strike;	// 스트라이크 개수
	int ball;	// 볼 개수
	
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Baseball base = new Baseball();
		base.gameStart();
	}
	
	// 3개의 난수 저장
	public void getRndNum() {
		Set<Integer> bbNum = new HashSet<>();
		
		//10개의 난수를 발생
		while (bbNum.size() < 3) {
			bbNum.add((int) (Math.random() * 9) + 1);
		}
		
		Iterator<Integer> it = bbNum.iterator();
		
		while (it.hasNext()) {
			num.add(it.next());
		}
		
		// 데이터 섞기
		for (int j = 1; j <= 100; j++) {
			int rnd = (int) (Math.random() * num.size());	// 0~2 사이의 인덱스 난수
			int temp = num.get(0);
			num.set(0, num.get(rnd));
			num.set(rnd, temp);
		}
	}
	
	// 입력 받은 3개의 정수 저장
	public void inputNum() {
		int n1, n2, n3;
		
		do {
			System.out.println("중복되지 않는 정수 3개 입력 => ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			if (n1 == n2 || n1 == n3 || n2 == n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력해 주세요.");
			}
		} while(n1 == n2 || n1 == n3 || n2 == n3);
		
		//중복되지 않으면 저장
		if (user.size() == 0) {
			user.add(n1);
			user.add(n2);
			user.add(n3);
		}
		else {
			user.set(0, n1);
			user.set(1, n2);
			user.set(2, n3);
		}
	}
	
	// 스트라이크, 볼 개수
	public void ballCount()	 {
		strike = 0;
		ball = 0;
		
		for (int i = 0; i < num.size(); i++) {
			for (int j = 0; j < user.size(); j++) {
				if (num.get(i) == user.get(j)) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}
		
		System.out.println(user.get(0) + " " + user.get(1) + " " + user.get(2) + " ==> " + strike + "S" + ball + "B");
	}
	
	// 게임 시작
	public void gameStart() {
		getRndNum();
		
		System.out.println("난수값 => " + num.get(0) + " " + num.get(1) + " " + num.get(2));
		
		int cnt = 0; // 몇번 만에 맞췄는지 저장
		
		do {
			cnt++;
			inputNum();
			ballCount();
		} while(strike != 3);
		
		System.out.println(cnt + "번째 만에 맞췄군요!");
	}
}
