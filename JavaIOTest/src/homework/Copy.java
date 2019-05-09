package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Copy {

	public static void main(String[] args) {
		FileInputStream fin = null;
		FileOutputStream fos = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
//			fin = new FileInputStream("d:/D_Other/Tulips.jpg");
//			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			fin = new FileInputStream("/Users/macbook/D_Other/Tulips.jpg");
			fos = new FileOutputStream("/Users/macbook/D_Other/복사본_Tulips.jpg");
			bin = new BufferedInputStream(fin, 50);
			bout = new BufferedOutputStream(fos, 50);
			
			int c = 0;
			while ((c = bin.read()) != -1) {
				bout.write(c);
			}
			
			System.out.println("파일 복사 완료");
			
			bout.close();
			fin.close();
			fos.close();
			bin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
