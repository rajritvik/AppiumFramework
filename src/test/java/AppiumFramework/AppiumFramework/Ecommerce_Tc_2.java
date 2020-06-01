package AppiumFramework.AppiumFramework;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Ecommerce_Tc_2 extends Base
{	
	@Test
	public void passedScenario() throws InterruptedException, IOException
	{
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("abcd");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementByClassName("android.widget.Button").click();
		
		String actMsg=driver.findElement(By.xpath("//android.widget.TextView[@text='Products']")).getText();
		Assert.assertEquals(actMsg, "Products");
		Reporter.log("Test Successfully passed", true);
		
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);
		
		
		String amnt1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		amnt1=amnt1.substring(1);
		double amnt1value=Double.parseDouble(amnt1);
		
		String amnt2=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		amnt2=amnt2.substring(1);
		double amnt2value=Double.parseDouble(amnt2);
		
		double sum = amnt1value+amnt2value;
		
		String totalAmnt = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		totalAmnt=totalAmnt.substring(1);
		double totalAmntValue=Double.parseDouble(totalAmnt);
		
		Assert.assertEquals(sum, totalAmntValue);
		System.out.println(sum);
		
		TouchAction t = new TouchAction(driver);
		
		AndroidElement chkBox = driver.findElementByClassName("android.widget.CheckBox");
		
		t.tap(tapOptions().withElement(element(chkBox))).perform();
		
		AndroidElement tc = driver.findElementById("com.androidsample.generalstore:id/termsButton");
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		
		driver.findElementById("android:id/button1").click();
		
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		Thread.sleep(5000);
		
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) 
		{
		    System.out.println(contextName); 
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Ritvik");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
	}
}
