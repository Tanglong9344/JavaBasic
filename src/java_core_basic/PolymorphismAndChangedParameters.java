package java_core_basic;

/**
 * Java 多态
 * @author 唐龙
 */
public class PolymorphismAndChangedParameters {
	public static void main(String[] args) {
		PolymorphismAndChangedParameters p = new PolymorphismAndChangedParameters();
		System.out.println("---------多态---------");
		System.out.println(p.add(1));
		System.out.println(p.add(1,2));
		System.out.println(p.add(1,2,3));
		System.out.println(p.adds(1));
		System.out.println(p.adds(1,2,3));
		System.out.println(p.adds(1,2,3,4,5,6,7,8,9));
	}

	//add(int a)
	public int add(int a){
		System.out.println("add(int a): one parameter");
		return a;
	}

	//add(int a,int b)
	public int add(int a,int b){
		System.out.println("add(int a,int b): two parameters");
		return a + b;
	}

	//add(int a,int b,int c)
	public int add(int a,int b,int c){
		System.out.println("add(int a,int b,int c): three parameters");
		return a + b + c;
	}

	//可变参数列表
	public int adds(int...ints){
		System.out.println("adds(int...ints):" + ints.length);
		int sum = 0;
		for(int i:ints){
			sum += i;
		}
		return sum;
	}
}