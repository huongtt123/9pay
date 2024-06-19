import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev-mcv2.9pay.mobi')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/username'), 'hmc_lead_huong')

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/password'), 'Paygate@123')

WebUI.click(findTestObject('Object Repository/Page_Account 9Pay/btn Login'))

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/otp1'), '1')

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/otp2'), '2')

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/otp3'), '3')

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/otp4'), '4')

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/otp5'), '5')

WebUI.setText(findTestObject('Object Repository/Page_Account 9Pay/otp6'), '6')

WebUI.click(findTestObject('Object Repository/Page_Account 9Pay/btn Confirm Authen'))

WebUI.enableSmartWait()

WebUI.click(findTestObject('Page_Dashboard/span_Quan ly giao dich chuyen tien'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard/a_Chuyen tien 247'))

WebUI.click(findTestObject('Object Repository/Page_Chuyen tien 247/div_Ngan hang nhan tien'))

WebUI.click(findTestObject('Object Repository/Page_Chuyen tien 247/li_ABBANK - NH An Binh'))

WebUI.setText(findTestObject('Object Repository/Page_Chuyen tien 247/input_stk'), stk)

sotaikhoan = WebUI.getAttribute(findTestObject('Page_Chuyen tien 247/input_stk'), 'value')

System.out.println(sotaikhoan)

WebUI.click(findTestObject('Object Repository/Page_Chuyen tien 247/div_Kim tra'))

WebUI.enableSmartWait()

AccountName = WebUI.getText(findTestObject('Page_Chuyen tien 247/accountname'))

System.out.println(AccountName)

WebUI.setText(findTestObject('Object Repository/Page_Chuyen tien 247/input_amount'), amount)

amount = WebUI.getAttribute(findTestObject('Page_Chuyen tien 247/input_amount'), 'value')

System.out.println(amount)

amountreplace = amount.replaceAll('[^0-9]', '')

System.out.println('Số tiền replace: ' + Integer.parseInt(amountreplace))

fee = WebUI.getText(findTestObject('Page_Chuyen tien 247/text_fee'))

System.out.println(fee)

feereplace = fee.replaceAll('[^0-9]', '')

System.out.println('Tổng phí replace: ' + Integer.parseInt(feereplace))

WebUI.setText(findTestObject('Page_Chuyen tien 247/input_description'), description)

description = WebUI.getAttribute(findTestObject('Page_Chuyen tien 247/input_description'), 'value')

System.out.println(description)

WebUI.setText(findTestObject('Object Repository/Page_Chuyen tien 247/input__authcode'), authcode)

WebUI.click(findTestObject('Page_Chuyen tien 247/button_Chuyen tien'))

WebUI.enableSmartWait()

WebUI.click(findTestObject('Page_Chuyen tien 247/button_Xem giao dich'))

WebUI.enableSmartWait()

detail_amount = WebUI.getText(findTestObject('Page_Chi tiet Giao dich/detail_amount'))

System.out.println(detail_amount)

detailamount = detail_amount.replaceAll('[^0-9]', '')

System.out.println('Giá trị giao dịch replace: ' + Integer.parseInt(detailamount))

detail_accountname = WebUI.getText(findTestObject('Page_Chi tiet Giao dich/detail_accountname'))

System.out.println(detail_accountname)

detail_description = WebUI.getText(findTestObject('Page_Chi tiet Giao dich/detail_description'))

System.out.println(detail_description)

detail_feethanhtoan = WebUI.getText(findTestObject('Page_Chi tiet Giao dich/detail_fee thanh toan'))

System.out.println(detail_feethanhtoan)

feethantoan = detail_feethanhtoan.replaceAll('[^0-9]', '')

System.out.println('Phí thanh toán replace: ' + Integer.parseInt(feethantoan))

detail_feexuly = WebUI.getText(findTestObject('Page_Chi tiet Giao dich/detail_fee xu ly'))

System.out.println(detail_feexuly)

feexuly = detail_feexuly.replaceAll('[^0-9]', '')

System.out.println('Phí xử lý replace: ' + Integer.parseInt(feexuly))

detail_stk = WebUI.getText(findTestObject('Page_Chi tiet Giao dich/detail_stk'))

System.out.println(detail_stk)

WebUI.verifyEqual(sotaikhoan, detail_stk)

WebUI.verifyEqual(AccountName, detail_accountname)

WebUI.verifyEqual(description, detail_description)

WebUI.verifyEqual(Integer.parseInt(amountreplace), Integer.parseInt(detailamount))

System.out.println('Tổng phí: ' + (Integer.parseInt(feethantoan) + Integer.parseInt(feexuly)))

WebUI.verifyEqual(Integer.parseInt(feereplace), Integer.parseInt(feethantoan) + Integer.parseInt(feexuly))

WebUI.closeBrowser()

