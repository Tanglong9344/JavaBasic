package java_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList �� LinkedList ����ǰ��������ݶԱ�
 */

public class ArrayListInsertToStartTest {
	public static void main(String[] args) {
		List<Integer> intList;
		intList = new ArrayList<>();
		insertFirst(intList, "ArrayList");

		intList = new LinkedList<>();
		insertFirst(intList, "LinkedList");
	}
	private static void insertFirst(List<Integer> intList, String type) {
		int total = 100 * 1000;
		final int number = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			intList.add(0, number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("��%s ��ǰ�����%d�����ݣ��ܹ���ʱ %d ���� %n", type, total, end - start);
	}
}