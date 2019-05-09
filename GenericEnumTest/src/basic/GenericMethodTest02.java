package basic;

class Util2{
	public static <T extends Number> int compare(T t1, T t2) {
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
		
	}
}
/*
 * 제한된 타입 파라미터(Bounded Parameter) 예제
 * @author HelloJava
 */
public class GenericMethodTest02 {
	public static void main(String[] args) {
		int result1 = Util2.compare(10, 20); //AutoBoxing(Integer)
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3); //AutoBoxing(Double)
		System.out.println(result2);
		
		//Util2.compare("c", "java"); // 에러 발생
	}


}