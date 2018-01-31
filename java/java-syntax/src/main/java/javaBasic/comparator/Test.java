package javaBasic.comparator;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		new Test().mapSort();
	}
	

	/** 中文 treeMap 升序 */
	public void mapSort() {
		triMap t0 = new triMap(3, "药物方剂", "已解决");
		triMap t1 = new triMap(2, "药方病证", "未解决");
		triMap t2 = new triMap(1, "服务器错", "已解决");
		triMap t3 = new triMap(3, "反馈失败", "未解决");
		triMap t4 = new triMap(6, "新闻空白", "已解决");
		triMap t5 = new triMap(9, "不能刷新", "未解决");
		triMap t6 = new triMap(2, "已经注册", "未解决");
		triMap t7 = new triMap(7, "开始错误", "已解决");
		triMap t8 = new triMap(4, "相应太慢", "未解决");
		triMap t9 = new triMap(8, "界面太丑", "已解决");

		List<triMap> list = new ArrayList<>();
		list.add(t0);
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.add(t6);
		list.add(t7);
		list.add(t8);
		list.add(t9);
		
		// 按照键值排序//按照title排序
		ChComparator comparator = new ChComparator();
		Map sortMap = new TreeMap(comparator);
		for (triMap triMap : list) {
			sortMap.put(triMap.getTitle(), triMap.getSupp());
		}
		// 注意：每次对TreeMap进行put()时，TreeMap都会自动调用它的compare(key,Entry.key)
		Collection col = sortMap.keySet();
		Iterator it = col.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			//System.out.print(it.next()+":"+sortMap.get(it.next()) + "  ");
			System.out.print(key +":"+sortMap.get(key) + "  ");
		}
		System.out.println();
	}

	class triMap {
		private int supp;
		private String title;
		private String status;

		public triMap() {
		}

		public triMap(int supp, String title, String status) {
			this.supp = supp;
			this.title = title;
			this.status = status;
		}

		public int getSupp() {
			return supp;
		}

		public void setSupp(int supp) {
			this.supp = supp;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}

}
