package AbhinavA.Coding.PlanitAssesment;

import java.text.DecimalFormat;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClass.JupiterToys_ContactPage;

public class Testcases extends JupiterToys_ContactPage {

	static ExtentTest test;
	static ExtentReports report;
	public static final String appURL = "http://jupiter.cloud.planittesting.com";

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(
				"target\\" + "extentReport.html");
		

	}

	@Test
	public void TestCase_1() throws Exception {
		test = report.startTest("TestCase_1");
		String ForeName_ExpectedErrMessage = "Forename is required";
		String ForeName_ActualErrMessage;

		String Email_ExpectedErrMessage = "Email is required";
		String Email_ActualErrMessage;

		String Message_ExpectedErrMessage = "Message is required";
		String Message_ActualErrMessage;

		setCaseParametersForCaseType("TestCase1");

		launchBrowser("Chrome");
		launchWebsite(appURL); // pWait(2000);
		maximizeWindow();

		if (getTitle().equals("Jupiter Toys")) {
			System.out.println("Entered IF Condition");
			test.log(LogStatus.INFO, "Jupiter Toys page open and User will Navigate to Contact Tab");

			click(JupiterToys_ContactPage.ContactTab);
			click(JupiterToys_ContactPage.Submit_Btn);

			ForeName_ActualErrMessage = getText(JupiterToys_ContactPage.ForeName_ErrMessage);

			Verify.verify(ForeName_ExpectedErrMessage.contentEquals(ForeName_ActualErrMessage));

			Email_ActualErrMessage = getText(JupiterToys_ContactPage.Email_ErrMessage);

			Verify.verify(Email_ExpectedErrMessage.contentEquals(Email_ActualErrMessage));

			Message_ActualErrMessage = getText(JupiterToys_ContactPage.Message_ErrMessage);

			Verify.verify(Message_ExpectedErrMessage.contentEquals(Message_ActualErrMessage));

			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Error Message Verified");

			sendKeys(JupiterToys_ContactPage.ForeName_text, "Abhinav");
			Assert.assertFalse(isDisplayed(JupiterToys_ContactPage.ForeName_ErrMessage));
			sendKeys(JupiterToys_ContactPage.Email_text, "Abhinav.agrawal88@gmail.com");
			Assert.assertFalse(isDisplayed(JupiterToys_ContactPage.Email_ErrMessage));
			sendKeys(JupiterToys_ContactPage.Message_text, "input message for testcase 1");
			Assert.assertFalse(isDisplayed(JupiterToys_ContactPage.Message_ErrMessage));

			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))
					+ "Mandatory fields populated and Error Message disappeared");

		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Test Failed");
		}

		close();
		report.endTest(test);
	}

	@Test
	public void TestCase_2() throws Exception {
		test = report.startTest("TestCase_2");
		setCaseParametersForCaseType("TestCases");
		String foreNameVal = "Abhinav";

		launchBrowser("Chrome");
		launchWebsite(appURL); // pWait(2000);
		maximizeWindow();

		boolean finalResullt = true;
		int passCount = 0;
		int failCount = 0;
		int totalCount = 5;
		for (int i = 1; i <= totalCount; i++) {
			String successMsgVal = "Thanks " + foreNameVal + i + ", we appreciate your feedback.";
			if (getTitle().equals("Jupiter Toys")) {
				System.out.println("Entered IF Condition");
				test.log(LogStatus.INFO, "Jupiter Toys page open and User will Navigate to Contact Tab");

				click(JupiterToys_ContactPage.ContactTab);
				click(JupiterToys_ContactPage.Submit_Btn);
				sendKeys(JupiterToys_ContactPage.ForeName_text, "Abhinav" + i);
				sendKeys(JupiterToys_ContactPage.Email_text, "Abhinav.agrawal88@gmail.com");
				sendKeys(JupiterToys_ContactPage.Message_text, "input message for testcase 1");
				click(JupiterToys_ContactPage.Submit_Btn);
				Thread.sleep(8000);
				System.out.println(isDisplayed(JupiterToys_ContactPage.successSubMsg));
				System.out.println(getText(JupiterToys_ContactPage.successSubMsg));
				Assert.assertTrue(isDisplayed(JupiterToys_ContactPage.successSubMsg));
				Assert.assertTrue(getText(JupiterToys_ContactPage.successSubMsg).equals(successMsgVal));
				if (isDisplayed(JupiterToys_ContactPage.successSubMsg)
						&& getText(JupiterToys_ContactPage.successSubMsg).equals(successMsgVal)) {
					finalResullt = finalResullt && true;
					passCount++;
				} else {
					finalResullt = finalResullt && false;
					failCount++;
				}

				test.log(LogStatus.PASS,
						test.addScreenCapture(capture(driver)) + "Success message validated in attempt " + i);
				if (i != totalCount) {
					click(JupiterToys_ContactPage.back_Btn);
				}
			} else { 
				test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Test Failed in attempt " + i);
				finalResullt = finalResullt && false;
				failCount++;
			}
		}
		System.out.println("pass count" + passCount);
		System.out.println("pass percent" + (passCount / totalCount) * 100);
		if ((passCount / totalCount) * 100 == 100) {
			test.log(LogStatus.PASS,
					test.addScreenCapture(capture(driver)) + "Test pass in all " + totalCount + " attempts.");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Test fail in " + failCount
					+ " attempts out of  " + totalCount + " attempts.");
		}
		close();
		report.endTest(test);
	}

	@Test
	public void TestCase_3() throws Exception {
		test = report.startTest("TestCase_3");
		DecimalFormat df_obj = new DecimalFormat("#.##");

		int expectedStuffedFrogQuantity = 2;
		int expectedFluffyBunnyQuantity = 5;
		int expectedValentineBearQuantity = 3;

		int actualStuffedFrogQuantity;
		int actualFluffyBunnyQuantity;
		int actualValentineBearQuantity;

		float actualStuffedFrogSubtotal;
		float actualFluffyBunnySubtotal;
		float actualValentineBearSubtotal;

		float expectedStuffedFrogSubtotal;
		float expectedFluffyBunnySubtotal;
		float expectedValentineBearSubtotal;

		float actualStuffedFrogShopPrice;
		float actualFluffyBunnyShopPrice;
		float actualValentineBearShopPrice;

		float actualStuffedFrogCartPrice;
		float actualFluffyBunnyCartPrice;
		float actualValentineBearCartPrice;

		setCaseParametersForCaseType("TestCases");
		String foreNameVal = "Abhinav";

		launchBrowser("Chrome");
		launchWebsite(appURL);

		maximizeWindow();

		if (getTitle().equals("Jupiter Toys")) {
			System.out.println("Entered IF Condition");
			click(JupiterToys_ContactPage.startShopping_Link);
			test.log(LogStatus.INFO, "Jupiter Toys page open and User will Navigate to start shopping");
			System.out.println(productPriceShop("Stuffed Frog"));
			Thread.sleep(3000);
			System.out.println(getText(productPriceShop("Stuffed Frog")));
			actualStuffedFrogShopPrice = Float
					.parseFloat(getText(productPriceShop("Stuffed Frog")).replace("$", "").trim());
			actualFluffyBunnyShopPrice = Float
					.parseFloat(getText(productPriceShop("Fluffy Bunny")).replace("$", "").trim());
			actualValentineBearShopPrice = Float
					.parseFloat(getText(productPriceShop("Valentine Bear")).replace("$", "").trim());

			System.out.println(actualStuffedFrogShopPrice);
			System.out.println(actualFluffyBunnyShopPrice);
			System.out.println(actualValentineBearShopPrice);

			for (int i = 1; i <= expectedStuffedFrogQuantity; i++) {
				click(JupiterToys_ContactPage.buy("Stuffed Frog"));
			}
			for (int i = 1; i <= expectedFluffyBunnyQuantity; i++) {
				click(JupiterToys_ContactPage.buy("Fluffy Bunny"));
			}

			for (int i = 1; i <= expectedValentineBearQuantity; i++) {
				click(JupiterToys_ContactPage.buy("Valentine Bear"));
			}

			click(JupiterToys_ContactPage.cart_Link);

			actualStuffedFrogQuantity = Integer
					.parseInt(getAttributeValue(cartProductQuantity("Stuffed Frog"), "value"));
			actualFluffyBunnyQuantity = Integer
					.parseInt(getAttributeValue(cartProductQuantity("Fluffy Bunny"), "value"));
			actualValentineBearQuantity = Integer
					.parseInt(getAttributeValue(cartProductQuantity("Valentine Bear"), "value"));

			System.out.println("actualStuffedFrogQuantity" + actualStuffedFrogQuantity);

			actualStuffedFrogSubtotal = Float
					.parseFloat(getText(cartProductSubtotal("Stuffed Frog")).replace("$", "").trim());
			actualFluffyBunnySubtotal = Float
					.parseFloat(getText(cartProductSubtotal("Fluffy Bunny")).replace("$", "").trim());
			actualValentineBearSubtotal = Float
					.parseFloat(getText(cartProductSubtotal("Valentine Bear")).replace("$", "").trim());

			expectedStuffedFrogSubtotal = expectedStuffedFrogQuantity * actualStuffedFrogShopPrice;
			expectedStuffedFrogSubtotal = Float.parseFloat(df_obj.format(expectedStuffedFrogSubtotal));
			expectedFluffyBunnySubtotal = expectedFluffyBunnyQuantity * actualFluffyBunnyShopPrice;
			expectedFluffyBunnySubtotal = Float.parseFloat(df_obj.format(expectedFluffyBunnySubtotal));
			expectedValentineBearSubtotal = expectedValentineBearQuantity * actualValentineBearShopPrice;
			expectedValentineBearSubtotal = Float.parseFloat(df_obj.format(expectedValentineBearSubtotal));
			actualStuffedFrogCartPrice = Float
					.parseFloat(getText(productPriceCart("Stuffed Frog")).replace("$", "").trim());
			actualFluffyBunnyCartPrice = Float
					.parseFloat(getText(productPriceCart("Fluffy Bunny")).replace("$", "").trim());
			actualValentineBearCartPrice = Float
					.parseFloat(getText(productPriceCart("Valentine Bear")).replace("$", "").trim());

			Float sumOfSubtotal = 0.00F;
			for (WebElement eb : pWebElements(JupiterToys_ContactPage.subtotalColumn)) {
				sumOfSubtotal = Float.parseFloat(eb.getText().replace("$", "").trim()) + sumOfSubtotal;

				sumOfSubtotal = Float.parseFloat(df_obj.format(sumOfSubtotal));
			}

			Float totalCartPrice = Float.parseFloat(getText(totalAmount).replace("Total:", "").trim());

			// Verify the price for each product is correct
			if (actualStuffedFrogCartPrice == actualStuffedFrogShopPrice) {
				test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Price for Stuffed Frog on cart "
						+ actualStuffedFrogCartPrice + " matches price on shop " + actualStuffedFrogShopPrice);
			} else {
				test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Price for Stuffed Frog on cart "
						+ actualStuffedFrogCartPrice + " does not match price on shop " + actualStuffedFrogShopPrice);
			}

			if (actualFluffyBunnyCartPrice == actualFluffyBunnyShopPrice) {
				test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Price for Stuffed Frog on cart "
						+ actualFluffyBunnyCartPrice + " matches price on shop " + actualFluffyBunnyShopPrice);
			} else {
				test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Price for Stuffed Frog on cart "
						+ actualFluffyBunnyCartPrice + " does not match price on shop " + actualFluffyBunnyShopPrice);
			}

			if (actualValentineBearCartPrice == actualValentineBearShopPrice) {
				test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Price for Stuffed Frog on cart "
						+ actualValentineBearCartPrice + " matches price on shop " + actualValentineBearShopPrice);
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(capture(driver)) + "Price for Stuffed Frog on cart "
								+ actualValentineBearCartPrice + " does not match price on shop "
								+ actualValentineBearShopPrice);
			}

			// Verify the subtotal for each product is correct
			if (actualStuffedFrogSubtotal == expectedStuffedFrogSubtotal) {
				test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Subtotal for Stuffed Frog on cart "
						+ actualStuffedFrogSubtotal + " matches expected subtotal " + expectedStuffedFrogSubtotal);
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(capture(driver)) + "Subtotal for Stuffed Frog on cart "
								+ actualStuffedFrogSubtotal + " does not match expected subtotal "
								+ expectedStuffedFrogSubtotal);
			}

			if (actualFluffyBunnySubtotal == expectedFluffyBunnySubtotal) {
				test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Subtotal for Stuffed Frog on cart "
						+ actualFluffyBunnySubtotal + " matches expected subtotal " + expectedFluffyBunnySubtotal);
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(capture(driver)) + "Subtotal for Stuffed Frog on cart "
								+ actualFluffyBunnySubtotal + " does not match expected subtotal "
								+ expectedFluffyBunnySubtotal);
			}

			if (actualValentineBearSubtotal == expectedValentineBearSubtotal) {
				test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Subtotal for Stuffed Frog on cart "
						+ actualValentineBearSubtotal + " matches expected subtotal " + expectedValentineBearSubtotal);
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(capture(driver)) + "Subtotal for Stuffed Frog on cart "
								+ actualValentineBearSubtotal + " does not match expected subtotal "
								+ expectedValentineBearSubtotal);
			}

			// verify cart total against subtotal column

			if (totalCartPrice.equals(sumOfSubtotal)) {
				test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Cart total " + totalCartPrice
						+ " matches sum of subtotal " + sumOfSubtotal);
			} else {
				test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Cart total " + totalCartPrice
						+ " does not match sum of subtotal " + sumOfSubtotal);
			}

		} else {
			// test.log(LogStatus.FAIL, "Test Failed");
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Test Failed");

		}

		close();
		report.endTest(test);
	}

	@AfterClass
	public static void endTest() throws Exception {
		quit();
		report.flush();
	}

}
