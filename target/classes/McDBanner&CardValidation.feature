Feature: Automation for Mcd

Background: Open Page
   Given User is on homepage "https://mcdonalds.co.id/"
   
   Scenario: Verify Homepage Banner should be 3-5
   	When User verifies banner count in homepage
   	Then User successfully verified mcd daily test
   	
   Scenario: Verify Card Promo should be 3
   	When User verifies  card count in card promo
   	Then User successfully verified mcd daily test
   	
   Scenario: Verify PromoPage Banner should be 5
   	When User enters promo page
   	And User verifies banner count in promo page
  	Then User successfully verified mcd daily test
