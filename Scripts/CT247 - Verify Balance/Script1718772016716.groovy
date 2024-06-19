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

textBalance = WebUI.getText(findTestObject('Page_Chuyen tien 247/text_balance'))

balanceNumber = 0

String regex = '([\\d,]+)(?=\\sVND)'

String string = textBalance

Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE)

Matcher matcher = pattern.matcher(string)

while (matcher.find()) {
    balanceNumber = matcher.group(0)
}

balanceChuareplace = balanceNumber

balanceNumber = balanceNumber.replace(',', '')

System.out.println('Balance String: ' + balanceChuareplace)

System.out.println('Balance: ' + balanceNumber)

WebUI.click(findTestObject('Object Repository/Page_Chuyen tien 247/div_Ngan hang nhan tien'))

WebUI.click(findTestObject('Object Repository/Page_Chuyen tien 247/li_ABBANK - NH An Binh'))

WebUI.setText(findTestObject('Object Repository/Page_Chuyen tien 247/input_stk'), '66668888')

WebUI.click(findTestObject('Object Repository/Page_Chuyen tien 247/div_Kim tra'))

WebUI.enableSmartWait()

AccountName = WebUI.getText(findTestObject('Page_Chuyen tien 247/accountname'))

System.out.println(AccountName)

WebUI.setText(findTestObject('Object Repository/Page_Chuyen tien 247/input_amount'), '50000')

TotalAmount = WebUI.getText(findTestObject('Page_Chuyen tien 247/TotalAmount'))

System.out.println(TotalAmount)

TotalAmountNumber = 0

TotalAmountChuareplace = TotalAmount

TotalAmountNumber = TotalAmount.replace(',', '')

System.out.println('TotalAmount String: ' + TotalAmountChuareplace)

System.out.println('TotalAmount: ' + TotalAmountNumber)

if (Integer.parseInt(balanceNumber) >= Integer.parseInt(TotalAmountNumber)) {
    System.out.println('Hop le')
} else {
    System.out.println('Khong hop le')

    return false
}

WebUI.setText(findTestObject('Page_Chuyen tien 247/input_description'), 'Test so du chuyen tien 247')

WebUI.setText(findTestObject('Object Repository/Page_Chuyen tien 247/input__authcode'), '123456')

WebUI.click(findTestObject('Page_Chuyen tien 247/button_Chuyen tien'))

WebUI.enableSmartWait()

WebUI.click(findTestObject('Page_Chuyen tien 247/button_Chuyen tiep'))

textBalance2 = WebUI.getText(findTestObject('Page_Chuyen tien 247/text_balance'))

balanceNumber2 = 0

String regex2 = '([\\d,]+)(?=\\sVND)'

String string2 = textBalance2

Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE)

Matcher matcher2 = pattern2.matcher(string2)

while (matcher2.find()) {
    balanceNumber2 = matcher2.group(0)
}

balanceChuareplace2 = balanceNumber2

balanceNumber2 = balanceNumber2.replace(',', '')

System.out.println('Balance String: ' + balanceChuareplace2)

System.out.println('Balance sau: ' + balanceNumber2)

System.out.println('Balance sau chuyen khoan: ' + (Integer.parseInt(balanceNumber) - Integer.parseInt(TotalAmountNumber)))

WebUI.verifyEqual(balanceNumber2, Integer.parseInt(balanceNumber) - Integer.parseInt(TotalAmountNumber))

WebUI.closeBrowser()

