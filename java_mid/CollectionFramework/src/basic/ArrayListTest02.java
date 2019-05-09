package basic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class ArrayListTest02 {
	// 문제) 5명의 사람 이름을 입력하여 ArrayList에 저장하고 이 중에 '김'씨 성의 이름을 출력하시오.
	//	(단, 입력은 Scanner를 이용하여 입력받는다.)
	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		System.out.println("5명의 이름을 입력하세요");
		for(int i = 1 ; i <= 5; i ++) {
			System.out.println(i + "번째 이름 : ");
			String name = s.next();
			nameList.add(name);
			}
		System.out.println();
		System.out.println("김씨 성을 가진 사람들");
		for(int i = 0; i<nameList.size(); i++) {
			String name = nameList.get(i);
			
			if(name.startsWith("김")) {
				System.out.println(name);
			}
//			if(name.indexOf("김") == 0) {
//				System.out.println(name);
//			}
		}
		
			
		}
}

	

