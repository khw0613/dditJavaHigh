package homework;

import java.util.ArrayList;

/*
10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간중간에 각 말들의 위치를 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

경기가 끝나면 등수 순으로 출력한다.

*/

import java.util.ArrayList;
import java.util.Collections;

public class HorseGame {
	public static int rankCnt = 0;
	public static boolean end = false;
	public static ArrayList<Horse> horse = new ArrayList<>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			horse.add(new Horse((i + 1) + "번말"));
		}
	
		ArrayList<RacingThread> racing = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			racing.add(new RacingThread(horse.get(i).getName()));
		}
		
		for (int i = 0; i < racing.size(); i++) {
			racing.get(i).start();
		}
		
		System.out.println("[시작]");
		while (!end) {
			for (RacingThread hr : racing) {
				try {
					System.out.println(hr);
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}		

		for (RacingThread hr : racing) {
			try {
				hr.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Collections.sort(horse);
		
		System.out.println("============================================================");
		System.out.println();
		System.out.println("[순위]");
		for (Horse h : horse) {
			System.out.println(h.getRank() + "등\t: " + h.getName());
		}
	}

}

class RacingThread extends Thread {
	private String name;
	private ArrayList<String> section = new ArrayList<>();
	
	// 생성자
	public RacingThread(String name) {
		this.name = name;
		addSection();
	}
	
	public void addSection() {
		for (int i = 0; i < 50; i++) {
			section.add("-");
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (i != 0) {
				section.set(i - 1, "-");
			}
			section.set(i, ">");
			
			try {
				// sleep() 메서드의 값을 200~500 사이의 난수로 한다.
				Thread.sleep((int) (Math.random() * 301 + 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println(name + " 경주 끝");
		HorseGame.rankCnt++;
		if (HorseGame.rankCnt >= 10) {
			HorseGame.end = true;
		}
		
		for (int i = 0; i < HorseGame.horse.size(); i++) {
			if (HorseGame.horse.get(i).getName().equals(name)) {
				HorseGame.horse.get(i).setRank(HorseGame.rankCnt);
			}
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < section.size(); i++) {
			str += section.get(i);
		}
		return name + "\t| " + str;
	}
}

class Horse implements Comparable<Horse> {
	private String name;	// 말 이름
	private int rank;		// 등수
	
	public Horse(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	// 등수(rank)의 오름차순으로 정렬
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(getRank(), horse.getRank());
	}
}