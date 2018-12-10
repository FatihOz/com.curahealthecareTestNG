package com.curahealthecareTestNG.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BrowserUtils {

	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getScreenshot(String name) throws IOException {

		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
		File finalDestination = new File(target);
		FileUtils.copyFile(source, finalDestination);
		return target;
	}
}
