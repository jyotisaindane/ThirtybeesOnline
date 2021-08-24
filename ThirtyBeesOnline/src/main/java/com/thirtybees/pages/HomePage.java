package com.thirtybees.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.thirtybees.objectRepository.HomePageObjectRepo;
import com.thirtybees.utility.ActionUtil;
import com.thirtybees.utility.ExcelUtil;

public class HomePage extends HomePageObjectRepo{
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToLoginPage() {
		ActionUtil.click(signInLink);
	}
	
	
	public CandlePage navigateToCandlePage() {
		candleImg.click();
		return new CandlePage(driver);	
	}
	
	public SoapPage navigateToSoapPage() {
		soapImg.click();
		return new SoapPage(driver);	
	}
	
	public MugPage navigateToMugPage() {
		mugImg.click();
		return new MugPage(driver);	
	}
	
	public String verifyLabelOfCandle() {
		String actText=candle.getText();
		return actText;
	}
	
	public String verifyLabelOfSoap() {
		String actText=soap.getText();
		return actText;
	}
	
	public boolean verifyBlogHeaders() {
		ArrayList<String> actHeader=new ArrayList<String>();
		for(WebElement header: blogHeaders) {
			actHeader.add(header.getText());	
		}
		System.out.println("Actual blog headers are "+actHeader);
		
		ArrayList<String> expHeader=ExcelUtil.getAllData(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx", "Blog headers");
		System.out.println("Expected blog headers are "+expHeader);
		
		if(actHeader.equals(expHeader)) {
			return true;
		}
		return false;
	}
	
	public boolean verifySliderHeading() {
		ArrayList<String> actHeader=new ArrayList<String>();
		System.out.println("Actual slider heading from website");
		for(WebElement header: sliderHeading) {
			actHeader.add(header.getText());
			ActionUtil.click(nextBtn);
			System.out.println(actHeader);
		}System.out.println(actHeader);
		/*
		 * System.out.println("Expected slider heading from website"); ArrayList<String>
		 * expHeader=ExcelUtil.getAllData(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\TestData.xlsx", "Blog headers");
		 */
		return false;
		
		
	}
	
	
}
