package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.util.Navigator.waitOn;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@Component
@Scope("cucumber-glue")
public class HomePage extends BasePage {

    public static final String titleFieldSel = "//div/h1[@class='heading']";

    public static final String allLinksFieldSel = "//div[@id=\"content\"]/ul/li";

    public static final String specificLinkFieldSel = allLinksFieldSel + "/a[text()=\"%s\"]";

    @FindBy(xpath = titleFieldSel)
    WebElement titleField;

    @FindBy(xpath = allLinksFieldSel)
    List<WebElement> allLinksField;

    @Autowired
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        waitOn(driver, xpath(titleFieldSel));
        return titleField.getText();
    }

    public boolean containsLink(String link) {
        return allLinksField.stream()
                .anyMatch(webElement -> webElement.getText().contains(link));
    }

    public void clickLink(final String linkText) {
        WebElement linkElement = driver.findElement(xpath(format(specificLinkFieldSel, linkText)));
        if (!linkElement.isDisplayed()) {
            throw new IllegalArgumentException(String.format("No Link Found with text %s", linkText));
        }
        linkElement.click();
    }

}
