package demo.selenium.pages;

import demo.selenium.utils.ConfigUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class SelectDropdownListPage {

    private WebDriverWait wait;
    private final Logger log = Logger.getLogger(SelectDropdownListPage.class);

    @FindBy(xpath = "//select[@id='select-demo']")
    WebElement singleSelect;

    @FindBy(xpath = "//p[@class='selected-value']")
    WebElement daySelectedTxt;

    @FindBy(xpath = "//select[@id='multi-select']")
    public WebElement stateMultiSelect;

    @FindBy(xpath = "//button[@id='printMe']")
    WebElement firstSelectedBtn;

    @FindBy(xpath = "//button[@id='printAll']")
    WebElement allSelectedBtn;

    @FindBy(xpath = "//p[@class='getall-selected']")
    WebElement optionsSelectedTxt;

    public SelectDropdownListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, ConfigUtil.getExplicitWaitTimeProperty());
    }

    public void selectDayByText(String text) {
        log.info("Select a day by text from single select");
        wait.until(ExpectedConditions.visibilityOfAllElements(singleSelect));
        Select select = new Select(singleSelect);
        select.selectByVisibleText(text);
    }

    public void selectDayByValue(String value) {
        log.info("Select a day by value from single select");
        wait.until(ExpectedConditions.visibilityOfAllElements(singleSelect));
        Select select = new Select(singleSelect);
        select.selectByValue(value);
    }

    public void selectDayByIndex(int index) {
        log.info("Select a day by index from single select");
        wait.until(ExpectedConditions.visibilityOfAllElements(singleSelect));
        Select select = new Select(singleSelect);
        select.selectByIndex(index);
    }

    public String getSelectedDay() {
        wait.until(ExpectedConditions.visibilityOfAllElements(daySelectedTxt));
        return daySelectedTxt.getText();
    }

    public void selectStateByText(List<String> states) {
        log.info("Select a state by name from multi select");
        wait.until(ExpectedConditions.visibilityOfAllElements(stateMultiSelect));
        Select select = new Select(stateMultiSelect);
        List<WebElement> options = select.getOptions();
        for (WebElement element : options) {
            for (String state : states) {
                if (element.getText().equalsIgnoreCase(state)) {
                    element.click();
                }
            }
        }
    }

    public List<String> getSelectedStates() {
        List<String> states = new LinkedList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(stateMultiSelect));
        Select select = new Select(stateMultiSelect);
        List<WebElement> options = select.getOptions();
        for (WebElement element : options) {
            if(element.isSelected()){
                states.add(element.getText());
            }
        }
        return  states;
    }

    public void clickOnFirstSelectedBtn() {
        log.info("Click on \'First Selected\' button");
        wait.until(ExpectedConditions.elementToBeClickable(firstSelectedBtn));
        firstSelectedBtn.click();
    }

    public void clickOnAllSelectedBtn() {
        log.info("Click on \'Get All Selected\' button");
        wait.until(ExpectedConditions.elementToBeClickable(allSelectedBtn));
        allSelectedBtn.click();
    }

    public String getSelectedOptions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(optionsSelectedTxt));
        return optionsSelectedTxt.getText();
    }
}
