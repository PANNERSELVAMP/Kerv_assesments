package com.BaseMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private static final Transferable StringSelectionVariable = null;
	static WebDriver driver;

	
	public static WebDriver Browser_Launch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("gecko")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("the invalid browser");
		}

		return driver;
	}
	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void clearText(WebElement element) {
		element.clear();
	}

	public static void sleep(int a) throws InterruptedException {
		Thread.sleep(a);
	}

	public static String get_Text(WebElement element) {
		String text = element.getText();
		System.out.println("Gettext :" + text);
		return text;
	}

	public static void get_Attribute_Placeholder(WebElement element, String value) {
		String attribute = element.getAttribute("Placeholder");
		System.out.println("attribute : " + attribute);

	}

	public static boolean isDisplayed(WebElement element) {
		boolean displayed = isDisplayed(element);
		System.out.println(displayed);
		return displayed;
	}

	public static void is_enable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	public static void is_selected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	public static void jsclick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",element);
		 }
	
		 public static void ScrollByElement(String text) {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,"+text+");");
		 }
	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void close() {
		driver.close();
	}

	public static void fullscreen() {
		driver.manage().window().maximize();
	}

	public static void quit() {
		driver.quit();
	}

	public static void navigateTourl(String url) {
		driver.navigate().to(url);
	}

	public static void imwait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String getWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static Set<String> getMultileWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public static void keyDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void keyUp() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
 }
	public void fileuploadMethod(String path) throws AWTException {
		Robot r = new Robot();
		StringSelection StringSelectionVariable=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelectionVariable, null);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	public static void keyTab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public static void keyEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void acceptSendkeys(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void alert(String option) {

		Alert alert = driver.switchTo().alert();
		if (option.equalsIgnoreCase("ok")) {
			alert.accept();
		} else if (option.equalsIgnoreCase("cancel")) {
			alert.dismiss();
		}
	}

	public static void frameSwitch(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static int totalFrame(List<WebElement> element) {
		int size = element.size();
		return size;

	}

	public static void mouseBasedActions(String option, WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		if (option.equalsIgnoreCase("move")) {
			a.moveToElement(element).build().perform();
		} else if (option.equalsIgnoreCase("click")) {
			a.click(element).perform();
		}
	}

	public static void drpDownSelect(WebElement element, String option, String value) {

		Select s = new Select(element);

		if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			// s.selectByVisibleText(value);
			List<WebElement> dropdownOptions = s.getOptions();

			for (int i = 0; i < dropdownOptions.size(); i++) {

				WebElement eachoption = dropdownOptions.get(i); // index- webelement

				String eachText = get_Text(eachoption);

				if (eachText.equalsIgnoreCase(value)) {
					s.selectByVisibleText(eachText);
				}
			}
		} else if (option.equalsIgnoreCase("index")) {
			int p = Integer.parseInt(value);
			s.selectByIndex(p);

		} else {
			System.out.println("invalid select");
		}

	}

}
