package com.revature.driver;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.revature.tester.MethodUtil;

class Firefox implements IDriver {

	 public WebDriver selectDriver() {
		File f = null;
		if (System.getenv("PATH").contains("/home/")) {
			f = new File("src/main/resources/geckodriver");
			System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
			return new FirefoxDriver();
		} else {
			URL resource = MethodUtil.class.getClassLoader().getResource("geckodriver.exe");
			f = new File(resource.getFile());
			System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
			return new FirefoxDriver();
		}
	}
}
