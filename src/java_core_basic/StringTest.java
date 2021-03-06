package java_core_basic;

import java.util.Arrays;

/**
 * String类
 *
 * @author 唐龙
 */
public class StringTest {
	public static void main(String[] args) {
		String str1 = "the light";
		String str2 = new String(str1);
		// '=='用于判断是否是同一个字符串对象
		System.out.println("str1 == str2:" + str1 == str2);

		String str11 = "the light";
		String str22 = "the light";
		System.out.println("str11 == str22:" + str11 == str22);

		String str111 = "The Light";
		String str222 = "the light";
		//equals 用于判断字符串的值
		System.out.println("str111.equals(str222):" + str111.equals(str222));
		System.out.println("str111.equalsIgnoreCase(str222):" + str111.equalsIgnoreCase(str222));// 忽略大小写进行比较
		//CompareTo()返回从左到右第一对不同字符间的Unicode的差值
		System.out.println("str111.str111.compareTo(str222):" + str111.compareTo(str222));
		System.out.println("str111.compareToIgnoreCase(str222):" + str111.compareToIgnoreCase(str222));
		System.out.println("str111.startsWith(\"the\"):" + str111.startsWith("the"));
		System.out.println("str111.endsWith(\"ght\"):" + str111.endsWith("ght"));

		String week="一二三四五六日";
		int i;
		//charAt()
		for(i=0;i<week.length();i++){
			System.out.print(week.charAt(i)+" ");
		}
		System.out.println();

		//subString()
		for(i=0;i<week.length();i++){
			System.out.print(week.substring(i,i+1)+" ");
		}
		System.out.println();

		//split()方法
		String splitStr="Wo.shi.zh.o.ng.r.en.";
		System.out.println(splitStr);
		String [] splitStrArr = splitStr.split("\\.");//.是转义字符，必须加上\\
		System.out.println("数组长度："+splitStrArr.length);
		for(i=0;i<splitStrArr.length;i++){
			System.out.print(splitStrArr[i]+" ");
		}
		System.out.println();

		//matches()方法
		System.out.println(splitStr.matches("^Wo\\.shi[a-z(\\.)]*$"));

		//startsWith前缀
		System.out.println(splitStr.startsWith("Wo."));
		//endsWith后缀
		System.out.println(splitStr.endsWith(".en."));

		String strTest = " I am TangLong,I'm from China. ";
		System.out.println("strTest:" + strTest);
		//toLowerCase
		System.out.println("strTest.toLowerCase():" + strTest.toLowerCase());
		//toUpperCase
		System.out.println("strTest.toUpperCase():" + strTest.toUpperCase());
		//trim
		System.out.println("strTest.trim():" + strTest.trim());
		//replace
		System.out.println("strTest.replace('L', 'l'):" + strTest.replace('L', 'l'));
		//lastIndexOf
		System.out.println("lastIndexOf():"+strTest.substring(strTest.lastIndexOf("T"),strTest.lastIndexOf(",")));
		//toCharArray()
		System.out.println("strTest.toCharArray():"+Arrays.toString(strTest.toCharArray()));
		//contentEquals
		System.out.println("aaa".contentEquals("aaa"));
		//format
		String info = "ch=%c,isTrue=%b,num=%d,double=%f";
		System.out.println("Before format:\n" + info);
		info = String.format(info, 'c',true,32,Math.PI);
		System.out.println("After  format:\n" + info);
		// hashcode
		System.out.println("hashcode:"+str1.hashCode());
		//
		System.out.println("startWith: " + str1.startsWith("the")); // return boolean value

	}
}