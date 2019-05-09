package basic.d03;

public class SingtonTest {
	public static void main(String[] args) {
		//MySingleton test1 = new MySingleton(); //new명령 사용 불가
		
		//getInstance()메서드 이용하여 객체 생성
		MySingleton test2 =  MySingleton.getInstance();
		
		test2.displayTest();
		
		MySingleton test3 = MySingleton.getInstance();
		System.out.println("test2 =>" + test2);
		System.out.println("test3 =>" + test3);
		
	}
}
