package javaBasic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 使用swing制作一个前天的面板
 * 	包括左右分割的panel和面板的切换
 * @author delln
 *
 */
public class TestSwing extends JFrame implements MouseListener{
	//定义需要的组件
	JSplitPane jSplitPane = null;
	JPanel jPanel_left,jPanel_right,jPanel_right_1,jPanel_right_2,jPanel_right_3;//左右两个panel，右边panel有三个切换
	JLabel jb1,jb2,jb3; //3 label
	CardLayout cardLayout=new CardLayout();//右边要切换，需要获取caedLayout的引用
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestSwing();
	}

	public TestSwing() {
		//创建组件
		jPanel_left=new JPanel(new GridLayout(5, 1));//左边不切换，不需要获取gridLayout的引用
		jPanel_left.setBorder(BorderFactory.createEmptyBorder());//左panel有外框线
		
		jb1=new JLabel("学生选课系统",JLabel.CENTER);
		jb2=new JLabel("老师管理",JLabel.CENTER);		
		jb3=new JLabel("学生管理",JLabel.CENTER);
		// 添加label的鼠标监听
		jb1.addMouseListener(this);
		jb2.addMouseListener(this);
		jb3.addMouseListener(this);
		//label添加到左panel
		jPanel_left.add(jb1);
		jPanel_left.add(jb2);
		jPanel_left.add(jb3);
		
		// 右边的panel
		jPanel_right = new JPanel(cardLayout);
		
		jPanel_right_1=new JPanel();
		//jPanel_right_1.setBackground(Color.black);
		jPanel_right_1.add(new JLabel(new ImageIcon("javaicon.jpg")));//面板显示一个图片
		jPanel_right_2=new JPanel();
		jPanel_right_2.setBackground(Color.red);
		jPanel_right_3=new JPanel();
		jPanel_right_3.setBackground(Color.blue);
		// 将右边三个添加到右panel
		jPanel_right.add("1", jPanel_right_1);
		jPanel_right.add("2", jPanel_right_2);
		jPanel_right.add("3", jPanel_right_3);
		//设置默认显示的卡片标号
		cardLayout.show(jPanel_right, "1");
		
		//pane分割为左右panel
		jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel_left, jPanel_right);
		jSplitPane.setDividerLocation(140);
		
		//窗口容器添加pane，设置
		this.add(jSplitPane);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// 点击label的时候切换cardLayout对应的panel
		System.out.println("click found...");
		if(e.getClickCount() == 1){
			if (e.getSource() == jb1) {
				cardLayout.show(jPanel_right, "1");
			}else if (e.getSource() == jb2) {
				cardLayout.show(jPanel_right, "2");
			}else if (e.getSource() == jb3) {
				cardLayout.show(jPanel_right, "3");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		if (e.getSource() == jb1) {
			jb1.setForeground(Color.DARK_GRAY);
			jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}else if (e.getSource() == jb2) {
			jb2.setForeground(Color.DARK_GRAY);
			jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		*/
		//鼠标悬浮于label的时候，变换颜色和鼠标形状
		((JLabel)(e.getSource())).setForeground(Color.orange);
		((JLabel)(e.getSource())).setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		if (e.getSource() == jb1) {
			jb1.setForeground(Color.DARK_GRAY);
			jb1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		*/
		//鼠标悬浮于label的时候，变换颜色和鼠标形状
		((JLabel)(e.getSource())).setForeground(Color.black);
		((JLabel)(e.getSource())).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
