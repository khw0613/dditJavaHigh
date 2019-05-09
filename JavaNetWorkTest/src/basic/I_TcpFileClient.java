package basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class I_TcpFileClient {
   /*
    * 클라이언트는 서버에 접속하여 서버가 보내주는 파일을 D드라이브의 C_Lip폴더에 저장한다
    */
   private Socket socket;
   private InputStream in;
   private FileOutputStream fout;
   
   public void clientStart() {
//	  File file = new File("d:/C_Lib/Turips.jsp"); // 저장할 파일설정
      File file = new File("/Users/macbook/C_Lib/Turips.jpg"); // 저장할 파일설정
      System.out.println("파일 다운로드 시작...");
      try {
      socket = new Socket("localhost", 7777);
      fout = new FileOutputStream(file);
      in = socket.getInputStream();
      
      byte[] tmp = new byte[1024];
      int length =0;
      while((length = in.read(tmp)) !=-1) {
         fout.write(tmp, 0, length);
         
      }
      fout.flush();
      System.out.println("파일 다운로드 완료...");
      }catch (Exception e) {
         e.printStackTrace();
      }finally {
         if(in != null) {
            try {in.close();}catch(IOException e2){}
         }
         if(fout != null) {
            try {fout.close();}catch(IOException e2){}
         }
         if(socket != null) {
            try {socket.close();}catch(IOException e2){}
         }
      }
   }
   public static void main(String[] args) {
      new I_TcpFileClient().clientStart();
   }

}