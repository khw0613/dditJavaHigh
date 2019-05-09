package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	/*
	 * 외부의 Properties파일을 읽어와 Properties객체로 처리하기
	 */
	
	public static void main(String[] args) {
		// 읽어온 정보를 저장할 Properties객체 생성
		Properties prop = new Properties();
		
		// 읽어올 파일명을 이용한 File객체에 생성
		File file = new File("res/db.properties");
		
		try {
			//파일 읽기를 수행할 FileInputStream객체 생성
			FileInputStream fin = new FileInputStream(file);
			
			//properties객체로 파일 내용 읽기
			prop.load(fin); // => 파일 내용을 읽어와 Key값과 Value값으로 분류 한 후, Properties객체에 담는다.
			
			//읽어온 자료 출력하기
			
			//Key값만 읽어와 Enumeration객체로 변환하기
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			
			//Key값 개수만큼 반복해서 값 출력하기
			
			//Keys.hasMoreElements() => 다음 포인터 위치에 자료 유무에 따라 boolean 데이터를 반환한다.
			while(keys.hasMoreElements()) {
				String key 		= keys.nextElement();
				String value	= prop.getProperty(key);
				System.out.println(key + " ==> " + value);
			}
			System.out.println("End Print");
		} catch(IOException e) {
			System.out.println("fail read file");
		}
		
	}
}