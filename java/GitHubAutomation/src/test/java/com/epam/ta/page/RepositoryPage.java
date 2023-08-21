package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepositoryPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"repository-container-header\"]//strong/a")
    private WebElement linkCurrentRepository;

    public RepositoryPage (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getCurrentRepositoryName()
    {
        waitForElement(By.xpath("//strong[text()='Quick setup']"));
        return linkCurrentRepository.getText();
    }

    @Override
    public RepositoryPage openPage()
    {
        return this;
    }
}
