package java_core_basic;

/*
 * ��������ת��
 */

public class BasicTypeChangeTest {
	public static void main(String[] args) {
		//���������Զ�ת��
		System.out.println("���������Զ�ת��");
		char c = 'a';
		System.out.println("c="+c);

		byte b = 44;
		System.out.println("b="+b);


		short s = b;
		System.out.println("s="+s);

		int i = s;
		System.out.println("i="+i);

		int i1 = c;
		System.out.println("i1="+i1);

		long l = i;
		System.out.println("l="+l);

		float f = l;
		System.out.println("f="+f);

		double d = f;
		System.out.println("d="+d);

		float f1 = 1.7f;
		System.out.println("f1="+f1);

		double db = f1;
		System.out.println("db="+db);

		f1 = (float) db;
		System.out.println("f1 = "+f1);

		// ��������ǿ��ת��
		System.out.println("\n\n��������ǿ��ת��");
		double db1 = 143.426d;
		System.out.println("db1 = "+db1);

		float ff = (float) db1;//��double����ǿת��float
		System.out.println("ff = "+ff);

		long ll = (long) db1;//��double����ǿת��long
		System.out.println("ll = "+ll);

		int ii = (int) db1;//��double����ǿת��int
		System.out.println("ii = "+ii);

		short s1 = (short) db1;//��double����ǿת��short
		System.out.println("s1 = "+s1);

		byte b1 = (byte) db1;//��double����ǿת��byte
		System.out.println("b1 = "+b1);
	}
}