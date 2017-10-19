package java_collection_map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
	public static void main(String[] args) {
		//��ʼ������numbers
		List<Integer> numbers = new ArrayList<>();
		final int N = 8;
		for (int i = 0; i < N; i++) {
			numbers.add((int)(Math.random()*30));
		}
		System.out.println("�����е�����:");
		System.out.println(numbers);

		Collections.reverse(numbers);
		System.out.println("��ת�󼯺��е�����:");
		System.out.println(numbers);
		
		Collections.shuffle(numbers);
		System.out.println("�����󼯺��е�����:");
		System.out.println(numbers);
		
		Collections.sort(numbers);
		System.out.println("����󼯺��е�����:");
		System.out.println(numbers);
		
		Collections.swap(numbers,0,5);
		System.out.println("����0��5�±�����ݺ󣬼����е�����:");
		System.out.println(numbers);
		
		Collections.rotate(numbers,2);
		System.out.println("�Ѽ������ҹ���2����λ��������ݺ󣬼����е�����:");
		System.out.println(numbers);
		
		int size = numbers.size();
		System.out.println("���ϴ�С:"+size);
		
		System.out.println("�ѷ��̰߳�ȫ��Listת��Ϊ�̰߳�ȫ��List");
        List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);
        System.out.println(synchronizedNumbers);
	}
}