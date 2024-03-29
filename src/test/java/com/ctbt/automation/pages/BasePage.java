package com.ctbt.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class BasePage {

	protected WebDriver driver;
	protected FluentWait<WebDriver> waiter;

	public BasePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		waiter = new FluentWait<>(driver)
				.ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(2));
	}
	public static String generateRandomString() {
		// Define alphabet characters
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		// Generate a random length between 6 and 10
		Random random = new Random();
		int length = random.nextInt(5) + 6; // Generates a random number between 6 and 10 (inclusive)

		// Generate the random string
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toUpperCase(alphabet.charAt(random.nextInt(alphabet.length())))); // First character is uppercase
		for (int i = 1; i < length; i++) {
			sb.append(alphabet.charAt(random.nextInt(alphabet.length()))); // Rest of the characters are lowercase
		}
		return sb.toString();
	}
	public void clickElement(By locator) {
		WebElement element = waitForElement(locator);
		clickAndWait(element);
	}

	public void sendKeysToElement(By locator, String keys) {
		WebElement element = waitForElement(locator);
		waitAndType(element, keys);
	}

	public WebElement waitForElement(By locator) {
		return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void switchToWindowByText(String windowTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(windowTitle)) {
				return;
			}
		}
		throw new NoSuchElementException("Window with title '" + windowTitle + "' not found.");
	}

	public void hoverOverElement(By locator) {
		WebElement element = waitForElement(locator);
		new Actions(driver).moveToElement(element).perform();
	}

	public void doubleClickElement(By locator) {
		WebElement element = waitForElement(locator);
		new Actions(driver).doubleClick(element).perform();
	}

	public void javaScriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickElementWithMouse(WebElement element) {
		new Actions(driver).click(element).perform();
	}

	public void uploadImageUsingRobot(String filePath) {
		waitFor(4); // Increased wait time for better reliability
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		waitFor(5); // Increased wait time for better reliability
	}

	public static void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void waitAndType(WebElement element, String text) {
		waitForVisibilityOf(element);
		element.clear();
		element.sendKeys(text);
	}

	void clickAndWait(WebElement element) {
		waitForVisibilityOf(element);
		element.click();
		waitFor(3);
	}

	void waitForVisibilityOf(WebElement element) {
		waiter.until(ExpectedConditions.visibilityOf(element));
	}

	protected static String generateRandomString(int length) {
		String randomUUIDString = UUID.randomUUID().toString();
		return randomUUIDString.replaceAll("-", "").substring(0, length);
	}

	protected static long generateRandom10DigitNumber() {
		Random rand = new Random();
		return 1000000000L + rand.nextLong() % (10000000000L - 1000000000L);
	}

	protected boolean isElementDisplayed(WebElement element) {
		try {
			waitForVisibilityOf(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected void selectDropdownOption(WebElement dropdown) {
		clickAndWait(dropdown);
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public  void scrollToElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public  void bringElementIntoView( WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center', behavior: 'smooth'});", element);
	}
	public  void moveToElement( WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public  void focusOnElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();", element);
	}
	public  void scrollVerticalWithRobot(int scrollAmount) {
		try {
			Robot robot = new Robot();

			// Press the down arrow key 'scrollAmount' times
			for (int i = 0; i < Math.abs(scrollAmount); i++) {
				if (scrollAmount < 0) {
					robot.keyPress(KeyEvent.VK_UP);
					robot.keyRelease(KeyEvent.VK_UP);
				} else {
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyRelease(KeyEvent.VK_DOWN);
				}
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public  void scrollVerticallyWithMouse( int yOffset) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, yOffset).perform();
	}
	public void scrollDownUsingRobot(){
		try {
			Robot robot = new Robot();
			robot.mouseWheel(1);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static boolean verifyElement(WebDriver driver, By locator, int timeoutInSeconds) {
		Instant start = Instant.now();
		Duration timeout = Duration.ofSeconds(timeoutInSeconds);
		while (Duration.between(start, Instant.now()).compareTo(timeout) < 0) {
			try {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed() && element.isEnabled()) {
					return true; // Element is visible and present
				}
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
				// Element not found or not attached to the DOM, continue waiting
			}
			// Sleep for a short interval before retrying
			try {
				Thread.sleep(1000); // Sleep for 1 second
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		return false; // Timeout reached, element not visible or present
	}
	public static boolean verifyElement(WebElement element, int timeoutInSeconds) {
		Instant start = Instant.now();
		Duration timeout = Duration.ofSeconds(timeoutInSeconds);
		while (Duration.between(start, Instant.now()).compareTo(timeout) < 0) {
			try {

				if (element.isDisplayed() && element.isEnabled()) {
					return true; // Element is visible and present
				}
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
				// Element not found or not attached to the DOM, continue waiting
			}
			// Sleep for a short interval before retrying
			try {
				Thread.sleep(1000); // Sleep for 1 second
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		return false; // Timeout reached, element not visible or present
	}
}
