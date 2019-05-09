package homework;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	HashMap<String, room> map1 = new HashMap<>();
	public static void main(String[] args) {
		Hotel ready = new Hotel();
		ready.start();
	}
	public void start() {//시작
		Scanner s = new Scanner(System.in);
		
		
		do {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.print("1.체크인 ");
		System.out.print(" 2.체크아웃 ");
		System.out.print(" 3.객실상태 ");
		System.out.println(" 4.업무종료");
		System.out.println("*******************************************");
		System.out.println("메뉴선택 =>");
		int menu = s.nextInt();
		switch (menu) {
		case 1: // 1.체크인
			check();
			break;
		case 2: // 2.체크아웃
			checkOut();
			break;
		case 3: // 3.객실상태
			roomInfo();
			break;
		case 4: //종료
			
			return;

		}
		}while(true);
	}
	public void check() { // 체크인
		Scanner s = new Scanner(System.in);
		room input = new room();
		System.out.println("어느방에 체크인 하시겠습니까?");
		input.setNum(s.nextLine());// 방번호		
		
		if(map1.containsKey(input.getNum())) {
			System.out.println(input.getNum()+"번 방이 이미 대여중입니다.");
			return;
		}
		
		
		System.out.println("누구를 체크인 하시겠습니까?");
		input.setName(s.nextLine());//이름
		
		
//		if(roomnumCheck(input.getNum())) {
//			System.out.println(input.getNum()+"번 방이 이미 대여중입니다.");
//			return;
//		}
		
		
		map1.put(input.getNum(), input);
		System.out.println(input.getNum()+"번 방이 체크인 되었습니다.");
			

	}
	public void checkOut() { //체크아웃
		Scanner s = new Scanner(System.in);
		
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		String out = s.nextLine();
		if(map1.containsKey(out)) {
			map1.remove(out);
		}else {
			System.out.println(out + " 번 방에는 체크인한 사람이 없습니다.");
		}
		
	}
	public void roomInfo() { //객실상태
		for(room values : map1.values()) {
			System.out.println("방번호 : " + values.getNum() + " 투숙객 : " + values.getName());
		}
		System.out.println();
		
	}
	
	public boolean roomnumCheck(String roomnum) {
		Set<String> mapKey = map1.keySet();
		boolean check=false;
			
			
		for(String key : mapKey) {
			if(key == roomnum) {
				check=true;
			}
		}
		
			
		return check;
	}
	
}
class room{
	private String num; //방번호
	private String name; //이름
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}