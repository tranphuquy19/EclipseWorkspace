import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DocDongDauTien {

	public static void main(String[] args) throws IOException {

		// Đọc một file XSL.
		FileInputStream inputStream = new FileInputStream(new File("C:/Users/tranp/Desktop/datasv.xlsx"));

		// Đối tượng workbook cho file XSL.
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
		Iterator<Row> rowIterator = sheet.iterator();

	
			Row row = rowIterator.next();
			row = rowIterator.next();
			// Lấy Iterator cho tất cả các cell của dòng hiện tại.
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				// Đổi thành getCellType() nếu sử dụng POI 4.x
				CellType cellType = cell.getCellTypeEnum();

				switch (cellType) {
				// case _NONE:
				// System.out.print("");
				// System.out.print("\t");
				// break;
				// case BOOLEAN:
				// System.out.print(cell.getBooleanCellValue());
				// System.out.print("\t");
				// break;
				// case BLANK:
				// System.out.print("");
				// System.out.print("\t");
				// break;
//				 case FORMULA:
//				
//				 // Công thức
//				 System.out.print(cell.getCellFormula());
//				 System.out.print("\t");
//				
//				 FormulaEvaluator evaluator =
//				 workbook.getCreationHelper().createFormulaEvaluator();
//				
//				 // In ra giá trị từ công thức
//				 System.out.print(evaluator.evaluate(cell).getNumberValue());
//				 break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					System.out.print("\t");
					break;
				case STRING:
					System.out.print(cell.getStringCellValue());
					System.out.print("\t");
					break;
				case ERROR:
					System.out.print("!");
					System.out.print("\t");
					break;
				}

			}
			System.out.println("\n"+workbook.getNumberOfSheets());
		

	}

}
