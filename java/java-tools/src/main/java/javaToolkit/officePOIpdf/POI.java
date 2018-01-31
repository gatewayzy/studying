package javaToolkit.officePOIpdf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Apache POI 用于操作Office(word/excel/ppt/...)，具体API参考相应链接
 * 
 * @author dell
 * @link https://poi.officePOIpdf.org/download.html
 * 
 *
 */
public class POI {

	public static void main(String[] args) throws Exception {
		myDiary();
		// myword();
		// wordRead();
		// excelRead();
		// excelWrite();
		// excelReadXlsx();
	}

	/**
	 * 个人日记的文本处理
	 * 
	 * @throws Exception
	 */
	private static void myDiary() throws Exception {
		FileReader fr = new FileReader("D:/1.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("D:/2.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String line = null;
		int check = 4;
		while ((line = br.readLine()) != null) {
			if (line.contains("——201")) {
				line = line.replaceAll(" ", "").replaceAll("——", "").replace("$$", "").replace("——", "##  ");
				line += "\r\n---\r\n";
				bw.write(line);
			} else {
				boolean flag = false;
				if (line.contains("日星期")) {
					line = "###  " + line;
					int k = line.indexOf("日");
					int num = Integer.parseInt(line.substring(k - 1, k));
					System.out.print(num);
					System.out.println(check % 10);
					if ((num - check % 10) != 0) {
						System.out.println(line);
					}
					check++;
					if (num == 1) {
						check = 2;

					}
				}
				if (line.contains("$$")) {
					flag = true;
					line = line.replace("$$", "");
					if (line.length() > 5 && !line.contains("日星期")
							&& !(line.endsWith("。") || line.endsWith(".") || line.endsWith(" "))) {
						flag = false;
					}
				}
				if (line.trim().length() > 0) {
					bw.write(line);
					if (flag) {
						bw.newLine();
						bw.newLine();
					}
				}
			}

		}

		bw.close();
		br.close();
		System.out.println("over！");

	}

	/**
	 * 读取docx格式的word内容
	 * 
	 * @throws IOException
	 */
	private static void myword() throws IOException {
		InputStream is = new FileInputStream("src/main/resources/files/office/1.docx");
		XWPFDocument document = new XWPFDocument(is);
		XWPFWordExtractor extractor = new XWPFWordExtractor(document);

		System.out.println(extractor.getText());
	}

	/**
	 * 读取word内容<br>
	 * word使用HWPF与XWPF<br>
	 * 
	 * @throws IOException
	 */
	private static void wordRead() throws IOException {
		InputStream is = new FileInputStream("src/main/resources/files/office/1.doc");
		WordExtractor extractor = new WordExtractor(is);
		// 输出word文档所有的文本
		System.out.println(extractor.getText());
		System.out.println(extractor.getTextFromPieces());
		// 输出页眉的内容
		System.out.println("页眉：" + extractor.getHeaderText());
		// 输出页脚的内容
		System.out.println("页脚：" + extractor.getFooterText());
		// 输出当前word文档的元数据信息，包括作者、文档的修改时间等。
		System.out.println(extractor.getMetadataTextExtractor().getText());
		// 获取各个段落的文本
		String paraTexts[] = extractor.getParagraphText();
		for (int i = 0; i < paraTexts.length; i++) {
			System.out.print("Paragraph " + (i + 1) + " : " + paraTexts[i]);
		}
		// 输出当前word的一些信息
		System.out.println(extractor.getSummaryInformation().getAuthor());
		is.close();
	}

	/**
	 * 读取xlsx格式的excel
	 * 
	 * @throws IOException
	 */
	private static void excelReadXlsx() throws IOException {
		Workbook workbook = new XSSFWorkbook("src/main/resources/files/office/1.xlsx");
		Sheet sheet = workbook.getSheetAt(0);
		// 总行数
		int rows = sheet.getLastRowNum();
		// 某一行总列数
		Row row = sheet.getRow(0);
		int cols = row.getPhysicalNumberOfCells();
		// 输出所有内容
		for (int i = 0; i < rows; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < cols; j++) {
				Cell cell = row.getCell(j);
				System.out.print(cell.getCellType() + ":" + cell + "	");
			}
			System.out.println();
		}
		workbook.close();
	}

	/**
	 * 读取xls格式的excel Excel : SS = HSSF + XSSF，低版本用HSSF，高版本用XSSF。
	 * 
	 * @throws Exception
	 */
	private static void excelRead() throws Exception {
		File file = new File("src/main/resources/files/office/1.xls");
		POIFSFileSystem fileSystem1 = new POIFSFileSystem(file);
		Workbook workbook = new HSSFWorkbook(fileSystem1);

		Sheet sheet = workbook.getSheetAt(0);
		// 总行数
		int rows = sheet.getLastRowNum();
		// 某一行总列数
		Row row = sheet.getRow(0);
		int cols = row.getPhysicalNumberOfCells();
		// 输出所有内容
		for (int i = 0; i < rows; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < cols; j++) {
				Cell cell = row.getCell(j);
				System.out.print(cell.getCellType() + ":" + cell + "	");
			}
			System.out.println();
		}
		workbook.close();
	}

	/**
	 * 读取与修改 excel
	 * 
	 * @throws Exception
	 */
	private static void excelWrite() throws Exception {
		InputStream inp = new FileInputStream("src/main/resources/files/office/1.xls");
		// InputStream inp = new FileInputStream("workbook.xlsx");

		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
		// 写入excel
		Cell cell = sheet.getRow(1).getCell(1);
		System.out.println(cell);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(new Date().toString());
		FileOutputStream fileOut = new FileOutputStream("src/main/resources/files/office/1.xls");
		wb.write(fileOut);
		fileOut.close();
	}

}
