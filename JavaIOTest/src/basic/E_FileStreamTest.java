package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class E_FileStreamTest {

	public static void main(String[] args) {

		//FileInputStram객체를 이용한 파일 내용 읽어오기
		FileInputStream fin = null;//스트림 선언
		
		try {
			//방법 1 (파일정보를 문자열로 지정하기)
//			fin = new FileInputStream("d:/D_Other/sample.txt");//생성
			fin = new FileInputStream("/Users/macbook/D_Other/sample.txt");//생성
			
			//방법 2 (파일정보를 file객체를 이용하여 지정하기)
//			File file = new File("d:/D_Other/sample.txt");
			File file = new File("/Users/macbook/D_Other/sample.txt");
			fin = new FileInputStream(file);//생성
		
			int c; //읽어온 데이터를 저장할 변수
			
			//읽어온 값이 -1이면 파일의 끝까지 읽었다는 의미이다.
			while((c=fin.read())!=-1) {
				//읽어온 자료 출력
				System.out.println((char)c);
			}
			fin.close();//작업 완료 후 스트림 닫기
		} catch (FileNotFoundException e) {
			System.out.println("지정할 파일이 없습니다.");
		} catch (Exception e) {
			System.out.println("알수 없는 입출력 오류입니다.");
		}
	}

}
