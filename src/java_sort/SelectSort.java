package java_sort;

import java.util.Random;

public class SelectSort {
	public static void main(String[] args) {
		final int LENGTH=10;//���鳤��
		final int RANGE =100;//���ݷ�Χ
		int [] intArr = new int [LENGTH];
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
		long begin = System.nanoTime();
		//ѡ������
		selectSort(intArr);
		long end = System.nanoTime();
		System.out.printf("ѡ�����򹲺�ʱ%f����%n",(end-begin)/10.0);
		//ѡ�������
		System.out.println("ѡ�������:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//ѡ������ʵ�ַ���
	static void selectSort(int [] intArr){
		int i,j,swap;
		int l=intArr.length;
		int minPos;//��¼ĳһ�˲����µ���Сֵλ��
		//����n-1�˲���
		for(i=0;i<l-1;i++){
			minPos=i;
			for(j=i+1;j<l;j++){
				//����
				if(intArr[j]<intArr[minPos]){
					minPos=j;
				}
			}
			//�Ƿ���Ҫ����
			if(minPos != i){
				swap=intArr[i];
				intArr[i]=intArr[minPos];
				intArr[minPos]=swap;
			}
		}
		System.out.printf("������%d�˲���%n",i);
	}
}