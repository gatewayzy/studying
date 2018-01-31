package javaBasic;

/**replace
 * @author dell
 *
 */
public class TestReplace {
	public static void main(String[] aStrings) {
		String a = "/di.*c/de";
		if (a.contains("*")) {
			System.out.println("^" + a.replaceAll("\\*", "+") + "$");
		} else {
			System.err.println("2");
			System.out.println("^" + a.replaceAll("\\*", "+") + "$");
		}
		System.out.println("1");
		System.out.println("/di.c/de".replaceAll("\\*", "+") + "$");
		System.out.println("/di.*c/de".replaceAll("\\*", "+") + "$");

		String string = "http://zcy.ckcest.cn/tcm/gate?pa=i0";
		System.out.println(string.substring(0, string.indexOf("?")));
		System.err.println("12");
		System.out.println("/di.c/de".replaceAll("\\*", "+") + "$");
		System.out.println("/di.*c/de".replaceAll("\\*", "+") + "$");
		
		System.err.println("test '='");
		String string1 = "st1";
		String string3 = string1;
		System.out.println(string3);
		string1 = "st1t1";
		System.out.println(string3);
		
		System.err.println("test '='");
		Mnode node1 = new Mnode(1);
		Mnode node3=node1;
		System.out.println(node3.val);
		node1.val=11;
		System.out.println(node3.val);
	}

}

class Mnode{
	int val;
	public Mnode(int val){
		this.val = val;
	}
}
