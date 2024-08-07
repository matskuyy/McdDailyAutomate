package locator;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(id="modalAnnouncement")
	public WebElement modalPopUp;
	
	@FindBy(xpath="//*[@id=\"modalAnnouncement\"]/div/div/div[1]/a")
	public WebElement close;
	
	@FindBy(xpath="//i[@class=\"fal fa-times\"]")
	public WebElement closeBtn;
	
	@FindBy(xpath="//li[@data-target='#carouselCoverResponsive']")
	public WebElement listBannerHome;
	
	@FindBy(xpath="//div[@class='card-body']")
	public WebElement listPromoCard;

	@FindBy(xpath="//li[@class='nav-item']//a[@class='nav-link'][normalize-space()='Promo']")
	public WebElement btnNavbarPromo;
	
	@FindBy(xpath= "//li[@data-target=\"#carouselCoverResponsive\"]")
	public WebElement listBannerPromo;
	
	@FindBy(xpath = "//li[@data-target='#carouselCoverResponsive']")
	public List<WebElement> PaginationBanner;

	@FindBy(xpath = "//div[@class='card-body']")
	public List<WebElement> AmountCard;
	
	@FindBy(xpath = "//li[@data-target=\"#carouselCoverResponsive\"]")
	public List<WebElement> PagElements;
	
}