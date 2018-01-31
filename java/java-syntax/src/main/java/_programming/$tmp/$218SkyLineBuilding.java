package _programming.$tmp;

import java.util.*;

/**
 * leetcode：[The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/description/)
 * 输入：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]  其中[2 9 10]表示大楼左右边界分别是2,9，高度是10
 * 输出：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
 * 思路：<p>将每一个竖线按顺序存入，对于每一个矩形，都有高度相同的两条竖线，
 * 为了在一次扫描的时候，能将所有的竖线都加入，利用一个小技巧，将右边界的高度存为负值，恰好可以对其标记。
 * 将存入的list排序，需要自定义一个比较器比较a[],b[]，如果a[0] == b[0] 说明竖线重合，
 * 这个时候应该是高的在前面，如果a[0] != b[0] 只需按照a[0]b[0]从小到大即可。</p>
 * <p>最后在遍历list的时候，为了满足连续相同的高度只记录最前的x，因此需要用到pre和cur分别记录当前的最高和上一次的最高。
 * 在判断的时候，需要维护每次当前的最大值，可以用PriorityQueue权重队列，其构造原理是大顶堆，即根节点为最小(或最大)的二叉树，默认跟为最小值，
 * 根据题意，本题需要自己定义一个比较器，根保存当前最大值(可以注意我下面说的堆和队列，是同一个概念，为了方便理解，不同的时候用了不同的说法)。</p>
 * <p>最核心的思想：扫描到左边界的时候，将高度加入到大顶堆，cur的值去peek即为当前的最大值，
 * 当cur和pre不同的时候，将坐标加入结果队列即可，当为右边界时（高度为负值），证明该矩形已经到头，在堆中去掉其高度值，
 * 如果此时队列为空，则证明此处非连续，即此时应加入的高度为0，如果不为空，则更新相应当前最高即可。</p>
 *
 * @author dell
 */
public class $218SkyLineBuilding {
    public static void main(String[] args) {
        int[][] data = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        getSkyline(data);
    }

    //降序比较器
    static class MaxHeightCom implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a; // 大的在堆的顶端
        }
    }

    //边界比较器，按照x坐标升序，次之按y坐标降序
    static class VerticalCom implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) return a[0] - b[0];  //先按左边界进行升序
            return b[1] - a[1];  // x相等则高度降序
        }
    }

    public static void getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        // 使用优先队列实现最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new MaxHeightCom());  // 边界降序

        List<int[]> vertical = new ArrayList<int[]>();  // 记录每一个竖线
        for (int i = 0; i < buildings.length; i++) {
            int[] temp = buildings[i];
            vertical.add(new int[]{temp[0], temp[2]});  // 左边界竖线
            vertical.add(new int[]{temp[1], -temp[2]});  // 右边界竖线 为了区分 存入负值
        }
        Collections.sort(vertical, new VerticalCom());    //  所有边界，按照x坐标升序，次之按y坐标降序
        int cur = 0, pre = 0;
        for (int i = 0; i < vertical.size(); i++) {  // 对于每个边界，左边界就是
            int[] temp = vertical.get(i);
            if (temp[1] > 0) {  // 左边界
                maxHeap.add(temp[1]);  //高度入队
                cur = maxHeap.peek(); // 当前最高的
            } else { // 右边界
                maxHeap.remove(-temp[1]);  // 将对应的高度从堆中删除 这里就是右边存负值的方便之处
                cur = (maxHeap.peek() == null ? 0 : maxHeap.peek()); // 如果右边界是最后一个则高度为0，否则设置为当前最高
                // 因为加入堆的时候，高度取负又降序，所以最后一个是最高的
            }
            // 判断是否存储为结果
            if (cur != pre) {  // 与上一个最高的不相等
                res.add(new int[]{temp[0], cur});
                pre = cur;  // 保存当前高度为下一次的前面高度
            }
        }
        // 输出结果
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i)));
        }
    }
}