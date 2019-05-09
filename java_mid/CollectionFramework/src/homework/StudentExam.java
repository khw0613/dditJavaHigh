package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentExam {
// list
	/*
	 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
		  Student클래스를 만든다.
		  생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
		  
		  이 Student객체들은 List에 저장하여 관리한다.
		  List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
		  총점의 역순으로 정렬하는 부분을 프로그램 하시오.
		  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
		  (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
		   총점 정렬기준은 외부클래스에서 제공하도록 한다.)
	 */
	public static void main(String[] args) {
		StudentExam std = new StudentExam();
		ArrayList<Student> sList =new ArrayList<>();
		sList.add(new Student("700","강현욱", 90 ,50, 40));
		sList.add(new Student("300","김도현", 100 ,90, 100));
		sList.add(new Student("600","이대용", 90 ,70, 60));
		sList.add(new Student("100","김현지", 80 ,60, 60));
		
		std.Ranking(sList); //랭킹 구하기
		System.out.println("정렬전..");
		for(Student str : sList) {
			System.out.println(str);
		}
		System.out.println("===================");
		
		//학번으로 오름차순으로 정렬하기
		Collections.sort(sList);
		System.out.println("학번으로 오름차순으로 정렬 후.....");
		for(Student str : sList){
			System.out.println(str);
		}
		System.out.println("===========================");
		
		Collections.sort(sList, new TotalSort());
		System.out.println("총점으로 내림차순으로 정렬후..");
		for(Student str : sList) {
			System.out.println(str);
		}
		System.out.println("=====================================");
	}
	
	public void Ranking(List<Student> sList) {
		for(Student std : sList) {
			int rank = 1;
			for(Student std2 : sList) {
				if(std.getTotal() < std2.getTotal()) {
					rank++;
				}
			}
			std.setRank(rank);
		}
	}
	
}
class Student implements Comparable<Student>{
	private String num; // 학번
	private String name; // 이름
	private int kor; // 국어점수
	private int eng; // 영어점수
	private int math;// 수학점수
	private int total; // 총 점
	private int rank; // 순위

	
	public Student(String num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}

	//학번을 기준으로 오름차순
	@Override
	public int compareTo(Student std) {
		return num.compareTo(std.getNum());
	}
	//화면에 학생 정보 출력 포맷을 정의
	@Override 
	public String toString() {
		return "Student [ 학번 " + num + " 이름 " + name + " 국어점수 " + kor + 
				" 영어점수 " + eng + " 수학점수 "+ " 총점 " + total + " 등수 " + rank + " ]"; 
	}
	
}

class TotalSort implements Comparator<Student>{
	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTotal() == std2.getTotal()) {
			return std1.getNum().compareTo(std2.getNum())* -1;
		}else {
			return Integer.compare(std1.getTotal(), std2.getTotal()) * -1;
		}
	}
}