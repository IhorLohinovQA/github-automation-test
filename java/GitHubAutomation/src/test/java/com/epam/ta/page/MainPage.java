package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";

	@FindBy(xpath = "//a[contains(@data-hydro-click, 'location=left')]")
	private WebElement buttonCreateNew;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement linkNewRepository;

	@FindBy(xpath = "//*[@aria-label='Open user account menu']")
	private WebElement avatarMenuOpen;


	private final By linkLoggedInUserLocator = By.xpath("//meta[@name='user-login']"); //вынесение локатора в отдельную переменную, чтобы иметь возможность переиспользовать ее в будущем

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public CreateNewRepositoryPage invokeNewRepositoryCreation()
	{
		waitForElement(By.xpath("//a[contains(@data-hydro-click, 'location=left')]"));
		buttonCreateNew.click();
		return new CreateNewRepositoryPage(driver);
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}


	public String getLoggedInUserName()
	{
		waitForElement(By.xpath("//*[@aria-label='Open user account menu']"));
		avatarMenuOpen.click();
		WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
		return linkLoggedInUser.getAttribute("content");
	}

}
