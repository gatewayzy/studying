package javaToolkit.officePOIpdf;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Apache pdf操作包<br>
 * 
 * @link http://pdfbox.officePOIpdf.org/index.html
 *
 */
public class PDFBox {
	public static void main(String[] a) throws Exception {
		readPDF();
	}

	/**
	 * 读取pdf文件的文本内容
	 * 
	 * @throws IOException
	 */
	private static void readPDF() throws IOException {
		File file = new File(
				"src/main/resources/files/pdf/Efficient Estimation of Word Representations in Vector Space.pdf");
		PDDocument document = PDDocument.load(file);
		// 用Stripper获取文字
		PDFTextStripper stripper = new PDFTextStripper();
		// 设置stripper的属性
		stripper.setStartPage(0);
		stripper.setEndPage(2);
		// 获取文本信息
		String text = stripper.getText(document);
		System.out.println(text);
	}

}
