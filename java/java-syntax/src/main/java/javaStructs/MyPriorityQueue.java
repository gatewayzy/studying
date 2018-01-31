package javaStructs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueue {
	/**
	 * PriorityQueue和comparator实现自定义有序队列
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Comparator<MyPriorityQueue> OrderIsdn = new Comparator<MyPriorityQueue>() {
			public int compare(MyPriorityQueue o1, MyPriorityQueue o2) {
				// TODO Auto-generated method stub
				int numbera = o1.getPopulation();
				int numberb = o2.getPopulation();
				if (numberb > numbera) {
					return 1;
				} else if (numberb < numbera) {
					return -1;
				} else {
					return 0;
				}

			}

		};
		Queue<MyPriorityQueue> priorityQueue = new PriorityQueue<MyPriorityQueue>(11, OrderIsdn);

		// 添加数据自动排序
		MyPriorityQueue t5 = new MyPriorityQueue("t5", 5);
		MyPriorityQueue t1 = new MyPriorityQueue("t1", 1);
		MyPriorityQueue t3 = new MyPriorityQueue("t3", 3);
		MyPriorityQueue t2 = new MyPriorityQueue("t2", 2);
		MyPriorityQueue t4 = new MyPriorityQueue("t4", 4);
		priorityQueue.add(t5);
		priorityQueue.add(t1);
		priorityQueue.add(t3);
		priorityQueue.add(t2);
		priorityQueue.add(t4);

		while (!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.poll().toString());
		}
		// priorityQueue.remove(t3);
	}

	private String name;
	private int population;

	public MyPriorityQueue(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return this.name;
	}

	public int getPopulation() {
		return this.population;
	}

	public String toString() {
		return getName() + " - " + getPopulation();
	}

}
