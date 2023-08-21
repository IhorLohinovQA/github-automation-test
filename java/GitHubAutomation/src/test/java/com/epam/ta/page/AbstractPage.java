package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage
{
	protected WebDriver driver;

	protected abstract AbstractPage openPage();
	protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}

	protected void waitForElement(By locator) {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

}
