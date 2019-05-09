package basic;

public class ThreadYieldTest {
   public static void main(String[] args) {
      ThreadYield th1=new ThreadYield("1번쓰레드");
      ThreadYield th2=new ThreadYield("2번쓰레드");
      
      th1.start();
      th2.start();
      
      try {
         Thread.sleep(10);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      System.out.println("111111111111-----------------------------------");
      th1.work =false;
      
      try {
         Thread.sleep(10);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      System.out.println("22222222222222222---------------------------------");
      th1.work =true;
      
      try {
         Thread.sleep(10);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      th1.stop =true;
      th2.stop =true;
      
   }

}

// Yield()메서드 연습용 쓰레드
class ThreadYield extends Thread{
   public boolean stop=false;   //반복문을 제어할 목적으로 만든변수
   public boolean work =true;   // 작업 실행을 제어할 목적으로 만든 변수
   
   public ThreadYield(String name) {
      //쓰레드에는 기본적으로 name속성이 있고, Thread생성자 중에서는 
      // name값을 매개변수로 받아서 설정하는 생성자가 있다.
      super(name);
      }
   
   @Override
   public void run() {
      while(!stop) {   //stop변수값이 true이면 반복을 멈춘다.
         if(work) {
            // 작업하는 영역....
            
            //getName() => 현재 쓰레드의 name값 반환
            System.out.println(getName()+"작업중...");
            }else {
               System.out.println(getName()+"작업양보");
               Thread.yield();
            }
         }
      System.out.println(getName()+"작업끝...");
   }

}