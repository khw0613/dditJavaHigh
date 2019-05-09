package basic;

public class ThreadGame {
 public static void main(String[] args) {
	GameTimer gt = new GameTimer();
	
	// 난수를 이용하여 컴퓨터의 가위 바위 보를 정한다.
	String[] com = {"가위", "바위", "보"};
	
	int index = (int)(Math.random()*3); 
	
}
}
