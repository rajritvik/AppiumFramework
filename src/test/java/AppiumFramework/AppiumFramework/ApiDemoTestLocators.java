package AppiumFramework.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemoTestLocators extends Base
{
	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException 
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemos");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		driver.closeApp();
		
		service.stop();
		System.out.println("Server Stopped");
	}

}
