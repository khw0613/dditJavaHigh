package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class N_ObjectStreamTest {

	public static void main(String[] args) {
		// Member인스턴스 생성
		Member mem1 =  new Member("김도현", 20, "대구시 수성구");
		Member mem2 =  new Member("이대용", 25, "부산시 사하구");
		Member mem3 =  new Member("강현욱", 30, "서울시 강남구 대치동");
		Member mem4 =  new Member("김현지", 18, "대전시 중구 대흥동");
		
		try {
			//객체를 파일에 저장하기
			
			//출력용 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(
//					new BufferedOutputStream(
//							new FileOutputStream("d:/D_Other/memOjb.bin")));
			new BufferedOutputStream(
					new FileOutputStream("/Users/macbook/D_Other/memOjb.bin")));
			
			//쓰기 작업
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			System.out.println("쓰기 작업 완료");
			oos.close();
			
			//=====================================
			
			//저장 객체를 읽어와 출력하기
			
			//입력용 스트림 객체 생성
//			ObjectInputStream ois = 
//					new ObjectInputStream(
//							new BufferedInputStream(new FileInputStream("d:/D_Other/memObj.bin")))
					ObjectInputStream ois = 
					new ObjectInputStream(
							new BufferedInputStream(new FileInputStream("/Users/macbook/D_Other/memObj.bin")));
			Object obj = null;
			 try {
				 while((obj=ois.readObject()) !=null) {
					 //읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
					 Member mem = (Member)obj;
					 System.out.println("이름 : " + mem.getName());
					 System.out.println("나이 : " + mem.getAge());
					 System.out.println("주소 : " + mem.getAddr());
					 System.out.println("====================================================");
					 
				 }
			 }catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
					
		} catch (IOException e) {
			e.printStackTrace();
			//더이상 읽어올 객체가 없으면 예외 발생함.
			System.out.println("출력 작업끝..");
		}
	}

}

class Member implements Serializable{ //자바는 Serializable 인터페이스를
									 // 구현한 클래스만 직렬화 가능.
	//transient => 직렬화가 되지 않을 멤버 변수에 지정 한다.
	//				(* static 필드도 직렬화가 되지 않는다.)
	//				직렬화가 되지 않는 멤버 변수는 기본값으로 저장된다.
	//				(참조형 변수 : null, 숫자형 변수 : 0)
	
	private String name;
	private transient int age;
	private String addr;
	
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}