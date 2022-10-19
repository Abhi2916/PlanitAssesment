package AbhinavA.Coding.PlanitAssesment;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileOperations {

	
	  //public static User user1 = new User();
	  
	  public static HashMap<String, String> Session = new HashMap<String,
	  String>(); public static String HomeDirectoryPath =
	  System.getProperty("user.dir"); public static String DataFilePath =
	  "C:\\Users\\abhin\\eclipse-workspace\\PlanitAssesment\\src\\test\\java\\Data\\TestData.xlsx";
	  
	  public static String readExcellCell(Row rowobject, int cellnumber) {
	  
	  String Cellvalue = null; try { Cellvalue =
	  rowobject.getCell(cellnumber).getStringCellValue(); } catch (Exception e) {
	  e.printStackTrace(); } return Cellvalue; }
	  
	  public static void readExcelByUniqueRowValue(String UniqueValue, String
	  ExcelPath) {
	  
	  try { FileInputStream fis = new FileInputStream(ExcelPath); XSSFWorkbook wb =
	  new XSSFWorkbook(fis); XSSFSheet sheet = wb.getSheet("Sheet1"); int RowCount
	  = sheet.getLastRowNum();
	  
	  System.out.println("UniqueValue : " + UniqueValue);
	  System.out.println("File Path : " + ExcelPath);
	  System.out.println("Number of Rows : " + RowCount);
	  
	  for (int RowNumber = 0; RowNumber <= RowCount; RowNumber++) { String
	  UniqueValue_File = readExcellCell(sheet.getRow(RowNumber), 0);
	  
	  if (UniqueValue_File.equalsIgnoreCase(UniqueValue)) { int ColumnCount =
	  sheet.getRow(RowNumber).getLastCellNum();
	  
	  System.out.println("Number of Columns : " + ColumnCount);
	  
	  for (int ColumnNumber = 0; ColumnNumber < ColumnCount; ColumnNumber++) {
	  System.out.println("Key : " + readExcellCell(sheet.getRow(0), ColumnNumber));
	  System.out.println("Value : " + readExcellCell(sheet.getRow(RowNumber),
	  ColumnNumber));
	  
	  // user1.userName = readExcellCell(sheet.getRow(0), ColumnNumber); //
	 // user1.password = readExcellCell(sheet.getRow(RowNumber), ColumnNumber);
	  
	  setsessionParameter(readExcellCell(sheet.getRow(0), ColumnNumber),
	  readExcellCell(sheet.getRow(RowNumber), ColumnNumber));
	  
	  // setsessionParameter(user1);
	  
	  } System.out.println("Session Value for CaseType : " +
	  getsessionParameter("CaseType"));
	  System.out.println("Session Value for LoginID : " +
	  getsessionParameter("LoginID"));
	  System.out.println("Session Value for Password : " +
	  getsessionParameter("Password"));
	  
	  break; } } } catch (Exception e) { e.printStackTrace(); } }
	  
	  public static void setsessionParameter(String ParameterName, String
	  ParameterValue) {
	  
	  Session.put(ParameterName, ParameterValue); }
	  
	  
	  public static String getsessionParameter(String ParameterName) {
	  
	  if (Session.get(ParameterName) == null) return "'" + ParameterName +
	  "' does not exist in session";
	  
	  else return Session.get(ParameterName); }
	  
	  public static void setCaseParametersForCaseType(String CaseType) {
	  
	  readExcelByUniqueRowValue(CaseType, DataFilePath); }
	 
}
