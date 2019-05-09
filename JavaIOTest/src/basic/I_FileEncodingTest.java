package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class I_FileEncodingTest {

	public static void main(String[] args) {
		//파일 인코딩을 이용하여 읽어오기
		//InputStreamReader 스트림 -> 바이트 기반 스트림을 문자기반 스트림	
		//							으로 변환해 주는 보조 스트림.
		
		FileInputStream fin = null;
		InputStreamReader isr = null;
		
		try {
			/*
			 * FileInputStream 객체를 생성한 후 이 객체를 매개변수로 받는 
			 * InputStreamReader객체를 생성한다.
			 * (바이트 입력 스트림에 연결되어 문자 입력 스트림인 Reader로 변환
			 * 시키는 보조스트림)
			 */
//			fin = new FileInputStream("d:/D_Other/test_utf8.txt");
//			fin = new FileInputStream("d:/D_Other/test_ansi.txt");
			fin = new FileInputStream("/Users/macbook/D_Other/test_utf8.txt");
//			fin = new FileInputStream("/Users/macbook/D_Other/test_ansi.txt");
			
			/*
			 * InputStreamReader객체는 파일의 인코딩 방식을 지정할 수 있다.
			 * 형식) new InputStreamReader(바이트 기반 스트림 객체, 인코딩 방식)
			 * 
			 * 인코딩 방식
			 * - MS949 => 윈도우의 기본 한글 인코딩 방식(ANSI)
			 * - UTF-8 => 유니코드 UTF-8 인코딩 방식
			 * - US-ASCII => 영문 전용 인코딩 방식
			 * 
			 * ANSI는 영어를 표기하기 위해 만든 코드로 규격 자체에 한글이 없었다가,
			 * 나중에 여기에 EUC-KR, CP949라는 식으로 한글이 포함됨.
			 */
			
			isr = new InputStreamReader(fin);
			isr = new InputStreamReader(fin, "MS949");
			
			int c;
			while((c=isr.read()) != -1) {
				System.out.print((char)c);
				
			}
			System.out.println();
			System.out.println("출력 끝...");
			
			isr.close();//보조 스트림만 닫아도 된다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
