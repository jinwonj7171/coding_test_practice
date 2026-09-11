package coding_test_problem;

//public class math_practice {
//
//	public static void main(String[] args) {
//		int[] start = {1,1};
//		int[] end = {2,2};
//		
//		int a = Math.abs(end[0] - start[0]);
//		int b = Math.abs(end[1] - start[1]);
//		
//		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b,2));
//		double radian = Math.atan(b/a);
//		System.out.printf("%f %f",c, Math.toDegrees(radian));
//		
//		
//		
//		
//		
//		
//		
//		
//
//	}
//
//}
public class math_practice{
//	static final double PI  = 3.141592;
	public static double calculateTheta (double x1, double y1, double x2, double y2) {
		double a = x2 -x1;
		double b = y2 +y1;
		double tanTheta = a/b;
		double theta = Math.atan(tanTheta);
		return theta;
	}
	public static void main(String[] args) {
		double x1 = 1.0, y1 =2.0;
		double x2 = 5.0,y2 = 1.0;
		
		double alpha = calculateTheta(x1,y1,x2,y2);
		System.out.println("my ball의 출발각도 세타 (라디안)"+alpha);
		System.out.println("my ball의 출발 각도 degree(도)"+Math.toDegrees(alpha)+"도");
		System.out.println("my ball의 출발 각도 degree(도)"+(alpha*(180.0/Math.PI))+"도");
		
		
		
		
	}
}