package javaToolkit.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 使用sax技术去解析xml文件.myclasses2.xml<br>
 * sax循环监听文本内容，使用DefaultHandler类进行响应解析
 */
public class XMLSax {
	
	public static void main(String[] args) throws Exception, SAXException {
		// 1.创建SaxParserFactory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		// 2.创建SaxParser 解析器
		SAXParser saxParser = spf.newSAXParser();
		// 3 把xml文件和事件处理对象关联
		saxParser.parse("src/main/resources/files/xml/myclasses2.xml", new MyDefaultHandler1());
		System.err.println("第二个handler");
		saxParser.parse("src/main/resources/files/xml/myclasses2.xml", new MyDefaultHandler2());
	}
}

// 请思考，如何只显示学生的名字和年龄
class MyDefaultHandler2 extends DefaultHandler {
	private boolean isName = false;
	private boolean isAge = false;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String con = new String(ch, start, length);
		if (!con.trim().equals("") && (isName || isAge)) {
			System.out.println(con);
		}
		isName = false;
		isAge = false;
		// super.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, name);
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (name.equals("名字")) {
			this.isName = true;
		} else if (name.equals("年龄")) {
			this.isAge = true;
		}
	}
}

// 定义事件处理类
class MyDefaultHandler1 extends DefaultHandler {
	// 发现文档开始
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("startDocument()");
		super.startDocument();
	}

	// 发现xml文件中的一个元素
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("元素名称=" + name);
	}

	// 发现xml文件中的文本
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String con = new String(ch, start, length);
		// 显示文本内容:
		if (!con.trim().equals("")) {
			System.out.println(new String(ch, start, length));
		}
	}

	// 发现xml文件中一个元素介绍</xx>
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, name);
	}

	// 发现文档结束
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("endDocument()");
		super.endDocument();
	}
}
