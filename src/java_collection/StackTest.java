package java_collection;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class StackTest {
	public static void main(String argv[]) {
		FileInputStream input;
		char ch;
		// ����һ����ջ�����ڴ���ַ�
		Stack<Character> stack = new Stack<Character>();
		try {
			input = new FileInputStream(FileDescriptor.in);
			System.out.println("��ջ������");
			//��ջ����
			while ((ch = (char) input.read()) != '\r') {
				stack.push(Character.valueOf(ch));
			}
			input.close();
			//��ջ
			System.out.println("��ջ������");
			while (!stack.empty()) {
				System.out.println(stack.pop());
			}
		} catch (IOException e) {
			System.err.println("�������������");
		}
	}
}