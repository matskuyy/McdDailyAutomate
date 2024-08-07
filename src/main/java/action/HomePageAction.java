package action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import locator.HomePage;
import utils.CustomKeywords;
import utils.HelperClass;

public class HomePageAction extends CustomKeywords {
	HomePage homeP = new HomePage();

	
	public HomePageAction() {
		this.homeP= new HomePage();
		PageFactory.initElements(HelperClass.getDriver(), homeP);
	}
	
	public void verifyHomePage() {
		waitForElementToBePresent(homeP.listBannerHome);
		isElementPresent(homeP.listBannerHome);
	}
	
	
	public int getPaginationBanner() {			
        java.util.List<WebElement> paginations = homeP.PaginationBanner;
		return paginations.size();
	}
	
    public boolean verifyBannerHome() {
        int bannerCount = getPaginationBanner();
        System.out.println("Banner:"+ bannerCount);
        return bannerCount >= 3 && bannerCount <= 5;
    }
    
    public int getAmountCardPromo() {
    	waitForElementToBePresent(homeP.listPromoCard);

    	java.util.List<WebElement> Amount = homeP.AmountCard;
    	return Amount.size();
    }
    
    public boolean verifyCard() {
    	int cardCount = getAmountCardPromo();
    	return cardCount >= 3;
    }
    
    public void goToPromoNavbar() {
    	waitForElementToBePresent(homeP.close);
    	homeP.close.click();
    	homeP.btnNavbarPromo.click();
    }
    
    public int getBannerPromo() {
    	waitForElementToBePresent(homeP.listBannerPromo);
    	
    	java.util.List<WebElement> Amount = homeP.PagElements;
    	return Amount.size();
    }
    
    public boolean VerifyBannerPromo() {
    	int bannerCount = getBannerPromo();
    	return bannerCount == 5;
    }
    
}