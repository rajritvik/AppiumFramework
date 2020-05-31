package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import AppiumFramework.AppiumFramework.Base;

public class Listeners implements ITestListener 
{

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String scriptName=result.getName();
		try {
			Base.getScreenshot(scriptName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
