package homework;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
//map	
	HashMap<String, Phone> map1 = new HashMap<>();
	/*
	 문제) 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고, 이 Phone클래스를 이용하여 
	  전화번호 정보를 관리하는 프로그램을 완성하시오.
	  이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	  
	  전체의 전화번호 정보는 Map을 이용하여 관리한다.
	  (key는 '이름'으로 하고 value는 'Phone클래스의 인스턴스'로 한다.)


	실행예시)
	===============================================
   	전화번호 관리 프로그램(파일로 저장되지 않음)
	===============================================

  	메뉴를 선택하세요.
  	1. 전화번호 등록
  	2. 전화번호 수정
  	3. 전화번호 삭제
  	4. 전화번호 검색
  	5. 전화번호 전체 출력
  	0. 프로그램 종료
  	번호입력 >> 1  <-- 직접 입력
  
  	새롭게 등록할 전화번호 정보를 입력하세요.
  	이름 >> 홍길동  <-- 직접 입력
  	전화번호 >> 010-1234-5678  <-- 직접 입력
  	주소 >> 대전시 중구 대흥동 111  <-- 직접 입력
  
  	메뉴를 선택하세요.
  	1. 전화번호 등록
  	2. 전화번호 수정
  	3. 전화번호 삭제
  	4. 전화번호 검색
  	5. 전화번호 전체 출력
  	0. 프로그램 종료
  	번호입력 >> 5  <-- 직접 입력
  
  	=======================================
  	번호   이름       전화번호         주소
  	=======================================
   	1    홍길동   010-1234-5678    대전시
   	~~~~~
   
  	=======================================
  	출력완료...
  
  	메뉴를 선택하세요.메뉴를 선택하세요.
  	1. 전화번호 등록
  	2. 전화번호 수정
  	3. 전화번호 삭제
  	4. 전화번호 검색
  	5. 전화번호 전체 출력
  	0. 프로그램 종료
  	번호입력 >> 0  <-- 직접 입력
  
  	프로그램을 종료합니다...
	 */
	
	
	public static void main(String[] args) {
		PhoneBookTest ready = new PhoneBookTest();
		ready.start();
		
	}
	
	public void start() {
		Scanner s = new Scanner(System.in);
		
		
		do {
		System.out.println("===============================================");
		System.out.println("전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("===============================================");
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("번호 입력 >>");
		int menu = s.nextInt();
		switch (menu) {
		case 1: // 전화번호 등록
			insert();
			break;
		case 2: // 수정
			update();
			break;
		case 3: // 삭제
			delete();
			break;
		case 4: // 검색
			select();
			break;
		case 5: // 전체출력
			all();
			break;
		case 0: //종료
			
			return;

		}
		}while(true);
	}
	public void insert(){//등록
		Scanner s_s = new Scanner(System.in);
		Phone pho = new Phone();
		
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름을 입력하세요.>>");
		pho.setName(s_s.nextLine());
		System.out.println("전화번호를 입력하세요.>>");
		pho.setPhone(s_s.nextLine());
		System.out.println("주소를 입력하세요.>>");
		pho.setAdd(s_s.nextLine());
		map1.put(pho.getName(), pho);

		
	}
	public void update() {//수정
		Phone pho = new Phone();
		Scanner s_s = new Scanner(System.in);
		System.out.println("수정할 전화번호의 이름을 입력하세요.>>");
		String name = s_s.nextLine();
			System.out.println("수정할 전화 번호를 입력하세요. >>");
			String ph= s_s.nextLine();
			
			Phone check = map1.get(name);
			if(check != null) {
				check.setPhone(ph);
				System.out.println("전화번호 수정 완료");
		}else {
			System.out.println("해당하는 정보가 없습니다.");
		}
		print();
		
	}
	public void delete() {//삭제
		Scanner s_s = new Scanner(System.in);
		
		System.out.println("삭제할 전화번호의 이름을 입력하세요.>>");
		String name = s_s.nextLine();
		if(map1.containsKey(name)) {
			map1.remove(name);
		}else {
			System.out.println("해당하는 정보가 없습니다.");
		}
		print();
	}
	public void select() {//검색
		Scanner s_s = new Scanner(System.in);
		
		System.out.println("찾으실 전화번호의 이름을 입력하세요.>>");
		String name = s_s.nextLine();
		if(map1.containsKey(name)) {
			System.out.println("=========================================================================");
			System.out.println("이름\t" + "\t전화번호\t" + "\t주소\t");
			System.out.println(name + "\t\t" + map1.get(name).getPhone() + "\t\t" + map1.get(name).getAdd());
			System.out.println("=========================================================================");
		}
				
		
	}
	public void all() {//전체 출력
		int num = 1;
		System.out.println("=========================================================================");
		System.out.println("번호\t" + "이름\t" + "\t전화번호\t" + "\t주소\t");
		for(Phone values : map1.values()) {
			System.out.println((num++) + "\t" + values.getName() + "\t\t" + values.getPhone() + "\t\t" + values.getAdd());
		}
		System.out.println("=========================================================================");
	}
	
	public void print() { //출력용
		System.out.println("=========================================================================");
		System.out.println("이름\t" + "\t전화번호\t" + "\t주소\t");
		for(Phone values : map1.values()) {
			System.out.println(values.getName() + "\t\t" + values.getPhone() + "\t\t" + values.getAdd());
		}
		System.out.println("=========================================================================");
	}

}





class Phone {
	private String name;
	private String add;
	private String phone;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	}


