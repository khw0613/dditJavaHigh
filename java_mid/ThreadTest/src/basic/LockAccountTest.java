package basic;

import java.util.concurrent.locks.ReentrantLock;

/*
 * 은행의 입출금을 쓰레드로 처리하는 예제
 * (Lock을 이용한 동기화 처리)
 * 
 */
public class LockAccountTest {
	public static void main(String[] args) {
		SyncAccount lAcc = new SyncAccount();
		lAcc.setBalance(10000); // 입금처리

		BankThread bth1 = new BankThread(lAcc);
		BankThread bth2 = new BankThread(lAcc);

		bth1.start();
		bth2.start();
	}

}

// 입출금을 담당하는 클래스
class LockAccount {
	private int balance; // 잔액이 저장될 변수

	// lock객체 생성 => 되도록이면 private final로 만든다.
	private final ReentrantLock lock = new ReentrantLock();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금하는 메서드
	public void deposit(int money) {
		// Lock객체의 lock()메서드가 동기화 시작이고, unlock()메서드가 동기화 끝을 나타낸다.
		// 동기화의 끝을 나타낸다.
		// lock()메서드로 동기화를 설정한 곳에서는 반드시 unlock()메서드로 헤제해 주어야 한다.
		lock.lock();
		balance += money;// 동기화 처리 부분
		lock.unlock(); // 헤제
	}

	// 출금하는 메서드(출금 성공 : true, 출금 실패 :false 반환)
	public boolean withdraw(int money) {
		lock.lock();
		boolean chk = false;
		// try ~ catch 블럭을 사용하는 경우에는
		// unlock()메서드 호출은 finally 블럭에서 하도록 한다.
		try {
			if (balance >= money) {// 잔액이 많을 경우...
				for (int i = 1; i <= 1000000000; i++) {
				} // 시간 때우기
				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());
				chk = true;
			} else {
				chk = false;
			}
		} finally {
			lock.unlock();

		}
		return chk;
	}
}

// 은행 업무를 처리하는 쓰레드
class BankThread2 extends Thread {
	private LockAccount lAcc;

	public BankThread2(LockAccount lAcc) {
		this.lAcc = lAcc;
	}

	@Override
	public void run() {
		boolean result = lAcc.withdraw(6000); // 6000원 출금
		System.out.println("쓰레드 안에서 result = " + result + 
							", balance = " + lAcc.getBalance());
	}
}
