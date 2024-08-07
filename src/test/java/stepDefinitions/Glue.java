package stepDefinitions;

import org.junit.Assert;

import action.HomePageAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.HelperClass;

public class Glue {
	HomePageAction homePA = new HomePageAction();
    @Given("User is on homepage {string}")
    public void user_is_on_homepage(String siteUrl) {
        HelperClass.openPage(siteUrl);
    }
    @When("User verifies banner count in homepage")
    public void user_verifies_banner_count_in_homepage() {
    	int countSize = homePA.getPaginationBanner();
    	System.out.println("Jumlah Banner Home Yand Ditampilkan: " + countSize);
    	
    	boolean isBannerCountValid = homePA.verifyBannerHome();
    	Assert.assertTrue("Jumlah Banner Home Tidak Sesuai",isBannerCountValid );
    }
    @When("User verifies  card count in card promo")
    public void user_verifies_card_count_in_card_promo() {
    	int countSize = homePA.getAmountCardPromo();
    	System.out.println("Jumlah Card Promo Menarik yang Ditampikan: " + countSize);
    	
    	boolean isBannerCountValid = homePA.verifyCard();
    	Assert.assertTrue("Jumlah Card Promo Menarik Tidak Sesuai", isBannerCountValid);
    }
    @When("User enters promo page")
    public void user_enters_promo_page() {
    	homePA.goToPromoNavbar();
    	System.out.println("User Click Menu Promo");
    }
    @When("User verifies banner count in promo page")
    public void user_verifies_banner_count_in_promo_page() {    	
    	int countSize = homePA.getBannerPromo();
    	System.out.println("Jumlah Banner Promo Yang ditemukan: " + countSize);
    	
    	boolean isBannerCountValid = homePA.VerifyBannerPromo();
    	Assert.assertTrue("Jumlah Banner Promo Tidak Sesuai", isBannerCountValid);
    }
    @Then("User successfully verified mcd daily test")
    public void user_successfully_verified_mcd_daily_test() {
    	System.out.println("Selesai");
    }
   
}
