import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * Thư viện hỗ trợ lấy dữ liệu từ Excel đẩy vào Database SQL Server
 * Sử dụng thư viện POI 3.17 & JDBC 4.2
 * Trang cá nhân: www.fb.com/tranphuquy19
 */
public class ExcelSQL {
	private String link;
	String port = "1433"; // default SQL Server port is 1433
	String databaseName = "";
	boolean SQL2007; // true = xlsx, false = xls
	String connectionUrl = "jdbc:sqlserver://localhost:" + port + ";integratedSecurity=True";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int numberOfSheet;
	ArrayList<String> nameOfSheets = new ArrayList<String>();
	ArrayList<String> dataRow = new ArrayList<String>();

	public ExcelSQL() {

	}

	public ExcelSQL(String link) {
		this.link = link;
		ExcelVersions();
	}

	public ExcelSQL(String link, String port) {
		this.link = link;
		this.port = port;
		connectionUrl = "jdbc:sqlserver://localhost:" + (this.port) + ";integratedSecurity=True";
		ExcelVersions();
	}

	public ExcelSQL(String link, String port, String databaseName) {
		this.link = link;
		this.port = port;
		this.databaseName = databaseName;
		connectionUrl = "jdbc:sqlserver://localhost:" + (this.port) + ";databaseName=" + this.databaseName
				+ ";integratedSecurity=True";
		ExcelVersions();
	}

	/*
	 * Chuyển kiểu dữ liệu date Excel _> SQL
	 */
	private String ConvertToSQLDate(String date) {
		String st = "";
		String[] stcv = date.split("[/]");
		for (int i = stcv.length - 1; i >= 0; i--) {
			st += stcv[i];
		}
		return st;
	}

	private void ExcelVersions() {
		this.SQL2007 = this.link.contains(".xlsx");
	}

	private String covertStringToNormal(String str) {

		String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").toUpperCase().replaceAll(" ", "_").replaceAll("đ", "d");
	}

	private void convertNameOfSheetsToNormal() {
		String st;
		for (int i = 0; i < numberOfSheet; i++) {
			st = covertStringToNormal(nameOfSheets.get(i));
			nameOfSheets.set(i, st);
		}
	}

	public void run() throws IOException {

		FileInputStream inputStream = new FileInputStream(new File(link));
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			// String SQL = "CREATE DATABASE TRANPHUQUY199";
			stmt = con.createStatement();
			// rs = stmt.executeQuery(SQL);
		} catch (Exception ex) {
			System.exit(0);
		}
		;
/*
 * Dành cho Excel Version > 2007
 */
		if (SQL2007) {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			numberOfSheet = workbook.getNumberOfSheets();
			for (int i = 0; i < numberOfSheet; i++) {
				nameOfSheets.add(workbook.getSheetName(i));
			}
			Iterator<Sheet> sheetInterator = workbook.iterator();
			while (sheetInterator.hasNext()) {
				Sheet sheet = sheetInterator.next();
				nameOfSheets.add(sheet.getSheetName());
			}
			convertNameOfSheetsToNormal();
			for (int i = 0; i < numberOfSheet; i++) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rowIterator = sheet.iterator();
				Row row = rowIterator.next();

				while (rowIterator.hasNext()) {
					row = rowIterator.next();
					dataRow.clear();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						// Đổi thành getCellType() nếu sử dụng POI 4.x
						CellType cellType = cell.getCellTypeEnum();

						switch (cellType) {
						 case _NONE:
						 dataRow.add("");
						 break;
						case NUMERIC:
							dataRow.add(Double.toString(cell.getNumericCellValue()));
							break;
						case STRING:
							dataRow.add(cell.getStringCellValue());
							break;
						 case ERROR:
						 dataRow.add("!");
						 break;
						default:
							break;
						}

					}
				}
			}

			workbook.close();
/*
 * Dành cho Excel Version < 2007
 */
		} else {
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			numberOfSheet = workbook.getNumberOfSheets();
			for (int i = 0; i < numberOfSheet; i++) {
				nameOfSheets.add(workbook.getSheetName(i));
			}
			Iterator<Sheet> sheetInterator = workbook.iterator();
			while (sheetInterator.hasNext()) {
				Sheet sheet = sheetInterator.next();
				nameOfSheets.add(sheet.getSheetName());
			}
			convertNameOfSheetsToNormal();
			
			for (int i = 0; i < numberOfSheet; i++) {

				HSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rowIterator = sheet.iterator();
				Row row = rowIterator.next();

				while (rowIterator.hasNext()) {
					row = rowIterator.next();
					dataRow.clear();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						// Đổi thành getCellType() nếu sử dụng POI 4.x
						CellType cellType = cell.getCellTypeEnum();

						switch (cellType) {
						case _NONE:
							 dataRow.add("");
							 break;
							case NUMERIC:
								dataRow.add(Double.toString(cell.getNumericCellValue()));
								break;
							case STRING:
								dataRow.add(cell.getStringCellValue());
								break;
							 case ERROR:
							 dataRow.add("!");
							 break;
							default:
								break;
						}

					}
				}
			}
			workbook.close();
		}
	}
}
