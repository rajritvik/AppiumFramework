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
		String s=result.getName();
		try {
			Base.getScreenshot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
