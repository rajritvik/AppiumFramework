package AppiumFramework.AppiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidDriverCommonLib 
{
	public static void scrollDownToText(AndroidDriver<AndroidElement> driver, String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
	}
	
	public static void tapping(AndroidDriver<AndroidElement> driver, WebElement element)
	{
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(element))).perform();
	}
	
	public static void longPress(AndroidDriver<AndroidElement> driver, WebElement element)
	{
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(2))).release().perform();
	}
	
	public static void dragAndDrop(AndroidDriver<AndroidElement> driver, WebElement src, WebElement dest)
	{
		TouchAction t = new TouchAction(driver);
//		t.longPress(longPressOptions().withElement(element(src))).moveTo(element(dest)).release().perform();
		
		                           //OR
		
		t.longPress(element(src)).moveTo(element(dest)).release().perform();
	}
	
	public static void swiping(AndroidDriver<AndroidElement> driver, WebElement first, WebElement second)
	{
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
	}

}
