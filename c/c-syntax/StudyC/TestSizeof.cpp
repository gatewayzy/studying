#include <stdio.h>
#include <stdlib.h>
#include "myHeader.h"

int f(long a[]) {
	return (int)sizeof(a);
}

void testSizeOf(void) {
	printf("\n>>>>>>  testSizeOf()\n");

	// 基本数据类型的sizeof会自动对应到基本类型的字节大小（与系统位数有关）
	printf("sizeof(2): %d\n", sizeof(2));
	printf("sizeof(2.0): %d\n", sizeof(2.0));
	printf("sizeof(char): %d\n", sizeof(char));
	printf("sizeof(short): %d\n", sizeof(short));
	printf("sizeof(int): %d\n", sizeof(int));

	// 数组的sizeof值等于数组所占用的内存字节数
	char a1[] = "abc";
	int a2[4] = { 1,2 };
	int a3[2][5] = { 1,2,3,4,5,6 };
	printf("sizeof a1: %d\n", sizeof(a1)); // 3个char加上结束符'\0' 
	printf("sizeof a2: %d\n", sizeof(a2)); // 4*（int的4个）
	printf("sizeof a3: %d\n", sizeof(a3)); // 2*5*（int的4个）.
	printf("sizeof a3[0]: %d\n", sizeof(a3[0])); // 5*（int的4个）

												 //在32位计算机中，任何类型的一个指针变量的返回值必定是4字节，但是在64位系统中指针变量的sizeof结果为8
	char * p = "abc";
	printf("sizeof(char*):%d\n", sizeof(p));
	printf("string: %s\n", p);
	printf("char: %c\n", *p);

	// 出现参数传递的时候，数组类型的形参只需传入实参的地址，所以形参实际上只是一个指针，其sizeof为4或8（要看机器位数）
	long a[2][3] = { 1,2,3,4 };
	printf("sizeof(long): %d\n", sizeof(long));
	printf("%d#%d\n", sizeof(a), f(a[0]));
	printf("%d#%d\n", sizeof(a[0]), f(a[0]));

}