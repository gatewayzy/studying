#include <stdio.h>
#include <stdlib.h>
#include "myHeader.h"

int f(long a[]) {
	return (int)sizeof(a);
}

void testSizeOf(void) {
	printf("\n>>>>>>  testSizeOf()\n");

	// �����������͵�sizeof���Զ���Ӧ���������͵��ֽڴ�С����ϵͳλ���йأ�
	printf("sizeof(2): %d\n", sizeof(2));
	printf("sizeof(2.0): %d\n", sizeof(2.0));
	printf("sizeof(char): %d\n", sizeof(char));
	printf("sizeof(short): %d\n", sizeof(short));
	printf("sizeof(int): %d\n", sizeof(int));

	// �����sizeofֵ����������ռ�õ��ڴ��ֽ���
	char a1[] = "abc";
	int a2[4] = { 1,2 };
	int a3[2][5] = { 1,2,3,4,5,6 };
	printf("sizeof a1: %d\n", sizeof(a1)); // 3��char���Ͻ�����'\0' 
	printf("sizeof a2: %d\n", sizeof(a2)); // 4*��int��4����
	printf("sizeof a3: %d\n", sizeof(a3)); // 2*5*��int��4����.
	printf("sizeof a3[0]: %d\n", sizeof(a3[0])); // 5*��int��4����

												 //��32λ������У��κ����͵�һ��ָ������ķ���ֵ�ض���4�ֽڣ�������64λϵͳ��ָ�������sizeof���Ϊ8
	char * p = "abc";
	printf("sizeof(char*):%d\n", sizeof(p));
	printf("string: %s\n", p);
	printf("char: %c\n", *p);

	// ���ֲ������ݵ�ʱ���������͵��β�ֻ�贫��ʵ�εĵ�ַ�������β�ʵ����ֻ��һ��ָ�룬��sizeofΪ4��8��Ҫ������λ����
	long a[2][3] = { 1,2,3,4 };
	printf("sizeof(long): %d\n", sizeof(long));
	printf("%d#%d\n", sizeof(a), f(a[0]));
	printf("%d#%d\n", sizeof(a[0]), f(a[0]));

}