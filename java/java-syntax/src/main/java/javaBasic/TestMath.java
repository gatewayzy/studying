package javaBasic;

/**数学运算
 * @author dell
 *
 */
public class TestMath {
	
	public static void main(String[] aStrings) {
		new TestMath().testMain();
	}

	/** 使用jUnit进行测试，使用run as junit */
	public void testMain() {
		System.out.print(1 & 2); // 按位与，或，异或，非
		System.out.print(1 | 2); // &、|也可以与&& ||
									// 相似，不过不会像后者们一样有“短路”判断，即第一个条件合适就返回
		System.out.print(1 ^ 2);
		System.out.print(~1);
		System.out.println((byte) (128)); // byte1字节，char2，short2 int4 long8
											// float4 double8 boolean不一定
		System.out.println(15 / 2 + "*" + 15 % 2 + "*" + 15.0 / 2); // 整除、余数、浮点除
		System.out.println(Math.pow(1.2, 2)); // Math类中有各种static方法
		System.out.println("hello".substring(0, "hel".length())); // 返回hel。注意substring(0,3)中含0不含3。

		
	}

}
