package AbhinavA.Coding.PlanitAssesment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	public static WebDriver driver;
	public static void launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("Chrome"))
		{
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\abhin\\eclipse-workspace\\PlanitAssesment\\src\\test\\java\\Drivers\\chromedriver_V106\\chromedriver.exe");
	driver = new ChromeDriver();
		}
	}
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../target/snapshots/" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		System.out.println(errflpath);
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
	
	public static void webDriverWait(By b) {
		WebDriverWait wait=new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(b));		
	}
	
	public static WebElement pWebElement(String locator) {
		webDriverWait(locatorBy(locator));
		return driver.findElement(locatorBy(locator));
		
	}
	public static List<WebElement> pWebElements(String locator) {
		webDriverWait(locatorBy(locator));
		return driver.findElements(locatorBy(locator));
		
	}
	public static WebElement pWebElementNowait(String locator) {

		return driver.findElement(locatorBy(locator));
		
	}
	public static By locatorBy(String locator) {
		if (locator.startsWith("id")) {

			
			return By.id(locator.substring(locator.indexOf("=")+1).trim());
		}
		
		if (locator.startsWith("xpath")) {


			return By.xpath(locator.substring(locator.indexOf("=")+1).trim());
		}
		
		if (locator.startsWith("linkText")) {

			
			return By.linkText(locator.substring(locator.indexOf("=")+1).trim());
		}
		
		if (locator.startsWith("name")) {

			
			return By.name(locator.substring(locator.indexOf("=")+1).trim());
		}
		
		if (locator.startsWith("partialLinkText")) {

			
			return By.partialLinkText(locator.substring(locator.indexOf("=")+1).trim());
		}
		
		if (locator.startsWith("cssSelector")) {

			
			return By.cssSelector(locator.substring(locator.indexOf("=")+1).trim());
		}
		
		if (locator.startsWith("tagName")) {

			
			return By.tagName(locator.substring(locator.indexOf("=")+1).trim());
		}
		
		if (locator.startsWith("className")) {

			
			return By.className(locator.substring(locator.indexOf("=")+1).trim());
		}
		else
		{
			return null;
		}

	}
	public static void click(String locator)
	{
		pWebElement(locator).click();
		
	}
	
	public static void sendKeys(String locator, String valueToEnter)
	{
		pWebElement(locator).sendKeys(valueToEnter);
		
	}
	
	public static String getText(String locator)
	{
		return pWebElement(locator).getText();
		
	}
	
	public static String getAttributeValue(String locator,String attribute)
	{
		return pWebElement(locator).getAttribute(attribute);
		
	}
	
	public static void launchWebsite(String url)
	{
		driver.get(url);
		
	}
	
	public static void maximizeWindow()
	{
		driver.manage().window().maximize();
		
	}
	
	public static String getTitle()
	{
		return driver.getTitle();
		
	}
	
	public static void pWait(long val) throws Exception
	{
		driver.wait(val);
		
	}
	
	public static void close() throws Exception
	{
		driver.close();
		
	}
	
	public static void quit() throws Exception
	{
		driver.quit();
		
	}
	
	public static boolean isDisplayed(String locator) throws Exception
	{
		try {
			return pWebElementNowait(locator).isDisplayed();
			
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	// File operations
	
	public static HashMap<String, String> Session = new HashMap<String, String>();
	public static String HomeDirectoryPath = System.getProperty("user.dir");
	public static String DataFilePath = "C:\\Users\\abhin\\eclipse-workspace\\PlanitAssesment\\src\\test\\java\\Data\\TestData.xlsx";

	public static String readExcellCell(Row rowobject, int cellnumber) {

		String Cellvalue = null;
		try {
			Cellvalue = rowobject.getCell(cellnumber).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Cellvalue;
	}

	public static void readExcelByUniqueRowValue(String UniqueValue, String ExcelPath) {

		try {
			FileInputStream fis = new FileInputStream(ExcelPath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int RowCount = sheet.getLastRowNum();

			System.out.println("UniqueValue : " + UniqueValue);
			System.out.println("File Path : " + ExcelPath);
			System.out.println("Number of Rows : " + RowCount);

			for (int RowNumber = 0; RowNumber <= RowCount; RowNumber++) {
				String UniqueValue_File = readExcellCell(sheet.getRow(RowNumber), 0);

				if (UniqueValue_File.equalsIgnoreCase(UniqueValue)) {
					int ColumnCount = sheet.getRow(RowNumber).getLastCellNum();

					System.out.println("Number of Columns : " + ColumnCount);

					for (int ColumnNumber = 0; ColumnNumber < ColumnCount; ColumnNumber++) {
						System.out.println("Key : " + readExcellCell(sheet.getRow(0), ColumnNumber));
						System.out.println("Value : " + readExcellCell(sheet.getRow(RowNumber), ColumnNumber));
						
//						user1.userName = readExcellCell(sheet.getRow(0), ColumnNumber);
//						user1.password = readExcellCell(sheet.getRow(RowNumber), ColumnNumber);
						
						setsessionParameter(readExcellCell(sheet.getRow(0), ColumnNumber),
								readExcellCell(sheet.getRow(RowNumber), ColumnNumber));
						
					//	setsessionParameter(user1);

					}
					System.out.println("Session Value for CaseType : " + getsessionParameter("CaseType"));
					System.out.println("Session Value for LoginID : " + getsessionParameter("LoginID"));
					System.out.println("Session Value for Password : " + getsessionParameter("Password"));
					System.out.println("Excel data set");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setsessionParameter(String ParameterName, String ParameterValue) {

		Session.put(ParameterName, ParameterValue);
	}
	


	public static String getsessionParameter(String ParameterName) {

		if (Session.get(ParameterName) == null)
			return "'" + ParameterName + "' does not exist in session";

		else
			return Session.get(ParameterName);
	}

	public static void setCaseParametersForCaseType(String CaseType) {

		readExcelByUniqueRowValue(CaseType, DataFilePath);
	}
}
