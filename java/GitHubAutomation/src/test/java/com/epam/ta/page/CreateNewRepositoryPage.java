package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewRepositoryPage extends AbstractPage
{
	private final String BASE_URL = "http://www.github.com/new";
	private final Logger logger = LogManager.getRootLogger();

	@FindBy(id = "react-aria-2")
	private WebElement inputRepositoryName;

	@FindBy(id = "react-aria-3")
	private WebElement inputRepositoryDescription;

	@FindBy(xpath = "//span[text()='Create repository']")
	private WebElement buttonCreate;

	public CreateNewRepositoryPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public RepositoryPage createNewRepository(String repositoryName, String repositoryDescription)
	{
		waitForElement(By.id("react-aria-2"));
		inputRepositoryName.sendKeys(repositoryName);
		waitForElement(By.id("RepoNameInput-is-available"));
		inputRepositoryDescription.sendKeys(repositoryDescription);
		buttonCreate.click();
		logger.info("Created repository with name: [" + repositoryName +
				"] and description: [" + repositoryDescription + "]");
		return new RepositoryPage(driver);
	}

	@Override
	public CreateNewRepositoryPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

}
