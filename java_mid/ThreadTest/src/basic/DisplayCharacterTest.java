package basic;
/*
 * 3명의 쓰레드가 각각 알팞 대문자를 출력하는데
 * 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
 * 
 */
public class DisplayCharacterTest {
	public static String strRank = ""; //순위 매길려고 만든것
	
	public static void main(String[] args) {
		DisplayCharacter[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("강현욱"),
				new DisplayCharacter("이대용"),
				new DisplayCharacter("김도현")
		};
		
		for(int i = 0; i < disChars.length; i++) {
			disChars[i].start();
		}
		for(DisplayCharacter dc : disChars) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("경기 끝.....");
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위 : " + strRank);
	}
}
//영어 대문자를 출력하는 메서드
class DisplayCharacter extends Thread {
	private String name;
	
	//생성자 
	public DisplayCharacter(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(char ch='A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력 문자 : " + ch);;
			try {
				//sleep()메서드의 값을 200~500사이의 난수로 한다.
				Thread.sleep((int)Math.random() * 200 + 100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " 출력 끝 ...");
		DisplayCharacterTest.strRank += name + " ";
	}
	
}