package basic;

public class SyncThreadTest {
	public static void main(String[] args) {
		
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번쓰레드", sObj);
		WorkerThread th2 = new WorkerThread("2번쓰레드", sObj);
		
		th1.start();
		th2.start();
	}
}

class ShareObject{
	private int sum = 0;
	
	/*동기화 하는 방법 1 : 메서드 자체에 동기화 설정하기
	synchronized를 붙이면 메서드 전체가 임계영역으로 설정된다. 
	쓰레드는 synchronized메서드가 호출된 시점부터 해당 메서드가 포함된 객체의 lock을 얻어
	작업을 수행하다가 메서드가 종료되면 lock을 반환한다.
	*/
	public synchronized void add() {
	//public void add() {
		//동기화 하는 방법2 : 동기화 블럭으로 설정하기 
		
		//synchronized (this) { 
			int n = sum;
			n += 10;// 10증가
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
			
		//}
	}
	public int getSum() {
		return sum;
	}
}

//작업을 수행하는 쓰레드
class WorkerThread extends Thread{
		ShareObject sObj;
		
		public WorkerThread(String name, ShareObject sObj) {
			super(name);
			this.sObj = sObj;
		}
	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			sObj.add();
		}
	}
}