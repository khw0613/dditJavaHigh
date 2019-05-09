package homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
//set
public class Lotto {
	/*
	 * 로또를 구매하는 프로그램 작성하기
	 * 
	 * 사용자는 로또를 구매할 때 구매할 금액을 입력하고 입력한 금액에 맞게 로또번호를 출력한다.
	 * (단, 로또 한장의 금액은 1000원이고 거스름돈도 계산하여 출력한다.)
	 * 
	 * ==========================
	 *       Lotto 프로그램
	 * --------------------------
	 * 1. Lotto 구입
	 * 2. 프로그램 종료
	 * ==========================
	 * 메뉴선택 : 1 <-- 입력
	 * 
	 * Lotto 구입 시작
	 * 
	 * (1000원에 로또번호 하나입니다.)
	 * 금액 입력 : 2500 <-- 입력
	 * 
	 * 행운의 로또번호는 아래와 같습니다.
	 * 로또번호1 : 2,3,4,5,6,7
	 * 로또번호2 : 20,21,22,23,24,25
	 * 
	 * 받은 금액은 2500원이고 거스름돈은 500원입니다.
	 * 
	 * ==========================
	 *       Lotto 프로그램
	 * --------------------------
	 * 1. Lotto 구입
	 * 2. 프로그램 종료
	 * ==========================
	 * 메뉴선택 : 2 <-- 입력
	 * 
	 * 감사합니다
	 */
	Scanner scan = new Scanner(System.in);
	boolean isContinue = true;
	int money; //입력할 금액
	int remoney;//거스름돈
	int[] lotto;
	public void menu(){
		while(isContinue) {
			System.out.println("================");
			System.out.println("Lotto 프로그램");
			System.out.println("----------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("================");
			switch (except()) {
			case 1:
				buy();
				break;
			case 2:
				System.out.println("감사합니다.");
				isContinue = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	//로또 구입
	public void buy() {
		money = 0;
		System.out.println("Lotto 구입 시작");
		System.out.println("1000원에 로또번호 하나입니다.");
		System.out.println("돈을 입력하세요");
		money = scan.nextInt();//금액 입력
		remoney = money%1000;//거스름돈
		
		System.out.println();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i = 0; i < money/1000; i++) {
			System.out.println("로또번호"+ (i+1) + ": ");
			lotto();
			System.out.println();
		}
		System.out.println("받은금액은" + money+"원이고" +
						"거스름돈은" + remoney +"원 입니다.");
		
		
		
	}
	//로또 배열 생성
	public void lotto() {
		Set<Integer> lot = new HashSet<>();
		while(lot.size() < 6) {
			lot.add((int)(Math.random() * 45 + 1));
		}
			Iterator<Integer> hi = lot.iterator();
			int i = 0; //첨자역할
			lotto = new int[6];
			while(hi.hasNext()) {
				lotto[i++] = hi.next();
			}
			
			int cnt = 0;
			for(int num : lotto) {
				if(cnt == 0) {
					System.out.print(num);
				}else {
					System.out.print("," + num);
				}
				cnt++;
			}
	}
		
	//예외처리
	public int except() {
		while(true)
			try {
				System.out.println("메뉴 선택: ");
				int num = scan.nextInt();
				return num;
			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요!");
				scan = new Scanner(System.in);
			}
		
	}
	

	public static void main(String[] args) {
		Lotto t = new Lotto();
		t.menu();

	}

}
