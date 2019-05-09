package homework;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ThreadGame {
/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용하여 구하고, 사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력받는다.
 * 
 * 입력시간은 5초로 제한하고 카운트 다운을 진행한다.
 * 5초안에 입력이 없으면 게임을 진것으로 처리한다.
 * 
 * 5초안에 입력이 안료되면 승패를 출력한다.
 * 
 * 결과예시)
 * 
 * === 결 과 ===
 * 컴퓨터 : 가위
 * 당   신 : 바위
 * 결   과 : 당신이 이겻습니다.
 */
	public static boolean inputCheck = false;
	public static String userStr = "";
	
	public static void main(String[] args) {
		ArrayList<String> computer = new ArrayList<>();
		computer.add("가위");
		computer.add("바위");
		computer.add("보");
		
		Thread th1 = new GameInput();
		Thread th2 = new GameTimer();
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int idx = (int) (Math.random() * 3);
		String comStr = computer.get(idx);

		System.out.println("=== 결 과 ===");
		System.out.println("컴퓨터 : " + comStr);
		System.out.println("당   신 : " + userStr);

		if (userStr.equals(comStr)) {
			System.out.println("결   과 : 비겼습니다.");
		} else if ((userStr.equals("가위") && comStr.equals("보"))
			|| (userStr.equals("바위") && comStr.equals("가위"))
			|| (userStr.equals("보") && comStr.equals("바위"))) {
			System.out.println("결   과 : 당신이 이겼습니다.");
		} else {
			System.out.println("결   과 : 당신이 졌습니다.");
		}
	}
}

//데이터를 입력하는 쓰레드
class GameInput extends Thread{
	@Override
	public void run() {
		String str = "";
		do {
			str = JOptionPane.showInputDialog("가위 바위 보 입력");
		}while (!str.equals("가위") && !str.equals("바위") && !str.equals("보"));
		
		ThreadGame.userStr = str;
		ThreadGame.inputCheck =true;
	}
}

//카운트 다운을 처리하는 쓰레드
class GameTimer extends Thread{
	@Override
	public void run() {
		for(int i = 5; i >= 1; i--) {
			if(ThreadGame.inputCheck == true) {
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("5초가 지났습니다. 당신이 졌습니다.");
		System.exit(0);
	}
}