package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置参数-XX:+HeapDumpOnOutOfMemoryError -Xmx10m
 * <p>
 * 保证溢出，并dump溢出文件，文件存放在项目根目录下，直接打开文件会自动使用memory analyzer分析，查看总体、查看大内存、查看引用链和对象列表等
 *
 */
public class _04HeapOOM {
	static class OOMOb{
		
	}

	public static void main(String[] args) {
		List<OOMOb> list = new ArrayList<>();
		while(true){
			list.add(new OOMOb());
		}
		
	}
}
