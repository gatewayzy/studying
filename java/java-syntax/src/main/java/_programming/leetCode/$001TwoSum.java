package _programming.leetCode;

/*
 * Given nums = [2, 7, 11, 15], target = 9,<br>
 * Because nums[0] + nums[1] = 2 + 7 = 9,<br>
 * return [0, 1]. <br>
 * 方法：数组存放数字，遍历如果两个数之和，如果是目标就返回这两个下标
 */
/**
 * easy
 * 
 * @author dell
 *
 */
public class $001TwoSum {
	public static void main(String args[]) {
		int[] test = new int[] { 3, 2, 4 };
		System.out.println(new SolutionTwoSum().twoSum(test, 6)[1]);
	}
}

class SolutionTwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j <= nums.length - 1; j++) {
				System.out.println("**" + i + j);
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
					return res;
				} // if
			} // for
		} // for
		return res;
	}
}
